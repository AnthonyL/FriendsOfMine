package friendsofmine

import org.springframework.dao.DataIntegrityViolationException

class MembreController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]


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
			render(view: "create", model: [membreInstance: membreInstance, errorConfirm: "membre.confirmation_mdp.error"])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'membre.label', default: 'Membre'), membreInstance.id])
        redirect(action: "create_sucess")
    }
	
	def create_sucess() {

	}

    def show() {
		def membreInstance = session.getAttribute("user");
		if(!membreInstance){
			redirect(controller:"identification", action:"login")
		}

        [membreInstance: membreInstance]
    }

    def edit() {
		def membreInstance = session.getAttribute("user");
		if(!membreInstance){
			redirect(controller:"identification", action:"login")
		}

        [membreInstance: membreInstance]
    }

    def update() {
        def membreInstance = session.getAttribute("user");
		if(!membreInstance){
			redirect(controller:"identification", action:"login")
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
        def membreInstance = session.getAttribute("user");
		if(!membreInstance){
			redirect(controller:"identification", action:"login")
		}

        try {
            membreInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'membre.label', default: 'Membre'), params.id])
            redirect(action: "delete_sucess")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'membre.label', default: 'Membre'), params.id])
            redirect(action: "show")
        }
    }
	
	def delete_sucess(){
		session.invalidate()
	}
	
	/*Inutilise pour le moment
	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[membreInstanceList: Membre.list(params), membreInstanceTotal: Membre.count()]
	}*/
}
