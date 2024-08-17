<%@ page import="java.sql.*" %>
<%
response.setDateHeader("Expires",-1);
try
{
System.out.println("Request received");
Class.forName("oracle.jdbc.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//sachin-pc:1521/orcl","scott","tiger");
PreparedStatement ps=conn.prepareStatement("Select username  from allusers where username=?");
String uname=request.getParameter("username");
ps.setString(1,uname);
ResultSet rs=ps.executeQuery();
if(rs.next())
	out.println("fail");
else
	out.println("pass");
}
catch(Exception ex)
{
out.println("Server error:");
System.out.println("Error Details:"+ex);
}
%>