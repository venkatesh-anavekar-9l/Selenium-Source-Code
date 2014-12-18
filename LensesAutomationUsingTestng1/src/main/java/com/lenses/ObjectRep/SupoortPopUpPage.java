package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupoortPopUpPage {
	
	private WebDriver driver;
	
	public SupoortPopUpPage(WebDriver driver){
		this.driver = driver;	
	}

	@FindBy(xpath="//input[@*='SupportName']")
	public WebElement enterNmeTxt;
	
	@FindBy(xpath="//input[@*='SupportPhone']")
	public WebElement supportPhoneNumTxt;
	
	@FindBy(xpath="//textarea[@*='SupportMessage']")
	public WebElement supportMessageTxt;
	
	@FindBy(xpath="//input[@*='file']")
	public WebElement browseFile;
	
	@FindBy(xpath="//a[text()='Send']")
	public WebElement sendLnk;
	
}
