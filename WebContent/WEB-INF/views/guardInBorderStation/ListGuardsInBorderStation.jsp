<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<pr:Layout>
	<div class="hero-unit">
		<h3>
			<spring:message code="guardInBorderStation.plural" />
		</h3>
	</div>
		<div>
			<table class="viewpanel">
				<tr>
					<th><h4><spring:message code="entity.field.id" /></h4></th>
					<th><h4><spring:message code="guardInBorderStation.field.guard" /></h4></th>
					<th><h4><spring:message code="guardInBorderStation.field.borderStation" /></h4></th>
				</tr>
				<c:forEach items="${guardInBorderStation}" var="guardInBorderStation">
					<tr>
						<td>${guardInBorderStation.id}</td>
						<td>
							${guardInBorderStation.guard.firstName}
							<c:out value=" " />
							${guardInBorderStation.guard.lastName}
						</td>
						<td>${guardInBorderStation.borderStation.name}</td>
						<td class="viewpanel">
							<sec:authorize access="hasAnyRole('ROLE_MODERATOR, ROLE_ADMIN')">
								<a href="<c:url value="/guardInBorderStation/update?id=${guardInBorderStation.id}" ></c:url>">
									<spring:message code="entity.button.update" />
								</a>
							</sec:authorize>
						</td>
						<td class="viewpanel">
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<a href="<c:url value="/guardInBorderStation/delete?id=${guardInBorderStation.id}"/>">
									<spring:message code="entity.button.delete" />
								</a>
							</sec:authorize>
						</td>
					</tr>
				</c:forEach>
			</table>
			<sec:authorize access="hasAnyRole('ROLE_MODERATOR, ROLE_ADMIN')">
				<a class="btn btn-inverse" href="<c:url value="/guardInBorderStation/add"/>"><spring:message code="entity.add.new" /></a>
			</sec:authorize>
		</div>
</pr:Layout>