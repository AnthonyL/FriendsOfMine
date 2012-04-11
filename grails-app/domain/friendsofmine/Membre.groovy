package friendsofmine

class Membre {
	
	static searchable = true
	String nom
	String prenom
	String mail
	Date naissance
	String mdp
	

    static constraints = {
		nom (blank:false)
		prenom (blank:false)
		mail (email:true, blank:false)
		mdp (password:true, blank:false, size:5..15)
		naissance (blank:true, validator:{val -> return (val.getYear()+15 < new Date().getYear())})
    }
}
