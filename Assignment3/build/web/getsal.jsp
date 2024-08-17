<%@ page import="java.sql.*" %>
<%
try
{
response.setDateHeader("Expires",-1);
Class.forName("oracle.jdbc.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//MEGHA-GOYAL:1521/XE","project","assignment");
PreparedStatement ps=conn.prepareStatement("Select sal from emp where ename=?");
String ename=request.getParameter("name");
System.out.println("Ename:"+ename);
ps.setString(1,ename);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
	int sal=rs.getInt(1);
	out.println("Salary is "+sal);
}
else

        out.println("No record of emp <b>"+ename+"</b> found");

}
catch(Exception ex)
{
out.println("Server error:");
System.out.println("Error Details:"+ex);
}
%>