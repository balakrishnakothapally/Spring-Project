<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					
				<div2 id="div1"><h3>welcome to WhUser Type Register Page</h3></div2>
					
				</div>
				<div class="card-body">


<form:form action="save" method="Post" modelAttribute="whUserType">

							<div class="row">
							<div class="col-3">
								<label for="userType" class="control-label ">
										 <b>User Type :</b></label>
							</div>
							<div class="col-5">

<form:radiobutton path="userType" value="VENDOR"/>vendor
<form:radiobutton path="userType" value="CUSTOMER"/>customer
</div>

<div class="col-4">
<form:errors path="userType" cssClass="text-danger"/>
</div>
</div>
<br>

						<div class="row">
							<div class="col-3">
								<label for="userCode" class="control-label ">
										 <b>User Code :</b></label>
							</div>
							<div class="col-5">
					<form:input path="userCode" cssClass="form-control"/>
</div>
<div class="col-4">

<form:errors path="userCode" cssClass="text-danger"/>
</div>
</div>
<br>


							<div class="row">
							<div class="col-3">
								<label for="userFor" class="control-label ">
										 <b>User For :</b></label>
							</div>
							<div class="col-5">

<form:select path="userFor" class="form-control">
<form:option value="">-select-</form:option>
<form:option value="PURCHASE">Purchase</form:option>
<form:option value="SALE">Sale</form:option>
</form:select>
</div>
<div class="col-4">
<form:errors path="userFor" cssClass="text-danger"/>

</div>
</div>
<br>

							<div class="row">
							<div class="col-3">
								<label for="userGmail" class="control-label ">
										 <b>User Email :</b></label>
							</div>
							<div class="col-5">

<form:input path="userGmail" cssClass="form-control"/>
</div>

<div class="col-4">

<form:errors path="userGmail" cssClass="text-danger"/>
</div>
</div>
<br>

							<div class="row">
							<div class="col-3">
								<label for="userContact" class="control-label ">
										 <b>User Contact :</b></label>
							</div>
							<div class="col-5">

<form:input path="userContact " cssClass="form-control"/>
</div>
<div class="col-4">
<form:errors path="userContact" cssClass="text-danger"/>
</div>
</div>
<br>


							<div class="row">
							<div class="col-3">
								<label for="userIdType" class="control-label ">
										 <b>User Id Type :</b></label>
							</div>
							<div class="col-5">

<form:select path="userIdType " class="form-control">
<form:option value="">-select-</form:option>
<form:option value="PAN CARD">pan card</form:option>
<form:option value="AADAAR">aadaar</form:option>
<form:option value="VOTERID">voterid</form:option>
<form:option value="OTHER">other</form:option>

</form:select>
</div>
<div class="col-4">
<form:errors path="userIdType" cssClass="text-danger"/>
</div>
</div>
<br>


							<div class="row">
							<div class="col-3">
								<label for="userIdNumber" class="control-label ">
										 <b>ID Number :</b></label>
							</div>
							<div class="col-5">



<form:input path="userIdNumber" cssClass="form-control" />
</div>
<div class="col-5">
<form:errors path="userIdNumber" cssClass="text-danger"/>

</div>
</div>
<br>








</form:form>

</div>
				<c:if test="${utd ne null}">
					<div class="card-footer bg-success text-white">
						<b>${utd}</b>
					</div>
				</c:if>
				<br>
				
				<br>
			<div class="row">
						<div class="col-3"></div>
	<a href="all"><button type="button" class="btn  btn-outline-primary ">VIEW ALL</button></a>
	</div>
	
				

			</div>
		</div>
	</div>

<br/>
	

</body>
</html>