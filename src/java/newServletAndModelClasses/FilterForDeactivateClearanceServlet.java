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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.read;

public class FilterForDeactivateClearanceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String username = null;
        user u;
        try {
            StudentBean[] students = FilterStudents.toDeactivate();

            username = request.getParameter("username");

            u = read.getAUser(username);
            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("name", u.getFirstName());
            request.setAttribute("student", students);
            getServletContext().getRequestDispatcher("/DeactivateStudent.jsp").forward(request, response);
        } catch (NullPointerException | ClassNotFoundException | ServletException | IOException ex) {

        } catch (SQLException ex) {
            try {
                if (ex.getErrorCode() == 1403) {
                    request.setAttribute("msg", "All Students Are Deactivated");
                    request.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "error occured while getting students data!   ");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                }
            } catch (NullPointerException | ServletException | IOException ex1) {
                request.setAttribute("msg", "Error occured while getting students data!");
                try {
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                } catch (ServletException | IOException ex2) {

                }
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
