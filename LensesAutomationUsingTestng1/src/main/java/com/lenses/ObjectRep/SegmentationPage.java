package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SegmentationPage {
	
	WebDriver driver;
	public SegmentationPage(WebDriver driver){
		this.driver = driver;
	}
	
	//@FindBy(xpath="//select[@class='inputAnswer ng-pristine ng-valid']")
	@FindBy(xpath="(//select[contains(@class,'inputAnswer')])[position()=1]")
	public WebElement inputAnserSclt;
	//@FindBy(xpath="//div[@class='styled-select-inputAnswer']")
	//public WebElement inputAnserSclt;
	
	
	//@FindBy(xpath="//input[@value='Next']")
	//public WebElement nextBtn;
	@FindBy(xpath="//button[contains(text(),'Next')]")
	public WebElement nextBtn;
	
	@FindBy(xpath="//p[contains(text(),'Select The Best Answers:')]")
	public WebElement pageText;
	
	@FindBy(xpath="//span[contains(text(),'prev')]")
	public WebElement pagePrevBtn;
	
	
}
