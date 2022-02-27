package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void intialize() throws IOException  {
		driver=initializerDriver();
		
	    
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String user,String Passwd,String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
	    LandingPage l = new LandingPage(driver);
	    l.getLogin().click();
	    LoginPage lp=new LoginPage(driver);
	    lp.Username().sendKeys(user);
	    lp.password().sendKeys(Passwd);
	    log.info(text);
	    lp.Login().click();
	        
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456789";
		data[0][2]="NON-Restricted Data";
		//1th Row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="234567890";
		data[1][2]="Restricted Data";
		System.out.println(data);
		return data;
		
	}
	@AfterTest
	public void teardown() 
	    {
		
		driver.close();
    }

}
