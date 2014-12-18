package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SessionSetUpPage {
	
	WebDriver driver;
	
	public SessionSetUpPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//@FindBy(xpath="//h1[contains(text(),'Session Set Up')]")
	@FindBy(xpath="//p[contains(text(),'Name this App')]")
	public WebElement sessionSetUpTitle;
	
	//@FindBy(xpath="//ul[@id='emailstag']//input[@class='tagit-input ui-widget-content ui-autocomplete-input']")
	@FindBy(xpath="//textarea[@id='participants_email']")
	public WebElement participantsEmailTxt;
	
	
	@FindBy(xpath="//a[@id='sessionsetup_createthislist' and contains(text(),'Create This List')]")
	//@FindBy(xpath="//div[contains(@class,'yesCreateThisList')]")
	public WebElement createThisListBtn;
	
	
	@FindBy(xpath="//div[@class='assignSelectCont']/div")
	public WebElement assignSelectChk;
	
	@FindBy(xpath="(//ul[@id='ul_participants']//p)[position()=1]")
	public WebElement finalizePaticipantsUsr;
	
	/*//@FindBy(xpath="//div[@class='nextStepDescriptionCont']//a[@class='topperFunctionButton' and text()='Next']")
	@FindBy(xpath="//div[@class='nextStepDescriptionCont']")
	public WebElement nextButton1;*/
	
	public String nextButtonXpath="//h3[contains(text(),'Next Step: Define Segments')]/parent::*/descendant::a[contains(text(),'Next')]";
	//@FindBy(xpath="(//div[@class='nextStepDescriptionCont']//a[contains(text(),'Next')])[position()=2]")
	@FindBy(xpath="//h3[contains(text(),'Next Step: Define Segments')]/parent::*/descendant::a[contains(text(),'Next')]")
	public WebElement defineSegmentsNextButton;
	
	
	@FindBy(xpath="//h3[contains(text(),'Define Segments:')]")
	public WebElement defineSegmentsTitle;
	
	//@FindBy(xpath="(//div[@class='jcf-unselectable chk-area chk-unchecked'])[position()=1]")
	@FindBy(xpath="//label[contains(text(),' Advanced: Configure Collecting Segmentation')]")
	public WebElement allowSegParticipantsChk;
	
	
	@FindBy(xpath="//input[@value='definesegment_participantsId']")
	public WebElement allowParticipantsRadio;
	
	
	//@FindBy(xpath="//h3[contains(text(),'Create Segments & Criteria:')]")
	@FindBy(xpath="//h3[contains(text(),'Create Segment')]")
	public WebElement createSegmentsAndCriteriaTitle;
	
	//@FindBy(xpath="//input[@*=' Job Title']")
	@FindBy(xpath="//input[@*='Role']")
	public WebElement segJobTitleTxt;
	
	
	//@FindBy(xpath="(//p[contains(text(),'Participant Options:')]/parent::*/descendant::input)[position()=1]")
	@FindBy(xpath="(//p[contains(text(),'Participant Option:')]/parent::*/descendant::input)[position()=1]")
	public WebElement participantOptionsTxt;
			
			
	@FindBy(xpath="//input[@*='Department']")
	public WebElement segDepartmentTxt;
	
	@FindBy(xpath="//input[@*=' Tenure']")
	public WebElement segTenureTxt;
	
	
	//@FindBy(xpath="//h3[contains(text(),'Next Step: Messaging')]/parent::*/descendant::a[contains(text(),'Next')]")
	@FindBy(xpath="(//a[contains(text(),'Next')])[position()=2]")
	public WebElement messagingNextButton;
	
	//@FindBy(xpath="//h3[contains(text(),'Messaging:')]")
	@FindBy(xpath="//a[contains(text(),'Messages')]")
	public WebElement messageTitle;
	
	
	@FindBy(xpath="//select[@id='visualTemplateTheme']")
	public WebElement createThemeSclt;
	
	@FindBy(xpath="//select[@id='createmessage_themes']")
	public WebElement invitionThemeSclt;
	
	
	//@FindBy(xpath="//input[@id='createmessage_subject']")
	@FindBy(xpath="//input[@id='Message_InvitationSubject']")
	public WebElement invitionMsgSubTxt;
	
	//@FindBy(xpath="//textarea[@id='createmessage_body']")
	@FindBy(xpath="(//div[@class='jqte_editor'])[position()=1]")
	public WebElement invitionBodyTxt;
	
	
	@FindBy(xpath="//h3[contains(text(),'Next Step: Set reporting')]/parent::*/descendant::a[contains(text(),'Next')]")
	public WebElement setReportingNext;
	
	//@FindBy(xpath="//h3[contains(text(),'Next Step: Finalize')]/parent::*/descendant::a[contains(text(),'Next')]")
	@FindBy(xpath="(//a[contains(text(),'Next')])[position()=4]")
	public WebElement finalizeNext;
	
	//@FindBy(xpath="//select[@id='sessionsetup_finalizetimezone']")
	@FindBy(xpath="//select[@id='duration_timezone']")
	public WebElement timeZoneSclt;
	
	@FindBy(xpath="//input[@id='sessionfinalize_enddate']")
	public WebElement endDateTxt;
	
	
	//@FindBy(xpath="(//a[contains(@class,'ui-state-default')])[position()=2]")
	//@FindBy(xpath="//a[@class='ui-state-default ui-state-highlight ui-state-hover']")
	@FindBy(xpath="//td[contains(@class,'xdsoft_date xdsoft_today')]")
	public WebElement endDateDay;
					
	
	//@FindBy(xpath="//h3[contains(text(),'Finalize:')]/parent::*/descendant::*[contains(text(),'Launch Now')]")
	@FindBy(xpath="//a[contains(text(),'launch now')]")
	public WebElement launchNowBtn;
		
	//@FindBy(xpath="//div[@id='divlaunched_popup']//a[contains(text(),'Yes')]")
	@FindBy(xpath="//a[contains(text(),'Launch It')]")
	public WebElement yesBtn;
	
	//@FindBy(xpath="//div[@id='dialog']//div[contains(text(),'Ok')]")
	@FindBy(xpath="//*[@id='btnOkayDialog']/div")
	//@FindBy(xpath="(//div[contains(text(),'OK')])[position()=2]")
	public WebElement okBtn;
	
	@FindBy(xpath="//h3[contains(text(),'9Lenses') and contains(text(),'Sessions List')]")
	public WebElement sessionListTitle;
	
	@FindBy(xpath="//select[@id='AdminPanelHeaderMenu_CmbCustomerGroup']")
	public WebElement scltCustomerGrp;
	
	@FindBy(xpath="//a[@id='AdminPanelHeaderMenu_lnkCutomerGroup' and text()='Apply']")
	public WebElement applyLnk;
	
	@FindBy(xpath="(//div[@data-hour='23'])[position()=2]")
	public WebElement endDateTime;
	
	@FindBy(xpath="(//td[contains(@class,'xdsoft_date xdsoft_today')]/following-sibling::td)[position()=1]")
	public WebElement endDateT;
	
	@FindBy(xpath="//input[@id='duration_sessionname_input']")
	public WebElement sessionTitleName;
	
	@FindBy(xpath="(//button[@class='xdsoft_next'])[position()=4]")
	public WebElement endDateTimeNext;
	
	@FindBy(xpath="(//a[contains(text(),'Next')])[position()=1]")
	public WebElement nextButton;
	
	@FindBy(xpath="//a[@id='emailAddToList']")
	public WebElement addToList;
	
	@FindBy(xpath="//div[@class='remBlock create-new invitationBlock']")
	public WebElement addMessage;
	
	@FindBy(xpath="//input[@id='Message_InvitationTitle']")
	public WebElement invitionMsgTitleTxt;
	
	@FindBy(xpath="//a[contains(text(),'Skip Reporting')]")
	public WebElement skipReporting;
	
	@FindBy(xpath="//h2[contains(text(),'Success!')]")
	public WebElement successMessage;
	
	
	
	
	
	
	
}
