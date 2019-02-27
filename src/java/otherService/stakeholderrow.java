/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherService;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author MEBA
 */
public class stakeholderrow {
    
    private String id;
    private String approvedby;
    private Date approvalDate;
    private int  status;
    private int cs;
    
    
    public stakeholderrow( String id, String approvedby, Date approvalDate, int  status, int cs){
        
        this.id=id;
        this.approvalDate=approvalDate;
        this.approvedby=approvedby;
        this.cs=cs;
        this.status=status;
        
    }
    public stakeholderrow( String id, String approvedby, Date approvalDate, int  status){
        
        this.id=id;
        this.approvalDate=approvalDate;
        this.approvedby=approvedby;
        
        this.status=status;
        
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the approvedby
     */
    public String getApprovedby() {
        return approvedby;
    }

    /**
     * @param approvedby the approvedby to set
     */
    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    /**
     * @return the approvalDate
     */
    public Date getApprovalDate() {
        return approvalDate;
    }

    /**
     * @param approvalDate the approvalDate to set
     */
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the cs
     */
    public int getCs() {
        return cs;
    }

    /**
     * @param cs the cs to set
     */
    public void setCs(int cs) {
        this.cs = cs;
    }
    
    
    
    
    
}
