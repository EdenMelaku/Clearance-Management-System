/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewPastData;

import clearance_management.clearance;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import model.connection;

/**
 *
 * @author MEBA
 */
public class readPastdata {

    public static clearance getclearanceInfo(long year, String SID) throws NullPointerException, ClassNotFoundException, SQLException {
        clearance c = null;

        Connection con = connection.connectDB();

        String sql = "{call GETPREVIOUSCELARANCEINFO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement cst = con.prepareCall(sql);
        cst.setString(1, SID);

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
        cst.setLong(18, year);

        cst.execute();
        c = new clearance(cst.getString(2), cst.getString(3),
                cst.getInt(4), cst.getInt(5), cst.getInt(6), cst.getInt(7), cst.getInt(8),
                 cst.getInt(9), cst.getInt(10),
                cst.getInt(11), cst.getInt(12), cst.getInt(13), cst.getInt(14),
                cst.getInt(15), cst.getInt(16), cst.getString(17));

        return c;

    }

}
