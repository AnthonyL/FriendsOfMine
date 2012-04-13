package friendsofmine

class MessageTagLib {
	
	def listeMessages = {attrs ->	
		def listeMessage = Message.findAllByRedacteur(attrs.membre)
		for(Message currant : listeMessage.reverse()){
			out << "<div class='message_membre'><span class='date'>"+currant.dateRedaction.format("dd MMM yyyy / HH:mm")+"</span><br/><h2>"+currant.titre+"</h2>"+"<p>"+currant.text+"</p></div>"
		}
	}

}
