package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html> \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/StyleOne.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .loginform{\n");
      out.write("                border:1px solid blue;\n");
      out.write("                left: calc(10% - 100px); \n");
      out.write("                width:84%;\n");
      out.write("                top: 0px;       \n");
      out.write("                line-height: 8px;\n");
      out.write("                top: calc(40% - 60px);\n");
      out.write("                left: calc(18% - 100px);\n");
      out.write("            }\n");
      out.write("            #failMsg{\n");
      out.write("                border:0px solid blue;\n");
      out.write("                height: 20px;\n");
      out.write("                width: 135%;\n");
      out.write("                font-size: 18px;               \n");
      out.write("                color: red;\n");
      out.write("            } \n");
      out.write("            .aaa a{\n");
      out.write("                color:#5bc0de;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            #yesMsg{\n");
      out.write("                color:green;\n");
      out.write("            }\n");
      out.write("            .icon{\n");
      out.write("                float: left\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style = \"background-color:#DFE2DB;color:black;\">\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"navbar navbar-fixed-top\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Common.jsp", out, false);
      out.write("\n");
      out.write("                <div class=\"aaa\">\n");
      out.write("                    <a href=\"index.jsp\" value=\"Home\">Home</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>         \n");
      out.write("        <br><br><br><br><br><br><br>\n");
      out.write("        &nbsp;&nbsp;&nbsp;<center>\n");
      out.write("        <section  class=\"loginform\"><br><!-- id=\"header\"-->\n");
      out.write("            <!-- <a href=\"/other.jsp\" class=\"lo\" name=\"home\">Home</a>-->\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"col-md-offset-3 col-md-6\">\n");
      out.write("                    <br><br><br>\n");
      out.write("                    <h2 >Login</h2>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                        <form name=\"login\" class=\"loginform2\"  method=\"post\" action=\"loginServlet\">\n");
      out.write("                            <!--User Email-->\n");
      out.write("                            <div id=\"failM\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msgS}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <!--label for=\"email\">Email</label-->\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"email\" id=\"email\" placeholder=\"Enter Your Email\" data-rule=\"email\" data-msg=\"Please enter a valid email\" />\n");
      out.write("                                <div class=\"validation\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <!---/Email-->\n");
      out.write("                            <!-- password-->\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <!--label>Password</label-->\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Enter Your Password\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <!--/password-->\n");
      out.write("                            <div id=\"failMsg\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"yesMsg\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${yesMsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <br> <br> <br>\n");
      out.write("                            <input type=\"submit\" class=\"lo\" name=\"login\"value=\"Login\"/>\n");
      out.write("                            &nbsp; <input type=\"reset\" class=\"lo\" value=\"Reset\"/>\n");
      out.write("                            <br><br><br><br><br>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section><br><br></center>\n");
      out.write("    <div class=\"loc\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("    </div>\n");
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
