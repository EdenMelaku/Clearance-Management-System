package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import otherService.StudentClearanceInfo;

public final class StudentStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
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
            status = "Process Started";
        } else if (sta == 3) {
            status = "Advisor Remain";
        } else if (sta == 2) {
            status = "Departmnet Head Remain";
        } else if (sta == 1) {
            status = "Registrar Remain";
        } else if (sta == 0) {
            status = "Cleared";
        } else {
            status = "Unknown";

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
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>CMS</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/StyleOne.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/my_style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/StatusTable.css\">\n");
      out.write("    <script src=\"javascript/an.js\"></script>\n");
      out.write("\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        #tt{\n");
      out.write("            position: absolute;\n");
      out.write("            top: calc(27% - 35px);\n");
      out.write("            left: calc(35% - 220px);\n");
      out.write("            width: 79%;\n");
      out.write("        }\n");
      out.write("        #refresh{\n");
      out.write("            width:7.5%;\n");
      out.write("        }\n");
      out.write("        #idNum{\n");
      out.write("            width:10%;\n");
      out.write("            font-size: 18px;\n");
      out.write("            border-bottom: 1px solid #1d96b2;\n");
      out.write("            text-align: center; \n");
      out.write("\n");
      out.write("        } #name{\n");
      out.write("            width:13.25%;\n");
      out.write("            font-size: 18px;\n");
      out.write("            border-bottom: 1px solid #1d96b2;\n");
      out.write("            text-align: left; \n");
      out.write("            text-transform: capitalize\n");
      out.write("\n");
      out.write("        } #idd{\n");
      out.write("            width:14%;\n");
      out.write("            font-size: 18px;\n");
      out.write("            border-bottom: 1px solid #1d96b2;\n");
      out.write("            text-align: left; \n");
      out.write("            text-transform: capitalize\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        #caffe{\n");
      out.write("            width: 8%;\n");
      out.write("            color: #007090;;\n");
      out.write("            font-size: 17px;\n");
      out.write("            border-bottom: 1px solid #1d96b2;\n");
      out.write("            font-weight: normal;\n");
      out.write("            text-align: center;  \n");
      out.write("        }   #dh{\n");
      out.write("            width: 8.5%;\n");
      out.write("            font-size: 18px;\n");
      out.write("            border-bottom: 1px solid #1d96b2;\n");
      out.write("            font-weight: normal;\n");
      out.write("            text-align: center;  \n");
      out.write("        }\n");
      out.write("    </style>\n");
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
      out.write("    ");

        StudentClearanceInfo[] stud = (StudentClearanceInfo[]) request.getAttribute("studInfo");
    
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"menu\">\n");
      out.write("        <ul class=\"widget-container\"><li id=\"text-15\" class=\"widget widget_text\"><h3 class=\"widgettitle\">Menu</h3>\t\t\n");
      out.write("                <div class=\"textwidget\"><ul>\n");
      out.write("                        <li> \n");
      out.write("                            <a href=\"initiateClearance1?username=");
      out.print(bean.getUsername());
      out.write("&amp; userRole=");
      out.print(bean.getUserRole());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                Initiate Clearance</a> </li>              \n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"ApproveClearanceFilterServlet?username=");
      out.print( bean.getUsername());
      out.write("\" >\n");
      out.write("                                Approve Clearance Status</a></li>\n");
      out.write("\n");
      out.write("                        <li><a href=\"GetStudentStatusServlet?username=");
      out.print(bean.getUsername());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                Get Student Status</a>  </li>\n");
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
      out.write("    <div  class=\"student_table\" id=\"tt\">\n");
      out.write("        <table class=\"testTable\">         \n");
      out.write("            <thead id=\"head\">\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("                    <td><input type=\"text\"class=\"myField1\" ID=\"id\"  placeholder=\"Search By Id...\" onkeydown=\"Filter(this)\" >\n");
      out.write("                    <td><input type=\"text\"class=\"myField10\" ID=\"fname\" placeholder=\"First Name...\"   onkeydown=\"Filter(this)\" /></td>\n");
      out.write("                    <td>   <a href=\"GetStudentStatusServlet?username=");
      out.print(bean.getUsername());
      out.write("\" >Refresh</a>\n");
      out.write("                    </td>\n");
      out.write("                    <!--td><input type=\"text\" ID=\"zupanija\"   onkeydown=\"Filter(this)\" /></td-->     \n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th id=\"idd\">ID</th>\n");
      out.write("                    <th id=\"name\"> Name</th>\n");
      out.write("                        ");
if (bean.getProgram().equals("ur") || bean.getProgram().equals("us")) {
      out.write("\n");
      out.write("                    <th>Cafe</th>\n");
      out.write("                    <th >Housing Office</th>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    <th >Sport Master</th>\n");
      out.write("                    <th >Faculty Store</th>\n");
      out.write("                    <th>Library</th>\n");
      out.write("                        ");
if (bean.getProgram().equals("pr")) {
      out.write("\n");
      out.write("                    <th >Dean Of Research</th>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        ");
if (bean.getProgram().equals("ue")) {
      out.write("\n");
      out.write("                    <th >Continuing Education</th>\n");
      out.write("                    <th>Cont.Edu Business Affair</th>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    <th>Advisor</th>\n");
      out.write("                    <th>Department Head</th>\n");
      out.write("                    <th>Registrar</th>\n");
      out.write("                    <th>Final Status</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tfoot>\n");
      out.write("\n");
      out.write("            </tfoot>\n");
      out.write("\n");
      out.write("            <tbody class=\"bbbb\">\n");
      out.write("                ");
for (int i = 0; i < (stud.length - 1); i++) {
      out.write("\n");
      out.write("                <tr class=\"aa\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    <td id=\"idNum\">");
      out.print( stud[i].getSID());
      out.write("</th>\n");
      out.write("                    <td id=\"name\">");
      out.print( stud[i].getFirstName());
 out.print("  ");
      out.print( stud[i].getLastName());
      out.write("</td>\n");
      out.write("                    ");
if (bean.getProgram().equals("ur") || bean.getProgram().equals("us")) {
      out.write("\n");
      out.write("                    <th id=\"refresh\">");
 num = stud[i].getStudentCaféStatus();
      out.print(status(num));
      out.write("</th>\n");
      out.write("                    <th>");
num = stud[i].getHousingOfficeStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    <th>");
num = stud[i].getSportMasterStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                    <th>");
 num = stud[i].getFacultyStoreStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                    <th>");
num = stud[i].getLibraryStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                        ");
if (bean.getProgram().equals("pr")) {
      out.write("\n");
      out.write("                    <th>");
 num = stud[i].getDeanOFRPGStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                        ");
}
      out.write(" \n");
      out.write("\n");
      out.write("                        ");
if (bean.getProgram().equals("ue")) {
      out.write("\n");
      out.write("                    <th>");
 num = stud[i].getContinuingEducationStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                    <th>");
num = stud[i].getContinuingEducationBAStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    <th >");
num = stud[i].getAdvisorStatus();
      out.print(status(num));
      out.write("\t</td>\n");
      out.write("                    <th id=\"dh\">");
num = stud[i].getDepartmentHeadStatus();
      out.print(status(num));
      out.write("</th>\n");
      out.write("                    <th>");
num = stud[i].getRegistrarStatus();
      out.print(status(num));
      out.write("</td>\n");
      out.write("                    <th>");
num = stud[i].getFinalStatus();
      out.print(finalStatus(num));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"loc\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("</div>   \n");
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
