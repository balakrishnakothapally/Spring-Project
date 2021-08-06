<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bg-light">
<%@include file="Menu.jsp" %>
	<div class="container mt-3">
<div class="card">
		<div class="card-header bg-primary text-white text-center font-weight-bolder font-italic alert alert-warning">
	<h3>welcome to UOM DATA PAGE</h3>
	</div>
	<div class="card-body">
	<div class="table-responsive">
	<c:if test="${empty list}">
	<h3>No data found</h3>
	</c:if>
	<c:if test="${!empty list}">
	<table class="table table-bordered table-hover table-striped">
	<thead class=" bg-dark ">
		<tr class="table-info text-success text-center">
		
			<th>ID</th>
			<th>TYPE</th>
			<th>MODEL</th>
			<th>NOTE</th>
			<th colspan="5">OPERATIONS</th>
		</tr>
		</thead>
		<c:forEach items="${list}" var="ob">
			<tr class="text-center">
				<td><c:out value="${ob.uId}"></c:out></td>
				<td><c:out value="${ob.uType}"></c:out></td>
				<td><c:out value="${ob.uModel}"></c:out></td>
				<td><c:out value="${ob.uDes}"></c:out></td>
				<td><a href="delete?id=${ob.uId}"><img src="../resources/images/delete.png" width="40" height="40"/></a></td>
				<td><a href="viewone?id=${ob.uId}"><img src="../resources/images/view.png" width="40" height="40"/></a>
				<td><a href="edit?id=${ob.uId}"><img src="../resources/images/edit.png" width="40" height="40"/></a></td>
				<td><a href="excel?id=${ob.uId}"><img src="../resources/images/excel.png" width="40" height="40"/></a></td>
				<td><a href="pdf?id=${ob.uId}"><img src="../resources/images/pdf.png" width="40" height="40"/></a></td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<a href="excel"> <img src="../resources/images/BulkExcel.png"
					width="100" height="50" />
				</a> 
				
				<a href="pdf"> <img src="../resources/images/BulkPdf.png"
					width="100" height="50" />
				</a>
	</div>
	</div>
	<c:if test="${msg ne null}">
			<div class="card-footer bg-warning text-danger">
			<b>${msg}</b>
			</div>
			</c:if>
	</div>
	

</body>
</html>