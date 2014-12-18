package com.lenses.Tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
import com.lenses.HelpeClass.HelperMethods;
import com.lenses.KeyWords.StringConstants;
import com.lenses.ObjectRep.AdminDashBoardPage;
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
import com.lenses.ObjectRep.TopicsOverViewsPage;
import com.lenses.TestdataTemplate.TestDataObj;
import com.lenses.Utils.TestSuitSetUp;

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
	private static int blockCheck=0;
	
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
	    
	}
	
	//@Test(groups = { "lenfuncTest" })
	public void loginTest() {
		boolean bRet=false;
		boolean bRet1=false;
		boolean bRet2=false;
		boolean bRet3=false;
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
		    
		    helperMethods.getScreenShot("snap1");
		   // helperMethods.loginAsValidUser("https://206.164.173.83/Login.aspx","jeevan.borale@9lenses.com","Automation@1234");
			wait.until(ExpectedConditions.visibilityOf(newSessionPage.newSessionTab));
			Assert.assertEquals(true, newSessionPage.newSessionTab.isDisplayed());
			helperMethods.getScreenShot("snap2");
			Thread.sleep(5000);
		    
		}
		catch(Exception e)
		{
			//assertEquals(true,bRet);
			logger.info("Error in testcase "+sTestcaseID+"-->"+e);
		}
	 }
	
	//@Test(groups="lenfuncTest")
	public void inSightSendInvitionUsingLaunchNowTCINS001()
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
		    
		    // verify should session will launch immediatelly and verify in the mail 
		    helperMethods.sessionInvitionAndVerifyEmail(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7,StringConstants.emailUrl,sBuddyName, sParam8);
		    Thread.sleep(5000);
	    	    	
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightStartSessionThrowEmailTCINS002(){
		
		try{
			
			boolean bRet=false;
			boolean bRet1=false;
			boolean bRet2=false;
			boolean bRet3=false;
			String interID=null;
			String content=null;
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
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			   /* sParam6=sParam6+sTimeAppend;
			    sParam7=sParam6+sTimeAppend;*/
			    
			    System.out.println("the  login url ---->"+sLoginUrl);
			    System.out.println("the user name ---->"+sBuddyName);
			    System.out.println("the password---->"+sBuddyPassword);
			
			   // helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp(sParam9.trim(), sBuddyName,sParam11);
			    WebElement ele = driver.findElement(By.xpath("//span[text()='"+ sParam6 +"']"));
	    	
			    commanFunc.mouseOverOnElement(ele);
			    //ele.click();
			    commanFunc.clickOnElement(ele);
			    Thread.sleep(5000);
	    	
	    	commanFunc.clickOnElement(mailPage.beginTheAppBtn);
	    	Thread.sleep(10000);
	    	
	    	commanFunc.windowSwitch();
	    	
	    	Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
	    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
	    	Select inputSclt = new Select(segmentationPage.inputAnserSclt);
	    	inputSclt.selectByVisibleText(sParam0.trim());
	    	Thread.sleep(3000);
	    	
	    	commanFunc.clickOnElement(segmentationPage.nextBtn);
	    	Thread.sleep(9000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	
	    	//commanFunc.clickOnElement(sliderPage1.sliderRow5);
	    	//Thread.sleep(1000);
	    	
	    	//sliderPage1.explanationTxt.sendKeys(sParam1);
	    	
	    	sliderPage1.commentTxt.sendKeys(sParam2);
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(sParam3.trim(),sliderPage1.secondDiagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(sParam4.trim(),sliderPage1.secondDiagnosticTitle.getText(),"text not found");
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//sliderPage1.commentTxt.sendKeys(sParam2);
	    	
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	    	
	    	//commanFunc.checkAlert();
	    	
	    	commanFunc.clickOnElement(insightReviewPage.exitAppDialogYesBtn);
	    	Thread.sleep(7000);
	    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
	    	Thread.sleep(1000);
	    	
	    	feedBackPage.feedbackTxt.sendKeys(sParam4.trim()+sTimeAppend);
	    	
	    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
	    	Thread.sleep(6000);
	    	    	
	    	commanFunc.clickOnElement(feedBackPage.feedbackDialogOkBtn);
	    	Thread.sleep(5000);
	    	//commanFunc.checkAlert();
	    	//Thread.sleep(6000);
	    	//Thread.sleep(5000);
		}catch(Exception e){
			System.out.println("the expception is --->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightStartSessionThrowEmailWithotSegmentConfigTCINS003(){
		
		try{
			
			boolean bRet=false;
			boolean bRet1=false;
			boolean bRet2=false;
			boolean bRet3=false;
			String interID=null;
			String content=null;
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
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    /*sParam6=sParam6+sTimeAppend;
			    sParam7=sParam6+sTimeAppend;*/
			    
			    System.out.println("the  login url ---->"+sLoginUrl);
			    System.out.println("the user name ---->"+sBuddyName);
			    System.out.println("the password---->"+sBuddyPassword);
			
			//helperMethods.loginIntoMailAndClickOnBeginApp("https://mail.google.com/mail/u/0/?pli=1#inbox", "jeevan.borale@9lenses.com","automation@123");
			  //  helperMethods.loginIntoMailAndClickOnBeginApp(sParam9.trim(), sBuddyName,sParam11.trim());
			//WebElement ele = driver.findElement(By.xpath("(//*[contains(text(),'Automation testing perpose invi Subj 1212')]/parent::*/parent::*/parent::*/parent::*/parent::tr)[position()=1]"));
			//WebElement ele = driver.findElement(By.xpath("Automation Testing Purpose sub']"));
			/*WebElement ele = driver.findElement(By.xpath("//span[text()='"+ sParam6 +"']"));
	    	//commanFunc.WaitforElement(ele);
	    	
			commanFunc.mouseOverOnElement(ele);
	    	//ele.click();
	    	commanFunc.clickOnElement(ele);
	    	Thread.sleep(5000);
	    	
	    	commanFunc.clickOnElement(mailPage.beginTheAppBtn);
	    	Thread.sleep(10000);*/
	    	
			  /*  WebElement ele = driver.findElement(By.xpath("//span[text()='"+ sParam6 +"']"));
		    	
				commanFunc.mouseOverOnElement(ele);
		    	commanFunc.clickOnElement(ele);
		    	Thread.sleep(5000);
		    	
			//commanFunc.clickOnSpecificSubjectAndBeginAppFromTheMailInbox(sParam6);
			
	    	commanFunc.windowSwitch();*/
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp(sParam9.trim(), sBuddyName,sParam11.trim());
			    WebElement ele = driver.findElement(By.xpath("//span[text()='"+ sParam6 +"']"));
	    	
			    commanFunc.mouseOverOnElement(ele);
			    //ele.click();
			    commanFunc.clickOnElement(ele);
			    Thread.sleep(5000);
	    	
	    	commanFunc.clickOnElement(mailPage.beginTheAppBtn);
	    	Thread.sleep(10000);
	    	
	    	commanFunc.windowSwitch();
	    	
	    	Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
	    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
	    	Thread.sleep(7000);
	    	
	    	/*commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    
	    	
	    	commanFunc.clickOnElement(sliderPage1.pollingChkY);
	    	Thread.sleep(2000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);*/
	    	
	    	//Assert.assertEquals(sParam3.trim(),sliderPage1.secondDiagnosticTitle.getText(),"text not found");
	    	Assert.assertEquals(sliderPage1.secondDiagnosticTitle.getText(),sParam3.trim(),"text not found");
	    	
	    	System.out.println("the secondquestion title---->"+sliderPage1.secondDiagnosticTitle.getText());
	    	
	    	sliderPage1.commentTxt.sendKeys(sParam1);
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	//Assert.assertEquals(sParam4.trim(),sliderPage1.secondDiagnosticTitle.getText(),"text not found");
	    	Assert.assertEquals(sliderPage1.secondDiagnosticTitle.getText(),sParam4.trim(),"text not found");
	    	
	    	System.out.println("the third question title---->"+sliderPage1.secondDiagnosticTitle.getText());
	    	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.clickOnElement(insightReviewPage.exitAppDialogYesBtn);
	    	Thread.sleep(6000);
	    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
	    	Thread.sleep(1000);
	    	
	    	feedBackPage.feedbackTxt.sendKeys(sParam5.trim());
	    	
	    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
	    	Thread.sleep(6000);
	    	
	    	commanFunc.clickOnElement(feedBackPage.feedbackDialogOkBtn);
	    	Thread.sleep(6000);
	    	
		}catch(Exception e){
			System.out.println("the expception is --->"+e);
		}
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightSaveAndQuiteSessionTCINS004(){
		
		try{
			
			boolean bRet=false;
			boolean bRet1=false;
			boolean bRet2=false;
			boolean bRet3=false;
			String interID=null;
			String content=null;
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
			    sParam2=sParam2.trim();
			    sParam3=sParam3.trim();
			    sParam6=sParam6+sTimeAppend;
			    sParam7=sParam6+sTimeAppend;
			    
			    System.out.println("the  login url ---->"+sLoginUrl);
			    System.out.println("the user name ---->"+sBuddyName);
			    System.out.println("the password---->"+sBuddyPassword);
			
			//helperMethods.loginIntoMailAndClickOnBeginApp("https://mail.google.com/mail/u/0/?pli=1#inbox", "jeevan.borale@9lenses.com","automation@123");
			    helperMethods.loginIntoMailAndClickOnBeginApp(sParam9.trim(), sBuddyName,sBuddyPassword);
			//WebElement ele = driver.findElement(By.xpath("(//*[contains(text(),'Automation testing perpose invi Subj 1212')]/parent::*/parent::*/parent::*/parent::*/parent::tr)[position()=1]"));
			//WebElement ele = driver.findElement(By.xpath("Automation Testing Purpose sub']"));
			/*WebElement ele = driver.findElement(By.xpath("//span[text()='"+ sParam6 +"']"));
	    	//commanFunc.WaitforElement(ele);
	    	
			commanFunc.mouseOverOnElement(ele);
	    	//ele.click();
	    	commanFunc.clickOnElement(ele);
	    	Thread.sleep(5000);
	    	
	    	commanFunc.clickOnElement(mailPage.beginTheAppBtn);
	    	Thread.sleep(10000);*/
	    	
			commanFunc.clickOnSpecificSubjectAndBeginAppFromTheMailInbox(sParam6);
			
	    	commanFunc.windowSwitch();
	    	
	    	Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
	    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(true, segmentationPage.inputAnserSclt.isDisplayed());
	    	Select inputSclt = new Select(segmentationPage.inputAnserSclt);
	    	inputSclt.selectByVisibleText(sParam0.trim());
	    	Thread.sleep(3000);
	    	
	    	commanFunc.clickOnElement(segmentationPage.nextBtn);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.sliderRow5);
	    	Thread.sleep(1000);
	    	
	    	sliderPage1.explanationTxt.sendKeys(sParam1);
	    	
	    	sliderPage1.commentTxt.sendKeys(sParam2);
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(sParam3.trim(),sliderPage1.secondDiagnosticTitle.getText(),"text not found");
	    	
	    	// click on save and quite 
	    	
	    	
	    	/*commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(sParam4.trim(),sliderPage1.secondDiagnosticTitle.getText(),"text not found");
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.checkAlert();
	    	Thread.sleep(6000);
	    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
	    	Thread.sleep(1000);
	    	
	    	feedBackPage.feedbackTxt.sendKeys(sParam4.trim());
	    	
	    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
	    	Thread.sleep(6000);
	    	
	    	commanFunc.checkAlert();
	    	Thread.sleep(6000);*/
	    	
		}catch(Exception e){
			System.out.println("the expception is --->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightStartNewUserSessionThrowEmailTCINS005(){
		
		try{
			
			boolean bRet=false;
			boolean bRet1=false;
			boolean bRet2=false;
			boolean bRet3=false;
			String interID=null;
			String content=null;
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
			    
			    // launching the new session
			    
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
			    
			    driver.manage().deleteAllCookies();
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp(conts.emailUrl, sBuddyName,conts.emailPassword);
			    
			    commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
			    
			    // verify first slider page should display
			    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
			 // click on the back to segmentation page   
	    	commanFunc.clickOnElement(sliderPage1.backToSegmentation);
	    	Thread.sleep(7000);
	    	//verify  should display segmentation page
	    	commanFunc.clickOnElement(segmentationPage.nextBtn);
	    	Thread.sleep(9000);
	    	
	    	// verify should display first slider page should.
		    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	// click on the skip link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.skipNotClearLnk);
	    	Thread.sleep(7000);
	    	
	    	// verify should display second slider page.
	    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	//click on the previous button from the current slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationPrev);
	    	Thread.sleep(7000);
	    	// verify should display first slider page should.
		    Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
		    
		    //click on the info download link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationPrev);
	    	Thread.sleep(7000);
	    	//verify should display PDF Pop up.
	    	//click on the info download link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.infoDownloadLnk);
	    	Thread.sleep(10000);
	    	commanFunc.waitForElement(sliderPage1.cancelBtnFromPDFPopup,80);
	    	//verify PDF Popup dialog should display
	    	Assert.assertEquals(true, sliderPage1.cancelBtnFromPDFPopup.isDisplayed());
	    	//click on the cancel button from the PDF Popup dialog
	    	commanFunc.clickOnElement(sliderPage1.cancelBtnFromPDFPopup);
	    	Thread.sleep(10000);
	    	//verify PDF Pop up dialog should disappear
	    	Assert.assertEquals(true, !sliderPage1.cancelBtnFromPDFPopup.isDisplayed());
	    	
		}catch(Exception e){
			System.out.println("the expception is --->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightStartNewUserSessionThrowEmailTCINS010(){
		
		try{
			
			boolean bRet=false;
			boolean bRet1=false;
			boolean bRet2=false;
			boolean bRet3=false;
			String interID=null;
			String content=null;
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
			    
			    // launching the new session
			    
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
			    
			    driver.manage().deleteAllCookies();
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp(conts.emailUrl, sBuddyName,conts.emailPassword);
			    
			    commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
			    
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
	    	helperMethods.verifyString(actualText,"Please fill the *Required");
	    	
	    	// click on the warning dialog ok button   
	    	commanFunc.clickOnElement(sliderPage1.warnignDialogOkBtn);
	    	Thread.sleep(4000);
	    	
	    	
		}catch(Exception e){
			System.out.println("the expception is --->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightEngineCollapsedStateTCINS011()
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
		    
		    // launching the new session
		   // helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
		   
		    // clicking on myAppsMain Tab from the session list page
		    /*commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);*/
		    
		    helperMethods.loginAsValidUser(sLoginUrl, sBuddyName, sBuddyPassword);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(7000);
	    
		    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
	    		    
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.commentTxt.isDisplayed());
	    	// enter the text into the comment text box
	    	sliderPage1.commentTxt.sendKeys(sParam11);
	    	
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
	    	
	    	//verify should display previous slider[1 slider]page collapsed state
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	//click on the submit button form the review page
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	    	// getting the pop up text from the exit dialog
	    	String actualTxt = insightReviewPage.exitAppDialogParagTxt.getText().trim();
	    	// verifying the text from the exit dialog
	    	helperMethods.verifyString(actualTxt, sParam12);
	    	
	    	//click on the yes button from the exit dialog
	    	commanFunc.clickOnElement(insightReviewPage.exitAppDialogYesBtn);
	    	Thread.sleep(7000);
	    	//verify should display feedback page
	    	Assert.assertEquals(true, feedBackPage.feedbackTxt.isDisplayed());
	    	//click on the radio button from the feedback page
	    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
	    	Thread.sleep(2000);
	    	feedBackPage.feedbackTxt.sendKeys(sParam13);
	    	//click on the radio button from the feedback page
	    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
	    	Thread.sleep(7000);
	    	String actualFeebBackTxt = feedBackPage.feedbackDialogTxt.getText().trim();
	    	helperMethods.verifyString(actualFeebBackTxt, sParam14);
	    	//click on the feedback ok button
	    	commanFunc.clickOnElement(feedBackPage.feedbackDialogOkBtn);
	    	Thread.sleep(7000);
	    	//verify should display feedback page
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightEngineCollapsedStateTCINS012()
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
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
		   
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		   // helperMethods.loginAsValidUser(sLoginUrl, sBuddyName, sBuddyPassword);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(7000);
	    
		    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
	    		    
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.commentTxt.isDisplayed());
	    	// enter the text into the comment text box
	    	sliderPage1.commentTxt.sendKeys(sParam11);
	    	
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
	    	
	    	//verify should display previous slider[1 slider]page collapsed state
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	// getting the pop up text from the exit dialog
	    	String actualTxt = insightReviewPage.insightReviewThanksLbl.getText().trim();
	    	// verifying the text from the insight review page
	    	helperMethods.verifyString(actualTxt, conts.insightReviewPageText);

		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightEngineCollapsedStateTCINS013()
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
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
		   
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		    //helperMethods.loginAsValidUser(sLoginUrl, sBuddyName, sBuddyPassword);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(7000);
	    
		    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
	    		    
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.commentTxt.isDisplayed());
	    	// enter the text into the comment text box
	    	sliderPage1.commentTxt.sendKeys(sParam11);
	    	
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
	    	
	    	//verify should display previous slider[1 slider]page collapsed state
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	//click on the submit button form the review page
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	    	// getting the pop up text from the exit dialog
	    	String actualTxt = insightReviewPage.exitAppDialogParagTxt.getText().trim();
	    	// verifying the text from the exit dialog
	    	helperMethods.verifyString(actualTxt, sParam12);
	    	
	    	//click on the yes button from the exit dialog
	    	commanFunc.clickOnElement(insightReviewPage.exitAppDialogYesBtn);
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
	    	Thread.sleep(7000);
	    	//verify should display my apps page.
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	 
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightEngineCollapsedStateTCINS014()
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
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
		   
		    // clicking on myAppsMain Tab from the session list page
		    commanFunc.clickOnElement(adminDashBoard.myAppsMainTab);
		    commanFunc.WaitforElement(newSessionPage.beginBtn);
		    
		    //helperMethods.loginAsValidUser(sLoginUrl, sBuddyName, sBuddyPassword);
		    
		    // clicking on begin Button from the My Apps page
		    commanFunc.clickOnElement(newSessionPage.beginBtn);
		    Thread.sleep(7000);
	    
		    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
	    		    
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    		    
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.commentTxt.isDisplayed());
	    	// enter the text into the comment text box
	    	sliderPage1.commentTxt.sendKeys(sParam11);
	    	
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
	    	
	    	//verify should display previous slider[1 slider]page collapsed state
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	//click on the submit button form the review page
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	    	// getting the pop up text from the exit dialog
	    	String actualTxt = insightReviewPage.exitAppDialogParagTxt.getText().trim();
	    	// verifying the text from the exit dialog
	    	helperMethods.verifyString(actualTxt, sParam12);
	    	
	    	//click on the yes button from the exit dialog
	    	commanFunc.clickOnElement(insightReviewPage.exitAppDialogYesBtn);
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
	    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
	    	Thread.sleep(7000);
	    	//verify should display my apps page.
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	 
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightEnginePollingTCINS015()
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
		    sParam6=sParam6.trim();
		    sParam7=sParam7.trim();
		    sParam8=sParam8.trim();
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
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
	    	//verifying the check box shouldn't checked    	
	    	helperMethods.verifyString(pollingNtext.toString(),"chk-unchecked");
	    	
	    	//click on the 2nd polling yes check box  from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.pollingChkY2);
	    	Thread.sleep(2000);
	    	// getting the attribute value from the selected 2nd yes check box
	    	String pollingYtext2 = sliderPage1.divPollingYChk.getAttribute("class");
	    	//verifying the check box should checked
	    	helperMethods.verifyString(pollingYtext2.toString(),"chk-checked");
	    	
	    	//click on the 2nd polling yes check box  from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.pollingChkN2);
	    	Thread.sleep(2000);
	    	// getting the attribute value from the selected check box
	    	String pollingNtext2 = sliderPage1.divPollingYChk.getAttribute("class");
	    	//verifying the check box should checked
	    	helperMethods.verifyString(pollingNtext2.toString(),"chk-checked");
	    	
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
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
		    sParam6=sParam6.trim();
		    sParam7=sParam7.trim();
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
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
	
	//@Test(groups="lenfuncTest")
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
		    sParam6=sParam6.trim();
		    sParam7=sParam7.trim();
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
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

	//@Test(groups="lenfuncTest")
	public void inSightEngineCollapsedStateTCINS018()
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
		    sParam6=sParam6.trim();
		    sParam7=sParam7.trim();
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
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
	    	
	    	//click on the yes link from the first slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	    	
	    	//verify first question title,skip ,yes and no links should display in the slider page
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam9,"First Diagnostic Title Not Found");
	    	Assert.assertEquals(true, sliderPage1.skipNotClearLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.yesLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.noLnk.isDisplayed());
	    	
	    
	    	//verify should display details in the slider page
	    	Assert.assertEquals(true, sliderPage1.commentTxt.isDisplayed());
	    	
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.skipNotClearLnk);
	    	Thread.sleep(7000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationPrev);
	    	Thread.sleep(7000);
	    	
	    	//verify should display previous slider[1 slider]page collapsed state
	    	Assert.assertEquals(true, !sliderPage1.commentTxt.isDisplayed());
	    	
	    	
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightEngineCollapsedStateTCINS019()
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
		    sParam6=sParam6.trim();
		    sParam7=sParam7.trim();
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
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
	    		    
	    		//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
	    	Thread.sleep(7000);
	    	
	    	//verify should display my apps page
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(newSessionPage.continueAsessionTab);
	    	Thread.sleep(7000);
	    	
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(inProgressSessionListPage.continueTab);
	    	Thread.sleep(7000);
	    	
	    	//verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(9000);
	    	
	    	//verify should display startGivingResponce Button and clicking on it.
	    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
	    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
	    	Thread.sleep(7000);
	    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
	    	
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightEngineExpandedStateTCINS020()
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
		    sParam6=sParam6.trim();
		    sParam7=sParam7.trim();
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
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
	    		    
	    		//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(7000);
	    	
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
	    	Thread.sleep(7000);
	    	
	    	//verify should display my apps page
	    	Assert.assertEquals(true, newSessionPage.myAppsMainTab.isDisplayed());
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(newSessionPage.continueAsessionTab);
	    	Thread.sleep(7000);
	    	
	    	//click on the continue a session tab form the my apps page
	    	commanFunc.clickOnElement(inProgressSessionListPage.continueTab);
	    	Thread.sleep(7000);
	    	
	    	//verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(9000);
	    	
	    	//verify should display startGivingResponce Button and clicking on it.
	    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
	    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
	    	Thread.sleep(7000);
	    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//verify should display expanded state 
		    Assert.assertEquals(true, sliderPage1.explanationTxt.isDisplayed());
		    
	    	
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
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
		    sParam6=sParam6.trim();
		    sParam7=sParam7.trim();
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
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
	    		    
	    		//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(7000);
	    	
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
	    	
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
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
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
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
	
	//@Test(groups="lenfuncTest")
	public void inSightEngineContinueTabTCINS023()
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
		    sParam6=sParam6.trim();
		    sParam7=sParam7.trim();
		    sParam8=sParam8.trim();
		    sParam9=sParam9.trim();
		    sParam10=sParam10.trim();
		    sParam11=sParam11.trim();
		    
		    // launching the new session
		    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
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
	    		    
	    		//click on the next pagination button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(7000);
	    	
	    	//click on the save and quite button form the slider page
	    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
	    	Thread.sleep(7000);
	    	
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
	    	Thread.sleep(7000);
	    	
	    	//verify should display startInterview Button and clicking on it. 
		    Assert.assertEquals(true, beginAppPage.startInterviewBtn.isDisplayed());
	    	commanFunc.clickOnElement(beginAppPage.startInterviewBtn);
	    	Thread.sleep(9000);
	    	
	    	//verify should display startGivingResponce Button and clicking on it.
	    	Assert.assertEquals(true, topicsOverViewsPage.startGivingResponsesBtn.isDisplayed());
	    	commanFunc.clickOnElement(topicsOverViewsPage.startGivingResponsesBtn);
	    	Thread.sleep(7000);
	    	
	    	
	    	//verify second diagnostic title should display
	    	Assert.assertEquals(sliderPage1.diagnosticTitle.getText(),sParam10,"Second Diagnostic Title Not Found");
	    	
	    	
		}catch(Exception e){
			System.out.println("the exception is-->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightStartNewUserSessionThrowEmailTCINS024(){
		
		try{
			
			boolean bRet=false;
			boolean bRet1=false;
			boolean bRet2=false;
			boolean bRet3=false;
			String interID=null;
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
			    
			    // launching the new session
			   helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp(conts.emailUrl, sBuddyName,conts.emailPassword);
			    
			    commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    		    	
	    	Assert.assertEquals(true, insightReviewPage.reviewSubmitBtn.isDisplayed());
	    	commanFunc.clickOnElement(insightReviewPage.reviewSubmitBtn);
	    	Thread.sleep(7000);
	    	
	    	
	    	commanFunc.clickOnElement(insightReviewPage.exitAppDialogYesBtn);
	    	Thread.sleep(7000);
	    	commanFunc.clickOnElement(feedBackPage.excellentRadioBtn);
	    	Thread.sleep(1000);
	    	
	    	feedBackPage.feedbackTxt.sendKeys(sParam4.trim()+sTimeAppend);
	    	
	    	commanFunc.clickOnElement(feedBackPage.feedbackSubmitBtn);
	    	Thread.sleep(6000);
	    	    	
	    	commanFunc.clickOnElement(feedBackPage.feedbackDialogOkBtn);
	    	Thread.sleep(9000);
	    	
	    	commanFunc.windowSwitch();
	    	
	    	commanFunc.WaitforElement(loginPage.homePageLensesLogo);
	    	
	    	Assert.assertEquals(true, loginPage.homePageLensesLogo.isDisplayed());
	    	
	    	Thread.sleep(2000);
	    	
		}catch(Exception e){
			System.out.println("the expception is --->"+e);
		}
		
	}
	
	//@Test(groups="lenfuncTest")
	public void inSightEngineNewUserSessionSaveAndQuiteTCINS025(){
		
		try{
			
			boolean bRet=false;
			boolean bRet1=false;
			boolean bRet2=false;
			boolean bRet3=false;
			String interID=null;
			String content=null;
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
			    
			    // launching the new session
			    helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
			    
			    helperMethods.loginIntoMailAndClickOnBeginApp(conts.emailUrl, sBuddyName,conts.emailPassword);
			    
			    commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.saveAndQuitBtn);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.windowSwitch();
	    	
	    	commanFunc.WaitforElement(loginPage.homePageLensesLogo);
	    	
	    	Assert.assertEquals(true, loginPage.homePageLensesLogo.isDisplayed());
	    	
	    	Thread.sleep(2000);
	    	
		}catch(Exception e){
			System.out.println("the expception is --->"+e);
		}
		
	}

	@Test(groups="lenfuncTest")
	public void inSightEngineSessionIdealTimeOutTCINS026(){
		
		try{
			
			boolean bRet=false;
			boolean bRet1=false;
			boolean bRet2=false;
			boolean bRet3=false;
			String interID=null;
			String content=null;
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
			    //sParam6="Auto Test Invi Subj2014-06-27 16:52:46";
			    sParam7=sParam7.trim()+sTimeAppend;
			    sParam8=sParam8.trim();
			    sParam9=sParam9.trim();
			    sParam10=sParam10.trim();
			    sParam11=sParam11.trim();
			    sParam12=sParam12+sTimeAppend;
			    
			    // launching the new session
			    //helperMethods.sessionInvitionLaunchNow(sLoginUrl, sBuddyName, sBuddyPassword,sParam0, sParam1, sParam2, sParam3, sParam4, sParam5, sParam6, sParam7);
			    System.out.println("after launching the session invition email---------->>>>0000000000000");
			    driver.manage().deleteAllCookies();
			    helperMethods.loginIntoMailAndClickOnBeginApp(conts.emailUrl, sBuddyName,conts.emailPassword);
			    
			    commanFunc.refershPage();
			    
			    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
			    
			    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
	
	    	commanFunc.clickOnElement(sliderPage1.noLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam9,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	commanFunc.clickOnElement(sliderPage1.paginationNext);
	    	Thread.sleep(7000);
	    	
	    	commanFunc.clickOnElement(sliderPage1.yesLnk);
	    	Thread.sleep(2000);
	    	
	    	Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
	    	
	    	//commanFunc.waitForElement(sliderPage1.exitNowLnk,900);
	    	commanFunc.waitForElementToBeClickable(sliderPage1.exitNowLnkXpath,960);
	    	//Thread.sleep(7000);
	    	
	    	Assert.assertEquals(true, sliderPage1.exitNowLnk.isDisplayed());
	    	Assert.assertEquals(true, sliderPage1.continueNowLnk.isDisplayed());
	    	
	    	System.out.println("after display the ideal pup up dialog--------------->>>>1111111111");
	    	commanFunc.waitForElementToBeClickable(sliderPage1.exitNowLnkXpath,130);
	    	Thread.sleep(7000);
	    	System.out.println("after display the ideal pup up dialog---agai need to wait 2 mins------------>>>>22222222222");
	    	Assert.assertEquals(true, loginPage.usrNameTxt.isDisplayed());
	    	
	    	helperMethods.loginIntoMailAndClickOnBeginApp(conts.emailUrl, sBuddyName,conts.emailPassword);
	    	System.out.println("again login into the email and click on the begin app----------->>>>333333333");
		    commanFunc.refershPage();
		    
		    helperMethods.clickOnParticularSubJectFrmTheMail(sParam6);
		    System.out.println("after clicking on the particular subject from the email---------->>>>44444444");
		    helperMethods.clicOnBeginAppAndStartInterview(sParam3);
		    
		    System.out.println("i am in the second slider page");
		    Assert.assertEquals(sParam10,sliderPage1.diagnosticTitle.getText(),"text not found");
		    
	    	
		}catch(Exception e){
			System.out.println("the expception is --->"+e);
		}
		
	}
	
	@AfterMethod(groups="lenfuncTest",alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}



}
