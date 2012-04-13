<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main">
        <title><g:message code="home.title" default="Page personnelle" /></title>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'message.css')}" type="text/css">
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="home" controller="membre" action="edit"><g:message code="private_home.button.myAccount.label" default="Mon compte" /></g:link></li>
                <li><g:link class="search" controller="searchable" action="index"><g:message code="private_home.button.search.label" default="Searchable" /></g:link></li>
                <li><g:link class="logout" controller="identification" action="logout"><g:message code="default.button.logout.label" default="Logout" /></g:link></li>
            </ul>
        </div>
    
        <div id="show-membre" class="content scaffold-show" role="main">
            <h1><g:message code="home.titre" /></h1>
      
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            
            <div class="zone_content">
	            <g:if test="${membreInstance?.nom}&&${membreInstance?.prenom}&&${age}">
	                <h2><g:fieldValue bean="${membreInstance}" field="prenom"/> <g:fieldValue bean="${membreInstance}" field="nom"/> (<span class="property-value" aria-labelledby="age">${age} ans</span>)</h2>
	            </g:if>
            </div>
            
            <h1><g:message code="home.message.label" default="Messages"/></h1>
            <div class="zone_content">
            	<g:actionSubmit class="buttons" value="${message(code: 'default.button.addMessage.label', default: 'Add_Message')}"  onClick="show_div('form_message')" />
            	<div class="message_form" name="form_message" style="display:none;">
	            	<g:form controller="message" action="save" >
	            		<div class="form_content" >
							<g:render template="form_message"/>
						</div>
						<fieldset class="buttons">
							<g:link class="cancel" onClick="hidden_div('form_message')" action="private_home" ><g:message code="default.button.cancel.label" default="Cancel" /></g:link>
							<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
						</fieldset>
					</g:form>
				</div>
				<br/>
	            <g:listeMessages membre="${membreInstance}" />
            </div>
        </div>
    </body>
</html>
