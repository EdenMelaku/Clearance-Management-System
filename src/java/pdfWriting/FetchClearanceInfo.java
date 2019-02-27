/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfWriting;

import clearance_management.StudentBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.connection;
import model.read;
import newServletAndModelClasses.officeStatusFiltration;
import otherService.stakeholderrow;

/**
 *
 * @author MEBA
 */
public class FetchClearanceInfo {

   

    public static ApprovalInfo getrow(String id, int i) throws NullPointerException, ClassNotFoundException, SQLException {
        String query;
        stakeholderrow sr = null;

        String[] stakeholders = {"library", "book store", "sport master", "housing office", "student cafe", "faculty store",
            "registrar", "advisor", "department head", "dean of post graduate and research", "continuing education business affair", "continuing education"};

        String office = stakeholders[i];

        ApprovalInfo output = null;
        if (i == 7) {

            query = "{CALL READADVISOR(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();

            //String sid,  String status, LocalDate approvalDate, String approver, String office
            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }
        } else if (i == 11) {

            query = "{CALL READCONTED(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();

            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }
        } else if (i == 10) {

            query = "{CALL READCONTEDBA(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();

            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }

        } else if (i == 9) {

            query = "{CALL READDEANOFRPG(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();
            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }

        } else if (i == 8) {

            query = "{CALL READDEPHEAD(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();
            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }

        } else if (i == 5) {

            query = "{CALL READFACULTYSTORE(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();

            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }

        } else if (i == 3) {

            query = "{CALL READHOUSINGOFFICE(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();
            System.out.println(cst.getDate(4));
            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }
        } else if (i == 0 || i == 1) {

            query = "{CALL READLIBRARY(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();
            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }

        } else if (i == 6) {

            query = "{CALL READREGISTRAR(?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();

            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }
        } else if (i == 2) {

            query = "{CALL READSPORTMASTER (?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.execute();

            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }

        } else {

            query = "{CALL READSTUDENTSCAFE (?,?,?,?,?)}";
            Connection con = connection.connectDB();

            CallableStatement cst = con.prepareCall(query);
            cst.setString(1, id);

            cst.registerOutParameter(2, java.sql.Types.NUMERIC);// status
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);// spprovedby
            cst.registerOutParameter(4, java.sql.Types.DATE);//approval date 
            cst.registerOutParameter(5, java.sql.Types.NUMERIC);//cafe status

            cst.execute();
            if (cst.getDate(4) != null) {
                sr = new stakeholderrow(id, cst.getString(3), cst.getDate(4), cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), sr.getApprovalDate(), read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);
            } else {
                sr = new stakeholderrow(id, cst.getString(3), null, cst.getInt(2));
                output = new ApprovalInfo(id, String.valueOf(sr.getStatus()), null, read.getAUser(sr.getApprovedby()).getFirstName() + "  " + read.getAUser(sr.getApprovedby()).getLastName(), office);

            }

        }

        return output;

    }

    public static ApprovalInfo[] fetchAll(String id) throws NullPointerException, ClassNotFoundException, SQLException {

        int size = 0;
        ApprovalInfo info[] = null;
        int values[] = new int[12];
        int v[] = null;
        String prog = read.getStudent(id).getProgram();
        int stakeholders[] = read.getStakeHolders(prog);
        for (int i = 0; i < 12; i++) {
            if (stakeholders[i] != -1) {

                values[size] = i;
                size++;
            }
        }
        v = new int[size];
        for (int j = 0; j < size; j++) {
            v[j] = values[j];
        }
        info = new ApprovalInfo[size];
        for (int i = 0; i < size; i++) {
            info[i] = FetchClearanceInfo.getrow(id, v[i]);
        }

        return info;
    }

}
