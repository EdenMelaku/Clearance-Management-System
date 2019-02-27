
<%@page import="javax.swing.JOptionPane"%>
<%@page import="otherService.AccountManagingInfo" errorPage="MyErrorPage.jsp"%>
<head><!--   Other Office   -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>C.M.S</title> 
    <link rel="stylesheet" href="css/StyleOne.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/my_style.css">
    <link rel="stylesheet" href="css/ManageTable.css">

    <style type="text/css">
        .lo{
            color:green;
            height: 40px;
            line-height: 30px;
            padding-right: 12px;
            padding-left: 20px;
            text-transform: uppercase;
            font-size: 18px; 
        }
        #msgF{
            background-color:red;
            width:20%;
            color:white;
            font-size:20px;
        }
        #msgSuc{
            background-color:green;
            width:20%;
            color:white;
            font-size:20px
        }
        #tt{
            position: absolute;
            top: calc(28% - 35px);
            left: calc(38% - 242px);
            width: 80%;
        }
        #accountChoice{
            width:20%;
        }
        #actionChoice{
            width:15%;

        }
        #name{
            width:17%;
            background: #0199d9;
            border: 1px solid #1d96b2;
            font-weight: normal;
            text-align: center;
            color: white;
        }
        .chkdata{
            width:60pt;

        }
        #ddd{
            width:18%;
            text-align: left;
            text-transform: capitalize
        }#sec{
            width:7%;

        }
        #dep{

            width:11%
        }
        #sta{
            width:15%;
        } #staHead{
            width:7%;
        }
        #prog{
            width:12%; 
        }
        .cbb{
            width:15%;
        }

    </style>
    <script type="text/javascript">
        function getItem() {
            //   alert("get it");
            var idElement = document.getElementById("AccountName").value;
            //  alert(idElement);
            document.myform.account.value = idElement;
//            location.href = "/ActivateAccountServlet?account=" + idElement;
            return idElement;
        }
    </script>

    <script type="text/javascript">

        var ss = [];
        var aa = [];
        count = 0;
        function GetValues() {
            ckbox = document.getElementsByClassName("chkdata");
            for (var i = 0; i < ckbox.length; i++) {
                element = ckbox[i];
                if (element.checked) {
                    ss[count] = i;
                    count++;
                }
            }
            count = 0;
            //    alert("ss is " + ss.length)

            return ss;
        }
        function selectedValues() {
            return ss;
        }
        function func()
        {
            GetValues();
            document.myform.varlet.value = ss;
            document.myform.arraylength.value = ss.length;
        }


    </script>
