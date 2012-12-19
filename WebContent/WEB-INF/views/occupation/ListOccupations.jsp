<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<pr:Layout>
	<div class="hero-unit">
		<h3>
			<spring:message code="occupation.plural" />
		</h3>
	</div>
	<div id="hor-minimalist-b">
		<table>
			<tr>
				<th><h4><spring:message code="entity.field.id" /></h4></th>
				<th><h4><spring:message code="occupation.field.iscoCode" /></h4></th>
				<th><h4><spring:message code="occupation.field.name" /></h4></th>
			</tr>
			<c:forEach items="${occupations}" var="occupation">
				<tr>
					<td>${occupation.id}</td>
					<td>${occupation.iscoCode}</td>
					<td>${occupation.name}</td>
					<td>
						<sec:authorize access="hasAnyRole('ROLE_MODERATOR, ROLE_ADMIN')">
							<a href="<c:url value="/occupation/update?id=${occupation.id}" ></c:url>">
								<spring:message code="entity.button.update" />
							</a>
						</sec:authorize>
					</td>
					<td>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a href="<c:url value="/occupation/delete?id=${occupation.id}"/>">
								<spring:message code="entity.button.delete" />
							</a>
						</sec:authorize>
					</td>
				</tr>
			</c:forEach>
		</table>
		<sec:authorize access="hasAnyRole('ROLE_MODERATOR, ROLE_ADMIN')">
			<a class="btn btn-inverse" href="<c:url value="/occupation/add"/>"><spring:message code="entity.add.new" /></a>
		</sec:authorize>
	</div>
</pr:Layout>