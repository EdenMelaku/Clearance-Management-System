/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newServletAndModelClasses;

import clearance_management.StudentBean;
import clearance_management.clearance;
import java.sql.Connection;
import java.sql.SQLException;
import model.connection;
import model.read;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import otherService.StudentClearanceInfo;

/**
 *
 * @author MEBA
 */
public class GetAllStudentsClearanceInfo {

    public static String[] getAllStudents() throws NullPointerException, ClassNotFoundException, SQLException {

        String activeID[] = null;

        Connection conn = connection.connectDB();
        String sqll = "begin ? := GETACTIVESTUDENTLIST; end;";

        OracleCallableStatement stmt = (OracleCallableStatement) conn.prepareCall(sqll);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);

        int count = 0;
        activeID = (String[]) sa.getArray();
        conn.close();
        return activeID;

    }

    public static StudentClearanceInfo[] GetClearanceinfo() throws NullPointerException, ClassNotFoundException, SQLException {
        String studs[] = GetAllStudentsClearanceInfo.getAllStudents();
        StudentClearanceInfo studentInfo[] = new StudentClearanceInfo[studs.length];

        for (int i = 0; i < studs.length; i++) {

            StudentBean b = read.getStudent(studs[i]);

            clearance c = read.getClearance(studs[i]);
            studentInfo[i] = new StudentClearanceInfo(b.getId(), b.getFirstName(), b.getLastname(), c.getReason(), c.getLibraryStatus(),
                    c.getBookStoreStatus(), c.getSportMasterStatus(), c.getHousingOfficeStatus(), c.getStudentCaféStatus(),
                    c.getFacultyStoreStatus(), c.getRegistrarStatus(), c.getAdvisorStatus(), c.getDepartmentHeadStatus(),
                    c.getDeanOFRPGStatus(), c.getContinuingEducationBAStatus(), c.getContinuingEducationStatus(),
                    c.getFinalStatus());
        }

        return studentInfo;
    }

}
