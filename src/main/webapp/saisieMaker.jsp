<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Add Makers</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Add Makers</div>
			<div class="card-body">
				<form action="saveMaker" method="post">
					<div class="form-group">
						<label class="control-label">Maker Name :</label> <input
							type="text" name="nom" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">maker Date : </label> <input
							type="date" name="dateCat" class="form-control"></input>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>