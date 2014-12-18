package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateLoginInfoPage {
	
	private WebDriver driver;
	
	public CreateLoginInfoPage(WebDriver driver){
		this.driver = driver;	
	}

	@FindBy(xpath="//input[@id='ContentPlaceHolder1_mainPass']")
	public WebElement passWrdTxt;
	
	@FindBy(xpath="//input[@id='fake_pwdConf']")
	public WebElement confirmPassWrdTxt;
	
	@FindBy(xpath="(//div[contains(@class,'jcf-unselectable chk-area')])[position()=2]")
	public WebElement termsAndConditionChk;
	
	@FindBy(xpath="//input[@value='Submit']")
	public WebElement submitBtn;
	


}
