package newServletAndModelClasses;

import clearance_management.StudentBean;
import clearance_management.user;
import java.sql.Connection;
import java.sql.SQLException;
import model.connection;
import model.read;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import otherService.outputobj;

public class filterStudentsForApproval {

    static String[] stakeholders = {"library", "book store", "sport master", "housing office", "student cafe", "faculty store",
        "registrar", "advisor", "department head", "dean of research and post graduate", "continuing education business affair", "continuing education"};

    // 0= all,  1= ur, 2- us, 3- ue ,  4- pr,  5- ps  
    public static StudentBean[] filter(user u) throws NullPointerException, ClassNotFoundException, SQLException {
        StudentBean[] students = new StudentBean[1000];
        StudentBean[] s = null;
        int i = 99;
       System.out.println(u.getOffice());

        for (int j = 0; j < stakeholders.length; j++) {
            if (u.getOffice().toLowerCase().matches(stakeholders[j])) {
                i = j;
       System.out.println("iside the looppn  "+u.getOffice());
            }

        }

        // faculty store 
        if (i == 5) {

            // considering user.department= faculty id 
            Connection conn = connection.connectDB();
            String sqll = "begin ? := FILTERFORFACULTYSTORE(?); end;";

            OracleCallableStatement stmt = (OracleCallableStatement) conn.prepareCall(sqll);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            stmt.setString(2, u.getDepartment());
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();

            s = new StudentBean[values.length];

            for (int ii = 0; ii < values.length; ii++) {
                s[ii] = read.getStudent(values[ii]);

            }
            conn.close();
            return s;

        } //- students cafe,  sport master 
        else if (i == 4 || i == 2) {

            Connection con = connection.connectDB();
            String sql;
            // studnets cafe
            if (i == 4) {
                sql = "begin ? := FILTERFORSTUDENTSCAFE; end;";

            } // sport master ---------- SPORTMASTERSTATUS
            else {
                sql = "begin ? := FILTERFORSPORTMASTER; end;";

            }
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }
            con.close();

            return s;

        } // department head
        else if (i == 8) {
            // status=getStatusFromAll.getLibraryStatus(id);

            Connection con = connection.connectDB();
            String sql = " begin ? := FILTERFORDEPARTMENTHEAD(?); end;";
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            stmt.setString(2, u.getDepartment());
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }
            con.close();

            return s;
        } // advisor
        else if (i == 7) {

            Connection con = connection.connectDB();
            String sql = " begin ? := GETSTUDS(?,?,?,?); end;";
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            stmt.setString(2, u.getDepartment());
            stmt.setString(3, u.getProgram());
            stmt.setInt(4, u.getYear());
            stmt.setString(5, u.getSection());
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }
            con.close();

            return s;
        } //library + bookstore,
        else if (i == 1 || i == 0) {
            // status=getStatusFromAll.getLibraryStatus(id);

            Connection con = connection.connectDB();
            String sql = " begin ? := FILTERFORLIBRARY; end;";
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }
            con.close();

            return s;
        } // registrar 
        else if (i == 6) {

            Connection con = connection.connectDB();
            String sql = " begin ? := FILTERFORREGISTRAR; end;";
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }
            con.close();

            return s;
        } //housing 
        else if (i == 3) {
            //ur, us, pr, ps
            Connection con = connection.connectDB();
            String sql = " begin ? := FILTERFORHOUSINGOFFICE; end;";
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }
            con.close();

            return s;
        } //dean of.....
        else if (i == 9) {

            Connection con = connection.connectDB();
            String sql = " begin ? := FILTERFORDEANOFRPG; end;";
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");

            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }
            con.close();

            return s;

        } else if (i == 10 || i == 11) {
//              10- BA 
//              11- CE
            Connection con = connection.connectDB();
            String sql;
            // studnets cafe
            if (i == 10) {
                sql = "begin ? := FILTERFORCEBA; end;";

            } // sport master ---------- SPORTMASTERSTATUS
            else {
                sql = "begin ? := FILTERFORCE; end;";

            }
            OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sql);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            stmt.executeUpdate();
            ARRAY sa = stmt.getARRAY(1);

            String[] values = (String[]) sa.getArray();
            s = new StudentBean[values.length];
            for (int k = 0; k < sa.length(); k++) {

                s[k] = read.getStudent(values[k]);

            }
            con.close();

            return s;

        } else {

            outputobj.sysout("the role and the office of the user is unknown ");
            return null;
        }

    }

    public static void main(String... args) {

        try {
            user u = read.getAUser("bernabas@gmail.com");
            StudentBean b[] = filterStudentsForApproval.filter(u);
                System.out.println("here is the name   "+b.length);

            for(int i=0;i<b.length;i++){
                System.out.println("here is the name   "+b[i].getFirstName());
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
