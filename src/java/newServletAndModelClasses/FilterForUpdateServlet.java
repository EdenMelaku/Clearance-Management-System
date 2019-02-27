/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newServletAndModelClasses;

import clearance_management.StudentBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.read;



public class FilterForUpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            {
        try {
            String username=request.getParameter("username");
            String[] stakeholders={"library","BookStore","SportMaster","housing office","StudentCafe","FacultyStore",
                "Registrar","Advisor","DepartmentHead","DeanOFRPG","ContinuingEducationBA","ContinuingEducation"};
            
            
            int office=99;
            for (int i=0 ;i<12 ;i++){
                try {
                    if(read.getAUser(username).getOffice().matches(stakeholders[i])){
                        office=i;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FilterForUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            StudentBean [] students=filterStudentsForUpdate.filterBYusername(username, office);
        } catch (SQLException ex) {
           
       request.setAttribute("msg", " error occured while reading tudents data please try again  ");

        }
        catch (NullPointerException ex) {
           
       request.setAttribute("msg", "there is no student available for updating   ");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilterForUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
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
