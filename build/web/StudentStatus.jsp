<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="otherService.StudentClearanceInfo" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true"
        isThreadSafe="true" info="true" isErrorPage="false"  buffer="10kb"%>

<head>
    <meta charset="utf-8">
    <title>CMS</title>
    <link rel="stylesheet" href="css/StyleOne.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/my_style.css">
    <link rel="stylesheet" href="css/StatusTable.css">
    <script src="javascript/an.js"></script>

    <style type="text/css">
        #tt{
            position: absolute;
            top: calc(27% - 35px);
            left: calc(35% - 220px);
            width: 79%;
        }
        #refresh{
            width:7.5%;
        }
        #idNum{
            width:10%;
            font-size: 18px;
            border-bottom: 1px solid #1d96b2;
            text-align: center; 

        } #name{
            width:13.25%;
            font-size: 18px;
            border-bottom: 1px solid #1d96b2;
            text-align: left; 
            text-transform: capitalize

        } #idd{
            width:14%;
            font-size: 18px;
            border-bottom: 1px solid #1d96b2;
            text-align: left; 
            text-transform: capitalize

        }
        #caffe{
            width: 8%;
            color: #007090;;
            font-size: 17px;
            border-bottom: 1px solid #1d96b2;
            font-weight: normal;
            text-align: center;  
        }   #dh{
            width: 8.5%;
            font-size: 18px;
            border-bottom: 1px solid #1d96b2;
            font-weight: normal;
            text-align: center;  
        }
    </style>

</head>
<body style = "background-color:#DFE2DB;color:black;">
    <div class="header">
        <div class="navbar navbar-fixed-top">
            <jsp:include page="Common.jsp"/>
        </div>
    </div>

    <jsp:useBean id="bean" class="clearance_management.UserBean" scope="session" />
    <%
        StudentClearanceInfo[] stud = (StudentClearanceInfo[]) request.getAttribute("studInfo");
    %>

    <div class="menu">
        <ul class="widget-container"><li id="text-15" class="widget widget_text"><h3 class="widgettitle">Menu</h3>		
                <div class="textwidget"><ul>
                        <li> 
                            <a href="initiateClearance1?username=<%=bean.getUsername()%>&amp; userRole=<%=bean.getUserRole()%>" accesskey="1" title="">
                                Initiate Clearance</a> </li>              
                        <li>
                            <a href="ApproveClearanceFilterServlet?username=<%= bean.getUsername()%>" >
                                Approve Clearance Status</a></li>

                        <li><a href="GetStudentStatusServlet?username=<%=bean.getUsername()%>" accesskey="1" title="">
                                Get Student Status</a>  </li>

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
    <div  class="student_table" id="tt">
        <table class="testTable">         
            <thead id="head">

                <tr>

                    <td><input type="text"class="myField1" ID="id"  placeholder="Search By Id..." onkeydown="Filter(this)" >
                    <td><input type="text"class="myField10" ID="fname" placeholder="First Name..."   onkeydown="Filter(this)" /></td>
                    <td>   <a href="GetStudentStatusServlet?username=<%=bean.getUsername()%>" >Refresh</a>
                    </td>
                    <!--td><input type="text" ID="zupanija"   onkeydown="Filter(this)" /></td-->     
                </tr>
                <tr>
                    <th id="idd">ID</th>
                    <th id="name"> Name</th>
                        <%if (bean.getProgram().equals("ur") || bean.getProgram().equals("us")) {%>
                    <th>Cafe</th>
                    <th >Housing Office</th>
                        <%}%>
                    <th >Sport Master</th>
                    <th >Faculty Store</th>
                    <th>Library</th>
                        <%if (bean.getProgram().equals("pr")) {%>
                    <th >Dean Of Research</th>
                        <%}%>
                        <%if (bean.getProgram().equals("ue")) {%>
                    <th >Continuing Education</th>
                    <th>Cont.Edu Business Affair</th>
                        <%}%>
                    <th>Advisor</th>
                    <th>Department Head</th>
                    <th>Registrar</th>
                    <th>Final Status</th>
                </tr>
            </thead>
            <tfoot>

            </tfoot>

            <tbody class="bbbb">
                <%for (int i = 0; i < (stud.length - 1); i++) {%>
                <tr class="aa">
                    <%! int num = 0;%>
                    <td id="idNum"><%= stud[i].getSID()%></th>
                    <td id="name"><%= stud[i].getFirstName()%><% out.print("  ");%><%= stud[i].getLastName()%></td>
                    <%if (bean.getProgram().equals("ur") || bean.getProgram().equals("us")) {%>
                    <th id="refresh"><% num = stud[i].getStudentCaféStatus();%><%=status(num)%></th>
                    <th><%num = stud[i].getHousingOfficeStatus();%><%=status(num)%></td>
                        <%}%>
                    <th><%num = stud[i].getSportMasterStatus();%><%=status(num)%></td>
                    <th><% num = stud[i].getFacultyStoreStatus();%><%=status(num)%></td>
                    <th><%num = stud[i].getLibraryStatus();%><%=status(num)%></td>
                        <%if (bean.getProgram().equals("pr")) {%>
                    <th><% num = stud[i].getDeanOFRPGStatus();%><%=status(num)%></td>
                        <%}%> 

                        <%if (bean.getProgram().equals("ue")) {%>
                    <th><% num = stud[i].getContinuingEducationStatus();%><%=status(num)%></td>
                    <th><%num = stud[i].getContinuingEducationBAStatus();%><%=status(num)%></td>
                        <%}%>
                    <th ><%num = stud[i].getAdvisorStatus();%><%=status(num)%>	</td>
                    <th id="dh"><%num = stud[i].getDepartmentHeadStatus();%><%=status(num)%></th>
                    <th><%num = stud[i].getRegistrarStatus();%><%=status(num)%></td>
                    <th><%num = stud[i].getFinalStatus();%><%=finalStatus(num)%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
</div>
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
%>

<div class="loc">
    <jsp:include page="Developers.jsp"/>
</div>   
</body>