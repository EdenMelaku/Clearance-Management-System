/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newServletAndModelClasses;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author MEBA
 */
public class ActivateClearanceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
//        String username = request.getParameter("username");
//        String studentID[] = request.getParameterValues("id");
//        

        String username = request.getParameter("username");
        String studentID = (String) request.getParameter("varlet");
        String RealLength = request.getParameter("length");//this is length of the total sid

        String stulen = request.getParameter("arraylength");
        int len = Integer.parseInt(stulen);
        /*don't blame my work*/
        //    JOptionPane.showMessageDialog(null, "initiated " + studentID + "  len  " + len);
        char[] sss = studentID.toCharArray();
        String[] stud = new String[len];
        String a = "";
        int p = 0;
        for (char aa : sss) {
            if (aa != ',') {
                a = a + aa;
            } else if (aa == ',') {
                stud[p] = a;
                a = "";
                p++;
            }
        }
        if (stud.length >= 1) {
            stud[len - 1] = a;
            p = 0;
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
            // JOptionPane.showMessageDialog(null, "get it " + stud[j]);
            //JOptionPane.showMessageDialog(null, "this " + allId[Integer.parseInt(stud[j])]);
            initIndexId[c] = allId[Integer.parseInt(stud[j])];
            c++;
        }
        c = 0;
        initHolder = 0;

        JOptionPane.showMessageDialog(null, username + " " + initIndexId.length);
        for (int i = 0; i < studentID.length(); i++) {
            try {
                ActivateDeactivate.Activate(initIndexId[i], username);

            } catch (ClassNotFoundException | SQLException ex) {

                try {
                    request.setAttribute("msg", "Error occured while Activating students!   ");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                } catch (ServletException ex1) {
                    Logger.getLogger(ActivateClearanceServlet.class.getName()).log(Level.SEVERE, null, ex1);
                } catch (IOException ex1) {
                    Logger.getLogger(ActivateClearanceServlet.class.getName()).log(Level.SEVERE, null, ex1);
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
