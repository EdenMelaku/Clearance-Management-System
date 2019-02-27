/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;

import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author MEBA
 */
public class getStatusFromAll {

    public static int getCafeStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getCafeStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int gethousingOfficeStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL gethousingOfficeStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int getSportMasterStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getSportMasterStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int getLibraryStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getLibraryStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int getFacultyStoreStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getFacultyStoreStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int getRegistrarStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getRegistrarStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int getDeanOFRPGStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getDeanOFRPGStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int getContinuingEducationBAStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getContinuingEducationBAStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int getContinuingEducationStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getContinuingEducationStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int getAdvisorStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {

        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getAdvisorStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

    public static int getDepartmentHeadStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {

        int status = 99;

        Connection con = connection.connectDB();

        String sql = "{CALL getDepartmentHeadStatus(?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);

        ResultSet rs = cst.executeQuery();

        status = cst.getInt(2);
        con.close();

        // private String id;firstName; lastname; department; program; int year;
        return status;

    }

}
