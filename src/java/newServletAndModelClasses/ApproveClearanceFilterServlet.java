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
//import javax.swing.JOptionPane;
import model.read;

/**
 *
 * @author MEBA
 */
public class ApproveClearanceFilterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String username = null;
        try {
            username = request.getParameter("username");
            user u = read.getAUser(username);
            StudentBean students[] = filterStudentsForApproval.filter(u);
            // JOptionPane.showMessageDialog(null,students[0].getFirstName());
            request.setAttribute("username", username);
            request.setAttribute("student", students);
            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
        } catch (SQLException ex) {
            try {
                if (ex.getErrorCode() == 1403) {
                    user u = read.getAUser(username);
                    request.setAttribute("msg", "All Students Are Approved");
                    request.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", " Error occured while reading Students data please try again we are working on it ");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                }
            } catch (ServletException | IOException | NullPointerException | ClassNotFoundException | SQLException ex1) {
                try {
                    request.setAttribute("msg", " Error occured while reading Students data please try again we are working on it ");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                } catch (ServletException | IOException ex2) {

                }
            }
        } catch (NullPointerException ex) {
            try {
                request.setAttribute("msg", "There is no student available for  approval  ");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            } catch (ServletException | IOException ex1) {
                try {
                    request.setAttribute("msg", " Error occured while reading Students data please try again  ");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                } catch (ServletException | IOException ex2) {

                }
            }
        } catch (ClassNotFoundException | ServletException | IOException ex) {
            try {
                request.setAttribute("msg", " Error occured while reading Students data please try again we are working on it ");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            } catch (ServletException | IOException ex1) {

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
