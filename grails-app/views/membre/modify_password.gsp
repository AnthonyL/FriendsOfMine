<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main">
            <g:set var="entityName" value="${message(code: 'membre.label', default: 'Membre')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/private_home')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="compte" controller="membre" action="edit"><g:message code="private_home.button.myAccount.label" default="Mon compte" /></g:link></li>
                <li><g:link class="search" controller="searchable" action="index"><g:message code="private_home.button.search.label" default="Searchable" /></g:link></li>
                <li><g:link class="logout" controller="identification" action="logout"><g:message code="default.button.logout.label" default="Logout" /></g:link></li>
            </ul>
        </div>
        <div id="editPassword-membre" class="content scaffold-edit" role="main">
            <h1><g:message code="membre.modifyPassword.label" /></h1>
            <g:if test="${errorPassword}">
                <ul class="errors" role="alert">
                    <li><g:message code="${errorPassword}"/></li>
                </ul>
            </g:if>
            <g:hasErrors bean="${membreInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${membreInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
	    </g:hasErrors>
            <g:form action="modify_password">
                  <fieldset class="form">
                      <div class="fieldcontain" required>
                          <label for="oldPassword">
                              <g:message code="membre.oldPassword.label" default="Old password" />
                          </label>
                          <g:field type="password" name="oldPassword" required="" value="" />
                      </div>

                      <div class="fieldcontain" required>
                          <label for="newPasword">
                              <g:message code="membre.newPassword.label" default="New password" />
                          </label>
                          <g:field type="password" name="newPassword" required="" value="" />
                      </div>
                    
                      <div class="fieldcontain" required>
                          <label for="confirmNewPasword">
                              <g:message code="membre.confirmNewPassword.label" default="Confirm new password" />
                          </label>
                          <g:field type="password" name="confirmNewPassword" required="" value=""  />
                      </div>
                  </fieldset>
                  <fieldset class="buttons">
                      <g:link class="back" action="edit">${message(code: 'default.button.back.label', default: 'Back')}</g:link>
                  <g:actionSubmit class="save" action="save_new_password" value="${message(code: 'default.button.save_new_password.label', default: 'Save new password')}" />
                  </fieldset>
            </g:form>
        </div>
    </body>
</html>
