<%@ page import="java.sql.*" %>
<html>
<head>
<title>AJAX Example 1</title>
<script type="text/javascript">
var ajaxreq;
function getdata()
{
ajaxreq=new XMLHttpRequest();
ajaxreq.onreadystatechange=processresponse;
var empno=document.getElementById("empid").value;
var reqstr="getempdetails.jsp?eno="+empno;
ajaxreq.open("GET",reqstr,true);
ajaxreq.send(null);
}
function processresponse()
{

if(ajaxreq.readyState===4)
{
var res=document.getElementById("result");
var ans=ajaxreq.responseText;
res.innerHTML=ans;
}
}
</script>
</head>
<body bgcolor="#ff8888">
<center>

<%
try
{
Class.forName("oracle.jdbc.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//MEGHA-GOYAL:1521/XE","project","assignment");
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery("Select empno from emp");
out.println("<b>Select employee ID:</b><select id='empid' onchange='getdata()' >");
while(rs.next())
{
int empid=rs.getInt(1);
out.println("<option value="+empid+">"+ empid +"</option>");

}
conn.close();
}
catch(Exception ex)
{
out.println("<h2>Some error occurred</h2>");
}
%>
</select>
<div id="result"></div>
</center>
</body>
</html>
