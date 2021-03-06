<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page isELIgnored="false" %>  --%>
<html>
<head>
	<title>Employees List</title>
</head>
<body>
	<center>
		<h1>Employees List</h1>
	</center>
	<table align="center" cellspacing="5px" cellpadding="5%" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Designation</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="Employee" items="${list}">
			<tr>
				<td>${Employee.id}</td>
				<td>${Employee.name}</td>
				<td>${Employee.salary}</td>
				<td>${Employee.designation}</td>
				<td><a href="getEmp/${Employee.id}">Edit</a></td>
				<td><a href="deleteEmp/${Employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="addEmployee" align="center">Add New Employee</a>
</body>
</html>