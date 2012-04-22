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

		flash.message = message(code: 'membre.updated.message')
        redirect(action: "edit")
    }
    
    def modify_password() {
            def membreInstance = session.getAttribute("user");
            if(!membreInstance){
                        redirect(controller:"identification", action:"login")
            }

            [membreInstance: membreInstance]
    }        
    
    def save_new_password() {
            def membreInstance = session.getAttribute("user");
            def oldMdp = params.oldPassword
            def newMdp = params.newPassword
            def confirmNewMdp = params.confirmNewPassword
            
            def mdp = membreInstance.mdp
            if (oldMdp == mdp)
            { //L'ancien mot de passe tapé est correct
                if (oldMdp != newMdp)
                { //Le nouveau mot de passe est différent de l'ancien
                            
                        if (confirmNewMdp == newMdp) 
                        { //Le nouveau mot de passe a bien été confirmé
                                    Membre m = Membre.findById(membreInstance.id)
                                    m.setMdp(newMdp)
                                    
                                    if(!m.save(flush:true)){
                                        render(view:"modify_password", model:[membreInstance: m])
                                        return
                                    }
                                    membreInstance.setMdp(newMdp)
									flash.message = message(code: 'membre.savePassword.message')
                                    redirect(controller:"membre", action:"edit")
                        }
                        else { //Erreur : le nouveau mot de passe n'a pas été confirmé
                                    render(view:"modify_password", model:[errorPassword:"membre.password.errorConfirmPassword"])
                        }
                }    
                else { //Erreur : le nouveau mot de passe doit etre différent de l'ancien
                            render(view:"modify_password", model:[errorPassword:"membre.password.errorNewPassword"])
                }
            }
            else { //Erreur : l'ancien mot de passe tapé est incorrect
                 render(view:"modify_password", model:[errorPassword:"membre.password.errorOldPassword"])       
            }
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
}
