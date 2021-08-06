<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>welcome to WhUserType View page</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${wt.userId}</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${wt.userType}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${wt.userCode}</td>
		</tr>
		<tr>
			<th>FOR</th>
			<td>${wt.userFor}</td>
		</tr>
		<tr>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<th>GMAIL</th>
			<td>${wt.userGmail}</td>
		</tr>
		<tr>
			<th>CONTACT</th>
			<td>${wt.userContact}</td>
		</tr>
		<tr>
			<th>IDTYPE</th>
			<td>${wt.userIdType}</td>
		</tr>
		<tr>
			<th>NUMBER</th>
			<td>${wt.userIdNumber}</td>
		</tr>
	</table>

</body>
</html>