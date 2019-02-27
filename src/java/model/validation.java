/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clearance_management.user;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import otherService.outputobj;

/**
 *
 * @author Bit
 */
public class validation {

    public static int userValidation(String u, String p) throws NullPointerException, ClassNotFoundException, SQLException {
        outputobj.sysout(" validating  pppppppppppp");
        outputobj.sysout("at the validation method validating for   " + u + "  " + p);
        user user = read.getUser(u, p);
        // JOptionPane.showMessageDialog(null,"found for username   "+u+"  "+user.getFirstName()+" "+user.getLastName());
        Connection c = connection.connectDB();
        String username = null;
        int res = 0;
        if (user == null) {

            CallableStatement cst = null;

            String sql = "{CALL getAuser(?,?,?,?,?,?,?,?,?,?,?)}";
            cst = c.prepareCall(sql);
            cst.setString(1, username);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);

            cst.registerOutParameter(4, java.sql.Types.VARCHAR);
            cst.registerOutParameter(5, java.sql.Types.VARCHAR);
            cst.registerOutParameter(6, java.sql.Types.VARCHAR);
            cst.registerOutParameter(7, java.sql.Types.VARCHAR);
            cst.registerOutParameter(8, java.sql.Types.VARCHAR);
            cst.registerOutParameter(9, java.sql.Types.NUMERIC);

            cst.registerOutParameter(10, java.sql.Types.VARCHAR);
            cst.registerOutParameter(11, java.sql.Types.NUMERIC);

            cst.executeQuery();

            username = cst.getString(2);

            if (username == null) {
                res = 4;
            } else {
                res = 3;
            }

        } else {

            if (user.AccountStatus() == 1) {
                res = 1;
            } else {
                res = 2;
            }

        }
        c.close();
        return res;
    }

    public static int validateuser(String username) throws NullPointerException, ClassNotFoundException, SQLException {
        Connection con = connection.connectDB();
        String sql = "begin ? := CHECKUSER(?); end;";

        OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
        stmt.registerOutParameter(1, OracleTypes.NUMBER);
        stmt.setString(2, username);
        stmt.executeUpdate();
        int x = stmt.getInt(1);
        System.out.println("the value of x is =" + x);
        con.close();
        return x;

    }

    public static Boolean isEligibleToPerformAction(String pu, String mu) throws NullPointerException, ClassNotFoundException, SQLException {
        String privUO = "";
        String masUO = "";
        if (mu.matches("system")) {
            return true;
        } else {

            masUO = read.getAUser(mu).getOffice();
            privUO = read.getAUser(pu).getOffice();
            if (masUO.matches(privUO)) {
                return true;
            } else {
                return false;
            }

        }
    }

    public static void main(String... args) {

        try {
            validation.validateuser("binisha@gmail.com");
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
