<%-- 
    Document   : MyErrorPage
    Created on : Oct 17, 2017, 8:46:47 PM
    Author     : Roba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>

        <style type="text/css">
            #imga{
                width:90;
                float: left;
            }
            .mss{
                float: none

            }

        </style>
    </head>
    <body style = "background-color:#DFE2DB;color:black;">

        <div id="imga">
            <img src="img/err.png" width="110%" alt="profile image" >        </div> 

        <div class="mss" id="msgF">
            <h1>       
&nbsp;&nbsp; ${msg}
                
&nbsp;&nbsp; "Some Thing Went Wrong"</h1>
        </div>
    </body>
</html>
