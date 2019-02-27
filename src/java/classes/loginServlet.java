package classes;

import clearance_management.user;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.*;

public class loginServlet extends HttpServlet {

    String email;
    String password;
    int counter = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            email = request.getParameter("email");
            password = request.getParameter("password");
            int x = validation.validateuser(email);
            if (password.length() == 0) {
                request.setAttribute("msg", "Password Can't be Empty");
                getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
            } else if (x == 0) {
                request.setAttribute("msg", "Invalid User");
                getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);

            } else if (x == 1) {
                user su = read.getAUser(email);

                if (su.getPassword().matches(password)) {
                        
                    if (password.toLowerCase().equals((su.getLastName().toLowerCase() + "123#"))) {
                        request.setAttribute("username", email);
                        getServletContext().getRequestDispatcher("/ChangePassword.jsp").forward(request, response);
                    } else {
//fail to do this 
                        if (su.getAccountStatus() == 1) {
                            request.setAttribute("username", email);
                            getServletContext().getRequestDispatcher("/Master.jsp").forward(request, response);

                        } else {
                            request.setAttribute("msg", "Your Account is Deactivated");
                            counter = 0;
                            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
                        }
                    }
                } else {

                    if (counter < 2) {
                        counter++;
                        request.setAttribute("msg", "Incorrect Username or Password " + (3 - counter) + " attempts left");
                        getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);

                    } else {
                        utility u = new utility();
                        u.deactivateAccount(email, "system");
                        request.setAttribute("msg", "your account is deactivated ");
                        counter = 0;
                        getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
                    }
                }
            } else {
                request.setAttribute("msg", "System Fail to Login ");
                getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
            }

        } catch (NullPointerException | ClassNotFoundException | SQLException | ServletException | IOException ex) {
            try {
                request.setAttribute("msg", " Error occured please try again  ");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            } catch (ServletException | IOException ex2) {

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
