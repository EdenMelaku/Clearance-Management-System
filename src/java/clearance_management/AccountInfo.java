/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clearance_management;

import java.util.Date;

/**
 *
 * @author Bit
 */
public class AccountInfo {

    private String userName;
    private String creator;
    private Date creationDate;
    private Date lastLogin;
    private long activity;

    public AccountInfo(String username, String creator,Date d,Date ll, long i) {
        this.userName=username;
        this.creator=creator;
        this.creationDate=d;
        this.lastLogin=ll;
        this.activity=i;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the lastLogin
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return the activity
     */
    public long getActivity() {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(long activity) {
        this.activity = activity;
    }

}
