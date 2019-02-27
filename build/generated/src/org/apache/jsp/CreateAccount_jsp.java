package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.read;
import javax.swing.JOptionPane;
import clearance_management.UserBean;
import classes.*;
import model.Test;

public final class CreateAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  public String getServletInfo() {
    return "true";
  }


            public String[] departments;
            public String rolePre;
            public String officePre;
        
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
      			null, true, 10240, true);
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
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head> \n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <title>CMS</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/StyleOne.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/my_style.css\">\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #b{\n");
      out.write("                overflow:scroll;   \n");
      out.write("            }\n");
      out.write("            .menu{\n");
      out.write("                float: top;\n");
      out.write("                background-color: #0199d9\n");
      out.write("            }\n");
      out.write("            .lo{\n");
      out.write("                color:green;\n");
      out.write("                height: 40px;\n");
      out.write("                line-height: 30px;\n");
      out.write("                padding-right: 12px;\n");
      out.write("                padding-left: 20px;\n");
      out.write("                /**    text-transform: uppercase;*/\n");
      out.write("                font-size: 18px; \n");
      out.write("            }\n");
      out.write("            .homeBtn{\n");
      out.write("                float: right;\n");
      out.write("                color:red;\n");
      out.write("                font-size:30px;\n");
      out.write("                position: absolute;\n");
      out.write("                top: calc(130% - 35px);\n");
      out.write("                left: calc(138% - 600px);\n");
      out.write("            }\n");
      out.write("            #prosel{\n");
      out.write("                width: 40%;\n");
      out.write("            }  #yearsel{\n");
      out.write("                width: 20%;\n");
      out.write("            }  #accChoice{\n");
      out.write("                width: 30%;\n");
      out.write("            }   #depsel{\n");
      out.write("                width: 40%;\n");
      out.write("            }\n");
      out.write("            #name{\n");
      out.write("                width:40%;\n");
      out.write("            }\n");
      out.write("            #secChoice{\n");
      out.write("                width:20%;\n");
      out.write("            } #emailChoice{\n");
      out.write("                width:40%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function getProgram() {\n");
      out.write("                var p = document.getElementById(prosel).value;\n");
      out.write("                alert(p);\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            function validate() {\n");
      out.write("                if (document.createForm.firstname.value.length <= 1)\n");
      out.write("                {\n");
      out.write("                    alert(\"Please provide your name!\");\n");
      out.write("                    document.createForm.firstname.focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (document.createForm.EMail.value == \"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"Please provide your Email!\");\n");
      out.write("                    document.createForm.EMail.focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (document.createForm.Zip.value == \"\" ||\n");
      out.write("                        isNaN(document.myForm.Zip.value) ||\n");
      out.write("                        document.createForm.Zip.value.length != 5)\n");
      out.write("                {\n");
      out.write("\n");
      out.write("                    alert(\"Please provide a zip in the format #####.\");\n");
      out.write("                    document.myForm.Zip.focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (document.myForm.Country.value == \"-1\")\n");
      out.write("                {\n");
      out.write("                    alert(\"Please provide your country!\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                return(true);\n");
      out.write("            }\n");
      out.write("            function accountChoice() {\n");
      out.write("                var f = document.getElementById(\"accChoice\").value;\n");
      out.write("                if (f == \"department head\") {\n");
      out.write("                    document.getElementById(\"prosel\").disabled = true;\n");
      out.write("                    document.getElementById(\"depsel\").disabled = false;\n");
      out.write("                    document.getElementById(\"yearsel\").disabled = true;\n");
      out.write("                    document.getElementById(\"secChoice\").disabled = true;\n");
      out.write("                } else if (f == \"faculty store\") {\n");
      out.write("                    document.getElementById(\"prosel\").disabled = true;\n");
      out.write("                    document.getElementById(\"depsel\").disabled = true;\n");
      out.write("                    document.getElementById(\"yearsel\").disabled = true;\n");
      out.write("                    document.getElementById(\"secChoice\").disabled = true;\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"prosel\").disabled = false;\n");
      out.write("                    document.getElementById(\"depsel\").disabled = false;\n");
      out.write("                    document.getElementById(\"yearsel\").disabled = false;\n");
      out.write("                    document.getElementById(\"secChoice\").disabled = false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function check() {\n");
      out.write("                document.getElementById(\"prosel\").focus();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body style = \"background-color:#DFE2DB;color:black;\">\n");
      out.write("        <div class=\"navbar navbar-fixed-top\" role=\"navigation\" data-0=\"line-height:100px; height:100px; background-color:red ;\" data-300=\"line-height:60px; height:60px; background-color:red;\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Common.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"homeBtn\">\n");
      out.write("                <a href=\"index.jsp\" >Home</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      clearance_management.UserBean bean = null;
      synchronized (session) {
        bean = (clearance_management.UserBean) _jspx_page_context.getAttribute("bean", PageContext.SESSION_SCOPE);
        if (bean == null){
          bean = new clearance_management.UserBean();
          _jspx_page_context.setAttribute("bean", bean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("        ");

            departments = (String[]) request.getAttribute("department");
            if (bean.getOffice().equals("faculty")) {
                rolePre = "Advisor";
                officePre = "faculty";

            } else {
                rolePre = "privileged_user";
                officePre = (bean.getOffice());
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <ul class=\"widget-container\"><li id=\"text-15\" class=\"widget widget_text\"><h3 class=\"widgettitle\">Menu</h3>\t\t\n");
      out.write("                        <div class=\"textwidget\"><ul>\n");
      out.write("                                ");
 if (bean.getUserRole().toLowerCase().equals("advisor")) {
      out.write("\n");
      out.write("                                <li> \n");
      out.write("                                    <a href=\"initiateClearance1?username=");
      out.print(bean.getUsername());
      out.write("&amp; userRole=");
      out.print(bean.getUserRole());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                        Initiate Clearance</a> </li>              \n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        ");
 if (bean.getUserRole().toLowerCase().equals("privileged_user") || bean.getUserRole().toLowerCase().equals("advisor")) {
      out.write("\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"ApproveClearanceFilterServlet?username=");
      out.print( bean.getUsername());
      out.write("\" >\n");
      out.write("                                        Approve Clearance Status</a></li>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        ");
 if (bean.getOffice().toLowerCase().equals("sport master") || bean.getOffice().toLowerCase().equals("library") | bean.getOffice().toLowerCase().equals("housing office") | bean.getOffice().toLowerCase().equals("student cafe") && bean.getUserRole().equals("privileged_user")) {
      out.write("            \n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"HoldClearanceServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                        Hold Clearance </a></li> \n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"release_clearance_servlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                        Release Clearance</a></li>   \n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        ");
 if (bean.getUserRole().toLowerCase().equals("master_user")) {
      out.write("\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"getofficeStatusServlet?username=");
      out.print(bean.getUsername());
      out.write("\">\n");
      out.write("                                        Get Office Status</a></li>\n");
      out.write("                                        ");
}
      out.write(" \n");
      out.write("                                        ");
 if (bean.getUserRole().equals("master_user") || bean.getUserRole().equals("system_admin")) {
      out.write("\n");
      out.write("                                <li>   <a href= \"ManageAccountServlet?username=");
      out.print(bean.getUsername());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                        Manage An Account</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"createAccountServlet1?username=");
      out.print(bean.getUsername());
      out.write("\"accesskey=\"1\" title=\"\">\n");
      out.write("                                        Create An Account</a></li>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        ");
 if (bean.getUserRole().toLowerCase().equals("advisor")) {
      out.write("\n");
      out.write("                                <li><a href=\"GetStudentStatusServlet?username=");
      out.print(bean.getUsername());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                        Get Student Status</a>  </li>\n");
      out.write("                                        ");
}
      out.write(" \n");
      out.write("                              \n");
      out.write("                                ");
 if (bean.getOffice().toLowerCase().equals("dean office")) {
      out.write("\n");
      out.write("                                <li><a href=\"FilterForActivateClearanceServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                        Activate Student</a></li>\n");
      out.write("                                <li><a href=\"FilterForDeactivateClearanceServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                        Deactivate Student</a></li>\n");
      out.write("\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                                ");
 if (bean.getOffice().toLowerCase().equals("registrar")) {
      out.write("\n");
      out.write("                                <li><a href=\"..?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                        Student Status</a></li>\n");
      out.write("                                <li><a href=\"RegistrarServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                        Generate Clearance</a></li>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                <li>  \n");
      out.write("                                    <a href=\"ChangePasswordServlet2?username=");
      out.print( bean.getUsername());
      out.write("\">\n");
      out.write("                                        Change Password</a></li>\n");
      out.write("                                <li>  \n");
      out.write("                                    <a href=\"logoutServlet\">\n");
      out.write("                                        Logout(");
      out.print(bean.getFirstName().toUpperCase());
      out.write(")</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!----------Create Account---------------->\n");
      out.write("        <form name=\"createAccount\" name=\"createForm\" id=\"create\" class=\"createAccount\" action=\"createAccountServlet2\"onsubmit=\"return(validate());\" method=\"post\">\n");
      out.write("\n");
      out.write("            <legend>User Registration Form\n");
      out.write("                ");
 if (bean.getOffice().equals("faculty")) {
      out.write("\n");
      out.write("                &nbsp;  &nbsp;  &nbsp;<select  class=\"form-control\" name=\"accountType\" id=\"accChoice\" onclick=\"accountChoice()\">\n");
      out.write("                    <option value=\"advisor\">Advisor</option>\n");
      out.write("                    <option value=\"department head\">Department Head</option>\n");
      out.write("                    <option value=\"faculty store\">Faculty Store</option>\n");
      out.write("                </select>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </legend>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                &nbsp;  &nbsp;<input type=\"text\" class=\"form-control\" id=\"name\" name=\"firstname\" placeholder=\"Enter First Name\"> \n");
      out.write("                &nbsp;&nbsp; <input type=\"text\" class=\"form-control\"  id=\"name\" name=\"lastname\" placeholder=\"Enter Last Name\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                &nbsp;  &nbsp;\n");
      out.write("                ");
 if (bean.getOffice().equals("faculty")) {
      out.write("\n");
      out.write("                <select name=\"program\"  class=\"form-control\" id=\"prosel\">\n");
      out.write("                    <option>Select Program</option>\n");
      out.write("                    <option value=\"ur\">Undergraduate Regular</option>\n");
      out.write("                    <option value=\"us\">Undergraduate Summer</option>\n");
      out.write("                    <option value=\"ue\">Undergraduate Extension</option>\n");
      out.write("                    <option value=\"pr\">Postgraduate Regular</option>\n");
      out.write("                    <option value=\"ps\">Postgraduate Summer</option>\n");
      out.write("                </select>\n");
      out.write("                &nbsp;&nbsp;\n");
      out.write("                <select name=\"department\" class=\"form-control\"id=\"depsel\">\n");
      out.write("                    <option>Select the Department</option>\n");
      out.write("                    ");
 for (int i = 0; i < departments.length; i++) {
      out.write("\n");
      out.write("                    <option value=");
      out.print( departments[i]);
      out.write('>');
      out.print( departments[i]);
      out.write("</option>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                &nbsp;  &nbsp;  &nbsp;<select name=\"year\" class=\"form-control\"  id=\"yearsel\">\n");
      out.write("                    <option>Year</option>\n");
      out.write("                    <option value=\"1\">1</option>\n");
      out.write("                    <option value=\"2\">2</option>\n");
      out.write("                    <option value=\"3\">3</option>\n");
      out.write("                    <option value=\"4\">4</option>\n");
      out.write("                    <option value=\"5\">5</option>    \n");
      out.write("                    <option value=\"6\">6</option>\n");
      out.write("                    <option value=\"7\">7</option>\n");
      out.write("                    <option value=\"8\">8</option>\n");
      out.write("                </select>\n");
      out.write("                &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"section\" id=\"secChoice\" placeholder=\"Section\">\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                &nbsp;&nbsp;  &nbsp;<input type=\"email\" class=\"form-control\" name=\"email\" id=\"emailChoice\" placeholder=\"Enter Email Address\" data-rule=\"email\" data-msg=\"Please enter a valid email\" />\n");
      out.write("                <div class=\"validation\"></div>\n");
      out.write("            </div>\n");
      out.write("            <input type=\"hidden\" class=\"form-control\" value=");
      out.print( rolePre);
      out.write("  name=\"userrole\" placeholder=\"Advisor\" readonly>\n");
      out.write("            <input type=\"hidden\" name=\"creator\" value=");
      out.print( bean.getUsername());
      out.write(">\n");
      out.write("            <input type=\"hidden\" class=\"form-control\" value=");
      out.print( officePre);
      out.write("  name=\"office\" placeholder=\"Advisor\" readonly>\n");
      out.write("            <div id=\"failMsg\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </div> \n");
      out.write("            <div id=\"Msg\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msgSuc}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </div><BR>\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"submit\"class=\"lo\" name=\"createAccount\" value=\"SINE UP\" onclick=\"check()\"/>\n");
      out.write("            &nbsp;&nbsp;&nbsp; <input type=\"reset\"class=\"lo\" name=\"createAccount\" value=\"Cancel\"/>\n");
      out.write("        </form>\n");
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
