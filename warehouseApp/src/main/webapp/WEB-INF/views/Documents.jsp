<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>welcome to Documents Page</h3>
	<form action="upload" method="post" enctype="multipart/form-data">
		<pre>
File:<input type="file" name="fob" />
<input type="submit" value="upload">




</pre>

	</form>
	<hr />
	<table border="1">
		<tr>
			<th>File Name</th>
			<th>Download link</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob[1]}" /></td>
				<td><a href="download?fileId=${ob[0]}"><img src="../resources/images/download.png" width="40" height="40"/></a></td>
			</tr>
<!-- 			<tr> -->
<%-- 				<td><a href="download?fileId=${ob[0]}">DOWNLOAD</a></td> --%>
		</c:forEach>


	</table>

</body>
</html>