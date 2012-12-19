<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<pr:Layout>
	<div class="hero-unit">
		<h3>
			<spring:message code="accessDenied.header" />
		</h3>
	</div>
	
	<p><spring:message code="accessDenied.text" /></p>
	
</pr:Layout>