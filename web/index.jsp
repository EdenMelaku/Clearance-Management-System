
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true"
        isThreadSafe="true" info="true" isErrorPage="false" errorPage="MyErrorPage.jsp" buffer="10kb"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>CMS</title>
        <link rel="stylesheet" href="css/StyleOne.css">
        <link rel="stylesheet" href="css/style.css">

        <style type="text/css">

            .linked{
                border:1px solid ; width:16%;height:48%; align:center;
                margin:0.2%;
                color:black;
                height:420px;
                padding:0.2%;
                top: 22%;position: absolute;
                float: left;
            }
            .stulink{
                color:black;
                font-size: 15pt;
            }
            .linked a{
                color: #5bc0de;
            }
            .linked a:hover {
                /**background-color: #00c6ff;    */
                font-size: 18pt;
                color:blue;
            }
            .bod{
                border:1px solid blue; width:72%;
                margin:0.2%;                
                color:black;
                height:420px;
                padding:0.2%;
                float: right;
                left: 20%;
                top: 22%;position: absolute;
            } 
            #included{
                /* border:1px solid blue; */
                color:black;
                height:133px;
                float: right;
                position: absolute;
            }
        </style>
    </head>
    <body>
        <div id="included" class="navbar navbar-fixed-top">
            <jsp:include page="Common.jsp"/>
        </div>
        <div class = "bod">
            <h1>Students Clearance Management System </h1>
            <a class="navbar-brand"a href="Login.jsp">LOGIN
            </a>
            <hr>
            <pre>  
<h4 class="ttext"> 
                1. The Password initially Given is your last name 123 and hash tag<br>
                2. If you want to have a healthy relationship with the university,it is very important to the student <br>
                to complete this clearance properly and return the university registrar before you leave the university <br>
                campus whatever reason may be. Only with the paper termination below can official transcripts,<br>
                letter of enrollment, student copy or honorable dismissal be issued. Re admission to any unit of the<br> 
                university will be considered only if proper termination is certified by the university registrar.
</h4>
            </pre> <br>
        </div>
        <div class = "linked">
            <ul><div class="stulink">		
                    <hr>
                    <!--li--><a href="StudentIntermidateServlet2">Student</a><!--/li--><hr>
                    <!--li--><!--a href="ContactUs.jsp">Contact Us</a><!--/li-->
                </div>       
            </ul></div> 
        <div class="loc">
            <jsp:include page="Developers.jsp"/>
        </div>
    </body>
</html>