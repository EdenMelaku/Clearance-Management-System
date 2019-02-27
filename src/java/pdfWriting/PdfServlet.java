package pdfWriting;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import otherService.StudentClearanceInfo;

public class PdfServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String fs = request.getParameter("fsta");
        if (Integer.parseInt(fs) != 0) {
            request.setAttribute("username", request.getParameter("uname"));
            try {
                StudentClearanceInfo sci;
                sci = new StudentClearanceInfo("01001", "Aklilu", "Lemma", "Graduation", 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2);
                request.setAttribute("studInfo", sci);
                getServletContext().getRequestDispatcher("/RegistrarPage.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                try {
                    request.setAttribute("msg", " Error occured while data please try again!");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                } catch (ServletException | IOException ex1) {

                }
            }
        } else {

            GeneratePDF gp = new GeneratePDF();
            try {
                String filename = id + ".pdf";
                gp.createPdf(id);
            } catch (DocumentException ex) {
                Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("id", id);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PdfTest.jsp");
            dispatcher.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
