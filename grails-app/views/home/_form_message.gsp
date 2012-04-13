<%@ page import="friendsofmine.Message" %>



<div class="${hasErrors(bean: messageInstance, field: 'titre', 'error')} required">
	<label for="titre">
		<g:message code="message.titre.label" default="Titre" />
	</label><br/>
	<g:textField class="titre" name="titre" required="" value="${messageInstance?.titre}"/>
</div>
<br/>
<div class="${hasErrors(bean: messageInstance, field: 'text', 'error')} required">
	<label for="text">
		<g:message code="message.text.label" default="Text" />
	</label><br/>
	<g:textArea name="text" required="" value="${messageInstance?.text}" rows="1" cols="1"/>
</div>

