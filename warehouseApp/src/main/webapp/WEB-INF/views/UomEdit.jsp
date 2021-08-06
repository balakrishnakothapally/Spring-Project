<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		url("https://cdn.pixabay.com/photo/2019/04/13/09/27/landscape-4124096_1280.jpg");
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.readMode {
	background-color: #D3D3D3;
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="bg">
		<%@include file="Menu.jsp"%>
		<div class="container">
			<div id="ui">
				<div class="card">
					<div
						class="card-header bg-primary text-white text-center font-weight-bolder font-italic ">

						
						<div2 id="div1"><h2>welcome to UOM Edit Page</h2></div2>
						
					</div>

					<div class="card-body">
						<form:form action="update" method="post" modelAttribute="uom">
							<div class="row">
								<div class="col-3">
									<label for="uId" class="control-label"><b>uomId : </b></label>
								</div>
								<div class="col-5">


									<form:input path="uId" readonly="true"
										cssClass="readMode form-control" />
								</div>
							</div>
							<br>


							<div class="row">
								<div class="col-3">
									<label for="uType" class="control-label"><b>Uom
											Type :</b></label>
								</div>
								<div class="col-5">

									<form:select path="uType" class="form-control">
										<form:option value="">-select-</form:option>
										<form:option value="PACKING">Packing</form:option>
										<form:option value="NO-PACKING">No packing</form:option>
										<form:option value="-NA-">-NA-</form:option>
									</form:select>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="uModel" class="control-label"><b>UomModel
											:</b></label>

								</div>
								<div class="col-5">

									<form:input path="uModel" readonly="true"
										cssClass="readMode form-control" />
								</div>
							</div>

							<br>
							<div class="row">
								<div class="col-3">
									<label for="uDes" class="control-label"><b>Note :</b></label>

								</div>

								<div class="col-5">

									<form:textarea path="uDes" cssClass="form-control " />
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3"></div>
								<div class="col-5">
									<input type="submit" value="update"
										class="btn btn-success btn-outline-primary text-white btn-block " />
								</div>
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