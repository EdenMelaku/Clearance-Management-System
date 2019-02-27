package classes;

import clearance_management.StudentBean;
import clearance_management.user;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

public class initiateClearance3 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = null;
        try {
            username = (String) request.getAttribute("username");
            //   String userRole2 = request.getParameter("userRole");
            user u = read.getAUser(username);

            StudentBean[] uninitiated = utility.getUninitiated(username);
            String[] StudentId = new String[uninitiated.length];
            for (int i = 0; i < uninitiated.length; i++) {
                StudentId[i] = uninitiated[i].getId();
            }
            String address = null;

            request.setAttribute("stud", uninitiated);
            request.setAttribute("sid", StudentId);
            request.setAttribute("userRole", request.getParameter("userRole"));
            request.setAttribute("username", request.getParameter("username"));
            address = "/initiateClearance.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            try {
                if (ex.getErrorCode() == 1403) {
                    user u = read.getAUser(username);
                    request.setAttribute("msg", "All Students Are Initiated");
                    request.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "error occured while getting students data   ");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                }
            } catch (NullPointerException | ClassNotFoundException | SQLException ex1) {
                request.setAttribute("msg", "Error occured while getting students data!");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            }
        } catch (NullPointerException | ClassNotFoundException ex) {
            request.setAttribute("msg", "Error occured while getting students data!");
            getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
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
