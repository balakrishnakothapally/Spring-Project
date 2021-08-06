<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.readMode {
	background-color: #D3D3D3;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>welcome to Edit page</h2>

	<form:form action="update" method="Post" modelAttribute="whUserType">
	<pre>
user Id:
<form:input path="userId" readonly="true" cssClass="readMode"/>
user Type:
<form:radiobutton path="userType" value="VENDOR" />vendor
<form:radiobutton path="userType" value="CUSTOMER" />customer
user Code:
<form:input path="userCode" readonly="true" cssClass="readMode"/>
user For:
<form:select path="userFor">
			<form:option value="">-select-</form:option>
			<form:option value="PURCHASE">Purchase</form:option>
			<form:option value="SALE">Sale</form:option>
		</form:select>
user Email:
<form:input path="userGmail" />
user Contact:
<form:input path="userContact" />
user Id type:
<form:select path="userIdType">
			<form:option value="">-select-</form:option>
			<form:option value="PAN CARD">pan card</form:option>
			<form:option value="AADAAR">aadaar</form:option>
			<form:option value="VOTERID">voterid</form:option>
			<form:option value="OTHER">other</form:option>

		</form:select>
ID number:
<form:input path="userIdNumber" />
		<input type="submit" value="Register">

		</pre>







	</form:form>
	
	${utd}
	<br/>
	<a href="all">update</a>

</body>
</html>