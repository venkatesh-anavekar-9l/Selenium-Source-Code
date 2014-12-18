package com.lenses.Tests;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lenses.CommanFunc.CommanFunctions;
import com.lenses.CustomReport.TestReport;
import com.lenses.HelpeClass.HelperMethods;
import com.lenses.KeyWords.StringConstants;
import com.lenses.ObjectRep.AdminDashBoardPage;
import com.lenses.ObjectRep.AnalyticPage;
import com.lenses.ObjectRep.ApplicationsPage;
import com.lenses.ObjectRep.BeginAppPage;
import com.lenses.ObjectRep.FeedBackPage;
import com.lenses.ObjectRep.InprogressSessionListPage;
import com.lenses.ObjectRep.InsightReviewPage;
import com.lenses.ObjectRep.LoginPage;
import com.lenses.ObjectRep.MailPage;
import com.lenses.ObjectRep.NewSessionPage;
import com.lenses.ObjectRep.SegmentationPage;
import com.lenses.ObjectRep.SessionSetUpPage;
import com.lenses.ObjectRep.SliderPage1;
import com.lenses.ObjectRep.SupoortPopUpPage;
import com.lenses.ObjectRep.TopicsOverViewsPage;
import com.lenses.TestdataTemplate.TestDataObj;
import com.lenses.Utils.TestSuitSetUp;
import com.lenses.ObjectRep.ManageUserPage;
import com.lenses.ObjectRep.AnalyticPage;

public class InSightTest {

	WebDriver driver;
	WebDriverWait wait;
	LoginPage loginPage;
	NewSessionPage newSessionPage;
	HelperMethods helperMethods = null;
	CommanFunctions commanFunc = null;
	AdminDashBoardPage adminDashBoard = null;
	ApplicationsPage applicationPage = null;
	SessionSetUpPage sessionSetUpPage = null;
	MailPage mailPage = null;
	Actions builder = null;
	BeginAppPage beginAppPage = null;
	TopicsOverViewsPage topicsOverViewsPage = null;
	SegmentationPage segmentationPage = null;
	SliderPage1 sliderPage1 = null;
	InsightReviewPage insightReviewPage = null;
	FeedBackPage feedBackPage = null;
	InprogressSessionListPage inProgressSessionListPage = null;
	ManageUserPage manageUserPage = null;
	AnalyticPage analyticPage = null;
	SupoortPopUpPage supportPopUpPage = null;
	TestReport testReport=null;
	StringConstants conts = null;
	String sPath=null;
	File f=null;
    String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
    String sTimeAppend=null;
    Calendar cal = null;
    SimpleDateFormat sdf = null;
    FirefoxProfile firefoxProfile=null;
    String lastProfile=null;
    String currentProfile=null;  
    String sClientMachineIP=null;
    String sClientMachineName=null;
    String runID=null;
    String sFinalResult="Fail";
    boolean bPostControl=false;
    //-------Testcase variables-----//
    private String sTestcaseID=null;
    private String sFeatureName=null;
    private String sTestcasePath=null;
    private String sProfileName=null;
    private String sUsgIP=null;
    private String sUsgUserName=null;
    private String sUsgPassword=null;
    private String sUsgRootPassword=null;
    private String sBuddyName=null;
    private String sBuddyPassword=null;
    private String sLoginUrl=null;
    private String sBrowser=null;
    private String sPolicyID=null;
    private String sPolicyName=null;
    private String sParam0=null;
    private String sParam1=null;
    private String sParam2=null;
    private String sParam3=null;
    private String sParam4=null;
    private String sParam5=null;
    private String sParam6=null;
    private String sParam7=null;
    private String sParam8=null;
    private String sParam9=null;
    private String sParam10=null;
    private String sParam11=null;
    private String sParam12=null;
    private String sParam13=null;
    private String sParam14=null;
    private String sParam15=null;
    private String sParam16=null;
    private String sParam17=null;
	private static int blockCheck=0;
	private String resultFileName=null;
	private FileWriter fileWriter=null;
	boolean bRet=false;
	
	private static Logger logger = Logger.getLogger(InSightTest.class.getName());
	static
	{
		DOMConfigurator.configure("resources/log4j.xml");
		
	}
	
	public static TestSuitSetUp CSvmap = new TestSuitSetUp();
	public TestDataObj TestDataObject;
	
/* 	@BeforeClass(alwaysRun=true)
	  public void BeforeClass()
	  {
		  try
		  
		  {
			  driver = new FirefoxDriver();
			  builder = new Actions(driver);
			  SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			  sTimeAppend=sdf.format(cal.getTime()).toString();
		  }
		  catch(Exception e)
		  {
			  System.out.println("the exception in the Before Class Method"+e);
		  }
	  }*/
	
	@BeforeMethod(groups="lenfuncTest",alwaysRun=true)
	public void setup(){
		try
		{
		    sPath = new java.io.File(".").getCanonicalPath();
		    Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    sTimeAppend=sdf.format(cal.getTime()).toString();	
		    //sFinalResult="Fail";
		    logger.info("before testcase execution i m in the setup method");		    
		    //bPostControl=false;
			//blockCheck++;
		}
		catch(Exception e)
		{
			logger.info(e);
		}
	}
	
	private void setParameterValues(TestDataObj TestDataObject)
	{
	    sTestcaseID=TestDataObject.getTestcaseID();
		sFeatureName=TestDataObject.getFeatureName();
	    sTestcasePath=TestDataObject.getTestPath();
	    sProfileName=TestDataObject.getProfile();
	    sUsgIP=TestDataObject.getUSGIP();
	    sUsgUserName=TestDataObject.getUSGUserName();
	    sUsgPassword=TestDataObject.getUSGPwd();
	    sUsgRootPassword=TestDataObject.getUSGRootPwd();
	    sBuddyName=TestDataObject.getUsername();
	    sBuddyPassword=TestDataObject.getPassword();
	    sLoginUrl=TestDataObject.getLoginURL();
	    sBrowser=TestDataObject.getBrowser();
	    sPolicyID=TestDataObject.getPolicyID();
	    sPolicyName=TestDataObject.getPolicyName();
	    sParam0=TestDataObject.getParam0();
	    sParam1=TestDataObject.getParam1();
	    sParam2=TestDataObject.getParam2();
	    sParam3=TestDataObject.getParam3();
	    sParam4=TestDataObject.getParam4();
	    sParam5=TestDataObject.getParam5();
	    sParam6=TestDataObject.getParam6();
	    sParam7=TestDataObject.getParam7();
	    sParam8=TestDataObject.getParam8();
	    sParam9=TestDataObject.getParam9();
	    sParam10=TestDataObject.getParam10();
	    sParam11=TestDataObject.getParam11();
	    sParam12=TestDataObject.getParam12();
	    sParam13=TestDataObject.getParam13();
	    sParam14=TestDataObject.getParam14();
	    sParam15=TestDataObject.getParam15();
	    
	    driver = new FirefoxDriver();
		builder = new Actions(driver);
	   
		helperMethods=PageFactory.initElements(driver, HelperMethods.class);
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
		inProgressSessionListPage=PageFactory.initElements(driver, InprogressSessionListPage.class);
		manageUserPage=PageFactory.initElements(driver, ManageUserPage.class);
		analyticPage=PageFactory.initElements(driver, AnalyticPage.class);
		supportPopUpPage=PageFactory.initElements(driver, SupoortPopUpPage.class);
		
		testReport= new TestReport();
		resultFileName=CSvmap.uniqueFilename;
		fileWriter=CSvmap.fw;
		
	}
	
