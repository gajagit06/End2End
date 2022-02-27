package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class ValidateTitle extends Base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void intialize() throws IOException  {
		driver=initializerDriver();
		log.info("Driver is intialized");
		
	    driver.get(prop.getProperty("url"));
	    log.info("Navigate to Home Page");
	}
	@Test
	public void basePageNavigation() throws IOException
	{
		
	    LandingPage l = new LandingPage(driver);
	    Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
	    log.info("Successfully Validated text message");
	   
	    
	    
}
	 @AfterTest
		public void teardown() 
		    {
			
			driver.close();
	    }
}