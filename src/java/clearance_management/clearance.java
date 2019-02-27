/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clearance_management;


public class clearance {

private String SID;
private String reason;
private int LibraryStatus;
private int BookStoreStatus;
private int SportMasterStatus; 
private int HousingOfficeStatus;
private int StudentCaféStatus;
private int FacultyStoreStatus;
private int RegistrarStatus;
private int AdvisorStatus;
private int DepartmentHeadStatus;
private int DeanOFRPGStatus;
private int ContinuingEducationBAStatus;
private int ContinuingEducationStatus;
private int finalStatus;
private String initiator;

    public clearance(String SID, String reason, int LibraryStatus, int BookStoreStatus, int SportMasterStatus,
            int HousingOfficeStatus, int StudentCaféStatus, int FacultyStoreStatus, int RegistrarStatus,
            int AdvisorStatus, int DepartmentHeadStatus,
            int DeanOFRPGStatus, int ContinuingEducationBAStatus, int ContinuingEducationStatus, int finalStatus, String initiator) {

    this.SID=SID;
    this.AdvisorStatus=AdvisorStatus;
    this.BookStoreStatus=BookStoreStatus;
    this.ContinuingEducationBAStatus=ContinuingEducationBAStatus;
    this.ContinuingEducationStatus=ContinuingEducationStatus;
    this.DeanOFRPGStatus=DeanOFRPGStatus;
    this.DepartmentHeadStatus=DepartmentHeadStatus;
    this.FacultyStoreStatus=FacultyStoreStatus;
    this.HousingOfficeStatus=HousingOfficeStatus;
    this.LibraryStatus=LibraryStatus;
    this.RegistrarStatus=RegistrarStatus;
    this.SportMasterStatus=SportMasterStatus;
    this.StudentCaféStatus=StudentCaféStatus;
    this.finalStatus=finalStatus;
    this.initiator=initiator;
    this.reason=reason;
    
    
    
    
    }

    /**
     * @return the SID
     */
    public String getSID() {
        return SID;
    }

    /**
     * @param SID the SID to set
     */
    public void setSID(String SID) {
        this.SID = SID;
    }

    /**
     * @return the LibraryStatus
     */
    public int getLibraryStatus() {
        return LibraryStatus;
    }

    /**
     * @param LibraryStatus the LibraryStatus to set
     */
    public void setLibraryStatus(int LibraryStatus) {
        this.LibraryStatus = LibraryStatus;
    }

    /**
     * @return the BookStoreStatus
     */
    public int getBookStoreStatus() {
        return BookStoreStatus;
    }

    /**
     * @param BookStoreStatus the BookStoreStatus to set
     */
    public void setBookStoreStatus(int BookStoreStatus) {
        this.BookStoreStatus = BookStoreStatus;
    }

    /**
     * @return the SportMasterStatus
     */
    public int getSportMasterStatus() {
        return SportMasterStatus;
    }

    /**
     * @param SportMasterStatus the SportMasterStatus to set
     */
    public void setSportMasterStatus(int SportMasterStatus) {
        this.SportMasterStatus = SportMasterStatus;
    }

    /**
     * @return the HousingOfficeStatus
     */
    public int getHousingOfficeStatus() {
        return HousingOfficeStatus;
    }

    /**
     * @param HousingOfficeStatus the HousingOfficeStatus to set
     */
    public void setHousingOfficeStatus(int HousingOfficeStatus) {
        this.HousingOfficeStatus = HousingOfficeStatus;
    }

    /**
     * @return the StudentCaféStatus
     */
    public int getStudentCaféStatus() {
        return StudentCaféStatus;
    }

    /**
     * @param StudentCaféStatus the StudentCaféStatus to set
     */
    public void setStudentCaféStatus(int StudentCaféStatus) {
        this.StudentCaféStatus = StudentCaféStatus;
    }

    /**
     * @return the FacultyStoreStatus
     */
    public int getFacultyStoreStatus() {
        return FacultyStoreStatus;
    }

    /**
     * @param FacultyStoreStatus the FacultyStoreStatus to set
     */
    public void setFacultyStoreStatus(int FacultyStoreStatus) {
        this.FacultyStoreStatus = FacultyStoreStatus;
    }

    /**
     * @return the RegistrarStatus
     */
    public int getRegistrarStatus() {
        return RegistrarStatus;
    }

    /**
     * @param RegistrarStatus the RegistrarStatus to set
     */
    public void setRegistrarStatus(int RegistrarStatus) {
        this.RegistrarStatus = RegistrarStatus;
    }

    /**
     * @return the AdvisorStatus
     */
    public int getAdvisorStatus() {
        return AdvisorStatus;
    }

    /**
     * @param AdvisorStatus the AdvisorStatus to set
     */
    public void setAdvisorStatus(int AdvisorStatus) {
        this.AdvisorStatus = AdvisorStatus;
    }

    /**
     * @return the DepartmentHeadStatus
     */
    public int getDepartmentHeadStatus() {
        return DepartmentHeadStatus;
    }

    /**
     * @param DepartmentHeadStatus the DepartmentHeadStatus to set
     */
    public void setDepartmentHeadStatus(int DepartmentHeadStatus) {
        this.DepartmentHeadStatus = DepartmentHeadStatus;
    }

    /**
     * @return the DeanOFRPGStatus
     */
    public int getDeanOFRPGStatus() {
        return DeanOFRPGStatus;
    }

    /**
     * @param DeanOFRPGStatus the DeanOFRPGStatus to set
     */
    public void setDeanOFRPGStatus(int DeanOFRPGStatus) {
        this.DeanOFRPGStatus = DeanOFRPGStatus;
    }

    /**
     * @return the ContinuingEducationBAStatus
     */
    public int getContinuingEducationBAStatus() {
        return ContinuingEducationBAStatus;
    }

    /**
     * @param ContinuingEducationBAStatus the ContinuingEducationBAStatus to set
     */
    public void setContinuingEducationBAStatus(int ContinuingEducationBAStatus) {
        this.ContinuingEducationBAStatus = ContinuingEducationBAStatus;
    }

    /**
     * @return the ContinuingEducationStatus
     */
    public int getContinuingEducationStatus() {
        return ContinuingEducationStatus;
    }

    /**
     * @param ContinuingEducationStatus the ContinuingEducationStatus to set
     */
    public void setContinuingEducationStatus(int ContinuingEducationStatus) {
        this.ContinuingEducationStatus = ContinuingEducationStatus;
    }

    /**
     * @return the finalStatus
     */
    public int getFinalStatus() {
        return finalStatus;
    }

    /**
     * @param finalStatus the finalStatus to set
     */
    public void setFinalStatus(int finalStatus) {
        this.finalStatus = finalStatus;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the initiator
     */
    public String getInitiator() {
        return initiator;
    }

    /**
     * @param initiator the initiator to set
     */
    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }


}
