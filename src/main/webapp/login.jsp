<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false"%>
<!--<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<label>Username: <input type="text" name="username"></label><br>
		<label>Password: <input type="text" name="password"></label><br>
		<c:if test="${ errorLogin != null }">
			<p>${errorLogin}</p>
		</c:if>
		<input type="submit" value="Login">
	</form>
</body>
</html>