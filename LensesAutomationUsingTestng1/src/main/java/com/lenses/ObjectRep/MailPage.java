package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage {

	
	private WebDriver driver;
	
	public MailPage(WebDriver driver){
		this.driver = driver;	
	}
	
	public String emailTxtXpath="//input[@id='Email']";
	@FindBy(xpath="//input[@id='Email']")
	public WebElement emailTxt;
	
	public String passWdTxtXpath="//input[@id='Passwd']";
	@FindBy(xpath="//input[@id='Passwd']")
	public WebElement passWdTxt;
	
	public String signInBtnXpath="//input[@id='signIn']";
	@FindBy(xpath="//input[@id='signIn']")
	public WebElement signInBtn;
	
	@FindBy(xpath="//a[@target='_blank']//span[contains(text(),'Begin the App ')]")
	public WebElement beginTheAppBtn;
	
	/*@FindBy(xpath="//a[contains(@href,'StartAppSession') and span[text()='Begin the App ']]")
	public WebElement beginTheAppBtn;*/
	
	@FindBy(xpath="//span[@title='Tue, Jul 29, 2014 at 3:30 PM']")
	public WebElement clickmail;
	
	@FindBy(xpath="//a[@href='mailto:venkatesh.anavekar@9lenses.com']")
	public WebElement supportMailEmailId;
	
	@FindBy(xpath="//span[contains(text(),'Auto Test Invi Subj2014-09-25 08:23:46')]")
	public WebElement clickInvite;
	
	@FindBy(xpath="//a[text()='Click here to get started!' or text()='Click here to get started']")
	public WebElement clickHereToGetStartedLnk;
	
	public String dotImgXpath="//div[@aria-label='Show trimmed content']"; 
	@FindBy(xpath="//div[@aria-label='Show trimmed content']")
	public WebElement dotImg;
	
	
}
