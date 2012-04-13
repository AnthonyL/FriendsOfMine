package friendsofmine

class Message {
	
	String titre
	String text
	static belongsTo = Membre

    static constraints = {
		titre (blank:false)
		text (blank:false)
    }
}
