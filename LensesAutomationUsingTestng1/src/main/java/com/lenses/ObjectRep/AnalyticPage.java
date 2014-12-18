package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnalyticPage {

	private WebDriver driver;
	
	public AnalyticPage(WebDriver driver){
		this.driver = driver;	
	}

	@FindBy(xpath="//a[contains(text(),'Analytics')]")
	public WebElement analyticsTab;
	
	@FindBy(xpath="//a[@id='HeaderMenu_linkanalytics' or text()='Analytics']")
	public WebElement analyticsBtn;
	
	@FindBy(xpath="//select[@id='ContentPlaceHolder1_ContentPlaceHolder1_ddlAppInstanceId']")
	public WebElement sessionList;
	
	@FindBy(xpath="//a[@class='smallLink' or text()='Session Access Settings']")
	public WebElement sessionAccessSetting;
	
	@FindBy(xpath="//p[contains(text(),'Add Non-Participant(s)')]")
	public WebElement addNonParticipant;
	
	@FindBy(xpath="//input[@id='txtusername']")
	public WebElement userNameTxt;
	
	@FindBy(xpath="//a[contains(text(),'add')]")
	public WebElement addBtn;
	
	//dash board web elements
	@FindBy(xpath="//div[@class='circleYellow']")//h2[contains(text(),'9Lenses Dashboard')]
	public WebElement marketCircle;
	
	@FindBy(xpath="//h2[contains(text(),'9Lenses Dashboard')]")
	public WebElement analyticDashBoard;

}
