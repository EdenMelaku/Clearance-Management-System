

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.SQLException"%>
<%@page import="clearance_management.user"%>
<%@page import="model.read"%>
<%@page import="otherService.stakeholderrow"%>
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

        #idNum{
            width:8.5%;
            /**  color: #007090;*/
            /**   font-size: 17px;*/
            border-bottom: 1px solid #1d96b2;
            font-weight: normal;
            text-align: left;  
        } #name{
            width:8%;
            /*   color: #007090;*/
            /** font-size: 17px;*/
            border-bottom: 1px solid #1d96b2;
            font-weight: normal;
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
            width: 9%;
            color: #007090;;
            font-size: 20px;
            border-bottom: 1px solid #1d96b2;
            font-weight: normal;
            text-align: center;  
        }
        #refresh{
            /**width:8%;*/
        }
        .ab{
            text-align: left;
            text-transform: capitalize
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
        stakeholderrow[] data = (stakeholderrow[]) request.getAttribute("data");
    %>

    <div class="menu">
        <ul class="widget-container"><li id="text-15" class="widget widget_text"><h3 class="widgettitle">Menu</h3>		
                <div class="textwidget"><ul>

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
    <div  class="student_table" id="tt">
        <table class="testTable">         
            <thead id="head">

                <tr>

                    <td><input type="text"class="myField1" ID="id"  placeholder="Search By Id..." onkeydown="Filter(this)" >
                    <td><input type="text"class="myField1" ID="fname" placeholder="First Name..."   onkeydown="Filter(this)" /></td>
                    <td>
                        <a href="getofficeStatusServlet?username=<%=bean.getUsername()%>" id="refresh">Refresh</a>
                    </td>
                    <!--td><input type="text" ID="zupanija"   onkeydown="Filter(this)" /></td-->     
                </tr>
                <tr>
                    <th>ID</th>
                    <th> Name</th>
                    <th id="refresh">Approved By</th>
                    <th >Approval Date</th>
                    <th > Status </th>
                    <th >Other</th>

                </tr>
            </thead>
            <tfoot>
            </tfoot>

            <tbody class="bbbb">
                <%
                    int a = 0;
                    String em = null;    String b = null;
                %>
                <%for (int i = 0; i < (data.length - 1); i++) {%>
                <tr class="aa">
                    <th id="idNum"><%= data[i].getId()%></th>
                    <th id="name"><%= read.getStudent(data[i].getId()).getFirstName()%><% out.print("  ");%><%=read.getStudent(data[i].getId()).getLastname()%></td>
                    <th id="refresh" id="ab"><% em = data[i].getApprovedby();%><%= activator(em)%></td>
                    <th><%= data[i].getApprovalDate()%></td>
                    <th><% a = data[i].getStatus();%><%= status(a)%></td>
                    <th><% a = data[i].getCs();%><% b = data[i].getApprovedby();%><%= cafeStatus(a,activator(em))%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
</div>
<%!
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
        } else {
            status = "Unknown";

        }
        return status;
    }

    public String activator(String email) {
        String name = null;
        if (email.toLowerCase().equals("default")) {
            name = "System";
        } else {
            try {
                user u = read.getAUser(email);
                name = u.getFirstName() + " " + u.getLastName();
            } catch (ClassNotFoundException e) {
                name = "Unknown";
            } catch (SQLException e) {
                name = "Unknown";
            }
        }

        return name;
    }

    public static String cafeStatus(int t, String k) {
        String s = null;
        if (k.toLowerCase().matches("biniam mezgebe")) {
            s = "Cafe";
        } else if (t == 0) {
            s = "Non Cafe";
        } else {
            s = "Cafe";
        }
        return s;
    }




%>
<div class="loc">
    <jsp:include page="Developers.jsp"/>
</div>   
</body>