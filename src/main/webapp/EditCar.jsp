<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Update</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Editing Cars</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div hidden class="form-group">
						<label class="control-label">Car ID :</label> <input type="text"
							name="id" class="form-control" value="${car.idCar}" />
					</div>
					<div class="form-group">
						<label class="control-label">Car Name :</label> <input type="text"
							name="nom" class="form-control" value="${car.carname}" />
					</div>
					<div class="form-group">
						<label class="control-label">Price :</label> <input type="text"
							name="prix" class="form-control" value="${car.price}" />
					</div>
					<div class="form-group">
						<select name="maker" class="form-control">
							<option value="${car.maker.idMaker}" selected>${car.maker.MakerName}</option>
							<c:forEach items="${catModel.makers}" var="cat">
								<c:if test="${cat.idMaker != car.maker.idMaker}">
									<option value="${cat.idMaker}">${cat.MakerName}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
