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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;
import model.read;
import update_related.Hold_clearance;
import update_related.releaseClearance;

public class UpdateClearanceStatusServlet extends HttpServlet {
    // hold 2
    // release 1

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            
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

            /**
             *
             */
            int status = 0;

            String action = request.getParameter("action");
            user u = read.getAUser(username);
            String office = u.getOffice();
            if (action.equals("hold")) {
              //  JOptionPane.showMessageDialog(null, username + " " + initIndexId[0] + "          " + u.getOffice() + "  hj      " + action);
               // JOptionPane.showMessageDialog(null, initIndexId.length);
                status = 2;
            } else if (action.equals("release")) {
//                JOptionPane.showMessageDialog(null, username + " " + initIndexId[0] + "          " + u.getOffice() + "   rel      " + action);
//                JOptionPane.showMessageDialog(null, initIndexId.length);

                status = 1;
            }

// each table 
//
//0- fully clear
//1- clear
//2- not clear
//3- deactivated 
//
            if (office.matches("library")) {

                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setLibraryStatus(initIndexId[i], status, username, 1);
                }

            } else if (office.matches("housing office")) {

//                for (int i = 0; i < initIndexId.length; i++) {
//           JOptionPane.showMessageDialog(null, " at the method for " + i + "  " + initIndexId[i]);
//                } 
                for (int i = 0; i < initIndexId.length; i++) {
//                  JOptionPane.showMessageDialog(null, " at the method for " + i + "  " + initIndexId[i]);
                    model.UpdateClearance.sethousingOfficeStatus(initIndexId[i], status, username, 1);
  //                  JOptionPane.showMessageDialog(null, " done for " + i + "  " + initIndexId[i]);

                }

            } else if (office.matches("student cafe")) {
//                JOptionPane.showMessageDialog(null, initIndexId[0]+ " " + status + " " + username);
                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setCafeStatus(initIndexId[i], status, username, 1);
  //                  JOptionPane.showMessageDialog(null, "Update Complete ");
                }

            } else if (office.matches("sport master")) {

                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setSportMasterStatus(initIndexId[i], status, username, 1);
                }

            } else if (office.matches("faculty store")) {

                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setFacultyStoreStatus(initIndexId[i], status, username, 1);
                }

            } else if (office.matches("registrar")) {

                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setRegistrarStatus(initIndexId[i], status, username, 1);
                }

            } else if (office.matches("continuing education business affair")) {

                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setContinuingEducationBAStatus(initIndexId[i], status, username, 1);
                }

            } else if (office.matches("continuing education ")) {

                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setContinuingEducationStatus(initIndexId[i], status, username, 1);
                }

            } else if (office.matches("dean of postgraduate")) {

                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setDeanOFRPGStatus(initIndexId[i], status, username, 1);
                }

            } else if (office.matches("advisor")) {

                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setAdvisorStatus(initIndexId[i], status, username, 1);
                }

            } else if (office.matches("department head")) {

                for (int i = 0; i < initIndexId.length; i++) {
                    model.UpdateClearance.setDepartmentHeadStatus(initIndexId[i], status, username, 1);
                }

            } else {
  //              JOptionPane.showMessageDialog(null, "unknown office name ");
            }
//            JOptionPane.showMessageDialog(null, "Finish");
            if (action.equals("hold")) {
                //user uu = read.getAUser(username);

                try {
                    request.setAttribute("student", UpdateClearanceStatusServlet.filterHold(username));
                    request.setAttribute("name", u.getFirstName());
                    request.setAttribute("username", u.getUsername());
                    request.setAttribute("userrole", u.getUserRole());
                    request.setAttribute("office", u.getOffice());
                    getServletContext().getRequestDispatcher("/HoldClearance.jsp").forward(request, response);

                } catch (SQLException ex) {
    //                JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            } else if (action.equals("release")) {
                UpdateClearanceStatusServlet ucs=new UpdateClearanceStatusServlet();
                request.setAttribute("student", ucs.filterRelease(username));
                request.setAttribute("name", u.getFirstName());
                request.setAttribute("username", u.getUsername());
                request.setAttribute("userrole", u.getUserRole());
                request.setAttribute("office", u.getOffice());
                getServletContext().getRequestDispatcher("/ReleaseClearance.jsp").forward(request, response);
//                request.setAttribute("username", username);
//                getServletContext().getRequestDispatcher("/ReleaseFilterServlet").forward(request, response);

            }
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getClass());
        } catch (ServletException ex) {
  //          JOptionPane.showMessageDialog(null, ex.getClass());
        } catch (IOException ex) {
    //        JOptionPane.showMessageDialog(null, ex.getClass());
        } catch (NullPointerException ex) {
      //      JOptionPane.showMessageDialog(null, ex.getClass());
        } catch (ClassNotFoundException ex) {
        //    JOptionPane.showMessageDialog(null, ex.getClass());
        }

    }

    public static StudentBean[] filterHold(String username) throws NullPointerException, ClassNotFoundException, SQLException {
//        JOptionPane.showMessageDialog(null, "filter Hold");

        user u = read.getAUser(username);
        String[] stakeholders = {"library", "book store", "sport master", "housing office", "student cafe", "faculty store",
            "registrar", "advisor", "department head", "dean of post graduate and research", "continuing education business affair", "continuing education"};
        int office = 0;
  //      JOptionPane.showMessageDialog(null, "uname " + username);

        for (int i = 0; i < stakeholders.length; i++) {
            if (u.getOffice().matches(stakeholders[i])) {
                office = i;
//                JOptionPane.showMessageDialog(null, "offi " + username);
            }
        }
        StudentBean[] students = Hold_clearance.filterBYusername(username, office);
        return students;
    }

public static void main(String ...a){
        try {
            System.out.println("inside the method");
            
            UpdateClearanceStatusServlet u=new UpdateClearanceStatusServlet();
            
            StudentBean []sb=UpdateClearanceStatusServlet.filterHold("biniam@gmail.com");
            
            System.out.println(sb.length);
        } catch (NullPointerException ex) {
            Logger.getLogger(UpdateClearanceStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateClearanceStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateClearanceStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
    
}    
    
    public StudentBean[] filterRelease(String username) throws NullPointerException, ClassNotFoundException, SQLException {

        user u= read.getAUser(username);

        String[] stakeholders = {"library", "book store", "sport master", "housing office", "student cafe", "faculty store",
            "registrar", "advisor", "department head", "deanOFRPG", "continuing educationBA", "continuing education"};
        int office = 0;
        for (int i = 0; i < stakeholders.length; i++) {
            if (u.getOffice().matches(stakeholders[i])) {
                office = i;
            }
        }
        StudentBean[] students = null;

        students = releaseClearance.filterBYusername(username, office);

        return students;
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
