<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<h1>
	<acme:message code="administrator.dashboard.form.title.admin-dashboard" />
</h1>

<h2>
	<acme:message code="administrator.dashboard.form.title.components" />
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row"><acme:message
				code="administrator.dashboard.form.label.total-number-of-components" />
		</th>
		<td><acme:print value="${adminDashboard.totalNumberOfComponents}" />
		</td>
	</tr>
</table>

<h3>
	<acme:message code="administrator.dashboard.form.title.technologies" />
</h3>
<table class="table table-sm">
	<jstl:forEach var="entry" items="${adminDashboard.avgPrize.entrySet()}">
		<tr>
			<th scope="row"><acme:message
					code="administrator.dashboard.form.label.average-prize-for" /> <acme:print
					value="${entry.key.first}" /> <acme:message
					code="administrator.dashboard.form.label.in" /> <acme:print
					value="${entry.key.second}" /></th>
			<td><acme:print value="${entry.value}" /> <acme:print
					value="${entry.key.second}" /></td>
		</tr>
	</jstl:forEach>
	<jstl:forEach var="entry" items="${adminDashboard.deviationPrize.entrySet()}">
		<tr>
			<th scope="row"><acme:message
					code="administrator.dashboard.form.label.deviation-prize-for" /> <acme:print
					value="${entry.key.first}" /> <acme:message
					code="administrator.dashboard.form.label.in" /> <acme:print
					value="${entry.key.second}" /></th>
			<td><acme:print value="${entry.value}" /> <acme:print
					value="${entry.key.second}" /></td>
		</tr>
	</jstl:forEach>
	<jstl:forEach var="entry" items="${adminDashboard.maxPrize.entrySet()}">
		<tr>
			<th scope="row"><acme:message
					code="administrator.dashboard.form.label.max-prize-for" /> <acme:print
					value="${entry.key.first}" /> <acme:message
					code="administrator.dashboard.form.label.in" /> <acme:print
					value="${entry.key.second}" /></th>
			<td><acme:print value="${entry.value}" /> <acme:print
					value="${entry.key.second}" /></td>
		</tr>
	</jstl:forEach>
	<jstl:forEach var="entry" items="${adminDashboard.minPrize.entrySet()}">
		<tr>
			<th scope="row"><acme:message
					code="administrator.dashboard.form.label.min-prize-for" /> <acme:print
					value="${entry.key.first}" /> <acme:message
					code="administrator.dashboard.form.label.in" /> <acme:print
					value="${entry.key.second}" /></th>
			<td><acme:print value="${entry.value}" /> <acme:print
					value="${entry.key.second}" /></td>
		</tr>
	</jstl:forEach>
</table>

<h2>
	<acme:message code="administrator.dashboard.form.title.tools" />
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row"><acme:message
				code="administrator.dashboard.form.label.total-number-of-tools" />
		</th>
		<td><acme:print value="${adminDashboard.totalNumberOfTools}" />
		</td>
	</tr>
</table>

<h3>
	<acme:message code="administrator.dashboard.form.title.currencies" />
</h3>

<table class="table table-sm">
	<jstl:forEach var="entry" items="${adminDashboard.avgTools.entrySet()}">
		<tr>
			<th scope="row"><acme:message
					code="administrator.dashboard.form.label.average-prize-in" /> <acme:print
					value="${entry.key}" />
			</th>
			<td><acme:print value="${entry.value}" /> <acme:print
					value="${entry.key}" /></td>
		</tr>
	</jstl:forEach>
	<jstl:forEach var="entry" items="${adminDashboard.deviationTools.entrySet()}">
		<tr>
			<th scope="row"><acme:message
					code="administrator.dashboard.form.label.deviation-prize-in" /> <acme:print
					value="${entry.key}" />
			</th>
			<td><acme:print value="${entry.value}" /> <acme:print
					value="${entry.key}" /></td>
		</tr>
	</jstl:forEach>
	<jstl:forEach var="entry" items="${adminDashboard.maxTools.entrySet()}">
		<tr>
			<th scope="row"><acme:message
					code="administrator.dashboard.form.label.max-prize-in" /> <acme:print
					value="${entry.key}" />
			</th>
			<td><acme:print value="${entry.value}" /> <acme:print
					value="${entry.key}" /></td>
		</tr>
	</jstl:forEach>
	<jstl:forEach var="entry" items="${adminDashboard.minTools.entrySet()}">
		<tr>
			<th scope="row"><acme:message
					code="administrator.dashboard.form.label.min-prize-in" /> <acme:print
					value="${entry.key}" />
			</th>
			<td><acme:print value="${entry.value}" /> <acme:print
					value="${entry.key}" /></td>
		</tr>
	</jstl:forEach>
</table>