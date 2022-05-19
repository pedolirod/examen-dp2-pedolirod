<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>


<jstl:choose>

	<jstl:when test="${isNew}">
		
		<acme:form>
			<acme:input-textbox code="any.artifact.form.label.name" path="name"/>	
			<acme:input-textbox code="any.artifact.form.label.code" path="code"/>	
			<acme:input-textbox code="any.artifact.form.label.technology" path="technology"/>
			<acme:input-textarea code="any.artifact.form.label.description" path="description"/>
			<acme:input-money code="any.artifact.form.label.retail-price" path="retailPrice"/>
			<acme:input-url code="any.artifact.form.label.link" path="link"/>
			
			<acme:submit code="any.tool.form.button.create" action="/inventor/artifact/create-tool"/>
		</acme:form>
		
	</jstl:when>
	
	<jstl:otherwise>
	
		<acme:form>
			<acme:input-textbox code="any.artifact.form.label.name" path="name"/>	
			<acme:input-textbox code="any.artifact.form.label.code" path="code"/>	
			<acme:input-textbox code="any.artifact.form.label.technology" path="technology"/>
			<acme:input-textarea code="any.artifact.form.label.description" path="description"/>
			<acme:input-money code="any.artifact.form.label.retail-price" path="retailPrice"/>
			<acme:input-url code="any.artifact.form.label.link" path="link"/>
			
			<acme:submit code="any.tool.form.button.update" action="/inventor/artifact/update"/>
		</acme:form>
		
		
	</jstl:otherwise>

</jstl:choose>

