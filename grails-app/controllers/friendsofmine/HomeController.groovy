package friendsofmine

class HomeController {

    def index() { }
    
    def private_home() {
        def membreInstance = session.getAttribute("user");
            if(!membreInstance){
                    redirect(controller:"identification", action:"login")
            }
        def age = 25 //(new Date() - membreInstance.naissance).getYear()
        [membreInstance: membreInstance, age: age]
    }
 
}
