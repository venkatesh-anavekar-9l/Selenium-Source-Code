package com.lenses.CommanFunc;

import java.awt.Robot;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lenses.ObjectRep.MailPage;
import com.lenses.ObjectRep.SessionSetUpPage;



public class CommanFunctions {
	WebDriver driver;
	Actions builder;
	WebDriverWait wait;
	WebElement element;
	MailPage mailPage = null;
	SessionSetUpPage sessionSetUpPage = null;
	
	public CommanFunctions(WebDriver driver)
	{
		this.driver = driver;
		//sessionSetUpPage=PageFactory.initElements(driver, SessionSetUpPage.class);
		//mailPage=PageFactory.initElements(driver, MailPage.class);
		
	}
	/*static Logger logger = Logger.getLogger(CommanFunctions.class);
	static
	{
		DOMConfigurator.configure("log4j.xml");
	}	*/
	public void clickOnElement(WebElement element)
	{
		try
		{
			builder=new Actions(driver);
			WaitforElement(element);
			builder.moveToElement(element).click().build().perform();
			//Thread.sleep(7000);
		}catch(Exception e){
			//logger.error("Error in clickOnElement method-->"+e);
		}
	}
	
	public void WaitforElement(WebElement element){
		
		try
		{
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			//wait.until(ExpectedConditions.elementToBeClickable((By) element));
		}
		catch(Exception e)
		{
			//logger.error("Error in WaitforElement method-->"+e);
		}
	}	
	
	
	
	public void waitForElement10Mins(WebElement element){
		
		try
		{
			//wait = new WebDriverWait(driver, 60);
			//wait.until(ExpectedConditions.visibilityOf(element));
			//wait.until(ExpectedConditions.elementToBeClickable((By) element));
			 wait = new WebDriverWait(driver, 600); // The int here is the maximum time in seconds the element can wait.
			//wait.until(ExpectedConditions.visibilityOfElementLocated(element);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			//logger.error("Error in WaitforElement method-->"+e);
		}
	}
	
	public void waitForElement(WebElement element,int timeOut){
		
		try
		{
			wait = new WebDriverWait(driver, timeOut); // The int here is the maximum time in seconds the element can wait.
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			//logger.error("Error in WaitforElement method-->"+e);
		}
	}
	
	public WebElement waitForElementToBeClickable(String elementXpath,int timeOut){
		
		try
		{
			wait = new WebDriverWait(driver, timeOut); // The int here is the maximum time in seconds the element can wait.
		    element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
			
		}
		catch(Exception e)
		{
			//logger.error("Error in WaitforElement method-->"+e);
			System.out.println("the exception caught in the waitForElementToBeClickable method");
		}
		return element;
	}
	
/*	// Waiting 30 seconds for an element to be present on the page, checking
	   // for its presence once every 5 seconds.
	
			WebDriverWait wait1 = (WebDriverWait) new FluentWait<WebDriver>(driver)
	       .withTimeout(30, TimeUnit.SECONDS)
	       .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	       

	   WebElement foo = wait1.until(new Function<WebDriver, WebElement>() {
	     public WebElement apply(WebDriver driver) {
	       return driver.findElement(By.id("foo"));
	     }
	   });*/

	public void mouseOverOnElement(WebElement tagElement)
	{
		try
		{
			builder=new Actions(driver);
			WaitforElement(tagElement);
	   
		   Point coordinate=tagElement.getLocation();
		   Robot robot=new Robot();
		   builder.moveToElement(tagElement, 5,5).build().perform();
		   builder.moveByOffset(1, 1).build().perform();
		   robot.mouseMove(coordinate.getX()+5,coordinate.getY()+63);
		   //logger.info("x and y coordinate--->"+coordinate.getX()+"---"+coordinate.getY()+60);

		   Thread.sleep(2000);
		}
		catch(Exception e)
		{
			//logger.info("Error message in mouseOverOnElement method-->"+e);
		}
	}
	
