package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewSessionPage {
	
private WebDriver driver;
	
	public NewSessionPage(WebDriver driver){
		this.driver = driver;	
	}
	@FindBy(xpath="//a[contains(@href,'NewSessionList') or contains(text(),' Start A New Session ')]")
	public WebElement newSessionTab;	
	
	
	@FindBy(xpath="//a[@id='HeaderMenu_linkAdminPanel' or contains(text(),'Admin Panel')]")
	public WebElement adminPanelTab;	
	
	
	@FindBy(xpath="//a[@id='HeaderMenu_linkmyapplication' or text()='My Apps ']")
	public WebElement myAppsMainTab;
	
	@FindBy(xpath="(//div[@class='ButtonOrange'])[position()=1]")
	public WebElement beginBtn;
	
	
	@FindBy(xpath="//a[contains(@href,'InProgressSessionList') or text()=' Continue A Session ']")
	public WebElement continueAsessionTab;
	
}
