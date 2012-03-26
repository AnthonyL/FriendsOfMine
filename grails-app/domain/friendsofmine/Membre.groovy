package friendsofmine

class Membre {
	
	String nom
	String prenom
	String mail
	Date naissance
	String mdp
	

    static constraints = {
		nom  blank:false
		prenom blank:false
		mail email:true, blank:false
		mdp password:true, blank:false
		naissance blank:true
    }
}
