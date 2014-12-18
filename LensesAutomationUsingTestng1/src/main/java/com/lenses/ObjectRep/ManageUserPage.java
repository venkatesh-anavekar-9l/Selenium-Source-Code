package com.lenses.ObjectRep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUserPage {

	private WebDriver driver;
	
	public ManageUserPage(WebDriver driver){
		this.driver = driver;	
	}
	
	@FindBy(xpath="//span[text()='Users ']")
	public WebElement usersTab;
	
	@FindBy(xpath="//a[@class='userpage_key' or text()='Manage Users']")
	public WebElement manageUsersTab;
	
	@FindBy(xpath="//h3[contains(text(),' 9Lenses')]")
	public WebElement userListPage;
	
	@FindBy(xpath="//div[contains(text(),'+ Add New User')]")
	public WebElement addNewUserBtn;
	
	@FindBy(xpath="//h4[contains(text(),'Add A New User')]")
	public WebElement addNewUserTxt;
	
	@FindBy(xpath="(//a[text()='Cancel'])[position()=3]")
	public WebElement cancelPopUp;
	
	@FindBy(xpath="//p[contains(text(),'Name')]")
	public WebElement namePopUpTxt;
	
	@FindBy(xpath="//p[contains(text(),'Email:')]")
	public WebElement emailPopUpTxt;
	
	@FindBy(xpath="//input[@id='txtfname' or @placeholder='First name']")
	public WebElement nameTxtField;
	
	@FindBy(xpath="//input[@id='txtmname' or @placeholder='M']")
	public WebElement middleNameTxtField;
	
	@FindBy(xpath="//input[@id='txtlname' or @placeholder='Last Name']")
	public WebElement lastNameTxtField;
	
	@FindBy(xpath="//input[@id='txtemail' or @placeholder='userName@companyName.com']")
	public WebElement emailTxtField;
	
	@FindBy(xpath="(//a[@href='#' and text()='Add'])[position()=2]")
	public WebElement addBtn;
	
	@FindBy(xpath="//span[@id='lblcontentmessage' or text()='The User has been added successfully']")
	public WebElement successfullyAddedTxt;
	
	@FindBy(xpath="//a[@id='btnOkayDialog']")
	public WebElement oKBtn;
	
	
	
}
