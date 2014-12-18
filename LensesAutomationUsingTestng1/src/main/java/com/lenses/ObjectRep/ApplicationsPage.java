package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationsPage {
	
private WebDriver driver;
	
	public ApplicationsPage(WebDriver driver){
		this.driver = driver;	
	}
	
	@FindBy(xpath="//a[@id='a9LensesApps']")
	public WebElement prePacklensesApp;	
	
	@FindBy(xpath="//a[@id='aCompanyApps']")
	public WebElement companyApp;
	
	
	@FindBy(xpath="//a[@class='show_hide']")
	public WebElement showHideLnk;
	
	@FindBy(xpath="//input[@id='searchapp']")
	public WebElement searchAppTxt;
	
	@FindBy(xpath="//a[@class='topperFunctionButton' and text()='Search']")
	public WebElement searchBtn;
	
	// search result section
	
	@FindBy(xpath="//span[@class='blockTextTitle search_text']")
	public WebElement searchResAppTitle;
	
	
	//@FindBy(xpath="//a[contains(@href,'sessionsetup')]")
	@FindBy(xpath="//a[contains(text(),'Use App')]")
	public WebElement useAppLnk;
	
}
