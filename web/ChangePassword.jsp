
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true"
        isThreadSafe="true" info="true" isErrorPage="false" errorPage="MyErrorPage.jsp" buffer="10kb"%>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/StyleOne.css">
        <link rel="stylesheet" href="css/style.css">

        <style type="text/css">
            .loginform{
                border:1px solid blue;
                left: calc(10% - 100px); 
                width:80.2%;
                top: 0px;       
                line-height:12px;
                top: calc(40% - 60px);
                left: calc(18% - 100px);
            }
            #failMsg{
                height: 20px;
                font-size: 15px;               
                color: red;
            } 
            #yesMsg{
                color:green;
            }
            .icon{
                float: left
            }
            .changepass{
                color: black;
                padding-right: 12px;
                padding-left: 10px;
                width: 240px;
            }
            #failMsg2{
                color: red
            }#Msg{

                color: green

            }

        </style>
    </head>
    <body style = "background-color:#DFE2DB;color:black;">
        <div class="header">
            <div class="navbar navbar-fixed-top">
                <jsp:include page="Common.jsp"/>
                <div>
                    <a href="index.jsp" value="Home">Home</a>
                </div>
            </div>
        </div>
                <%!
                String username=null;
                %>
        <%
             username = (String) request.getAttribute("username");
        %>
        <br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;<center>

        <div class="container">
            <div class="col-md-offset-3 col-md-6">
                <br>
                <div class="col-md-8 col-md-offset-2">
                    <form method="post" action="changePasswordServlet">
                        <section  class="changepass">
                            <br>
                            <div class="form-group">
                                <input type="hidden" name="username" value=<%= username%>>
                                <input type="password"class="form-control" name="oldpass" placeholder="Enter Your Old Password"><br>
                            </div> 
                            <div class="form-group">
                                <input type="password"class="form-control" name="newpass1" placeholder="Enter Your New Password"><br>
                            </div>                                <div class="form-group">
                                <input type="password" class="form-control" name="newpass2" placeholder="Confirm Your New Password"><br>
                            </div>         
                            <div id="Msg">
                                ${msg}
                            </div><div id="failMsg2">
                                ${failMsg}
                            </div><br>
                            <input type="submit" class="changePassword" name="passchange"value="Submit" >&nbsp;&nbsp; <input type="reset" class="changePassword" name="passchange" value="Cancel">
                        </section>
                    </form>   
                </div>
            </div>
        </div>
    </section><br><br></center>
<div class="loc">
    <jsp:include page="Developers.jsp"/>
</div>
</body>
</html>