</head>
<body style = "background-color:#DFE2DB;color:black;">
    <jsp:useBean id="bean" class="clearance_management.UserBean" scope="session" />

    <div class="header">
        <section id="header" class="appear">
            <div class="navbar navbar-fixed-top" role="navigation" data-0="line-height:100px; height:100px; background-color:red ;" data-300="line-height:60px; height:60px; background-color:red;">
                <jsp:include page="Common.jsp"/>
            </div>
        </section>
    </div>

    <%!
        public AccountManagingInfo[] us = null;
        public String[] username = null;
        public String[] fullname = null;
        public int len = 0;

    %>
    <%
        us = (AccountManagingInfo[]) request.getAttribute("users");
        fullname = (String[]) request.getAttribute("name");
        username = (String[]) request.getAttribute("unames");
        len = us.length;

    %>
    <%!        int vv() {
            return len;
        }
    %>
    <%@page import="model.Test"%>
    <div class="bod">
        <%@page import="model.Test"%>
        <div class="menu">
            <ul class="widget-container"><li id="text-15" class="widget widget_text"><h3 class="widgettitle">Menu</h3>		
                    <div class="textwidget"><ul>
                            <% if (bean.getUserRole().toLowerCase().equals("advisor")) {%>
                            <li> 
                                <a href="initiateClearance1?username=<%=bean.getUsername()%>&amp; userRole=<%=bean.getUserRole()%>" accesskey="1" title="">
                                    Initiate Clearance</a> </li>              
                                    <%}%>
                                    <% if (bean.getUserRole().toLowerCase().equals("privileged_user") || bean.getUserRole().toLowerCase().equals("advisor")) {%>
                            <li>
                                <a href="ApproveClearanceFilterServlet?username=<%= bean.getUsername()%>" >
                                    Approve Clearance Status</a></li>
                                    <%}%>
                                    <% if (bean.getOffice().toLowerCase().equals("sport master") || bean.getOffice().toLowerCase().equals("library") | bean.getOffice().toLowerCase().equals("housing office") | bean.getOffice().toLowerCase().equals("student cafe") && bean.getUserRole().equals("privileged_user")) {%>            
                            <li>
                                <a href="HoldClearanceServlet?username=<%=bean.getUsername()%>" >
                                    Hold Clearance </a></li> 
                            <li>
                                <a href="release_clearance_servlet?username=<%=bean.getUsername()%>" >
                                    Release Clearance</a></li>   
                                    <%}%>
                                    <% if (bean.getUserRole().toLowerCase().equals("master_user")) {%>
                            <li>
                                <a href="getofficeStatusServlet?username=<%=bean.getUsername()%>">
                                    Get Office Status</a></li>
                                    <%}%> 
                                    <% if (bean.getUserRole().equals("master_user") || bean.getUserRole().equals("system_admin")) {%>
                            <li>   <a href= "ManageAccountServlet?username=<%=bean.getUsername()%>" accesskey="1" title="">
                                    Manage An Account</a>
                            </li>
                            <li>
                                <a href="createAccountServlet1?username=<%=bean.getUsername()%>"accesskey="1" title="">
                                    Create An Account</a></li>
                                    <%}%>
                                    <% if (bean.getUserRole().toLowerCase().equals("advisor")) {%>
                            <li><a href="GetStudentStatusServlet?username=<%=bean.getUsername()%>" accesskey="1" title="">
                                    Get Student Status</a>  </li>
                                    <%}%> 
                                    <% if (bean.getOffice().toLowerCase().equals("student cafe")) {%>
                            <li><a href="filterStudentsForNONCAFEservlet?username=<%=bean.getUsername()%>" accesskey="1" title="">
                                    Register Non Cafe</a>  </li>

                            <%}%>
                            <% if (bean.getOffice().toLowerCase().equals("dean office")) {%>
                            <li><a href="FilterForActivateClearanceServlet?username=<%=bean.getUsername()%>" >
                                    Activate Student</a></li>
                            <li><a href="FilterForDeactivateClearanceServlet?username=<%=bean.getUsername()%>" >
                                    Deactivate Student</a></li>

                            <%}%>

                            <% if (bean.getOffice().toLowerCase().equals("registrar")) {%>
                            <li><a href="..?username=<%=bean.getUsername()%>" >
                                    Student Status</a></li>
                            <li><a href="RegistrarServlet?username=<%=bean.getUsername()%>" >
                                    Generate Clearance</a></li>
                                    <%}%>
                            <li>  
                                <a href="ChangePasswordServlet2?username=<%= bean.getUsername()%>">
                                    Change Password</a></li>
                            <li>  
                                <a href="logoutServlet">
                                    Logout(<%=bean.getFirstName().toUpperCase()%>)</a></li>
                        </ul>
                    </div>
            </ul>
        </div>
    </div>

    <form  class="student_table" id="tt" method="post" action="ActivateAccountServlet">
        <!--select id="accountChoice"  class="form-control" name="accountChoice" >
            <option>Select the Account</option>
        <% for (int i = 0; i < us.length - 1; i++) {%>
        <option value=<%=username[i]%>> <%= fullname[i]%></option>
        <%}%>                   

    </select-->
        <div id="msgSuc">
            ${msg}
        </div>
        <div id="msgF">
            ${msgF}
        </div>
        <table  class="testTable">         
            <br>
            <thead id="head">
            <script type="text/javascript">
                function selection() {
                <% for (int t = 0; t < vv(); t++) {%>
                <%= idAssign(t)%>.click();
                <%}%>
                }

            </script>
            <tr>
                <td id="name"> Name</td>
                <th id="prog">Program</th>
                <th>Department</th> 
                <th id="sec">Year</th>
                <th id="sec">Section</th>
                <th id="prog">Creator</th>
                <th>Creation Date</th>
                <th>Last Login</th>
                <th id="staHead">Account Status</th>
                <th>Select<br>
                    <input type="checkbox" onchange ="selection();">Select All</div>

                </th>
            </tr>
            </thead>

            <tbody class="bbbb">
                <%!
                    int num;
                    String pr = null;
                    String dp = null;
                %>
                <% for (int i = 0; i < us.length - 1; i++) {%>
                <tr> 
                    <th id="ddd"><%=us[i].getFirstName()%>&nbsp;<%=us[i].getLastName()%></th>
                    <th id="prog"><% pr = program(us[i].getProgram());%><%= pr%></th>
                    <th id="dep"><%dp = department(us[i].getDepartment());%><%= us[i].getDepartment()%></th>
                    <th id="sec"><%=us[i].getYear()%></th>
                    <th id="sec"><%=us[i].getSection()%></th>
                    <th><%=us[i].getCreator()%></th>
                    <th><%=us[i].getCreationDate()%></th>
                    <th><%=us[i].getLastLogin()%></th>
                    <th id="sta"><%num = us[i].getAccountStatus();%><%=accountSta(num)%></th>
                    <th id="cbb"><input type="checkbox" class="chkdata" id=<%=idAssign(i)%>  /></th>

                </tr>    
                <%}%>
            </tbody>
            <tfoot>
                <%!
                    public String idAssign(int n) {
                        String h = null;
                        h = "cb" + n;
                        return h;
                    }
                %>

                <tr>
                    <td>
                        <select id="actionChoice" class="form-control" name="actionChoice">
                            <option value="activate">Activate</option>
                            <option value="deactivate">DeActivate</option>
                        </select>
                        &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<input type="submit" class="lo" name="Activate" value="Done" onclick ="func()">
                        <input type="hidden" name="arraylength">
                        <input type="hidden" class="lo" name="username" value=<%= bean.getUsername()%>>
                        <input type="hidden" name="username" value=<%= bean.getUsername()%>>
                        <input type="hidden" name="length" value=<%= us.length%>>
                        <input type="hidden" name="varlet">   
                        <% for (int i = 0; i < us.length; i++) {%>
                        <input type="hidden" name="userEmail[<%= i%>]" value=<%= us[i].getUsername()%>>
                        <%}%>
                    </td>
                </tr>
            </tfoot>
        </table>
    </form>    
    <div class="loc">
        <jsp:include page="Developers.jsp"/>
    </div>

    <%!
        public String accountSta(int ss) {
            String status = null;
            if (ss == 1) {
                status = "Active";
            } else if (ss == 0) {
                status = "Not Active";
            }
            return status;
        }

        public String program(String pro) {
            String p = null;
            if (pro.equals("ur")) {
                p = "Undergraduate Regular";
            } else if (pro.equals("pr")) {
                p = "Postgraduate Regular";
            } else if (pro.equals("us")) {
                p = "Undergraduate Summar";
            } else if (pro.equals("ue")) {
                p = "Undergraduate Extension";
            } else {
                p = "Department Head";
            }
            return p;
        }

        public String department(String dep) {
            String p = null;
            if (dep.toLowerCase().equals("cs")) {
                p = "Computer Scince";
            } else if (dep.toLowerCase().equals("se")) {
                p = "Software Engineering";
            } else if (dep.toLowerCase().equals("is")) {
                p = "Informaiton System";
            } else if (dep.toLowerCase().equals("it")) {
                p = "Informaiton Technology";
            } else {
                p = "";
            }
            return p;
        }

                                                                    %>


</body>
