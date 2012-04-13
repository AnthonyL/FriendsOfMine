package friendsofmine

class Message {
	
	String titre
	String text
	Date dateRedaction
	Membre redacteur
	static belongsTo = Membre

    static constraints = {
		titre (blank:false)
		text (blank:false)
		dateRedaction (blank:false)
		redacteur (blank:false)
    }
}