	public boolean isElementPresent(String xpath) {
    	System.out.println("i m in the is element present method");
		boolean present;
    	try {
    		driver.findElement(By.xpath(xpath));
    		present = true;
    		System.out.println("the eeeeeeeeeeeeeeeeeee try block");
    	} catch (Exception e) {
    		System.out.println("the eeeeeeeeeeeeeeeeeee catch block"+e);
    		present = false;
    	}
    	return present;
    }
	
	public void scrollDownThePage(int x_axis,int y_axis)
	{
		builder=new Actions(driver);
		wait = new WebDriverWait(driver, 40);
		
		JavascriptExecutor jsx = (JavascriptExecutor)driver;		
		jsx.executeScript("window.scrollBy("+x_axis+","+y_axis+")", "");
		
	}
	public void pageScrolling(int x_axis,int y_axis,WebElement ele)
	{
		builder=new Actions(driver);
		wait = new WebDriverWait(driver, 40);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;		
		//try{
		//	for (int second = 0;; second++) {
			//	if(second >=60){
			//		break;
		//		}
             //   jsx.executeScript("window.scrollBy("+x_axis+","+y_axis+")", "");
             //   Thread.sleep(1000);
			//	if(driver.findElements(By.xpath(element)).size() != 0)
				//{
				//	break;
				//}
			//}
		//}catch(Exception e){
		//logger.error("Error in pageScrolling method-->"+e);
		//}
		jsx.executeScript("arguments[0].scrollIntoView(true);",ele);
	}
	public void enableElementViaJavaScript(WebElement ele)
	{
		try{
			JavascriptExecutor js = (JavascriptExecutor) driver;   
			js.executeScript("arguments[0].style.visibility = 'visible';arguments[0].style.display = 'inherit';arguments[0].class = ''",ele);
		}catch(Exception e){
		}
			
	}

	public void enableElementViaJavaScriptAndClick(WebElement ele)
	{
		try{
			JavascriptExecutor js = (JavascriptExecutor) driver;   
			js.executeScript("arguments[0].style.visibility = 'visible';arguments[0].style.display = 'inherit';arguments[0].class = ''",ele);
			builder.moveToElement(ele).click().build().perform();
			//builder.moveToElement(ele).click().build().perform();
		}catch(Exception e){
		}
			
	}
	public void refershPage()
	{
		try{
			driver.navigate().refresh();
			Thread.sleep(4000);
		}catch(Exception e){
		
		}
			
	}
	public void checkAlert() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 6);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    } catch (Exception e) {
	        //exception handling
	    }
	}
	
	public void windowSwitch() {
	    try {
	    	 String parentWindow = driver.getWindowHandle();
	 	     Set<String> handles =  driver.getWindowHandles();
	 	    for(String windowHandle  : handles)
	 	    {
	 	        if(!windowHandle.equals(parentWindow))
	 	       {
	 	         driver.switchTo().window(windowHandle);
	 	       }
	 	    }
	    } catch (Exception e) {
	        //exception handling
	    }
	}
	
	// it will click on the particular subject and begin app btn from the email inbox
	public void clickOnSpecificSubjectAndBeginAppFromTheMailInbox(String subject) {
	    try {
	    	//mailPage=PageFactory.initElements(driver, MailPage.class);
	    	WebElement ele = driver.findElement(By.xpath("//span[text()='"+ subject +"']"));
	    	
			mouseOverOnElement(ele);
	    	clickOnElement(ele);
	    	Thread.sleep(5000);
	    	clickOnElement(mailPage.beginTheAppBtn);
	    	Thread.sleep(10000);
	    } catch (Exception e) {
	        //exception handling
	    }
	}
	
	public void scltCompanyFrmDropDown(String companyNme) {
		
		sessionSetUpPage=PageFactory.initElements(driver, SessionSetUpPage.class);
		System.out.println("the sclt Company DropDown Method");
	    try {
	    	Select custGrp = new Select(sessionSetUpPage.scltCustomerGrp);
	    	
	    	System.out.println("the company name"+companyNme);
	    	
	    	custGrp.selectByVisibleText(companyNme);
	    	clickOnElement(sessionSetUpPage.applyLnk);
	    	Thread.sleep(6000);
	    } catch (Exception e) {
	        //exception handling
	    }
	}
	
	
	
}
