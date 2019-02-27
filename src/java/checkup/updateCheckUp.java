
package checkup;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class updateCheckUp extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String username = request.getParameter("username");
        String studentID = (String) request.getParameter("varlet");
        String stulen = request.getParameter("arraylength");
        String RealLength = request.getParameter("length");//this is length of the total sid

        int len = Integer.parseInt(stulen);

        JOptionPane.showMessageDialog(null, "Students : " + studentID);
        //this is to filter the real index
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
        stud[len - 1] = a;
        i = 0;
        //end of identification    

        String[] ss = new String[stud.length];
        JOptionPane.showMessageDialog(null, "thte ken is " + stud.length);
        for (int j = 0; j < len; j++) {
            JOptionPane.showMessageDialog(null, "get it " + stud[j]);
        }
        int nn = Integer.parseInt(RealLength);
        String[] allId = new String[nn];
        int initHolder = 0;
        for (int k = 0; k < nn; k++) {
            allId[k] = (String) request.getParameter("studentsIdNum[" + k + "]");
        }
        int c = 0;
        for (int j = 0; j < len; j++) {
            JOptionPane.showMessageDialog(null, "get it " + stud[j]);
            JOptionPane.showMessageDialog(null, "this " + allId[Integer.parseInt(stud[j])]);
            ss[c] = allId[Integer.parseInt(stud[j])];
            c++;
        }
        c = 0;

        // DISPLAY
          initHolder = 0;
        JOptionPane.showMessageDialog(null, "The Following Are Updated Students Id");
        for (int y = 0; y < ss.length; y++) {
            JOptionPane.showMessageDialog(null, ss[y]);
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
