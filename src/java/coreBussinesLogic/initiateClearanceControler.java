package coreBussinesLogic;

import clearance_management.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.*;
import model.getStatusFromAll;
import newServletAndModelClasses.finalApprove;
import otherService.calculation;
import otherService.outputobj;

public class initiateClearanceControler {

    public static clearance getClearance(String StudID, String reason, String username) throws NullPointerException, ClassNotFoundException, SQLException {
        outputobj.joption("im at the get clearance method  " + StudID);

        StudentBean s = read.getStudent(StudID);
        outputobj.joption("i found the student the name is " + s.getFirstName());
        int[] values = read.getStakeHolders(s.getProgram());
        user u = read.getAUser(username);
        outputobj.joption(" got stakeholder vaalues");
        outputobj.joption("the values are ------------");

        for (int i = 0; i < values.length; i++) {
            outputobj.joption("" + values[i]);

        }
        outputobj.joption("the values are ------------");
        int[] status = new int[12];
        for (int i = 0; i < 12; i++) {
            if (values[i] != -1 && i != 1) {
                outputobj.joption("at get status for i= " + i);
                status[i] = getStatus(i, StudID, u);
                outputobj.joption("the value  = " + status[i]);
            } else {
                status[i] = -1;
                status[1] = status[0];
            }

        }
        outputobj.joption("the status are ------------");
        for (int i = 0; i < status.length; i++) {

            outputobj.joption("" + status[i]);

        }
        outputobj.joption("the status are ------------");
        clearance c = new clearance(StudID, reason, status[0], status[1], status[2], status[3],
                status[4], status[5], status[6], status[7], status[8],
                status[9], status[10], status[11], 4, username);
        outputobj.sysout(c.getAdvisorStatus() + "    is advisor status ");
        outputobj.sysout(c.getFinalStatus() + "    is final status ");

        c.setFinalStatus(calculation.getFinalStatus(c));

        //JOptionPane.showMessageDialog(null, "the  final status is ------------" + c.getFinalStatus());
        return c;

    }

    public static int getStatus(int i, String id, user u) throws NullPointerException, ClassNotFoundException, SQLException {
        String[] stakeholders = {"library", "BookStore", "SportMaster", "HousingOffice", "StudentCafe", "FacultyStore",
            "Registrar", "Advisor", "DepartmentHead", "DeanOFRPG", "ContinuingEducationBA", "ContinuingEducation"};
        int status = 1;

        // 0-  fully clear,  1- clear,    2- not clear ,   3- deactivated
        if (i == 0) {

            status = getStatusFromAll.getLibraryStatus(id);
            outputobj.joption("library status = " + status);
            if (status == 1) {
                finalApprove.finalLibraryStatus(id, u, 1);
                outputobj.joption("final library status sucessfuly set ");
                finalApprove.finalBookStoreStatus(id, u, 1);
                outputobj.joption("final book store  status sucessfuly set ");
                status = 0;
            }

        } else if (i == 2) {
            status = getStatusFromAll.getSportMasterStatus(id);
            if (status == 1) {
                finalApprove.finalSportMasterStatus(id, u, 1);
                status = 0;
            }

        } else if (i == 3) {

            status = getStatusFromAll.gethousingOfficeStatus(id);
            outputobj.sysout("housing office status =" + status);
            if (status == 1) {
                finalApprove.finalhousingOfficeStatus(id, u, 1);
                status = 0;
            }

        } else if (i == 4) {
            status = getStatusFromAll.getCafeStatus(id);

            if (status == 1) {
                finalApprove.finalCafeStatus(id, u, 1);
                status = 0;
            }

        } else if (i == 5) {

            status = getStatusFromAll.getFacultyStoreStatus(id);
            if (status == 1) {
                finalApprove.finalFacultyStoreStatus(id, u, 1);
                status = 0;
            }

        } else if (i == 6) {

            status = getStatusFromAll.getRegistrarStatus(id);

        } else if (i == 7) {
            status = getStatusFromAll.getAdvisorStatus(id);
        } else if (i == 8) {
            status = getStatusFromAll.getDepartmentHeadStatus(id);
        } else if (i == 9) {
            status = getStatusFromAll.getDeanOFRPGStatus(id);

        } else if (i == 10) {

            status = getStatusFromAll.getContinuingEducationBAStatus(id);
        } else {

            status = getStatusFromAll.getContinuingEducationStatus(id);

        }

        return status;
    }

    public static int ClearAstudent(String StudID, String reason, String username) throws NullPointerException, ClassNotFoundException, SQLException {

        String u = username;

        clearance c = getClearance(StudID, reason, u);
        
        outputobj.joption("clearance   " + c.getSID() + "  " + c.getInitiator() + " " + c.getReason() + " " + c.getLibraryStatus());
        if (update.AddClearance(c) == 1) {
            return 1;
        } else {
            return 0;
        }

    }

    public static void main(String... str)  {
        try {
            System.out.println(calculation.getFinalStatus(read.getClearance("oo6")));
        } catch (NullPointerException ex) {
           ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        } catch (SQLException ex) {
          ex.printStackTrace();

        }
    }
}
