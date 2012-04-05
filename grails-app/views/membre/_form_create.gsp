<%@ page import="friendsofmine.Membre" %>


<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'prenom', 'error')} required">
	<label for="prenom">
		<g:message code="membre.prenom.label" default="Prenom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="prenom" required="" value="${membreInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="membre.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${membreInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'mail', 'error')} required">
	<label for="mail">
		<g:message code="membre.mail.label" default="Mail" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="mail" required="" value="${membreInstance?.mail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'mdp', 'error')} required">
	<label for="mdp">
		<g:message code="membre.mdp.label" default="Mdp" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="mdp" required="" value="${membreInstance?.mdp}"/>
</div>

<div class="fieldcontain required">
	<label for="mdp_confirm">
		<g:message code="membre.mdp_confirm.label" default="Mdp_confirm" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="mdp_confirm" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'naissance', 'error')} required">
	<label for="naissance">
		<g:message code="membre.naissance.label" default="Naissance" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="naissance" precision="day"  value="${membreInstance?.naissance}"  />
</div>

