package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
import model.utility;

import otherService.StudentClearanceInfo;

public class GetStudentStatusServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //5 deactivate
        //4 many
        //3 Ad
        //2  DH
        //1 Reg
        //0 Cleared
        int res;
        String username = request.getParameter("username");
        String address = null;
        StudentClearanceInfo[] studInfo;
        try {
            studInfo = utility.getInitiatedInfo(username);
            if (studInfo != null) {
                address = "/StudentStatus.jsp";
                request.setAttribute("studInfo", studInfo);
            } else {
                address = "nostatus.jsp";
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(GetStudentStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetStudentStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetStudentStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);
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
