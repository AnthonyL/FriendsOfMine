import friendsofmine.Membre

class BootStrap {

    def init = { servletContext ->   
            new Membre(nom: "Chapeyroux", prenom: "Sébastien", mail: "chaps@mail.com", naissance: new Date("1987/12/27"), mdp:"password").save(failOnError:true)
            new Membre(nom: "Letourneur", prenom: "Anthony", mail: "let@mail.com", naissance: new Date("1988/06/30"), mdp:"password").save(failOnError:true)
    }
    def destroy = {
    }
}
