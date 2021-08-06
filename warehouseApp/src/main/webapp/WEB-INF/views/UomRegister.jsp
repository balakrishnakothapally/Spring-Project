<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

@
keyframes mymove {
	from {top: -200px;
}

to {
	top: 20px;
}

}
div3 {
	width: 100px;
	height: 10px;
	background-image: black;
	color: black;
	font-weight: bold;
	position: relative;
	animation: mymove1 1s;
}

@
keyframes mymove1 {
	from {left: -500px;
}

to {
	left: 20px;
}

}
div4 {
	width: 100px;
	height: 10px;
	background-image: black;
	color: black;
	font-weight: bold;
	position: relative;
	animation: mymove2 1s;
}

@
keyframes mymove2 {
	from {bottom: -400px;
}

to {
	bottom: 20px;
}

}
body, html {
	height: 100%;
	margin: 0;
}

.bg {
	background-image:
		url("https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_1280.jpg");
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
			<div class="card">
				<div
					class="card-header bg-primary text-white text-center font-weight-bolder font-italic ">
					<div2 id="div1">
					<h3>welcome to Uom Register Page</h3>
					</div2>
				</div>
				<div class="card-body">
					<form:form action="save" method="Post" modelAttribute="uom">
						<div class="row">
							<div class="col-3">
								<label for="uType" class="control-label "><div3
										id="div1"> <b>Uom Type:</b></div3></label>
							</div>
							<div class="col-5">

								<form:select path="uType" class="form-control">
									<form:option value="">-select-</form:option>
									<form:option value="PACKING">Packing</form:option>
									<form:option value="NO-PACKING">No packing</form:option>
									<form:option value="-NA-">-NA-</form:option>
								</form:select>
							</div>
							<div class="col-4">
								<form:errors path="uType" cssClass="text-danger" />
							</div>
						</div>
						<br>


						<div class="row">
							<div class="col-3">
								<label for="uModel" class="control-label"><div3
										id="div1"> <b>Uom Model :</b></div3></label>

							</div>
							<div class="col-5">
								<form:input path="uModel" cssClass="form-control"
									placeholder="enter model name" data-toggle="tooltip"
									data-placement="top" title="please enter model name" />
							</div>
							<div class="col-4">

								<form:errors path="uModel" cssClass="text-danger" />
							</div>
						</div>
						<br>

						<div class="row">
							<div class="col-3">
								<label for="uDes" class="control-label"><div3 id="div1">
									<b>Note :</b></div3></label>

							</div>

							<div class="col-5">

								<form:textarea path="uDes" cssClass="form-control"
									placeholder="enter details here" />
							</div>
							<div class="col-4">
								<form:errors path="uDes" cssClass="text-danger" />
							</div>
						</div>

						<div class="row">
							<div class="col-3"></div>
							<div class="col-5">
								<div4 id="div1"> <input type="submit" value="Register"
									class="btn btn-success btn-outline-primary text-white btn-block " /></div4>
							</div>
						</div>



					</form:form>
				</div>
				<c:if test="${utd ne null}">
					<div class="card-footer bg-success text-white">
						<b>${utd}</b>
					</div>
				</c:if>

			</div>
		</div>
	</div>



</body>
</html>