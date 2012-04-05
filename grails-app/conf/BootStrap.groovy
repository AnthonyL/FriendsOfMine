import friendsofmine.Membre

class BootStrap {

    def init = { servletContext ->
                
            new Membre(nom: "chapeyroux", prenom: "sébastien", mail: "chaps@mail.com", naissance: new Date("1987/12/27"), mdp:"password").save(failOnError:true)
            new Membre(nom: "letourneur", prenom: "anthony", mail: "let@mail.com", naissance: new Date("1988/06/30"), mdp:"password").save(failOnError:true)
    }
    def destroy = {
    }
}
