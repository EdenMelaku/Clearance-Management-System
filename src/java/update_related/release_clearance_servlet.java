/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update_related;

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

/**
 *
 * @author MEBA
 */
public class release_clearance_servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        user u;
        try {
            u = read.getAUser(username);

            String[] stakeholders = {"library", "book store", "sport master", "housing office", "student cafe", "faculty store",
                "registrar", "advisor", "department head", "deanOFRPG", "continuing educationBA", "continuing education"};
            int office = 0;
            for (int i = 0; i < stakeholders.length; i++) {
                if (u.getOffice().matches(stakeholders[i])) {
                    office = i;
                }
            }
            StudentBean[] students = null;

            students = releaseClearance.filterBYusername(username, office);
            request.setAttribute("student", students);
            request.setAttribute("name", u.getFirstName());
            request.setAttribute("username", u.getUsername());
            request.setAttribute("userrole", u.getUserRole());
            request.setAttribute("office", u.getOffice());
//            JOptionPane.showMessageDialog(null, u.getOffice());
            
            if (students.length < 1) {
                request.setAttribute("msg", "There is no any Student's clearance is hold");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/ReleaseClearance.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            try {
                request.setAttribute("msg", "The System Can't Get The data retry again");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            } catch (ServletException ex1) {
                Logger.getLogger(release_clearance_servlet.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(release_clearance_servlet.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(release_clearance_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(release_clearance_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(release_clearance_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(release_clearance_servlet.class.getName()).log(Level.SEVERE, null, ex);
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
