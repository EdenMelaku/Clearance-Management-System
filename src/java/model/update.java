package model;

import clearance_management.AccountInfo;
import clearance_management.clearance;
import clearance_management.user;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class update {

    public static int AddNonCafe(String id[]) throws NullPointerException, ClassNotFoundException, SQLException {
        // 0 is for non cafe 

        Connection con = connection.connectDB();
        String sql = "{CALL ADDNONCAFE(?,?)}";

        for (int i = 0; i < id.length; i++) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, 0);
            ps.setString(1, id[i]);
            ps.execute();
        }
con.close();
        return 1;

    }

    public static int changePassword(String username, String newPassword) throws NullPointerException, ClassNotFoundException, SQLException {

        Connection con = connection.connectDB();

        String sql = "{call changepassword(?,?)}";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(2, newPassword);
        pst.setString(1, username);
        pst.execute();
        con.close();
        return 1;

    }

    public static int updateAccountStatusD(String Username) throws NullPointerException, ClassNotFoundException, SQLException {

        int s = 0;

        Connection con = connection.connectDB();

        String sql = "{CALL UPDATEACCOUNTSTATUS(?,?)}";
        CallableStatement cst = con.prepareCall(sql);

        cst.setInt(2, 0);
        cst.setString(1, Username);
        cst.executeUpdate();
        s = 1;
con.close();
        return s;

    }

    public static int updateAccountStatusA(String Username) throws NullPointerException, ClassNotFoundException, SQLException {

        int s = 0;

        Connection con = connection.connectDB();

        String sql = "{CALL UPDATEACCOUNTSTATUS(?,?)}";
        CallableStatement cst = con.prepareCall(sql);

        cst.setInt(2, 1);
        cst.setString(1, Username);
        cst.executeUpdate();
        s = 1;
con.close();
        return s;

    }

    public static void main(String... args) {

    }

    public static int addUser(user user, AccountInfo af) throws NullPointerException, ClassNotFoundException, SQLException {
        Connection c = connection.connectDB();
        int addu = 0;

        Connection con = connection.connectDB();

        String sql = "{CALL addUser(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        CallableStatement cst = con.prepareCall(sql);

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = af.getCreationDate().toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        cst.setString(12, af.getCreator());
        cst.setDate(13, (java.sql.Date.valueOf(localDate)));
        cst.setDate(14, (java.sql.Date.valueOf(localDate)));
        cst.setLong(15, af.getActivity());

        cst.setString(1, user.getUsername());
        cst.setString(2, user.getFirstName());
        cst.setString(3, user.getLastName());
        cst.setString(4, user.getPassword());
        cst.setString(5, user.getOffice());
        cst.setString(6, user.getUserRole());
        cst.setString(7, user.getDepartment());
        cst.setInt(8, user.getYear());
        cst.setString(9, user.getProgram());
        cst.setString(10, user.getSection());
        cst.setInt(11, user.getAccountStatus());
        cst.execute();

        addu = 1;
        updateAccountStatusA(user.getUsername());
con.close();
        return addu;

        //status, username, firstName, lastName, password, office, userRole, department, year, program, section
    }

    public static int AddClearance(clearance clear) throws NullPointerException, ClassNotFoundException, SQLException {
        int i = 0;

        String sql = "{CALL ADDCLEARANCE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        Connection c = connection.connectDB();
        CallableStatement pst = c.prepareCall(sql);

        pst.setString(1, clear.getSID());
        pst.setString(2, clear.getReason());
        pst.setInt(3, clear.getLibraryStatus());
        pst.setInt(4, clear.getBookStoreStatus());
        pst.setInt(5, clear.getSportMasterStatus());
        pst.setInt(6, clear.getHousingOfficeStatus());
        pst.setInt(7, clear.getStudentCaféStatus());
        pst.setInt(8, clear.getFacultyStoreStatus());
        pst.setInt(9, clear.getRegistrarStatus());
        pst.setInt(10, clear.getAdvisorStatus());
        pst.setInt(11, clear.getDepartmentHeadStatus());
        pst.setInt(12, clear.getDeanOFRPGStatus());
        pst.setInt(13, clear.getContinuingEducationBAStatus());
        pst.setInt(14, clear.getContinuingEducationStatus());
        pst.setInt(15, clear.getFinalStatus());
        pst.setString(16, clear.getInitiator());
        pst.execute();

        i = 1;
c.close();
        return i;
    }

}
