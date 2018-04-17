<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<fieldset><legend>Add Employee</legend>
<form action="allusers" method="post">
<label width="60px">Name : </label><input type="text" name="name"><br>
<label width="60px">Salary : </label><input type="number" name="salary"><br>
<label width="60px">Designation : </label><input type="text" name="designation"><br>
<input type="submit" value="Save"> <a href="users">click to view employees</a>
</form>
</fieldset>
</body>
</html>