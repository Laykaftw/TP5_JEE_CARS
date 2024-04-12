<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>List of Makers</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">List of Makers</div>
			<div class="card-body">
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Maker</th>
						<th>Creation Date</th>
						<th>Delete</th>
						<th>Edit</th>
					</tr>
					<c:forEach items="${model.Makers}" var="mak">
						<tr>
							<td>${mak.idMaker }</td>
							<td>${mak.MakerName }</td>
							<td><fmt:formatDate pattern="dd/MM/yyyy"
									value="${cat.dateCreation}" /></td>
							<td><a onclick="return confirm('Are you sure? ')"
								href="supprimerCat?id=${mak.idMaker }">Delete</a></td>
							<td><a href="editerCat?id=${mak.idMaker }">Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>