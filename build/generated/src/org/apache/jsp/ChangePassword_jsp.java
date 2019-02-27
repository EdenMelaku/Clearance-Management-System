package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class ChangePassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  public String getServletInfo() {
    return "true";
  }


                String username=null;
                
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
      out.write("                width:80.2%;\n");
      out.write("                top: 0px;       \n");
      out.write("                line-height:12px;\n");
      out.write("                top: calc(40% - 60px);\n");
      out.write("                left: calc(18% - 100px);\n");
      out.write("            }\n");
      out.write("            #failMsg{\n");
      out.write("                height: 20px;\n");
      out.write("                font-size: 15px;               \n");
      out.write("                color: red;\n");
      out.write("            } \n");
      out.write("            #yesMsg{\n");
      out.write("                color:green;\n");
      out.write("            }\n");
      out.write("            .icon{\n");
      out.write("                float: left\n");
      out.write("            }\n");
      out.write("            .changepass{\n");
      out.write("                color: black;\n");
      out.write("                padding-right: 12px;\n");
      out.write("                padding-left: 10px;\n");
      out.write("                width: 240px;\n");
      out.write("            }\n");
      out.write("            #failMsg2{\n");
      out.write("                color: red\n");
      out.write("            }#Msg{\n");
      out.write("\n");
      out.write("                color: green\n");
      out.write("\n");
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
      out.write("                <div>\n");
      out.write("                    <a href=\"index.jsp\" value=\"Home\">Home</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                ");
      out.write("\n");
      out.write("        ");

             username = (String) request.getAttribute("username");
        
      out.write("\n");
      out.write("        <br><br><br><br><br><br><br>\n");
      out.write("        &nbsp;&nbsp;&nbsp;<center>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"col-md-offset-3 col-md-6\">\n");
      out.write("                <br>\n");
      out.write("                <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                    <form method=\"post\" action=\"changePasswordServlet\">\n");
      out.write("                        <section  class=\"changepass\">\n");
      out.write("                            <br>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"hidden\" name=\"username\" value=");
      out.print( username);
      out.write(">\n");
      out.write("                                <input type=\"password\"class=\"form-control\" name=\"oldpass\" placeholder=\"Enter Your Old Password\"><br>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\"class=\"form-control\" name=\"newpass1\" placeholder=\"Enter Your New Password\"><br>\n");
      out.write("                            </div>                                <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"newpass2\" placeholder=\"Confirm Your New Password\"><br>\n");
      out.write("                            </div>         \n");
      out.write("                            <div id=\"Msg\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </div><div id=\"failMsg2\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${failMsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </div><br>\n");
      out.write("                            <input type=\"submit\" class=\"changePassword\" name=\"passchange\"value=\"Submit\" >&nbsp;&nbsp; <input type=\"reset\" class=\"changePassword\" name=\"passchange\" value=\"Cancel\">\n");
      out.write("                        </section>\n");
      out.write("                    </form>   \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section><br><br></center>\n");
      out.write("<div class=\"loc\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("</div>\n");
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
