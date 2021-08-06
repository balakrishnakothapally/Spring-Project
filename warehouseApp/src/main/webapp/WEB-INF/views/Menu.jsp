<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"
	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />

    

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">
  WAREHOUSE
  	<img  src="../resources/images/bb.png" width="50" height="50">
  </a>

  <!-- Links -->
  <ul class="navbar-nav">
   
   
    <li class="nav-item">
      <a class="nav-link" href="#">Home</a>
    </li>
    
		
	<!-- Copy below code for another menu option -->
		
    <!-- Shipment Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>SHIPMENT-TYPE</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/shipment/register">Register</a>
        <a class="dropdown-item" href="${url}/shipment/all">View All</a>
        <a class="dropdown-item" href="${url}/shipment/charts">Reports</a>
      </div>
    </li>
    <!-- Shipment Type end -->
    
    <!-- copy upto this -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>UOM</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/uom/show">Register</a>
        <a class="dropdown-item" href="${url}/uom/all">View All</a>
        <a class="dropdown-item" href="${url}/uom/charts">Reports</a>
      </div>
    </li>
    
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>ORDER-METHOD</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/order/show">Register</a>
        <a class="dropdown-item" href="${url}/order/all">View All</a>
        <a class="dropdown-item" href="${url}/order/charts">Reports</a>
      </div>
    </li>
    
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>USER</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/sample/show">Register</a>
        <a class="dropdown-item" href="${url}/sample/all">View All</a>
        <a class="dropdown-item" href="${url}/sample/charts">Reports</a>
      </div>
    </li>
    
    
    
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>WhUser-TYPE</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/user/show">Register</a>
        <a class="dropdown-item" href="${url}/user/all">View All</a>
        <a class="dropdown-item" href="${url}/user/charts">Reports</a>
      </div>
    </li>
    
    
    <li class="nav-item">
      <a class="nav-link" href="#">Logout</a>
    </li>
  </ul>
</nav>