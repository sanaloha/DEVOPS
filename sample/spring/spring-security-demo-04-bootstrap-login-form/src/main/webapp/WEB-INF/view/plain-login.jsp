<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
			<title>Custom Login Form</title>
	<style>
		.error{
			color: red;
			}
	
	</style>
	</head>
	
	

	<body>
		<h3>My Custom Login form</h3>
		
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		
			<!-- Check for Login Error -->
			<c:if test="${param.error!=null}">
				<i class="error">Sorry! you entered invalid user/password</i>
			</c:if>
			<br><br>
			User Name: <input type="text" name="username" />
			<br><br>
			Password: <input type="password" name="password" />
			<br><br>
			<input type="submit" value="Login" />
	</form:form>
	</body>	
</html>
