<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<pr:Layout>
	<div class="hero-unit">
		<h3>
			<spring:message code="guard.plural" />
		</h3>
	</div>
	<div id="hor-minimalist-b">
		<table>
			<tr>
				<th><h4><spring:message code="entity.field.id" /></h4></th>
				<th><h4><spring:message code="guard.field.socialSecurityNumber" /></h4></th>
				<th><h4><spring:message code="guard.field.soldiersCode" /></h4></th>
				<th><h4><spring:message code="guard.field.firstName" /></h4></th>
				<th><h4><spring:message code="guard.field.lastName" /></h4></th>
			</tr>
			<c:forEach items="${guards}" var="guard">
				<tr>
					<td>${guard.id}</td>
					<td>${guard.socialSecurityNumber}</td>
					<td>${guard.soldiersCode}</td>
					<td>${guard.firstName}</td>
					<td>${guard.lastName}</td>
					<td>
						<sec:authorize access="hasAnyRole('ROLE_MODERATOR, ROLE_ADMIN')">
							<a href="<c:url value="/guard/update?id=${guard.id}" ></c:url>">
								<spring:message code="entity.button.update" />
							</a>
						</sec:authorize>
					</td>
					<td>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a href="<c:url value="/guard/delete?id=${guard.id}"/>">
								<spring:message code="entity.button.delete" />
							</a>
						</sec:authorize>
					</td>
				</tr>
			</c:forEach>
		</table>
			<sec:authorize access="hasAnyRole('ROLE_MODERATOR, ROLE_ADMIN')">
				<a class="btn btn-inverse" href="<c:url value="/guard/add"/>"><spring:message code="entity.add.new" /></a>
			</sec:authorize>
	</div>
</pr:Layout>