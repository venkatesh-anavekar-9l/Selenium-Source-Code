package com.lenses.HelpeClass;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.lenses.CommanFunc.CommanFunctions;
import com.lenses.KeyWords.StringConstants;
import com.lenses.ObjectRep.AdminDashBoardPage;
import com.lenses.ObjectRep.ApplicationsPage;
import com.lenses.ObjectRep.BeginAppPage;
import com.lenses.ObjectRep.CreateLoginInfoPage;
import com.lenses.ObjectRep.FeedBackPage;
import com.lenses.ObjectRep.InsightReviewPage;
import com.lenses.ObjectRep.LoginPage;
import com.lenses.ObjectRep.MailPage;
import com.lenses.ObjectRep.NewSessionPage;
import com.lenses.ObjectRep.SegmentationPage;
import com.lenses.ObjectRep.SessionSetUpPage;
import com.lenses.ObjectRep.SliderPage1;
import com.lenses.ObjectRep.TopicsOverViewsPage;
import com.lenses.ObjectRep.ManageUserPage;
import com.lenses.ObjectRep.AnalyticPage;

public class HelperMethods {
	
	private WebDriver driver;
	NewSessionPage newSessionPage;
	CommanFunctions commanFunc = null;
	AdminDashBoardPage adminDashBoard = null;
	ApplicationsPage applicationPage = null;
	SessionSetUpPage sessionSetUpPage = null;
	Actions builder = null;
	BeginAppPage beginAppPage = null;
	TopicsOverViewsPage topicsOverViewsPage = null;
	SegmentationPage segmentationPage = null;
	SliderPage1 sliderPage1 = null;
	InsightReviewPage insightReviewPage = null;
	FeedBackPage feedBackPage = null;
	ManageUserPage manageUserPage = null;
	AnalyticPage analyticPage = null;
	CreateLoginInfoPage createLoginInfoPage = null;
	private LoginPage loginPage = null;
	private MailPage mailPage = null;
	
	public HelperMethods(WebDriver driver)
	{
		this.driver = driver;
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		mailPage=PageFactory.initElements(driver, MailPage.class);
		newSessionPage=PageFactory.initElements(driver, NewSessionPage.class);
		commanFunc=PageFactory.initElements(driver, CommanFunctions.class);
		adminDashBoard=PageFactory.initElements(driver, AdminDashBoardPage.class);
		applicationPage=PageFactory.initElements(driver, ApplicationsPage.class);
		sessionSetUpPage=PageFactory.initElements(driver, SessionSetUpPage.class);
		mailPage=PageFactory.initElements(driver, MailPage.class);
		beginAppPage=PageFactory.initElements(driver, BeginAppPage.class);
		topicsOverViewsPage=PageFactory.initElements(driver, TopicsOverViewsPage.class);
		segmentationPage=PageFactory.initElements(driver, SegmentationPage.class);
		sliderPage1=PageFactory.initElements(driver, SliderPage1.class);
		insightReviewPage=PageFactory.initElements(driver, InsightReviewPage.class);
		feedBackPage=PageFactory.initElements(driver, FeedBackPage.class);
		manageUserPage=PageFactory.initElements(driver, ManageUserPage.class);
		analyticPage=PageFactory.initElements(driver, AnalyticPage.class);
		createLoginInfoPage = PageFactory.initElements(driver, CreateLoginInfoPage.class);
		builder = new Actions(driver);
	}
	
	public void loginAsValidUser(String url,String userName,String password){
		try{
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
			loginPage.usrNameTxt.sendKeys(userName);
			loginPage.pswdTxt.sendKeys(password);
			loginPage.loginBtn.click();
			Thread.sleep(7000);
		}catch(Exception e){
			System.out.println("the exception the login method"+e);
		}
	}
	
	public void loginIntoMailAndClickOnBeginApp(){
		try{
			driver.get(StringConstants.emailUrl);
			driver.manage().window().maximize();
			commanFunc.WaitforElement(mailPage.emailTxt);
			if ((driver.findElements(By.xpath(mailPage.emailTxtXpath)).size() != 0)){
				mailPage.emailTxt.sendKeys(StringConstants.emailUsername);
				mailPage.passWdTxt.sendKeys(StringConstants.emailPassword);
				mailPage.signInBtn.click();
			}
			
			Thread.sleep(180000);
			
		}catch(Exception e){
			System.out.println("the exception the login method"+e);
		}
	}
	
	// click on the particular subject from the mail page
	public void clickOnParticularSubJectFrmTheMail(String subj){
		try{
			 String subjectXpath ="//span/b[text()='"+ subj +"']";
			    
			    String subjectXpath1 ="//span[text()='"+ subj +"']";
			
			    if(driver.findElements(By.xpath(subjectXpath)).size()!=0)
				{	
			    	WebElement ele = driver.findElement(By.xpath(subjectXpath));
			    	commanFunc.mouseOverOnElement(ele);
			    	commanFunc.clickOnElement(ele);
				    Thread.sleep(5000);
				}
			    else if(driver.findElements(By.xpath(subjectXpath1)).size()!=0){
					WebElement ele = driver.findElement(By.xpath(subjectXpath1));
					commanFunc.mouseOverOnElement(ele);
			    	commanFunc.clickOnElement(ele);
				    Thread.sleep(5000);
				}
		}catch(Exception e){
			System.out.println("the expception caught in the clickOnParticularSubJectFrmTheMail"+e);
		}
	}
	
	// click on Begin App Button from the mail page and startInterview button and startGiving responces Button
	public void clicOnBeginAppAndStartInterview(){
		try{
			
			System.out.println("i am in the click on the begin app and start interview method--------->>>>555555");
			
			commanFunc.clickOnElement(mailPage.beginTheAppBtn);
	    	Thread.sleep(60000);
	    	
	    	commanFunc.windowSwitch();
	    	
	    	Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(10000);
	    	
		}catch(Exception e){
			System.out.println("the exception caught clicOnBeginAppAndStartInterview"+e);
		}
	}
	
