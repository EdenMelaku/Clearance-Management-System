/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newServletAndModelClasses;

import clearance_management.StudentBean;
import clearance_management.user;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import model.connection;
import model.read;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import otherService.outputobj;
import otherService.stakeholderrow;

/**
 *
 * @author MEBA
 */
public class officeStatusFiltration {

    public static user[] getUsers(String username) throws NullPointerException, ClassNotFoundException, SQLException {
        user users[];
        user u = read.getAUser(username);
        if (u.getOffice().matches("Faculty store")) {

            int found = 0;
            int i = 0;
            Connection con = connection.connectDB();
            String sql = "begin ? := FILTERUSERS(?); end;";

            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

            stmt.setString(2, u.getOffice());
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);
            outputobj.sysout("array of type " + sa.getBaseTypeName());
            outputobj.sysout("array of length " + sa.length());

            String[] values = (String[]) sa.getArray();
            users = new user[values.length];
            for (i = 0; i < sa.length(); i++) {
                users[i] = read.getAUser(values[i]);
            }
            con.close();

        } else if (u.getOffice().charAt(0) == 'F' || u.getOffice().charAt(0) == 'f') {

            int found = 0;
            int i = 0;
            Connection con = connection.connectDB();
            String sql = "begin ? := FILTERUSERS2(?); end;";

            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

            stmt.setString(2, u.getOffice());
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);
            outputobj.sysout("array of type " + sa.getBaseTypeName());
            outputobj.sysout("array of length " + sa.length());

