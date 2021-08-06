<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
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


 body, html {
  height: 100%;
  margin: 0;
}

.bg {
  
  background-image: url("https://cdn.pixabay.com/photo/2018/02/13/23/41/nature-3151869_1280.jpg");

  
  height: 100%; 

 
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}


</style>



<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="bg">
<%@include file="Menu.jsp"%>
	<div class="container mt-3">
	<div class="card">
	<div class="card-header bg-primary text-white text-center font-weight-bolder font-italic">
	<div2 id="div1"><h2>welcome to shipmentType view page</h2></div2>
	</div>
	<div class="card-body">
	<div class="table-responsive">
	<table class="table table-bordered table-hover table-striped text-center">
		<tr >
			<th>ID</th>
			<td><b>${st.shipmentId}</b></td>
		</tr>
		<tr>
			<th>CODE</th>
			<td><b>${st.shipmentCode}</b></td>
		</tr>
		<tr>
			<th>MODE</th>
			<td><b>${st.shipmentMode}</b></td>
		</tr>
		<tr>
			<th>ENABLED</th>
			<td><b>${st.enableShipment}</b></td>
		</tr>
		<tr>
			<th>GRADE</th>
			<td><b>${st.shipmentGrade}</b></td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td><b>${st.note}</b></td>
		</tr>

	</table>
	</div>
	</div>
</div>
</div>
</div>
</body>
</html>