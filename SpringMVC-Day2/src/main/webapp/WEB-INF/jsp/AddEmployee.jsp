<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form modelAttribute="Employee" action="save" method="post">
<table>
<tr><label>Id:</label>
<input type="number" name="id"><br></tr>
<tr><label>Name:</label>
<input type="text" name="name"><br></tr>
<tr><label>Salary:</label>
<input type="number" name="salary"><br></tr>
<tr><label>Designation:</label>
<input type="text" name="designation"><br></tr>
<input type="submit" name="save" value="save">
</form>
</table>
</body>
</html>