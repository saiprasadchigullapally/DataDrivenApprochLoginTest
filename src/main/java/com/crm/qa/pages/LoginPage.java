package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	//The main important of this individual pages is to define each individual element
	// Locate element and methods for validation
	// Check the functionalites
	
	
	
	//Define Pagefactory or Object Repository (OR) or webelements
	
	@FindBy(xpath="//img[@class='img-responsive' and @alt='free crm logo']")
	WebElement crmlogo;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small'and@value='Login']")
	WebElement submitbuton;
	
	
	//To intiallize the WebElements/PageObjcts we  need to create constructor
	
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	// Functionalites of login page
	
	public  String validateLoginPageTitle(){
		
		return driver.getTitle();
		
		
	}
	
	public  boolean validateCRMImage(){
		
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pd) {
		
		username.sendKeys(un);
		password.sendKeys(pd );
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitbuton.click();
		
		return new HomePage();
		
		
		
	}
	
	
	
}
