package classes;

import clearance_management.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
import model.*;

public class createAccountServlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String username = request.getParameter("username");
            user u = read.getAUser(username);
            System.out.println(" user found   " + u.getFirstName());
            String office = u.getOffice();
            String userRole = u.getUserRole();
            String[] departments = null;

            if (u.getOffice().matches("faculty")) {
                String facultyID = read.getFacultyID(username);
                // JOptionPane.showMessageDialog(null," faculty id  found   "+ facultyID);
                departments = read.getDepartments(facultyID);
//            for(int i=0;i<departments.length;i++){
//                     JOptionPane.showMessageDialog(null," department found   "+ departments [i]);
//            }

            }
            request.setAttribute("department", departments);
            request.setAttribute("userRole", userRole);
            request.setAttribute("office", office);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateAccount.jsp");
            dispatcher.forward(request, response);
        } catch (NullPointerException ex) {
            Logger.getLogger(createAccountServlet1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(createAccountServlet1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(createAccountServlet1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//     public static void main(String ... args){
//         
//         user u = read.getAUser("tesema@gmail.com");
//         String username=u.getUsername();
//        System.out.println(" user found   "+ u.getFirstName());
//        String office = u.getOffice();
//        String userRole = u.getUserRole();
//        String[] departments = null;
//
//        if (u.getOffice().matches("faculty")) {
//            String facultyID = read.getFacultyID(username);
//                    System.out.println(" faculty id  found   "+ facultyID);
//
//            departments = read.getDepartments(facultyID);
//                    System.out.println(" department found   "+ departments [0]);
//
//        }
//       
//     }
//   
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
