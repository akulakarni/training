<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,tr,td,th{
border:1px solid blue;}</style>
</head>
<body>
<h1>Employee List</h1>
<table><tr><th>Name</th><th>Salary</th><th>Designation</th></tr>
<c:forEach items="${employees}" var="emp">
<tr><td>${emp.name}</td><td>${emp.salary}</td><td>${emp.designation}</td></tr>
    
    </c:forEach>

</table>
<a href="adduser">Add New Employee</a>
</body>
</html>