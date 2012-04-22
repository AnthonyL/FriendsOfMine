package friendsofmine

import org.springframework.dao.DataIntegrityViolationException

class MessageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def save() {
		def membreInstance = session.getAttribute("user");
		if(!membreInstance){
			redirect(controller:"identification", action:"login")
		}
		
		Membre m = Membre.findById(membreInstance.id)
		Message messageInstance = new Message(titre: params.titre, text: params.text, dateRedaction: new Date(), redacteur: m)
		messageInstance.save(flush: true)
		
		redirect(controller: "home", action: "private_home")
	}
}
