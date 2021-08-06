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
	from {top: -200px;}
to {top: 20px;}

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
  
  background-image: url("https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_1280.jpg");

  
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
				<div2 id="div1"><h3>welcome to Shipment Type Page</h3></div2>
				</div>
				<div class="card-body">


					<form:form action="save" method="Post"
						modelAttribute="shipmentType">
						<div class="row">
							<div class="col-3">
								<label for="shipmentMode" class="control-label"><b>Shipment
										Mode :</b></label>

							</div>

							<div class="col-5">
								<form:select path="shipmentMode" class="form-control">
									<form:option value="">--select--</form:option>
									<form:option value="TRAIN">Train</form:option>
									<form:option value="SHIP">Ship</form:option>
									<form:option value="AIR">Air</form:option>
									<form:option value="TRUCK">Truck</form:option>
								</form:select>
							</div>


							<div class="col-4">
								<form:errors path="shipmentMode" cssClass="text-danger" />

							</div>
						</div>
						<br>

						<div class="row">
							<div class="col-3">
								<label for="shipmentCode" class="control-label"><b>ShipmentCode
										:</b></label>

							</div>

							<div class="col-5">
								<form:input path="shipmentCode" cssClass="form-control"
									placeholder="enter code here.."  data-toggle="tooltip" data-placement="top" title="please enter code here"/>

							</div>


							<div class="col-4">
								<form:errors path="shipmentCode" cssClass="text-danger" />

							</div>

						</div>
						<br>

						<div class="row">
							<div class="col-3">
								<label for="enableShipment" class="control-label"><b>EnableShipment
										:</b></label>

							</div>

							<div class="col-5">
								<form:select path="enableShipment" class="form-control">
									<form:option value="">--select--</form:option>
									<form:option value="YES">YES</form:option>
									<form:option value="NO">NO</form:option>

								</form:select>

							</div>


							<div class="col-4">
								<form:errors path="enableShipment" cssClass="text-danger" />

							</div>

						</div>
						<br>


						<div class="row">
							<div class="col-3">
								<label for="shipmentGrade" class="control-label"><b>ShipmentGrade
										:</b></label>

							</div>

							<div class="col-5">

								<form:radiobutton path="shipmentGrade" value="A" />
								A
								<form:radiobutton path="shipmentGrade" value="B" />
								B
								<form:radiobutton path="shipmentGrade" value="C" />
								C

							</div>


							<div class="col-4">
								<form:errors path="shipmentGrade" cssClass="text-danger" />

							</div>

						</div>
						<br>


						<div class="row">
							<div class="col-3">
								<label for="note" class="control-label"><b>Desciption
										:</b></label>

							</div>

							<div class="col-5">
								<form:textarea path="note" cssClass="form-control"
									placeholder="enter address details" />

							</div>


							<div class="col-4">

								<form:errors path="note" cssClass="text-danger" />
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
			<c:if test="${std ne null}">
				<div class="card-footer bg-success text-white">
					<b>${std}</b>
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
