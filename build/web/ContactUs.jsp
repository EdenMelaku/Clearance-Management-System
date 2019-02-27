
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us</title>
        <link rel="stylesheet" href="css/StyleOne.css">
        <link rel="stylesheet" href="css/style.css">

        <style type="text/css">
            #name{
                size: 20%;
            }.container{
                position: absolute;
                top: calc(23% - 35px);
                left: calc(30% - 242px);
                width: 80%;
            }
            #name{
                width:45%;
            }#email{
                width:45%;
            }
            #imga{                top: calc(53% - 35px);
                left: calc(30% - 242px);

                width:90;
                float:left
                    
            }
        </style>

    </head>
    <body style = "background-color:#DFE2DB ;color:black;">
        <div class="header">
            <div class="navbar navbar-fixed-top">
                <jsp:include page="Common.jsp"/>
                <div>
                    <a href="index.jsp" value="Home">Home</a>
                </div>
            </div>
        </div>      

        <div class="container" id="contactBound">

            <center> <h2>Contact us</h2></center>

            <div class="col-md-8 col-md-offset-2">
                If You Have any Comment or Question Regarding this System usage we are ready to fix it
                <form action="/MessageServlet" name="contact" method="post" role="form" class="contactForm">
                    <div class="form-group">
                        <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="maxlen:4" data-msg="Please enter at least 4 chars" />

                        <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
                        <div class="validation"></div>

                        <label for="subject">Subject</label>
                        <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="maxlen:4" data-msg="Please enter at least 8 chars of subject" />
                        <div class="validation"></div>

                        <label for="message">Message</label>
                        <textarea class="form-control" name="message" rows="" data-rule="required" data-msg="Please write something for us"></textarea>
                        <div class="validation"></div>
                    </div>
                    <button type="submit"  class="button" >SEND MESSAGE</button>
                </form>
            </div>
        </div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <div id="imga">
            <img src="img/phone.png" width="18%" alt="profile image" >0947416048[EDEN]
        </div> 
<div id="imga">
            <img src="img/phone.png" width="18%" alt="profile image" >0914673987[ROBEL]
        </div> 
        <div class="loc">
            <jsp:include page="Developers.jsp"/>
        </div>  
    </body>
</html>
