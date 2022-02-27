package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
public WebDriver driver;
public Properties prop;
	
	
	public WebDriver initializerDriver() throws IOException
	{
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\gowri\\E2E\\End2End\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		//String urlname=prop.getProperty("url");
		System.out.println(prop.getProperty("url"));
		 
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\gowri\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			//firefoxDriver
			
		}
		else if(browsername.equals("IE"))
		{
			//IE CODE
		}
		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenshotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
	
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}
	
	
}
