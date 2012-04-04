<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="default.home.label" default="Home" /></title>
	</head>
	<body>
			<g:if test="${errorLogin}">
				<ul class="errors" role="alert">
					<li><g:message code="${errorLogin}"/></li>
				</ul>
			</g:if>
			<g:form controller="Identification" action="identify" >
				<fieldset class="form">
					<div class="fieldcontain">
						<label for="login">
							<g:message code="identify.login.label" default="Login" />
						</label>
						<g:textField name="login" value="${login}"/>
					</div>
					
					<div class="fieldcontain">
						<label for="mdp">
							<g:message code="identify.mdp.label" default="Mdp" />
						</label>
						<g:field type="password" name="mdp"/>
						<g:submitButton name="identify" class="identify" value="${message(code: 'default.button.identify.label', default: 'Identify')}" />
					</div>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="create" action="create" value="${message(code: 'default.button.create_compte.label', default: 'Membre_create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
