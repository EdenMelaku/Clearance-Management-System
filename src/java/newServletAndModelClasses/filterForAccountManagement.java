
package newServletAndModelClasses;

import java.sql.SQLException;
import model.read;
import otherService.AccountManagingInfo;


public class filterForAccountManagement {

    AccountManagingInfo af[] = null;
    AccountManagingInfo afo[] = new AccountManagingInfo[1000];

    public AccountManagingInfo[] filterForActivation(String username) throws NullPointerException, ClassNotFoundException, SQLException {

        af = read.getAccountManagingInfo(read.getAUser(username));

        for (int i = 0; i < af.length; i++) {
            if (af[i].getAccountStatus() == 0) {
                if (af[i].getUserRole().matches("advisor") || af[i].getUserRole().matches("department Head") || af[i].getUserRole().matches("privilaged_user")) {

                    afo[i] = af[i];
                }
            }

        }
        return afo;

    }

    public AccountManagingInfo[] filterForDeactivation(String username) throws NullPointerException, ClassNotFoundException, SQLException {

        af = read.getAccountManagingInfo(read.getAUser(username));

        for (int i = 0; i < af.length; i++) {
            if (af[i].getAccountStatus() == 1) {
                if (af[i].getUserRole().matches("advisor") || af[i].getUserRole().matches("department Head") || af[i].getUserRole().matches("privilaged_user")) {

                    afo[i] = af[i];
                }
            }

        }
        return afo;

    }

}
