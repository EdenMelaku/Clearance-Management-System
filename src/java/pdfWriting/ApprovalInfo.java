package pdfWriting;

import java.time.LocalDate;
import java.util.Date;

public class ApprovalInfo {
    
    private String office;
    private String sid;
    private String status;
    private Date approvalDate;
    private String approver;

    
    
    public ApprovalInfo(String sid,  String status, Date approvalDate, String approver, String office){
       this.approvalDate=approvalDate;
       this.approver=approver;
       this.sid=sid;
       this.status=status;
       this.office=office;
    }
    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @return the approver
     */
    public String getApprover() {
        return approver;
    }

    /**
     * @param approver the approver to set
     */
    public void setApprover(String approver) {
        this.approver = approver;
    }

    /**
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(String office) {
        this.office = office;
    }
    
}
