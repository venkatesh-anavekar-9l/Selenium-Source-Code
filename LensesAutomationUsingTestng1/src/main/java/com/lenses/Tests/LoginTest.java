package com.lenses.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.lenses.HelpeClass.HelperMethods;
import com.lenses.ObjectRep.LoginPage;
import com.lenses.ObjectRep.NewSessionPage;

public class LoginTest {
	WebDriver driver;
	WebDriverWait wait;
	LoginPage loginPage;
	NewSessionPage newSessionPage;
	HelperMethods helperMethods = null;
	@BeforeClass(groups="funcTest")
	public void setup(){
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		helperMethods=PageFactory.initElements(driver, HelperMethods.class);
	
		newSessionPage=PageFactory.initElements(driver, NewSessionPage.class);
	}
	
	//@Test(groups="lenfuncTest")
	public void loginTest()
	{
		/*loginPage.usrNameTxt.sendKeys("jeevan.borale@9lenses.com");
		loginPage.pswdTxt.sendKeys("Automation@1234");
		loginPage.loginBtn.click();*/
		helperMethods.loginAsValidUser("https://206.164.173.83/Login.aspx", "venkatesh.anavekar@9lenses.com","Anavekar_560");
		helperMethods.getScreenShot("snap1");
		wait.until(ExpectedConditions.visibilityOf(newSessionPage.newSessionTab));
		//assertEquals("","");
		Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
		helperMethods.getScreenShot("snap2");
	}
	
	@AfterMethod(groups="funcTest")
	public void tearDown()
	{
		driver.quit();;
	}

}
