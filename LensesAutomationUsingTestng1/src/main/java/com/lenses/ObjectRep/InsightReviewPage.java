package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsightReviewPage {
	
	private WebDriver driver;
	
	public InsightReviewPage(WebDriver driver){
		this.driver = driver;
	}
	
	//@FindBy(xpath="//a[@id='hrefSubmit']")
	@FindBy(xpath="//a[contains(text(),'Submit My Responses')]")
	public WebElement reviewSubmitBtn;
	
	
	@FindBy(xpath="//div[@id='ExitAppDialog']/p")
	public WebElement exitAppDialogParagTxt;
	
	
	@FindBy(xpath="//div[@class='wrapperFullWidth ']//p[contains(@class,'text_Large')]")
	public WebElement insightReviewThanksLbl;
	
	@FindBy(xpath="//div[@id='ExitAppDialog']//div[text()='Yes']")
	public WebElement exitAppDialogYesBtn;
		
	@FindBy(xpath="//a[contains(@href,'ViewAllTopicArea') or text()='Topic Area ']")
	public WebElement topicAreaLnk;
	
	// insight review list of questions pop up 
	
	@FindBy(xpath="//div[@class='diagnosticListBlock']//a[text()='Auto Ques 1']")
	public WebElement firstQues;
	
	@FindBy(xpath="//div[@class='diagnosticListBlock']//a[text()='Auto Ques 2']")
	public WebElement secQues;
	
	
	
	@FindBy(xpath="//p[contains(text(),'You Made It')]")
	public WebElement youMadeItTxt;

	@FindBy(xpath="//p[contains(text(),'If you are happy with your response')]")
	public WebElement yourResponseTxt;

	@FindBy(xpath="//th[contains(text(),'Topic Area')]")
	public WebElement topicAreaTxt;

	@FindBy(xpath="//th[contains(text(),'Score')]")
	public WebElement scoreTxt;

	@FindBy(xpath="//th[contains(text(),'Words')]")
	public WebElement wordsTxt;
	
	@FindBy(xpath="//th[contains(text(),'Strengths')]")
	public WebElement strengthsTxt;
	
	@FindBy(xpath="//th[contains(text(),'Challenges')]")
	public WebElement challengesTxt;

	@FindBy(xpath="//th[contains(text(),'Can you help')]")
	public WebElement canUHelpTxt;

	@FindBy(xpath="//a[contains(text(),'Back to Top')]")
	public WebElement backToTopBtn;

	@FindBy(xpath="//td[contains(text(),'Auto Ques 1')]")
	public WebElement questionOne;

	@FindBy(xpath="//td[contains(text(),'Auto Ques 2')]")
	public WebElement questionSecond;

	@FindBy(xpath="//td[contains(text(),'9')]")
	public WebElement scoreFirstQuestion;

	@FindBy(xpath="(//td[contains(text(),'1')])[position()='3']")
	public WebElement scoreSecondQuestion;

	@FindBy(xpath="(//td[contains(text(),'64')])[position()=1]")
	public WebElement wordFirstQuestion;

	@FindBy(xpath="(//td[contains(text(),'64')])[position()=2]")
	public WebElement wordSecondQuestion;
	
	@FindBy(xpath="(//td[contains(text(),'1')])[position()=2]")
	public WebElement strengthFirstQuestion;
	
	@FindBy(xpath="(//td[contains(text(),'NIL') or text()='--'])[position()=1]")
	public WebElement strengthSecondQuestion;
	
	@FindBy(xpath="(//td[contains(text(),'NIL') or text()='--'])[position()=2]")
	public WebElement challengesFirstQuestion;
	
	@FindBy(xpath="(//td[contains(text(),'2')])[position()=2]")
	public WebElement challengesSecondQuestion;

	@FindBy(xpath="//td[contains(text(),'Yes')]")
	public WebElement canUHelpFirstQuestion;

	@FindBy(xpath="//td[contains(text(),'No')]")
	public WebElement canUHelpSecondQuestion;

	@FindBy(xpath="(//a[@ng-click='OnMainClick()'])[position()='1']")
	public WebElement iBtn;
	
	@FindBy(xpath="(//a[@ng-click='OnReviewClick()'])[position()='1']")
	public WebElement rBtn;
	
	@FindBy(xpath="//a[contains(text(),'1')]")
	public WebElement firstQuestionBtn;
	
	@FindBy(xpath="//a[contains(text(),'2')]")
	public WebElement secondQuestionBtn;
	
	@FindBy(xpath="(//a[@ng-click='OnSegmentationClick()'])[position()='1']")
	public WebElement sBtn;
	
	@FindBy(xpath="//div[contains(text(),'You must select your segmentation information before')]")
	public WebElement segInfoBeforePopUp;
	
	@FindBy(xpath="//a[contains(text(),'Go to Segmentation Page')]")
	public WebElement goToSegPopUp;
	
	@FindBy(xpath="//strong[contains(text(),'Auto Ques 1')]")
	public WebElement firstQuestionTitle;
	
	@FindBy(xpath="//strong[contains(text(),'Auto Ques 2')]")
	public WebElement secondQuestionTitle;

}
