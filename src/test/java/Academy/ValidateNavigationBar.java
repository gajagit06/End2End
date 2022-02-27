package Academy;

import java.io.IOException;
import java.io.IOException.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class ValidateNavigationBar extends Base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
@BeforeTest
public void intialize() throws IOException  {
	driver=initializerDriver();
	
    driver.get(prop.getProperty("url"));
}
	@Test
	public void basePageNavigation () 
	{
		
	    LandingPage l = new LandingPage(driver);
	    Assert.assertTrue(l.getnavigateBar().isDisplayed());
	  //Assert.assertTrue(l.getnavigateBar().isDisplayed());
	    log.info("displayed successfully");
	//  Assert.assertFalse(false);
	} 
	    
	    @AfterTest
	public void teardown() 
	    {
		
		driver.close();
    }
	
}