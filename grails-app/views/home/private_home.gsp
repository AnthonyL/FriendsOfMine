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
                <li><g:link class="logout" controller="identification" action="logout"><g:message code="default.button.logout.label" default="Logout" /></g:link></li>
            </ul>
        </div>
    
        <div id="show-membre" class="content scaffold-show" role="main">
            <h1><g:message code="private_home.button.myAccount.label" args="[entityName]" /></h1>
      
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            
            <g:if test="${membreInstance?.nom}&&${membreInstance?.prenom}">
                <span class="property-value" aria-labelledby="name-label"><h2><g:fieldValue bean="${membreInstance}" field="prenom"/> <g:fieldValue bean="${membreInstance}" field="nom"/></h2></span>
            </g:if>
            
            <br/>
            <g:if test="${age}">
                <span class="property-value" aria-labelledby="age">${age} ans</span>
            </g:if>
        </div>
    </body>
</html>
