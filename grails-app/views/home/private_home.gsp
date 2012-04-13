<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main">
        <title><g:message code="home.title" default="Page personnelle" /></title>
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
            	<g:link controller="message" action="add"><g:message code="private_home.button.add.label" default="Add_Message" /></g:link></br>
            	<!-- <g:if test="${addMessage}">
            		<g:form controller="message" action="save" >
						<fieldset class="form">
							<g:render template="form"/>
						</fieldset>
						<fieldset class="buttons">
							<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
						</fieldset>
					</g:form>
            	</g:if>
            	<g:if test="${membreInstance?.messages.size() != 0}">
            		
            	</g:if> -->
            	#Zone de messages#
            </div>
        </div>
    </body>
</html>
