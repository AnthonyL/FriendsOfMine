import friendsofmine.Membre

class BootStrap {

    def init = { servletContext ->
		new Membre(nom:"Letourneur", prenom:"Anthony", mail:"let@mail.fr", mdp:"password", naissance:new Date("30/06/1988")).save(failOnError)
		new Membre(nom:"Chapeyroux", prenom:"Sébastien", mail:"chap@mail.fr", mdp:"password", naissance:new Date("10/10/1987")).save(failOnError)
    }
    def destroy = {
    }
}
