package API_Automation;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Utility.RestFWLogger;

public class basicTestCase {
	
	@Test
	public void Rest_Test01() throws IOException {
		
		PropertyConfigurator.configure("log4j.properties");
		RestFWLogger.startCase("Rest_Test01");
		RestFWLogger.info("Creating Rest Assured Object");
		RestFWLogger.info("Excel sheet opened");
		RestFWLogger.info("New object initiated");
		RestFWLogger.info("URI of application launched");
		RestFWLogger.info("Log in successfull");
		RestFWLogger.info("Test case closed");
		RestFWLogger.endCase();
		
		
	}

}
