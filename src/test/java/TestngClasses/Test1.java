package TestngClasses;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void test1method()
	{
		PropertyConfigurator.configure("D:\\AndeSwathi\\EclipseWorkplace\\CucumberTraining\\src\\log4j.properties");
		Logger lg = Logger.getLogger("devpinoyLogger");
		lg.info("Testing Log4J Started");
		System.out.println("Test1");
		Assert.assertEquals(false, true);
		lg.info("Log4J closed");
	}

}
