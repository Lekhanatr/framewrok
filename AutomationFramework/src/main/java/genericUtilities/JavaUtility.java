package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This method consists of generic methods related to Java
 * @author swaroop
 */
public class JavaUtility {
	/**
	 * This method will capture the current system date in required format and return it to caller
	 * @return date
	 */
	public String getSystemDate() {
		Date d = new Date();
		//SimpleDateFormat formats the date into how user wants in a simplified way and return it as text 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = sdf.format(d);
		return date;
		
	}
	
	

}
