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
		
		Membre membreCurrant = Membre.find {
			(mail == login && mdp == pass)
		}
		
		if(membreCurrant){
			session["user"] = membreCurrant
			redirect(controller:"membre", action:"show")
		} else {
			render(view:"login", model:[login:login, errorLogin:"identify.login.error"])
		}
		
	}
	
	def logout(){
		session.invalidate()
		redirect(action:"login")
	}
	
	def create() {
		redirect(controller:"membre", action:"create")
	}
}
