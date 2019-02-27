
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
                width:84%;
                top: 0px;       
                line-height: 8px;
                top: calc(40% - 60px);
                left: calc(18% - 100px);
            }
            #failMsg{
                border:0px solid blue;
                height: 20px;
                width: 135%;
                font-size: 18px;               
                color: red;
            } 
            .aaa a{
                color:#5bc0de;
                
            }
            #yesMsg{
                color:green;
            }
            .icon{
                float: left
            }

        </style>
    </head>
    <body style = "background-color:#DFE2DB;color:black;">
        <div class="header">
            <div class="navbar navbar-fixed-top">
                <jsp:include page="Common.jsp"/>
                <div class="aaa">
                    <a href="index.jsp" value="Home">Home</a>
                </div>
            </div>
        </div>         
        <br><br><br><br><br><br><br>
        &nbsp;&nbsp;&nbsp;<center>
        <section  class="loginform"><br><!-- id="header"-->
            <!-- <a href="/other.jsp" class="lo" name="home">Home</a>-->
            <div class="container">
                <div class="col-md-offset-3 col-md-6">
                    <br><br><br>
                    <h2 >Login</h2>
                    <br>
                    <div class="col-md-8 col-md-offset-2">
                        <form name="login" class="loginform2"  method="post" action="loginServlet">
                            <!--User Email-->
                            <div id="failM">
                                ${msgS}
                            </div>
                            <div class="form-group">
                                <!--label for="email">Email</label-->
                                <input type="email" class="form-control" name="email" id="email" placeholder="Enter Your Email" data-rule="email" data-msg="Please enter a valid email" />
                                <div class="validation"></div>
                            </div>
                            <!---/Email-->
                            <!-- password-->
                            <div class="form-group">
                                <!--label>Password</label-->
                                <input type="password" class="form-control" name="password" placeholder="Enter Your Password"/>
                            </div>
                            <!--/password-->
                            <div id="failMsg">
                                ${msg}
                            </div>
                            <div id="yesMsg">
                                ${yesMsg}
                            </div>
                            <br> <br> <br>
                            <input type="submit" class="lo" name="login"value="Login"/>
                            &nbsp; <input type="reset" class="lo" value="Reset"/>
                            <br><br><br><br><br>
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
