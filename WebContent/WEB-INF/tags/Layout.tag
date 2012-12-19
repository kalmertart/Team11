<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="main.title"/></title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="./css/myCss.css" rel="stylesheet">
<link href="../css/myCss.css" rel="stylesheet">
<link href="./css/datepicker.css" rel="stylesheet">
<link href="../css/datepicker.css" rel="stylesheet">
<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" /> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.js"></script>
<!-- <script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script> -->
<script type="text/javascript" src="./js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="../js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="./js/script.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="<c:url value="/"/>"><spring:message code="borderservice"/></a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<sec:authorize access="isAnonymous()">
							<li><a href="<c:url value="/login"/>"><spring:message code="login.login"/></a></li>
						</sec:authorize>
						<sec:authorize access="hasAnyRole('ROLE_USER, ROLE_MODERATOR, ROLE_ADMIN')">
							<li><a href="<c:url value="/guard/view"/>"><spring:message code="guard.singular"/></a></li>
							<li><a href="<c:url value="/borderStation/view"/>"><spring:message code="borderStation.singular"/></a></li>
							<li><a href="<c:url value="/occupation/view"/>"><spring:message code="occupation.singular"/></a></li>
							<li><a href="<c:url value="/occupationInBorderStation/view"/>"><spring:message code="occupationInBorderStation.singular"/></a></li>
							<li><a href="<c:url value="/guardInBorderStation/view"/>"><spring:message code="guardInBorderStation.singular"/></a></li>
							<li><a href="<c:url value="/j_spring_security_logout"/>"><spring:message code="login.logout"/></a></li>
						</sec:authorize>
						<li><a href="?siteLanguage=et">
							<img height="12" width="18" alt="et" src="http://www.itcollege.ee/wp-content/plugins/sitepress-multilingual-cms/res/flags/et.png">
						</a></li>
						<li><a href="?siteLanguage=en">
							<img height="12" width="18" alt="en" src="http://www.itcollege.ee/wp-content/plugins/sitepress-multilingual-cms/res/flags/en.png">
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<jsp:doBody />
	</div>
	<footer class="footer">
		<div class="container">
			<hr />
			<p>
				<spring:message code="home.footer" />
			</p>
		</div>
	</footer>
</body>
</html>