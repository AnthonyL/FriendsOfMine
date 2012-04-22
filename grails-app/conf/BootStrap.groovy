import friendsofmine.Membre
import friendsofmine.Message

class BootStrap {

    def init = { servletContext ->   
            Membre seb = new Membre(nom: "Chapeyroux", prenom: "Sébastien", mail: "chaps@mail.com", naissance: new Date("1987/12/27"), mdp:"password").save(failOnError:true)
			Membre sebL = new Membre(nom: "Lacroix", prenom: "Sébastien", mail: "lac@mail.com", naissance: new Date("1987/12/27"), mdp:"password").save(failOnError:true)
			Membre sebD = new Membre(nom: "Dupond", prenom: "Sébastien", mail: "dup@mail.com", naissance: new Date("1987/12/27"), mdp:"password").save(failOnError:true)
            Membre ant = new Membre(nom: "Letourneur", prenom: "Anthony", mail: "let@mail.com", naissance: new Date("1988/06/30"), mdp:"password").save(failOnError:true)
			Membre jack = new Membre(nom: "Dupond", prenom: "jack", mail: "jack@mail.com", naissance: new Date("1988/06/30"), mdp:"password").save(failOnError:true)
			
			Message m1 = new Message(titre: "Ma vie est génial !!!", text: "A midi, j'ai mangé de la tartiflette", dateRedaction: new Date("2012/04/20"), redacteur: seb).save(failOnError:true)
			Message m2 = new Message(titre: "Démonstration de JEE", text: "Attention à l'effet Bonaldi.", dateRedaction: new Date(), redacteur: seb).save(failOnError:true)	
    }
    def destroy = {
    }
}
