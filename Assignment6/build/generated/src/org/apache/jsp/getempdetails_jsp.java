package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class getempdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

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

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
