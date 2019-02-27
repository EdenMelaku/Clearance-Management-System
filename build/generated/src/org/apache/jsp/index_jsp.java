package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  public String getServletInfo() {
    return "true";
  }

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
      			"MyErrorPage.jsp", true, 10240, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>CMS</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/StyleOne.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("\n");
      out.write("            .linked{\n");
      out.write("                border:1px solid ; width:16%;height:48%; align:center;\n");
      out.write("                margin:0.2%;\n");
      out.write("                color:black;\n");
      out.write("                height:420px;\n");
      out.write("                padding:0.2%;\n");
      out.write("                top: 22%;position: absolute;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            .stulink{\n");
      out.write("                color:black;\n");
      out.write("                font-size: 15pt;\n");
      out.write("            }\n");
      out.write("            .linked a{\n");
      out.write("                color: #5bc0de;\n");
      out.write("            }\n");
      out.write("            .linked a:hover {\n");
      out.write("                /**background-color: #00c6ff;    */\n");
      out.write("                font-size: 18pt;\n");
      out.write("                color:blue;\n");
      out.write("            }\n");
      out.write("            .bod{\n");
      out.write("                border:1px solid blue; width:72%;\n");
      out.write("                margin:0.2%;                \n");
      out.write("                color:black;\n");
      out.write("                height:420px;\n");
      out.write("                padding:0.2%;\n");
      out.write("                float: right;\n");
      out.write("                left: 20%;\n");
      out.write("                top: 22%;position: absolute;\n");
      out.write("            } \n");
      out.write("            #included{\n");
      out.write("                /* border:1px solid blue; */\n");
      out.write("                color:black;\n");
      out.write("                height:133px;\n");
      out.write("                float: right;\n");
      out.write("                position: absolute;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"included\" class=\"navbar navbar-fixed-top\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Common.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class = \"bod\">\n");
      out.write("            <h1>Students Clearance Management System </h1>\n");
      out.write("            <a class=\"navbar-brand\"a href=\"Login.jsp\">LOGIN\n");
      out.write("            </a>\n");
      out.write("            <hr>\n");
      out.write("            <pre>  \n");
      out.write("<h4 class=\"ttext\"> \n");
      out.write("                1. The Password initially Given is your last name 123 and hash tag<br>\n");
      out.write("                2. If you want to have a healthy relationship with the university,it is very important to the student <br>\n");
      out.write("                to complete this clearance properly and return the university registrar before you leave the university <br>\n");
      out.write("                campus whatever reason may be. Only with the paper termination below can official transcripts,<br>\n");
      out.write("                letter of enrollment, student copy or honorable dismissal be issued. Re admission to any unit of the<br> \n");
      out.write("                university will be considered only if proper termination is certified by the university registrar.\n");
      out.write("</h4>\n");
      out.write("            </pre> <br>\n");
      out.write("        </div>\n");
      out.write("        <div class = \"linked\">\n");
      out.write("            <ul><div class=\"stulink\">\t\t\n");
      out.write("                    <hr>\n");
      out.write("                    <!--li--><a href=\"StudentIntermidateServlet2\">Student</a><!--/li--><hr>\n");
      out.write("                    <!--li--><!--a href=\"ContactUs.jsp\">Contact Us</a><!--/li-->\n");
      out.write("                </div>       \n");
      out.write("            </ul></div> \n");
      out.write("        <div class=\"loc\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
