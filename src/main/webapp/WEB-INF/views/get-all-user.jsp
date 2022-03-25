<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List of Users</h1>
	
	<table border="1">
	    <tr><th>UserId</th><th>UserName</th><th>Password</th>
	    					<th>Role</th></tr>
		<c:forEach var="u" items="${userList}">
			<tr><td>${u.userId}</td><td>${u.userName}</td><td>${u.password}</td><td>${u.role }</td>
				</tr>
		</c:forEach>	
	
	</table>
	
</body>
</html>