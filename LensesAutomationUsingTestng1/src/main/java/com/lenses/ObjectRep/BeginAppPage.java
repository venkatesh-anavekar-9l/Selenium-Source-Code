package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeginAppPage {
	private WebDriver driver;
	
	public BeginAppPage(WebDriver driver){
		this.driver = driver;	
	}
	
	//@FindBy(xpath="//a[@id='ContentPlaceHolder1_ahrefStartInterview']")
	//@FindBy(xpath="//a[contains(text(),'Start Interview')]")
	@FindBy(xpath="//a[contains(text(),'Begin the Interview')]")
	public WebElement startInterviewBtn;
	
	@FindBy(xpath="//a[contains(text(),'Continue the Interview')]")
	public WebElement continueInterviewBtn;
	
	@FindBy(xpath="//h2[contains(text(),'You are beginning a software interview')]")
	public WebElement softwareInterviewText;
	
	@FindBy(xpath="//p[contains(text(),'There are followup questions and discussion around each topic.')]")
	public WebElement followupQuestionText;
	
	@FindBy(xpath="//h3[contains(text(),'Automation Test App')]")
	public WebElement beginPageAppName;
	
	@FindBy(xpath="//h3[contains(text(),'Automation Test App')]")
	public WebElement beginPageAppsName;
	
	@FindBy(xpath="//p[contains(text(),'Auto Ques 1')]")
	public WebElement beginPageFirstDiagnosticName;
	
	@FindBy(xpath="//p[contains(text(),'Auto Ques 2')]")
	public WebElement beginPageSecondDiagnosticName;
	
	@FindBy(xpath="(//p[contains(text(),'Automation Testing purpose')])[position()=1]")
	public WebElement beginPageAppDescription;
	
	@FindBy(xpath="//a[contains(text(),'Back to Top')]")
	public WebElement beginPageBackToTop;

	@FindBy(xpath="//p[contains(text(),'Each topic will be repeated as you respond. This is just a roadmap.')]")
	public WebElement beginPageRoadMap;
	
	@FindBy(xpath="(//a[contains(text(),'Support')])[position()=2]")
	public WebElement supportLnk;
	
	@FindBy(xpath="//div[contains(text(),'You have already completed taking your Application session')]")
	public WebElement completedTakingApp;
	
}
