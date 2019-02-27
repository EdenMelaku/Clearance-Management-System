

<%@page import="javax.swing.JOptionPane"%>
<%@page import="otherService.StudentClearanceInfo"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true"
        isThreadSafe="true" info="true" isErrorPage="false"  buffer="10kb"%>
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
            .name{
                font-size: 30px;
                color:green;

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
        <%
            StudentClearanceInfo stud = (StudentClearanceInfo) request.getAttribute("studInfo");
            String name=stud.getFirstName()+" "+stud.getLastName();
%>
        <jsp:useBean id="bean" class="clearance_management.UserBean" scope="session" />

        <div class="main">
            <form class="form-wrapper cf" method="post" action="getMyStatusServlet" >
                <input type="text"name="id" placeholder="Search By Id Here..." >
                <button type="submit">Search</button>
            </form>
        </div>

        <div id="imga">
            <img src="img/images.jpg" width="310%" alt="profile image" >
        </div> 
        <div class="name">
            <br><br><br><br><br><br><br>&nbsp;&nbsp;<%= name%>
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
                            <th>0801770</th>
                            <td ><%= name.toUpperCase() %></td>
                            <td><% num = stud.getStudentCaféStatus() ;%><%=status(num)%></td>
                            <td><% num = stud.getHousingOfficeStatus();%><%=status(num)%></td>
                            <td><% num = stud.getSportMasterStatus();%><%=status(num)%></td>
                            <td><%  num = stud.getFacultyStoreStatus();%><%=status(num)%></td>
                            <td><% num = stud.getLibraryStatus();%><%=status(num)%></td>
                            <td ><% num = stud.getAdvisorStatus();%><%=status(num)%>	</td>
                            <td><% num = stud.getDepartmentHeadStatus();%><%=status(num)%></td>
                            <td><% num = stud.getRegistrarStatus();%><%=status(num)%></td>
                            <td><%num = stud.getFinalStatus();%><%=finalStatus(num)%></td>
                        </tr>
                    </tbody>
                </table>
            </div>  
        </form>
        <%!

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
                                                                                                        %>
        <div class="loc">
            <jsp:include page="Developers.jsp"/>
        </div>
    </body>
</html>
