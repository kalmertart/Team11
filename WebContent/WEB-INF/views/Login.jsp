<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>

<pr:Layout>
	<h1>Login</h1>
	<div class="hero-unit">
		<form name='f' action="j_spring_security_check" method='POST'>
			<table>
				<tr>
					<td>User</td>
					<td><input type='text' name='j_username' value=''></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type='password' name='j_password' /></td>
				</tr>
				<tr>
					<td colspan='2'>
						<input name="submit" type="submit" value='Login' class="btn btn-primary btn-larg" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</pr:Layout>