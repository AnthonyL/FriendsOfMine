package friendsofmine

import org.springframework.dao.DataIntegrityViolationException

class MembreController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [membreInstanceList: Membre.list(params), membreInstanceTotal: Membre.count()]
    }

    def create() {
        [membreInstance: new Membre(params)]
    }

    def save() {
        def membreInstance = new Membre(params)
		if(params.mdp.equals(params.mdp_confirm)){
	        if (!membreInstance.save(flush: true)) {
	            render(view: "create", model: [membreInstance: membreInstance])
	            return
	        }
		} else {
			render(view: "create", model: [membreInstance: membreInstance, errorConfirm: "error.confirmation_mdp"])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'membre.label', default: 'Membre'), membreInstance.id])
        redirect(action: "sucess")
    }
	
	def sucess() {
		
	}

    def show() {
        def membreInstance = Membre.get(params.id)
        if (!membreInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'membre.label', default: 'Membre'), params.id])
            redirect(action: "list")
            return
        }

        [membreInstance: membreInstance]
    }

    def edit() {
        def membreInstance = Membre.get(params.id)
        if (!membreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'membre.label', default: 'Membre'), params.id])
            redirect(action: "list")
            return
        }

        [membreInstance: membreInstance]
    }

    def update() {
        def membreInstance = Membre.get(params.id)
        if (!membreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'membre.label', default: 'Membre'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (membreInstance.version > version) {
                membreInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'membre.label', default: 'Membre')] as Object[],
                          "Another user has updated this Membre while you were editing")
                render(view: "edit", model: [membreInstance: membreInstance])
                return
            }
        }

        membreInstance.properties = params

        if (!membreInstance.save(flush: true)) {
            render(view: "edit", model: [membreInstance: membreInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'membre.label', default: 'Membre'), membreInstance.id])
        redirect(action: "show", id: membreInstance.id)
    }

    def delete() {
        def membreInstance = Membre.get(params.id)
        if (!membreInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'membre.label', default: 'Membre'), params.id])
            redirect(action: "list")
            return
        }

        try {
            membreInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'membre.label', default: 'Membre'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'membre.label', default: 'Membre'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
