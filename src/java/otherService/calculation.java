/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherService;

import clearance_management.clearance;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane; 
import model.read;

/**
 *
 * @author MEBA
 */
public class calculation {
    
    public static int getFinalStatus(clearance c){
        
        int fin=0;
        int [] values=new int[12];
        int j=0;
        
        
//        outputobj.joption( "the student id number = " + c.getSID());
//        outputobj.joption( "the clearance initiator = " + c.getInitiator());
//        outputobj.joption( "the reason = " + c.getReason());
//        outputobj.joption( "the library status " + c.getLibraryStatus());
//        outputobj.joption( "the bookstore status  " + c.getBookStoreStatus());
//        outputobj.joption( "the housing office status " + c.getHousingOfficeStatus());
//        outputobj.joption( "the sport master status  = " + c.getSportMasterStatus());
//        outputobj.joption( "the students cafe status = " + c.getStudentCaféStatus());
//        outputobj.joption( "the advisor status " + c.getAdvisorStatus());
//        outputobj.joption( "the department head status  = " + c.getDepartmentHeadStatus());
//        outputobj.joption( "the faculty store status " + c.getFacultyStoreStatus());
//        outputobj.joption( "the registrar status  = " + c.getRegistrarStatus());
//        outputobj.joption( "the dean of ............. status = " + c.getDeanOFRPGStatus());
//        outputobj.joption( "the continung eduacation  status " + c.getContinuingEducationStatus());
//        outputobj.joption( "the continuing education business affair  status  = " + c.getContinuingEducationBAStatus());
//                
        if(c.getAdvisorStatus()!=-1){
            values[j]=c.getAdvisorStatus();
            j++;
        }
         if(c.getBookStoreStatus()!=-1){
            values[j]=c.getBookStoreStatus();
            j++;
        }
          if(c.getContinuingEducationBAStatus()!=-1){
            values[j]=c.getContinuingEducationBAStatus();
            j++;
        }
           if(c.getContinuingEducationStatus()!=-1){
            values[j]=c.getContinuingEducationStatus();
            j++;
        }
           
         if(c.getDeanOFRPGStatus()!=-1){
            values[j]=c.getDeanOFRPGStatus();
            j++;
        }
         
         if(c.getDepartmentHeadStatus()!=-1){
            values[j]=c.getDepartmentHeadStatus();
            j++;
        }
        
        if(c.getFacultyStoreStatus()!=-1){
            values[j]=c.getFacultyStoreStatus();
            j++;
        }
        
         if(c.getHousingOfficeStatus()!=-1){
            values[j]=c.getHousingOfficeStatus();
            j++;
        }
           if(c.getLibraryStatus()!=-1){
            values[j]=c.getLibraryStatus();
            j++;
        }
           if(c.getRegistrarStatus()!=-1){
            values[j]=c.getRegistrarStatus();
            j++;
        }
          if(c.getSportMasterStatus()!=-1){
            values[j]=c.getSportMasterStatus();
            j++;
        }
             if(c.getStudentCaféStatus()!=-1){
            values[j]=c.getStudentCaféStatus();
            j++;
        }
             int finalStatus=0;
           
        for (int i=0;i<values.length;i++){
            //System.out.println(values[i]);
            if(values[i]!=0){
             finalStatus=finalStatus+1;

            }
            else{
            finalStatus=finalStatus+values[i];
            
        }
                 //   System.out.println("final status =  "+finalStatus);

        if(finalStatus>3){
             fin=4;
        }
        else {
           fin=finalStatus;

        }
        
    }
                return fin;

    }
    
    public static void main(String ... args){
        try {
            System.out.println (calculation.getFinalStatus(read.getClearance("BDU0800023UR")));
        } catch (Exception ex) {
      ex.printStackTrace();

        }
    }
}
    
    
    
    
    

