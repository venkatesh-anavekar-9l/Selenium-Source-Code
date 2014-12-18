package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InprogressSessionListPage {
			
	WebDriver driver;
	
			public InprogressSessionListPage(WebDriver driver){
				this.driver = driver;	
			}
			@FindBy(xpath="(//div[@class='ButtonOrange'])[position()=1]")
			public WebElement continueTab;	
			
			@FindBy(xpath="(//div[@class='ButtonOrange']/parent::*/parent::*/descendant::*/p)[position()=1]")
			public WebElement inProgressAppsName;		
}
