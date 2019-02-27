<%-- 
    Document   : Developers
    Created on : Sep 16, 2017, 4:57:59 AM
    Author     : Roba
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Developers</title>
    </head>
    <body>
     <div>
                <%!
                    public static int currentYear() {//this is to write current date to file 
                        GregorianCalendar gc = new GregorianCalendar();
                        int year = gc.get(Calendar.YEAR);
                        return year;
                    }
                                                                                                                    %>
                <div class="col-sm-12">
                    <center>
                        <p>Copyright &copy; <%=currentYear()%> BIT <a href="http://www.bdu.edu.et">Bahir Dar University</a></p>
                        <div class="developer">
                            Designed and Implemented By Robel Milashu and Eden Melaku   
                        </div>
                    </center>
                </div>
            </div>     </body>
</html>
