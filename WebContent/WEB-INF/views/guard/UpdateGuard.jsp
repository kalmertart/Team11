<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<pr:Layout>
	<div class="hero-unit">
		<h3>
			<spring:message code="guard.update.heading"/>
		</h3>
	</div>
	<div id="formdiv">
		<form:form action="update" method="POST" modelAttribute="guard">
			<c:if test="${errors}">
				<div id="errorspanel">
					<table>
						<tr>
							<td><form:errors path="soldiersCode" /></td>
						</tr>
						<tr>
							<td><form:errors path="socialSecurityNumber" /></td>
						</tr>
						<tr>
							<td><form:errors path="firstName" /></td>
						</tr>
						<tr>
							<td><form:errors path="lastName" /></td>
						</tr>
						<tr>
							<td><form:errors path="gender" /></td>
						</tr>
						<tr>
							<td><form:errors path="email" /></td>
						</tr>
						<tr>
							<td><form:errors path="phoneNumber" /></td>
						</tr>
						<tr>
							<td><form:errors path="address" /></td>
						</tr>
						<tr>
							<td><form:errors path="comment" /></td>
						</tr>
					</table>
				</div>
			</c:if>
			<form:hidden path="id" />
			<div>
				<div id="leftpanel">
					<table>
						<tr>
							<td><form:label path="soldiersCode">
									<spring:message code="guard.field.soldiersCode" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="soldiersCode" /></td>
						</tr>
						<tr>
							<td><form:label path="socialSecurityNumber">
									<spring:message code="guard.field.socialSecurityNumber" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="socialSecurityNumber" /></td>
						</tr>
						<tr>
							<td><form:label path="firstName">
									<spring:message code="guard.field.firstName" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><form:label path="lastName">
									<spring:message code="guard.field.lastName" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><form:label path="gender">
									<spring:message code="guard.field.gender" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:select path="gender">
									<form:option value="0">
										<spring:message code="guard.gender.male" />
									</form:option>
									<form:option value="1">
										<spring:message code="guard.gender.female" />
									</form:option>
								</form:select></td>
						</tr>
					</table>
				</div>
				<div id="rightpanel">
					<table>
						<tr>
							<td><form:label path="email">
									<spring:message code="guard.field.email" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td><form:label path="phoneNumber">
									<spring:message code="guard.field.phoneNumber" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="phoneNumber" /></td>
						</tr>
						<tr>
							<td><form:label path="address">
									<spring:message code="guard.field.address" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="address" /></td>
						</tr>
						<tr>
							<td><form:label path="comment"><spring:message code="entity.field.comment" /></form:label></td>
						</tr>
						<tr>
							<td><form:textarea path="comment" name="comments" cols="100" class="guardComment"
									rows="3"></form:textarea></td>
						</tr>
					</table>
				</div>
			</div>
			<div id="buttonspanel">
				<input type="submit" value="<spring:message code="entity.button.save" />" class="btn btn-success " /> 
				<a class="btn btn-default" href="<c:url value="/guard/view"/>"><spring:message code="entity.button.cancel" /></a>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a class="btn btn-default" href="<c:url value="/guard/delete?id=${guard.id}"/>"><spring:message code="entity.button.delete" /></a>
				</sec:authorize>
			</div>
		</form:form>
	</div>
</pr:Layout>