<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="model.read"%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true" import="clearance_management.UserBean,classes.*"
        isThreadSafe="true" info="true" isErrorPage="false" buffer="10kb"%>
<head> 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>CMS</title>
    <link rel="stylesheet" href="css/StyleOne.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/my_style.css"/>
    <style type="text/css">
        #b{
            overflow:scroll;   
        }
        .bod{
            border:0px solid blue; width:45.2%; align:center;
            margin:0.2%;
            padding:0.2%;
            float: left;

        }  
        #searchIt{
            top: calc(15% - 35px);
            left: calc(10% - 243px);
        }
        #userName{
            background-color: #428bca;
            float: right;
            height: 70px;
            font-size: 25px;
            font-family: times new roman;
            width: 27%;
            color:white;
            text-transform: capitalize
        }

        .bod2{
            border:0px solid blue; width:45.2%; align:center;
            padding-right: 70px;
            padding-left: 0px;
            float: right;
        }  
        #logoutLink{
            font-size: 20px;
        }
        .msgBox{
            border:0px solid #080808; width:50%; align:center;
            top: calc(35% - 60px);
            left: calc(27% - 100px);
            height: 50%;
            padding: 5px;
            position: fixed;

        }
    </style>

    <script type="text/javascript">
        function logout() {
            window.location = "Login.jsp";
        }
    </script>

</head>
<body style = "background-color:#DFE2DB;color:black;">
    <div class="header">
        <div class="navbar navbar-fixed-top">
            <jsp:include page="Common.jsp"/>
        </div>
    </div>

    <jsp:useBean id="bean" class="clearance_management.UserBean" scope="session" />

    <%
        username = (String) request.getAttribute("username");
        pass = request.getParameter("password");

    %>

    <%        read r = new read();
        userData = r.getUserData(username, pass);
        bean.setUsername(userData[0]);
        bean.setFirstName(userData[1]);
        bean.setLastName(userData[2]);
        bean.setPassword(userData[3]);
        bean.setOffice(userData[4]);
        bean.setUserRole(userData[5]);
        bean.setDepartment(userData[6]);
        bean.setYear(Integer.parseInt(userData[7]));
        bean.setProgram(userData[8]);
        bean.setSection(userData[9]);
        bean.setAccountStatus(Integer.parseInt(userData[10]));
    %>

    <%!
        String username;
        String pass;
        Object o;
        public String[] userData;
        read r;
                                                                                                                                                                                                                    %>


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
                                <% if (bean.getOffice().toLowerCase().equals("sport master") || bean.getOffice().toLowerCase().equals("library") || bean.getOffice().toLowerCase().equals("faculty store")| bean.getOffice().toLowerCase().equals("housing office") | bean.getOffice().toLowerCase().equals("student cafe") && bean.getUserRole().equals("privileged_user")) {%>            
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
                      <!--  <li><a href="filterStudentsForNONCAFEservlet?username=<%=bean.getUsername()%>" accesskey="1" title="">
                                Register Non Cafe</a>  </li>
-->
                        <%}%>
                        <% if (bean.getOffice().toLowerCase().equals("dean office")) {%>
                        <li><a href="FilterForActivateClearanceServlet?username=<%=bean.getUsername()%>" >
                                Activate Student</a></li>
                        <li><a href="FilterForDeactivateClearanceServlet?username=<%=bean.getUsername()%>" >
                                Deactivate Student</a></li>
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
    <br><br><br><br><br><br><br>
    <div id="userName" class="widget-container">
        &nbsp;<%= bean.getFirstName().toUpperCase()%><% out.println(" ");%><%= bean.getLastName().toUpperCase()%>
        <br> &nbsp; &nbsp;   <%= bean.getOffice()%>
    </div>

    <div class="msgBox">
        <!--center><h1>Welcome To Cms BIT</h1></center>
        <h2>Recommendation</h2-->
        <hr>
        <h2>
            ${msg}
        </h2>
        <hr>

    </div>

    <div class="loc">
        <jsp:include page="Developers.jsp"/>
    </div>
</body>