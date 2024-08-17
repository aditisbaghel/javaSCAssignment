<%@ page import="java.sql.*" %>
<%!
    PreparedStatement ps;
    %>
<%
response.setDateHeader("Expires",-1);
try
{
System.out.println("Request received");
Class.forName("oracle.jdbc.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-8COBE3LT:1521/xe","project","assignment");
ps=conn.prepareStatement("Select username  from register where username=?");
String uname=request.getParameter("uname");
ps.setString(1,uname);
ResultSet rs=ps.executeQuery();
if(rs.next())
	out.println("fail");
else
{
       String pwd=request.getParameter("pwd");
       String uid=request.getParameter("uid");
       ps.setString(1,uname);
       ps.setString(2, pwd);
       ps.setString(3,uid);
       int count=ps.executeUpdate();
       System.out.println("Rows Effected"+count);
	out.println("pass");
}
}
catch(Exception ex)
{
out.println("Server error:"+ex.getMessage());
System.out.println("Error Details:"+ex);
}
%>