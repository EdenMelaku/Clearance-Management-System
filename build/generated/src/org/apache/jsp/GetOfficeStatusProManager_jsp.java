package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import clearance_management.user;
import model.read;
import otherService.stakeholderrow;
import java.util.Calendar;
import java.util.GregorianCalendar;
import otherService.StudentClearanceInfo;

public final class GetOfficeStatusProManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  public String getServletInfo() {
    return "true";
  }


        String username = null;
        String firstname = null;
    

    public String status(int sta) {
        String status = null;
        if (sta == 2) {
            status = "In Hold";
        } else if (sta == 1) {
            status = "Cleared";
        } else if (sta == 0) {
            status = "Fully Cleared";
        } else if (sta == 4) {
            status = "Deactivated";
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
      out.write("\n");
      out.write("\n");
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
      out.write("    <link rel=\"stylesheet\" href=\"css/StatusProgramManager.css\">\n");
      out.write("    <script src=\"javascript/an.js\"></script>\n");
      out.write("\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        #tt{\n");
      out.write("            position: absolute;\n");
      out.write("            top: calc(27% - 35px);\n");
      out.write("            left: calc(35% - 220px);\n");
      out.write("            width: 79%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #idNum{\n");
      out.write("            width:7.5%;\n");
      out.write("            /**  color: #007090;*/\n");
      out.write("            /**   font-size: 17px;*/\n");
      out.write("            border-bottom: 1px solid #1d96b2;\n");
      out.write("            font-weight: normal;\n");
      out.write("            text-align: left;  \n");
      out.write("        } #name{\n");
      out.write("            width:6%;\n");
      out.write("            /*   color: #007090;*/\n");
      out.write("            /** font-size: 17px;*/\n");
      out.write("            border-bottom: 1px solid #1d96b2;\n");
      out.write("            font-weight: normal;\n");
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
      out.write("            width: 9%;\n");
      out.write("            color: #007090;;\n");
      out.write("            font-size: 20px;\n");
      out.write("            border-bottom: 1px solid #1d96b2;\n");
      out.write("            font-weight: normal;\n");
      out.write("            text-align: center;  \n");
      out.write("        }\n");
      out.write("        #refresh{\n");
      out.write("            width:3%;\n");
      out.write("        }\n");
      out.write("        .ab{\n");
      out.write("            text-align: left;\n");
      out.write("            text-transform: capitalize\n");
      out.write("        }\n");
      out.write("        .myField100{\n");
      out.write("            width:100px\n");
      out.write("\n");
      out.write("        }#program{\n");
      out.write("\n");
      out.write("            width:5%;\n");
      out.write("\n");
      out.write("        }#sta{\n");
      out.write("\n");
      out.write("            width:5.75%;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
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
      out.write("    ");
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

        username = (String) request.getAttribute("username");
        firstname = (String) request.getAttribute("firstname");
        stakeholderrow[] dataAdv = (stakeholderrow[]) request.getAttribute("advisor");
        stakeholderrow[] dataDep = (stakeholderrow[]) request.getAttribute("departmenthead");
        stakeholderrow[] dataFuc = (stakeholderrow[]) request.getAttribute("facultystore");

    
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"menu\">\n");
      out.write("        <ul class=\"widget-container\"><li id=\"text-15\" class=\"widget widget_text\"><h3 class=\"widgettitle\">Menu</h3>\t\t\n");
      out.write("                <div class=\"textwidget\"><ul>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"getofficeStatusServlet?username=");
      out.print(bean.getUsername());
      out.write("\">\n");
      out.write("                                Get Office Status</a></li>\n");
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
      out.write("                    <td><input type=\"text\"class=\"myField10\" ID=\"id\"  placeholder=\"Search By Id...\" onkeydown=\"Filter(this)\" ></td>\n");
      out.write("                    <td><input type=\"text\"class=\"myField10\" ID=\"fname\" placeholder=\"First Name...\"   onkeydown=\"Filter(this)\" /></td>\n");
      out.write("                    <td id=\"program\" >  <select class=\"form-control\" id=\"prog\"  class=\"myCombo\"  value=\"Search By Program\" onclick=\"Filter(this)\">\n");
      out.write("                            <option  value=\"advisor\" onkeydown=\"Filter(this)\" >Advisor</option>\n");
      out.write("                            <option value=\"departmenthead\" onkeydown=\"Filter(this)\">Department Head</option>\n");
      out.write("                            <option value=\"facultystore\" onkeydown=\"Filter(this)\">Faculty Store</option></select>\n");
      out.write("                    </td>\n");
      out.write("                    <td id=\"refresh\">\n");
      out.write("                        <a href=\"getofficeStatusServlet?username=");
      out.print( request.getAttribute("username"));
      out.write("\" >Refresh</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th> Name</th>\n");
      out.write("                    <th>Approved By</th>\n");
      out.write("                    <th>Approval Date</th>\n");
      out.write("                    <th id=\"sta\"> Status </th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tfoot>\n");
      out.write("            </tfoot>\n");
      out.write("\n");
      out.write("            <tbody class=\"bbbb\">\n");
      out.write("                ");

                    int a = 0;
                    String em = null;
                
      out.write("\n");
      out.write("                ");
for (int i = 0; i < (dataAdv.length - 1); i++) {
      out.write("\n");
      out.write("                <tr class=\"aa\">\n");
      out.write("                    <th id=\"idNum\">");
      out.print( dataAdv[i].getId());
      out.write("</th>\n");
      out.write("                    <th id=\"name\">");
      out.print( read.getStudent(dataAdv[i].getId()).getFirstName());
 out.print("  ");
      out.print(read.getStudent(dataAdv[i].getId()).getLastname());
      out.write("</td>\n");
      out.write("                    <th hidden>advisor </td>\n");
      out.write("                    <th>");
      out.print( dataAdv[i].getApprovedby());
      out.write("</td>\n");
      out.write("                    <th>");
      out.print( dataAdv[i].getApprovalDate());
      out.write("</td>\n");
      out.write("                    <th>");
      out.print( dataAdv[i].getStatus());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
for (int i = 0; i < (dataAdv.length - 1); i++) {
      out.write("\n");
      out.write("                <tr class=\"aa\">\n");
      out.write("                    <th id=\"idNum\">");
      out.print( dataDep[i].getId());
      out.write("</th>\n");
      out.write("                    <th id=\"name\">");
      out.print( read.getStudent(dataDep[i].getId()).getFirstName());
 out.print("  ");
      out.print(read.getStudent(dataDep[i].getId()).getLastname());
      out.write("</td>\n");
      out.write("                    <th hidden>departmenthead </td>\n");
      out.write("                    <th>");
      out.print( dataDep[i].getApprovedby());
      out.write("</td>\n");
      out.write("                    <th>");
      out.print( dataDep[i].getApprovalDate());
      out.write("</td>\n");
      out.write("                    <th>");
      out.print( dataDep[i].getStatus());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
for (int i = 0; i < (dataAdv.length - 1); i++) {
      out.write("\n");
      out.write("                <tr class=\"aa\">\n");
      out.write("                    <th id=\"idNum\">");
      out.print( dataFuc[i].getId());
      out.write("</th>\n");
      out.write("                    <th id=\"name\">");
      out.print( read.getStudent(dataFuc[i].getId()).getFirstName());
 out.print("  ");
      out.print(read.getStudent(dataFuc[i].getId()).getLastname());
      out.write("</td>\n");
      out.write("                    <th hidden>facultystore </td>\n");
      out.write("                    <th>");
      out.print( dataFuc[i].getApprovedby());
      out.write("</td>\n");
      out.write("                    <th>");
      out.print( dataFuc[i].getApprovalDate());
      out.write("</td>\n");
      out.write("                    <th>");
      out.print( dataFuc[i].getStatus());
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
