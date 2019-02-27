package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.read;
import clearance_management.UserBean;
import classes.*;
import model.Test;

public final class Master_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  public String getServletInfo() {
    return "true";
  }


        String username;
        String pass;
        Object o;
        public String[] userData;
        read r;
                                                                                                                                                                                                                    
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
      out.write("<head> \n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("    <title>CMS</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/StyleOne.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/my_style.css\"/>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        #b{\n");
      out.write("            overflow:scroll;   \n");
      out.write("        }\n");
      out.write("        .bod{\n");
      out.write("            border:0px solid blue; width:45.2%; align:center;\n");
      out.write("            margin:0.2%;\n");
      out.write("            padding:0.2%;\n");
      out.write("            float: left;\n");
      out.write("\n");
      out.write("        }  \n");
      out.write("        #searchIt{\n");
      out.write("            top: calc(15% - 35px);\n");
      out.write("            left: calc(10% - 243px);\n");
      out.write("        }\n");
      out.write("        #userName{\n");
      out.write("            background-color: #428bca;\n");
      out.write("            float: right;\n");
      out.write("            height: 70px;\n");
      out.write("            font-size: 25px;\n");
      out.write("            font-family: times new roman;\n");
      out.write("            width: 27%;\n");
      out.write("            color:white;\n");
      out.write("            text-transform: capitalize\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .bod2{\n");
      out.write("            border:0px solid blue; width:45.2%; align:center;\n");
      out.write("            padding-right: 70px;\n");
      out.write("            padding-left: 0px;\n");
      out.write("            float: right;\n");
      out.write("        }  \n");
      out.write("        #logoutLink{\n");
      out.write("            font-size: 20px;\n");
      out.write("        }\n");
      out.write("        .msgBox{\n");
      out.write("            border:0px solid #080808; width:50%; align:center;\n");
      out.write("            top: calc(35% - 60px);\n");
      out.write("            left: calc(27% - 100px);\n");
      out.write("            height: 50%;\n");
      out.write("            padding: 5px;\n");
      out.write("            position: fixed;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function logout() {\n");
      out.write("            window.location = \"Login.jsp\";\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body style = \"background-color:#DFE2DB;color:black;\">\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <div class=\"navbar navbar-fixed-top\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Common.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
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
      out.write("    ");

        username = (String) request.getAttribute("username");
        pass = request.getParameter("password");

    
      out.write("\n");
      out.write("\n");
      out.write("    ");
        read r = new read();
        userData = r.getUserData(username, pass);
        bean.setUsername(userData[0]);
        bean.setFirstName(userData[1]);
        bean.setLastName(userData[2]);
        bean.setPassword(userData[3]);
        bean.setOffice(userData[4]);
        bean.setUserRole(userData[5]);
        bean.setDepartment(userData[6]);
        bean.setYear(Integer.parseInt(userData[7]));
        bean.setProgram(userData[8]);
        bean.setSection(userData[9]);
        bean.setAccountStatus(Integer.parseInt(userData[10]));
    
      out.write("\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"menu\">\n");
      out.write("        <ul class=\"widget-container\"><li id=\"text-15\" class=\"widget widget_text\"><h3 class=\"widgettitle\">Menu</h3>\t\t\n");
      out.write("                <div class=\"textwidget\"><ul>\n");
      out.write("                        ");
 if (bean.getUserRole().toLowerCase().equals("advisor")) {
      out.write("\n");
      out.write("                        <li> \n");
      out.write("                            <a href=\"initiateClearance1?username=");
      out.print(bean.getUsername());
      out.write("&amp; userRole=");
      out.print(bean.getUserRole());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                Initiate Clearance</a> </li>              \n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                                ");
 if (bean.getUserRole().toLowerCase().equals("privileged_user") || bean.getUserRole().toLowerCase().equals("advisor")) {
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"ApproveClearanceFilterServlet?username=");
      out.print( bean.getUsername());
      out.write("\" >\n");
      out.write("                                Approve Clearance Status</a></li>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                                ");
 if (bean.getOffice().toLowerCase().equals("sport master") || bean.getOffice().toLowerCase().equals("library") || bean.getOffice().toLowerCase().equals("faculty store")| bean.getOffice().toLowerCase().equals("housing office") | bean.getOffice().toLowerCase().equals("student cafe") && bean.getUserRole().equals("privileged_user")) {
      out.write("            \n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"HoldClearanceServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                Hold Clearance </a></li> \n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"release_clearance_servlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                Release Clearance</a></li>   \n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                                ");
 if (bean.getUserRole().toLowerCase().equals("master_user")) {
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"getofficeStatusServlet?username=");
      out.print(bean.getUsername());
      out.write("\">\n");
      out.write("                                Get Office Status</a></li>\n");
      out.write("                                ");
}
      out.write(" \n");
      out.write("                                ");
 if (bean.getUserRole().equals("master_user") || bean.getUserRole().equals("system_admin")) {
      out.write("\n");
      out.write("                        <li>   <a href= \"ManageAccountServlet?username=");
      out.print(bean.getUsername());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                Manage An Account</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"createAccountServlet1?username=");
      out.print(bean.getUsername());
      out.write("\"accesskey=\"1\" title=\"\">\n");
      out.write("                                Create An Account</a></li>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                                ");
 if (bean.getUserRole().toLowerCase().equals("advisor")) {
      out.write("\n");
      out.write("                        <li><a href=\"GetStudentStatusServlet?username=");
      out.print(bean.getUsername());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                Get Student Status</a>  </li>\n");
      out.write("                                ");
}
      out.write(" \n");
      out.write("                                ");
 if (bean.getOffice().toLowerCase().equals("student cafe")) {
      out.write("\n");
      out.write("                      <!--  <li><a href=\"filterStudentsForNONCAFEservlet?username=");
      out.print(bean.getUsername());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                Register Non Cafe</a>  </li>\n");
      out.write("-->\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        ");
 if (bean.getOffice().toLowerCase().equals("dean office")) {
      out.write("\n");
      out.write("                        <li><a href=\"FilterForActivateClearanceServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                Activate Student</a></li>\n");
      out.write("                        <li><a href=\"FilterForDeactivateClearanceServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                Deactivate Student</a></li>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        ");
 if (bean.getOffice().toLowerCase().equals("registrar")) {
      out.write("\n");
      out.write("\n");
      out.write("                        <li><a href=\"RegistrarServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                Generate Clearance</a></li>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                        <li>  \n");
      out.write("                            <a href=\"ChangePasswordServlet2?username=");
      out.print( bean.getUsername());
      out.write("\">\n");
      out.write("                                Change Password</a></li>\n");
      out.write("                        <li>  \n");
      out.write("                            <a href=\"logoutServlet\">\n");
      out.write("                                Logout(");
      out.print(bean.getFirstName().toUpperCase());
      out.write(")</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    <br><br><br><br><br><br><br>\n");
      out.write("    <div id=\"userName\" class=\"widget-container\">\n");
      out.write("        &nbsp;");
      out.print( bean.getFirstName().toUpperCase());
 out.println(" ");
      out.print( bean.getLastName().toUpperCase());
      out.write("\n");
      out.write("        <br> &nbsp; &nbsp;   ");
      out.print( bean.getOffice());
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"msgBox\">\n");
      out.write("        <!--center><h1>Welcome To Cms BIT</h1></center>\n");
      out.write("        <h2>Recommendation</h2-->\n");
      out.write("        <hr>\n");
      out.write("        <h2>\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </h2>\n");
      out.write("        <hr>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"loc\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>");
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
