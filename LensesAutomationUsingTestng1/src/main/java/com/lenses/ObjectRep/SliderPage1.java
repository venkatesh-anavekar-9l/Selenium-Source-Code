package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage1 {
	
	private WebDriver driver;
	
	public SliderPage1(WebDriver driver){
		this.driver = driver;
	}
	
	//@FindBy(xpath="(//a[@id='yes' and text()='Yes'])[position()=1]")
	@FindBy(xpath="//a[@id='yes']")
	public WebElement yesLnk;
	
	@FindBy(xpath="//a[@id='no']")
	public WebElement noLnk;
	
	@FindBy(xpath="//a[@id='notclear']")
	public WebElement notClearSkipItLnk;
	
	
	//1-9 Rate Scaling Radio Button
	
		@FindBy(xpath="//input[@name='rdSlider0' and @value='5']")
		public WebElement sliderRow_5;
		
		@FindBy(xpath="//input[@name='rdSlider0' and @value='9']")
		public WebElement sliderRow9;
		
		
		@FindBy(xpath="(//div[@value='1']/parent::*/descendant::div[contains(@class,'rad-unchecked')])[position()=1]")
		public WebElement sliderScale1UnChk;
		
		@FindBy(xpath="(//div[@value='1']/parent::*/descendant::div[contains(@class,'rad-checked')])[position()=1]")
		public WebElement sliderScale1Chk;
		
		@FindBy(xpath="(//div[@value='5']/parent::*/descendant::div[contains(@class,'rad-unchecked')])[position()=1]")
		public WebElement sliderScale5UnChk;
		
		@FindBy(xpath="(//div[@value='5']/parent::*/descendant::div[contains(@class,'rad-checked')])[position()=1]")
		public WebElement sliderScale5Chk;
		
		//@FindBy(xpath="(//input[@value='9']/parent::*/descendant::div[contains(@class,'rad-unchecked')])[position()=1]")
		@FindBy(xpath="(//div[@value='9']/parent::*/descendant::div[contains(@class,'rad-unchecked')])[position()=1]")
		public WebElement sliderScale9UnChk;
		
		//@FindBy(xpath="(//input[@value='9']/parent::*/descendant::div[contains(@class,'rad-checked')])[position()=1]")
		@FindBy(xpath="(//div[@value='9']/parent::*/descendant::div[contains(@class,'rad-checked')])[position()=1]")
		public WebElement sliderScale9Chk;
		
		@FindBy(xpath="(//div[@value='2']/parent::*/descendant::div[contains(@class,'rad-unchecked')])[position()=2]")
		public WebElement slider2Scale2UnChk;
		
		@FindBy(xpath="(//div[@value='2']/parent::*/descendant::div[contains(@class,'rad-checked')])[position()=1]")
		public WebElement slider2Scale2Chk;
		
		@FindBy(xpath="(//div[@value='4']/parent::*/descendant::div[contains(@class,'rad-unchecked')])[position()=2]")
		public WebElement slider2Scale4UnChk;
		
		@FindBy(xpath="(//div[@value='4']/parent::*/descendant::div[contains(@class,'rad-checked')])[position()=1]")
		public WebElement slider2Scale4Chk;
		
		@FindBy(xpath="(//div[@value='8']/parent::*/descendant::div[contains(@class,'rad-unchecked')])[position()=2]")
		public WebElement slider2Scale8UnChk;
		
		@FindBy(xpath="(//div[@value='8']/parent::*/descendant::div[contains(@class,'rad-checked')])[position()=1]")
		public WebElement slider2Scale8Chk;
		
	
	
		
		@FindBy(xpath=".//*[@id='dvComponentSliderBox0']")
		public WebElement scaleMeter;
		
		//@FindBy(xpath="//div[@class='slider']")
		@FindBy(xpath="(//div[contains(@class,'rankMeterCont')])[position()=1]")
		public WebElement scaleMeter1to9;
		
		@FindBy(xpath=".//*[@id='dvComponentExplainationAndActionBox1']")
		public WebElement explanationField;
		
		@FindBy(xpath="//textarea[@id='txtExplanation']")
		public WebElement explanationTxt;
		
	//	@FindBy(xpath="(//img[@id='browse'])[position()=1]")
	//	@FindBy(xpath="//input[@id='file-input-S']")
		@FindBy(xpath="//a[@id='lnkExplanationFile']")
		public WebElement uploadExplanationTxt;
		
		@FindBy(xpath=".//*[@id='txtResponseChars1']")
		public WebElement explainationCharLeft;
		
		@FindBy(xpath=".//*[@id='dvComponentCommentBox_2']")
		public WebElement commentField;
		
		@FindBy(xpath="(//textarea[contains(@id,'txtComment')])[position()=1]")
		public WebElement commentTxt;
		
		@FindBy(xpath="(//textarea[contains(@id,'txtComment')])[position()=2]")
		public WebElement comment2Txt;
		
		@FindBy(xpath="(//span[contains(@id,'txtCommentChars')])[position()=1]")
		public WebElement commentCharLeft;
		
		@FindBy(xpath="(//span[contains(@id,'txtCommentChars')])[position()=2]")
		public WebElement comment2CharLeft;
		
		@FindBy(xpath=".//*[@id='dvComponentExplainationAndActionBox3']")
		public WebElement actionField;
		
		@FindBy(xpath="//textarea[contains(@id,'txtSolution')]")
		public WebElement actionTxt;
		
		@FindBy(xpath=".//*[@id='txtSolutionChars2']")
		public WebElement actionCharLeft;
		
		@FindBy(xpath=".//*[@id='dvComponentGaps0']")
		public WebElement gapField;
		
		@FindBy(xpath="//div[@class='chooseBestOption']")
		public WebElement gapOption;
		
		@FindBy(xpath=".//*[@id='dvComponentGaps1']")
		public WebElement strengthsChallenges;
		
		@FindBy(xpath="//div[@class='strengthWrapper']")
		public WebElement strengthsChallengesOptions;
		
		//@FindBy(xpath="//div[@class='identifyCompetition']")
		@FindBy(xpath="(//div[contains(@class,'identifyCompetition')])[position()=1]")
		public WebElement pollingField;
		
		@FindBy(xpath="//p[contains(text(),'Polling1')]")
		public WebElement pollingFieldName;
		
		//Gap options
		@FindBy(xpath="(//div[contains(@class,'chk-unchecked')])[position()=1]")
		public WebElement communicationGapsUncheck;
		
		@FindBy(xpath="(//div[contains(@class,'chk-checked')])[position()=1]")
		public WebElement communicationGapsCheck;
		
		@FindBy(xpath="(//div[contains(@class,'chk-checked')])[position()=2]")
		public WebElement communicationGaps2Check;
		
		@FindBy(xpath="(//div[contains(@class,'chk-checked')])[position()=3]")
		public WebElement communicationGaps3Check;
		
		@FindBy(xpath="(//div[contains(@class,'chk-unchecked')])[position()=2]")
		public WebElement communicationGaps2Uncheck;
		
		@FindBy(xpath="(//div[contains(@class,'chk-unchecked')])[position()=3]")
		public WebElement communicationGaps3Uncheck;
		

		// Field - Strength
		//Click on up arrow in Strength
		//@FindBy(xpath="//input[@id='txtStrength']/parent::*/parent::*/descendant::span[@class='ui-icon ui-icon-triangle-1-n']")
		@FindBy(xpath="(//span[@class='ui-icon ui-icon-triangle-1-n'])[position()=1]")
		public WebElement strengthUpArrow;
		
		//Click on down arrow in Strength
		//@FindBy(xpath="//input[@id='txtStrength']/parent::*/parent::*/descendant::span[@class='ui-icon ui-icon-triangle-1-s']")
		@FindBy(xpath="(//span[@class='ui-icon ui-icon-triangle-1-s'])[position()=1]")
		public WebElement strengthDownArrow;
		
		//Rating count in Strength
		@FindBy(xpath="(//input[@id='txtStrength'])[position()=1]")
		public WebElement strengthCount;
		
		//Rating Remain in Strength
		@FindBy(xpath="(.//*[@id='countRemainingStrength'])[position()=1]")
		public WebElement strengthRemain;
		
		// Field - Challenge
		//Click on up arrow in Challenge
			//@FindBy(xpath="//input[@id='txtChallenge']/parent::*/parent::*/descendant::span[@class='ui-icon ui-icon-triangle-1-n']")
			@FindBy(xpath="(//span[@class='ui-icon ui-icon-triangle-1-n'])[position()=2]")
			public WebElement challengeUpArrow;
			
			//Click on down arrow in Challenge
			//@FindBy(xpath="//input[@id='txtChallenge']/parent::*/parent::*/descendant::span[@class='ui-icon ui-icon-triangle-1-s']")
			@FindBy(xpath="(//span[@class='ui-icon ui-icon-triangle-1-s'])[position()=2]")
			public WebElement challengeDownArrow;
			
			//Rating count in Challenge
			//@FindBy(xpath="//input[@id='txtChallenge']")
			@FindBy(xpath="(//input[@id='txtStrength'])[position()=2]")
			public WebElement challengeCount;
			
			//Rating Remain in Challenge
			//@FindBy(xpath=".//*[@id='countRemainingChallenge']")
			@FindBy(xpath="(.//*[@id='countRemainingStrength'])[position()=2]")
			public WebElement challengeRemain;
			
			//Polling Field
			
			//@FindBy(xpath="//input[@value='yes']/parent::*/descendant::div[contains(@class,'chk-unchecked')]")
			@FindBy(xpath="//div[@value='yes']/parent::*/descendant::div[contains(@class,'chk-unchecked')]")
			public WebElement pollingYesUnChk;
		
			@FindBy(xpath="//input[@value='yes']/parent::*/descendant::div[contains(@class,'chk-checked')]")
			public WebElement pollingYesChk;
		
		
		
	
	@FindBy(xpath="//input[@name='rdSlider0' and @value='5']")
	public WebElement sliderRow5;
	
	//@FindBy(xpath="//textarea[@id='txtExplanation']")
	//public WebElement explanationTxt;
	
	//@FindBy(xpath="//textarea[contains(@id,'txtComment')]")
	//public WebElement commentTxt;
	
	@FindBy(xpath="//div[@id='pagination']//span[text()='Next']")
	public WebElement paginationNext;
	
	@FindBy(xpath="//div[@id='pagination']//span[text()='prev']")
	public WebElement paginationPrev;
	
	@FindBy(xpath="//div[@id='pagination']//span[text()='Back to segmentation']")
	public WebElement backToSegmentation;
	
	@FindBy(xpath="//a[contains(text(),'go back')]")
	public WebElement goBackFromReview;
	
	@FindBy(xpath="//a[@id='aDiagnosticDoc']")
	public WebElement infoDownloadLnk;
		
	@FindBy(xpath="//div[@id='divDownloadFile']//div[text()='Close']")
	public WebElement cancelBtnFromPDFPopup;
	
	//@FindBy(xpath="//a[text()='save & quit ']")
	@FindBy(xpath="//a[contains(text(),' Save')]")
	public WebElement saveAndQuitBtn;
	
	
	
	//@FindBy(xpath="(//p[text()='auto polling']/parent::*/parent::*/descendant::*/div[contains(@class,'chk-unchecked')])[position()=1]")
	@FindBy(xpath="(//div[@value='yes']/parent::*/descendant::div[contains(@class,'chk-unchecked')])[position()=1]")
	public WebElement pollingChkY;
	
	
	//@FindBy(xpath="//p[text()='auto polling']/parent::*/parent::*/descendant::*/div[contains(@class,'chk-checked')]")
	@FindBy(xpath="//div[@value='yes']/parent::*/descendant::div[contains(@class,'chk-checked')]")
	public WebElement divPollingYChk;
		
	//@FindBy(xpath="(//p[text()='auto polling']/parent::*/parent::*/descendant::*/div[contains(@class,'chk-unchecked')])[position()=1]")
	@FindBy(xpath="(//div[@value='no']/parent::*/descendant::div[contains(@class,'chk-unchecked')])[position()=1]")
	public WebElement pollingChkN;
	
	//@FindBy(xpath="//p[text()='auto polling']/parent::*/parent::*/descendant::*/div[contains(@class,'chk-unchecked')]")
	@FindBy(xpath="//div[@value='no']/parent::*/descendant::div[contains(@class,'chk-checked')]")
	public WebElement divPollingNChk;
	
	// 2nd auto polling check boxes
	
	//@FindBy(xpath="(//p[text()='auto polling unlimited']/parent::*/parent::*/descendant::*/div[contains(@class,'chk-unchecked')])[position()=1]")
	//@FindBy(xpath="(//div[@value='yes']/parent::*/descendant::div[contains(@class,'chk-unchecked')])[position()=1]")
	@FindBy(xpath="//div[@value='yes1']/parent::*/descendant::div[contains(@class,'chk-unchecked')]")
	public WebElement pollingChkY2;
			
	//@FindBy(xpath="//p[text()='auto polling unlimited']/parent::*/parent::*/descendant::*/div[contains(@class,'chk-checked')]")
	@FindBy(xpath="//div[@value='yes1']/parent::*/descendant::div[contains(@class,'chk-checked')]")
	public WebElement divPollingYChk2;
				
	//@FindBy(xpath="(//p[text()='auto polling unlimited']/parent::*/parent::*/descendant::*/div[contains(@class,'chk-unchecked')])[position()=1]")
	@FindBy(xpath="//div[@value='no1']/parent::*/descendant::div[contains(@class,'chk-unchecked')]")
	public WebElement pollingChkN2;
	
	//@FindBy(xpath="//p[text()='auto polling unlimited']/parent::*/parent::*/descendant::*/div[contains(@class,'chk-checked')]")
	@FindBy(xpath="//div[@value='no']/parent::*/descendant::div[contains(@class,'chk-checked')]")
	public WebElement divPollingNChk2;
	
	//@FindBy(xpath="//p[text()='auto polling unlimited']/parent::*/parent::*/descendant::*/div[contains(@class,'chk-checked')]")
		@FindBy(xpath="//div[@value='no1']/parent::*/descendant::div[contains(@class,'chk-checked')]")
		public WebElement divPollingChkN2;
			
	// 2nd Diagnostic elements
	
	@FindBy(xpath="//span[@id='DiagnosticTitle']")
	public WebElement secondDiagnosticTitle;
	
	@FindBy(xpath="//span[@id='DiagnosticTitle']")
	public WebElement diagnosticTitle;

	// slider details page
	
	@FindBy(xpath="//a[@id='notclear']")
	public WebElement skipNotClearLnk;
	
    // progress bar elements
	
	@FindBy(xpath="//p[@id='progressPercentage']")
	public WebElement progressBarPercentage;
	
	//ideal pop up web elements
	
	public String exitNowLnkXpath="//a[contains(text(),'Exit Now')]";
	@FindBy(xpath="//a[contains(text(),'Exit Now')]")
	public WebElement exitNowLnk;
	
	@FindBy(xpath="//a[contains(text(),'Continue Now')]")
	public WebElement continueNowLnk;
	
	// waring dialog
	
	//@FindBy(xpath="//div[@id='warning']/p")
	@FindBy(xpath="//div[@id='warning']/div")
	public WebElement warnignDialogtxt;
	
	//@FindBy(xpath="//div[@id='warning']//a[text()='Ok']")
	@FindBy(xpath="(//div[@id='warning']//a[text()='Ok'])[position()=1]")
    public WebElement warnignDialogOkBtn;
	
	//@FindBy(xpath="//a[@href='Logout.aspx']")
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	public WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'What is this?')]")
	public WebElement helpStrengthChallenge;
	
	@FindBy(xpath="//h2[contains(text(),'You have been given 10 strength votes and 10 challenge votes')]")
	public WebElement helpStrengthChallengePopUp;
	
	@FindBy(xpath="//p[contains(text(),'Strength Votes')]")
	public WebElement helpStrengthVotes;
	
	@FindBy(xpath="//p[contains(text(),'Challenge Votes')]")
	public WebElement helpChallengeVotes;
	
	@FindBy(xpath="//p[contains(text(),'A topic area can be given both strength and challenge votes.')]")
	public WebElement helpStrengthChallengeVotes;
	
	@FindBy(xpath="//a[contains(text(),'Got It, Return to Interview')]")
	public WebElement helpReturnToInterview;
	
	@FindBy(xpath="(//a[contains(text(),'Support')])[position()=2]")
	public WebElement supportBtn;
	
	@FindBy(xpath="(//a[contains(text(),'Support')])[position()=1]")
	public WebElement sliderSupportBtn;
	
	@FindBy(xpath="//p[contains(text(),'9Lenses Support')]")
	public WebElement supportPopUp;
	
	@FindBy(xpath="//input[@placeholder='Enter Name']")
	public WebElement supportEnterName;
	
	@FindBy(xpath="//input[@ng-model='SupportPhone']")
	public WebElement supportPhone;
	
	@FindBy(xpath="//textarea[@ng-model='SupportMessage']")
	public WebElement supportMessage;
	
	@FindBy(xpath="//input[@class='popUpSupportInput']")
	public WebElement supportUpload;
	
	@FindBy(xpath="//a[contains(text(),'cancel')]")
	public WebElement supportCancel;
	
	@FindBy(xpath="//a[contains(text(),'Send')]")
	public WebElement supportSend;

	@FindBy(xpath="//a[@id='aDiagnosticDoc' or text()='Info download available']")
	public WebElement infoDownloadBtn;
	
	@FindBy(xpath="//div[@class='ngdialog-content']")
	public WebElement infoDownloadPopUp;
	
	@FindBy(xpath="(//div[text()='Close'])[position()=2]")
	public WebElement infoDownloadClosePopUp;
	
	
	
	
	
	
	
	
}