	@Test(groups = { "lenfuncTest29" })
	public void loginTest() {
		boolean bRet=false;
		try
		{
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCILog001");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
		    
		    setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    logger.info("testcases-->"+sTestcaseID+"<-- started");
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4+sTimeAppend;
		    sParam5=sParam5+sTimeAppend;
		    
		    Reporter.log("Before Login Application SuccussFully");
		    
		    logger.info("the  login url ---->"+sLoginUrl);
		    logger.info("the user name ---->"+sBuddyName);
		    logger.info("the password---->"+sBuddyPassword);
		    logger.info("the sParam4 ---->"+sParam4);
		    logger.info("the sParam5---->"+sParam5);
		    
		    System.out.println("the  login url ---->"+sLoginUrl);
		    System.out.println("the user name ---->"+sBuddyName);
		    System.out.println("the password---->"+sBuddyPassword);
		    System.out.println("the sParam4 ---->"+sParam4);
		    System.out.println("the sParam5---->"+sParam5);
		    helperMethods.loginAsValidUser(sLoginUrl,sBuddyName,sBuddyPassword);
		    
		    Reporter.log("Application Loged SuccussFully");
		    commanFunc.WaitforElement(newSessionPage.newSessionTab);
		    //helperMethods.getScreenShot("snap1");
			//wait.until(ExpectedConditions.visibilityOf(newSessionPage.newSessionTab));
			Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
			//helperMethods.getScreenShot("snap2");
			Thread.sleep(5000);
			bRet = newSessionPage.newSessionTab.isDisplayed();
			
			if(bRet){
				sFinalResult = "Pass";
			}else{
				sFinalResult = "Fail";
			}
						
			testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, "put Expectedf result", "Put actual result", "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	 }
	
	@Test(groups="lenfuncTest")
	public void inSightSendInvitionUsingLaunchNowAndVerifyAllFieldFromBeginTheInterviewPageTCINS001()
	{
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		String interID=null;
		String content=null;
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS001");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam13=sParam13.trim();
		    sParam14=sParam14.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    
		    // verify should session will launch immediately and verify in the mail 
		    helperMethods.sessionInvitionAndVerifyEmail(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7,StringConstants.emailUrl,sBuddyName, sParam8, sParam15);
		 
		    commanFunc.windowSwitch();
            Thread.sleep(30000);
		    
          //Click on Support Button
	    	commanFunc.clickOnElement(sliderPage1.supportBtn);
	    	Thread.sleep(2000);
	    	
	    	//Verify Support Pop up Window is displayed
	    	Assert.assertEquals(true, sliderPage1.supportPopUp.isDisplayed());
	    	
	    	//Click on Cancel button from popup window
	    	commanFunc.clickOnElement(sliderPage1.supportCancel);
	    	Thread.sleep(2000);
            
     
		   //Verify should display BeginApp Page Text.     
	    	Assert.assertEquals(true,beginAppPage.softwareInterviewText.isDisplayed()); 
	    	Thread.sleep(7000);
	    	
	    	//Verify should display BeginApp Page Text2.
	    	Assert.assertEquals(true,beginAppPage.followupQuestionText.isDisplayed()); 
	    	Thread.sleep(2000); 
		    
	    	//Verify should Display Application Name Diagnostic
	    	Assert.assertEquals(true,beginAppPage.beginPageAppName.isDisplayed()); 
	    	Thread.sleep(2000);
	    	
	    	//Verify should Display First Diagnostic
	    	Assert.assertEquals(true,beginAppPage.beginPageFirstDiagnosticName.isDisplayed()); 
	    	Thread.sleep(2000);
	    	
	//    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    	//Verify should Display Second Diagnostic
	    	Assert.assertEquals(true,beginAppPage.beginPageSecondDiagnosticName.isDisplayed()); 
	    	Thread.sleep(2000);
	    	
	    	//Verify should Display Application Description
	    	Assert.assertEquals(true,beginAppPage.beginPageAppDescription.isDisplayed()); 
	    	Thread.sleep(2000);
	    	
	    	//Verify should Display BackToTop button
	    	Assert.assertEquals(true,beginAppPage.beginPageBackToTop.isDisplayed()); 
	    	Thread.sleep(2000);
	    	
	    	//Verify should Display RoadMap Text
	    	Assert.assertEquals(true,beginAppPage.beginPageRoadMap.isDisplayed()); 
	    	Thread.sleep(2000);
	    	
	    	
	    	bRet=beginAppPage.beginPageAppDescription.isDisplayed();
	    	String actualTxt = beginAppPage.beginPageAppDescription.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightStartSessionThrowEmailAndSegmentationPageFunctionalityTCINS002(){
			
		//	boolean bRet=false;
			boolean bRet=false;
			boolean bRet1=false;
			
			try{
				
					try
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS002");
						if((TestDataObject==null))
						{
							TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
							bPostControl=false;
						}
						else
						{
							bPostControl=true;
						}
						
					}
					catch(Exception e)
					{
						
						logger.info("Error in selecting testcase id ");
						
					}
					
					setParameterValues(TestDataObject);
				    System.out.println("testcases-->"+sTestcaseID+"<-- started");
				 
				    sParam0=sParam0.trim();
				    sParam1=sParam1.trim();
				    sParam2=sParam2.trim();
				    sParam3=sParam3.trim();
				    sParam4=sParam4.trim();
				    sParam5=sParam5.trim();
				    sParam6=sParam6.trim()+sTimeAppend;;
				    sParam7=sParam7.trim()+sTimeAppend;
				    sParam8=sParam8.trim();
				    sParam9=sParam9.trim();
				    sParam10=sParam10.trim();
				    sParam11=sParam11.trim();
				    sParam15=sParam15.trim()+sTimeAppend;
				  
				    System.out.println("the  login url ---->"+sLoginUrl);
				    System.out.println("the user name ---->"+sBuddyName);
				    System.out.println("the password---->"+sBuddyPassword);
				
				    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7,sParam15);
				    driver.manage().deleteAllCookies();
				    
				    Thread.sleep(30000);
				    
	                helperMethods.loginIntoMailAndClickOnBeginApp();
				    
				   // commanFunc.refershPage();
				    
				    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
				    
				    helperMethods.clicOnBeginAppAndStartInterview();
			
		    	
				//Verify should display First Slider Page    
			    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
			    Thread.sleep(2000);    
				    
		    	commanFunc.clickOnElement(sliderPage1.yesLnk);
		    	Thread.sleep(2000);
		    	
		    	sliderPage1.explanationTxt.sendKeys(sParam2);
		    	Thread.sleep(3000);
		    	
		    	commanFunc.clickOnElement(sliderPage1.paginationNext);
		    	Thread.sleep(3000);
		    	
		    	//Verify should display Second Slider Page    
		    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    	Thread.sleep(2000);
		    	
		    	commanFunc.clickOnElement(sliderPage1.noLnk);
		    	Thread.sleep(2000);
		    	
		    	//Verify should Remain on same Second Slider Page    
		    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    	Thread.sleep(2000);
		    	
		    	//Click on Next button from 2nd slider page
		    	commanFunc.clickOnElement(sliderPage1.paginationNext);
		    	Thread.sleep(5000);
		    	
		    	//Should display Segmentation page
		    	Assert.assertEquals(true, segmentationPage.pageText.isDisplayed());
		    	
		    	//Click on Next Button on Segmentation page without entering the criteria
		    	commanFunc.clickOnElement(segmentationPage.nextBtn);
		    	Thread.sleep(5000);
		    	
		    	// verify should display the warning dialog with please fill the required fields.
		    	String actualText = sliderPage1.warnignDialogtxt.getText().trim();
		    	helperMethods.verifyString(actualText,"Please fill the *Required fields"); 
		    	
		    	// click on the warning dialog ok button   
		    	commanFunc.clickOnElement(sliderPage1.warnignDialogOkBtn);  	
		    	Thread.sleep(4000);
		    	
		    	
		    	
		    	//Should remain on the Segmentation page
		    	Assert.assertEquals(true, segmentationPage.pageText.isDisplayed());
		    	
		    	//Select Criteria from drop down list
		    	Select inputSclt = new Select(segmentationPage.inputAnserSclt);
		    	inputSclt.selectByValue("0");
		    	Thread.sleep(5000);
		    	
		    	//Click on Previous Button from Segmentation
		    	commanFunc.clickOnElement(segmentationPage.pagePrevBtn);
		    	Thread.sleep(5000);
		    	
		    	//Verify should display Second Slider Page    
		    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    	Thread.sleep(2000);
		    	
		    	//Click on Next button from 2nd slider page
		    	commanFunc.clickOnElement(sliderPage1.paginationNext);
		    	Thread.sleep(10000);
		    	
		    	//Click on Segmentation page and Select drill down option.
		    	helperMethods.clicOnSegmentationAndSelectOption(sParam3);
		    	
		    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
		    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
		    	Thread.sleep(10000);
		    	
		    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
		    	Thread.sleep(2000);
		    	
		    	feedBackPage.feedbackTxt.sendKeys(sParam4.trim()+sTimeAppend);
		    	Thread.sleep(2000);
		    	
		   /* 	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
		    	Thread.sleep(15000);
		    	
		    	//verify should display Company page.
		    	String  actualText = driver.getCurrentUrl();
		    	//public static String companyUrl=StringConstants.url9Lenses;
		    	helperMethods.verifyString(actualText,StringConstants.url9Lenses);
		    	
		    	Assert.assertEquals(true, feedBackPage.companyHomePage.isDisplayed()); */
		    	Assert.assertEquals(true, feedBackPage.feedbackTxt.isDisplayed());
		    	Thread.sleep(2000);
		    	
		    	Assert.assertEquals(true, feedBackPage.feedbackExperience.isDisplayed());
		    	Thread.sleep(2000);
		    	
		    	bRet=feedBackPage.feedbackExperience.isDisplayed();
		    	String actualTxt = feedBackPage.feedbackExperience.getText();
		    	
		    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
		    	
		    	 if(bRet || bRet1){
		    		    sFinalResult = "Pass"; 
		    		   }
		    	 else{
		    		    sFinalResult = "Fail";
		    		   }
		    	
		    	 
		    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
			}
			catch(Exception e)
			{
				logger.info("Error in testcase "+sTestcaseID+"-->"+e);
			}
			finally{
				
				Assert.assertEquals(true,bRet);
				
			}

			
		}
	
	@Test(groups="lenfuncTest")
	public void inSightStartSessionThrowEmailWithotSegmentConfigAndVerifySessionAsCompletedTCINS003(){
			
		//	boolean bRet=false;
			boolean bRet=false;
			boolean bRet1=false;
			
			try{
				
					try
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS003");
						if((TestDataObject==null))
						{
							TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
							bPostControl=false;
						}
						else
						{
							bPostControl=true;
						}
						
					}
					catch(Exception e)
					{
						
						logger.info("Error in selecting testcase id ");
						
					}
					
					setParameterValues(TestDataObject);
				    System.out.println("testcases-->"+sTestcaseID+"<-- started");
				    sParam0=sParam0.trim();
				    sParam1=sParam1.trim();
				    sParam2=sParam2.trim();
				    sParam3=sParam3.trim();
				    sParam4=sParam4.trim();
				    sParam5=sParam5.trim();
				    sParam6=sParam6.trim()+sTimeAppend;
				    sParam7=sParam7.trim()+sTimeAppend;
				    sParam8=sParam8.trim();
				    sParam9=sParam9.trim();
				    sParam10=sParam10.trim();
				    sParam11=sParam11.trim();
				    sParam15=sParam15.trim()+sTimeAppend;
				    
				    System.out.println("the  login url ---->"+sLoginUrl);
				    System.out.println("the user name ---->"+sBuddyName);
				    System.out.println("the password---->"+sBuddyPassword);
				
				 // launching the new session
				    helperMethods.sessionInvitionLaunchNowWithOutSeg(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
				    driver.manage().deleteAllCookies();
				    
				    Thread.sleep(5000);
				    
				    helperMethods.loginIntoMailAndClickOnBeginApp();
				    
				    //commanFunc.refershPage();
				   
				    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
				    
				  
		    	commanFunc.clickOnElement(mailPage.beginTheAppBtn);
		    	Thread.sleep(20000);
		    	
		    	commanFunc.windowSwitch();
		    	
		    	Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
		    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
		    	Thread.sleep(20000);
		    	
		    	//Verify should display First Slider Page    
		    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
		    	Thread.sleep(2000);
		    	
		    	//Click on Yes button in the 1st slider page
		    	commanFunc.clickOnElement(sliderPage1.yesLnk);
		    	Thread.sleep(2000); 
		    	
		    	sliderPage1.explanationTxt.sendKeys(sParam1);
		    	Thread.sleep(2000);
		    	
		    	commanFunc.clickOnElement(sliderPage1.paginationNext);
		    	Thread.sleep(3000);
		    	
		    	//Verify should display Second Slider Page    
		    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    	Thread.sleep(2000);
		    	
		    	commanFunc.clickOnElement(sliderPage1.noLnk);
		    	Thread.sleep(2000);
		    	
		    	commanFunc.clickOnElement(sliderPage1.paginationNext);
		    	Thread.sleep(3000);
		    	
		    	
		    	
		    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
		    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
		    	Thread.sleep(5000);
		    	
		    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
		    	Thread.sleep(2000);
		    	
		    	feedBackPage.feedbackTxt.sendKeys(sParam5.trim());
		    	
		    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
		    	Thread.sleep(10000);
		    	
		    	//Application Issue Page is not displayed in Dev Server
		    	//verify should display Company page.
		    	String  actualText = driver.getCurrentUrl();
		    	helperMethods.verifyString(actualText,StringConstants.url9Lenses);
		    	Thread.sleep(10000);
		    	
		    	//Application Issue Page is not displayed in Dev Server
		    //	Assert.assertEquals(true, feedBackPage.companyHomePage.isDisplayed());   
		    	
		    	// verifying the already session taken pop up
	       	    
		    	helperMethods.loginIntoMailAndClickOnBeginApp();
			    
			  //  commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
				commanFunc.clickOnElement(mailPage.beginTheAppBtn);
		    	Thread.sleep(20000);
		    	
		    	commanFunc.windowSwitch();
		    	
			    String actualTxt1 = beginAppPage.completedTakingApp.getText().trim();
			    System.out.println("the alert text is--->"+actualTxt1);
			    Assert.assertEquals(actualTxt1,"You have already completed taking your Application session.Thank you for sharing your perspective.","Text Not Found");
			        	
		    /*	//Click on Ok Btn
		    	commanFunc.clickOnElement(loginPage.clickOk);
		    	Thread.sleep(7000);
		    	System.out.println("COMPLETED");
		    	
		    	//Verify Application Login page should Display, So that session has been completed
		    	Assert.assertEquals(true, loginPage.usrNameTxt.isDisplayed());
		    	System.out.println("COMPLETED"); */
			    
		    	Assert.assertEquals(true, beginAppPage.completedTakingApp.isDisplayed()); 
		    	
	            Thread.sleep(2000);
		    	
		    	bRet=beginAppPage.completedTakingApp.isDisplayed();
		    	String actualTxt = beginAppPage.completedTakingApp.getText();
		    	
		    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
		    	
		    	 if(bRet || bRet1){
		    		    sFinalResult = "Pass"; 
		    		   }
		    	 else{
		    		    sFinalResult = "Fail";
		    		   }
		    	
		    	 
		    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
			}
			catch(Exception e)
			{
				logger.info("Error in testcase "+sTestcaseID+"-->"+e);
			}
			finally{
				
				Assert.assertEquals(true,bRet);
				
			}
		}  
	
	@Test(groups="lenfuncTest")
	public void inSightSaveAndQuiteSessionTCINS004(){
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		try{
			
				try
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS004");
					if((TestDataObject==null))
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
						bPostControl=false;
					}
					else
					{
						bPostControl=true;
					}
					
				}
				catch(Exception e)
				{
					
					logger.info("Error in selecting testcase id ");
					
				}
				
				setParameterValues(TestDataObject);
				System.out.println("testcases-->"+sTestcaseID+"<-- started");
				 
				    sParam0=sParam0.trim();
				    sParam1=sParam1.trim();
				    sParam2=sParam2.trim();
				    sParam3=sParam3.trim();
				    sParam4=sParam4.trim();
				    sParam5=sParam5.trim();
				    sParam6=sParam6.trim()+sTimeAppend;;
				    sParam7=sParam7.trim()+sTimeAppend;
				    sParam8=sParam8.trim();
				    sParam9=sParam9.trim();
				    sParam10=sParam10.trim();
				    sParam11=sParam11.trim();
				    sParam15=sParam15.trim()+sTimeAppend;
				   
				    System.out.println("the  login url ---->"+sLoginUrl);
				    System.out.println("the user name ---->"+sBuddyName);
				    System.out.println("the password---->"+sBuddyPassword);
				
				    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
				    driver.manage().deleteAllCookies();
				    
				    Thread.sleep(30000);
				    
	                helperMethods.loginIntoMailAndClickOnBeginApp();
				    
			//	    commanFunc.refershPage();
				    
				    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
				    
				    helperMethods.clicOnBeginAppAndStartInterview();
			
		    	
				//Verify should display First Slider Page    
			    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
			    Thread.sleep(2000);    
				    
		    	commanFunc.clickOnElement(sliderPage1.yesLnk);
		    	Thread.sleep(2000);
		    	
		    	
		    	sliderPage1.explanationTxt.sendKeys(sParam2);
		    	
		    	commanFunc.clickOnElement(sliderPage1.paginationNext);
		    	Thread.sleep(5000);
		    	
		    	//Verify should display Second Slider Page    
		    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    	Thread.sleep(2000);
		    	
		    	commanFunc.clickOnElement(sliderPage1.noLnk);
		    	Thread.sleep(2000);
		    	
		    	//Verify should Remain on same Second Slider Page    
		    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    	Thread.sleep(2000);
		    	
	    	 
		    	//click on the save and quite button form the slider page
		    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
		    	Thread.sleep(7000);
		    	
		    	//verify should display Company page.
		    	String  actualText = driver.getCurrentUrl();
		    	//public static String companyUrl=StringConstants.url9Lenses;
		    	helperMethods.verifyString(actualText,StringConstants.url9Lenses);
		    	Thread.sleep(5000);
		    	
		    	//Login in Mail Inbox and click on begin App
		    	helperMethods.loginIntoMailAndClickOnBeginApp();
		    	System.out.println("again login into the email and click on the begin app----------->>>>333333333");
			    commanFunc.refershPage();
	    	
	    	   //Click on Inbox and click on same invitation mail
		    	System.out.println("i am in the click on the begin app and start interview method--------->>>>555555");
		        helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
				
				commanFunc.clickOnElement(mailPage.beginTheAppBtn);
		    	Thread.sleep(15000);
		    	
		    	commanFunc.windowSwitch();
		    	
		    	Assert.assertEquals(true, beginAppPage.continueInterviewBtn.isDisplayed());
		    	commanFunc.clickOnElement(beginAppPage.continueInterviewBtn);
		    	Thread.sleep(7000);
		    	
		    	//verify second diagnostic title should display
		    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
		    	
		    	bRet=sliderPage1.diagnosticTitle.isDisplayed();
		    	
		    	String actualTxt = sliderPage1.diagnosticTitle.getText();
		    	
		    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
		    	
		    	 if(bRet || bRet1){
		    		    sFinalResult = "Pass"; 
		    		   }
		    	 else{
		    		    sFinalResult = "Fail";
		    		   }
		    	
		    	 
		    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
			}
			catch(Exception e)
			{
				logger.info("Error in testcase "+sTestcaseID+"-->"+e);
			}
			finally{
			
				Assert.assertEquals(true,bRet);
			}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightCheckBtnAndInfoDownloadAvaliabeFunctionalityTCINS005(){
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		try{
			
				try
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS005");
					if((TestDataObject==null))
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
						bPostControl=false;
					}
					else
					{
						bPostControl=true;
					}
					
				}
				catch(Exception e)
				{
					
					logger.info("Error in selecting testcase id ");
					
				}
				
				setParameterValues(TestDataObject);
			    System.out.println("testcases-->"+sTestcaseID+"<-- started");
			    sParam0=sParam0.trim();
			    sParam1=sParam1.trim();
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    sParam4=sParam4.trim();
			    sParam5=sParam5.trim();
			    sParam6=sParam6.trim()+sTimeAppend;
			    //sParam6="Auto Test Invi Subj2014-06-24 17:00:33";
			    sParam7=sParam7.trim()+sTimeAppend;
			    sParam8=sParam8.trim();
			    sParam9=sParam9.trim();
			    sParam10=sParam10.trim();
			    sParam11=sParam11.trim();
			    sParam12=sParam12+sTimeAppend;
			    sParam15=sParam15.trim()+sTimeAppend;
			    
			    // launching the new session
			    
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
			    
			    driver.manage().deleteAllCookies();
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp();
			    
			    Thread.sleep(60000);
			    
			  //  commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview();
			    
			    // verify first slider page should display
			    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
			    
			    //Click on skip button on 1st Slider Page
	    	commanFunc.clickOnElement(sliderPage1.skipNotClearLnk);
	    	Thread.sleep(7000);
	    	
	    	// verify should display second slider page.
	    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	//click on the previous button from the current slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationPrev);
	    	Thread.sleep(5000);
	    	
	    	// verify should display first slider page should.
		    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
		    
		  //Click on Info Download Option
		    commanFunc.clickOnElement(sliderPage1.infoDownloadBtn);
	    	Thread.sleep(7000);
		    
		  //Verify should display BeginApp Page Text2.
	    	Assert.assertEquals(true,sliderPage1.infoDownloadPopUp.isDisplayed()); 
	    	Thread.sleep(2000);
		    
	    	//Click on Close Btn on Info Download Pop Up Window
		    commanFunc.clickOnElement(sliderPage1.infoDownloadClosePopUp);
	    	Thread.sleep(7000);
	    	
	    	// verify should display first slider page should.
		    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
		    bRet=sliderPage1.infoDownloadBtn.isDisplayed();
	    	
