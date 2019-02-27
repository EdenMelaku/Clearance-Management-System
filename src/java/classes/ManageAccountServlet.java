package classes;

import clearance_management.user;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;
import otherService.AccountManagingInfo;
import otherService.outputobj;

public class ManageAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = null;
        try {
            username = request.getParameter("username");
            outputobj.joption(username + " ");
            user u = read.getAUser(username);
            AccountManagingInfo ami[] = read.getAccountManagingInfo(u);

            String[] uss = new String[ami.length - 1];
            outputobj.joption(ami.length + "  the length ");
            outputobj.joption(ami[1].getLastName());
            outputobj.joption(ami[0].getFirstName());

            String[] unames = new String[ami.length - 1];
            for (int i = 0; i < ami.length - 1; i++) {
                uss[i] = ami[i].getFirstName() + " " + ami[i].getLastName();
                unames[i] = ami[i].getUsername();
            }
            request.setAttribute("unames", unames);
            request.setAttribute("name", uss);
            request.setAttribute("users", ami);
            if (u.getOffice().equals("faculty")) {
                getServletContext().getRequestDispatcher("/AccountManagment.jsp").forward(request, response);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ManageAccount.jsp");
                rd.forward(request, response);
            }
        } catch (NullPointerException | ClassNotFoundException ex) {
            outputobj.joption(" null pointer ");
            request.setAttribute("msg", " Error occured while reading data please try again  ");
            getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
        } catch (SQLException ex) {
            try {
                if (ex.getErrorCode() == 1403) {
                    user u = read.getAUser(username);
                    request.setAttribute("msg", "Accounts Can't Filter");
                    request.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", " Error occured while reading data please try again  ");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                }
            } catch (NullPointerException | ClassNotFoundException | SQLException ex1) {
                request.setAttribute("msg", " Error occured please try again  ");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);

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
