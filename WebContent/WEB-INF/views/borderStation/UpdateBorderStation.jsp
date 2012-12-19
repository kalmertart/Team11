<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<pr:Layout>
	<div class="hero-unit">
		<h3>
			<spring:message code="borderStation.update.heading" />
		</h3>
	</div>
	<div id="formdiv">
		<form:form action="update" method="POST" modelAttribute="borderStation">
			<form:hidden path="id" />
			<c:if test="${errors}">
				<div id="errorspanel">
					<table>
						<tr>
							<td><form:errors path="code" /></td>
						</tr>
						<tr>
							<td><form:errors path="latitude" /></td>
						</tr>
						<tr>
							<td><form:errors path="name" /></td>
						</tr>
						<tr>
							<td><form:errors path="longitude" /></td>
						</tr>
						<tr>
							<td><form:errors path="elevation" /></td>
						</tr>
					</table>
				</div>
			</c:if>
			<div>
				<div id="leftpanel">
					<table>
						<tr>
							<td><form:label path="code">
									<spring:message code="borderStation.field.code" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="code" /></td>
						</tr>
						<tr>
							<td><form:label path="latitude">
									<spring:message code="borderStation.field.latitude" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="latitude" /></td>
						</tr>
					</table>
				</div>
				<div class="rightpanel">
					<table>
						<tr>
							<td><form:label path="name">
									<spring:message code="borderStation.field.name" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<td><form:label path="longitude">
									<spring:message code="borderStation.field.longitude" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="longitude" /></td>
						</tr>
					</table>
				</div>
				<div class="rightpanel">
					<table>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td style="padding-bottom: 6px">&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="elevation">
									<spring:message code="borderStation.field.elevation" />
								</form:label></td>
						</tr>
						<tr>
							<td><form:input path="elevation" /></td>
						</tr>
					</table>
				</div>
			</div>
			<div id="commentpanel">
			<table>
				<tr>
					<td><spring:message code="entity.field.comment" /></td>
				</tr>
				<tr>
					<td><form:textarea class="borderStationComment" path="comment" name="comments" cols="100" 
									rows="3"></form:textarea></td>
				</tr>
			</table>				
			</div>
			<div id="buttonspanel">
				<input type="submit" value="<spring:message code="entity.button.save" />" class="btn btn-success " /> 
				<a class="btn btn-default" href="<c:url value="/borderStation/view"/>"><spring:message code="entity.button.cancel" /></a>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a class="btn btn-default" href="<c:url value="/borderStation/delete?id=${borderStation.id}"/>"><spring:message code="entity.button.delete" /></a>
				</sec:authorize>
			</div>
		</form:form>
	</div>
</pr:Layout>