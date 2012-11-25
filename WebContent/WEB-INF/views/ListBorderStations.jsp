<%@ taglib tagdir="/WEB-INF/tags" prefix="pr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<pr:Layout>
	<h1>Border Stations</h1>
	<div class="hero-unit">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Amount of guards</th>
			</tr>
			<c:forEach items="${borderStations}" var="borderStation">
				<tr>
					<td>${borderStation.id}</td>
					<td>${borderStation.name}</td>
					<td>${borderStation.address}</td>
					<td>${borderStation.guardCount}</td>
				</tr>
			</c:forEach>
		</table>
		<a href='<c:url value="/borderStation/add"/>' class="btn btn-primary btn-larg">Add new</a>
	</div>
</pr:Layout>