<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="model.read"%>
<%@page import="javax.swing.JOptionPane"%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true" import="clearance_management.UserBean,classes.*"
        isThreadSafe="true" info="true" isErrorPage="false" buffer="10kb"%>
<html>
    <head> 
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>CMS</title>
        <link rel="stylesheet" href="css/StyleOne.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/my_style.css">

        <style type="text/css">
            #b{
                overflow:scroll;   
            }
            .menu{
                float: top;
                background-color: #0199d9
            }
            .lo{
                color:green;
                height: 40px;
                line-height: 30px;
                padding-right: 12px;
                padding-left: 20px;
                /**    text-transform: uppercase;*/
                font-size: 18px; 
            }
            .homeBtn{
                float: right;
                color:red;
                font-size:30px;
                position: absolute;
                top: calc(130% - 35px);
                left: calc(138% - 600px);
            }
            #prosel{
                width: 40%;
            }  #yearsel{
                width: 20%;
            }  #accChoice{
                width: 30%;
            }   #depsel{
                width: 40%;
            }
            #name{
                width:40%;
            }
            #secChoice{
                width:20%;
            } #emailChoice{
                width:40%;
            }
        </style>
        <script type="text/javascript">
            function getProgram() {
                var p = document.getElementById(prosel).value;
                alert(p);

            }
            function validate() {
                if (document.createForm.firstname.value.length <= 1)
                {
                    alert("Please provide your name!");
                    document.createForm.firstname.focus();
                    return false;
                }
                if (document.createForm.EMail.value == "")
                {
                    alert("Please provide your Email!");
                    document.createForm.EMail.focus();
                    return false;
                }
                if (document.createForm.Zip.value == "" ||
                        isNaN(document.myForm.Zip.value) ||
                        document.createForm.Zip.value.length != 5)
                {

                    alert("Please provide a zip in the format #####.");
                    document.myForm.Zip.focus();
                    return false;
                }
                if (document.myForm.Country.value == "-1")
                {
                    alert("Please provide your country!");
                    return false;
                }
                return(true);
            }
            function accountChoice() {
                var f = document.getElementById("accChoice").value;
                if (f == "department head") {
                    document.getElementById("prosel").disabled = true;
                    document.getElementById("depsel").disabled = false;
                    document.getElementById("yearsel").disabled = true;
                    document.getElementById("secChoice").disabled = true;
                } else if (f == "faculty store") {
                    document.getElementById("prosel").disabled = true;
                    document.getElementById("depsel").disabled = true;
                    document.getElementById("yearsel").disabled = true;
                    document.getElementById("secChoice").disabled = true;
                } else {
                    document.getElementById("prosel").disabled = false;
                    document.getElementById("depsel").disabled = false;
                    document.getElementById("yearsel").disabled = false;
                    document.getElementById("secChoice").disabled = false;
                }
            }
            function check() {
                document.getElementById("prosel").focus();
            }

        </script>
    </head>
    <body style = "background-color:#DFE2DB;color:black;">
        <div class="navbar navbar-fixed-top" role="navigation" data-0="line-height:100px; height:100px; background-color:red ;" data-300="line-height:60px; height:60px; background-color:red;">
            <jsp:include page="Common.jsp"/>
            <div class="homeBtn">
                <a href="index.jsp" >Home</a>
            </div>
        </div>
        <%!
            public String[] departments;
            public String rolePre;
            public String officePre;
        %>
        <%@page import="model.Test"%>
        <jsp:useBean id="bean" class="clearance_management.UserBean" scope="session" />

        <%
            departments = (String[]) request.getAttribute("department");
            if (bean.getOffice().equals("faculty")) {
                rolePre = "Advisor";
                officePre = "faculty";

            } else {
                rolePre = "privileged_user";
                officePre = (bean.getOffice());
            }
        %>

        <div class="menu">
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
        <!----------Create Account---------------->
        <form name="createAccount" name="createForm" id="create" class="createAccount" action="createAccountServlet2"onsubmit="return(validate());" method="post">

            <legend>User Registration Form
                <% if (bean.getOffice().equals("faculty")) {%>
                &nbsp;  &nbsp;  &nbsp;<select  class="form-control" name="accountType" id="accChoice" onclick="accountChoice()">
                    <option value="advisor">Advisor</option>
                    <option value="department head">Department Head</option>
                    <option value="faculty store">Faculty Store</option>
                </select>
                <%}%>
            </legend>
            <div class="form-group">
                &nbsp;  &nbsp;<input type="text" class="form-control" id="name" name="firstname" placeholder="Enter First Name"> 
                &nbsp;&nbsp; <input type="text" class="form-control"  id="name" name="lastname" placeholder="Enter Last Name"> <br>
            </div>
            <div class="form-group">
                &nbsp;  &nbsp;
                <% if (bean.getOffice().equals("faculty")) {%>
                <select name="program"  class="form-control" id="prosel">
                    <option>Select Program</option>
                    <option value="ur">Undergraduate Regular</option>
                    <option value="us">Undergraduate Summer</option>
                    <option value="ue">Undergraduate Extension</option>
                    <option value="pr">Postgraduate Regular</option>
                    <option value="ps">Postgraduate Summer</option>
                </select>
                &nbsp;&nbsp;
                <select name="department" class="form-control"id="depsel">
                    <option>Select the Department</option>
                    <% for (int i = 0; i < departments.length; i++) {%>
                    <option value=<%= departments[i]%>><%= departments[i]%></option>
                    <%}%>
                </select>
            </div>
            <div class="form-group">
                &nbsp;  &nbsp;  &nbsp;<select name="year" class="form-control"  id="yearsel">
                    <option>Year</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>    
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                </select>
                &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="form-control" name="section" id="secChoice" placeholder="Section">
            </div>
            <%}%>
            <div class="form-group">
                &nbsp;&nbsp;  &nbsp;<input type="email" class="form-control" name="email" id="emailChoice" placeholder="Enter Email Address" data-rule="email" data-msg="Please enter a valid email" />
                <div class="validation"></div>
            </div>
            <input type="hidden" class="form-control" value=<%= rolePre%>  name="userrole" placeholder="Advisor" readonly>
            <input type="hidden" name="creator" value=<%= bean.getUsername()%>>
            <input type="hidden" class="form-control" value=<%= officePre%>  name="office" placeholder="Advisor" readonly>
            <div id="failMsg">
                ${msg}
            </div> 
            <div id="Msg">
                ${msgSuc}
            </div><BR>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"class="lo" name="createAccount" value="SINE UP" onclick="check()"/>
            &nbsp;&nbsp;&nbsp; <input type="reset"class="lo" name="createAccount" value="Cancel"/>
        </form>
        <div class="loc">
            <jsp:include page="Developers.jsp"/>
        </div>
    </body>
</html>