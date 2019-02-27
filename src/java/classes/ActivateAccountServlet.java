package classes;

import clearance_management.StudentBean;
import clearance_management.user;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.read;
import model.update;
import newServletAndModelClasses.approveClearanceServlet;
import otherService.AccountManagingInfo;

public class ActivateAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        user u = null;
        String[] initIndexMail=null;

        try {
            //String account = request.getParameter("accountChoice");
            String action = request.getParameter("actionChoice");
            String username = request.getParameter("username");
            u = read.getAUser(username);
            String studentID = (String) request.getParameter("varlet");
            String RealLength = request.getParameter("length");//this is length of the total sid
            String stulen = (String) request.getParameter("arraylength");
//            JOptionPane.showMessageDialog(null, action+" "+username+" "+studentID.length()+" "+RealLength+" "+stulen.length());
            int len = Integer.parseInt(stulen);
            initIndexMail = new String[len];
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
            approveClearanceServlet aa = new approveClearanceServlet();
            StudentBean[] ss = null;
            //if there is no selectd student

            String[] allMail = new String[nn];
            int initHolder = 0;
            for (int k = 0; k < nn; k++) {
                allMail[k] = (String) request.getParameter("userEmail[" + k + "]");

            }
            int c = 0;
            for (int j = 0; j < len; j++) {
                initIndexMail[c] = allMail[Integer.parseInt(stud[j])];
                c++;
            }
            c = 0;

            ActivateAccountServlet acs = new ActivateAccountServlet();
            if (initIndexMail.length == 0) {
                request.setAttribute("msgF", "Select the Account First");
                request.setAttribute("unames", acs.returnUNames(username));
                request.setAttribute("name", acs.returnAccounts(username));
                request.setAttribute("users", acs.returner(username));
                if (u.getOffice().equals("faculty")) {
                    getServletContext().getRequestDispatcher("/AccountManagment.jsp").forward(request, response);
                } else {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ManageAccount.jsp");
                    rd.forward(request, response);
                }
            }
  //          JOptionPane.showMessageDialog(null, initIndexMail.length);
            if (action.matches("activate")) {
                int t = 0;
                for (int q = 0; q < initIndexMail.length; q++) {
//                                JOptionPane.showMessageDialog(null, initIndexMail[q]);

                    t = update.updateAccountStatusA(initIndexMail[q]);

                }
                if (t == 1) {
                    request.setAttribute("msg", "Success");
                    request.setAttribute("unames", acs.returnUNames(username));
                    request.setAttribute("name", acs.returnAccounts(username));
                    request.setAttribute("users", acs.returner(username));
                    if (u.getOffice().equals("faculty")) {
                        getServletContext().getRequestDispatcher("/AccountManagment.jsp").forward(request, response);
                    } else {
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ManageAccount.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("msgF", "Not Success");
                    request.setAttribute("unames", acs.returnUNames(username));
                    request.setAttribute("name", acs.returnAccounts(username));
                    request.setAttribute("users", acs.returner(username));
                    if (u.getOffice().equals("faculty")) {
                        getServletContext().getRequestDispatcher("/AccountManagment.jsp").forward(request, response);
                    } else {
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ManageAccount.jsp");
                        rd.forward(request, response);
                    }
                }
            } else {
                int t = 0;
                for (int q = 0; q < initIndexMail.length; q++) {
                    t = update.updateAccountStatusD(initIndexMail[q]);

                }
                if (t == 1) {
                    request.setAttribute("msg", "Success ");
                    request.setAttribute("unames", acs.returnUNames(username));
                    request.setAttribute("name", acs.returnAccounts(username));
                    request.setAttribute("users", acs.returner(username));
                    if (u.getOffice().equals("faculty")) {
                        getServletContext().getRequestDispatcher("/AccountManagment.jsp").forward(request, response);
                    } else {
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ManageAccount.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("msgF", "Not Success");
                    request.setAttribute("unames", acs.returnUNames(username));
                    request.setAttribute("name", acs.returnAccounts(username));
                    request.setAttribute("users", acs.returner(username));
                    if (u.getOffice().equals("faculty")) {
                        getServletContext().getRequestDispatcher("/AccountManagment.jsp").forward(request, response);
                    } else {
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ManageAccount.jsp");
                        rd.forward(request, response);
                    }
                }
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(ActivateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActivateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ActivateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public AccountManagingInfo[] returner(String username) throws NullPointerException, ClassNotFoundException, SQLException {
        user u = read.getAUser(username);
        AccountManagingInfo ami[] = read.getAccountManagingInfo(u);

        return ami;
    }

    public String[] returnUNames(String username) throws NullPointerException, SQLException, ClassNotFoundException {
        ActivateAccountServlet acs = new ActivateAccountServlet();
        AccountManagingInfo[] ami = acs.returner(username);
        String[] unames = new String[ami.length - 1];
        for (int i = 0; i < ami.length - 1; i++) {
            unames[i] = ami[i].getUsername();
        }
        return unames;
    }

    public String[] returnAccounts(String username) throws NullPointerException, SQLException, ClassNotFoundException {
        ActivateAccountServlet acs = new ActivateAccountServlet();
        AccountManagingInfo[] ami = acs.returner(username);
        String[] uss = new String[ami.length - 1];
        for (int i = 0; i < ami.length - 1; i++) {
            uss[i] = ami[i].getFirstName() + " " + ami[i].getLastName();
        }
        return uss;
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
