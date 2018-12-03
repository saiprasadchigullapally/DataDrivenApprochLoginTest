package testngdata;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.util.Util;

public class LoginTest {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		
	System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium softwares\\\\chromedriver.exe ");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get("https://www.freecrm.com/");
	
		
	}
	
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object data[][]=Util.getTestData("logindetails");
		return data;
		
	}
	
	
	
	
	@Test(dataProvider="getLoginData")
	public void loginTest(String username,String password) {
		
		//Entering Userid and password
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Login Button
		driver.findElement(By.xpath("//input[@class='btn btn-small'and @value='Login']")).click();
		
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		
		driver.quit();
	}
	
	
}
