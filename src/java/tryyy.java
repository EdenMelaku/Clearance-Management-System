
import clearance_management.StudentBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import static java.sql.JDBCType.ARRAY;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.ARRAY;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.lang.model.type.TypeKind.ARRAY;
import model.connection;
import oracle.jdbc.OracleCallableStatement;
import static oracle.jdbc.OracleTypes.ARRAY;
import oracle.jdbc.internal.OracleTypes;
import oracle.sql.*;
import java.sql.*;
import model.read;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MEBA
 */
public class tryyy {
    
    public static void main (String ... br){
        
        
        
    Connection con=connection.connectDB();
    String sql="{CALL  TRYCURSOR(?)}";
    
//        try {
//            CallableStatement cs=con.prepareCall(sql);
//            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
//            cs.execute();
//           //cs.get
//             System.out.println(cs.getString(1));
//         boolean res=cs.execute();
//         while (!res && cs.getUpdateCount() !=-1){
//             System.out.println(cs.getString(1));
//             ResultSet rs=  cs.getResultSet();
//             
//             
//             boolean b =cs.getMoreResults();
//             while(rs.next()){
//             System.out.println("the student name   ");
//             }
//             rs.close();
//             res=cs.getMoreResults();
//         }
//         
//            System.out.println("sucessfuly executed the callable statement ");
//        } catch (SQLException ex) {
//
//         System.out.println(ex);
//        }
    
    Connection conn=connection.connectDB();
    String sqll="begin ? := tct; end;";
        try {
            OracleCallableStatement stmt=(OracleCallableStatement) conn.prepareCall(sqll);
            stmt.registerOutParameter(1, OracleTypes.ARRAY, "TYPP");
            stmt.executeUpdate();
           ARRAY sa=stmt.getARRAY(1);
           System.out.println("array of type "+ sa.getBaseTypeName());
           System.out.println("array of length "+ sa.length());
           
           
           String [] values=(String[])sa.getArray();
           
           for(int i=0;i<sa.length();i++){
               StudentBean b=read.getStudent(values[i]);
           System.out.println("row   "+ i + "  ="+b.getFirstName()+"  "+b.getLastname());
           }
        } catch (SQLException ex) {
        
          ex.printStackTrace();
        } catch (NullPointerException ex) {
            Logger.getLogger(tryyy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tryyy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
        
    }
    
}
