<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.hustle.form.label.theme" path="theme" />
	<acme:input-textbox code="inventor.hustle.form.label.code" path="code"  />
	<jstl:if test="${isNew == false}">
	<acme:input-moment code="inventor.hustle.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:input-textarea code="inventor.hustle.form.label.summary" path="summary" />
	<acme:input-moment code="inventor.hustle.form.label.period" path="period" />
	<acme:input-money code="inventor.hustle.form.label.share" path="share" />
	<acme:input-url code="inventor.hustle.form.label.furtherInfo" path="furtherInfo" />
	<acme:input-select code="inventor.hustle.form.label.artifact" path="artifactId">
	<jstl:forEach items="${artifact}" var="artifact">
			<acme:input-option code="${artifact.code}" value="${artifact.getId()}" selected="${artifact.getId() == artifactId}"/>
	</jstl:forEach>
	</acme:input-select>
	<jstl:choose>
		<jstl:when test="${isNew == true}">
			<acme:submit code="inventor.hustle.form.label.create" action="/inventor/hustle/create" />
		</jstl:when>
		<jstl:otherwise>
				<acme:submit code="inventor.hustle.form.label.update"
					action="/inventor/hustle/update" />
				<acme:submit code="inventor.hustle.form.label.delete"
					action="/inventor/hustle/delete" />
		</jstl:otherwise>
	</jstl:choose>
</acme:form>
