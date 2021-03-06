/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pdfWriting;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import newServletAndModelClasses.getMystatus;
import otherService.StudentClearanceInfo;

/**
 *
 * @author Roba
 */
public class StudensRegistrarStatus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String id = request.getParameter("id");

            StudentClearanceInfo cinfo = getMystatus.getmystatus(id);
            request.setAttribute("studInfo", cinfo);
            getServletContext().getRequestDispatcher("/RegistrarPage.jsp").forward(request, response);

        } catch (NullPointerException ex) {
            try {
                request.setAttribute("msgFail", "Invalid id");
                getServletContext().getRequestDispatcher("/RegistrarServlet").forward(request, response);
            } catch (ServletException | IOException ex1) {

            }
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            try {
                if (ex.getErrorCode() == 1403) {
                    request.setAttribute("msgFail", "Invalid id");
                    getServletContext().getRequestDispatcher("/RegistrarServlet").forward(request, response);
                } else {
                    request.setAttribute("msg", "error occured while getting  data!   ");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                }
            } catch (NullPointerException | ServletException | IOException ex1) {
                request.setAttribute("msg", "Error occured while getting  data!");
                try {
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                } catch (ServletException | IOException ex2) {

                }
            }
        } catch (ServletException | IOException ex) {

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
