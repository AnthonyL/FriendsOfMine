package friendsofmine

class IdentificationController {

	def index(){
		redirect(action:"login")
	}
	
	def login(){
		
	}
	
    def identify() {
		def login = params.login
		def pass = params.mdp
		
		Membre membreCurrent = Membre.find {
			(mail == login && mdp == pass)
		}
		
		if(membreCurrent){
			session["user"] = membreCurrent
			//redirect(controller:"membre", action:"show")
                        redirect(controller:"home", action:"private_home")
		} else {
			render(view:"login", model:[login:login, errorLogin:"identify.login.error"])
		}
		
	}
	
	def logout(){
		session.invalidate()
		redirect(action:"login")
	}
}
