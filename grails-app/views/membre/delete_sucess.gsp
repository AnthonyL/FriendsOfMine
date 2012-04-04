<%@ page import="friendsofmine.Membre" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="membre.delete_sucess.label" default="Delete_sucess" /></title>
	</head>
	<body>
		<a href="#delete-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="delete-membre_sucess" class="content scaffold-create" role="main">
			<h1><g:message code="membre.delete_sucess.label" default="Delete_sucess" /></h1>
			<div>
				<g:message code="membre.message.delete_sucess" default="Compte supprimer." /><br/>
				<g:link controller="identification" action="login"><g:message code="identify.link.label" default="identification/login" /></g:link>
			</div>
		</div>
	</body>
</html>