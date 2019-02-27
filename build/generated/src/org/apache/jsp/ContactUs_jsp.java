package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class ContactUs_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			null, true, 8192, true);
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Contact Us</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/StyleOne.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #name{\n");
      out.write("                size: 20%;\n");
      out.write("            }.container{\n");
      out.write("                position: absolute;\n");
      out.write("                top: calc(23% - 35px);\n");
      out.write("                left: calc(30% - 242px);\n");
      out.write("                width: 80%;\n");
      out.write("            }\n");
      out.write("            #name{\n");
      out.write("                width:45%;\n");
      out.write("            }#email{\n");
      out.write("                width:45%;\n");
      out.write("            }\n");
      out.write("            #imga{                top: calc(53% - 35px);\n");
      out.write("                left: calc(30% - 242px);\n");
      out.write("\n");
      out.write("                width:90;\n");
      out.write("                float:left\n");
      out.write("                    \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body style = \"background-color:#DFE2DB ;color:black;\">\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"navbar navbar-fixed-top\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Common.jsp", out, false);
      out.write("\n");
      out.write("                <div>\n");
      out.write("                    <a href=\"index.jsp\" value=\"Home\">Home</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>      \n");
      out.write("\n");
      out.write("        <div class=\"container\" id=\"contactBound\">\n");
      out.write("\n");
      out.write("            <center> <h2>Contact us</h2></center>\n");
      out.write("\n");
      out.write("            <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                If You Have any Comment or Question Regarding this System usage we are ready to fix it\n");
      out.write("                <form action=\"/MessageServlet\" name=\"contact\" method=\"post\" role=\"form\" class=\"contactForm\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"text\" name=\"name\" class=\"form-control\" id=\"name\" placeholder=\"Your Name\" data-rule=\"maxlen:4\" data-msg=\"Please enter at least 4 chars\" />\n");
      out.write("\n");
      out.write("                        <input type=\"email\" class=\"form-control\" name=\"email\" id=\"email\" placeholder=\"Your Email\" data-rule=\"email\" data-msg=\"Please enter a valid email\" />\n");
      out.write("                        <div class=\"validation\"></div>\n");
      out.write("\n");
      out.write("                        <label for=\"subject\">Subject</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"subject\" id=\"subject\" placeholder=\"Subject\" data-rule=\"maxlen:4\" data-msg=\"Please enter at least 8 chars of subject\" />\n");
      out.write("                        <div class=\"validation\"></div>\n");
      out.write("\n");
      out.write("                        <label for=\"message\">Message</label>\n");
      out.write("                        <textarea class=\"form-control\" name=\"message\" rows=\"\" data-rule=\"required\" data-msg=\"Please write something for us\"></textarea>\n");
      out.write("                        <div class=\"validation\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\"  class=\"button\" >SEND MESSAGE</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n");
      out.write("        <div id=\"imga\">\n");
      out.write("            <img src=\"img/phone.png\" width=\"18%\" alt=\"profile image\" >0947416048[EDEN]\n");
      out.write("        </div> \n");
      out.write("<div id=\"imga\">\n");
      out.write("            <img src=\"img/phone.png\" width=\"18%\" alt=\"profile image\" >0914673987[ROBEL]\n");
      out.write("        </div> \n");
      out.write("        <div class=\"loc\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("        </div>  \n");
      out.write("    </body>\n");
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
