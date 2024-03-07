<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Search in Cars</div>
			<div class="card-body">
				<form action="chercher.do" method="get">
					<label>Keyword</label> <input type="text" name="motCle"
						value="${modele.motCle}" />
					<button type="submit" class="btn btn-primary">Search</button>
				</form>
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Car Name</th>
						<th>Price</th>
					</tr>
					<c:forEach items="${modele.cars}" var="c">
						<tr>
							<td>${c.idCar}</td>
							<td>${c.carname}</td>
							<td>${c.price}</td>
							<td><a onclick="return confirm('Etes-vous sûr ?')"
								href="supprimer.do?id=${c.idCar }">Delete</a></td>
							<td><a href="editer.do?id=${c.idCar }">Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>