package classes;

import clearance_management.AccountInfo;
import clearance_management.user;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

public class createAccountServlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String creator = request.getParameter("creator");
            String dep = null;
            String program = null;
            String year = null;
            String section = null;
            String accType = null;
            Calendar c = new GregorianCalendar();
            Date d = c.getTime();
            Date ll = null;
            long a = 0;
            accType = request.getParameter("accountType");
            String office = read.getAUser(creator).getOffice();
            String role = request.getParameter("userrole");
            user u = null;
            String[] departments = null;

            String uname = request.getParameter("email");
            String fname = request.getParameter("firstname");
            String lname = request.getParameter("lastname");
            try {
                if (office.toLowerCase().equals("faculty")) {
                    dep = request.getParameter("department");
                    program = request.getParameter("program");
                    year = request.getParameter("year");
                    section = request.getParameter("section");

                    if (accType.equals("advisor")) {
                        if (uname.equals("") || fname.equals("") || lname.equals("") || dep.equals("Select the Department") || program.equals("Select Program") || year.equals("Year") || section.equals("")) {
                            request.setAttribute("msg", "Fill The Form Properly Please");
                            String facultyID = read.getFacultyID(uname);
                            // JOptionPane.showMessageDialog(null," faculty id  found   "+ facultyID);
                            departments = read.getDepartments(facultyID);
                            request.setAttribute("department", departments);
                            request.setAttribute("userRole", role);
                            request.setAttribute("office", office);
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateAccount.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            u = new user(1, uname, fname, lname, (lname + "123#").toLowerCase(), accType, role, dep, Integer.parseInt(year), program, section);
                            AccountInfo accI = new AccountInfo(u.getUsername(), creator, d, ll, a);
                            if (update.addUser(u, accI) == 1) {
                                request.setAttribute("msgSuc", "Account Successfully Created");
                                String facultyID = read.getFacultyID(uname);
                                // JOptionPane.showMessageDialog(null," faculty id  found   "+ facultyID);
                                departments = read.getDepartments(facultyID);
                                request.setAttribute("department", departments);
                                request.setAttribute("userRole", role);
                                request.setAttribute("office", office);
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateAccount.jsp");
                                dispatcher.forward(request, response);
                            } else {
                                request.setAttribute("msg", "System Fail To Create Account Try Again");
                                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                            }
                        }
                    } else if (accType.equals("department head")) {

                        if (uname.equals("") || fname.equals("") || lname.equals("") || dep.equals("Select the Department")) {
                            request.setAttribute("msg", "Fill All The Form Please");
                            String facultyID = read.getFacultyID(uname);
                            // JOptionPane.showMessageDialog(null," faculty id  found   "+ facultyID);
                            departments = read.getDepartments(facultyID);
                            request.setAttribute("department", departments);
                            request.setAttribute("userRole", role);
                            request.setAttribute("office", office);
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateAccount.jsp");
                            dispatcher.forward(request, response);

                        } else {
                            u = new user(1, uname, fname, lname, (lname + "123#").toLowerCase(), "department head", "privileged_user", dep, 0, "A", "A");
                            AccountInfo accI = new AccountInfo(u.getUsername(), creator, d, ll, a);
                            if (update.addUser(u, accI) == 1) {
                                request.setAttribute("msgSuc", "Account Successfully Created");
                                String facultyID = read.getFacultyID(uname);
                                // JOptionPane.showMessageDialog(null," faculty id  found   "+ facultyID);
                                departments = read.getDepartments(facultyID);
                                request.setAttribute("department", departments);
                                request.setAttribute("userRole", role);
                                request.setAttribute("office", office);
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateAccount.jsp");
                                dispatcher.forward(request, response);

                            } else {
                                request.setAttribute("msg", "System Fail To Create Account Try Again");
                                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                            }
                        }

                    } else {//  faculty store

                        if (uname.equals("") || fname.equals("") || lname.equals("")) {
                            request.setAttribute("msg", "Fill All The Form Please");
                            String facultyID = read.getFacultyID(uname);
                            // JOptionPane.showMessageDialog(null," faculty id  found   "+ facultyID);
                            departments = read.getDepartments(facultyID);
                            request.setAttribute("department", departments);
                            request.setAttribute("userRole", role);
                            request.setAttribute("office", office);
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateAccount.jsp");
                            dispatcher.forward(request, response);
                            getServletContext().getRequestDispatcher("/CreateAccount.jsp").forward(request, response);
                        } else {
                            u = new user(1, uname, fname, lname, (lname + "123#").toLowerCase(), "faculty store", "privileged_user", dep, 0, "A", "A");
                            AccountInfo accI = new AccountInfo(u.getUsername(), creator, d, ll, a);
                            if (update.addUser(u, accI) == 1) {
                                request.setAttribute("msgSuc", "Account Successfully Created");
                                String facultyID = read.getFacultyID(uname);
                                // JOptionPane.showMessageDialog(null," faculty id  found   "+ facultyID);
                                departments = read.getDepartments(facultyID);
                                request.setAttribute("department", departments);
                                request.setAttribute("userRole", role);
                                request.setAttribute("office", office);
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateAccount.jsp");
                                dispatcher.forward(request, response);

                                getServletContext().getRequestDispatcher("/CreateAccount.jsp").forward(request, response);

                            } else {
                                request.setAttribute("msg", "System Fail To Create Account Try Again");
                                getServletContext().getRequestDispatcher("/CreateAccount.jsp").forward(request, response);
                            }
                        }
                    }
                } else {// Other Offices
                    if (uname == "" || fname == "" || lname == "") {
                        // JOptionPane.showMessageDialog(null, "lela inner");
                        request.setAttribute("msg", "Fill The Form Properly Please");
                        request.setAttribute("department", returnData(creator));
                        request.setAttribute("userRole", u.getUserRole());
                        request.setAttribute("office", u.getOffice());
                        getServletContext().getRequestDispatcher("/CreateAccount.jsp").forward(request, response);
                    } else {
                        u = new user(1, uname, fname, lname, (lname + "123#").toLowerCase(), office, role, dep, 0, program, section);
                        AccountInfo accI = new AccountInfo(u.getUsername(), creator, d, ll, a);
                        int r = update.addUser(u, accI);

                        if (r == 1) {
                            request.setAttribute("msgSuc", "Account Successfully Created");
                            request.setAttribute("department", returnData(creator));
                            request.setAttribute("userRole", u.getUserRole());
                            request.setAttribute("office", u.getOffice());
                            getServletContext().getRequestDispatcher("/CreateAccount.jsp").forward(request, response);

                        } else {
                            request.setAttribute("msg", " Fail To Create Account Try Again");
                            getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                        }
                    }
                }

            } catch (Exception e) {
                request.setAttribute("msg", " Error occured please try again  ");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            }
        } catch (NullPointerException | ClassNotFoundException | SQLException ex) {
            request.setAttribute("msg", " Error occured please try again  ");
            getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
        }
    }

    public static String[] returnData(String username) throws NullPointerException, ClassNotFoundException, SQLException {

        user u = read.getAUser(username);
        System.out.println(" user found   " + u.getFirstName());
        String office = u.getOffice();
        String userRole = u.getUserRole();
        String[] departments = null;

        if (u.getOffice().matches("faculty")) {
            String facultyID = read.getFacultyID(username);
            departments = read.getDepartments(facultyID);
        }
        return departments;
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