	    	String actualTxt = sliderPage1.infoDownloadBtn.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
		
	}
	
	@Test(groups="lenfuncTest")
	public void inSightSliderPageVerifyPART2EntitiesTCINS008(){
		           // boolean bRet=false;
		            boolean bRet=false;
		    		boolean bRet1=false;
		            
					try{
						
						
						
							try
							{
								TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS008");
								if((TestDataObject==null))
								{
									TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
									bPostControl=false;
								}
								else
								{
									bPostControl=true;
								}
								
							}
							catch(Exception e)
							{
								
								logger.info("Error in selecting testcase id ");
								
							}
							
							setParameterValues(TestDataObject);
						    System.out.println("testcases-->"+sTestcaseID+"<-- started");
						    sParam0=sParam0.trim();
						    sParam1=sParam1.trim();
						    sParam2=sParam2.trim();
						    sParam3=sParam3.trim();
						    sParam4=sParam4.trim();
						    sParam5=sParam5.trim();
						    sParam6=sParam6.trim()+sTimeAppend;;
						    sParam7=sParam7.trim()+sTimeAppend;
						    sParam8=sParam8.trim();
						    sParam9=sParam9.trim();
						    sParam10=sParam10.trim();
						    sParam11=sParam11.trim();
						    sParam12=sParam12+sTimeAppend;
						    sParam15=sParam15.trim()+sTimeAppend;
						    // launching the new session
						    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
						    driver.manage().deleteAllCookies();
						    
						    helperMethods.loginIntoMailAndClickOnBeginApp();
						    
						    Thread.sleep(60000);
						    
						//    commanFunc.refershPage();
						    
						    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
						    
						    helperMethods.clicOnBeginAppAndStartInterview();
				
						    
						//Verify should display First Slider Page    
				    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
				    	
				    	//Click on Yes button in the 1st slider page
				    	commanFunc.clickOnElement(sliderPage1.yesLnk);
				    	Thread.sleep(3000);
				    		    	
				    	//verify should display '1-9 Rating Scale' Field in Slider page
				    	Assert.assertEquals(true, sliderPage1.scaleMeter1to9.isDisplayed());
				    	
				    	//verify should display 'Explanation' Text in Slider page
				    	Assert.assertEquals(true, sliderPage1.explanationTxt.isDisplayed());
				    		
				    	//verify should display 'Comment Text' in Slider page
				    	Assert.assertEquals(true, sliderPage1.commentTxt.isDisplayed());
				   
				    	//verify should display 'action Txt' in Slider page
				    	Assert.assertEquals(true, sliderPage1.actionTxt.isDisplayed());
				    	
				    	//verify should display 'Gaps Option' in Slider page
				    	Assert.assertEquals(true, sliderPage1.gapOption.isDisplayed());
				    	
				    	//verify should display 'StrengthsChallenges' Options in Slider page
				    	Assert.assertEquals(true, sliderPage1.strengthsChallengesOptions.isDisplayed());
				    	
				    	
				    	//verify should display 'PollingField' Options in Slider page
				    	Assert.assertEquals(true, sliderPage1.pollingField.isDisplayed());
				    	Thread.sleep(3000);
				    	
				    	//verify should display 'PollingFieldName' Options in Slider page
				    	Assert.assertEquals(true, sliderPage1.pollingFieldName.isDisplayed());
				    	Thread.sleep(3000);
				    	
				    //	bRet=sliderPage1.pollingField.isDisplayed();
				    	 bRet=sliderPage1.pollingFieldName.isDisplayed();
					    	
					    	String actualTxt = sliderPage1.pollingFieldName.getText();
					    	
					    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
					    	
					    	 if(bRet || bRet1){
					    		    sFinalResult = "Pass"; 
					    		   }
					    	 else{
					    		    sFinalResult = "Fail";
					    		   }
					    	
					    	 
					    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
						}
						catch(Exception e)
						{
							logger.info("Error in testcase "+sTestcaseID+"-->"+e);
					}
					finally{
						
						Assert.assertEquals(true,bRet);
						
					} 
	}
	
	@Test(groups="lenfuncTest")
	public void inSightSliderPageEnterDataintoPART2EntitiesTCINS009(){
					
	//	boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
					try{				
						
						
							try
							{
								TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS009");
								if((TestDataObject==null))
								{
									TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
									bPostControl=false;
								}
								else
								{
									bPostControl=true;
								}
								
							}
							catch(Exception e)
							{
								
								logger.info("Error in selecting testcase id ");
								
							}
							
							setParameterValues(TestDataObject);
						    System.out.println("testcases-->"+sTestcaseID+"<-- started");
						    sParam0=sParam0.trim();
						    sParam1=sParam1.trim();
						    sParam2=sParam2.trim();
						    sParam3=sParam3.trim();
						    sParam4=sParam4.trim();
						    sParam5=sParam5.trim();
						    sParam6=sParam6.trim()+sTimeAppend;;
						    sParam7=sParam7.trim()+sTimeAppend;
						    sParam8=sParam8.trim();
						    sParam9=sParam9.trim();
						    sParam10=sParam10.trim();
						    sParam11=sParam11.trim();
						    sParam12=sParam12+sTimeAppend;
						    sParam13=sParam13.trim();
						    sParam15=sParam15+sTimeAppend;
						    // launching the new session
						    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
						    driver.manage().deleteAllCookies();
						    
						    helperMethods.loginIntoMailAndClickOnBeginApp();
						    
						    Thread.sleep(30000);
						    
						    //commanFunc.refershPage();
						    
						    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
						    
						    helperMethods.clicOnBeginAppAndStartInterview();
				
						    
						//Verify should display First Slider Page    
				    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
				    	
				    	//Click on Yes button in the 1st slider page
				    	commanFunc.clickOnElement(sliderPage1.yesLnk);
				    	Thread.sleep(3000); 
				    	
				    	//Click on 1st Slider row radio button(1-9 Rating Scale) in the 1st slider page
				    	commanFunc.clickOnElement(sliderPage1.sliderScale1UnChk);
				    	Thread.sleep(3000);
				    	//getting the attribute value from the selected check box    	
				    	String Rad1chk = sliderPage1.sliderScale1Chk.getAttribute("class");
				    	//verifying the check box is selected or not
				    	helperMethods.verifyString(Rad1chk.toString(),"rad-checked");
				    	 
				    	
				    	//Click on 5th Slider row radio button(1-9 Rating Scale) in the 1st slider page
				    	commanFunc.clickOnElement(sliderPage1.sliderScale5UnChk);
				    	Thread.sleep(3000);
				    	//getting the attribute value from the selected check box    	
				    	String Rad5chk = sliderPage1.sliderScale5Chk.getAttribute("class");
				    	//verifying the check box is selected or not
				    	helperMethods.verifyString(Rad5chk.toString(),"rad-checked");
				    	 
				    	
				    	//verify 1st Slider row radio button(1-9 Rating Scale) in slider page is unchecked or not
				    	//getting the attribute value from the 1st check box    	
				    	String Rad1unchk = sliderPage1.sliderScale1UnChk.getAttribute("class"); 
				    	//verifying the check box is selected or not
				    	helperMethods.verifyString(Rad1unchk.toString(),"rad-unchecked");
				    	 
				    	
				    	//Click on 9th Slider row radio button(1-9 Rating Scale) in the 1st slider page
				    	commanFunc.clickOnElement(sliderPage1.sliderScale9UnChk);
				    	Thread.sleep(3000);    	
				    	//getting the attribute value from the selected check box    	
				    	String Rad8chk = sliderPage1.sliderScale9Chk.getAttribute("class");
				    	//verifying the check box is selected or not
				    	helperMethods.verifyString(Rad8chk.toString(),"rad-checked");
				    	 
				    	
				    	 //	verify 5th Slider row radio button(1-9 Rating Scale) in slider page is unchecked or not
				    	//getting the attribute value from the 1st check box    	
				    	String Rad5unchk = sliderPage1.sliderScale5UnChk.getAttribute("class"); 
				    	//verifying the check box is selected or not
				    	helperMethods.verifyString(Rad5unchk.toString(),"rad-unchecked");
				    	
				    	
				
				    	//Enter Txt into 'Explanation' Text box in Slider page 
				    	sliderPage1.explanationTxt.sendKeys(sParam13);
				    	Thread.sleep(3000);
				    	//verify user can enter text in 'Explanation' Text box in Slider page  
				    	Assert.assertEquals("627 characters left.",sliderPage1.explainationCharLeft.getText());
				    	
				    	
				    	//Update document in Explanation field
				    	//commanFunc.clickOnElement(sliderPage1.uploadExplanationTxt);
				    	//sliderPage1.uploadExplanationTxt.sendKeys("C:\\9Lenses VPN Access Server.pdf");
				    	//sliderPage1.uploadExplanationTxt.sendKeys("C:\\9LensesVPNAccessServer.pdf");
				    	//Thread.sleep(7000);
				    	
				    	
				    	//Enter Txt into 'Comment' Text box in Slider page 
				    	sliderPage1.commentTxt.sendKeys(sParam13);
				    	Thread.sleep(3000);
				    	//verify user can enter text in 'Comment' Text box in Slider page  
				    	Assert.assertEquals("627 characters left.",sliderPage1.commentCharLeft.getText());

				    	
				    	//Enter Txt into 'Action' Text box in Slider page 
				    	sliderPage1.actionTxt.sendKeys(sParam13);
				    	Thread.sleep(3000);
				    	//verify user can enter text in 'Action' Text box in Slider page  
				    	Assert.assertEquals("627 characters left.",sliderPage1.actionCharLeft.getText());
				    	Thread.sleep(3000);
				    	
				    	//Click on Strength up arrow key
				    	commanFunc.clickOnElement(sliderPage1.strengthUpArrow);
				    	Thread.sleep(3000);
				    	
				    	//Verify whether the remaining count as been decreased or not
				    	Assert.assertEquals("9",sliderPage1.strengthRemain.getText());
				    	
				    	
				    	//Click on Strength Down arrow key
				    	commanFunc.clickOnElement(sliderPage1.strengthDownArrow);
				    	Thread.sleep(3000);
				    	
				    	//Verify whether the remaining count as been increased or not
				    	Assert.assertEquals("10",sliderPage1.strengthRemain.getText());
				    	
				    	//Click on Challenge up arrow keygetText()
				    	commanFunc.clickOnElement(sliderPage1.challengeUpArrow);
				    	Thread.sleep(3000);
				    	
				    	//Verify whether the remaining count as been decreased or not
				    	Assert.assertEquals("9",sliderPage1.challengeRemain.getText());
				    	
				    	
				    	//Click on Challenge Down arrow key
				    	commanFunc.clickOnElement(sliderPage1.challengeDownArrow);
				    	Thread.sleep(3000);
				    	
				    	//Verify whether the remaining count as been increased or not
				    	Assert.assertEquals("10",sliderPage1.challengeRemain.getText());
				    	
				       //Click on Gaps 1st(Organizational communication is needed around this topic area) option in slider page
				    	commanFunc.clickOnElement(sliderPage1.communicationGapsUncheck);
				    	Thread.sleep(3000);
				    	//getting the attribute value from the selected check box    	
				    	String Radchk = sliderPage1.communicationGapsCheck.getAttribute("class");
				    	//verifying the check box is selected or not
				    	helperMethods.verifyString(Radchk.toString(),"chk-checked");
				    	
				    	//Click on Gaps 2nd(Organizational training is needed around this topic area) option in slider page
				    	commanFunc.clickOnElement(sliderPage1.communicationGapsUncheck);
				    	Thread.sleep(3000);
				    	//getting the attribute value from the selected check box    	
				    	String gaps2 = sliderPage1.communicationGaps2Check.getAttribute("class");
				    	//verifying the check box is selected or not
				    	helperMethods.verifyString(gaps2.toString(),"chk-checked");
				    	
				    	
				    	//Click on Gaps 3rd(Help needed around this topic area) option in slider page
				    	commanFunc.clickOnElement(sliderPage1.communicationGapsUncheck);
				    	Thread.sleep(3000);
				    	//getting the attribute value from the selected check box   	
				    	String gaps3 = sliderPage1.communicationGaps3Check.getAttribute("class");
				    	//verifying the check box is selected or not
				    	helperMethods.verifyString(gaps3.toString(),"chk-checked");
				    	
				    	//Click on Gaps 1st(Organizational communication is needed around this topic area) Un-check option in slider page
				    	commanFunc.clickOnElement(sliderPage1.communicationGapsCheck);
				    	Thread.sleep(3000);
				    	// getting the attribute value from the selected check box
				    	String Radchk2 = sliderPage1.communicationGapsUncheck.getAttribute("class");
				    	//verifying the check box should checked
				    	helperMethods.verifyString(Radchk2.toString(),"chk-unchecked");
				    	
				    	//Click on Gaps 2nd(Organizational communication is needed around this topic area) Un-check option in slider page
				    	commanFunc.clickOnElement(sliderPage1.communicationGapsCheck);
				    	Thread.sleep(3000);
				    	// getting the attribute value from the selected check box
				    	String gapsuncheck2 = sliderPage1.communicationGaps2Uncheck.getAttribute("class");
				    	//verifying the check box should checked
				    	helperMethods.verifyString(gapsuncheck2.toString(),"chk-unchecked");
				    	
				    	
				    	//Click on Gaps 3rd(Help is needed around this topic area) Un-check option in slider page
				    	commanFunc.clickOnElement(sliderPage1.communicationGapsCheck);
				    	Thread.sleep(3000);
				    	// getting the attribute value from the selected check box
				    	String gapsuncheck3 = sliderPage1.communicationGaps3Uncheck.getAttribute("class");
				    	//verifying the check box should checked
				    	helperMethods.verifyString(gapsuncheck3.toString(),"chk-unchecked");
				    	
				    	
				    	//Click on polling Field in the 1st slider page
				    	commanFunc.clickOnElement(sliderPage1.pollingYesUnChk);
				    	Thread.sleep(3000);
				    	
				    	
				    	//Click on Next button in the 1st slider page
				    	commanFunc.clickOnElement(sliderPage1.paginationNext);
				    	Thread.sleep(5000);
				    	
				    	//Verify should display Second Slider Page    
				    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
				    	Thread.sleep(5000);
				    	
				    	bRet=sliderPage1.diagnosticTitle.isDisplayed();
				    	
				    	String actualTxt = sliderPage1.diagnosticTitle.getText();
				    	
				    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
				    	
				    	 if(bRet || bRet1){
				    		    sFinalResult = "Pass"; 
				    		   }
				    	 else{
				    		    sFinalResult = "Fail";
				    		   }
				    	
				    	 
				    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
					}
					catch(Exception e)
					{
						logger.info("Error in testcase "+sTestcaseID+"-->"+e);
					}
					finally{
						
						Assert.assertEquals(true,bRet);
						
					}
				}
	
	@Test(groups="lenfuncTest")
	public void inSightStartSessionThrowEmailCheckToEnterRequiedFieldsTCINS010(){
		
	//	boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
			
			
			
				try
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS010");
					if((TestDataObject==null))
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
						bPostControl=false;
					}
					else
					{
						bPostControl=true;
					}
					
				}
				catch(Exception e)
				{
					
					logger.info("Error in selecting testcase id ");
					
				}
				
				setParameterValues(TestDataObject);
			    System.out.println("testcases-->"+sTestcaseID+"<-- started");
			    sParam0=sParam0.trim();
			    sParam1=sParam1.trim();
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    sParam4=sParam4.trim();
			    sParam5=sParam5.trim();
			    sParam6=sParam6.trim()+sTimeAppend;
			    //sParam6="Auto Test Invi Subj2014-06-24 17:00:33";
			    sParam7=sParam7.trim()+sTimeAppend;
			    sParam8=sParam8.trim();
			    sParam9=sParam9.trim();
			    sParam10=sParam10.trim();
			    sParam11=sParam11.trim();
			    sParam12=sParam12+sTimeAppend;
			    sParam15=sParam15.trim()+sTimeAppend;
			    
			    // launching the new session
			    
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
			    
			    driver.manage().deleteAllCookies();
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp();
			    
			    Thread.sleep(10000);
			    
			//    commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			   
			    helperMethods.clicOnBeginAppAndStartInterview();
			    
			    // verify first slider page should display
			    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
			    
			    // click on the yes link from the slider page
		    	commanFunc.clickOnElement(sliderPage1.yesLnk);
		    	Thread.sleep(2000);
		    	
			 // click on the next button from the slider page   
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(4000);
	    	
	    	// verify should display the warning dialog with please fill the required fields.
	    	String actualText = sliderPage1.warnignDialogtxt.getText().trim();
	    	helperMethods.verifyString(actualText,"Please fill the *Required fields"); 
	    	
	    	// click on the warning dialog ok button   
	    	commanFunc.clickOnElement(sliderPage1.warnignDialogOkBtn);  	
	    	Thread.sleep(4000);
	    	
	    	
	    	// verify first slider page should display
		    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
		    
		    // click on the yes link from the slider page
	    	//commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	//Thread.sleep(2000);
	    	
		 // click on the next button from the slider page   
    	commanFunc.clickOnElement(sliderPage1.paginationNext);
    	Thread.sleep(4000);
	    	
	    	
            bRet=sliderPage1.warnignDialogtxt.isDisplayed();
	    	
	    	String actualTxt = sliderPage1.warnignDialogtxt.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEngineLoginAsValidUserFromApplicationToStartSessionTCINS011()
	{
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS011");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim()+sTimeAppend;
		    sParam12=sParam12.trim();
		    sParam13 = sParam13.trim()+sTimeAppend;
		    sParam14 = sParam14.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		   
		    helperMethods.loginAsValidUser(sLoginUrl, sBuddyName, sBuddyPassword);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(10000);
	    
		    helperMethods.clicOnBeginAppAndStartInterview();
	    		    
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    	
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.explanationTxt.isDisplayed());
        	
	    	// enter the text into the comment text box
	    	sliderPage1.explanationTxt.sendKeys(sParam11);
	    	
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(3000);
	    	    	
	    	//verify should remain in the same page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the next pagination button form the 2nd slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	helperMethods.clicOnSegmentationAndSelectOption(sParam3);
	    	
	    	//verify should display previous slider[1 slider]page collapsed state
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	//click on the submit button form the review page
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	   
	    	//verify should display feedback page
	    	Assert.assertEquals(true, feedBackPage.feedbackTxt.isDisplayed());
	    	//click on the Excellent radio button from the feedback page
	    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
	    	Thread.sleep(2000);
	    	//Enter Text on FeedBack Test box
	    	feedBackPage.feedbackTxt.sendKeys(sParam13);
	    	//Click on Submit button from the feedback page
	    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
	    	Thread.sleep(60000);
	    
	    	//verify should display feedback page
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	
            bRet=newSessionPage.myAppsMainTab.isDisplayed();
	    	
	    	String actualTxt = newSessionPage.myAppsMainTab.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	//////////////@Test(groups="lenfuncTest")         ("This scenario not present in the latest Insight Engine")
	public void inSightEngineLoginAsValidUserFromApplicationTCINS012()
	{
		boolean bRet=false;
		boolean bRet1=false;
		boolean bRet2=false;
		boolean bRet3=false;
		String interID=null;
		String content=null;
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS012");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim()+sTimeAppend;
		    sParam12=sParam12.trim();
		    sParam13 = sParam13.trim()+sTimeAppend;
		    sParam14 = sParam14.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		    Thread.sleep(7000);
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    Thread.sleep(7000);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		   // helperMethods.loginAsValidUser(sLoginUrl, sBuddyName, sBuddyPassword);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(7000);
	    
		    helperMethods.clicOnBeginAppAndStartInterview();
	    		    
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.explanationTxt.isDisplayed());
	    	// enter the text into the explanation text box
	    	sliderPage1.explanationTxt.sendKeys(sParam11);
	    	
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the no button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(3000);
	    	    	
	    	//verify should remain in the same page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the next pagination button form the 2nd slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//Click on Segmentation page and Select drill down option.
	    	helperMethods.clicOnSegmentationAndSelectOption(sParam3);
	    	
	    	//verify should display reView page 
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	
	   /* 	//Click on Go Back Button on REview Page
	    	commanFunc.clickOnElement(sliderPage1.goBackFromReview);
	    	Thread.sleep(7000);
	    	
	    	//verify should display previous slider[2 slider]page collapsed state
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
	    	//click on the next pagination button form the 2nd slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//Click on Segmentation page and Select drill down option.
	    	helperMethods.clicOnSegmentationAndSelectOption(sParam3);
	    	
	    	//verify should display reView page 
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed()); */
	    	
	    	String actualTxt = insightReviewPage.insightReviewThanksLbl.getText().trim();
	    	// verifying the text from the insight review page
	    	helperMethods.verifyString(actualTxt, conts.insightReviewPageText);

		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	@Test(groups="lenfuncTest")
	public void inSightStartSessionFromApplicationCheckAllButtonsAndVerifyHelpOptionFromEntitiesAndCompleteTCINS013()
	{
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS013");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim()+sTimeAppend;
		    sParam12=sParam12.trim();
		    sParam13 = sParam13.trim();
		    sParam14 = sParam14.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		   
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    Thread.sleep(5000);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		   
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(10000);
	    
		    helperMethods.clicOnBeginAppAndStartInterview();
	    		    
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.explanationTxt.isDisplayed());
	    	// enter the text into the comment text box
	    	sliderPage1.explanationTxt.sendKeys(sParam11);
	    	
	    	//Verify Help option(What is this?) is present in the Strength and Challenge entities
	    	Assert.assertEquals(true, sliderPage1.helpStrengthChallenge.isDisplayed());
	    	
	    	//Click on Help option
	    	commanFunc.clickOnElement(sliderPage1.helpStrengthChallenge);
	    	Thread.sleep(3000);
	    	
	    	//Should display Help Popup window
	    	Assert.assertEquals(true, sliderPage1.helpStrengthChallengePopUp.isDisplayed());
	    	
	    	//Should display Strength Votes text in Help Popup window
	    	Assert.assertEquals(true, sliderPage1.helpStrengthVotes.isDisplayed());
	    	
	    	//Should display Challenge Votes text in Help Popup window
	    	Assert.assertEquals(true, sliderPage1.helpChallengeVotes.isDisplayed());
	    	
	    	//Should display Votes text in Help Popup window
	    	Assert.assertEquals(true, sliderPage1.helpStrengthChallengeVotes.isDisplayed());
	    	
	    	//Should display "Got It, Return to Interview" text in Help Popup window
	    	Assert.assertEquals(true, sliderPage1.helpReturnToInterview.isDisplayed());
	    	
	    	//Click on "Got It, Return to Interview" Button
	    	commanFunc.clickOnElement(sliderPage1.helpReturnToInterview);
	    	Thread.sleep(3000);
	    	
	    	//verify Current Slider page should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(3000);
	    	    	
	    	//verify should remain in the same page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the next pagination button form the 2nd slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//Select options from Segmentation page
	    	helperMethods.clicOnSegmentationAndSelectOption(sParam3);
	    	
	    	//verify should display previous slider[1 slider]page collapsed state
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	//click on the submit button form the review page
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	   
	    	//verify should display feedback page
	    	Assert.assertEquals(true, feedBackPage.optionalFeedbackLbl.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.excellentRadioBtn.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.averageRadioBtn.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.poorRadioBtn.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.feedbackTxt.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.skipLnk.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.feedbackSubmitBtn.isDisplayed());
	    	//click on the yes button from the exit dialog
	    	commanFunc.clickOnElement(feedBackPage.skipLnk);
	    	Thread.sleep(90000);
	    	//verify should display my apps page.
	    	//verify should display feedback page
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	
            bRet=newSessionPage.myAppsMainTab.isDisplayed();
	    	
	    	String actualTxt = newSessionPage.myAppsMainTab.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEngineInsightSessionFromApplicationAndSubmitTCINS014()
	{
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS014");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim()+sTimeAppend;
		    sParam12=sParam12.trim();
		    sParam13 = sParam13.trim();
		    sParam14 = sParam14.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		   
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    Thread.sleep(5000);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(10000);
	    
		    helperMethods.clicOnBeginAppAndStartInterview();
	    		    
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    		    
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.explanationTxt.isDisplayed());
	    	// enter the text into the comment text box
	    	sliderPage1.explanationTxt.sendKeys(sParam11);
	    	
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
	    	//verify skip ,yes and no links should display in the second slider page
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(3000);	    
	    	
	    	//verify should remain in the same page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the next pagination button form the 2nd slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//Select options from Segmentation page
	    	helperMethods.clicOnSegmentationAndSelectOption(sParam3);
	    	
	    	//verify should display previous slider[1 slider]page collapsed state
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	//click on the submit button form the review page
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	   
	    	//verify should display feedback page
	    	Assert.assertEquals(true, feedBackPage.optionalFeedbackLbl.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.excellentRadioBtn.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.averageRadioBtn.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.poorRadioBtn.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.feedbackTxt.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.skipLnk.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.feedbackSubmitBtn.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.feedbackExperience.isDisplayed());
	    	Assert.assertEquals(true, feedBackPage.feedbackInterviewEngine.isDisplayed());
	    	
	    	//click on the Excellent radio button from the feedback page
	    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
	    	Thread.sleep(2000);
	    	
	    	//Enter Text on FeedBack Test box
	    	feedBackPage.feedbackTxt.sendKeys(sParam13);
	    	//Click on Submit button from the feedback page
	    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
	    	Thread.sleep(90000);
	    	
	    	//verify should display my apps page.
            Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	
            bRet=newSessionPage.myAppsMainTab.isDisplayed();
	    	
	    	String actualTxt = newSessionPage.myAppsMainTab.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEnginePollingTCINS015()
	{
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS015");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    Thread.sleep(10000);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(10000);
		    //verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(9000);
	    	
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	
	    	//click on the 1 polling yes check box  from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.pollingChkY);
	    	Thread.sleep(3000);
	    	
	    	//getting the attribute value from the selected check box    	
	    	String pollingYtext = sliderPage1.divPollingYChk.getAttribute("class");
	    	//verifying the check box is selected or not
	    	helperMethods.verifyString(pollingYtext.toString(),"chk-checked");
	    	
	    	//click on the 1 polling No check box  from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.pollingChkN);
	    	Thread.sleep(3000);
	    	//getting the attribute value from the selected check box    	
	    	String pollingNtext = sliderPage1.divPollingNChk.getAttribute("class");
	    	//verifying the check box must be checked    	
	    	helperMethods.verifyString(pollingNtext.toString(),"chk-checked");
	    	
	    	//click on the 2nd polling yes check box  from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.pollingChkY2);
	    	Thread.sleep(2000);
	    	// getting the attribute value from the selected 2nd yes check box
	    	String pollingYtext2 = sliderPage1.divPollingYChk2.getAttribute("class");
	    	//verifying the check box should checked
	    	helperMethods.verifyString(pollingYtext2.toString(),"chk-checked");
	    	
	    	//click on the 2nd polling No check box  from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.pollingChkN2);
	    	Thread.sleep(2000);
	    	// getting the attribute value from the selected check box
	    	String pollingNtext2 = sliderPage1.divPollingChkN2.getAttribute("class");
	    	//verifying the check box should checked
	    	helperMethods.verifyString(pollingNtext2.toString(),"chk-checked");
	    	
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
            bRet=sliderPage1.diagnosticTitle.isDisplayed();
	    	
	    	String actualTxt = sliderPage1.diagnosticTitle.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	////////@Test(groups="lenfuncTest") [Review option is not present in the Application]
	public void inSightEngineWithoutStrenthAndChallengesTCINS016()
	{
		boolean bRet=false;
		boolean bRet1=false;
		boolean bRet2=false;
		boolean bRet3=false;
		String interID=null;
		String content=null;
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS016");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		    ///helperMethods.loginAsValidUser(sLoginUrl, sBuddyName, sBuddyPassword);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(7000);
		    //verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(9000);
	    	
	    	//verify should display startGivingResponce Button and clicking on it.
	    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
	    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
	    	Thread.sleep(7000);
	    	
	    	//verify should display segmentation Page Button and select the option from the drop down list.
	    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
	    	Select inputSclt = new Select(segmentationPage.inputAnserSclt);
	    	inputSclt.selectByVisibleText(sParam8);
	    	Thread.sleep(3000);
	    	
	    	//click on the next Button from the segmention page
	    	commanFunc.clickOnElement(segmentationPage.nextBtn);
	    	Thread.sleep(9000);
	    	
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    	// filling data in the comment text box from the details page
	    	sliderPage1.commentTxt.sendKeys(sParam8);
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the no link from the second slider page
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//verify should display insight review page
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	commanFunc.clickOnElement(insightReviewPage.topicAreaLnk);
	    	Thread.sleep(9000);
	    	
	    	//verify first and  second diagnostic title should display int pop up 
	    	System.out.println("the first question from the pop up---->"+insightReviewPage.firstQues.getText());
	    	Assert.assertEquals(insightReviewPage.firstQues.getText(),sParam9,"first Diagnostic Title Not Found in the pop up");
	    	Assert.assertEquals(insightReviewPage.secQues.getText(),sParam10,"second Diagnostic Title Not Found in the pop up");
	    	System.out.println("the second question from the pop up---->"+insightReviewPage.secQues.getText());
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	////////@Test(groups="lenfuncTest") [Review option is not present in the Application]
	public void inSightEngineWithoutGapsTCINS017()
	{
		boolean bRet=false;
		boolean bRet1=false;
		boolean bRet2=false;
		boolean bRet3=false;
		String interID=null;
		String content=null;
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS017");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7,sParam15);
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		    ///helperMethods.loginAsValidUser(sLoginUrl, sBuddyName, sBuddyPassword);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(7000);
		    //verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(9000);
	    	
	    	//verify should display startGivingResponce Button and clicking on it.
	    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
	    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
	    	Thread.sleep(7000);
	    	
	    	//verify should display segmentation Page Button and select the option from the drop down list.
	    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
	    	Select inputSclt = new Select(segmentationPage.inputAnserSclt);
	    	inputSclt.selectByVisibleText(sParam8);
	    	Thread.sleep(3000);
	    	
	    	//click on the next Button from the segmention page
	    	commanFunc.clickOnElement(segmentationPage.nextBtn);
	    	Thread.sleep(9000);
	    	
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    	// filling data in the comment text box from the details page
	    	sliderPage1.commentTxt.sendKeys(sParam8);
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the no link from the second slider page
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//verify should display insight review page
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	commanFunc.clickOnElement(insightReviewPage.topicAreaLnk);
	    	Thread.sleep(9000);
	    	
	    	//verify first and  second diagnostic title should display int pop up 
	    	System.out.println("the first question from the pop up---->"+insightReviewPage.firstQues.getText());
	    	Assert.assertEquals(insightReviewPage.firstQues.getText(),sParam9,"first Diagnostic Title Not Found in the pop up");
	    	Assert.assertEquals(insightReviewPage.secQues.getText(),sParam10,"second Diagnostic Title Not Found in the pop up");
	    	System.out.println("the second question from the pop up---->"+insightReviewPage.secQues.getText());
	    	
	    	// need to add the gaps validation
	    	
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}

	@Test(groups="lenfuncTest")  
	public void inSightEngineCollapsedStateTCINS018()
	{
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS018");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    Thread.sleep(10000);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(60000);
		    //verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(60000);
	    	
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.explanationTxt.isDisplayed());
	    	
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.skipNotClearLnk);
	    	
	    	Thread.sleep(5000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
	    	//click on the previous pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationPrev);
	    	
	    	Thread.sleep(5000);
	    	
	    	//verify should display previous slider[1 slider]page collapsed state
	    	Assert.assertEquals(true, !sliderPage1.explanationTxt.isDisplayed());
	    	
            bRet=sliderPage1.diagnosticTitle.isDisplayed();
	    	
	    	String actualTxt = sliderPage1.diagnosticTitle.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEngineCollapsedStateTCINS019()
	{
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS019");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		    // clicking on myAppsMain Tab from the session list page
		    Thread.sleep(5000);
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    Thread.sleep(30000);
		   
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(60000);
		    //verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(30000);
	   
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    		    
	    		//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(5000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
	    	Thread.sleep(60000);
	    	
	    	//verify should display my apps page
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(newSessionPage.continueAsessionTab);
	    	Thread.sleep(15000);
	    	
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(inProgressSessionListPage.continueTab);
	    	Thread.sleep(15000);
	    	
	    	//verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.continueInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.continueInterviewBtn);
	    	Thread.sleep(15000);
	    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
            bRet=sliderPage1.diagnosticTitle.isDisplayed();
	    	
	    	String actualTxt = sliderPage1.diagnosticTitle.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEngineExpandedStateTCINS020()
	{
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS020");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		    // clicking on myAppsMain Tab from the session list page
		    Thread.sleep(5000);
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    Thread.sleep(15000);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(30000);
		    //verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(20000);
	   
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    		    
	    		//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(5000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(3000);
	    	
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
	    	Thread.sleep(60000);
	    	
	    	//verify should display my apps page
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(newSessionPage.continueAsessionTab);
	    	Thread.sleep(7000);
	    	
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(inProgressSessionListPage.continueTab);
	    	Thread.sleep(7000);
	    	
	    	//verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.continueInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.continueInterviewBtn);
	    	Thread.sleep(9000);
	 
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//verify should display expanded state 
		    Assert.assertEquals(true, sliderPage1.explanationTxt.isDisplayed());
		    
		    //Verify Polling Name is displayed
		    Assert.assertEquals(true, sliderPage1.pollingFieldName.isDisplayed());
		    
            bRet=sliderPage1.pollingFieldName.isDisplayed();
	    	
	    	String actualTxt = sliderPage1.pollingFieldName.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEngineAppPresentInRelvantTabTCINS021()
	{
		boolean bRet=false;
		boolean bRet1=false;
		boolean bRet2=false;
		boolean bRet3=false;
		String interID=null;
		String content=null;
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS021");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		    // clicking on myAppsMain Tab from the session list page
		    Thread.sleep(15000);
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    Thread.sleep(15000);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(30000);
		    //verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(15000);
	 
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    		    
	    		//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(5000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
	    	//click on yes button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(3000);
	    	
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
	    	Thread.sleep(7000);
	    	
	    	//verify should display my apps page
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(newSessionPage.continueAsessionTab);
	    	Thread.sleep(7000);
	    	
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(inProgressSessionListPage.inProgressAppsName);
	    	Thread.sleep(7000);
	    	
	    	String inProgressApp = inProgressSessionListPage.inProgressAppsName.getText().toString();
	    	// verify in complete app should be displayed in the in progress app list.
	    	helperMethods.verifyString(inProgressApp,sParam0);

	    	//verify should display my apps page.
            Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	
            bRet=newSessionPage.myAppsMainTab.isDisplayed();
	    	
	    	String actualTxt = newSessionPage.myAppsMainTab.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	////////@Test(groups="lenfuncTest")                 [Progress Bar option is not present so skip the script]
	public void inSightEngineProgressBarTCINS022()
	{
		boolean bRet=false;
		boolean bRet1=false;
		boolean bRet2=false;
		boolean bRet3=false;
		String interID=null;
		String content=null;
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS022");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		    //helperMethods.loginAsValidUser(sLoginUrl, sBuddyName, sBuddyPassword);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(7000);
		    //verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(9000);
	    	
	    	//verify should display startGivingResponce Button and clicking on it.
	    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
	    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
	    	Thread.sleep(7000);
	    	
	    	//verify should display segmentation Page Button and select the option from the drop down list.
	    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
	    	Select inputSclt = new Select(segmentationPage.inputAnserSclt);
	    	inputSclt.selectByVisibleText(sParam8);
	    	Thread.sleep(3000);
	    	
	    	//click on the next Button from the segmention page
	    	commanFunc.clickOnElement(segmentationPage.nextBtn);
	    	Thread.sleep(9000);
	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	
	    	String fistSliderProgressBarTxt = sliderPage1.progressBarPercentage.getText().trim();
	    	//verify in first slider page should display 0% progress bar
	    	helperMethods.verifyProgressBar(fistSliderProgressBarTxt,"0%");
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	//verify second diagnostic title should display and slider page should display 33% progress bar
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
	    	String secSliderProgressBarTxt = sliderPage1.progressBarPercentage.getText().trim();
	    	
	    	helperMethods.verifyProgressBar(secSliderProgressBarTxt,"33%");
	    	
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//verify third diagnostic title should display and slider page should display 66% progress bar
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam11,"Third Diagnostic Title Not Found");
	    	
	    	String thirdSliderProgressBarTxt = sliderPage1.progressBarPercentage.getText().trim();
	    	
	    	helperMethods.verifyProgressBar(thirdSliderProgressBarTxt,"66%");
	    	
	    	
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEngineContinueTabTCINS023()
	{
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS023");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    Thread.sleep(10000);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(30000);
		    //verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(15000);
	 
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    		    
	    		//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(5000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(3000);
	    	
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
	    	Thread.sleep(30000);
	    	
	    	//verify should display my apps page
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(newSessionPage.continueAsessionTab);
	    	Thread.sleep(7000);
	    	
	    	String inProgressApp = inProgressSessionListPage.inProgressAppsName.getText().toString();
	    	// verify in complete app should be displayed in the in progress app list.
	    	helperMethods.verifyString(inProgressApp,sParam0);
	    	
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(inProgressSessionListPage.continueTab);
	    	Thread.sleep(10000);
	    	
	    	//verify should display ContinueInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.continueInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.continueInterviewBtn);
	    	Thread.sleep(10000);
	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
bRet=sliderPage1.diagnosticTitle.isDisplayed();
	    	
	    	String actualTxt = sliderPage1.diagnosticTitle.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightStartNewUserSessionThrowEmailAndVerifySupportLinkAtDifferentPagesTCINS024(){
		
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
			
			
			
			String content=null;
				try
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS024");
					if((TestDataObject==null))
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
						bPostControl=false;
					}
					else
					{
						bPostControl=true;
					}
					
				}
				catch(Exception e)
				{
					
					logger.info("Error in selecting testcase id ");
					
				}
				
				setParameterValues(TestDataObject);
			    System.out.println("testcases-->"+sTestcaseID+"<-- started");
			    sParam0=sParam0.trim();
			    sParam1=sParam1.trim();
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    sParam4=sParam4.trim();
			    sParam5=sParam5.trim();
			    sParam6=sParam6.trim()+sTimeAppend;
			    //sParam6="Auto Test Invi Subj2014-06-23 16:19:51";
			    sParam7=sParam7.trim()+sTimeAppend;
			    sParam8=sParam8.trim();
			    sParam9=sParam9.trim();
			    sParam10=sParam10.trim();
			    sParam11=sParam11.trim();
			    sParam12=sParam12+sTimeAppend;
			    sParam15=sParam15.trim()+sTimeAppend;
			    
			    // launching the new session
			   helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
			   driver.manage().deleteAllCookies();
			   
			   Thread.sleep(60000);
			   
			    helperMethods.loginIntoMailAndClickOnBeginApp();
			    
			 //   commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
				
			//	commanFunc.clickOnElement(mailPage.clickInvite);
	    	//    Thread.sleep(5000);
			    
			    helperMethods.clicOnBeginAppAndStartInterview();
	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	//Click on Support Button
	    	commanFunc.clickOnElement(sliderPage1.sliderSupportBtn);
	    	Thread.sleep(2000);
	    	
	    	//Verify Support Pop up Window is displayed
	    	Assert.assertEquals(true, sliderPage1.supportPopUp.isDisplayed());
	    	
	    	//Click on Cancel button from popup window
	    	commanFunc.clickOnElement(sliderPage1.supportCancel);
	    	Thread.sleep(2000);
	   
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	//Click on Support Button from 2nd Slider page
	    	commanFunc.clickOnElement(sliderPage1.sliderSupportBtn);
	    	Thread.sleep(2000);
	    	
	    	//Verify Support Pop up Window is displayed
	    	Assert.assertEquals(true, sliderPage1.supportPopUp.isDisplayed());
	    	
	    	//Click on Cancel button from popup window
	    	commanFunc.clickOnElement(sliderPage1.supportCancel);
	    	Thread.sleep(2000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//Select options from Segmentation page
	    	helperMethods.clicOnSegmentationAndSelectOption(sParam3);
	    		    	
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	
	    	//Click on Support Button
	    	commanFunc.clickOnElement(sliderPage1.supportBtn);
	    	Thread.sleep(2000);
	    	
	    	//Verify Support Pop up Window is displayed
	    	Assert.assertEquals(true, sliderPage1.supportPopUp.isDisplayed());
	    	
	    	//Click on Cancel button from popup window
	    	commanFunc.clickOnElement(sliderPage1.supportCancel);
	    	Thread.sleep(2000);
	    	
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	    
	    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
	    	Thread.sleep(2000);
	    	
	    	
	    	feedBackPage.feedbackTxt.sendKeys(sParam4.trim()+sTimeAppend);
	    	
	    	//Click on Support Button
	    	commanFunc.clickOnElement(sliderPage1.supportBtn);
	    	Thread.sleep(2000);
	    	
	    	//Verify Support Pop up Window is displayed
	    	Assert.assertEquals(true, sliderPage1.supportPopUp.isDisplayed());
	    	
	    	//Click on Cancel button from popup window
	    	commanFunc.clickOnElement(sliderPage1.supportCancel);
	    	Thread.sleep(2000);
	    	
	    	//Application Issue Page is not displayed in Dev Server
	    	
	  /*  	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
	    	Thread.sleep(10000);
	    
	    	//verify should display Company page.
	    	String  actualText = driver.getCurrentUrl();
	    	//public static String companyUrl=StringConstants.url9Lenses;
	    	helperMethods.verifyString(actualText,StringConstants.url9Lenses);
	    	
            Assert.assertEquals(true, feedBackPage.companyHomePage.isDisplayed()); */
	    	
	    	
	    	Assert.assertEquals(true, feedBackPage.feedbackExperience.isDisplayed());
	    	Thread.sleep(2000);
	    	
	    	bRet=feedBackPage.feedbackExperience.isDisplayed();
	    	String actualTxt = feedBackPage.feedbackExperience.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEngineNewUserSessionSaveAndQuiteTCINS025(){
		
	//	boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		
		try{
			
			
			
				try
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS025");
					if((TestDataObject==null))
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
						bPostControl=false;
					}
					else
					{
						bPostControl=true;
					}
					
				}
				catch(Exception e)
				{
					
					logger.info("Error in selecting testcase id ");
					
				}
				
				setParameterValues(TestDataObject);
			    System.out.println("testcases-->"+sTestcaseID+"<-- started");
			    sParam0=sParam0.trim();
			    sParam1=sParam1.trim();
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    sParam4=sParam4.trim();
			    sParam5=sParam5.trim();
			    sParam6=sParam6.trim()+sTimeAppend;
			  // sParam6="Auto Test Invi Subj2014-06-23 16:40:23";
			    sParam7=sParam7.trim()+sTimeAppend;
			    sParam8=sParam8.trim();
			    sParam9=sParam9.trim();
			    sParam10=sParam10.trim();
			    sParam11=sParam11.trim();
			    sParam12=sParam12+sTimeAppend;
			    sParam15=sParam15.trim()+sTimeAppend;
			    
			    // launching the new session
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
			    driver.manage().deleteAllCookies();
			    
			    Thread.sleep(60000);
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp();
			    
			//    commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview();
	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
	    	Thread.sleep(60000);
	    	
	    	//verify should display Company page.
	    	String  actualText = driver.getCurrentUrl();
	    	//public static String companyUrl=StringConstants.url9Lenses;
	    	helperMethods.verifyString(actualText,StringConstants.url9Lenses);
	    	
	    	//Application Issue Page is not displayed in Dev Server
	    	
            Assert.assertEquals(true, feedBackPage.companyHomePage.isDisplayed());
	    	
            bRet=feedBackPage.companyHomePage.isDisplayed();
	    	
	    	String actualTxt = feedBackPage.companyHomePage.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}

	@Test(groups="lenfuncTest")
	public void inSightEngineSessionAutoSaveTCINS026(){
		
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
			
				try
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS026");
					if((TestDataObject==null))
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
						bPostControl=false;
					}
					else
					{
						bPostControl=true;
					}
					
				}
				catch(Exception e)
				{
					
					logger.info("Error in selecting testcase id ");
					
				}
				
				setParameterValues(TestDataObject);
			    System.out.println("testcases-->"+sTestcaseID+"<-- started");
			    sParam0=sParam0.trim();
			    sParam1=sParam1.trim();
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    sParam4=sParam4.trim();
			    sParam5=sParam5.trim();
			    sParam6=sParam6.trim()+sTimeAppend;
			    sParam7=sParam7.trim()+sTimeAppend;
			    sParam8=sParam8.trim();
			    sParam9=sParam9.trim();
			    sParam10=sParam10.trim();
			    sParam11=sParam11.trim();
			    sParam12=sParam12+sTimeAppend;
			    sParam15=sParam15.trim()+sTimeAppend;
			    
			    // launching the new session
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
			    System.out.println("after launching the session invition email---------->>>>0000000000000");
			    driver.manage().deleteAllCookies();
			    
			    Thread.sleep(30000);
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp();
			    
			   // commanFunc.refershPage();
			    
			    //commanFunc.clickOnElement(mailPage.clickmail);
			   
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview();
	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//Verify Slider page2 is displayed
	    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	
	    	//Click on 9th Slider row radio button(1-9 Rating Scale) in the 1st slider page
	    	commanFunc.clickOnElement(sliderPage1.sliderScale9UnChk);
	    	Thread.sleep(5000);    	
	    	//getting the attribute value from the selected check box 
	    	String Rad8chk = sliderPage1.sliderScale9Chk.getAttribute("class");
	    	//verifying the check box is selected or not
	    	helperMethods.verifyString(Rad8chk.toString(),"rad-checked");
	    	 
	    	
	    	//Enter Txt into 'Explanation' Text box in Slider page 
	    	sliderPage1.explanationTxt.sendKeys(sParam13);
	    	Thread.sleep(5000);
	    	
	    	//verify user can enter text in 'Explanation' Text box in Slider page  
	    	Assert.assertEquals("627 characters left.",sliderPage1.explainationCharLeft.getText());
	    	
	    	//Click on Next button from 2nd slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(30000);
	    	
	    	//Login in Mail Inbox and click on begin App
	    	helperMethods.loginIntoMailAndClickOnBeginApp();
	    	System.out.println("again login into the email and click on the begin app----------->>>>333333333");
		    commanFunc.refershPage();
    	
    	   //Click on Inbox and click on same invitation mail
	    	System.out.println("i am in the click on the begin app and start interview method--------->>>>555555");
	        helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			
			commanFunc.clickOnElement(mailPage.beginTheAppBtn);
	    	Thread.sleep(10000);
	    	
	    	commanFunc.windowSwitch();
	    	
	    	Assert.assertEquals(true, beginAppPage.continueInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.continueInterviewBtn);
	    	Thread.sleep(7000);
	    	
            //Verify values entered in all Entities are retained -------------------------------------->
	    	
	    	//getting the attribute value from the selected check box (Check 1st Rating scale is selected or not after timeout popup)   	
	    	String Rad81chk = sliderPage1.sliderScale9Chk.getAttribute("class");
	    	//verifying the check box is selected or not
	    	helperMethods.verifyString(Rad81chk.toString(),"rad-checked");
	    	
	    	
	    	//verify user can enter text in 'Explanation' Text box in Slider page  
	    	Assert.assertEquals("627 characters left.",sliderPage1.explainationCharLeft.getText());
	    	
		    System.out.println("i am in the second slider page");
		    Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    
            bRet=sliderPage1.explainationCharLeft.isDisplayed();
	    	
	    	String actualTxt = sliderPage1.explainationCharLeft.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEngineSegmenatationPageRequiredFieldsAndVerifySupportLinkOnSegmentationPageAndLeftNavBarTCINS027(){
		
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		
		try{
			
			
			
				try
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS027");
					if((TestDataObject==null))
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
						bPostControl=false;
					}
					else
					{
						bPostControl=true;
					}
					
				}
				catch(Exception e)
				{
					
					logger.info("Error in selecting testcase id ");
					
				}
				
				setParameterValues(TestDataObject);
			    System.out.println("testcases-->"+sTestcaseID+"<-- started");
			    sParam0=sParam0.trim();
			    sParam1=sParam1.trim();
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    sParam4=sParam4.trim();
			    sParam5=sParam5.trim();
			    sParam6=sParam6.trim()+sTimeAppend;
			    //sParam6="Auto Test Invi Subj2014-06-27 16:52:46";
			    sParam7=sParam7.trim()+sTimeAppend;
			    sParam8=sParam8.trim();
			    sParam9=sParam9.trim();
			    sParam10=sParam10.trim();
			    sParam11=sParam11.trim();
			    sParam12=sParam12+sTimeAppend;
			    sParam15=sParam15.trim()+sTimeAppend;
			    
			    // launching the new session
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
			    System.out.println("after launching the session invition email---------->>>>0000000000000");
			    driver.manage().deleteAllCookies(); 
			    helperMethods.loginIntoMailAndClickOnBeginApp();
			  //  commanFunc.clickOnElement(mailPage.clickInvite);
			    Thread.sleep(60000);
			  //  commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6); 
			    
			    helperMethods.clicOnBeginAppAndStartInterview();
	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	//Click on 'r' button from 1st Slider Page
	    	commanFunc.clickOnElement(insightReviewPage.rBtn);
	    	Thread.sleep(3000);
	    	
	    	//Verify Review Page is displayed
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	
	    	//Click on "I'm done, Submit My Responses" Button from REview Page
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(3000);
	    	
	    	//Verify Warning segmentation popup message is displayed
	    	Assert.assertEquals(true, insightReviewPage.segInfoBeforePopUp.isDisplayed());
	    	
	    	//Click on 'Go to Segmentation Page' button from the pop up
	    	commanFunc.clickOnElement(insightReviewPage.goToSegPopUp);
	    	Thread.sleep(3000);
	    	
	    	//Should display segmentation page
	    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
	    	
	    	//Click on Support Button
	    	commanFunc.clickOnElement(sliderPage1.supportBtn);
	    	Thread.sleep(2000);
	    	
	    	//Verify Support Pop up Window is displayed
	    	Assert.assertEquals(true, sliderPage1.supportPopUp.isDisplayed());
	    	
	    	//Click on Cancel button from popup window
	    	commanFunc.clickOnElement(sliderPage1.supportCancel);
	    	Thread.sleep(2000);
	    	
	    	//Click on 'i' button from Segmentation Page
	    	commanFunc.clickOnElement(insightReviewPage.iBtn);
	    	Thread.sleep(5000);
	    	
	    	// verify should display the warning dialog with please fill the required fields.
	    	String actualText = sliderPage1.warnignDialogtxt.getText().trim();
	    	helperMethods.verifyString(actualText,"Please fill the *Required fields");   	
	    	// click on the warning dialog ok button   
	    	commanFunc.clickOnElement(sliderPage1.warnignDialogOkBtn);  	
	    	Thread.sleep(4000);
	    	
	    	//Should display segmentation page
	    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
	    	
	    	//Mouse Cursor to 1st Slider Page i.e Left Navigation Link
	    	helperMethods.MoveCursorTo1stQuestion();
	    	
	    	//Verify 1st Slider Page Title is Displayed
	    	Assert.assertEquals(true, insightReviewPage.firstQuestionTitle.isDisplayed());
	    	
	    	
	    	//Click on '1st' button from Segmentation Page
	    	commanFunc.clickOnElement(insightReviewPage.firstQuestionBtn);
	    	Thread.sleep(5000);
	    	
	    	// verify should display the warning dialog with please fill the required fields.
	    	String actualText1 = sliderPage1.warnignDialogtxt.getText().trim();
	    	helperMethods.verifyString(actualText1,"Please fill the *Required fields");   	
	    	// click on the warning dialog ok button   
	    	commanFunc.clickOnElement(sliderPage1.warnignDialogOkBtn);  	
	    	Thread.sleep(4000);
	    	
	    	//Mouse Cursor to 2nd Slider Page i.e Left Navigation Link
	    	helperMethods.MoveCursorTo2ndQuestion();
	    	
	    	//Verify 1st Slider Page Title is Displayed
	    	Assert.assertEquals(true, insightReviewPage.secondQuestionTitle.isDisplayed());
	    	
	    	//Click on '2nd' button from Segmentation Page
	    	commanFunc.clickOnElement(insightReviewPage.secondQuestionBtn);
	    	Thread.sleep(3000);
	    	
	    	// verify should display the warning dialog with please fill the required fields.
	    	String actualText2 = sliderPage1.warnignDialogtxt.getText().trim();
	    	helperMethods.verifyString(actualText2,"Please fill the *Required fields");   	
	    	// click on the warning dialog ok button   
	    	commanFunc.clickOnElement(sliderPage1.warnignDialogOkBtn);  	
	    	Thread.sleep(4000);
	    	
	    	//Click on 'r' button from Segmentation Page
	    	commanFunc.clickOnElement(insightReviewPage.rBtn);
	    	Thread.sleep(3000);
	    	
	    	// verify should display the warning dialog with please fill the required fields.
	    	String actualText3 = sliderPage1.warnignDialogtxt.getText().trim();
	    	helperMethods.verifyString(actualText3,"Please fill the *Required fields");   	
	    	// click on the warning dialog ok button   
	    	commanFunc.clickOnElement(sliderPage1.warnignDialogOkBtn);  	
	    	Thread.sleep(3000);
	    	
	    	//Click on 's' button from Segmentation Page
	    	commanFunc.clickOnElement(insightReviewPage.sBtn);
	    	Thread.sleep(3000);
	    	
	    	//Should display segmentation page
	    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
	    	
	    	//Should display segmentation page Text
	    	Assert.assertEquals(true, segmentationPage.pageText.isDisplayed());
	    	
            bRet=segmentationPage.pageText.isDisplayed();
	    	
	    	String actualTxt = segmentationPage.pageText.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightEngineSupportButtonTCINS028(){
		
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
			
			
			
				try
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS028");
					if((TestDataObject==null))
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
						bPostControl=false;
					}
					else
					{
						bPostControl=true;
					}
					
				}
				catch(Exception e)
				{
					
					logger.info("Error in selecting testcase id ");
					
				}
				
				setParameterValues(TestDataObject);
			    System.out.println("testcases-->"+sTestcaseID+"<-- started");
			    sParam0=sParam0.trim();
			    sParam1=sParam1.trim();
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    sParam4=sParam4.trim();
			    sParam5=sParam5.trim();
			    sParam6=sParam6.trim()+sTimeAppend;
			    //sParam6="Auto Test Invi Subj2014-06-27 16:52:46";
			    sParam7=sParam7.trim()+sTimeAppend;
			    sParam8=sParam8.trim();
			    sParam9=sParam9.trim();
			    sParam10=sParam10.trim();
			    sParam11=sParam11.trim();
			    sParam12=sParam12+sTimeAppend;
			    sParam13=sParam13.trim();
			    sParam14=sParam14.trim();
			    sParam15=sParam15.trim()+sTimeAppend;
			    
			    // launching the new session
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
			    System.out.println("after launching the session invition email---------->>>>0000000000000");
			    driver.manage().deleteAllCookies();
			    
			    Thread.sleep(30000);
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp();
			    
			    //commanFunc.refershPage();
			   
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview();
	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	//Click on Support Button from 1st Slider page
	    	commanFunc.clickOnElement(sliderPage1.sliderSupportBtn);
	    	Thread.sleep(2000);
	    	
	    	//Verify Support Pop up Window is displayed
	    	Assert.assertEquals(true, sliderPage1.supportPopUp.isDisplayed());
	    	
	    	//Click on Cancel button from popup window
	    	commanFunc.clickOnElement(sliderPage1.supportCancel);
	    	Thread.sleep(2000);
	    	
	    	//Verify 1st slider page should display
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	//Click on Support Button from 1st Slider page
	    	commanFunc.clickOnElement(sliderPage1.sliderSupportBtn);
	    	Thread.sleep(2000);
	    	
	    	//Verify Support Pop up Window is displayed
	    	Assert.assertEquals(true, sliderPage1.supportPopUp.isDisplayed());
	    	
	    	//Enter Name in Name field 
	    	sliderPage1.supportEnterName.sendKeys(sParam11);
	    	Thread.sleep(3000);
	    	
	    	//Enter Phone Number in Phone field 
	    	sliderPage1.supportPhone.sendKeys(sParam13);
	    	Thread.sleep(3000);
	    	
	    	//Enter Support Text in Message Text field 
	    	sliderPage1.supportMessage.sendKeys(sParam14);
	    	Thread.sleep(3000);
	    	
	    	//Upload doc from upload field 
	    	sliderPage1.supportUpload.sendKeys("C:\\9LensesVPNAccessServer.pdf");
	    	Thread.sleep(3000);
	    	
	    	//Click on Send Button
	    	commanFunc.clickOnElement(sliderPage1.supportSend);
	    	Thread.sleep(5000);
	    	
	    	//Verify 1st slider page should display
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	 /*   	//commanFunc.windowSwitch();
	    	
	    	helperMethods.loginIntoMailAndClickOnBeginApp();
	    	Thread.sleep(10000);
	    	
	    	helperMethods.clickOnParticularSubJectFrmTheMailFeedBack(sParam5);
	    	
	    	//Verify Support Mail contents
	    	Assert.assertEquals(true, mailPage.supportMailEmailId.isDisplayed()); */
	    	
            bRet=sliderPage1.diagnosticTitle.isDisplayed();
	    	
	    	String actualTxt = sliderPage1.diagnosticTitle.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightSliderVerifyMultipleCommentAndMultipleScaleEntitiesTCINS0030(){
						
		             //  boolean bRet=false;
		               boolean bRet=false;
		       		   boolean bRet1=false;
		               
		               
						try{				
							
							
								try
								{
									TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS030");
									if((TestDataObject==null))
									{
										TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
										bPostControl=false;
									}
									else
									{
										bPostControl=true;
									}
									
								}
								catch(Exception e)
								{
									
									logger.info("Error in selecting testcase id ");
									
								}
								
								setParameterValues(TestDataObject);
							    System.out.println("testcases-->"+sTestcaseID+"<-- started");
							    sParam0=sParam0.trim();
							    sParam1=sParam1.trim();
							    sParam2=sParam2.trim();
							    sParam3=sParam3.trim();
							    sParam4=sParam4.trim();
							    sParam5=sParam5.trim();
							    sParam6=sParam6.trim()+sTimeAppend;;
							    sParam7=sParam7.trim()+sTimeAppend;
							    sParam8=sParam8.trim();
							    sParam9=sParam9.trim();
							    sParam10=sParam10.trim();
							    sParam11=sParam11.trim();
							    sParam12=sParam12+sTimeAppend;
							    sParam13=sParam13.trim();
							    sParam15=sParam15.trim()+sTimeAppend;
							    // launching the new session
							    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7, sParam15);
							    driver.manage().deleteAllCookies();
							    
							    helperMethods.loginIntoMailAndClickOnBeginApp();
							    
							    Thread.sleep(60000);
							    
							//    commanFunc.refershPage();
							    
							    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
							    
							    helperMethods.clicOnBeginAppAndStartInterview();
					
							    //Click on Yes button on 1st Slider page
							    commanFunc.clickOnElement(sliderPage1.yesLnk);
						    	Thread.sleep(2000);
						    	
						    	//Verify 1st diagnostic page
						    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
						    	
						 
					    	
					    	
					    	//Click on 1st Slider row radio button(1-9 Rating Scale) in the 1st slider page
					    	commanFunc.clickOnElement(sliderPage1.sliderScale1UnChk);
					    	Thread.sleep(3000);
					    	//getting the attribute value from the selected check box    	
					    	String Rad1chk = sliderPage1.sliderScale1Chk.getAttribute("class");
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Rad1chk.toString(),"rad-checked");
					    	 
					    	
					    	//Click on 5th Slider row radio button(1-9 Rating Scale) in the 1st slider page
					    	commanFunc.clickOnElement(sliderPage1.sliderScale5UnChk);
					    	Thread.sleep(3000);
					    	//getting the attribute value from the selected check box    	
					    	String Rad5chk = sliderPage1.sliderScale5Chk.getAttribute("class");
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Rad5chk.toString(),"rad-checked");
					    	 
					    	
					    	//verify 1st Slider row radio button(1-9 Rating Scale) in slider page is unchecked or not
					    	//getting the attribute value from the 1st check box    	
					    	String Rad1unchk = sliderPage1.sliderScale1UnChk.getAttribute("class"); 
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Rad1unchk.toString(),"rad-unchecked");
					    	 
					    	
					    	//Click on 9th Slider row radio button(1-9 Rating Scale) in the 1st slider page
					    	commanFunc.clickOnElement(sliderPage1.sliderScale9UnChk);
					    	Thread.sleep(3000);    	
					    	//getting the attribute value from the selected check box    	
					    	String Rad8chk = sliderPage1.sliderScale9Chk.getAttribute("class");
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Rad8chk.toString(),"rad-checked");
					    	 
					    	
					    	 //	verify 5th Slider row radio button(1-9 Rating Scale) in slider page is unchecked or not
					    	//getting the attribute value from the 1st check box    	
					    	String Rad5unchk = sliderPage1.sliderScale5UnChk.getAttribute("class"); 
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Rad5unchk.toString(),"rad-unchecked");
					    	
					    	
					    	
					    	
					    	//Click on 2nd Slider row radio button(1-9 Rating Scale) from 2 scale in the 1st slider page
					    	commanFunc.clickOnElement(sliderPage1.slider2Scale2UnChk);
					    	Thread.sleep(3000);
					    	//getting the attribute value from the selected check box    	
					    	String Scale2Rad2chk = sliderPage1.slider2Scale2Chk.getAttribute("class");
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Scale2Rad2chk.toString(),"rad-checked");
					    	 
					    	
					    	//Click on 4th Slider row radio button(1-9 Rating Scale) from 2 scale in the 1st slider page
					    	commanFunc.clickOnElement(sliderPage1.slider2Scale4UnChk);
					    	Thread.sleep(3000);
					    	//getting the attribute value from the selected check box    	
					    	String Scale2Rad4chk = sliderPage1.slider2Scale4Chk.getAttribute("class");
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Scale2Rad4chk.toString(),"rad-checked");
					    	 
					    	
					    	//verify 2nd Slider row radio button(1-9 Rating Scale)from 2 scale in slider page is unchecked or not
					    	//getting the attribute value from the 1st check box    	
					    	String Scale2Rad2unchk = sliderPage1.slider2Scale2UnChk.getAttribute("class"); 
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Scale2Rad2unchk.toString(),"rad-unchecked");
					    	 
					    	
					    	//Click on 8th Slider row radio button(1-9 Rating Scale)from 2 scale in the 1st slider page
					    	commanFunc.clickOnElement(sliderPage1.slider2Scale8UnChk);
					    	Thread.sleep(3000);    	
					    	//getting the attribute value from the selected check box    	
					    	String Scale2Rad8chk = sliderPage1.slider2Scale8Chk.getAttribute("class");
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Scale2Rad8chk.toString(),"rad-checked");
					    	 
					    	
					    	 //	verify 4th Slider row radio button(1-9 Rating Scale)from 2 scale in 1st slider page is unchecked or not
					    	//getting the attribute value from the 1st check box    	
					    	String Scale2Rad4unchk = sliderPage1.slider2Scale4UnChk.getAttribute("class"); 
					    	//verifying the check box is selected or not
					    	helperMethods.verifyString(Scale2Rad4unchk.toString(),"rad-unchecked");
					    	
					    	
					    	
					    	
					    	
					    	//Enter Txt into 1st 'Comment' Text box in Slider page 
					    	sliderPage1.commentTxt.sendKeys(sParam13);
					    	Thread.sleep(3000);
					    	//verify user can enter text in 1st 'Comment' Text box in Slider page  
					    	Assert.assertEquals("627 characters left.",sliderPage1.commentCharLeft.getText());

					    	//Enter Txt into 2nd 'Comment' Text box in Slider page 
					    	sliderPage1.comment2Txt.sendKeys(sParam13);
					    	Thread.sleep(3000);
					    	//verify user can enter text in 2nd 'Comment' Text box in Slider page  
					    	Assert.assertEquals("627 characters left.",sliderPage1.comment2CharLeft.getText());
					 
					    	bRet=sliderPage1.comment2CharLeft.isDisplayed();
					    	
					    	String actualTxt = sliderPage1.comment2CharLeft.getText();
					    	
					    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
					    	
					    	 if(bRet || bRet1){
					    		    sFinalResult = "Pass"; 
					    		   }
					    	 else{
					    		    sFinalResult = "Fail";
					    		   }
					    	
					    	 
					    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
						}
						catch(Exception e)
						{
							logger.info("Error in testcase "+sTestcaseID+"-->"+e);
						}
						finally{
							
							Assert.assertEquals(true,bRet);
							
						}
					}	
	
	@Test(groups="lenfuncTest")
	public void inSightReviewPageAndVerifyAllFieldInREviewPageTCINS031(){
		
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
			
				try
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS031");
					if((TestDataObject==null))
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
						bPostControl=false;
					}
					else
					{
						bPostControl=true;
					}
					
				}
				catch(Exception e)
				{
					
					logger.info("Error in selecting testcase id ");
					
				}
				
				setParameterValues(TestDataObject);
			    System.out.println("testcases-->"+sTestcaseID+"<-- started");
			
			    sParam0=sParam0.trim();
			    sParam1=sParam1.trim();
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    sParam4=sParam4.trim();
			    sParam5=sParam5.trim();
			    sParam6=sParam6.trim()+sTimeAppend;;
			    sParam7=sParam7.trim()+sTimeAppend;
			    sParam8=sParam8.trim();
			    sParam9=sParam9.trim();
			    sParam10=sParam10.trim();
			    sParam11=sParam11.trim();
			    sParam13=sParam13.trim();
			    sParam15=sParam15.trim()+sTimeAppend;
			  
			    System.out.println("the  login url ---->"+sLoginUrl);
			    System.out.println("the user name ---->"+sBuddyName);
			    System.out.println("the password---->"+sBuddyPassword);
			
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7,sParam15);
			    driver.manage().deleteAllCookies();
			    
			    Thread.sleep(45000);
			    
                helperMethods.loginIntoMailAndClickOnBeginApp();
			    
			 //   commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview();
		
	    	
			//Verify should display First Slider Page    
		    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
		    Thread.sleep(2000);    
			    
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	
	    	//Click on 9th Slider row radio button(1-9 Rating Scale) in the 1st slider page
	    	commanFunc.clickOnElement(sliderPage1.sliderScale9UnChk);
	    	Thread.sleep(5000);
	    	
	    	sliderPage1.explanationTxt.sendKeys(sParam13);
	    	Thread.sleep(3000);
	    	
	    	//Click on Strength up arrow key
	    	commanFunc.clickOnElement(sliderPage1.strengthUpArrow);
	    	Thread.sleep(5000);
	    	
	    	//Click on Gaps 3rd(Help is needed around this topic area) Un-check option in slider page
	    	commanFunc.clickOnElement(sliderPage1.communicationGaps3Uncheck);
	    	Thread.sleep(3000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//Verify should display Second Slider Page    
	    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	Thread.sleep(5000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	
	    	//Click on 1st Slider row radio button(1-9 Rating Scale) in the 1st slider page
	    	commanFunc.clickOnElement(sliderPage1.sliderScale1UnChk);
	    	Thread.sleep(5000);
	    	
	    	sliderPage1.explanationTxt.sendKeys(sParam13);
	    	
	    	//Click on Challenge up arrow keygetText()
	    	commanFunc.clickOnElement(sliderPage1.challengeUpArrow);
	    	Thread.sleep(3000);
	    	
	    	//Click on Challenge up arrow keygetText()
	    	commanFunc.clickOnElement(sliderPage1.challengeUpArrow);
	    	Thread.sleep(3000);
	    	
	    	
	    	//Click on Next button from 2nd slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	
	    	//Click on Segmentation page and Select drill down option.
	    	helperMethods.clicOnSegmentationAndSelectOption(sParam3);
	    	Thread.sleep(7000);
	    	
	    	//Verify "I'm done, Submit My Responses" Button should present in the Page
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	
	    	
	    	//You Made It!,Topic Area,Score,Words & Can you help? Text should present in the Page
	    	Assert.assertEquals(true, insightReviewPage.youMadeItTxt.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.yourResponseTxt.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.topicAreaTxt.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.scoreTxt.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.wordsTxt.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.strengthsTxt.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.challengesTxt.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.strengthFirstQuestion.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.strengthSecondQuestion.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.challengesFirstQuestion.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.challengesSecondQuestion.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.canUHelpTxt.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.backToTopBtn.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.questionOne.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.questionSecond.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.scoreFirstQuestion.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.scoreSecondQuestion.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.wordFirstQuestion.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.wordSecondQuestion.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.canUHelpFirstQuestion.isDisplayed());
	    	Assert.assertEquals(true, insightReviewPage.canUHelpSecondQuestion.isDisplayed());
	    	
	    	//Click on "I'm done, Submit My Responses" Button
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
	    	Thread.sleep(1000);
	    	
	    	feedBackPage.feedbackTxt.sendKeys(sParam4.trim()+sTimeAppend);
	    	
	    	//Application Issue Page is not displayed in Dev Server
	    	
	    	commanFunc.clickOnElement(feedBackPage.skipLnk);
	    	Thread.sleep(90000);
	  
	    	//verify should display Company page.
	    	String  actualText = driver.getCurrentUrl();
	    	//public static String companyUrl=StringConstants.url9Lenses;
	    	helperMethods.verifyString(actualText,StringConstants.url9Lenses);
	    	
            Assert.assertEquals(true, feedBackPage.companyHomePage.isDisplayed()); 
	    	
	   // 	Assert.assertEquals(true, feedBackPage.feedbackExperience.isDisplayed());
	    	
            bRet=feedBackPage.companyHomePage.isDisplayed();
	    	
	    	String actualTxt = feedBackPage.companyHomePage.getText();
	    	
	    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
	    	
	    	 if(bRet || bRet1){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	
	    	 
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}			
	}

	@Test(groups="lenfuncTest")
	public void inSightReviewPageNavigationTCINS032(){
			
		//boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		
		try{
				
				
				
					try
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINS032");
						if((TestDataObject==null))
						{
							TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
							bPostControl=false;
						}
						else
						{
							bPostControl=true;
						}
						
					}
					catch(Exception e)
					{
						
						logger.info("Error in selecting testcase id ");
						
					}
					
					setParameterValues(TestDataObject);
				    System.out.println("testcases-->"+sTestcaseID+"<-- started");
				
				    sParam0=sParam0.trim();
				    sParam1=sParam1.trim();
				    sParam2=sParam2.trim();
				    sParam3=sParam3.trim();
				    sParam4=sParam4.trim();
				    sParam5=sParam5.trim();
				    sParam6=sParam6.trim()+sTimeAppend;;
				    sParam7=sParam7.trim()+sTimeAppend;
				    sParam8=sParam8.trim();
				    sParam9=sParam9.trim();
				    sParam10=sParam10.trim();
				    sParam11=sParam11.trim();
				    sParam13=sParam13.trim();
				    sParam15=sParam15.trim()+sTimeAppend;
				  
				    System.out.println("the  login url ---->"+sLoginUrl);
				    System.out.println("the user name ---->"+sBuddyName);
				    System.out.println("the password---->"+sBuddyPassword);
				
				    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7,sParam15);
				    driver.manage().deleteAllCookies();
				    
				    Thread.sleep(30000);
				    
	                helperMethods.loginIntoMailAndClickOnBeginApp();
				    
			//	    commanFunc.refershPage();
				    
				    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
				    
				    helperMethods.clicOnBeginAppAndStartInterview();
			
		    	
				//Verify should display First Slider Page    
			    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
			    Thread.sleep(2000);    
				    
		    	commanFunc.clickOnElement(sliderPage1.yesLnk);
		    	Thread.sleep(2000);
		    	
		    	//Click on 9th Slider row radio button(1-9 Rating Scale) in the 1st slider page
		    	commanFunc.clickOnElement(sliderPage1.sliderScale9UnChk);
		    	Thread.sleep(5000);
		    	
		    	sliderPage1.explanationTxt.sendKeys(sParam13);
		    	
		    	//Click on Strength up arrow key
		    	commanFunc.clickOnElement(sliderPage1.strengthUpArrow);
		    	Thread.sleep(3000);
		    	
		    	//Click on Gaps 3rd(Help is needed around this topic area) Un-check option in slider page
		    	commanFunc.clickOnElement(sliderPage1.communicationGaps3Uncheck);
		    	Thread.sleep(3000);
		    	
		    	commanFunc.clickOnElement(sliderPage1.paginationNext);
		    	Thread.sleep(5000);
		    	
		    	//Verify should display Second Slider Page    
		    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    	Thread.sleep(2000);
		    	
		    	commanFunc.clickOnElement(sliderPage1.yesLnk);
		    	Thread.sleep(2000);
		    	
		    	//Click on 1st Slider row radio button(1-9 Rating Scale) in the 2nd slider page
		    	commanFunc.clickOnElement(sliderPage1.sliderScale1UnChk);
		    	Thread.sleep(8000);
		    	
		    	sliderPage1.explanationTxt.sendKeys(sParam13);
		    	Thread.sleep(3000);
		    	
		    	//Click on Next button from 2nd slider page
		    	commanFunc.clickOnElement(sliderPage1.paginationNext);
		    	Thread.sleep(5000);
		    	
		    	
		    	//Click on Segmentation page and Select drill down option.
		    	helperMethods.clicOnSegmentationAndSelectOption(sParam3);
		    	Thread.sleep(5000);
		    	
		    	//Verify "I'm done, Submit My Responses" Button should present in the Page
		    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
		    	
		    	
		    	//You Made It!,Topic Area,Score,Words & Can you help? Text should present in the Page
		    	Assert.assertEquals(true, insightReviewPage.youMadeItTxt.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.yourResponseTxt.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.topicAreaTxt.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.scoreTxt.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.wordsTxt.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.canUHelpTxt.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.backToTopBtn.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.questionOne.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.questionSecond.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.scoreFirstQuestion.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.scoreSecondQuestion.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.wordFirstQuestion.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.wordSecondQuestion.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.canUHelpFirstQuestion.isDisplayed());
		    	Assert.assertEquals(true, insightReviewPage.canUHelpSecondQuestion.isDisplayed());
		    	
		    	//Click on 'i' button from Review Page
		    	commanFunc.clickOnElement(insightReviewPage.iBtn);
		    	Thread.sleep(5000);
		    	
		    	//Click on 'BACT TO TOP' button
		    	commanFunc.clickOnElement(insightReviewPage.backToTopBtn);
		    	Thread.sleep(3000);
		    	
		    	//Verify should Display Application Name Diagnostic
		    	Assert.assertEquals(true,beginAppPage.beginPageAppsName.isDisplayed()); 
		    	Thread.sleep(2000);
		    
		    	//Click on 'r' button from Introduction Page
		    	commanFunc.clickOnElement(insightReviewPage.rBtn);
		    	Thread.sleep(5000); 
		    	
		    	//Click on 'BACT TO TOP' button
		    	commanFunc.clickOnElement(insightReviewPage.backToTopBtn);
		    	Thread.sleep(3000);
		    	
		    	//Verify "I'm done, Submit My Responses" Button should present in the Page
		    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed()); 
		    	
		    	//Click on '1st' button from Review Page
		    	commanFunc.clickOnElement(insightReviewPage.firstQuestionBtn);
		    	Thread.sleep(5000);
		    	
		    	//Click on 'Diagnostic Title' button
		    	commanFunc.clickOnElement(sliderPage1.diagnosticTitle);
		    	Thread.sleep(3000);
		    	
		    	//Verify should display First Slider Page    
			    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
			    Thread.sleep(2000);
			    
		    	//Click on 'r' button from 1st Question Page
		    	commanFunc.clickOnElement(insightReviewPage.rBtn);
		    	Thread.sleep(5000);
		    	
		    	//Click on 'BACT TO TOP' button
		    	commanFunc.clickOnElement(insightReviewPage.backToTopBtn);
		    	Thread.sleep(3000);
		    	
		    	//Verify "I'm done, Submit My Responses" Button should present in the Page
		    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
		    	
		    	//Click on '2nd' button from Review Page
		    	commanFunc.clickOnElement(insightReviewPage.secondQuestionBtn);
		    	Thread.sleep(5000);
		    	
		    	//Click on 'Diagnostic Title' button
		    	commanFunc.clickOnElement(sliderPage1.diagnosticTitle);
		    	Thread.sleep(3000);
		    	
		    	//Verify should display Second Slider Page    
		    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    	Thread.sleep(2000);
		    	
		    	//Click on 'r' button from 2nd Question Page
		    	commanFunc.clickOnElement(insightReviewPage.rBtn);
		    	Thread.sleep(5000);
		    	
		    	//Click on 'BACT TO TOP' button
		    	commanFunc.clickOnElement(insightReviewPage.backToTopBtn);
		    	Thread.sleep(3000);
		    	
		    	//Verify "I'm done, Submit My Responses" Button should present in the Page
		    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
		    	
		    	//Click on 's' button from Review Page
		    	commanFunc.clickOnElement(insightReviewPage.sBtn);
		    	Thread.sleep(5000);
		    	
		    	//Click on 'BACT TO TOP' button
		    	//commanFunc.clickOnElement(insightReviewPage.backToTopBtn);
		    	//Thread.sleep(3000);
		    	
		    	//Should display segmentation page
		    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
		    	
		    	//Click on 'r' button from Segmentation Page
		    	commanFunc.clickOnElement(insightReviewPage.rBtn);
		    	Thread.sleep(5000);
		    	
		    	//Click on 'BACT TO TOP' button
		    	commanFunc.clickOnElement(insightReviewPage.backToTopBtn);
		    	Thread.sleep(3000);
		    	
		    	//Verify "I'm done, Submit My Responses" Button should present in the Page
		    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
		    	
		    	//Click on "I'm done, Submit My Responses" Button
		    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
		    	Thread.sleep(7000);
		     
		    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
		    	Thread.sleep(1000);
		    	
		    	feedBackPage.feedbackTxt.sendKeys(sParam4.trim()+sTimeAppend);
		    	
		    	
		    	//Commented because Page not getting displayed in Dev,Staging and QA Server
		    	
		    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
		    	Thread.sleep(90000);
		  
		    	//verify should display Company page.
		    	String  actualText = driver.getCurrentUrl();
		    	//public static String companyUrl=StringConstants.url9Lenses;
		    	helperMethods.verifyString(actualText,StringConstants.url9Lenses);
		    
		    	Assert.assertEquals(true, feedBackPage.companyHomePage.isDisplayed()); 
		    	
		    //	Assert.assertEquals(true, feedBackPage.excellentRadioBtn.isDisplayed());
		    	
		    	bRet=feedBackPage.companyHomePage.isDisplayed();
		    	
		    	String actualTxt = feedBackPage.companyHomePage.getText();
		    	
		    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
		    	
		    	 if(bRet || bRet1){
		    		    sFinalResult = "Pass"; 
		    		   }
		    	 else{
		    		    sFinalResult = "Fail";
		    		   }
		    	
		    	 
		    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
			}
			catch(Exception e)
			{
				logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
		}
	
		
	@Test(groups="lenfuncTest")
	public void analyticPremissionAccessTCAP033(){
		
	//	boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
				
				
				
					try
					{
						TestDataObject = (TestDataObj) CSvmap.mMap.get("TCAP033");
						if((TestDataObject==null))
						{
							TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
							bPostControl=false;
						}
						else
						{
							bPostControl=true;
						}
						
					}
					catch(Exception e)
					{
						
						logger.info("Error in selecting testcase id ");
						
					}
					
					setParameterValues(TestDataObject);
				    System.out.println("testcases-->"+sTestcaseID+"<-- started");
				
				    sParam0=sParam0.trim()+helperMethods.getRandomNum();
				    sParam1=sParam1.trim()+helperMethods.getRandomNum();
				    sParam2=sParam2.trim()+helperMethods.getRandomNum();
				    sParam3=sParam3.trim()+helperMethods.getRandomNum()+"@9lenses.com";
				    sParam3=sParam3.trim();
				    sParam4=sParam4.trim();
				    
				 /*   sParam0="AutoFNme24";
				    sParam2="SeliLNme73";
				    sParam3=sParam3.trim();
				    sParam4=sParam4.trim();*/
		
				    System.out.println("the  login url ---->"+sLoginUrl);
				    System.out.println("the user name ---->"+sBuddyName);
				    System.out.println("the password---->"+sBuddyPassword);
				    System.out.println("the user first name ---->"+sParam0);
				    System.out.println("the user middle name---->"+sParam1);
				    System.out.println("the new last name---->"+sParam2);
				    
				    System.out.println("the new user email id---->"+sParam3);
				    
				 helperMethods.addNewUser(sLoginUrl, sBuddyName, sBuddyPassword,sParam0,sParam1,sParam2,sParam3);
				   
				 Thread.sleep(7000);
				 
				//Click on Analytic tab 
		    	commanFunc.clickOnElement(analyticPage.analyticsTab);
		    	Thread.sleep(10000);
		    	
		    	//Verify Analytic page is displayed
		    	Assert.assertEquals(true, analyticPage.analyticsBtn.isDisplayed());
		    	
		    	//Verify Session List is displayed
		    	Assert.assertEquals(true, analyticPage.sessionList.isDisplayed());
		    	
		    	//Click on Session Access Settings
		    	commanFunc.clickOnElement(analyticPage.sessionAccessSetting);
		    	Thread.sleep(10000);
		    	
		    	//Verify session Access Setting page is displayed
		    	Assert.assertEquals(true, analyticPage.addNonParticipant.isDisplayed());
		    	
		    	//Enter user email id in the text field
		    	analyticPage.userNameTxt.sendKeys(sParam3);
		    	Thread.sleep(10000);
		    	
		    	//Click on Session Access Settings
		    	commanFunc.clickOnElement(analyticPage.addBtn);
		    	Thread.sleep(10000);
		    	
		    	//Login into email box
		    	helperMethods.loginIntoMailAndClickOnBeginApp();
		    	
		    	commanFunc.refershPage();
		    	String usrFullNme=sParam0+" "+sParam2;
		    	//click on the particular analytic email
		    	helperMethods.clickOnParticularSubJectFrmTheMail(usrFullNme);
		    	
		    	Thread.sleep(10000);
		    	if(driver.findElements(By.xpath(mailPage.dotImgXpath)).size()!=0){
		    		commanFunc.clickOnElement(mailPage.dotImg);
		    		Thread.sleep(4000);
		    	}
		    	
		    	commanFunc.clickOnElement(mailPage.clickHereToGetStartedLnk);
		    	Thread.sleep(10000);
		    	commanFunc.windowSwitch();
		    	Thread.sleep(45000);

		    	helperMethods.updatePassWord(sParam4, sParam4);
		    	Thread.sleep(30000);
		    	
		    	Assert.assertEquals(true, analyticPage.analyticDashBoard.isDisplayed());
		    	
		    	bRet=analyticPage.analyticDashBoard.isDisplayed();
		    	
		    	String actualTxt = analyticPage.analyticDashBoard.getText();
		    	
		    	bRet1=helperMethods.verifyAssertString(actualTxt, sParam5);
		    	
		    	 if(bRet || bRet1){
		    		    sFinalResult = "Pass"; 
		    		   }
		    	 else{
		    		    sFinalResult = "Fail";
		    		   }
		    	
		    	 
		    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, sParam5, actualTxt, "Add some comment if required", resultFileName);
			}
			catch(Exception e)
			{
				logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}

	@Test(groups="lenfuncTest")
	public void inSightSuppotEmailTestTCINSEMAIL034()
	{
	//	boolean bRet=false;
		boolean bRet=false;
		boolean bRet1=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINSEMAIL034");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		 
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim()+sTimeAppend;
		    sParam9=sParam9.trim()+helperMethods.getRandomNum();
		    sParam10=sParam10.trim()+sTimeAppend;
		    sParam11=sParam11.trim();
		    sParam15=sParam15.trim()+sTimeAppend;
		    System.out.println("the  login url ---->"+sLoginUrl);
		    System.out.println("the user name ---->"+sBuddyName);
		    System.out.println("the password---->"+sBuddyPassword);
		
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7,sParam15);
		    driver.manage().deleteAllCookies();
		    
		    Thread.sleep(60000);
		    
            helperMethods.loginIntoMailAndClickOnBeginApp();
		    
		//    commanFunc.refershPage();
		    
		    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
		    
		    helperMethods.clicOnBeginAppAndVerifyBeginTheInterview();
		    
		    commanFunc.clickOnElement(beginAppPage.supportLnk);
		    Thread.sleep(8000);
		    
		    // enter the support name
		    supportPopUpPage.enterNmeTxt.sendKeys(sParam8);
		    //enter the phone number
		    supportPopUpPage.supportPhoneNumTxt.sendKeys(sParam9);
		    //enter the support description
		    supportPopUpPage.supportMessageTxt.sendKeys(sParam10);
	    	
		    commanFunc.clickOnElement(supportPopUpPage.sendLnk);
		    Thread.sleep(90000);
		    
		    
		    helperMethods.loginIntoMailAndClickOnBeginApp();
		    
		   // commanFunc.refershPage();
		    
		    helperMethods.clickOnParticularSubJectFrmTheMail(sParam8);
		    Thread.sleep(10000);
		    
		    String contents = "Name : "+sParam8+"::"+"Email : "+sParam1+"::"+"Phone Number : "+sParam9+"::"+"Message : "+sParam10;
		    bRet = helperMethods.verifySupportEmailContents(sParam1, contents);
		    	    	
	    	 if(bRet){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, "put Expectedf result", "Put actual result", "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@Test(groups="lenfuncTest")
	public void inSightFeedBackEmailTestTCINSFBEMAIL035()
	{
		boolean bRet=false;
		
		try{
					
			try
			{
				TestDataObject = (TestDataObj) CSvmap.mMap.get("TCINSFBEMAIL035");
				if((TestDataObject==null))
				{
					TestDataObject = (TestDataObj) CSvmap.mMap.get("NocorrespondingArchival");
					bPostControl=false;
				}
				else
				{
					bPostControl=true;
				}
				
			}
			catch(Exception e)
			{
				
				logger.info("Error in selecting testcase id ");
				
			}
			
			setParameterValues(TestDataObject);
		    System.out.println("testcases-->"+sTestcaseID+"<-- started");
		 
		    sParam0=sParam0.trim();
		    sParam1=sParam1.trim();
		    sParam2=sParam2.trim();
		    sParam3=sParam3.trim();
		    sParam4=sParam4.trim();
		    sParam5=sParam5.trim();
		    sParam6=sParam6.trim()+sTimeAppend;;
		    sParam7=sParam7.trim()+sTimeAppend;
		    sParam8=sParam8.trim()+sTimeAppend;
		    sParam15=sParam15.trim()+sTimeAppend;
		    System.out.println("the  login url ---->"+sLoginUrl);
		    System.out.println("the user name ---->"+sBuddyName);
		    System.out.println("the password---->"+sBuddyPassword);
		
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7,sParam15);
		    driver.manage().deleteAllCookies();
		    
		    Thread.sleep(60000);
		    
            helperMethods.loginIntoMailAndClickOnBeginApp();
		    
		//    commanFunc.refershPage();
		    
		    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
		    
		    helperMethods.clicOnBeginAppAndStartInterview();
		    //clicking next button from the first slider page
		    commanFunc.clickOnElement(sliderPage1.paginationNext);
		    Thread.sleep(7000);
		    //clicking next button from the second slider page
		    commanFunc.clickOnElement(sliderPage1.paginationNext);
		    Thread.sleep(7000);
		    // selecting the segmentation option from the segmentation page
		    helperMethods.clicOnSegmentationAndSelectOption(sParam3);
		    // click on the submit button from the feedback page
		    commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
		    Thread.sleep(7000);
		    // clicking on the excellent radio button from the feedback page
		    commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
		    Thread.sleep(3000);
		    // enter the feed back text in feed back text box
		    feedBackPage.feedbackTxt.sendKeys(sParam8);
		    //click on the sub mit from the feed back page
		    commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
		    Thread.sleep(7000);
		    
		    helperMethods.loginIntoMailAndClickOnBeginApp();
		    
		 //   commanFunc.refershPage();
		    
		    helperMethods.clickOnParticularSubJectFrmTheMail(sParam1);
		    Thread.sleep(5000);

		    
		    String contents = "Customer Name : "+sParam9+"::"+"Customer Email : "+sParam1+"::"+"Company Name :  "+sParam10+"::"+"Rank Your Experience : "+sParam11+"::"+"Tell Us About Your Experience : "+sParam8;
		    bRet = helperMethods.verifySupportEmailContents(sParam1, contents);
		    	    	
	    	 if(bRet){
	    		    sFinalResult = "Pass"; 
	    		   }
	    	 else{
	    		    sFinalResult = "Fail";
	    		   }
	    	 testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, "put Expectedf result", "Put actual result", "Add some comment if required", resultFileName);
		}
		catch(Exception e)
		{
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
		finally{
			
			Assert.assertEquals(true,bRet);
			
		}
	}
	
	@AfterMethod(groups="lenfuncTest",alwaysRun=true)
	public void tearDown()
	{	
		try{
			driver.quit();
		}
		
		catch(Exception e)
		{
			//testReport.addResult(fileWriter, sTestcaseID,sTestcasePath, sFinalResult, "put Expectedf result", "Put actual result", "Add some comment if required", resultFileName);
			logger.info("Error in killing the browser "+sTestcaseID+"-->"+e);
		}
		
	}
	
}
