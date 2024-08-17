<%@ page import="java.sql.*" %>
<%
try
{
response.setDateHeader("Expires",-1);
Class.forName("oracle.jdbc.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//MEGHA-GOYAL:1521/XE","project","assignment");
PreparedStatement ps=conn.prepareStatement("Select empno,sal,deptno from emp where ename=?");
String ename=request.getParameter("name");
System.out.println("Ename:"+ename);
ps.setString(1,ename);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
	int empno=rs.getInt(1);
        double sal=rs.getDouble(2);
        String deptno=rs.getString(3);
	out.println("<table border='2' style='margin-top:20px'>");
        out.println("<tr><th>EMPNO</th><td>"+empno+"</td></th>");
        out.println("<tr><th>ENAME</th><td>"+ename+"</td></th>");
        out.println("<tr><th>SALARY</th><td>"+sal+"</td></th>");
        out.println("<tr><th>JOB</th><td>"+deptno+"</td></th>");
        out.println("</table>");
        
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