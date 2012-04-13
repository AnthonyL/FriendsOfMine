<%@ page import="friendsofmine.Membre" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'membre.label', default: 'Membre')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

		<div id="create-membre" class="content scaffold-create" role="main">
			<h1><g:message code="membre.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${membreInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${membreInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:if test="${errorConfirm}">
			<ul class="errors" role="alert">
				<li><g:message code="${errorConfirm}"/></li>
			</ul>
			</g:if>
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="form_create"/>
				</fieldset>
				<fieldset class="buttons">
					<g:link class="back" controller="identification" action="login">${message(code: 'default.button.back.label', default: 'Back')}</g:link>
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
