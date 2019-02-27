/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clearance_management;

public class user {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String office;
    private String userRole;
    private String department;
    private int year;
    private String program;
    private String section;
    private int accountStatus;

    /**
     * @param status
     * @param department
     * @return the username
     */
    public user(int status, String username, String firstName, String lastName, String password, String office, String userRole,
            String department, int year, String program, String section) {
        
        this.accountStatus = status;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.department = department;
        this.year = year;
        this.office = office;
        this.userRole = userRole;
        this.section = section;
        this.program = program;

    }

    public user(int status, String username, String firstName, String lastName, String password, String office, String userRole) {

    }

    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {

        this.password = password;
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

    user login(String username, String password) {

        // validating code 
        return null;
    }

    void logout(user u) {

    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the program
     */
    public String getProgram() {
        return program;
    }

    /**
     * @param program the program to set
     */
    public void setProgram(String program) {
        this.program = program;
    }

    /**
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the accountStatus
     */
    public int AccountStatus() {
        return getAccountStatus();
    }

    /**
     * @return the accountStatus
     */
    public int getAccountStatus() {
        return accountStatus;
    }

    /**
     * @param accountStatus the accountStatus to set
     */
    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

}
