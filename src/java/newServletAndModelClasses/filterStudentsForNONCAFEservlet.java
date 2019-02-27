/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newServletAndModelClasses;

import clearance_management.StudentBean;
import clearance_management.user;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.read;

public class filterStudentsForNONCAFEservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String username = null;
        try {
            username = request.getParameter("username");
            user u = read.getAUser(username);
            StudentBean ab[] = filterStudentsForUpdate.FilterForNoncafeRegistration();
            if (ab.length == 2) {
                request.setAttribute("msg", "All Students Have bean Registered");
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);

            } else {
                request.setAttribute("username", username);
                request.setAttribute("student", ab);
                request.setAttribute("firstname", u.getFirstName());
                request.setAttribute("userrole", u.getUserRole());
                request.setAttribute("office", u.getOffice());
                getServletContext().getRequestDispatcher("/RegisterNonCafe.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            try {
                if (ex.getErrorCode() == 1403) {
                    request.setAttribute("msgFail", "All Students are Registered");
                    getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
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
        } catch (NullPointerException ex) {
            try {
                request.setAttribute("msg", "there is no student available for updating all are non cafe  ");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);

            } catch (ServletException | IOException ex1) {

            }
        } catch (ClassNotFoundException | ServletException | IOException ex) {
            request.setAttribute("msg", "Error occured while getting students data!");
            try {
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            } catch (ServletException | IOException ex2) {

            }
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
