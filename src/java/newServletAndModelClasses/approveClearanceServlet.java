package newServletAndModelClasses;

import clearance_management.StudentBean;
import clearance_management.user;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author MEBA
 */
public class approveClearanceServlet extends HttpServlet {

    static String[] stakeholders = {"library", "book store", "sport master", "housing office", "student cafe", "faculty store",
        "registrar", "advisor", "department head", "dean of research and post graduate", "continuing education business affair", "continuing education"};

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {

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
            approveClearanceServlet aa = new approveClearanceServlet();
            StudentBean[] ss = null;
            //if there is no selectd student

            if (stud.length == 0) {
                try {
                    request.setAttribute("username", username);
                    request.setAttribute("msg", "Select At Least one Student ");
                    request.setAttribute("name", read.getAUser(username).getFirstName());
                    request.setAttribute("student", aa.test(username));
                    request.setAttribute("userrole", read.getAUser(username).getUserRole());
                    request.setAttribute("office", read.getAUser(username).getOffice());

                    try {
                        getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                    } catch (IOException ex) {
                        request.setAttribute("msg", "Error occured while getting students data!");
                        try {
                            getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                        } catch (ServletException | IOException ex2) {

                        }
                    }
                } catch (NullPointerException | ClassNotFoundException | ServletException ex) {
                    request.setAttribute("msg", "Error occured while getting students data!");
                    try {
                        getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                    } catch (ServletException | IOException ex2) {

                    }
                } catch (SQLException e) {
                    try {
                        if (e.getErrorCode() == 1403) {
                            request.setAttribute("msg", "All Students Are Activated");
                            request.setAttribute("username", username);
                            getServletContext().getRequestDispatcher("/Master2.jsp").forward(request, response);
                        } else {
                            request.setAttribute("msg", "error occured while getting students data!   ");
                            getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                        }
                    } catch (IOException ex) {
                        try {
                            request.setAttribute("msg", "error occured while getting students data!   ");
                            getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                        } catch (IOException ex1) {

                        }
                    }
                }
            }
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
            user u = read.getAUser(username);
            // JOptionPane.showMessageDialog(null,username);
            //JOptionPane.showMessageDialog(null, " the username of the user is   " + username);
            // 0= all,  1= ur, 2- us, 3- ue ,  4- pr,  5- ps  
            // JOptionPane.showMessageDialog(null, " the office of the user is   " + u.getOffice());
            i = 99;
            for (int j = 0; j < stakeholders.length; j++) {
//            JOptionPane.showMessageDialog(null,"at the loop");
                //              JOptionPane.showMessageDialog(null,u.getOffice());
                //                JOptionPane.showMessageDialog(null,stakeholders[j]);
                if (u.getOffice().matches(stakeholders[j]) == true) {
                    //               JOptionPane.showMessageDialog(null, "got");

                    i = j;
                    //                JOptionPane.showMessageDialog(null, i + "  " + stakeholders[i]);

                }

            }
            if (i == 1 || i == 0) {
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalLibraryStatus(initIndexId[k], u, 0);
            finalApprove.setFinalStatus(initIndexId[k]);

                        ss = aa.test(username);
                        request.setAttribute("msgSuccess", "Success");
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            request.setAttribute("msg", "Error occured while getting students data!");
                            try {
                                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                            } catch (ServletException | IOException ex2) {

                            }
                        }
                    } catch (SQLException ex) {

                    }

                }
            } else if (i == 3) {//housing office
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalhousingOfficeStatus(initIndexId[k], u, 0);
            finalApprove.setFinalStatus(initIndexId[k]);

                        ss = aa.test(username);
                        request.setAttribute("msgSuccess", "Success");
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        user us = read.getAUser(username);
                        StudentBean students[] = filterStudentsForApproval.filter(us);

                        //   request.setAttribute("student", aa.test(username));
                        request.setAttribute("student", students);
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            request.setAttribute("msg", "Error occured while getting students data!");
                            try {
                                getServletContext().getRequestDispatcher("/MyErrorPage.jsp").forward(request, response);
                            } catch (ServletException | IOException ex2) {

                            }
                        }

                    } catch (SQLException ex) {

                    }

                }
            } //        {"library", "book store", "sport master", "housing office", "student cafe", "faculty store",
            //        "registrar", "advisor", "department head", "dean of research and post graduate", "continuing education business affair", "continuing education"};
            else if (i == 2) {//sport master
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalSportMasterStatus(initIndexId[k], u, 0);
            finalApprove.setFinalStatus(initIndexId[k]);

                        try {
                            ss = aa.test(username);
                            request.setAttribute("msgSuccess", "Success");
                        } catch (ClassNotFoundException | NullPointerException | SQLException ex) {
                            request.setAttribute("msg", "Fail to Approve ");
                        }
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            //         JOptionPane.showMessageDialog(null, ex);
                        }

                    } catch (SQLException ex) {
                        request.setAttribute("msg", "error occured while approving  ");
                    }

                }
            } else if (i == 4) {//students cafe
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalCafeStatus(initIndexId[k], u, 0);
            finalApprove.setFinalStatus(initIndexId[k]);

                        try {
                            ss = aa.test(username);
                            request.setAttribute("msgSuccess", "Success");
                        } catch (Exception ex) {
                            request.setAttribute("msg", "Fail to Approve ");
                        }
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            //   JOptionPane.showMessageDialog(null, ex);
                        }

                    } catch (SQLException ex) {
                        request.setAttribute("msg", "error occured while approving  ");
                    }

                }
            } else if (i == 5) {//faculty store
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalFacultyStoreStatus(initIndexId[k], u, 0);
            finalApprove.setFinalStatus(initIndexId[k]);

                        try {
                            ss = aa.test(username);
                            request.setAttribute("msgSuccess", "Success");
                        } catch (Exception ex) {
                            request.setAttribute("msg", "Fail to Approve ");
                        }
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            //    JOptionPane.showMessageDialog(null, ex);
                        }

                    } catch (SQLException ex) {
                        request.setAttribute("msg", "error occured while approving  ");
                    }

                }
            } else if (i == 6) {//registrar
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalRegistrarStatus(initIndexId[k], u, 0);
            finalApprove.setFinalStatus(initIndexId[k]);

                        try {
                            ss = aa.test(username);
                            request.setAttribute("msgSuccess", "Success");
                        } catch (ClassNotFoundException | NullPointerException | SQLException ex) {
                            request.setAttribute("msg", "Fail to Approve ");
                        }
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            //   JOptionPane.showMessageDialog(null, ex);
                        }

                    } catch (SQLException ex) {
                        request.setAttribute("msg", "error occured while approving  ");
                    }

                }
            } else if (i == 7) {//advisor
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
    //                    JOptionPane.showMessageDialog(null, "at the advisor ");

                        finalApprove.finalAdvisorStatus(initIndexId[k], u, 0);
  //                      JOptionPane.showMessageDialog(null, "at the advisor have implemented update ");
            finalApprove.setFinalStatus(initIndexId[k]);
//            JOptionPane.showMessageDialog(null,"have updated final status");

                        try {
                            ss = aa.test(username);
                            request.setAttribute("msgSuccess", "Success");
                        } catch (ClassNotFoundException | NullPointerException | SQLException ex) {
                            request.setAttribute("msg", "Fail to Approve ");
                        }
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            //       JOptionPane.showMessageDialog(null, ex);
                        }

                    } catch (SQLException ex) {
                        request.setAttribute("msg", "error occured while approving  ");
                    }

                }
            } else if (i == 8) {//department head 
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalDepartmentHeadStatus(initIndexId[k], u, 0);
            finalApprove.setFinalStatus(initIndexId[k]);

                        try {
                            ss = aa.test(username);
                            request.setAttribute("msgSuccess", "Success");
                        } catch (ClassNotFoundException | NullPointerException | SQLException ex) {
                            request.setAttribute("msg", "Fail to Approve ");
                        }
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            //   JOptionPane.showMessageDialog(null, ex);
                        }

                    } catch (SQLException ex) {
                        request.setAttribute("msg", "error occured while approving  ");
                    }

                }
            } else if (i == 9) {//dean of research and post graduate 
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalDeanOFRPGStatus(initIndexId[k], u, 0);
            finalApprove.setFinalStatus(initIndexId[k]);

                        try {
                            ss = aa.test(username);
                            request.setAttribute("msgSuccess", "Success");
                        } catch (Exception ex) {
                            request.setAttribute("msg", "Fail to Approve ");
                        }
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            //   JOptionPane.showMessageDialog(null, ex);
                        }

                    } catch (SQLException ex) {
                        request.setAttribute("msg", "error occured while approving  ");
                    }

                }
            } else if (i == 10) {//continuing education business affair 
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalContinuingEducationBAStatus(initIndexId[k], u, 0);
            finalApprove.setFinalStatus(initIndexId[k]);

                        try {
                            ss = aa.test(username);
                            request.setAttribute("msgSuccess", "Success");
                        } catch (Exception ex) {
                            request.setAttribute("msg", "Fail to Approve ");
                        }
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            //         JOptionPane.showMessageDialog(null, ex);
                        }

                    } catch (SQLException ex) {
                        request.setAttribute("msg", "error occured while approving  ");
                    }

                }
            } else if (i == 11) {//continuing education
                for (int k = 0; k < initIndexId.length; k++) {
                    try {
                        finalApprove.finalSportMasterStatus(initIndexId[k], u, 0);
                        
            finalApprove.setFinalStatus(initIndexId[k]);

                        try {
                            ss = aa.test(username);
                            request.setAttribute("msgSuccess", "Success");
                        } catch (Exception ex) {
                            request.setAttribute("msg", "Fail to Approve ");
                        }
                        request.setAttribute("username", username);
                        request.setAttribute("msgSuc", request.getAttribute("msg"));
                        request.setAttribute("username", username);
                        request.setAttribute("student", aa.test(username));
                        request.setAttribute("name", read.getAUser(username).getFirstName());
                        request.setAttribute("userrole", read.getAUser(username).getUserRole());
                        request.setAttribute("office", read.getAUser(username).getOffice());
                        try {
                            getServletContext().getRequestDispatcher("/ApproveClearance.jsp").forward(request, response);
                        } catch (IOException ex) {
                            //    JOptionPane.showMessageDialog(null, ex);
                        }

                    } catch (SQLException ex) {
                        request.setAttribute("msg", "error occured while approving  ");
                    }

                }
            }
        } catch (NullPointerException ex) {
            //     Logger.getLogger(approveClearanceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //   Logger.getLogger(approveClearanceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            // Logger.getLogger(approveClearanceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            //  Logger.getLogger(approveClearanceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected StudentBean[] test(String username) throws NullPointerException, ClassNotFoundException, SQLException {
        /*
            user u = read.getAUser(username);
            StudentBean students[] = filterStudentsForApproval.filter(u);
        
         */
        user us = read.getAUser(username);
        StudentBean students[] = filterStudentsForApproval.filter(us);

        return students;
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
