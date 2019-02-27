
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="true"
        isThreadSafe="true" info="true" isErrorPage="false" buffer="10kb"%>

<%@page import="java.io.File"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.DocumentException"%>
<%@page import="com.itextpdf.text.pdf.PdfReader"%>
<%@page import="com.itextpdf.text.pdf.PdfImportedPage"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<html>
    <head>
        <title>Student File</title>
    </head>
    <body style = "background-color:#DFE2DB;color:black;">
        <%
            response.reset();
            //response.setContentType("application/pdf");
            File file = new File((String)request.getAttribute("id")+".pdf");
            //  response.setHeader("Content-Type", "application/pdf");
            //response.setHeader("Content-Disposition",
            //      "inline;filename=student.pdf");
            //response.setContentLength((int) file.length());
            //response.setHeader("Content-Type",
            //      getServletContext().getMimeType(file.getName()));
            //response.setHeader("Content-Length", String.valueOf(file.length()));
            //OPen an input stream to the file and post the file contents thru the
            //servlet output stream to the browser
            FileInputStream in = new FileInputStream(file);
            ServletOutputStream outs = response.getOutputStream();
            response.setContentLength(in.available());
            byte[] buf = new byte[8192];
            int c = 0;
            try {
                while ((c = in.read(buf, 0, buf.length)) > 0) {
                    outs.write(buf, 0, c);
                    out.write(outs.toString());
                }

            } catch (IOException ioe) {
                ioe.printStackTrace(System.out);
            } finally {
                outs.flush();
                outs.close();
                in.close();
            }
        %>

    </body>
</html>