	public void sessionInvitionAndVerifyEmail_oldLunch(String loginUrl,String useNme,String passWord,String searchAppNme,String usrEmailId,String segJobTitle,String partiOptionY,String partiOptionN,String inviTheme,String inviSubj,String inviBody,String emailUrl,String emailUsrNme,String emailPwd){
		try{
			System.out.println("the  login url ---->"+loginUrl);
		    System.out.println("the user name ---->"+useNme);
		    System.out.println("the password---->"+passWord);
		    loginAsValidUser(loginUrl,useNme,passWord);
			commanFunc.WaitforElement(newSessionPage.newSessionTab);
			Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
			
			commanFunc.clickOnElement(newSessionPage.adminPanelTab);
			Assert.assertEquals(true, adminDashBoard.dashBoardTab.isDisplayed());
			
			//commanFunc.scltCompanyFrmDropDown(sParam10.trim());
			
			commanFunc.clickOnElement(adminDashBoard.appsTab);
			commanFunc.WaitforElement(applicationPage.prePacklensesApp);
			Assert.assertEquals(true, applicationPage.prePacklensesApp.isDisplayed());
			commanFunc.clickOnElement(applicationPage.companyApp);
			
			commanFunc.clickOnElement(applicationPage.showHideLnk);
			Thread.sleep(7000);
			commanFunc.WaitforElement(applicationPage.searchAppTxt);
			Assert.assertEquals(true, applicationPage.searchAppTxt.isDisplayed());
			
			//applicationPage.searchAppTxt.sendKeys("(MUI APP)Automation Test App");
			applicationPage.searchAppTxt.sendKeys(searchAppNme);
			commanFunc.clickOnElement(applicationPage.searchBtn);
			Thread.sleep(7000);
			commanFunc.WaitforElement(applicationPage.searchResAppTitle);
			
			System.out.println("the search title 11111111111111111");
			
			Assert.assertEquals(applicationPage.searchResAppTitle.getText(),searchAppNme,"text not found");
			//Assert.assertEquals(sParam1,applicationPage.searchResAppTitle.getText(),"text not found");
			
			commanFunc.mouseOverOnElement(applicationPage.searchResAppTitle);
			Thread.sleep(4000);
			commanFunc.clickOnElement(applicationPage.useAppLnk);
			
			System.out.println("the session setup title 2222222222");
			
			commanFunc.WaitforElement(sessionSetUpPage.sessionSetUpTitle);
			Assert.assertEquals(true, sessionSetUpPage.sessionSetUpTitle.isDisplayed());
			
			sessionSetUpPage.participantsEmailTxt.clear();
			//builder.moveToElement(sessionSetUpPage.participantsEmailTxt).click().sendKeys("auto1@9lenses.com").build().perform();
			builder.moveToElement(sessionSetUpPage.participantsEmailTxt).click().sendKeys(usrEmailId).build().perform();
			Thread.sleep(3000);
			builder.moveToElement(sessionSetUpPage.participantsEmailTxt).sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			commanFunc.clickOnElement(sessionSetUpPage.createThisListBtn);
			Thread.sleep(7000);
			
			commanFunc.clickOnElement(sessionSetUpPage.assignSelectChk);
			Thread.sleep(4000);
			
			commanFunc.clickOnElement(sessionSetUpPage.defineSegmentsNextButton);
			
			Thread.sleep(8000);
			
			commanFunc.WaitforElement(sessionSetUpPage.defineSegmentsTitle);
			Assert.assertEquals(true, sessionSetUpPage.defineSegmentsTitle.isDisplayed());
			
			commanFunc.clickOnElement(sessionSetUpPage.allowSegParticipantsChk);
			
			commanFunc.clickOnElement(sessionSetUpPage.allowParticipantsRadio);
			Thread.sleep(2000);
			commanFunc.WaitforElement(sessionSetUpPage.createSegmentsAndCriteriaTitle);
			
			//sessionSetUpPage.segJobTitleTxt.sendKeys("Senior Software Engineer");
			sessionSetUpPage.segJobTitleTxt.sendKeys(segJobTitle);
			Thread.sleep(2000);
			sessionSetUpPage.participantOptionsTxt.sendKeys(partiOptionY);
			Thread.sleep(2000);
			builder.moveToElement(sessionSetUpPage.participantOptionsTxt).sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			
			sessionSetUpPage.participantOptionsTxt.sendKeys(partiOptionN);
			Thread.sleep(3000);
			builder.moveToElement(sessionSetUpPage.participantOptionsTxt).sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			
			commanFunc.clickOnElement(sessionSetUpPage.messagingNextButton);
			Thread.sleep(8000);
			
			commanFunc.WaitforElement(sessionSetUpPage.messageTitle);
			Assert.assertEquals(true, sessionSetUpPage.messageTitle.isDisplayed());
			
			Select droplist = new Select(sessionSetUpPage.invitionThemeSclt);   
	    	droplist.selectByVisibleText(inviTheme);
	    	Thread.sleep(2000);
			
	    	 System.out.println("invition subject ---->"+inviSubj);
			 
			    
	    	sessionSetUpPage.invitionMsgSubTxt.sendKeys(inviSubj);
	    	
	    	sessionSetUpPage.invitionBodyTxt.sendKeys(inviBody);
	    	
	    	System.out.println("invition body--->"+inviBody);
	    	
	    	Thread.sleep(2000);	    	
	    	
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.setReportingNext);
	    	Thread.sleep(8000);
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.finalizeNext);
	    	Thread.sleep(8000);
	    	
	    	Select droplist1 = new Select(sessionSetUpPage.timeZoneSclt);   
	    	//droplist1.selectByVisibleText("(GMT +5:30) Bombay, Calcutta, Madras, New Delhi");
	    	droplist1.selectByVisibleText(StringConstants.timeZone);
	    	
	    	System.out.println("time zone--->"+StringConstants.timeZone);
	    	
	    	Thread.sleep(2000);
	    	
	    	sessionSetUpPage.endDateTxt.click();
	    	Thread.sleep(2000);
	    	
