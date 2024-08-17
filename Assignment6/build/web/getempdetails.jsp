<%@ page import="java.sql.*" %>
<%
response.setDateHeader("Expires",-1);
try
{
Class.forName("oracle.jdbc.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//MEGHA-GOYAL:1521/XE","project","assignment");
PreparedStatement ps=conn.prepareStatement("Select ename,sal,deptno from emp where empno=?");
int empno=Integer.parseInt(request.getParameter("eno"));
ps.setInt(1,empno);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
	String ename=rs.getString(1);
	int sal=rs.getInt(2);
	int dep=rs.getInt(3);
        out.println("<table border='2' style='margin-top:20px';>");
	out.println("<tr><td><b>Name :</b></td><td>"+ename+"</td></tr>");
	out.println("<tr><td><b>Salary :</b></td><td>"+sal+"</td></tr>");
	out.println("<tr><td><b>Dept Number :</b></td><td>"+dep+"</td></tr>");
	out.println("<tr><td><b>Emp no:</b></td><td>"+empno+"</td></tr>");
        out.println("</table>");
}
else
{
	out.println("No record of emp "+empno+" found!");
}
}
catch(Exception ex)
{
out.println("Server error:");
System.out.println("Error Details:"+ex);
}
%>