
package clearance_management;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Other {
      public static int currentYear() {//this is to write current date to file 
        GregorianCalendar gc = new GregorianCalendar();

        int year = gc.get(Calendar.YEAR);

        return year;
    }
}
