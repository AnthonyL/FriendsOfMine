<%@ page import="friendsofmine.Membre" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'membre.label', default: 'Membre')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="edit-membre" class="content scaffold-edit" role="main">
			<h1><g:message code="membre.edit.label" /></h1>
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
			<g:form method="post" >
				<g:hiddenField name="id" value="${membreInstance?.id}" />
				<g:hiddenField name="version" value="${membreInstance?.version}" />
				<fieldset class="form">
					<g:render template="form_edit"/>
				</fieldset>
				<fieldset class="buttons">
					<g:link class="back" controller="home" action="private_home">${message(code: 'default.button.back.label', default: 'Back')}</g:link>
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'membre.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
