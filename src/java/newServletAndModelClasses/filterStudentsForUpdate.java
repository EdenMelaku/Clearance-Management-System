package newServletAndModelClasses;

import clearance_management.StudentBean;
import java.sql.Connection;
import java.sql.SQLException;
import model.connection;

import model.read;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;

public class filterStudentsForUpdate {

    static String[] stakeholders = {"library", "BookStore", "SportMaster", "housing Office", "StudentCafe", "FacultyStore",
        "Registrar", "Advisor", "DepartmentHead", "DeanOFRPG", "ContinuingEducationBA", "ContinuingEducation"};

    // 0= all,  1= ur, 2- us, 3- ue ,  4- pr,  5- ps  
    public static StudentBean[] filterBYusername(String username, int office) throws NullPointerException, ClassNotFoundException, SQLException {
        StudentBean[] students = new StudentBean[1000];
        StudentBean[] s = null;
        int i = office;

        // faculty store 
        if (i == 5) {

            // considering user.department= faculty id 
            Connection con = connection.connectDB();
            String sql = " begin ? := FILTERFORUPDATEFACULTYSTORE(?); end;";
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
            con.close();

            return s;

        } else if (i == 4 || i == 2) {

            //cafe, sportmaster 
            Connection con = connection.connectDB();
            String sql = " begin ? := FILTER_FOR_UPDATE_CAFE_OR_SM; end;";
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

        } // library and bookstore
        else if (i == 1 || i == 0) {
            // status=getStatusFromAll.getLibraryStatus(id);

            Connection con = connection.connectDB();
            String sql = " begin ? := SELECT_ALL_STUDENTS; end;";
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
        } else if (i == 3) {
            // housing office 
            //ur, us, pr, ps

            Connection con = connection.connectDB();
            String sql = " begin ? := FILTERFORHOUSINGOFFICEUPDATE; end;";
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
            return null;
        }

    }

    public static StudentBean[] FilterForNoncafeRegistration() throws NullPointerException, ClassNotFoundException, SQLException {

        StudentBean[] s = null;
        Connection con = connection.connectDB();
        String sql = " begin ? := FILTERFORNONCAFE; end;";
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

    }

}