	    	sessionSetUpPage.endDateDay.click();
	    	Thread.sleep(4000);
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.launchNowBtn);
	    	Thread.sleep(8000);
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.yesBtn);
	    	Thread.sleep(8000);
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.okBtn);
	    	Thread.sleep(8000);
	    	
	    	Assert.assertEquals(true, sessionSetUpPage.sessionListTitle.isDisplayed());
	    	
	    	//Thread.sleep(100000);
	    	
	       
	    	//helperMethods.loginIntoMailAndClickOnBeginApp("https://mail.google.com/mail/u/0/?pli=1#inbox", "jeevan.borale@9lenses.com","automation@123");
	    	driver.manage().deleteAllCookies();
	    	loginIntoMailAndClickOnBeginApp();
	    	Thread.sleep(30000);
	    	
	    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
	    	
	    	//WebElement ele = driver.findElement(By.xpath("(//*[contains(text(),'Automation testing perpose invi Subj 1212')]/parent::*/parent::*/parent::*/parent::*/parent::*/parent::tr)[position()=1]"));
	    	WebElement ele = driver.findElement(By.xpath("//span/b[text()='"+ inviSubj +"']"));
	    	
	    	commanFunc.waitForElement10Mins(ele);
	    	
	    	
	    	commanFunc.mouseOverOnElement(ele);
	    	
	    	ele.click();
	    	
	    	//commanFunc.clickOnElement(ele);
	    	Thread.sleep(5000);
	    	
	    	
	    	WebElement ele1 = driver.findElement(By.xpath("//a[contains(@href,'StartAppSession') and span[text()='Begin the App ']]"));
	    	//ele1.click();
	    	commanFunc.clickOnElement(ele1);
	    	
	    	
	    	System.out.println("COMPLETED");
	    	Thread.sleep(70000);
	    	
		}catch(Exception e){
			System.out.println("the exception is-->sessionInvitionAndVerifyEmail<------"+e);
		}
	}             
	
	// this method will launch the session immediatelly 
	public void sessionInvitionLaunchNow(String loginUrl,String useNme,String passWord,String searchAppNme,String usrEmailId,String segJobTitle,String partiOptionY,String partiOptionN,String inviTheme,String inviSubj,String inviBody,String appName){
		try{
			System.out.println("the  login url ---->"+loginUrl);
		    System.out.println("the user name ---->"+useNme);
		    System.out.println("the password---->"+passWord);
		    loginAsValidUser(loginUrl,useNme,passWord);
			commanFunc.WaitforElement(newSessionPage.newSessionTab);
			Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
			
			commanFunc.WaitforElement(newSessionPage.adminPanelTab);
			commanFunc.clickOnElement(newSessionPage.adminPanelTab);
			Thread.sleep(5000);
			
			commanFunc.WaitforElement(adminDashBoard.administerApps);
			Assert.assertEquals(true, adminDashBoard.administerApps.isDisplayed());
			Thread.sleep(5000);
			
			commanFunc.WaitforElement(adminDashBoard.appsTemplate);
			commanFunc.clickOnElement(adminDashBoard.appsTemplate);
			
			commanFunc.WaitforElement(applicationPage.prePacklensesApp);
			Assert.assertEquals(true, applicationPage.prePacklensesApp.isDisplayed());
			commanFunc.clickOnElement(applicationPage.companyApp);
			
			commanFunc.clickOnElement(applicationPage.showHideLnk);
			Thread.sleep(7000);
			commanFunc.WaitforElement(applicationPage.searchAppTxt);
			Assert.assertEquals(true, applicationPage.searchAppTxt.isDisplayed());
			
			
			applicationPage.searchAppTxt.sendKeys(searchAppNme);
			commanFunc.clickOnElement(applicationPage.searchBtn);
			Thread.sleep(7000);
			commanFunc.WaitforElement(applicationPage.searchResAppTitle);
			
			System.out.println("the search title 11111111111111111");
			
			Assert.assertEquals(applicationPage.searchResAppTitle.getText(),searchAppNme,"text not found");
			
			
			commanFunc.mouseOverOnElement(applicationPage.searchResAppTitle);
			Thread.sleep(4000);
			commanFunc.clickOnElement(applicationPage.useAppLnk);
			
			System.out.println("the session setup title 2222222222");
			
			commanFunc.WaitforElement(sessionSetUpPage.sessionSetUpTitle);
			Assert.assertEquals(true, sessionSetUpPage.sessionSetUpTitle.isDisplayed());
			
			sessionSetUpPage.sessionTitleName.sendKeys(appName);
			Thread.sleep(4000);
			
		/*	Select droplist1 = new Select(sessionSetUpPage.timeZoneSclt);   
	    	//droplist1.selectByVisibleText("(GMT +5:30) Bombay, Calcutta, Madras, New Delhi");
	    	droplist1.selectByVisibleText(StringConstants.timeZone);
	    	
	    	System.out.println("time zone--->"+StringConstants.timeZone);
	    	
	    	Thread.sleep(5000); */
	    	
	   /* 	sessionSetUpPage.endDateDay.click();
	    	Thread.sleep(5000);
	    	
	    	sessionSetUpPage.endDateTimeNext.click();
	    	Thread.sleep(3000);  
	    	
	    	for (int i = 0; i < 18; i++){
	    		 //click the button
	    		sessionSetUpPage.endDateTimeNext.click();
	    		//Thread.sleep(1000);
		         
	    	}  
	    	
	    	Thread.sleep(3000); */
	    	
	    	sessionSetUpPage.endDateT.click();
	    	Thread.sleep(3000);
			
	    	sessionSetUpPage.nextButton.click();
	    	Thread.sleep(3000);
			
			sessionSetUpPage.participantsEmailTxt.clear();
			//builder.moveToElement(sessionSetUpPage.participantsEmailTxt).click().sendKeys("auto1@9lenses.com").build().perform();
			builder.moveToElement(sessionSetUpPage.participantsEmailTxt).click().sendKeys(usrEmailId).build().perform();
			Thread.sleep(8000);
			
			commanFunc.clickOnElement(sessionSetUpPage.addToList);
			Thread.sleep(8000);
			
			commanFunc.clickOnElement(sessionSetUpPage.allowSegParticipantsChk);
			Thread.sleep(2000);
			//commanFunc.clickOnElement(sessionSetUpPage.allowParticipantsRadio);
			
			commanFunc.WaitforElement(sessionSetUpPage.createSegmentsAndCriteriaTitle);
			
			//sessionSetUpPage.segJobTitleTxt.sendKeys("Senior Software Engineer");
			sessionSetUpPage.segJobTitleTxt.sendKeys(segJobTitle);
			Thread.sleep(5000);
			sessionSetUpPage.participantOptionsTxt.sendKeys(partiOptionY);
			Thread.sleep(3000);
			builder.moveToElement(sessionSetUpPage.participantOptionsTxt).sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(3000);
			
			sessionSetUpPage.participantOptionsTxt.sendKeys(partiOptionN);
			Thread.sleep(3000);
			builder.moveToElement(sessionSetUpPage.participantOptionsTxt).sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(3000);
			
			commanFunc.clickOnElement(sessionSetUpPage.messagingNextButton);
			Thread.sleep(5000);
			
			commanFunc.WaitforElement(sessionSetUpPage.messageTitle);
			Assert.assertEquals(true, sessionSetUpPage.messageTitle.isDisplayed());
			
			commanFunc.clickOnElement(sessionSetUpPage.addMessage);
			Thread.sleep(2000);
			
			sessionSetUpPage.invitionMsgTitleTxt.sendKeys(inviSubj);
	    	Thread.sleep(2000);
			    
	    	sessionSetUpPage.invitionMsgSubTxt.sendKeys(inviSubj);
	    	Thread.sleep(2000);
	    	
	    	sessionSetUpPage.invitionBodyTxt.sendKeys(inviBody);
	    	Thread.sleep(2000);
	    	
	    	System.out.println("invition body--->"+inviBody);
	    	
	    	Thread.sleep(2000);	    	
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.finalizeNext);
	    	Thread.sleep(5000);
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.launchNowBtn);
	    	Thread.sleep(3000);
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.yesBtn);
	    	Thread.sleep(3000);
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.okBtn);
	    	Thread.sleep(5000);
	    	
	    	Assert.assertEquals(true, sessionSetUpPage.successMessage.isDisplayed());
	    	
	    	commanFunc.clickOnElement(sessionSetUpPage.skipReporting);
	    	Thread.sleep(10000);
	    	
	    	Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
	    	
		}catch(Exception e){
			System.out.println("the exception is-->sessionInvitionAndVerifyEmail<------"+e);
		}
	}
	
	public void verifyString(String actualString,String expectedString){
		
		try
		{
			if(actualString.contains(expectedString)){
				System.out.println("the string is  present----->");
			}else{
				System.out.println("the string is not  present----->");
			}
			
		}catch(Exception e)
		{
			System.out.println("the exception caught in the verifyString Method"+e);
		}
		
	}
	
	public void getScreenShot(String screenShotNme){
		try{
		
			String filename="C:\\screenShoots\\screenShotNme"+".jpg";
		
		File  screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(filename));
		}catch(Exception e ){
			System.out.println("the exception caught in getScreenShot"+e);
		}
	}
	// verify progress bar percentage
	public void verifyProgressBar(String actualString,String expectedString){
		
		try
		{
			if(actualString.equals(expectedString)){
				System.out.println("The progreesbar contains correct percentage");
			}else{
				System.out.println("The progreesbar doesn't contain correct percentage");
			}
			
		}catch(Exception e)
		{
			System.out.println("the exception caught in the verifyProgressBar Method"+e);
		}
		
	}
	
	    // this method will launch the session immediatelly 
		public void sessionInvitionLaunchNowWithOutSeg(String loginUrl,String useNme,String passWord,String searchAppNme,String usrEmailId,String segJobTitle,String partiOptionY,String partiOptionN,String inviTheme,String inviSubj,String inviBody, String appName){
			try{
				System.out.println("the  login url ---->"+loginUrl);
			    System.out.println("the user name ---->"+useNme);
			    System.out.println("the password---->"+passWord);
			    loginAsValidUser(loginUrl,useNme,passWord);
			    commanFunc.WaitforElement(newSessionPage.newSessionTab);
				Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
				
				commanFunc.clickOnElement(newSessionPage.adminPanelTab);
				Thread.sleep(5000);
				
				Assert.assertEquals(true, adminDashBoard.administerApps.isDisplayed());
				Thread.sleep(7000);
				
				commanFunc.clickOnElement(adminDashBoard.appsTemplate);
				
				commanFunc.WaitforElement(applicationPage.prePacklensesApp);
				Assert.assertEquals(true, applicationPage.prePacklensesApp.isDisplayed());
				commanFunc.clickOnElement(applicationPage.companyApp);
				
				commanFunc.clickOnElement(applicationPage.showHideLnk);
				Thread.sleep(7000);
				commanFunc.WaitforElement(applicationPage.searchAppTxt);
				Assert.assertEquals(true, applicationPage.searchAppTxt.isDisplayed());
				
				//applicationPage.searchAppTxt.sendKeys("(MUI APP)Automation Test App");
				applicationPage.searchAppTxt.sendKeys(searchAppNme);
				commanFunc.clickOnElement(applicationPage.searchBtn);
				Thread.sleep(7000);
				commanFunc.WaitforElement(applicationPage.searchResAppTitle);
				
				System.out.println("the search title 11111111111111111");
				
				Assert.assertEquals(applicationPage.searchResAppTitle.getText(),searchAppNme,"text not found");
				//Assert.assertEquals(sParam1,applicationPage.searchResAppTitle.getText(),"text not found");
				
				commanFunc.mouseOverOnElement(applicationPage.searchResAppTitle);
				Thread.sleep(4000);
				commanFunc.clickOnElement(applicationPage.useAppLnk);
				
				System.out.println("the session setup title 2222222222");
				
				commanFunc.WaitforElement(sessionSetUpPage.sessionSetUpTitle);
				Assert.assertEquals(true, sessionSetUpPage.sessionSetUpTitle.isDisplayed());
				
				sessionSetUpPage.sessionTitleName.sendKeys(appName);
				Thread.sleep(4000);
				
			/*	Select droplist1 = new Select(sessionSetUpPage.timeZoneSclt);   
		    	//droplist1.selectByVisibleText("(GMT +5:30) Bombay, Calcutta, Madras, New Delhi");
		    	droplist1.selectByVisibleText(StringConstants.timeZone);
		    	
		    	System.out.println("time zone--->"+StringConstants.timeZone);
		    	
		    	Thread.sleep(2000);
		    	
		    	//sessionSetUpPage.endDateTxt.click();
		    	//Thread.sleep(2000);  */
		    	
		/*    	sessionSetUpPage.endDateDay.click();
		    	Thread.sleep(3000);
		    	
		    	sessionSetUpPage.endDateTimeNext.click();
		    	Thread.sleep(3000);  
		    	
		    	for (int i = 0; i < 18; i++){
		    		 //click the button
		    		sessionSetUpPage.endDateTimeNext.click();
			         
		    	}  */
		    		
		    	sessionSetUpPage.endDateT.click();
		    	Thread.sleep(2000);
				
		    	sessionSetUpPage.nextButton.click();
		    	Thread.sleep(4000);
				
				sessionSetUpPage.participantsEmailTxt.clear();
				//builder.moveToElement(sessionSetUpPage.participantsEmailTxt).click().sendKeys("auto1@9lenses.com").build().perform();
				builder.moveToElement(sessionSetUpPage.participantsEmailTxt).click().sendKeys(usrEmailId).build().perform();
				Thread.sleep(3000);
				//builder.moveToElement(sessionSetUpPage.participantsEmailTxt).sendKeys(Keys.ENTER).build().perform();
				//Thread.sleep(2000);
				//commanFunc.clickOnElement(sessionSetUpPage.createThisListBtn);
				//Thread.sleep(7000);
				//commanFunc.clickOnElement(sessionSetUpPage.assignSelectChk);
				//Thread.sleep(4000);
				
				commanFunc.clickOnElement(sessionSetUpPage.addToList);
				Thread.sleep(4000);
				
				//commanFunc.clickOnElement(sessionSetUpPage.defineSegmentsNextButton);
				
				//Thread.sleep(8000);
				
				//commanFunc.WaitforElement(sessionSetUpPage.defineSegmentsTitle);
				//Assert.assertEquals(true, sessionSetUpPage.defineSegmentsTitle.isDisplayed());
				
				//commanFunc.clickOnElement(sessionSetUpPage.allowSegParticipantsChk);
				//Thread.sleep(2000);
				//commanFunc.clickOnElement(sessionSetUpPage.allowParticipantsRadio);
				
				//commanFunc.WaitforElement(sessionSetUpPage.createSegmentsAndCriteriaTitle);
				
				//sessionSetUpPage.segJobTitleTxt.sendKeys("Senior Software Engineer");
				//sessionSetUpPage.segJobTitleTxt.sendKeys(segJobTitle);
				//Thread.sleep(2000);
				//sessionSetUpPage.participantOptionsTxt.sendKeys(partiOptionY);
				//Thread.sleep(2000);
				//builder.moveToElement(sessionSetUpPage.participantOptionsTxt).sendKeys(Keys.ENTER).build().perform();
				//Thread.sleep(2000);
				
				//sessionSetUpPage.participantOptionsTxt.sendKeys(partiOptionN);
				//Thread.sleep(2000);
				//builder.moveToElement(sessionSetUpPage.participantOptionsTxt).sendKeys(Keys.ENTER).build().perform();
				//Thread.sleep(2000);
				
				commanFunc.clickOnElement(sessionSetUpPage.messagingNextButton);
				Thread.sleep(5000);
				
				commanFunc.WaitforElement(sessionSetUpPage.messageTitle);
				Assert.assertEquals(true, sessionSetUpPage.messageTitle.isDisplayed());
				
				//Select droplist = new Select(sessionSetUpPage.invitionThemeSclt);   
		    	//droplist.selectByVisibleText(inviTheme);
		    	//Thread.sleep(2000);
				
		    	//System.out.println("invition subject ---->"+inviSubj);
				
				//commanFunc.clickOnElement(sessionSetUpPage.messagingNextButton);
				
				commanFunc.clickOnElement(sessionSetUpPage.addMessage);
				Thread.sleep(2000);
				
				sessionSetUpPage.invitionMsgTitleTxt.sendKeys(inviSubj);
		    	Thread.sleep(2000);
				    
		    	sessionSetUpPage.invitionMsgSubTxt.sendKeys(inviSubj);
		    	Thread.sleep(2000);
		    	
		    	sessionSetUpPage.invitionBodyTxt.sendKeys(inviBody);
		    	Thread.sleep(2000);
		    	
		    	System.out.println("invition body--->"+inviBody);
		    	
		    	Thread.sleep(2000);	    	
		    	
		    	
		    	//commanFunc.clickOnElement(sessionSetUpPage.setReportingNext);
		    	//Thread.sleep(8000);
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.finalizeNext);
		    	Thread.sleep(5000);
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.launchNowBtn);
		    	Thread.sleep(3000);
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.yesBtn);
		    	Thread.sleep(3000);
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.okBtn);
		    	Thread.sleep(5000);
		    	
		    	//Assert.assertEquals(true, sessionSetUpPage.sessionListTitle.isDisplayed());
		    	
		    	Assert.assertEquals(true, sessionSetUpPage.successMessage.isDisplayed());
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.skipReporting);
		    	Thread.sleep(5000);
		    	
		    	Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
		    	
		    	Thread.sleep(5000);
		    	
		       
		    	//helperMethods.loginIntoMailAndClickOnBeginApp("https://mail.google.com/mail/u/0/?pli=1#inbox", "jeevan.borale@9lenses.com","automation@123");
		    	//driver.manage().deleteAllCookies();
		    	//loginIntoMailAndClickOnBeginApp();
		    	//Thread.sleep(30000);
		    	
		    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		    	
		    	//WebElement ele = driver.findElement(By.xpath("(//*[contains(text(),'Automation testing perpose invi Subj 1212')]/parent::*/parent::*/parent::*/parent::*/parent::*/parent::tr)[position()=1]"));
		    	//WebElement ele = driver.findElement(By.xpath("//span/b[text()='"+ inviSubj +"']"));
		    	
		    	//commanFunc.waitForElement10Mins(ele);
		    	
		    	//commanFunc.mouseOverOnElement(ele);
		    	
		    	//ele.click();
		    	
		    	//commanFunc.clickOnElement(ele);
		    	//Thread.sleep(5000);
		    	
		    	//WebElement ele1 = driver.findElement(By.xpath("//a[contains(@href,'StartAppSession') and span[text()='Begin the App ']]"));
		    	//ele1.click();
		    	//commanFunc.clickOnElement(ele1);
		    	//System.out.println("COMPLETED");
		    	//Thread.sleep(70000);
		    	
			
			}catch(Exception e){
				System.out.println("the exception is-->sessionInvitionAndVerifyEmail<------"+e);
			}
		}
		
	
	    // click on Begin App Button from the mail page and startInterview button and startGiving responses Button without segmentation page
		public void clicOnBeginAppAndStartInterviewSecondTime(String segOpt){
			try{
				
				System.out.println("i am in the click on the begin app and start interview method--------->>>>555555");
				
				commanFunc.clickOnElement(mailPage.beginTheAppBtn);
		    	Thread.sleep(10000);
		    	
		    	commanFunc.windowSwitch();
		    	
		    	Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
		    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
		    	Thread.sleep(7000);
		    	
		    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
		    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
		    	Thread.sleep(7000);
		    	
		    	//Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
		    	//Select inputSclt = new Select(segmentationPage.inputAnserSclt);
		    	//inputSclt.selectByVisibleText(segOpt);
		    	//Thread.sleep(3000);
		    	//commanFunc.clickOnElement(segmentationPage.nextBtn);
		    	//Thread.sleep(9000);
			}catch(Exception e){
				System.out.println("the exception caught clicOnBeginAppAndStartInterview"+e);
			}
		}

		
		public void sessionInvitionAndVerifyEmail(String loginUrl,String useNme,String passWord,String searchAppNme,String usrEmailId,String segJobTitle,String partiOptionY,String partiOptionN,String inviTheme,String inviSubj,String inviBody,String emailUrl,String emailUsrNme,String emailPwd,String appName){
			try{
				System.out.println("the  login url ---->"+loginUrl);
			    System.out.println("the user name ---->"+useNme);
			    System.out.println("the password---->"+passWord);
			    loginAsValidUser(loginUrl,useNme,passWord);
				commanFunc.WaitforElement(newSessionPage.newSessionTab);
				Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
				
				commanFunc.clickOnElement(newSessionPage.adminPanelTab);
				//Assert.assertEquals(true, adminDashBoard.dashBoardTab.isDisplayed());
				Assert.assertEquals(true, adminDashBoard.administerApps.isDisplayed());
				Thread.sleep(7000);
				
				
				
				//commanFunc.clickOnElement(adminDashBoard.appsTab);
				commanFunc.clickOnElement(adminDashBoard.appsTemplate);
				commanFunc.WaitforElement(applicationPage.prePacklensesApp);
				Assert.assertEquals(true, applicationPage.prePacklensesApp.isDisplayed());
				commanFunc.clickOnElement(applicationPage.companyApp);
				
				commanFunc.clickOnElement(applicationPage.showHideLnk);
				Thread.sleep(7000);
				commanFunc.WaitforElement(applicationPage.searchAppTxt);
				Assert.assertEquals(true, applicationPage.searchAppTxt.isDisplayed());
				
				//applicationPage.searchAppTxt.sendKeys("(MUI APP)Automation Test App");
				applicationPage.searchAppTxt.sendKeys(searchAppNme);
				commanFunc.clickOnElement(applicationPage.searchBtn);
				Thread.sleep(7000);
				commanFunc.WaitforElement(applicationPage.searchResAppTitle);
				
				System.out.println("the search title 11111111111111111");
				
				Assert.assertEquals(applicationPage.searchResAppTitle.getText(),searchAppNme,"text not found");
				//Assert.assertEquals(sParam1,applicationPage.searchResAppTitle.getText(),"text not found");
				
				commanFunc.mouseOverOnElement(applicationPage.searchResAppTitle);
				Thread.sleep(4000);
				commanFunc.clickOnElement(applicationPage.useAppLnk);
				
				System.out.println("the session setup title 2222222222");
				
				commanFunc.WaitforElement(sessionSetUpPage.sessionSetUpTitle);
				Assert.assertEquals(true, sessionSetUpPage.sessionSetUpTitle.isDisplayed());
				
				sessionSetUpPage.sessionTitleName.sendKeys(appName);
				Thread.sleep(4000);
				
			/*	Select droplist1 = new Select(sessionSetUpPage.timeZoneSclt);   
		    	//droplist1.selectByVisibleText("(GMT +5:30) Bombay, Calcutta, Madras, New Delhi");
		    	droplist1.selectByVisibleText(StringConstants.timeZone);
		    	
		    	System.out.println("time zone--->"+StringConstants.timeZone);
		    	
		    	Thread.sleep(5000);  */
		    	
		    	
		  /*  	sessionSetUpPage.endDateDay.click();
		    	Thread.sleep(8000);
		    	
		    	sessionSetUpPage.endDateTimeNext.click();
		    	Thread.sleep(5000); 
		    	
		    	for (int i = 0; i < 18; i++){
		    		 //click the button
		    		sessionSetUpPage.endDateTimeNext.click();
		    		//Thread.sleep(1000);
			         
		    	}   */
		    		
		    	sessionSetUpPage.endDateT.click();
		    	Thread.sleep(3000);
				
		    	sessionSetUpPage.nextButton.click();
		    	Thread.sleep(5000);
				
				sessionSetUpPage.participantsEmailTxt.clear();
				//builder.moveToElement(sessionSetUpPage.participantsEmailTxt).click().sendKeys("auto1@9lenses.com").build().perform();
				builder.moveToElement(sessionSetUpPage.participantsEmailTxt).click().sendKeys(usrEmailId).build().perform();
				Thread.sleep(3000);
				
				commanFunc.clickOnElement(sessionSetUpPage.addToList);
				Thread.sleep(4000);
				
				commanFunc.clickOnElement(sessionSetUpPage.allowSegParticipantsChk);
				Thread.sleep(2000);
				//commanFunc.clickOnElement(sessionSetUpPage.allowParticipantsRadio);
				
				commanFunc.WaitforElement(sessionSetUpPage.createSegmentsAndCriteriaTitle);
				
				//sessionSetUpPage.segJobTitleTxt.sendKeys("Senior Software Engineer");
				sessionSetUpPage.segJobTitleTxt.sendKeys(segJobTitle);
				Thread.sleep(2000);
				sessionSetUpPage.participantOptionsTxt.sendKeys(partiOptionY);
				Thread.sleep(2000);
				builder.moveToElement(sessionSetUpPage.participantOptionsTxt).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				
				sessionSetUpPage.participantOptionsTxt.sendKeys(partiOptionN);
				Thread.sleep(2000);
				builder.moveToElement(sessionSetUpPage.participantOptionsTxt).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				
				commanFunc.clickOnElement(sessionSetUpPage.messagingNextButton);
				Thread.sleep(5000);
				
				commanFunc.WaitforElement(sessionSetUpPage.messageTitle);
				Assert.assertEquals(true, sessionSetUpPage.messageTitle.isDisplayed());
				
				
				commanFunc.clickOnElement(sessionSetUpPage.addMessage);
				Thread.sleep(2000);
				
				sessionSetUpPage.invitionMsgTitleTxt.sendKeys(inviSubj);
		    	Thread.sleep(2000);
				    
		    	sessionSetUpPage.invitionMsgSubTxt.sendKeys(inviSubj);
		    	Thread.sleep(2000);
		    	
		    	sessionSetUpPage.invitionBodyTxt.sendKeys(inviBody);
		    	Thread.sleep(2000);
		    	
		    	System.out.println("invition body--->"+inviBody);
		    	
		    	Thread.sleep(2000);	    	
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.finalizeNext);
		    	Thread.sleep(3000);
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.launchNowBtn);
		    	Thread.sleep(3000);
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.yesBtn);
		    	Thread.sleep(5000);
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.okBtn);
		    	Thread.sleep(5000);
		    	
		    	Assert.assertEquals(true, sessionSetUpPage.successMessage.isDisplayed());
		    	
		    	commanFunc.clickOnElement(sessionSetUpPage.skipReporting);
		    	Thread.sleep(5000);
		    	
		    	driver.manage().deleteAllCookies();
		    	loginIntoMailAndClickOnBeginApp();
		    	Thread.sleep(5000);
		    	
		    	
		    	WebElement ele = driver.findElement(By.xpath("//span/b[text()='"+ inviSubj +"']"));
		    	
		    	commanFunc.waitForElement10Mins(ele);
		    	
		    	commanFunc.mouseOverOnElement(ele);
		    	
		    	ele.click();
		    	Thread.sleep(5000);
		    	WebElement ele1 = driver.findElement(By.xpath("//span[contains(text(),'Begin the App ')]"));
		    	
		    	commanFunc.clickOnElement(ele1);
		    	
		    	Thread.sleep(30000);
		    	
			}catch(Exception e){
				System.out.println("the exception is-->sessionInvitionAndVerifyEmail<------"+e);
			}
		}
		
		// click on Begin App Button from the mail page and startInterview button and startGiving responces Button
		public void clicOnSegmentationAndSelectOption(String segOpt){
			try{
				
		
		    	
				//Should display segmentation page
		    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
		    	
		    	Select inputSclt = new Select(segmentationPage.inputAnserSclt);
		    	
		    	
		    	//inputSclt.selectByVisibleText(segOpt);
		    	inputSclt.selectByValue("0");
		    	
		    	Thread.sleep(3000);
		    	commanFunc.clickOnElement(segmentationPage.nextBtn);
		    	
		    	Thread.sleep(9000); 
		    	
			}catch(Exception e){
				System.out.println("the exception caught clicOnSegmentationAndSelectOption"+e);
			}
		}
		
		// this method will New User to 9Lenses Company 
				public void addNewUser(String loginUrl,String useNme,String passWord,String newUsrFirstNme,String newUsrMiddleNme,String newUsrLastNme,String newUsrEmailId){
					try{
						System.out.println("the  login url ---->"+loginUrl);
					    System.out.println("the user name ---->"+useNme);
					    System.out.println("the password---->"+passWord);
					    loginAsValidUser(loginUrl,useNme,passWord);
						commanFunc.WaitforElement(newSessionPage.newSessionTab);
						Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
						
						commanFunc.WaitforElement(newSessionPage.adminPanelTab);
						commanFunc.clickOnElement(newSessionPage.adminPanelTab);
						Thread.sleep(5000);
						
						commanFunc.WaitforElement(adminDashBoard.administerApps);
						Assert.assertEquals(true, adminDashBoard.administerApps.isDisplayed());
						Thread.sleep(2000);
						
						//Click on Users Tab from left hand side of the page
						commanFunc.clickOnElement(manageUserPage.usersTab);
						Thread.sleep(5000);
						
						//Verify Manage Users tab is displayed from drill down 
						Assert.assertEquals(true, manageUserPage.manageUsersTab.isDisplayed());
						Thread.sleep(2000);
						
						//Click on Manage Users Tab from left hand side of the page
						commanFunc.clickOnElement(manageUserPage.manageUsersTab);
						Thread.sleep(5000);
						
						//Verify 9Lenses Users List Page is displayed 
						Assert.assertEquals(true, manageUserPage.userListPage.isDisplayed());
						
						//Click on Add New User Button
						commanFunc.clickOnElement(manageUserPage.addNewUserBtn);
						Thread.sleep(5000);
						
						//Verify Add New User POP Up Window is displayed 
						Assert.assertEquals(true, manageUserPage.addNewUserTxt.isDisplayed());
						
						//Click on Cancel Button from the POP UP Window
						commanFunc.clickOnElement(manageUserPage.cancelPopUp);
						Thread.sleep(3000);
						
						//Verify 9Lenses Users List Page is displayed 
						Assert.assertEquals(true, manageUserPage.userListPage.isDisplayed());
						
						//Click on Add New User Button
						commanFunc.clickOnElement(manageUserPage.addNewUserBtn);
						Thread.sleep(5000);
						
						//Verify Name and email txt is displayed in POP Up Window
						Assert.assertEquals(true, manageUserPage.namePopUpTxt.isDisplayed());
						Assert.assertEquals(true, manageUserPage.emailPopUpTxt.isDisplayed());
						
						//Enter First Name  of new user
						manageUserPage.nameTxtField.sendKeys(newUsrFirstNme);
				    	Thread.sleep(2000);
						
						//Enter new User Middle name
				    	manageUserPage.middleNameTxtField.sendKeys(newUsrMiddleNme);
				    	Thread.sleep(2000);
						
				    	//Enter new User Last name
				    	manageUserPage.lastNameTxtField.sendKeys(newUsrLastNme);
				    	Thread.sleep(2000);
				    	
					/*	int randomNum = getRandomNum();
						appName = appName+randomNum+"@9lenses.com";*/
						
						System.out.println("the user email id ---->"+newUsrEmailId);
				    	//Enter new User email address		    	
				    	manageUserPage.emailTxtField.sendKeys(newUsrEmailId);
				    	Thread.sleep(2000);
				    	
				    	//Click on Add button from the Pop up window
				    	commanFunc.clickOnElement(manageUserPage.addBtn);
						Thread.sleep(3000);
						
						//Verify Successfully added confirmation message popup window is displayed
						Assert.assertEquals(true, manageUserPage.successfullyAddedTxt.isDisplayed());
				    	
				    	//Click on Ok Button from the pop up window
						commanFunc.clickOnElement(manageUserPage.oKBtn);
						Thread.sleep(3000);
						
						//Verify 9Lenses Users List Page is displayed 
						Assert.assertEquals(true, manageUserPage.userListPage.isDisplayed());
						
					}catch(Exception e){
						System.out.println("the exception caught add New User"+e);
					}
					
			}
		
		// click on the particular subject from the mail page
		public void clickOnParticularSubJectFrmTheMailFeedBack(String subj){
			try{
				 String subjectXpath ="//span/b[text()='"+ subj +"']";
				    
				    String subjectXpath1 ="//span[text()='"+ subj +"']";
				
				    if(driver.findElements(By.xpath(subjectXpath)).size()!=0)
					{	
				    	WebElement ele = driver.findElement(By.xpath(subjectXpath));
				    	commanFunc.mouseOverOnElement(ele);
				    	commanFunc.clickOnElement(ele);
					    Thread.sleep(5000);
					}
				    else if(driver.findElements(By.xpath(subjectXpath1)).size()!=0){
						WebElement ele = driver.findElement(By.xpath(subjectXpath1));
						commanFunc.mouseOverOnElement(ele);
				    	commanFunc.clickOnElement(ele);
					    Thread.sleep(5000);
					}
			}catch(Exception e){
				System.out.println("the expception caught in the clickOnParticularSubJectFrmTheMail"+e);
			}
		}
		
		// click on the particular subject from the mail page
		public void MoveCursorTo1stQuestion(){
			try{
				 String subjectXpath ="//a[contains(text(),'2')]";
				    
				    	WebElement ele = driver.findElement(By.xpath(subjectXpath));
				    	commanFunc.mouseOverOnElement(ele);
					    Thread.sleep(5000);
					
			}catch(Exception e){
				System.out.println("the expception caught in the MoveCursorTo1stQuestion"+e);
			}
		}
		
		// it will generate the random number
		public int getRandomNum(){
			Random num = new Random();
			int randomNum = num.nextInt(100);
			return randomNum;
		}
		
		// update password for analytics
		public void updatePassWord(String passWrd,String confpassWrd){
			try{
				System.out.println("i m in update password ");
				commanFunc.enableElementViaJavaScriptAndClick(createLoginInfoPage.passWrdTxt);
				builder.moveToElement(createLoginInfoPage.passWrdTxt).sendKeys(passWrd).build().perform();
				commanFunc.enableElementViaJavaScriptAndClick(createLoginInfoPage.confirmPassWrdTxt);
				builder.moveToElement(createLoginInfoPage.confirmPassWrdTxt).sendKeys(confpassWrd).build().perform();
				Thread.sleep(8000);
				commanFunc.clickOnElement(createLoginInfoPage.termsAndConditionChk);
				Thread.sleep(5000);
				commanFunc.clickOnElement(createLoginInfoPage.submitBtn);
				Thread.sleep(30000);
			}catch(Exception e){
				System.out.println("the exception the login method"+e);
			}
		}
		
		// click on the particular subject from the mail page
		public Boolean verifySupportEmailContents(String email,String contents){
			Boolean retVal=false;
			try{
					//String inviSubjXpath ="//a[text()='auto1@9lenses.com']/parent::div";
					String inviSubjXpath ="//a[text()='"+email+"']/parent::div";
				    System.out.println("1111111111111111111111111111111111111");
				    WebElement ele = driver.findElement(By.xpath(inviSubjXpath));
				    
				    String actualText = ele.getText().toString();
				    String[] exceptedTxt = contents.split("::");
				    System.out.println("the feedback email contents-->"+actualText);
				    //exceptedTxt=contents.split("::");
	                for(String Data : exceptedTxt)
	                {
	                    Data=Data.trim();

	                    if(actualText.contains(Data))
	                    {
	                        System.out.println(Data + "--->Exists");
	                        retVal=true;
	                    }
	                    else
	                    {
	                    	System.out.println(Data + "<---Doesnt Exists");
	                        retVal=false;
	                        break;
	                    }
	                }
				    
			}catch(Exception e){
				System.out.println("the expception caught in the verifySupportEmailContents"+e);
			}
			return retVal;
		}
		
		// click on Begin App Button from the mail page and startInterview button and startGiving responces Button
		public void clicOnBeginAppAndVerifyBeginTheInterview(){
			try{
				
				System.out.println("i am in the click on the begin app and start interview method--------->>>>555555");
				
				commanFunc.clickOnElement(mailPage.beginTheAppBtn);
		    	Thread.sleep(15000);
		    	
		    	commanFunc.windowSwitch();
		    	
		    	Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
		    	Thread.sleep(15000);
		    	
			}catch(Exception e){
				System.out.println("the exception caught clicOnBeginAppAndStartInterview"+e);
			}
		}

		// click on the particular subject from the mail page
				public void MoveCursorTo2ndQuestion(){
					try{
						 String subjectXpath ="(//a[@ng-click='OnSegmentationClick()'])[position()='1']";
						    
						    	WebElement ele = driver.findElement(By.xpath(subjectXpath));
						    	commanFunc.mouseOverOnElement(ele);
							    Thread.sleep(5000);
							
					}catch(Exception e){
						System.out.println("the expception caught in the MoveCursorTo2ndQuestion"+e);
					}
				}
		
		
				 public boolean verifyAssertString(String actualString,String expectedString){
					  boolean bRet = false;
					  try
					  {
					   if(actualString.contains(expectedString)){
					    System.out.println("the string is  present----->");
					    bRet = true;
					   }else{
					    System.out.println("the string is not  present----->");
					    bRet = false;
					   }
					   
					  }catch(Exception e)
					  {
					   System.out.println("the exception caught in the verifyString Method"+e);
					  }
					  return bRet;
					  
					 }
				
}


