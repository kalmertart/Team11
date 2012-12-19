<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>

<pr:Layout>
	
	<div class="hero-unit">
	<h3>
		<spring:message code="login.header"/>
	</h3>
		<form name='f' action="j_spring_security_check" method='POST'>
			<table>
				<tr>
					<td><spring:message code="login.username"/></td>
					<td><input type='text' name='j_username' value=''></td>
				</tr>
				<tr>
					<td><spring:message code="login.password"/></td>
					<td><input type='password' name='j_password' /></td>
				</tr>
				<tr>
					<td colspan='2'>
						<input name="submit" type="submit" value='<spring:message code="login.login"/>' class="btn btn-success" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</pr:Layout>