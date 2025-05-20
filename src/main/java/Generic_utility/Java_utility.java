package Generic_utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**This is for java utility files
 * @author HP
 */
public class Java_utility {

	public static String systemdate()
	{
		Date d = new Date();
		SimpleDateFormat a = new SimpleDateFormat("dd-MMM-yyyy_hh-mm-ss");
		String dateformat = a.format(d);
		return dateformat;
	}
}
