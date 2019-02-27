package model;

import clearance_management.AccountInfo;
import clearance_management.StudentBean;
import clearance_management.clearance;
import clearance_management.user;
import java.sql.*;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import otherService.AccountManagingInfo;
import otherService.outputobj;

/**
 *
 * @author Bit
 */
public class read {

    public static user getUser(String username, String password) throws NullPointerException, ClassNotFoundException, SQLException {
        Connection c = connection.connectDB();
        user user = null;

        outputobj.sysout(" about to reading ");
        CallableStatement cst = null;

        String sql = "{CALL getuser(?,?,?,?,?,?,?,?,?,?,?,?)}";
        cst = c.prepareCall(sql);
        cst.setString(1, username);
        cst.setString(2, password);
        cst.registerOutParameter(3, java.sql.Types.VARCHAR);

        cst.registerOutParameter(4, java.sql.Types.VARCHAR);
        cst.registerOutParameter(5, java.sql.Types.VARCHAR);
        cst.registerOutParameter(6, java.sql.Types.VARCHAR);
        cst.registerOutParameter(7, java.sql.Types.VARCHAR);
        cst.registerOutParameter(8, java.sql.Types.VARCHAR);
        cst.registerOutParameter(9, java.sql.Types.VARCHAR);

        cst.registerOutParameter(10, java.sql.Types.NUMERIC);
        cst.registerOutParameter(11, java.sql.Types.VARCHAR);
        System.out.println(" registering ");
        cst.registerOutParameter(12, java.sql.Types.NUMERIC);

        outputobj.sysout("reading ");

        cst.executeQuery();

        user = new user(cst.getInt(12), cst.getString(3), cst.getString(4), cst.getString(5), " ",
                cst.getString(6), cst.getString(7), cst.getString(8), cst.getInt(10), cst.getString(9),
                cst.getString(11));
        c.close();

        return user;
    }

    public static user getAUser(String username) throws NullPointerException, ClassNotFoundException, SQLException {
        Connection c = connection.connectDB();
        user user = null;
        //  System.out.println(" about to reading ");
        CallableStatement cst = null;

        String sql = "{CALL getAuser(?,?,?,?,?,?,?,?,?,?,?,?)}";
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
        cst.registerOutParameter(12, java.sql.Types.VARCHAR);
        // outputobj.sysout(" registering ");

        cst.executeQuery();
        user = new user(cst.getInt(11), cst.getString(2), cst.getString(3), cst.getString(4), cst.getString(12),
                cst.getString(5), cst.getString(6), cst.getString(7), cst.getInt(9), cst.getString(8),
                cst.getString(10));
        c.close();
//JOptionPane.showMessageDialog(null, " dep  "+cst.getString(7));
        return user;
    }

    public static AccountManagingInfo[] getAccountManagingInfo(user u) throws NullPointerException, ClassNotFoundException, SQLException {

        AccountManagingInfo ami[] = null;
        if (u.getOffice().matches("faculty")) {

            ami = read.getAccountManagingInfoPM(u.getUsername());
        } else {
            AccountManagingInfo ami1[] = new AccountManagingInfo[1000];
            user users[] = new user[1000];
            int found = 0;
            int i = 0;
            Connection con = connection.connectDB();
            String sql = "begin ? := GETUSERID(?); end;";

            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            stmt.setString(2, u.getOffice());
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);
            outputobj.sysout("array of type " + sa.getBaseTypeName());
            outputobj.sysout("array of length " + sa.length());

            String[] values = (String[]) sa.getArray();
            int count = 0;
            for (i = 0; i < sa.length(); i++) {
                user b = read.getAUser(values[i]);
                AccountInfo a = read.getAccountInfo(values[i]);

                ami1[i] = new AccountManagingInfo(b.AccountStatus(), b.getUsername(), b.getFirstName(), b.getLastName(), b.getOffice(),
                        b.getUserRole(), b.getDepartment(), b.getYear(), b.getProgram(),
                        b.getSection(), a.getCreator(), a.getCreationDate(), a.getLastLogin(), a.getActivity());

                //outputobj.joption(ami1[i].getFirstName() + "  " + ami1[i].getLastName());
                count++;
            }

            ami = new AccountManagingInfo[count];
            outputobj.sysout(" SIZE  " + found + "     " + ami.length);
            for (int j = 0; j < count; j++) {
                outputobj.sysout("" + i);
                ami[j] = ami1[j];
            }
            con.close();
        }

