<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div2 {
	width: 100px;
	height: 10px;
	background-image: white;
	color: white;
	font-weight: bold;
	position: relative;
	animation: mymove 1s;
}

@keyframes mymove {
	from {top: -200px;}
to {top: 20px;}

}
 </style>
</head>
<body class="bg-light">
<%@include file="Menu.jsp" %>
	<div class="container mt-3">
	<input class="form-control" id="myInput" type="text" placeholder="Search.."/>
   <br>
		<div class="card">
		<div class="card-header bg-primary text-white text-center font-weight-bolder font-italic alert alert-warning">
		<div id="div1"><h2 >welcome to Shipment Data Page</h2></div>
		
		</div>
		
		
		<div class="card-body">
		 <div class="table-responsive">
			
			<c:if test="${empty list}">
				<h3>no data found</h3>
			</c:if>
			<c:if test="${!empty list}">
				<table class="table table-bordered table-hover table-striped">
				<thead class=" bg-dark ">
					<tr class="table-info text-success text-center">
						<th>id</th>
						<th>MODE</th>
						<th>CODE</th>
						<th>ENABLE</th>
						<th>GRADE</th>
						<th>NOTE</th>
						<th colspan="5">OPERATIONS</th>
					</tr>
					</thead>
					<c:forEach items="${list}" var="ob">
					<tbody id="myTable">
						<tr class="text-center">
							<td><b><c:out value="${ob.shipmentId}" /></b></td>

							<td><c:out value="${ob.shipmentMode}" /></td>

							<td><c:out value="${ob.shipmentCode}" /></td>

							<td><c:out value="${ob.shipmentGrade}" /></td>

							<td><c:out value="${ob.enableShipment}" /></td>

							<td><c:out value="${ob.note}" /></td>
							<td><b><a href="delete?id=${ob.shipmentId}"><img
									src="../resources/images/delete.png" width="40" height="40" /></a></b></td>
							<td><a href="viewone?id=${ob.shipmentId}"><img
									src="../resources/images/view.png" width="40" height="40" /></a></td>
							<td><b><a href="edit?id=${ob.shipmentId}"><img
									src="../resources/images/edit.png" width="40" height="40" /></a></b></td>
							<td><b><a href="excel?id=${ob.shipmentId}"><img
									src="../resources/images/excel.png" width="40" height="40" /></a></b></td>
							<td><a href="pdf?id=${ob.shipmentId}"><img
									src="../resources/images/pdf.png" width="40" height="40" /></a>

						</tr>
</tbody>
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
				  <script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
			
			<c:if test="${msg ne null}">
			<div class="card-footer bg-warning text-danger">
			<b>${msg}</b>
			</div>
			</c:if>
		</div>
	</div>
</body>
</html>