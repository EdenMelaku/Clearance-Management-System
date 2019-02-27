
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import otherService.outputobj;

public class Test {
    
    
  public static void main( String ... args) throws NullPointerException, ClassNotFoundException, SQLException{
    

        
  
  
     CallableStatement cst=null;
        String id="ede@hotmail.com";
        String password="123";
        String fn;
        String ln;
        String o;
        String ur;
        String d;
        String s;
        int  y;
        String p;
        String as;
      
            Connection con=connection.connectDB();
            String sql="{CALL ty (?,?,?,?,?,?,?,?,?,?,?,?)}";
            cst = con.prepareCall(sql);
            cst.setString(1,id);
            cst.setString(2, password);
            cst.registerOutParameter(3,java.sql.Types.VARCHAR);
            cst.registerOutParameter(4,java.sql.Types.VARCHAR);
            cst.registerOutParameter(5,java.sql.Types.VARCHAR);
            cst.registerOutParameter(6,java.sql.Types.VARCHAR);
            cst.registerOutParameter(7,java.sql.Types.VARCHAR);
            cst.registerOutParameter(8,java.sql.Types.VARCHAR);
            cst.registerOutParameter(9,java.sql.Types.NUMERIC);
            cst.registerOutParameter(10,java.sql.Types.VARCHAR);
            cst.registerOutParameter(11,java.sql.Types.VARCHAR);
             cst.registerOutParameter(12,java.sql.Types.VARCHAR);
            cst.executeUpdate();
            
             fn = cst.getString(3);
             ln=cst.getString(4);
             o = cst.getString(5);
             ur=cst.getString(6);
             d = cst.getString(7);
             p=cst.getString(8);
             y = cst.getInt(9);
             s=cst.getString(10);
             as = cst.getString(11);
            outputobj.sysout("password is "+ cst.getString(12));
            
             outputobj.sysout(" username ="+ cst.getString(1));
       outputobj.sysout("name ="+ fn+" "+ln);
          outputobj.sysout("office ="+ o);
        outputobj.sysout("user role"+ ur);
       outputobj.sysout("department "+ d);
        outputobj.sysout("program "+ p);
        outputobj.sysout(" year " + y);
        outputobj.sysout("section "+ s);
        outputobj.sysout("account status "+ as);

            
            outputobj.sysout(" ");

            
            
        
        
    }
  
  
}
    
    
    
    

