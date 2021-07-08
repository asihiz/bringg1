
/**
 * General Utils
 * Performs util actions for test
 *
 * @author ASIH
 *
 */


package util.general_util;

import java.io.*;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class GeneralUtils {

	private static final Logger logger = Logger.getLogger(GeneralUtils.class);

	private GeneralUtils(){

	}

	public  static <T extends  Throwable> String stacktraceToString(T t){
		StringWriter errors = new StringWriter();
		t.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}

	public static <T extends Throwable> void reportError(String error , T t)  throws AssertionError{
		Assert.assertFalse(error + GeneralUtils.stacktraceToString(t), true);
	}

}
