package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clearance_management.user;
import model.read;
import javax.swing.JOptionPane;
import clearance_management.StudentBean;

public final class RegisterNonCafe_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            public StudentBean[] stud;
            public String[] sid;
            public String fname = null;
            public int len;
            public String username;
        

            int vv() {
                return len;
            }
        

                        public String idAssign(int n) {
                            String h = null;
                            h = "cb" + n;
                            return h;
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>CMS</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/StyleOne.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/my_style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/NewTable.css\">\n");
      out.write("        <script src=\"javascript/an.js\"></script>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #msgF{\n");
      out.write("                font-size: 20px;\n");
      out.write("                background-color:#F00;\n");
      out.write("            }\n");
      out.write("            #msgSuccess{\n");
      out.write("                font-size: 20px;\n");
      out.write("                color:white;\n");
      out.write("                width:925px;\n");
      out.write("                background-color:green;\n");
      out.write("            }\n");
      out.write("            #tt{\n");
      out.write("                position: absolute;\n");
      out.write("                top: calc(25% - 35px);\n");
      out.write("                left: calc(38% - 240px);\n");
      out.write("                width: 79%;\n");
      out.write("            }\n");
      out.write("            #idid{/*program*/\n");
      out.write("                width:23%;\n");
      out.write("            }\n");
      out.write("            #idid2{/*department*/\n");
      out.write("                width:22%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #name{\n");
      out.write("                text-align: left;\n");
      out.write("                text-transform: capitalize\n");
      out.write("            }\n");
      out.write("            .chkdata{\n");
      out.write("                width: 77px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            var ss = [];\n");
      out.write("            var aa = [];\n");
      out.write("            count = 0;\n");
      out.write("            function GetValues() {\n");
      out.write("                ckbox = document.getElementsByClassName(\"chkdata\");\n");
      out.write("                aa = document.getElementsByName(\"sid\");\n");
      out.write("                for (var i = 0; i < ckbox.length; i++) {\n");
      out.write("                    element = ckbox[i];\n");
      out.write("                    if (element.checked) {\n");
      out.write("                        ss[count] = i;\n");
      out.write("                        count++;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                count = 0;\n");
      out.write("                return ss;\n");
      out.write("            }\n");
      out.write("            function selectedValues() {\n");
      out.write("                return ss;\n");
      out.write("            }\n");
      out.write("            function func()\n");
      out.write("            {\n");
      out.write("                GetValues();\n");
      out.write("                document.myform.varlet.value = ss;\n");
      out.write("                document.myform.arraylength.value = ss.length;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"my_style.css\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body style = \"background-color:#DFE2DB;color:black;\">\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <section id=\"header\" class=\"appear\">\n");
      out.write("                <div class=\"navbar navbar-fixed-top\" role=\"navigation\" data-0=\"line-height:100px; height:100px; background-color:red ;\" data-300=\"line-height:60px; height:60px; background-color:red;\">\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Common.jsp", out, false);
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
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
      out.write("\n");
      out.write("\n");
      out.write("        ");

            username = (String) request.getAttribute("username");
            stud = (StudentBean[]) request.getAttribute("student");
            fname = (String) request.getAttribute("firstname");
            bean.setUserRole((String) request.getAttribute("userrole"));
            bean.setOffice((String) request.getAttribute("office"));
            len = stud.length;
        
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <ul class=\"widget-container\"><li id=\"text-15\" class=\"widget widget_text\"><h3 class=\"widgettitle\">Menu</h3>\t\t\n");
      out.write("                           <div class=\"textwidget\"><ul>\n");
      out.write("                      \n");
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
 if (bean.getOffice().toLowerCase().equals("sport master") || bean.getOffice().toLowerCase().equals("library") | bean.getOffice().toLowerCase().equals("housing office") | bean.getOffice().toLowerCase().equals("student cafe") && bean.getUserRole().equals("privileged_user")) {
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
      out.write("                        <li><a href=\"filterStudentsForNONCAFEservlet?username=");
      out.print(bean.getUsername());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                Register Non Cafe</a>  </li>\n");
      out.write("                     \n");
      out.write("\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                   \n");
      out.write("                        ");
 if (bean.getOffice().toLowerCase().equals("registrar")) {
      out.write("\n");
      out.write("                        <li><a href=\"..?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                Student Status</a></li>\n");
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
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>      \n");
      out.write("        <form name=\"myform\" class=\"student_table\" id=\"tt\" method=\"post\" action=\"registerNoncafeStudentsServlet\" >\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <table class=\"testTable\">     \n");
      out.write("                <thead id=\"head\">\n");
      out.write("                <div id=\"msgSuccess\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div id=\"msgF\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Failmsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                \n");
      out.write("                    <td><input type=\"text\"class=\"myField\" ID=\"id\"  placeholder=\"Search By Id...\" onkeydown=\"Filter(this)\" >\n");
      out.write("                    <td><input type=\"text\"class=\"myField\" ID=\"fname\" placeholder=\"First Name...\"   onkeydown=\"Filter(this)\" /></td>\n");
      out.write("                    <td><input type=\"text\"class=\"myField\" ID=\"lname\"        placeholder=\"Last Name...\"  onkeydown=\"Filter(this)\" /></td>  \n");
      out.write("                    <td>\n");
      out.write("                        <select id=\"prog\" class=\"form-control\" class=\"myCombo\"  value=\"Search By Program\" onclick=\"Filter(this)\">\n");
      out.write("                            <option  value=\"ur\"  >Undergraduate Regular</option>\n");
      out.write("                            <option  value=\"us\" >Undergraduate Summer</option>\n");
      out.write("                            <option value=\"ue\" >Undergraduate Extension</option>\n");
      out.write("                            <option  value=\"pr\">Postgraduate Regular</option>\n");
      out.write("                            <option  value=\"ps\" >Postgraduate Summer</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select  id=\"dep\" class=\"form-control\" class=\"myCombo\" value=\"Search By Department\" onclick=\"Filter(this)\">\n");
      out.write("                            <option  value=\"Software Engineering\" onkeydown=\"Filter(this)\" >Software Engineering</option>\n");
      out.write("                            <option value=\"Civil Engineering\" onkeydown=\"Filter(this)\">Civil Engineering</option>\n");
      out.write("                            <option value=\"Computer scince\" onkeydown=\"Filter(this)\">Computer Science</option>\n");
      out.write("                            <option value=\"Automotive Engineering\" onkeydown=\"Filter(this)\">Automotive Engineering</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"filterStudentsForNONCAFEservlet?username=");
      out.print(bean.getUsername());
      out.write("\"class=\"refreshLink\">Refresh</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>First Name</th>\n");
      out.write("                    <th>Last Name</th>\n");
      out.write("                    <th>Program</th>\n");
      out.write("                    <th>Department</th>\n");
      out.write("                    <th>section</th>\n");
      out.write("                    <th>Register<br>\n");
      out.write("                        <input type=\"checkbox\" onchange =\"selection();\">Select All</div>\n");
      out.write("                    </th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    function selection() {\n");
      out.write("                    ");
 for (int t = 0; t < vv(); t++) {
      out.write("\n");
      out.write("                    ");
      out.print( idAssign(t));
      out.write(".click();\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                </script>\n");
      out.write("                <tbody class=\"bbbb\">\n");
      out.write("\n");
      out.write("                    ");
for (int i = 0; i < (stud.length - 1); i++) {
      out.write("\n");
      out.write("                    <tr class=\"aa\"> \n");
      out.write("                        <th>");
      out.print( stud[i].getId());
      out.write("</th>\n");
      out.write("                        <th id=\"name\">");
      out.print( stud[i].getFirstName());
      out.write("</th>\n");
      out.write("                        <th id=\"name\">");
      out.print( stud[i].getLastname());
      out.write("</th>\n");
      out.write("                        <th id=\"idid\">");
      out.print( stud[i].getProgram());
      out.write("</th>\n");
      out.write("                        <th id=\"idid2\">");
      out.print( stud[i].getDepartment());
      out.write("</th>\n");
      out.write("                        <th>");
      out.print( stud[i].getSection());
      out.write("</th>\n");
      out.write("                        <th><input type=\"checkbox\" class=\"chkdata\" id=");
      out.print(idAssign(i));
      out.write("  /></th>\n");
      out.write("                    </tr>     \n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("                <tfoot class=\"footer\">         \n");
      out.write("\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"btn\">\n");
      out.write("                                <input type=\"hidden\" name=\"arraylength\">\n");
      out.write("                                <input type=\"hidden\" name=\"username\" value=");
      out.print( bean.getUsername());
      out.write(">\n");
      out.write("                                <input type=\"hidden\" name=\"length\" value=");
      out.print( stud.length);
      out.write(">\n");
      out.write("                                <input type=\"hidden\" name=\"varlet\"/>\n");
      out.write("                                ");
 for (int i = 0; i < (stud.length - 1); i++) {
      out.write("\n");
      out.write("                                <input type=\"hidden\" name=\"studentsIdNum[");
      out.print( i);
      out.write("]\" value=");
      out.print( stud[i].getId());
      out.write(">\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                                <input type=\"submit\" class=\"lo\" name = \"Submit\" value =\"Finish\" onclick =\"func()\"/>\n");
      out.write("                                <input type=\"reset\" class=\"lo\" value =\"Cancel\" />\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </td>           \n");
      out.write("                    </tr>\n");
      out.write("                </tfoot>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("    <div class=\"loc\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("    </div> \n");
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