        return ami;

    }

    private static AccountInfo getAccountInfo(String username) throws NullPointerException, ClassNotFoundException, SQLException {
        AccountInfo a = null;

        Connection con = connection.connectDB();
        String sql = "{CALL GETACCOUNTINFO(?,?,?,?,?,?)}";
        CallableStatement cst = con.prepareCall(sql);
        cst.setString(1, username);

        cst.registerOutParameter(2, java.sql.Types.VARCHAR);
        cst.registerOutParameter(3, java.sql.Types.VARCHAR);
        cst.registerOutParameter(4, java.sql.Types.DATE);
        cst.registerOutParameter(5, java.sql.Types.DATE);
        cst.registerOutParameter(6, java.sql.Types.NUMERIC);

        cst.executeUpdate();

        a = new AccountInfo(cst.getString(2), cst.getString(3), cst.getDate(4), cst.getDate(5), cst.getLong(6));
        outputobj.sysout(a.getCreationDate() + " ");
        con.close();
        return a;

    }

    public String[] getUserData(String username, String password) throws NullPointerException, ClassNotFoundException, SQLException {

        String[] userData = new String[11];

        user u = read.getUser(username, password);
        userData[0] = u.getUsername();
        userData[1] = u.getFirstName();
        userData[2] = u.getLastName();
        userData[3] = u.getPassword();
        userData[4] = u.getOffice();
        userData[5] = u.getUserRole();
        userData[6] = u.getDepartment();
        userData[7] = String.valueOf(u.getYear());
        userData[8] = u.getProgram();
        userData[9] = u.getSection();
        userData[10] = String.valueOf(u.getAccountStatus());

        return userData;
    }

    public static StudentBean getStudent(String sid) throws NullPointerException, ClassNotFoundException, SQLException {
        StudentBean stud = null;
        Connection con = connection.connectDB();
        //     System.out.println(" about to reading ");
        CallableStatement cst = null;

        String sql = "{CALL getStudent(?,?,?,?,?,?,?,?)}";
        cst = con.prepareCall(sql);
        cst.setString(1, sid);
        cst.registerOutParameter(2, java.sql.Types.VARCHAR);
        cst.registerOutParameter(3, java.sql.Types.VARCHAR);

        cst.registerOutParameter(4, java.sql.Types.VARCHAR);
        cst.registerOutParameter(5, java.sql.Types.VARCHAR);
        cst.registerOutParameter(6, java.sql.Types.VARCHAR);
        cst.registerOutParameter(7, java.sql.Types.NUMERIC);
        cst.registerOutParameter(8, java.sql.Types.VARCHAR);

        cst.executeQuery();

        stud = new StudentBean(cst.getString(2), cst.getString(3), cst.getString(4), cst.getString(5),
                cst.getString(6), cst.getInt(7), cst.getString(8));
        con.close();
        return stud;
    }

    public static int[] getStakeHolders(String program) throws NullPointerException, ClassNotFoundException, SQLException {

        int[] sh = new int[12];

        Connection con = connection.connectDB();

        CallableStatement cst = null;

        String sql = "{CALL GETSTAKEHOLDER(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        cst = con.prepareCall(sql);
        cst.setString(1, program);
        cst.registerOutParameter(2, java.sql.Types.NUMERIC);
        cst.registerOutParameter(3, java.sql.Types.NUMERIC);

        cst.registerOutParameter(4, java.sql.Types.NUMERIC);
        cst.registerOutParameter(5, java.sql.Types.NUMERIC);
        cst.registerOutParameter(6, java.sql.Types.NUMERIC);
        cst.registerOutParameter(7, java.sql.Types.NUMERIC);
        cst.registerOutParameter(8, java.sql.Types.NUMERIC);
        cst.registerOutParameter(9, java.sql.Types.NUMERIC);
        cst.registerOutParameter(10, java.sql.Types.NUMERIC);
        cst.registerOutParameter(11, java.sql.Types.NUMERIC);
        cst.registerOutParameter(12, java.sql.Types.NUMERIC);
        cst.registerOutParameter(13, java.sql.Types.NUMERIC);

        cst.executeQuery();

        for (int i = 2; i <= 13; i++) {
            sh[i - 2] = cst.getInt(i);
        }
        con.close();
        return sh;

    }

    public static StudentBean[] getStudents(user u) throws NullPointerException, ClassNotFoundException, SQLException {
        StudentBean[] students = new StudentBean[1000];
        StudentBean[] s = null;

        Connection con = connection.connectDB();
        String sql = "begin ? := GETSTUDENTSBYBATCH(?,?,?,?); end;";
        OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.setString(2, u.getDepartment());
        stmt.setString(3, u.getProgram());
        stmt.setInt(4, u.getYear());
        stmt.setString(5, u.getSection());

        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);

        String[] values = (String[]) sa.getArray();

        int i = 0;
        for (i = 0; i < sa.length(); i++) {
            students[i] = read.getStudent(values[i]);

            outputobj.sysout("row   " + i + "  =" + students[i].getFirstName() + "  " + students[i].getLastname());
            i++;
        }

        s = new StudentBean[i + 1];
        for (int j = 0; j <= i; j++) {
            s[j] = students[j];
        }
        con.close();
        return s;

    }

    public static void main(String... str) {
        try {
            AccountManagingInfo am[] = read.getAccountManagingInfo(read.getAUser("nega@gmail.com"));
            for (int i = 0; i < am.length; i++) {
                System.out.println(am[i].getUsername() + "   " + am[i].getCreationDate());
            }
            // AccountManagingInfo am[] = read.getAccountManagingInfoPM("abera@gmail.com");

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static AccountManagingInfo[] getAccountManagingInfoPM(String u) throws NullPointerException, ClassNotFoundException, SQLException {

        AccountManagingInfo ami1[] = new AccountManagingInfo[1000];
        user users[] = new user[1000];
        int found = 0;
        int i = 0;
        Connection con = connection.connectDB();
        String sql = "begin ? := FILTERFACULTYACCOUNTS(?); end;";

        OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.setString(2, u);
        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);
        outputobj.sysout("array of type " + sa.getBaseTypeName());
        outputobj.sysout("array of length " + sa.length());

        String[] values = (String[]) sa.getArray();
        int count = 0;
        for (i = 0; i < sa.length(); i++) {
            user b = read.getAUser(values[i]);
            AccountInfo a = read.getAccountInfo(values[i]);

            ami1[i] = new AccountManagingInfo(b.AccountStatus(), b.getUsername(), b.getFirstName(), b.getLastName(), b.getOffice(),
                    b.getUserRole(), b.getDepartment(), b.getYear(), b.getProgram(),
                    b.getSection(), a.getCreator(), a.getCreationDate(), a.getLastLogin(), a.getActivity());

            outputobj.joption(ami1[i].getFirstName() + "  " + ami1[i].getLastName());
            count++;
        }

        AccountManagingInfo ami[] = new AccountManagingInfo[count];
        outputobj.sysout(" SIZE  " + found + "     " + ami.length);
        for (int j = 0; j < count; j++) {
            // outputobj.sysout("" + i);
            ami[j] = ami1[j];

        }
        con.close();
        return ami;

    }

    public static String[] getDepartments(String facultyID) throws NullPointerException, ClassNotFoundException, SQLException {

        String[] departments1 = new String[100];
        String[] departments = null;

        Connection con = connection.connectDB();
        String sql = "begin ? :=  GETDEPTS(?); end;";
        OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
        stmt.setString(2, facultyID);

        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);
        String[] values = (String[]) sa.getArray();
        int i = 0;
        for (i = 0; i < sa.length(); i++) {

            departments1[i] = values[i];
            outputobj.sysout("department ---- " + departments1[i]);

        }

        outputobj.sysout("the number of deaprtments =  " + i);
        departments = new String[i];
        for (int j = 0; j < i; j++) {
            outputobj.joption(departments1[j]);
            departments[j] = departments1[j];
        }
        con.close();
        return departments;

    }

    public static String getFacultyID(String username) throws NullPointerException, ClassNotFoundException, SQLException {

        String facultyId = "99";

        Connection con = connection.connectDB();
        String sql = "{CALL GETFACULTYID(?,?)}";
        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, username);
        cst.registerOutParameter(2, java.sql.Types.VARCHAR);
        cst.executeQuery();

        facultyId = cst.getString(2);
        con.close();
        return facultyId;
    }

    public static clearance getClearance(String id) throws NullPointerException, ClassNotFoundException, SQLException {

        clearance c = null;

        Connection con = connection.connectDB();

        String sql = "{call GETCLEARANCE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement cst = con.prepareCall(sql);
        cst.setString(1, id);
        cst.registerOutParameter(2, java.sql.Types.VARCHAR);
        cst.registerOutParameter(3, java.sql.Types.VARCHAR);
        cst.registerOutParameter(4, java.sql.Types.NUMERIC);
        cst.registerOutParameter(5, java.sql.Types.NUMERIC);
        cst.registerOutParameter(6, java.sql.Types.NUMERIC);
        cst.registerOutParameter(7, java.sql.Types.NUMERIC);
        cst.registerOutParameter(8, java.sql.Types.NUMERIC);
        cst.registerOutParameter(9, java.sql.Types.NUMERIC);
        cst.registerOutParameter(10, java.sql.Types.NUMERIC);
        cst.registerOutParameter(11, java.sql.Types.NUMERIC);
        cst.registerOutParameter(12, java.sql.Types.NUMERIC);
        cst.registerOutParameter(13, java.sql.Types.NUMERIC);
        cst.registerOutParameter(14, java.sql.Types.NUMERIC);
        cst.registerOutParameter(15, java.sql.Types.NUMERIC);
        cst.registerOutParameter(16, java.sql.Types.NUMERIC);
        cst.registerOutParameter(17, java.sql.Types.VARCHAR);

        cst.execute();
        c = new clearance(cst.getString(2), cst.getString(3),
                cst.getInt(4), cst.getInt(5), cst.getInt(6), cst.getInt(7), cst.getInt(8),
                cst.getInt(9), cst.getInt(10),
                cst.getInt(11), cst.getInt(12), cst.getInt(13), cst.getInt(14),
                cst.getInt(15), cst.getInt(16), cst.getString(17));
        con.close();
        return c;

    }

}
