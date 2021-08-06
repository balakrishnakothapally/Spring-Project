<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	from {top: -200px;}
to {top: 20px;}

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

@keyframes mymove1 {
	from {left: -500px;}
to {left: 20px;}

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

@keyframes mymove2 {
	from {bottom: -200px;}
to {bottom: 20px;}

}





body, html {
  height: 100%;
  margin: 0;
}

.bg {
  
  background-image: url("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg");

  
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
	
	<div class="container">
		<div class="card">
		<div class="card-header bg-primary text-white text-center font-weight-bolder font-italic ">
	<div2 id="div1"><h3>welcome to OrderMethod Register page</h3></div2>
	
	</div>
	
	<div class="card-body">
	<form:form action="save" method="post" modelAttribute="orderMethod">
	
						<div class="row">
						<div class="col-3">
							<label for="orderMode" class="control-label "><div3 id="div1"><b>Order Mode :</b></div3></label>
						</div>
						
						<div class="col-5">

<form:radiobutton path="orderMode" value="SALE" />sale
<form:radiobutton path="orderMode" value="PURCHASE" />purchase
</div>
<div class="col-4">
<form:errors path="orderMode" cssClass="text-danger"/>
</div>
</div>
<br>

						<div class="row">
						<div class="col-3">
							<label for="orderCode" class="control-label"><div3 id="div1"><b>Order Code :</b></div3></label>

						</div>
						<div class="col-5">

				<form:input path="orderCode" cssClass="form-control" placeholder="enter code here"/>
				</div>
				
				<div class="col-4">
<form:errors path="orderCode" cssClass="text-danger"/>
</div>
</div>
<br>

					<div class="row">
						<div class="col-3">
							<label for="exeType" class="control-label "><div3 id="div1"><b>Excute Type :</b></div3></label>
						</div>
						<div class="col-5">

<form:select path="exeType" class="form-control">
<form:option value="">-select-</form:option>
<form:option value="LIFO">LIFO</form:option>
<form:option value="FIFO">FIFO</form:option>
<form:option value="FCFO">FCFO</form:option>
<form:option value="FEFO">FEFO</form:option>
</form:select>
</div>

<div class="col-4">
<form:errors path="exeType" cssClass="text-danger"/>
</div>
</div>
<br>


						<div class="row">
						<div class="col-3">
							<label for="orderAccepts" class="control-label "><div3 id="div1"><b>Order Accept :</b></div3></label>
						</div>
						<div class="col-5">

<form:checkbox path="orderAccepts" value="MULTI-MODEL" />Multi-Model
<form:checkbox path="orderAccepts" value="Accept Return"  />Accept Return
<form:checkbox path="orderAccepts" value="Service Extend" />Service Extend
</div>
<div class="col-4">
<form:errors path="orderAccepts" cssClass="text-danger"/>
</div>
</div>
<br>


				<div class="row">
						<div class="col-3">
							<label for="note" class="control-label "><div3 id="div1"><b>Description :</b></div3></label>
						</div>
						<div class="col-5">

<form:textarea path="note" cssClass="form-control" placeholder="enter code here"/>
</div>
<div class="col-4">

<form:errors path="note" cssClass="text-danger"/>
</div>
</div>


					<div class="row">
						<div class="col-3"></div>
						<div class="col-5">
						<div4 id="div1"><input type="submit" value="Register" class="btn btn-success btn-outline-primary text-white btn-block "  /></div4>
						</div>
						</div>



	</form:form>
	</div>
	
	<c:if test="${msg ne null}">
			<div class="card-footer bg-success text-white">
			<b>${msg}</b>
			</div>
			</c:if>
	
	
	
	<div class="row">
						<div class="col-3"></div>
	<a href="all"><button type="button" class="btn  btn-outline-primary ">VIEW ALL</button></a>
	</div>
	<br>
	<br>
	</div>
	</div>
</div>
</body>
</html>