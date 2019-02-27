/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newServletAndModelClasses;

import clearance_management.user;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.read;
import otherService.stakeholderrow;

/**
 *
 * @author MEBA
 */
public class getofficeStatusServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            user u = read.getAUser(username);
            String office = u.getOffice();

            if (u.getOffice().matches("faculty")) {
                String id[] = officeStatusFiltration.getStudentsforPM(username);
                stakeholderrow[] adv = officeStatusFiltration.filterAdvisor(id);
                stakeholderrow[] dep = officeStatusFiltration.filterDepartmentHead(id);
                stakeholderrow[] fac = officeStatusFiltration.filterfacultyStore(officeStatusFiltration.getAvsuds(username));

                request.setAttribute("advisor", adv);
                request.setAttribute("departmenthead", dep);
                request.setAttribute("facultystore", fac);
                request.setAttribute("username", username);
                request.setAttribute("firstname", u.getFirstName());
                getServletContext().getRequestDispatcher("/GetOfficeStatusProManager.jsp").forward(request, response);

            } else {
                try {
                    //JOptionPane.showMessageDialog(null, "HERE" + office + " " + username);
                    if (u.getOffice().equals("student cafe")) {
//                        JOptionPane.showMessageDialog(null, u.getOffice());
                        stakeholderrow[] roww = officeStatusFiltration.getrow("housing office", "samson@gmail.com");
                        //  JOptionPane.showMessageDialog(null, roww.length);

                        request.setAttribute("data", roww);

                        request.setAttribute("username", username);
                        request.setAttribute("firstname", u.getFirstName());
                        getServletContext().getRequestDispatcher("/OfficeStatusCafe.jsp").forward(request, response);

                    } else {
                        stakeholderrow[] roww = officeStatusFiltration.getrow(office, username);
                        //  JOptionPane.showMessageDialog(null, roww.length);

                        request.setAttribute("data", roww);

                        request.setAttribute("username", username);
                        request.setAttribute("firstname", u.getFirstName());
                        getServletContext().getRequestDispatcher("/OfficeStatus.jsp").forward(request, response);

                    }

                    //    JOptionPane.showMessageDialog(null, u.getOffice());
                    //   JOptionPane.showMessageDialog(null, roww.length + "  " + username + " " + u.getFirstName());
                } catch (SQLException | ServletException | IOException ex) {
                    request.setAttribute("msg", "Error occured while getting students data!");
                    try {
                        getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
                    } catch (ServletException | IOException ex2) {

                    }
                }
            }
        } catch (NullPointerException | ClassNotFoundException | SQLException | ServletException | IOException ex) {
            request.setAttribute("msg", "Error occured while getting students data!");
            try {
                getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
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
