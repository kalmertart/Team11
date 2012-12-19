<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<pr:Layout>
	<div class="hero-unit">
		<h3>
			<spring:message code="guardInBorderStation.add" />
		</h3>
	</div>
		<div id="formdiv">
			<form:form action="add" method="POST" modelAttribute="guardInBorderStation">
				<div>
					<c:if test="${errors}">
						<div id="errorspanel">
							<table>
								<tr>
									<td><form:errors path="guard.id" /></td>
								</tr>
								<tr>
									<td><form:errors path="borderStation.id" /></td>
								</tr>
								<tr>
									<td><form:errors path="start" /></td>
								</tr>
								<tr>
									<td><form:errors oath="workTime" /></td>
								</tr>
								<tr>
									<td><form:errors path="comment" /></td>
								</tr>
							</table>
						</div>
					</c:if>
					<div id="leftpanel">
						<table>
							<tr>
								<td>
									<form:label path="guard.id">
										<spring:message code="guardInBorderStation.field.guard"/>
									</form:label>
								</td>
							</tr>
							<tr>
								<td>
									<form:select path="guard.id">
										<c:forEach items="${guards}" var="guard">
											<c:set var="guardId" value="${guard.id}"/>
											<form:option value="${guardId}">
												<c:out value="${guard.firstName}" />
												<c:out value=" " />
												<c:out value="${guard.lastName}" />
											</form:option>
										</c:forEach>
									</form:select>
								</td>
							</tr>
							<tr>
								<td>
									<form:label path="borderStation.id">
										<spring:message code="guardInBorderStation.field.borderStation"/>
									</form:label>
								</td>
							</tr>
							<tr>
								<td>
									<form:select path="borderStation.id">
										<c:forEach items="${borderStations}" var="borderStation">
											<c:set var="borderStationId" value="${borderStation.id}"/>
											<form:option value="${borderStationId}">
												<c:out value="${borderStation.name}" />
											</form:option>
										</c:forEach>
									</form:select>
								</td>
							</tr>
							<tr>
								<td>
									<form:label path="workTime">
										<spring:message code="guardInBorderStation.field.workTime" />
									</form:label>
								</td>
							</tr>
							<tr>
								<td>
									<form:input path="workTime"/>
								</td>
							</tr>
						</table>
					</div>
					<div class="rightpanel">
						<table>
							<tr>
								<td>
									<form:label path="start">
										<spring:message code="guardInBorderStation.field.start"/>
									</form:label>
								</td>
							</tr>
							<tr>
								<td>
									<form:input path="start" class="datefield" />
								</td>
							</tr>
							<tr>
								<td>
									<form:label path="end">
										<spring:message code="guardInBorderStation.field.end"/>
									</form:label>
								</td>
							</tr>
							<tr>
								<td>
									<form:input path="end" class="datefield" />
								</td>
							</tr>
						</table>
					</div>
					<div style="clear:both"></div>
					<table>
						<tr>
							<td>
								<form:label path="comment">
									<spring:message code="entity.field.comment" />
								</form:label>
							</td>
						</tr>
						<tr>
							<td>
								<form:textarea path="comment" name="comments" cols="100" class="guardComment" rows="3"/>
							</td>
						</tr>
					</table>
				</div>
				<div id="buttonspanel">
					<input type="submit" value="<spring:message code="entity.button.save" />" class="btn btn-success " /> 
					<a class="btn btn-default" href="<c:url value="/guardInBorderStation/view"/>">
						<spring:message code="entity.button.cancel" />
					</a>
				</div>
			</form:form>
	</div>
</pr:Layout>