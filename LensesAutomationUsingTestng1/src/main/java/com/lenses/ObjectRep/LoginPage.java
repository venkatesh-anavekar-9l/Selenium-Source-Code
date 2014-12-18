package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;	
	}
	@FindBy(xpath="//h3[contains(text(),'Login')]")
	public WebElement loginTxt;
	
	@FindBy(xpath="//input[@id='txtEmail']")
	public WebElement usrNameTxt;	
	
	@FindBy(xpath="//input[@id='txtPassword']")
	public WebElement pswdTxt;	
	
	@FindBy(xpath="//a[@id='btnLogin']")
	public WebElement loginBtn;	
	
	@FindBy(xpath="//label[contains(text(),'Remember Me')]")
	public WebElement rememberMe;
	
	//@FindBy(xpath="//img[contains(@src,'www.9lenses.com') and @alt='9Lenses']")
	//public WebElement homePageLensesLogo;
	
	@FindBy(xpath="//h1[contains(text(),'The Organizational Intelligence Platform')]")
	public WebElement homePageOrganizationalIntelligencePlatform;
	
	@FindBy(xpath="//div[contains(text(),' You have already completed taking your Application session')]")
	public WebElement alreadySessionCompleted;
	
	@FindBy(xpath="//a[contains(text(),'Ok')]")
	public WebElement clickOk;

	
}
