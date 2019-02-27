package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import otherService.AccountManagingInfo;
import model.Test;
import model.Test;

public final class ManageAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public AccountManagingInfo[] us = null;
        public String[] username = null;
        public String[] fullname = null;
        public int len = 0;
    

        int vv() {
            return len;
        }
    

                    int num;
                

                    public String idAssign(int n) {
                        String h = null;
                        h = "cb" + n;
                        return h;
                    }
                

        public String accountSta(int ss) {
            String status = null;
            if (ss == 1) {
                status = "Active";
            } else if (ss == 0) {
                status = "Not Active";
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
      response.setContentType("text/html");
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
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("    <title>C.M.S</title> \n");
      out.write("    <link rel=\"stylesheet\" href=\"css/StyleOne.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/my_style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/ManageAccountTable.css\">\n");
      out.write("\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        .lo{\n");
      out.write("            color:green;\n");
      out.write("            height: 40px;\n");
      out.write("            line-height: 30px;\n");
      out.write("            padding-right: 12px;\n");
      out.write("            padding-left: 20px;\n");
      out.write("            text-transform: uppercase;\n");
      out.write("            font-size: 18px; \n");
      out.write("        }\n");
      out.write("        #msgF{\n");
      out.write("            background-color:red;\n");
      out.write("            width:20%;\n");
      out.write("            color:white;\n");
      out.write("            font-size:20px;\n");
      out.write("        }\n");
      out.write("        #msgSuc{\n");
      out.write("            background-color:green;\n");
      out.write("            width:20%;\n");
      out.write("            color:white;\n");
      out.write("            font-size:20px\n");
      out.write("        }\n");
      out.write("        #tt{\n");
      out.write("            position: absolute;\n");
      out.write("            top: calc(28% - 35px);\n");
      out.write("            left: calc(38% - 242px);\n");
      out.write("            width: 80%;\n");
      out.write("            /**  background-color: #AAA*/\n");
      out.write("        }\n");
      out.write("        #accountChoice{\n");
      out.write("            width:20%;\n");
      out.write("        }\n");
      out.write("        #actionChoice{\n");
      out.write("            width:15%;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        #name{\n");
      out.write("            width:15.5%;\n");
      out.write("            background: #0199d9;\n");
      out.write("            border: 1px solid #1d96b2;\n");
      out.write("            font-weight: normal;\n");
      out.write("            text-align: center;\n");
      out.write("            color: white;\n");
      out.write("        }  \n");
      out.write("        #name1{\n");
      out.write("            width:15%;\n");
      out.write("            font-weight: normal;\n");
      out.write("        }\n");
      out.write("        .ccc{\n");
      out.write("            width:10%;\n");
      out.write("\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("        var ss = [];\n");
      out.write("        var aa = [];\n");
      out.write("        count = 0;\n");
      out.write("        function GetValues() {\n");
      out.write("            ckbox = document.getElementsByClassName(\"chkdata\");\n");
      out.write("            for (var i = 0; i < ckbox.length; i++) {\n");
      out.write("                element = ckbox[i];\n");
      out.write("                if (element.checked) {\n");
      out.write("                    ss[count] = i;\n");
      out.write("                    count++;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            count = 0;\n");
      out.write("            //    alert(\"ss is \" + ss.length)\n");
      out.write("\n");
      out.write("            return ss;\n");
      out.write("        }\n");
      out.write("        function selectedValues() {\n");
      out.write("            return ss;\n");
      out.write("        }\n");
      out.write("        function func()\n");
      out.write("        {\n");
      out.write("            GetValues();\n");
      out.write("            document.myform.varlet.value = ss;\n");
      out.write("            document.myform.arraylength.value = ss.length;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function getItem() {//this is for combo box\n");
      out.write("            //  alert(\"get it\");\n");
      out.write("            var idElement = document.getElementById(\"AccountName\").value;\n");
      out.write("            //   alert(idElement);\n");
      out.write("            document.myform.account.value = idElement;\n");
      out.write("//            location.href = \"/ActivateAccountServlet?account=\" + idElement;\n");
      out.write("            return idElement;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body style = \"background-color:#DFE2DB;color:black;\">\n");
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
      out.write("    <div class=\"header\">\n");
      out.write("        <section id=\"header\" class=\"appear\">\n");
      out.write("            <div class=\"navbar navbar-fixed-top\" role=\"navigation\" data-0=\"line-height:100px; height:100px; background-color:red ;\" data-300=\"line-height:60px; height:60px; background-color:red;\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Common.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");

        us = (AccountManagingInfo[]) request.getAttribute("users");
        fullname = (String[]) request.getAttribute("name");
        username = (String[]) request.getAttribute("unames");
        len = us.length;
    
      out.write("\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"bod\">\n");
      out.write("        \n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <ul class=\"widget-container\"><li id=\"text-15\" class=\"widget widget_text\"><h3 class=\"widgettitle\">Menu</h3>\t\t\n");
      out.write("                    <div class=\"textwidget\"><ul>\n");
      out.write("\n");
      out.write("                            ");
 if (bean.getUserRole().toLowerCase().equals("privileged_user") || bean.getUserRole().toLowerCase().equals("advisor")) {
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"ApproveClearanceFilterServlet?username=");
      out.print( bean.getUsername());
      out.write("\" >\n");
      out.write("                                    Approve Clearance Status</a></li>\n");
      out.write("                                    ");
}
      out.write("\n");
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
 if (bean.getUserRole().toLowerCase().equals("advisor")) {
      out.write("\n");
      out.write("                            <li><a href=\"GetStudentStatusServlet?username=");
      out.print(bean.getUsername());
      out.write("\" accesskey=\"1\" title=\"\">\n");
      out.write("                                    Get Student Status</a>  </li>\n");
      out.write("                                    ");
}
      out.write(" \n");
      out.write("                               \n");
      out.write("\n");
      out.write("                            ");
 if (bean.getOffice().toLowerCase().equals("registrar")) {
      out.write("\n");
      out.write("                            <li><a href=\"..?username=");
      out.print(bean.getUsername());
      out.write("\" >\n");
      out.write("                                    Student Status</a></li>\n");
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
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <form name=\"myform\" class=\"student_table\" id=\"tt\" method=\"post\" action=\"ActivateAccountServlet\">\n");
      out.write("        <!--select id=\"accountChoice\"  class=\"form-control\" name=\"accountChoice\" >\n");
      out.write("            <option>Select the Account</option>\n");
      out.write("        ");
 for (int i = 0; i < us.length - 1; i++) {
      out.write("\n");
      out.write("        <option value=");
      out.print(username[i]);
      out.write('>');
      out.write(' ');
      out.print( fullname[i]);
      out.write("</option>\n");
      out.write("        ");
}
      out.write("                   \n");
      out.write("    </select-->\n");
      out.write("        <div id=\"msgSuc\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div id=\"msgF\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msgF}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <table  class=\"testTable\">         \n");
      out.write("            <br>\n");
      out.write("            <thead id=\"head\">\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                function selection() {\n");
      out.write("                ");
 for (int t = 0; t < vv(); t++) {
      out.write("\n");
      out.write("                ");
      out.print( idAssign(t));
      out.write(".click();\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("            <tr>\n");
      out.write("                <td id=\"name\">First Name</td>\n");
      out.write("                <td id=\"name\">Last Name</td>\n");
      out.write("                <th>Creator</th>\n");
      out.write("                <th>Creation Date</th>\n");
      out.write("                <th>Last Login</th>\n");
      out.write("                <th>Account Status</th>\n");
      out.write("                <th>Select<br>\n");
      out.write("                    <input type=\"checkbox\" onchange =\"selection();\">Select All\n");
      out.write("                </th>\n");
      out.write("            </tr>\n");
      out.write("            </thead>\n");
      out.write("\n");
      out.write("            <tbody class=\"bbbb\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");
 for (int i = 0; i < us.length; i++) {
      out.write("\n");
      out.write("                <tr class=\"aa\"> \n");
      out.write("                    <th id=\"name1\">");
      out.print(us[i].getFirstName());
      out.write("</th>\n");
      out.write("                    <th id=\"name1\">");
      out.print(us[i].getLastName());
      out.write("</th>\n");
      out.write("                    <th>");
      out.print( us[i].getCreator());
      out.write("</th>\n");
      out.write("                    <th>");
      out.print(us[i].getCreationDate());
      out.write("</th>\n");
      out.write("                    <th>");
      out.print(us[i].getLastLogin());
      out.write("</th>\n");
      out.write("                    <th>");
num = us[i].getAccountStatus();
      out.print(accountSta(num));
      out.write("</th>\n");
      out.write("                    <th><input type=\"checkbox\" class=\"chkdata\" id=");
      out.print(idAssign(i));
      out.write("  /></th>\n");
      out.write("                </tr>    \n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("            <tfoot>\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <select id=\"actionChoice\" class=\"form-control\" name=\"actionChoice\">\n");
      out.write("                            <option value=\"activate\">Activate</option>\n");
      out.write("                            <option value=\"deactivate\">DeActivate</option>\n");
      out.write("                        </select>\n");
      out.write("                        &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<input type=\"submit\" class=\"lo\" name=\"Activate\" value=\"Done\" onclick =\"func()\">\n");
      out.write("                        <input type=\"hidden\" name=\"arraylength\">\n");
      out.write("                        <input type=\"hidden\" class=\"lo\" name=\"username\" value=");
      out.print( bean.getUsername());
      out.write(">\n");
      out.write("                        <input type=\"hidden\" name=\"username\" value=");
      out.print( bean.getUsername());
      out.write(">\n");
      out.write("                        <input type=\"hidden\" name=\"length\" value=");
      out.print( us.length);
      out.write(">\n");
      out.write("                        <input type=\"hidden\" name=\"varlet\">   \n");
      out.write("                        ");
 for (int i = 0; i < us.length; i++) {
      out.write("\n");
      out.write("                        <input type=\"hidden\" name=\"userEmail[");
      out.print( i);
      out.write("]\" value=");
      out.print( us[i].getUsername());
      out.write(">\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </tfoot>\n");
      out.write("        </table>\n");
      out.write("    </form>    \n");
      out.write("    <div class=\"loc\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Developers.jsp", out, false);
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("</body>\n");
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
