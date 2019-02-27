package classes;

import clearance_management.StudentBean;
import clearance_management.user;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import coreBussinesLogic.initiateClearanceControler;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import model.read;
import model.utility;

/**
 *
 * @author MEBA
 */
public class initiateClearance2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String username;
        String studentID;
        String RealLength;
        username = request.getParameter("username");
        studentID = (String) request.getParameter("varlet");
        RealLength = request.getParameter("length");//this is length of the total sid

        //  String []studs = (String[])request.getAttribute("students");
        //  String baantest=request.getParameter("students");
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

        initHolder = 0;
        String reason = request.getParameter("reasonChoice");
        if (reason.equals("Select the Reason") || len == 0) {
            try {
                if (reason.equals("Select the Reason")) {
                    request.setAttribute("msg", "Select The Reason First");
                } else {
                    request.setAttribute("msg", "Select At Least one Student");
                }

                /*From Robel   to Ed this is not for you but for my own purpose 
                 */
                String username2 = request.getParameter("username");
                String userRole2 = request.getParameter("userRole");

                user u = read.getAUser(username2);

                StudentBean[] uninitiated = utility.getUninitiated(username2);
                String[] StudentId = new String[uninitiated.length];
                for (int g = 0; g < uninitiated.length; g++) {
                    StudentId[g] = uninitiated[g].getId();
                }
                /*
                END                
                 */
                String address;

                request.setAttribute("stud", uninitiated);
                request.setAttribute("sid", StudentId);
                request.setAttribute("userRole", request.getParameter("userRole"));
                request.setAttribute("username", request.getParameter("username"));
                address = "/initiateClearance.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
                dispatcher.forward(request, response);
            } catch (NullPointerException | ClassNotFoundException ex) {
                request.setAttribute("msg", "Error occured while getting students data!");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            } catch (SQLException e) {
                try {
                    if (e.getErrorCode() == 1403) {
                        request.setAttribute("msg", "All Students Are Initiated");
                        request.setAttribute("username", username);
                        getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
                    } else {
                        request.setAttribute("msg", "error occured while getting students data!   ");
                        getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                    }
                } catch (NullPointerException ex) {
                    request.setAttribute("msg", "All Students Are Initiated");
                    request.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);

                }
            }
        } else {// going to initiate operation

            //JOptionPane.showMessageDialog(null, "initIndexId.length  :  " + initIndexId.length);
            int cv = 0;
            try {
                for (i = 0; i < initIndexId.length; i++) {
                 //    JOptionPane.showMessageDialog(null, "---------------" + initIndexId[i]);
                    if (initiateClearanceControler.ClearAstudent(initIndexId[i], reason, username) == 1) {
                       
                        cv++;
                    } else {
                        request.setAttribute("msg", "Request Fail Try Again ");
                        getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                    }
                }
            } catch (NullPointerException | ClassNotFoundException ex) {
                request.setAttribute("msg", "error occured while Initiating students!   ");
                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
            }

//            JOptionPane.showMessageDialog(null, "CV  :  " + cv);

            if (cv == initIndexId.length) {
                try {
                    user u = read.getAUser(username);
                    StudentBean[] uninitiated = utility.getUninitiated(username);
                    String[] StudentId = new String[uninitiated.length];
                    for (int k = 0; k < uninitiated.length; k++) {
                        StudentId[k] = uninitiated[k].getId();
                    }
                    String address;
                    request.setAttribute("stud", uninitiated);
                    request.setAttribute("sid", StudentId);
                    request.setAttribute("userRole", request.getParameter("userRole"));
                    address = "/initiateClearance.jsp";

                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
                    dispatcher.forward(request, response);
                } catch (NullPointerException | ClassNotFoundException ex) {
                    request.setAttribute("msg", "Error occured while getting students data!   ");
                    getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);

                } catch (SQLException ex) {
                    try {
                        if (ex.getErrorCode() == 1403) {
                            user u = read.getAUser(username);
                            request.setAttribute("msg", "All Students Are Initiated");
                            request.setAttribute("username", username);
                            getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
                        } else {
                            request.setAttribute("msg", "Error occured while getting students data!   ");
                            getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                        }
                    } catch (Exception e) {
                        request.setAttribute("msg", "Error occured while getting students data!   ");
                        getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                    }
                }
            }

        }

    }

    public StudentBean[] studentsList(String username) throws SQLException, ClassNotFoundException, NullPointerException {
        StudentBean[] uninitiated;
        uninitiated = utility.getUninitiated(username);

        return uninitiated;
    }

    public String[] studentsIdList(String username) throws SQLException, NullPointerException, ClassNotFoundException {
        String[] StudentId;
        StudentBean[] uninitiated = utility.getUninitiated(username);
        StudentId = new String[uninitiated.length];
        for (int i = 0; i < uninitiated.length; i++) {
            StudentId[i] = uninitiated[i].getId();
        }

        return StudentId;
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
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(initiateClearance2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(initiateClearance2.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
