package friendsofmine

class IdentificationController {

	def home(){
		
	}
	
    def identify() {
		def login = params.login
		def pass = params.mdp
		
		Membre membreCurrant = Membre.find {
			(mail == login && mdp == pass)
		}
		
		if(membreCurrant){
			session["user"] = membreCurrant
			redirect(controller:"membre", action:"show")
		} else {
			render(view:"home", model:[login:login, errorLogin:"identify.login.error"])
		}
		
	}
	
	def create() {
		redirect(controller:"membre", action:"create")
	}
}
