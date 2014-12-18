package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedBackPage {

	WebDriver driver;
	public FeedBackPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	//@FindBy(xpath="//div[@class='jcf-unselectable rad-area rad-unchecked']")
	@FindBy(xpath="//input[@id='radioGood']")
	public WebElement excellentRadioBtn;
	
	//@FindBy(xpath="(//div[@class='jcf-unselectable rad-area rad-unchecked'])[position()=2]")
	@FindBy(xpath="//input[@id='radioAverage']")
	public WebElement averageRadioBtn;		
	
	//@FindBy(xpath="(//div[@class='jcf-unselectable rad-area rad-unchecked'])[position()=3]")
	@FindBy(xpath="//input[@id='radioPoor']")
	public WebElement poorRadioBtn;	
	
	@FindBy(xpath="//a[text()='Skip']")
	public WebElement skipLnk;
	
	@FindBy(xpath="//textarea[contains(@placeholder,'Enter your feedback here')]")
	public WebElement feedbackTxt;
	
	@FindBy(xpath="//h2[contains(text(),'Optional Feedback')]")
	public WebElement optionalFeedbackLbl;
	
	@FindBy(xpath="//a[text()='Submit']")
	public WebElement feedbackSubmitBtn;
	
	@FindBy(xpath="//div[@id='dialog']//span[@id='lblText']")
	public WebElement feedbackDialogTxt;
	
	@FindBy(xpath="//div[@id='dialog']//div[contains(text(),'Ok')]")
	public WebElement feedbackDialogOkBtn;
	
	@FindBy(xpath="//label[contains(text(),'How was your experience with this software?')]")
	public WebElement feedbackExperience;
	
	@FindBy(xpath="//label[contains(text(),'The Interview Engine was')]")
	public WebElement feedbackInterviewEngine;
	
	@FindBy(xpath="//h1[contains(text(),'The Organizational Intelligence Platform')]")
	public WebElement companyHomePage;
	
}
