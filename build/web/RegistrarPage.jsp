

<%@page import="clearance_management.user"%>
<%@page import="model.read"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="otherService.StudentClearanceInfo"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true"
        isThreadSafe="true" info="true" isErrorPage="false" errorPage="MyErrorPage.jsp" buffer="10kb"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMS Student</title>
        <link rel="stylesheet" href="css/StyleOne.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/my_style.css">
        <link rel="stylesheet" href="css/t.css">

        <style type="text/css">
            #imga{
                width:90;
                float: left;
            }
            .main{
                float: center;
            }
            .gene{

            }
            .name{
                font-size: 30px;
                color:green;
            }
            .final{
                color:red;
                font-style: bold;
            }



            .form-wrapper2 button {
                padding: 5px;
                overflow: visible;
                position: relative;
                float: right;
                border: 0;
                padding: 0;
                top: calc(40% - 50px);
                left: calc(2% - 50px);

                cursor: pointer;
                height: 40px;
                width: 110px;
                font: bold 15px/40px 'lucida sans', 'trebuchet MS', 'Tahoma';
                color: #fff;
                text-transform: uppercase;
                background: #d83c3c;

            }   

            .form-wrapper2 button:hover{		
                background: #e54040;
            }	

            .form-wrapper2 button:active,
            .form-wrapper button:focus{   
                background: #c42f2f;    
            }

            .form-wrapper2 button:before {
                content: '';
                position: absolute;
                border-width: 8px 8px 8px 0;
                border-style: solid solid solid none;
                border-color: transparent #d83c3c transparent;
                top: calc(280% - 100px);
                left: calc(82% - 100px);
            }

            .form-wrapper2 button:hover:before{
                border-right-color: #e54040;
            }

            .form-wrapper2 button:focus:before{
                border-right-color: #c42f2f;
            }    

            .form-wrapper2 button::-moz-focus-inner {
                border: 0;
                padding: 0;
            }
        </style>
    </head>
    <body style = "background-color:#DFE2DB;color:black;">

        <div class="header">
            <div class="navbar navbar-fixed-top">
                <jsp:include page="Common.jsp"/>
            </div>
        </div>
        <div class="link_home">
            <a href="index.jsp" >Home</a>
        </div>
        <%!
            public String username;
        %>
        <%
            username = (String) request.getAttribute("username");
        %>
        <%
            StudentClearanceInfo stud = (StudentClearanceInfo) request.getAttribute("studInfo");
            String name = stud.getFirstName() + " " + stud.getLastName();
        %>
        <jsp:useBean id="bean" class="clearance_management.UserBean" scope="session" />

        <div class="main"><!--  PdfServlet  -->
            <form class="form-wrapper cf" method="post" action="StudensRegistrarStatus">
                <input type="text" name="id" placeholder="Search By Id Here..." >
                <button type="submit">Search</button>
            </form>
        </div>><br><br><br><br><br><br><br><br><br><br>
        <form class="form-wrapper2 cf" method="post" action="PdfServlet">
            <%num = stud.getFinalStatus();%>
            <input type="hidden" name="id" value=<%= stud.getSID()%> >
            <input type="hidden" name="uname" value=<%= username%> >
            <input type="hidden" name="fsta" value=<%= stud.getFinalStatus()%> >
            <button type="submit">Generate</button>
        </form>
        <div class="menu">
            <ul class="widget-container"><li id="text-15" class="widget widget_text"><h3 class="widgettitle">Menu</h3>		
                    <div class="textwidget"><ul>

                            <li>
                                <a href="ApproveClearanceFilterServlet?username=<%= bean.getUsername()%>" >
                                    Approve Clearance Status</a></li>
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
                                    <% if (bean.getOffice().toLowerCase().equals("registrar")) {%>

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
        <form  class="student_status_table">
            <div style="height:200px; overflow: auto"> 
                <table class="responsive-table1">         
                    <!--     <caption>Student Status</caption>-->
                    <br>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Full Name</th>
                            <th>Cafe</th>
                            <th >Housing Office</th>
                            <th >Sport Master</th>
                            <th >Faculty Store</th>
                            <th>Library</th>
                            <th>Advisor</th>
                            <th>Department Head</th>
                            <th>Registrar</th>
                            <th>Final Status</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <td colspan="7">BIT , <a href="www.fb.com" rel="external">Clearance Management System</a></td>
                        </tr>
                    </tfoot>

                    <tbody>
                        <tr>
                            <%! int num = 0;%>
                            <th><%= stud.getSID()%></th>
                            <td ><%= name.toUpperCase()%></td>
                            <td><% num = stud.getHousingOfficeStatus();%><%=status(num)%></td>
                            <td><% num = stud.getStudentCaféStatus();%><%=status(num)%></td>
                            <td><% num = stud.getSportMasterStatus();%><%=status(num)%></td>
                            <td><%  num = stud.getFacultyStoreStatus();%><%=status(num)%></td>
                            <td><% num = stud.getLibraryStatus();%><%=status(num)%></td>
                            <td ><% num = stud.getAdvisorStatus();%><%=status(num)%>	</td>
                            <td><% num = stud.getDepartmentHeadStatus();%><%=status(num)%></td>
                            <td><% num = stud.getRegistrarStatus();%><%=status(num)%></td>
                            <td class="final"><%num = stud.getFinalStatus();%><%=finalStatus(num)%></td>
                        </tr>
                    </tbody>
                </table>
            </div>  
        </form>
        <%!

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
                                                                                                                                                                                                                                                                                                        %>

        <div class="loc">
            <jsp:include page="Developers.jsp"/>
        </div>
    </body>
</html>
