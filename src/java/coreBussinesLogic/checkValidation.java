/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreBussinesLogic;

import java.sql.SQLException;
import model.read;

/**
 *
 * @author MEBA
 */
public class checkValidation {

    public static Boolean one(String sid) throws NullPointerException, ClassNotFoundException, SQLException {
        String pp = read.getStudent(sid).getProgram();
        if (pp.matches("ur") || pp.matches("us")) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean two(String sid) throws NullPointerException, ClassNotFoundException, SQLException {
        String pp = read.getStudent(sid).getProgram();
        if (pp.matches("ue")) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean three(String sid) throws NullPointerException, ClassNotFoundException, SQLException {
        String pp = read.getStudent(sid).getProgram();
        if (pp.matches("pr") || pp.matches("ps")) {
            return true;
        } else {
            return false;
        }
    }
}
