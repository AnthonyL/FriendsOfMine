<%@ page import="friendsofmine.Membre" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="membre.create_sucess.label" default="Create_sucess" /></title>
	</head>
	<body>
		<a href="#create-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="create-membre_sucess" class="content scaffold-create" role="main">
			<h1><g:message code="membre.create_sucess.label" default="Create_sucess" /></h1>
			<div>
				<g:message code="membre.message.sucess" default="Compte créer." />
				<g:link controller="identification" action="home"><g:message code="identify.link.label" default="identification/home" /></g:link>
			</div>
		</div>
	</body>
</html>