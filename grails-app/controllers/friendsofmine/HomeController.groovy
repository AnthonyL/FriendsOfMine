package friendsofmine

class HomeController {

    def index() { }
    
    def private_home() {
        def membreInstance = session.getAttribute("user");
        if(!membreInstance){
                redirect(controller:"identification", action:"login")
        }
			
		int annee = new Date().getYear();
		int anneeNaissance = membreInstance.naissance.getYear();
        def age = annee - anneeNaissance;
        [membreInstance: membreInstance, age: age, messageInstance: params.messageInstance, messageError: params.messageError]
    }
 
}
