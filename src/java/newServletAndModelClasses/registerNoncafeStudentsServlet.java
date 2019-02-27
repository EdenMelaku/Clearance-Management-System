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
import model.update;

/**
 *
 * @author MEBA
 */
public class registerNoncafeStudentsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String studentID = (String) request.getParameter("varlet");
        String RealLength = request.getParameter("length");//this is length of the total sid
        String stulen = request.getParameter("arraylength");

        int len = Integer.parseInt(stulen);
        /*don't blame my work*/
        char[] sss = studentID.toCharArray();
        String[] stud = new String[len];
        String a = "";
        int i = 0;
        for (char aa : sss) {
            if (aa != ',') {
                a = a + aa;
            } else if (aa == ',') {
                stud[i] = a;
                a = "";
                i++;
            }
        }
        if (stud.length >= 1) {
            stud[len - 1] = a;
            i = 0;
        }

        int nn = Integer.parseInt(RealLength);
        String[] initIndexId = new String[len];
        String[] allId = new String[nn];
        int initHolder = 0;
        for (int k = 0; k < nn; k++) {
            allId[k] = (String) request.getParameter("studentsIdNum[" + k + "]");
        }
        int c = 0;
        for (int j = 0; j < len; j++) {
            initIndexId[c] = allId[Integer.parseInt(stud[j])];
            c++;
        }
        c = 0;

        try {
            if (initIndexId.length == 0) {
                registerNoncafeStudentsServlet re = new registerNoncafeStudentsServlet();
                user us = read.getAUser(username);
                request.setAttribute("Failmsg", "Select at Least One Student");
                request.setAttribute("student", re.Caffestudents());
                request.setAttribute("username", username);
                request.setAttribute("firstname", us.getFirstName());
                request.setAttribute("userrole", us.getUserRole());
                request.setAttribute("office", us.getOffice());
                getServletContext().getRequestDispatcher("/RegisterNonCafe.jsp").forward(request, response);

            } else {

                int u = update.AddNonCafe(initIndexId);
                if (u == 0) {
                    request.setAttribute("msg", "updating failed try again later ");
                } else {
                    registerNoncafeStudentsServlet re = new registerNoncafeStudentsServlet();
                    user us = read.getAUser(username);
                    request.setAttribute("msg", "Sucessful Registration");
                    request.setAttribute("student", re.Caffestudents());
                    request.setAttribute("username", username);
                    request.setAttribute("firstname", us.getFirstName());
                    request.setAttribute("userrole", us.getUserRole());
                    request.setAttribute("office", us.getOffice());

                    getServletContext().getRequestDispatcher("/RegisterNonCafe.jsp").forward(request, response);

                }
            }
        } catch (NullPointerException | ClassNotFoundException | ServletException | IOException ex) {
            try {
                request.setAttribute("msg", "error occured while getting students data!   ");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);

            } catch (ServletException | IOException ex1) {

            }
        } catch (SQLException ex) {
            try {
                if (ex.getErrorCode() == 1403) {
                    request.setAttribute("msg", "All Students Are Registered");
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

    public StudentBean[] Caffestudents() throws NullPointerException, SQLException, ClassNotFoundException {
        StudentBean ab[] = filterStudentsForUpdate.FilterForNoncafeRegistration();
        return ab;
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
