<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	from {top: -200px;
}

to {
	top: 20px;
}

}
#ui {
	background-color: #333;
	padding: 30px;
	margin-top: 50px;
	border-radius: 10px;
	opacity: 0.8;
}

body, html {
	height: 100%;
	margin: 0;
}

.bg {
	background-image:
		url("https://cdn.pixabay.com/photo/2019/04/25/15/57/black-white-4155205_1280.jpg");
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>

</head>
<body>

	<div class="bg">

		<%@include file="Menu.jsp"%>
		<div class="container">
			<div id="ui">
				<div class="card">
					<div
						class="card-header bg-primary text-white text-center font-weight-bolder font-italic ">
						
						<div2 id="div1"><h3>welcome to User Register Page</h3></div2>
						
					</div>
					<div class="card-body">

						<form:form action="save" method="Post" modelAttribute="user">

							<div class="row">
								<div class="col-3">
									<label for="userName" class="control-label"><b>Name
											: </b></label>

								</div>

								<div class="col-5">
									<form:input path="userName" cssClass="form-control"
										placeholder="enter name here.." />

								</div>
								<div class="col-4">
									<form:errors path="userName" cssClass="text-danger" />
								</div>
							</div>
							<br>


							<div class="row">
								<div class="col-3">
									<label for="userEmail" class="control-label"><b>Email
											: </b></label>

								</div>

								<div class="col-5">
									<form:input path="userEmail" cssClass="form-control"
										placeholder="enter name here.." />


								</div>

								<br>
								<div class="col-4">
									<form:errors path="userEmail" cssClass="text-danger" />
								</div>
							</div>
							<br>

							<div class="row">
								<div class="col-3">
									<label for="userPwd" class="control-label"><b>Password
											: </b></label>

								</div>

								<div class="col-5">

									<form:password path="userPwd" cssClass="form-control"
										placeholder="enter password here.." />
								</div>

								<div class="col-4">
									<form:errors path="userPwd" cssClass="text-danger" />
								</div>
							</div>
	<br>
	
	
							<div class="row">
								<div class="col-3">
									<label for="roles" class="control-label"><b>Roles 
											: </b></label>

								</div>

								<div class="col-5">


<form:checkbox path="roles" value="ADMIN" />Admin
<form:checkbox path="roles" value="EMPLOYEE" />Employee
</div>
<div class="col-4">
<form:errors path="roles" cssClass="text-danger" />
</div>
</div>
<br>

<div class="row">
							<div class="col-3"></div>
							<div class="col-5">
								<input type="submit" value="Register"
									class="btn btn-success btn-outline-primary text-white btn-block " />
							</div>
						</div>
							

							

						</form:form>
						

					</div>
				</div>
				
				
				<c:if test="${utd ne null}">
				<div class="card-footer bg-success text-white">
					<b>${utd}</b>
				</div>
			</c:if>
			<br>
			
			<div class="row">
						<div class="col-3"></div>
	<a href="all"><button type="button" class="btn  btn-outline-primary ">VIEW ALL</button></a>
	</div>
	
	</div>
	</div>
	
	
			</div>
</body>
</html>