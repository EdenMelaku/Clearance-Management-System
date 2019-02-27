/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newServletAndModelClasses;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import model.connection;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author MEBA
 */
public class ActivateDeactivate {

    static DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
    //Date d=new Date();

    static Calendar c = new GregorianCalendar();
    static java.util.Date d = c.getTime();
    static Instant instant = d.toInstant();
    static ZoneId zoneID = ZoneId.systemDefault();
    static ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
    static LocalDate localDate = zdt.toLocalDate();

    public static void Activate(String id, String username) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection c = connection.connectDB();

        CallableStatement cst = null;

        String sql = "{CALL UPDATEDEACTIVATEDLIST(?,?,?)}";
        cst = c.prepareCall(sql);
        cst.setInt(1, 0);
        cst.setString(2, id);
        cst.setDate(3, java.sql.Date.valueOf(localDate));

        cst.executeQuery();
        c.close();
        finalApprove.setFinalStatus(id);

    }

    public static void Deactivate(String id, String username) throws NullPointerException, ClassNotFoundException, SQLException {
        Connection con = connection.connectDB();
        String sql = "begin ? := checkDeactivatedlist(?); end;";

        OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
        stmt.registerOutParameter(1, OracleTypes.NUMBER);
        stmt.setString(2, id);
        stmt.executeUpdate();
        int x = stmt.getInt(1);
        System.out.println("the value of x is =" + x);

        if (x == 0) {

            System.out.println("student not found in list so inserting is posssible ");
            String query = "{CALL INSERTDEACTIVATEDLIST(?,?,?,?,?)}";
            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);
            cst.setString(2, username);
            cst.setDate(3, java.sql.Date.valueOf(localDate));
            cst.setDate(4, null);
            cst.setInt(5, 1);

            cst.executeQuery();
            con.close();
            finalApprove.setFinalStatus(id);

        } else {
            System.out.println("student found in list  ");
            CallableStatement cst = null;

            String sq = "{CALL UPDATEDEACTIVATEDLIST2(?,?,?)}";
            cst = con.prepareCall(sq);
            cst.setInt(1, 1);
            cst.setString(2, id);
            cst.setDate(3, java.sql.Date.valueOf(localDate));

            cst.executeQuery();
        }
        con.close();

        finalApprove.setFinalStatus(id);
    }

    public static void main(String... m) {

        try {
            ActivateDeactivate.Deactivate("oo19", "default");
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
