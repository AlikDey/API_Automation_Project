package Utility;

import org.apache.log4j.Logger;

public class RestFWLogger {
	
	//Initialize Log4j logs
	private static Logger log = Logger.getLogger(RestFWLogger.class.getName());
	
	public static void startCase(String sTestCaseName) {
		log.info("===================================================================");
		log.info("===================================================================");
		log.info("--------------------     "+sTestCaseName+"     --------------------");
		log.info("===================================================================");
		log.info("===================================================================");
	}
	
	public static void endCase() {
		log.info("==========================     --E--N--D--    =====================");
		log.info("-------------------------------------------------------------------");
		log.info("*******************************************************************");
	}
	
	public static void info(String msg) {
		log.info(msg);
	}
	
	public static void warn(String msg) {
		log.warn(msg);
	}
	
	public static void error(String msg) {
		log.error(msg);
	}
	
	public static void fatal(String msg) {
		log.fatal(msg);
	}
	
	public static void debug(String msg) {
		log.debug(msg);
	}

}
