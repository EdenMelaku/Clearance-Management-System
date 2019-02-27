/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clearance_management.StudentBean;
import clearance_management.clearance;
import clearance_management.user;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.ARRAY;
import otherService.StudentClearanceInfo;
import otherService.outputobj;

/**
 *
 * @author Bit
 */
public class utility {

    public static StudentBean[] getUninitiated(String username) throws NullPointerException, ClassNotFoundException, SQLException {
        StudentBean[] uninitiated1 = new StudentBean[10000];
        Connection con = connection.connectDB();
        StudentBean[] uninitiated = null;
        user u = read.getAUser(username);
        String sqll = "begin ? := getuninitiated(?,?,?,?); end;";

        OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sqll);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.setString(3, u.getProgram());
        stmt.setString(2, u.getDepartment());
        stmt.setString(5, u.getSection());
        stmt.setInt(4, u.getYear());

        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);
        System.out.println("array of type " + sa.getBaseTypeName());
        System.out.println("array of length " + sa.length());

        String[] values = (String[]) sa.getArray();
        int i = 0;
        for (i = 0; i < sa.length(); i++) {
            uninitiated1[i] = read.getStudent(values[i]);
            outputobj.sysout("row   " + i + "  =" + uninitiated1[i].getFirstName() + "  " + uninitiated1[i].getLastname());
        }

        uninitiated = new StudentBean[i];

        for (int j = 0; j < i; j++) {
            uninitiated[j] = uninitiated1[j];

        }
        con.close();
        return uninitiated;

    }

    public static StudentClearanceInfo[] getInitiatedInfo(String initiator) throws NullPointerException, ClassNotFoundException, SQLException {

        StudentClearanceInfo[] sci = null;

        StudentClearanceInfo[] s = new StudentClearanceInfo[10000];
        Connection con = connection.connectDB();

        String sqll = "begin ? := GETINITIATEDINFOF(?); end;";

        OracleCallableStatement stmt = (OracleCallableStatement) con.prepareCall(sqll);
        stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
        stmt.setString(2, initiator);

        stmt.executeUpdate();
        ARRAY sa = stmt.getARRAY(1);

        String[] values = (String[]) sa.getArray();
        int i = 0;

        for (i = 0; i < sa.length(); i++) {
            StudentBean b = read.getStudent(values[i]);
            clearance c = read.getClearance(values[i]);
            s[i] = new StudentClearanceInfo(b.getId(), b.getFirstName(), b.getLastname(), c.getReason(), c.getLibraryStatus(),
                    c.getBookStoreStatus(), c.getSportMasterStatus(), c.getHousingOfficeStatus(), c.getStudentCaféStatus(),
                    c.getFacultyStoreStatus(), c.getRegistrarStatus(), c.getAdvisorStatus(), c.getDepartmentHeadStatus(),
                    c.getDeanOFRPGStatus(), c.getContinuingEducationBAStatus(), c.getContinuingEducationStatus(),
                    c.getFinalStatus());
            outputobj.sysout("row   " + i + "  =" + s[i].getFirstName() + "  " + s[i].getLastName());
            outputobj.sysout("cafe status " + s[i].getStudentCaféStatus() + " final status  " + s[i].getFinalStatus());
        }

        sci = new StudentClearanceInfo[i];

        for (int j = 0; j < i; j++) {
            sci[j] = s[j];
        }
        con.close();
        return sci;
    }

    public static void main(String... str) throws NullPointerException, ClassNotFoundException, SQLException {
StudentClearanceInfo []s=getInitiatedInfo("hiwot@gmail.com");
        /*utility u = new utility();
        utility.getUninitiated("biniam@gmail.com");
*/
        System.out.println(s.length);
        
    }

    public int deactivateAccount(String pu, String mu) throws NullPointerException, ClassNotFoundException, SQLException {
        if (validation.isEligibleToPerformAction(pu, mu)) {
            if (update.updateAccountStatusD(pu) == 1) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    public int activateAccount(String pu, String mu) throws NullPointerException, ClassNotFoundException, SQLException {
        if (validation.isEligibleToPerformAction(pu, mu)) {
            if (update.updateAccountStatusA(pu) == 1) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }
}
