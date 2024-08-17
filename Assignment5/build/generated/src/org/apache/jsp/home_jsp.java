package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>AJAX Example 1</title>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("var ajaxreq;\n");
      out.write("function getdata()\n");
      out.write("{\n");
      out.write("ajaxreq=new XMLHttpRequest();\n");
      out.write("ajaxreq.onreadystatechange=processresponse;\n");
      out.write("var empno=document.getElementById(\"empid\").value;\n");
      out.write("var reqstr=\"getdetails.jsp?eno=\"+empno;\n");
      out.write("ajaxreq.open(\"GET\",reqstr,true);\n");
      out.write("ajaxreq.send(null);\n");
      out.write("}\n");
      out.write("function processresponse()\n");
      out.write("{\n");
      out.write("\n");
      out.write("if(ajaxreq.readyState===4)\n");
      out.write("{\n");
      out.write("var res=document.getElementById(\"result\");\n");
      out.write("var ans=ajaxreq.responseText;\n");
      out.write("res.innerHTML=ans;\n");
      out.write("}\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"#ff8888\">\n");
      out.write("<center>\n");
      out.write("\n");

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

      out.write("\n");
      out.write("</select>\n");
      out.write("<div id=\"result\"></div>\n");
      out.write("</center>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
