import friendsofmine.Membre

class BootStrap {

    def init = { servletContext ->
		new Membre(nom:"Letourneur", prenom:"Anthony", mail:"let@mail.fr", mdp:"password", naissance:new Date("1988/06/30")).save(failOnError:true)
		new Membre(nom:"Chapeyroux", prenom:"Sébastien", mail:"chaps@mail.fr", mdp:"password", naissance:new Date("1987/10/27")).save(failOnError:true)
    }
    def destroy = {
    }
}
