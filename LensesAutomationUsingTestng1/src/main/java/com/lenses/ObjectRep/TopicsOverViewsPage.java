package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopicsOverViewsPage {
	
private WebDriver driver;
	
	public TopicsOverViewsPage(WebDriver driver){
		this.driver = driver;	
	}
	
	//@FindBy(xpath="//a[@id='ContentPlaceHolder1_ahrefStartGivingResponses']")
	//public WebElement startGivingResponsesBtn;
	
	@FindBy(xpath="//a[contains(text(),'Start Giving Responses')]")
	public WebElement startGivingResponsesBtn;
	
	

}
