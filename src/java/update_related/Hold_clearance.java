/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update_related;

import clearance_management.StudentBean;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.connection;
import model.read;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;

/**
 *
 * @author MEBA
 */
public class Hold_clearance {

    // 0= all,  1= ur, 2- us, 3- ue ,  4- pr,  5- ps  
    public static StudentBean[] filterBYusername(String username, int office) throws NullPointerException, ClassNotFoundException, SQLException {
        StudentBean[] students = new StudentBean[1000];
        StudentBean[] s = null;
        int i = office;

        // faculty store 
        if (i == 5) {

            // considering user.department= faculty id 
           // JOptionPane.showMessageDialog(null, " faculrt id ="+read.getAUser(username).getDepartment()+"   "+username);
            Connection con = connection.connectDB();
            String sql = " begin ? := FILTER_HOLD_FACULTYS(?); end;";
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            stmt.setString(2, read.getAUser(username).getDepartment());
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }

            return s;

        } else if (i == 4 || i == 2) {

            //cafe, sportmaster 
            if (i == 4) {
                Connection con = connection.connectDB();
                String sql = " begin ? := FILTER_HOLD_CAFE; end;";
                OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
                stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

                stmt.executeUpdate();
                ARRAY sa = stmt.getARRAY(1);

                String[] values = (String[]) sa.getArray();
                s = new StudentBean[values.length];
                for (int k = 0; k < sa.length(); k++) {

                    s[k] = read.getStudent(values[k]);

                }
            } else {
                Connection con = connection.connectDB();
                String sql = " begin ? := FILTER_HOLD_SM; end;";
                OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
                stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

                stmt.executeUpdate();
                ARRAY sa = stmt.getARRAY(1);

                String[] values = (String[]) sa.getArray();
                s = new StudentBean[values.length];
                for (int k = 0; k < sa.length(); k++) {

                    s[k] = read.getStudent(values[k]);

                }
            }
            return s;

        } // library and bookstore
        else if (i == 1 || i == 0) {
            // status=getStatusFromAll.getLibraryStatus(id);

            Connection con = connection.connectDB();
            String sql = " begin ? := FILTER_HOLD_LIBRARY; end;";
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }

            return s;
        } else if (i == 3) {
            // housing office 
            //ur, us, pr, ps

            System.out.println("here is i housing office");
            Connection con = connection.connectDB();
            String sql = " begin ? := FILTER_HOLD_HOUSINGOFFICE; end;";
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);
            System.out.println("here is i housing office");

            System.out.println("here is " + sa.length());

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];

            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }

            System.out.println("here is  s " + s.length);
            return s;
        } else {
            return null;
        }

    }

    public static void main(String... args) {
        try {
            StudentBean[] b = Hold_clearance.filterBYusername("sami@gmail.com", 3);
            System.out.println("number of students =" + b.length);
            for (int i = 0; i < b.length; i++) {
                System.out.println(b[i].getFirstName() + "    " + b[i].getId());
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(releaseClearance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(releaseClearance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(releaseClearance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
