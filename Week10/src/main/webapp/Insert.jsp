<%@ page import="com.prokarma.week10.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
</head>
<body>
<%
		DBConnectionManager connectionManager = (DBConnectionManager) getServletContext().getAttribute("DBManager");
		Connection connection=connectionManager.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement("insert into TaskList values (?,?,?,?,?,?)");
			preparedStatement.setString(1, request.getParameter("mtitle"));
			preparedStatement.setString(2, request.getParameter("mdescription"));
			preparedStatement.setString(3, request.getParameter("massignee"));
			preparedStatement.setString(4, request.getParameter("ehours"));
			preparedStatement.setString(5, request.getParameter("startdate"));
			preparedStatement.setString(6, request.getParameter("enddate"));
			preparedStatement.execute();
			connection.commit();
		    response.sendRedirect("TaskList.jsp");
			
		  /*   
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/LoginPage.jsp");
			out.println("<font color=green>Registration successfull, please login below.</font>");
			rd.include(request, response); */
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new ServletException("DB Connection problem.");
		}finally{
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
%>
</body>
</html>