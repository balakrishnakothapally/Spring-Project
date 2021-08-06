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
	from {top: -100px;
}

to {
	top: 20px;
}

}
body, html {
	height: 100%;
	margin: 0;
}

.bg {
	background-image:
		url("https://cdn.pixabay.com/photo/2019/04/27/16/10/star-4160389_1280.jpg");
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
	<div2 id="div1"><h3>welcome to USER View Page</h3></div2>
	</div>
	<div class="card-body">
	<div class="table-responsive">
	<table class="table table-bordered table-hover table-striped text-center">
	
		<tr >
			<th>ID</th>
			<td><b>${u.userId}</b></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><b>${u.userName}</b></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><b>${u.userEmail}</b></td>
		</tr>
		<tr>
			<th>PASSWORD</th>
			<td><b>${u.userPwd}</b></td>
		</tr>
		<tr>
			<th>ROLES</th>
			<td><b>${u.roles}</b></td>
		</tr>


	</table>
	</div>
	</div>
	</div>
	</div>
	
	

</body>
</html>