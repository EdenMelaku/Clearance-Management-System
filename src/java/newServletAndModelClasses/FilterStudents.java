package newServletAndModelClasses;

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
import otherService.outputobj;

public class FilterStudents {

    public static StudentBean[] toDeactivate() throws NullPointerException, ClassNotFoundException, SQLException {

        StudentBean activeID[] = null;

        Connection conn = connection.connectDB();
        String sqll = "begin ? := GETACTIVESTUDENTLIST; end;";

        OracleCallableStatement stmt = (OracleCallableStatement) conn.prepareCall(sqll);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);

        int count = 0;
        String[] values = (String[]) sa.getArray();

        for (int i = 0; i < sa.length(); i++) {
            if (i > 0 && values[i].matches(values[i - 1])) {
                continue;
            } else {
                values[count] = values[i];
                count++;

                StudentBean b = read.getStudent(values[i]);
                outputobj.sysout("row   " + i + "  =" + b.getFirstName() + "  " + b.getLastname());
            }
        }
        
        activeID = new StudentBean[count + 1];
        for (int j = 0; j < count; j++) {
            activeID[j] = read.getStudent(values[j]);
            outputobj.sysout(activeID[j].getFirstName() + "  " + activeID[j].getLastname());

        }
        conn.close();
        return activeID;

    }

    public static void main(String... args) {
        try {
          //  System.out.println("to activate  ");
           // FilterStudents.toActivate();
            System.out.println("to deactivate ");
            FilterStudents.toDeactivate();
        } catch (NullPointerException ex) {
            System.out.println("null pointer ");

        } catch (ClassNotFoundException ex) {
            System.out.println("class  ");
        } catch (SQLException ex) {
            System.out.println("sql  ");
        }
    }

    public static StudentBean[] toActivate() throws NullPointerException, ClassNotFoundException, SQLException {

        StudentBean deactiveID[] = null;

        Connection conn = connection.connectDB();
        String sqll = "begin ? := GETDEACTIVATEDLIST; end;";

        OracleCallableStatement stmt = (OracleCallableStatement) conn.prepareCall(sqll);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);

        int count = 0;
        String[] values = (String[]) sa.getArray();

        for (int i = 0; i < sa.length(); i++) {
            if (i > 0 && values[i].matches(values[i - 1])) {
                continue;
            } else {
                values[count] = values[i];
                count++;

                StudentBean b = read.getStudent(values[i]);
                outputobj.sysout("row   " + i + "  =" + b.getFirstName() + "  " + b.getLastname());
            }
        }
        deactiveID = new StudentBean[count + 1];
        for (int j = 0; j < count; j++) {
            deactiveID[j] = read.getStudent(values[j]);
            outputobj.sysout(deactiveID[j].getFirstName() + "  " + deactiveID[j].getLastname());

        }
        conn.close();
        return deactiveID;

    }

}
