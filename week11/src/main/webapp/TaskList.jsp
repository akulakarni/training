<%@ page import="com.prokarma.week11.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>

</head>
<body>
<form method="post" action="TaskList.jsp">
  <h1 align="center" style="float:center">Task List</h1>
        <table border="green" id="myTable" align="center">
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Assignee</th>
                <th>Estimated Hours</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Select</th>
            </tr>
            <%
try{ 
DBConnectionManager connectionManager = (DBConnectionManager) getServletContext().getAttribute("DBManager");
Connection connection=connectionManager.getConnection();
Statement statement=connection.createStatement();
String sql ="Select * from TaskList";

ResultSet resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString(1) %></td>
<td><%=resultSet.getString(2) %></td>
<td><%=resultSet.getString(3) %></td>
<td><%=resultSet.getInt(4) %></td>
<td><%=resultSet.getDate(5) %></td>
<td><%=resultSet.getDate(6) %></td>
<td><input type="radio" name="abc"></td>
</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
           
%>
</table>
       
          
          <a href="AddTask.jsp">Add</a>
             
       
        </form>
        </body>
   

</html>