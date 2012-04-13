<%@ page import="friendsofmine.Message" %>



<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'titre', 'error')} required">
	<label for="titre">
		<g:message code="message.titre.label" default="Titre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titre" required="" value="${messageInstance?.titre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'text', 'error')} required">
	<label for="text">
		<g:message code="message.text.label" default="Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="text" required="" value="${messageInstance?.text}"/>
</div>

