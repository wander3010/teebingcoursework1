<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tee bing coursework 1 code management register jsp file</title>
</head>
<body>
<!-- enter code here -->
	<form action="RegisterServlet" method="post">
		
		Name:<input type="text" name="username"/><br/>
		Password:<input type="password" name="password"/><br/>
		Email:<input type="text" name="email" /><br/>
		Language: <select name="language">
			<option>English</option>
			<option>Chinese</option>
			<option>Malay</option>
			<option>Indian</option>
		</select> <br/>
		<input type="submit" value="Register"/>

</form>
</body>
</html>