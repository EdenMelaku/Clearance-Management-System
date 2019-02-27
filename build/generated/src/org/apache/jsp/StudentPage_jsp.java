package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.swing.JOptionPane;
import otherService.StudentClearanceInfo;

public final class StudentPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  public String getServletInfo() {
    return "true";
  }

 int num = 0;


            public String status(int stat) {
                String s = null;
                if (stat == 0) {
                    s = "cleared";
                } else {
                    s = "not cleared";
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
                    status = "Advisor Remain";
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
      out.write("            .name{\n");
      out.write("                font-size: 30px;\n");
      out.write("                color:green;\n");
      out.write("                text-transform: left\n");
      out.write("            } #name{\n");
      out.write("                font-size: 30px;\n");
      out.write("                font-family: times new roman;\n");
      out.write("                color:green;\n");
      out.write("                text-transform: capitalize\n");
      out.write("            }\n");
      out.write("            #msg10{\n");
      out.write("                font-size: 20px;\n");
      out.write("                color:red;text-align: center; \n");
      out.write("\n");
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
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"link_home\">\n");
      out.write("            <a href=\"index.jsp\" >Home</a>\n");
      out.write("        </div>\n");
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
      out.write("        <div class=\"main\">\n");
      out.write("            <form class=\"form-wrapper cf\" method=\"post\" action=\"getMyStatusServlet\" >\n");
      out.write("                <input type=\"text\"name=\"id\" placeholder=\"Search By Id Here...\" >\n");
      out.write("                <button type=\"submit\">Search</button>\n");
      out.write("                <div id=\"msg10\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msgFail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"imga\">\n");
      out.write("            <img src=\"img/images.jpg\" width=\"310%\" alt=\"profile image\" >\n");
      out.write("        </div> \n");
      out.write("        <div id=\"name\">\n");
      out.write("            <br><br><br><br><br><br><br>&nbsp;&nbsp;");
      out.print( name);
      out.write("\n");
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
      out.write("                            <th >Housing Office</th>\n");
      out.write("                            <th>Cafe</th>\n");
      out.write("                            <th >Sport Master</th>\n");
      out.write("                            <th >Faculty Store</th>\n");
      out.write("                            <th>Library</th>\n");
      out.write("                            <th>Book Store</th>\n");
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
      out.write("                            <td>");
 num = stud.getBookStoreStatus();
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
      out.write("                            <td>");
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
      out.write("        <div class=\"loc\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
