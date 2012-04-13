import friendsofmine.Membre
import friendsofmine.Message

class BootStrap {

    def init = { servletContext ->   
            Membre seb = new Membre(nom: "Chapeyroux", prenom: "Sébastien", mail: "chaps@mail.com", naissance: new Date("1987/12/27"), mdp:"password").save(failOnError:true)
            Membre let = new Membre(nom: "Letourneur", prenom: "Anthony", mail: "let@mail.com", naissance: new Date("1988/06/30"), mdp:"password").save(failOnError:true)
			
			Message m1 = new Message(titre: "Mon message 1", text: "J'ai mangé des pates", dateRedaction: new Date(), redacteur: let).save(failOnError:true)
			Message m2 = new Message(titre: "Mon message 2", text: "J'ai mangé de la tartiflette", dateRedaction: new Date(), redacteur: let).save(failOnError:true)
			//let.addToMessages(m1)
			
    }
    def destroy = {
    }
}
