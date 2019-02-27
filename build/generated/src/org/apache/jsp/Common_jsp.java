package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Common_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"MyErrorPage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <style type=\"text/css\"> \n");
      out.write("            .profile{\n");
      out.write("                border:1px solid blue; width:100%; align:center;\n");
      out.write("              /*  margin:0.2%;\n");
      out.write("                padding:0.2%;*/\n");
      out.write("              /*  float:left;*/\n");
      out.write("                background: #0199d9  \n");
      out.write("            }\n");
      out.write("            .titleH1{\n");
      out.write("                color:white;\n");
      out.write("                top:auto;\n");
      out.write("                font-size: 30pt\n");
      out.write("            }\n");
      out.write("            #header1{\n");
      out.write("                width:81%; align:center;\n");
      out.write("                margin:0.2%;\n");
      out.write("                height:30%;\n");
      out.write("                float:right;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    <div class = \"profile\">\n");
      out.write("        <a href = \"http//:www.bdu.edu.et\"><img src=\"img/bdu.bmp\" width=\"11%\" alt=\"profile image\" ></a>\n");
      out.write("        <div id=\"header1\">\n");
      out.write("            <h1 class=\"titleH1\">&nbsp;&nbsp;&nbsp;&nbsp;  Bahir Dar Technology Institute<br>\n");
      out.write("                Students Clearance Management System</h1>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</head>\n");
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
