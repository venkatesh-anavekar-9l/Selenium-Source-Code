package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminDashBoardPage {
	
	private WebDriver driver;
	
	public AdminDashBoardPage(WebDriver driver){
		this.driver = driver;	
	}
	
	@FindBy(xpath="//a[contains(@href,'Dashboard') and text()='Dashboard']")
	public WebElement dashBoardTab;	
	
	
	@FindBy(xpath="//a[contains(@href,'Applications') and text()='Apps']")
	public WebElement appsTab;
	
	
	@FindBy(xpath="//a[contains(@href,'/NewSessionList.aspx') and contains(text(),'My Apps')]")
	public WebElement myAppsMainTab;
	
	@FindBy(xpath="//a[contains(text(),'App Templates')]")
	public WebElement appsTemplate;
	
	@FindBy(xpath="//span[contains(text(),'Administer Apps')]")
	public WebElement administerApps;
	
	
	
}
