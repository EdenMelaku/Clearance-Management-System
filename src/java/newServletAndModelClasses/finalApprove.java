/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newServletAndModelClasses;

import clearance_management.user;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import model.UpdateClearance;
import model.connection;
import model.read;
import otherService.calculation;

/**
 *
 * @author MEBA
 */
public class finalApprove {

    public static void finalCafeStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call finalCafeStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);
        cs.setString(1, id);

        cs.execute();
        con.close();

        UpdateClearance.setCafeStatus(id, 0, u.getUsername(), y);
        // private String id;firstName; lastname; department; program; int year;
        //finalApprove.setFinalStatus(id);

    }

    public static void finalhousingOfficeStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call FINALHOUSINGOFFICESTATUS(?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);

        System.out.println(" the devil line ");
        cs.executeUpdate();
        con.close();

        UpdateClearance.sethousingOfficeStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalSportMasterStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call finalSportMasterStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);

        cs.execute();
        con.close();

        UpdateClearance.setSportMasterStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalBookStoreStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call finalBookStoreStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);

        cs.execute();
        con.close();

        UpdateClearance.setLibraryStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalLibraryStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call finalLibraryStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);

        cs.execute();
        con.close();

        UpdateClearance.setLibraryStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalFacultyStoreStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call finalFacultyStoreStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);
        cs.setString(1, id);

        cs.execute();
        con.close();

        UpdateClearance.setFacultyStoreStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalRegistrarStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {
        //JOptionPane.showMessageDialog(null,id);
        Connection con = connection.connectDB();

        String sql = "{call finalRegistrarStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.execute();
        con.close();

        UpdateClearance.setRegistrarStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalDeanOFRPGStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call finalDeanOFRPGStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);

        cs.execute();
        con.close();

        UpdateClearance.setDeanOFRPGStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalContinuingEducationBAStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call FINALCEDUCATIONBASTATUS(?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);

        cs.execute();
        con.close();

        UpdateClearance.setContinuingEducationBAStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalContinuingEducationStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call finalContinuingEducationStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);

        cs.execute();
        con.close();

        UpdateClearance.setContinuingEducationStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalDepartmentHeadStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call finalDepartmentHeadStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);

        cs.execute();
        con.close();

        UpdateClearance.setDepartmentHeadStatus(id, 0, u.getUsername(), y);
        //finalApprove.setFinalStatus(id);

    }

    public static void finalAdvisorStatus(String id, user u, int y) throws NullPointerException, ClassNotFoundException, SQLException {
       // JOptionPane.showMessageDialog(null, "at the method before updating " + id);

        Connection con = connection.connectDB();

        String sql = "{call finalAdvisorStatus(?)}";

        CallableStatement cs = con.prepareCall(sql);
//        JOptionPane.showMessageDialog(null, "here1 ");

        cs.setString(1, id);
  //      JOptionPane.showMessageDialog(null, "here2");

        cs.execute();
    //    JOptionPane.showMessageDialog(null, "here2 ");

        con.close();
      //  JOptionPane.showMessageDialog(null, "before calling setAdvisor method  ");

        UpdateClearance.setAdvisorStatus(id, 0, u.getUsername(), y);
        //JOptionPane.showMessageDialog(null, "asucess update on both table  ");
        //finalApprove.setFinalStatus(id);

    }

    public static void setFinalStatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {
  //      JOptionPane.showMessageDialog(null, "at set final status method ");
        Connection con = connection.connectDB();
        int finalStatus = calculation.getFinalStatus(read.getClearance(id));
//        JOptionPane.showMessageDialog(null, "get final status  =" + finalStatus);
        String sql = "{call SETFINALSTATUS(?,?)}";

        CallableStatement cs = con.prepareCall(sql);
        cs.setInt(1, finalStatus);
        cs.setString(2, id);

        cs.execute();
        con.close();
    //    JOptionPane.showMessageDialog(null, "final status updated ");

    }

}
