<%@ page import="org.springframework.util.ClassUtils" %>
<%@ page import="grails.plugin.searchable.internal.lucene.LuceneUtils" %>
<%@ page import="grails.plugin.searchable.internal.util.StringQueryUtils" %>
<%@ page import="friendsofmine.Membre" %>

<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="default.searchable.label" default="Searchable" /></title>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'search.css')}" type="text/css">

    <script type="text/javascript">
        var focusQueryInput = function() {
            document.getElementById("q").focus();
        }
    </script>
  </head>
  <body onload="focusQueryInput();">
  		<a href="#show-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
            <ul>
            	<li><a class="home" href="${createLink(uri: '/home/private_home')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="compte" controller="membre" action="edit"><g:message code="private_home.button.myAccount.label" default="Mon compte" /></g:link></li>
                <li><g:link class="search" controller="searchable" action="index"><g:message code="private_home.button.search.label" default="Searchable" /></g:link></li>
                <li><g:link class="logout" controller="identification" action="logout"><g:message code="default.button.logout.label" default="Logout" /></g:link></li>
            </ul>
        </div>
  <div class="zone_content">
  <div id="header">
    <h1><g:message code="search.titre" default="Searchable" /></h1>
    <g:form url='[controller: "searchable", action: "index"]' id="searchableForm" name="searchableForm" method="get">
        <g:textField name="q" value="${params.q}" size="50"/> <input type="submit" value="${message(code:'default.button.search.label', default:'Search') }" />
    </g:form>
    <div style="clear: both; display: none;" class="hint">See <a href="http://lucene.apache.org/java/docs/queryparsersyntax.html">Lucene query syntax</a> for advanced queries</div>
  </div>
  <div id="main">
    <g:set var="haveQuery" value="${params.q?.trim()}" />
    <g:set var="haveResults" value="${searchResult?.results}" />
    <div class="title">
      <span>
        <g:if test="${haveQuery && haveResults}">
        	<g:set var="arg1" value="${searchResult.offset + 1}" />
        	<g:set var="arg2" value="${searchResult.results.size() + searchResult.offset}" />
        	<g:set var="arg3" value="${searchResult.total}" />
        	<g:set var="arg4" value="${params.q}" />
          	<g:message code="search.result.message" args="[arg1, arg2, arg3, arg4]" />
        </g:if>
        <g:else>
        &nbsp;
        </g:else>
      </span>
    </div>
    
    <g:if test="${haveQuery && !haveResults && !parseException}">
      <g:set var="arg1" value="${params.q}" />
      <g:message code="search.noresult.message" args="[arg1]" />
    </g:if>

    <g:if test="${parseException}">
    	<g:set var="arg1" value="${params.q}" />
      	<g:message code="search.invalidresult.message" args="[arg1]" />
    </g:if>

    <g:if test="${haveResults}">
      <div class="results">
        <g:each var="result" in="${searchResult.results}" status="index">
          <div class="result">
            <g:set var="memberName" value="${result.nom}" />
            <g:set var="memberPrenom" value="${result.prenom}" />
            <div class="name">
            	${memberPrenom} ${memberName}
            	<g:link controller="invitation" action="invite"><g:message code="default.button.invite.label" default="Invite" /></g:link>
            </div>
          </div>
        </g:each>
      </div>

      <div>
        <div class="paging">
          <g:if test="${haveResults}">
              Page:
              <g:set var="totalPages" value="${Math.ceil(searchResult.total / searchResult.max)}" />
              <g:if test="${totalPages == 1}"><span class="currentStep">1</span></g:if>
              <g:else><g:paginate controller="searchable" action="index" params="[q: params.q]" total="${searchResult.total}" prev="&lt; previous" next="next &gt;"/></g:else>
          </g:if>
        </div>
      </div>
    </g:if>
  </div>
  </div>
  </body>
</html>
