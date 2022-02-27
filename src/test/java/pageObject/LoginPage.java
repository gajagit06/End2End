package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	By email=By.cssSelector("#user_email");
	By pwd=By.cssSelector("[type='password']");
	By go=By.name("commit");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	

	public WebElement Username()
	{
		return driver.findElement(email);
		
	}

	public WebElement password()
	{
		return driver.findElement(pwd);
		
	}

	public WebElement Login()
	{
		return driver.findElement(go);
		
	}

}

