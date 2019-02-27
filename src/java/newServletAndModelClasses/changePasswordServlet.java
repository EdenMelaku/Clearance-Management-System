package newServletAndModelClasses;

import clearance_management.user;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.read;
import model.update;

public class changePasswordServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String oldPassword = request.getParameter("oldpass");
            String password1 = request.getParameter("newpass1");
            String password = request.getParameter("newpass2");
            user u = read.getAUser(username);
            int controller = 0;
            // 1 -- unfilled form
            // 2 incorrrect old password
            // 3 length less than 8
            // 4 missmatch

            if (oldPassword.equals("") || password1.equals("") || password.equals("")) {
                controller = 1;
                request.setAttribute("failMsg", "Fill The Form Properly Please");
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/ChangePassword.jsp").forward(request, response);

            }
            if (controller == 0 && oldPassword.matches(u.getPassword()) == false) {
                controller = 2;
                request.setAttribute("failMsg", "Incorrect Old Password");
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/ChangePassword.jsp").forward(request, response);

            }

            if (controller == 0 && password.length() < 8) {
                controller = 3;
                request.setAttribute("failMsg", "Insert At least 8Character");

                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/ChangePassword.jsp").forward(request, response);

            }
            if (controller == 0 && password.matches(password1) == false) {
                controller = 4;
                request.setAttribute("failMsg", "Password Mismatch");
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/ChangePassword.jsp").forward(request, response);
            }

            if (controller == 0) {
                int y = update.changePassword(username, password);
                if (y == 0) {
                    request.setAttribute("failMsg", "Error occured while changing password");
                    request.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/ChangePassword.jsp").forward(request, response);
                } else {
                    request.setAttribute("yesMsg", "Your Password Successfully Changed");
                    getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
                }
            }

        } catch (NullPointerException | ClassNotFoundException | SQLException | ServletException | IOException ex) {
            request.setAttribute("msg", "Error occured while getting data!");
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