            String[] values = (String[]) sa.getArray();
            users = new user[values.length];
            for (i = 0; i < sa.length(); i++) {
                users[i] = read.getAUser(values[i]);
            }
            con.close();

        } else {

            int found = 0;
            int i = 0;
            Connection con = connection.connectDB();
            String sql = "begin ? := FILTERUSERS(?); end;";

            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

            stmt.setString(2, u.getOffice());
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);
            outputobj.sysout("array of type " + sa.getBaseTypeName());
            outputobj.sysout("array of length " + sa.length());

            String[] values = (String[]) sa.getArray();
            users = new user[values.length];
            for (i = 0; i < sa.length(); i++) {
                users[i] = read.getAUser(values[i]);
            }
            con.close();
        }

        return users;
    }

    public static StudentBean[] getApprovedStudents(String username) throws NullPointerException, ClassNotFoundException, SQLException {

        String query;
        StudentBean studs[] = null;
        user u = read.getAUser(username);
        if (u.getOffice().matches("advisor")) {
            query = "begin ? := getapprovedadvisor(?); end;";
        } else if (u.getOffice().matches("continuing education ")) {
            query = "begin ? := GETAPPROVEDCONTED(?); end;";
        } else if (u.getOffice().matches("continuing education business affair")) {
            query = "begin ? := GETAPPROVEDCONTEDBA(?); end;";
        } else if (u.getOffice().matches("dean of research and post graduate")) {
            query = "begin ? := GETAPPROVEDDEANOFRPG(?); end;";
        } else if (u.getOffice().matches("department head")) {
            query = "begin ? := GETAPPROVEDDEPHEAD(?); end;";
        } else if (u.getOffice().matches("faculty store")) {
            query = "begin ? := GETAPPORVEDFACSTORE(?); end;";
        } else if (u.getOffice().matches("housing office")) {
            query = "begin ? := GETAPPROVEDHOUSINGOFFICE(?); end;";
        } else if (u.getOffice().matches("library")) {
            query = "begin ? := GETAPPROVEDLIBRARY(?); end;";
        } else if (u.getOffice().matches("registrar")) {
            query = "begin ? := GETAPPROVEDREGISTRAR(?); end;";
        } else if (u.getOffice().matches("sport master")) {
            query = "begin ? := GETAPPROVEDSPORTMASTER(?); end;";
        } else {
            query = "begin ? := GETAPPROVEDSTUDETSCAFE(?); end;";
        }

        Connection conn = connection.connectDB();

        try {
            OracleCallableStatement stmt = (OracleCallableStatement) conn.prepareCall(query);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            stmt.setString(2, u.getDepartment());
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);
            System.out.println("array of type " + sa.getBaseTypeName());
            System.out.println("array of length " + sa.length());

            int count = 0;
            String[] values = (String[]) sa.getArray();

            for (int i = 0; i < sa.length(); i++) {

                StudentBean b = read.getStudent(values[i]);
                //System.out.println("row   "+ i + "  ="+b.getFirstName()+"  "+b.getLastname());

            }
            studs = new StudentBean[count + 1];
            for (int j = 0; j < count; j++) {
                studs[j] = read.getStudent(values[j]);
                //System.out.println(id[j].getFirstName()+"  "+id[j].getLastname());

            }
            conn.close();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        return studs;

    }

    public static stakeholderrow[] getrow(String office, String username) throws NullPointerException, ClassNotFoundException, SQLException {
        String query;
        stakeholderrow sr[] = null;

        if (office.matches("advisor")) {
            String[] id = officeStatusFiltration.getstudents(office);
            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READADVISOR(?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();

                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }

                con.close();
            }
        } else if (office.matches("continuing education")) {
            String[] id = officeStatusFiltration.getstudents(office);
            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READCONTED(?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();

                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }
                con.close();
            }
        } else if (office.matches("continuing education business affair")) {
            String[] id = officeStatusFiltration.getstudents(office);
            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READCONTEDBA(?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();

                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }
                con.close();
            }
        } else if (office.matches("dean of research and post graduate")) {
            String[] id = officeStatusFiltration.getstudents(office);
            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READDEANOFRPG(?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();

                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }
                con.close();
            }
        } else if (office.matches("department head")) {
            String[] id = officeStatusFiltration.getstudents(office);
            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READDEPHEAD(?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();

                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }

                con.close();
            }
        } else if (office.matches("faculty store")) {
            String[] id = officeStatusFiltration.getstudents(office);
            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READFACULTYSTORE(?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();

                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }
                con.close();
            }
        } else if (office.matches("housing office")) {

            String[] id = officeStatusFiltration.getstudents(office);

            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READHOUSINGOFFICE(?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();
                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }
                con.close();
            }
        } else if (office.matches("library")) {
            String[] id = officeStatusFiltration.getstudents(office);
            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READLIBRARY(?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();

                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }
                con.close();
            }
        } else if (office.matches("registrar")) {
            String[] id = officeStatusFiltration.getstudents(office);
            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READREGISTRAR(?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();

                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }
                con.close();
            }
        } else if (office.matches("sport master")) {
            String[] id = officeStatusFiltration.getstudents(office);

            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READSPORTMASTER (?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
                cst.execute();

                if (cst.getDate(4) == null) {
                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }
                con.close();
            }

        } else {
//            JOptionPane.showMessageDialog(null, "here in office of cafe ");
            String[] id = officeStatusFiltration.getstudents(office);
            //          JOptionPane.showMessageDialog(null, "here in office of cafe " + id.length);

            sr = new stakeholderrow[id.length];
            for (int i = 0; i < id.length; i++) {

                query = "{CALL READSTUDENTSCAFE (?,?,?,?)}";
                Connection con = connection.connectDB();

                CallableStatement cst = con.prepareCall(query);
                cst.setString(1, id[i]);

                cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
                cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 

                cst.execute();
//                JOptionPane.showMessageDialog(null, "mmmmmmmmmmmmmm");

                if (cst.getDate(4) == null) {
                    ///                  JOptionPane.showMessageDialog(null, "aaa1");

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

                } else {
                    //               JOptionPane.showMessageDialog(null, "bbbb1");

                    sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
                }
                con.close();
            }
        }

        for (int i = 0; i < sr.length; i++) {
            // System.out.println(sr[i].getId() + "   " + sr[i].getApprovedby() + "  " + sr[i].getApprovalDate() + "  " + sr[i].getStatus());
        }

        return sr;

    }

    public static String[] getstudents(String office) throws NullPointerException, ClassNotFoundException, SQLException {
        String query;
        String studs[] = null;
        query = "begin ? := FILTERSTAKEHOLDER(?); end;";

        Connection conn = connection.connectDB();

        String[] values = null;
        try {
            OracleCallableStatement stmt = (OracleCallableStatement) conn.prepareCall(query);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            if (office.matches("advisor")) {
                stmt.setInt(2, 1);
            } else if (office.matches("continuing education ")) {
                stmt.setInt(2, 2);
            } else if (office.matches("continuing education business affair")) {
                stmt.setInt(2, 3);
            } else if (office.matches("dean of research and post graduate")) {
                stmt.setInt(2, 4);
            } else if (office.matches("department head")) {
                stmt.setInt(2, 5);
            } else if (office.matches("faculty store")) {
                stmt.setInt(2, 6);
            } else if (office.matches("housing office")) {
                stmt.setInt(2, 7);
            } else if (office.matches("library")) {
                stmt.setInt(2, 8);
            } else if (office.matches("registrar")) {
                stmt.setInt(2, 9);
            } else if (office.matches("sport master")) {
                stmt.setInt(2, 10);
            } else {
                stmt.setInt(2, 11);
            }

            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);
            System.out.println("array of type " + sa.getBaseTypeName());
            System.out.println("array of length " + sa.length());

            int count = 0;
            values = (String[]) sa.getArray();

            for (int i = 0; i < values.length; i++) {
                // System.out.println(values[i]);
            }
            conn.close();

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        return values;
    }

    public static stakeholderrow[] filterPM(String username) throws NullPointerException, ClassNotFoundException, SQLException {

        stakeholderrow[] sr = null;
        String query;

        query = "{ begin ? := GET_ADVISORS_BY_FACULTY(?); end;";
        Connection con = connection.connectDB();

        OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(query);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.setString(2, username);
        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);

        String[] adv = (String[]) sa.getArray();

        query = "{ begin ? := FILTER_FACULTYSTORE_BY_FID (?); end;";
        stmt = (OracleCallableStatement) con.prepareCall(query);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.setString(2, username);
        stmt.executeUpdate();
        sa = stmt.getARRAY(1);

        String[] facs = (String[]) sa.getArray();
        for (int i = 0; i < adv.length; i++) {

        }
        con.close();
        return null;
    }

    public static String[] getStudentsforPM(String username) throws NullPointerException, ClassNotFoundException, SQLException {
        String query;

        query = " begin ? := FILTER_STUDENTS_BY_FID(?); end;";
        Connection con = connection.connectDB();

        OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(query);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.setString(2, username);

        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);

        String[] adv = (String[]) sa.getArray();
        con.close();
        return adv;

    }

    public static stakeholderrow[] filterAdvisor(String id[]) throws NullPointerException, ClassNotFoundException, SQLException {

        stakeholderrow sr[] = null;

        sr = new stakeholderrow[id.length];
        for (int i = 0; i < id.length; i++) {
            outputobj.sysout("reading for " + id[i]);
            String query = "{CALL READADVISOR(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id[i]);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();

            if (cst.getDate(4) == null) {
                sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

            } else {

                sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
            }
            con.close();
        }

        return sr;

    }

    public static stakeholderrow[] filterDepartmentHead(String[] id) throws NullPointerException, ClassNotFoundException, SQLException {

        stakeholderrow sr[] = null;
        sr = new stakeholderrow[id.length];
        for (int i = 0; i < id.length; i++) {

            String query = "{CALL READDEPHEAD(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id[i]);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();

            if (cst.getDate(4) == null) {
                sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

            } else {

                sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
            }
            con.close();
        }
        return sr;
    }

    public static stakeholderrow[] filterfacultyStore(String[] id) throws NullPointerException, ClassNotFoundException, SQLException {

        stakeholderrow[] sr = new stakeholderrow[id.length];
        for (int i = 0; i < id.length; i++) {
            System.out.println("reading for ___________ " + id[i]);
            String query = "{CALL READFACULTYSTORE(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id[i]);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();

            if (cst.getDate(4) == null) {
                sr[i] = new stakeholderrow(id[i], cst.getString(3), null, cst.getInt(2));

            } else {

                sr[i] = new stakeholderrow(id[i], cst.getString(3), cst.getDate(4), cst.getInt(2));
            }
            con.close();
        }
        return sr;

    }

    public static String[] getAvsuds(String username) throws SQLException {

        Connection conn = connection.connectDB();
        String sqll = "begin ? := GETAVAILABLESTUDBYPMFORFS(?); end;";

        OracleCallableStatement stmt = (OracleCallableStatement) conn.prepareCall(sqll);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.setString(2, username);
        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);

        String[] values = (String[]) sa.getArray();
        return values;
    }

    public static void main(String... args) {
        try {
            String un = "samson@gmail.com";
            String id[] = officeStatusFiltration.getStudentsforPM(un);
            stakeholderrow[] adv = officeStatusFiltration.filterAdvisor(id);
            stakeholderrow[] dep = officeStatusFiltration.filterDepartmentHead(id);
            stakeholderrow[] fac = officeStatusFiltration.filterfacultyStore(officeStatusFiltration.getAvsuds(un));
            System.out.println((fac.length));

            System.out.println(id.length);

            // String id[] = officeStatusFiltration.getstudents("student cafe");
//            for (int i = 0; i < id.length; i++) {
//                outputobj.sysout(id[i] + "");
//            }
//            stakeholderrow[] adv = officeStatusFiltration.filterAdvisor(id);
//            stakeholderrow[] dep = officeStatusFiltration.filterDepartmentHead(id);
//            stakeholderrow[] fac = officeStatusFiltration.filterfacultyStore(id);
//            outputobj.sysout("filtering for advisor ");
//            for (int i = 0; i < adv.length; i++) {
//
//                outputobj.sysout(adv[i].getId() + "  " + adv[i].getApprovedby() + "  " + adv[i].getApprovalDate());
//            }
//            outputobj.sysout("filtering for department head  ");
//            for (int i = 0; i < dep.length; i++) {
//
//                outputobj.sysout(dep[i].getId() + "  " + dep[i].getApprovedby() + "  " + dep[i].getApprovalDate());
//            }
//            outputobj.sysout("filtering for faculty head  ");
//
//            for (int i = 0; i < fac.length; i++) {
//
//                outputobj.sysout(fac[i].getId() + "  " + fac[i].getApprovedby() + "  " + fac[i].getApprovalDate());
//            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
