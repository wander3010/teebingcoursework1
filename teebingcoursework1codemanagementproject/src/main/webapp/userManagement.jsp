<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- enter codes to capture user details -->
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
		<div>
			<a href="https://www.javaguides.net" class="navbar-brand"> User Application </a>
		</div>

	<ul class="navbar-nav">

	<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
	
	</ul>

		</nav>
	</header>

	<br>

	<div class="row">

	<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

	<div class="container">
	
	<h3 class="text-center">List of Users</h3>

	<hr>

	<div class="container text-left">

	<a href="<%=request.getContextPath()%>/register.jsp" class="btn btn-success">Add User</a>

	</div>

	<br>

	<table class="table table-bordered">

	<thead>

		<tr>
			
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Language</th>
			<th>Actions</th>

		</tr>

	</thead>

	<tbody>
	
	<!-- for (Todo todo: todos) { -->
	
	<c:forEach var="user" items="${listUser}">
	
	<script>
		console.log("${user.username}");
		console.log("comes here");
	</script>

	<tr>
		<td>
			<c:out value="${user.username}" />
		</td>
		
		<td>
			<c:out value="${user.password}" />
		</td>

		<td>
			<c:out value="${user.email}" />
		</td>

		<td>
			<c:out value="${user.language}" />
		</td>

		<td>
			<a href="edit?id=<c:out value='${user.username}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.username}' />">Delete</a>
		</td>
	</tr>
	</c:forEach>

<!-- } -->
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>