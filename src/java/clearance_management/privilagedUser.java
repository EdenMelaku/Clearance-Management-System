/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clearance_management;

/**
 *
 * @author Bit
 */
public class privilagedUser extends user {

      public privilagedUser(int status,String username, String firstName, String lastName, String password, String office, String userRole) {
        super(status,username, firstName, lastName, password, office, userRole);
    }


    
   void createAccount(String username, String password, String firstName, String lastName, String office){
        
    }
    
   void createAccount(String username, String password, String firstName, String lastName, String department, int year, String program, String section){
        
    }
   
   
   void manageAccount(user user){
       
       
       
   }
    
}
