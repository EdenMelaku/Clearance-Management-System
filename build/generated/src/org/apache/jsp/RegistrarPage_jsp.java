package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clearance_management.user;
import model.read;
import javax.swing.JOptionPane;
import otherService.StudentClearanceInfo;

public final class RegistrarPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  public String getServletInfo() {
    return "true";
  }


            public String username;
        
 int num = 0;


            public String status(int stat) {
                String s = null;
                if (stat == 1) {
                    s = "not cleared";
                } else {
                    s = "cleared";
                }
                return s;
            }

            public String finalStatus(int sta) {
                String status = null;
                if (sta == 4) {
                    status = "started";
                } else if (sta == 3) {
                    status = "Advisor Remain";
                } else if (sta == 2) {
                    status = "Dh Remain";
                } else if (sta == 1) {
                    status = "Registrar";
                } else {
                    status = "Cleared";
                }
                return status;
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>CMS Student</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/StyleOne.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/my_style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/t.css\">\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #imga{\n");
      out.write("                width:90;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            .main{\n");
      out.write("                float: center;\n");
      out.write("            }\n");
      out.write("            .gene{\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .name{\n");
      out.write("                font-size: 30px;\n");
      out.write("                color:green;\n");
      out.write("            }\n");
      out.write("            .final{\n");
      out.write("                color:red;\n");
      out.write("                font-style: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            .form-wrapper2 button {\n");
      out.write("                padding: 5px;\n");
      out.write("                overflow: visible;\n");
      out.write("                position: relative;\n");
      out.write("                float: right;\n");
      out.write("                border: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                top: calc(40% - 50px);\n");
      out.write("                left: calc(2% - 50px);\n");
      out.write("\n");
      out.write("                cursor: pointer;\n");
      out.write("                height: 40px;\n");
      out.write("                width: 110px;\n");
      out.write("                font: bold 15px/40px 'lucida sans', 'trebuchet MS', 'Tahoma';\n");
      out.write("                color: #fff;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                background: #d83c3c;\n");
      out.write("\n");
      out.write("            }   \n");
      out.write("\n");
      out.write("            .form-wrapper2 button:hover{\t\t\n");
      out.write("                background: #e54040;\n");
      out.write("            }\t\n");
      out.write("\n");
      out.write("            .form-wrapper2 button:active,\n");
      out.write("            .form-wrapper button:focus{   \n");
      out.write("                background: #c42f2f;    \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-wrapper2 button:before {\n");
      out.write("                content: '';\n");
      out.write("                position: absolute;\n");
      out.write("                border-width: 8px 8px 8px 0;\n");
      out.write("                border-style: solid solid solid none;\n");
      out.write("                border-color: transparent #d83c3c transparent;\n");
      out.write("                top: calc(280% - 100px);\n");
      out.write("                left: calc(82% - 100px);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-wrapper2 button:hover:before{\n");
      out.write("                border-right-color: #e54040;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-wrapper2 button:focus:before{\n");
      out.write("                border-right-color: #c42f2f;\n");
      out.write("            }    \n");
      out.write("\n");
      out.write("            .form-wrapper2 button::-moz-focus-inner {\n");
      out.write("                border: 0;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style = \"background-color:#DFE2DB;color:black;\">\n");
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"navbar navbar-fixed-top\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Common.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"link_home\">\n");
      out.write("            <a href=\"index.jsp\" >Home</a>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            username = (String) request.getAttribute("username");
        
      out.write("\n");
      out.write("        ");

            StudentClearanceInfo stud = (StudentClearanceInfo) request.getAttribute("studInfo");
            String name = stud.getFirstName() + " " + stud.getLastName();
        
      out.write("\n");
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
      out.write("        <div class=\"main\"><!--  PdfServlet  -->\n");
      out.write("            <form class=\"form-wrapper cf\" method=\"post\" action=\"StudensRegistrarStatus\">\n");
      out.write("                <input type=\"text\" name=\"id\" placeholder=\"Search By Id Here...\" >\n");
      out.write("                <button type=\"submit\">Search</button>\n");
      out.write("            </form>\n");
      out.write("        </div>><br><br><br><br><br><br><br><br><br><br>\n");
      out.write("        <form class=\"form-wrapper2 cf\" method=\"post\" action=\"PdfServlet\">\n");
      out.write("            ");
num = stud.getFinalStatus();
      out.write("\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=");
      out.print( stud.getSID());
      out.write(" >\n");
      out.write("            <input type=\"hidden\" name=\"uname\" value=");
      out.print( username);
      out.write(" >\n");
      out.write("            <input type=\"hidden\" name=\"fsta\" value=");
      out.print( stud.getFinalStatus());
      out.write(" >\n");
      out.write("            <button type=\"submit\">Generate</button>\n");
      out.write("        </form>\n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <ul class=\"widget-container\"><li id=\"text-15\" class=\"widget widget_text\"><h3 class=\"widgettitle\">Menu</h3>\t\t\n");
      out.write("                    <div class=\"textwidget\"><ul>\n");
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"ApproveClearanceFilterServlet?username=");
      out.print( bean.getUsername());
      out.write("\" >\n");
      out.write("                                    Approve Clearance Status</a></li>\n");
      out.write("                                    ");
 if (bean.getOffice().toLowerCase().equals("sport master") || bean.getOffice().toLowerCase().equals("library") | bean.getOffice().toLowerCase().equals("housing office") | bean.getOffice().toLowerCase().equals("student cafe") && bean.getUserRole().equals("privileged_user")) {
      out.write("            \n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"HoldClearanceServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                    Hold Clearance </a></li> \n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"release_clearance_servlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                    Release Clearance</a></li>   \n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                    ");
 if (bean.getUserRole().toLowerCase().equals("master_user")) {
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"getofficeStatusServlet?username=");
      out.print(bean.getUsername());
      out.write("\">\n");
      out.write("                                    Get Office Status</a></li>\n");
      out.write("                                    ");
}
      out.write(" \n");
      out.write("                                    ");
 if (bean.getUserRole().equals("master_user") || bean.getUserRole().equals("system_admin")) {
      out.write("\n");
      out.write("                            <li>   <a href= \"ManageAccountServlet?username=");
      out.print(bean.getUsername());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                    Manage An Account</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"createAccountServlet1?username=");
      out.print(bean.getUsername());
      out.write("\"accesskey=\"1\" title=\"\">\n");
      out.write("                                    Create An Account</a></li>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                    ");
 if (bean.getOffice().toLowerCase().equals("registrar")) {
      out.write("\n");
      out.write("\n");
      out.write("                            <li><a href=\"RegistrarServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                    Generate Clearance</a></li>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                            <li>  \n");
      out.write("                                <a href=\"ChangePasswordServlet2?username=");
      out.print( bean.getUsername());
      out.write("\">\n");
      out.write("                                    Change Password</a></li>\n");
      out.write("                            <li>  \n");
      out.write("                                <a href=\"logoutServlet\">\n");
      out.write("                                    Logout(");
      out.print(bean.getFirstName().toUpperCase());
      out.write(")</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <form  class=\"student_status_table\">\n");
      out.write("            <div style=\"height:200px; overflow: auto\"> \n");
      out.write("                <table class=\"responsive-table1\">         \n");
      out.write("                    <!--     <caption>Student Status</caption>-->\n");
      out.write("                    <br>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>ID</th>\n");
      out.write("                            <th>Full Name</th>\n");
      out.write("                            <th>Cafe</th>\n");
      out.write("                            <th >Housing Office</th>\n");
      out.write("                            <th >Sport Master</th>\n");
      out.write("                            <th >Faculty Store</th>\n");
      out.write("                            <th>Library</th>\n");
      out.write("                            <th>Advisor</th>\n");
      out.write("                            <th>Department Head</th>\n");
      out.write("                            <th>Registrar</th>\n");
      out.write("                            <th>Final Status</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tfoot>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"7\">BIT , <a href=\"www.fb.com\" rel=\"external\">Clearance Management System</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tfoot>\n");
      out.write("\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            <th>");
      out.print( stud.getSID());
      out.write("</th>\n");
      out.write("                            <td >");
      out.print( name.toUpperCase());
      out.write("</td>\n");
      out.write("                            <td>");
 num = stud.getHousingOfficeStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                            <td>");
 num = stud.getStudentCaféStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                            <td>");
 num = stud.getSportMasterStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                            <td>");
  num = stud.getFacultyStoreStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                            <td>");
 num = stud.getLibraryStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                            <td >");
 num = stud.getAdvisorStatus();
      out.print(status(num));
      out.write("\t</td>\n");
      out.write("                            <td>");
 num = stud.getDepartmentHeadStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                            <td>");
 num = stud.getRegistrarStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                            <td class=\"final\">");
num = stud.getFinalStatus();
      out.print(finalStatus(num));
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>  \n");
      out.write("        </form>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"loc\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
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
