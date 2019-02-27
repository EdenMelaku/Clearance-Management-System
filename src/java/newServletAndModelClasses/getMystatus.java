/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newServletAndModelClasses;

import clearance_management.StudentBean;
import clearance_management.clearance;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.read;
import otherService.StudentClearanceInfo;
import otherService.outputobj;

/**
 *
 * @author MEBA
 */
public class getMystatus {

    public static StudentClearanceInfo getmystatus(String id) throws NullPointerException, ClassNotFoundException, SQLException {

        StudentClearanceInfo sci = null;

        StudentBean b = read.getStudent(id);

        clearance c = read.getClearance(id);
        sci = new StudentClearanceInfo(b.getId(), b.getFirstName(), b.getLastname(), c.getReason(), c.getLibraryStatus(),
                c.getBookStoreStatus(), c.getSportMasterStatus(), c.getHousingOfficeStatus(), c.getStudentCaféStatus(),
                c.getFacultyStoreStatus(), c.getRegistrarStatus(), c.getAdvisorStatus(), c.getDepartmentHeadStatus(),
                c.getDeanOFRPGStatus(), c.getContinuingEducationBAStatus(), c.getContinuingEducationStatus(),
                c.getFinalStatus());
        outputobj.sysout("row     =" + sci.getFirstName() + "  " + sci.getLastName());
        outputobj.sysout("cafe status " + sci.getStudentCaféStatus() + " final status  " + sci.getFinalStatus());

        return sci;

    }

    public static void main(String... args) {

        StudentClearanceInfo sc;
        try {
            // sc = getmystatus("BDU0800023UR");
            read d = new read();
            StudentBean sb = d.getStudent("BDU0800023UR");
            clearance c = read.getClearance("BDU0800023UR");

            System.out.println(sb.getFirstName());

            System.out.println(c.getBookStoreStatus());

        } catch (NullPointerException ex) {
            Logger.getLogger(getMystatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getMystatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(getMystatus.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
