package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	
	
	
	public TestBase(){
		
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("E:\\myselenium\\DataDrivenApproachLoginTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public static void intialization() {
	
	String browsername=prop.getProperty("browser");
	
	if(browsername.equals("chrome")){
		
	  System.setProperty("webdriver.chrome.driver","E:\\Selenium softwares\\chromedriver.exe");
	  driver=new ChromeDriver();
		
	}
	else if(browsername.equals("firefox")) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SAI\\Desktop\\mindq practice\\webdriverbrowsers\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get(prop.getProperty("URL"));
	
}
	
	
}
