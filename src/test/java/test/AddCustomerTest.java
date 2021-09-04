package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import util.BrowserFactory;
import util.ReadExcel;
import page.DashBoardPage;
import page.LoginPage;
import page.AddCustomerPage;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ReadExcel exlread = new ReadExcel("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	
	String fullname = exlread.getCellData("AddContactInfo", "FullName", 2);
	String companyname = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlread.getCellData("AddContactInfo", "Email", 2);
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String state = exlread.getCellData("AddContactInfo", "State", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver,LoginPage.class);
		loginpage.enterUserName(userName);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		
		DashBoardPage dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardPage.varifyDashboardPage(); 
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullname);
		addCustomerPage.enterCompanyName(companyname);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.clickSaveButtonOnAddCustomerPage();
		
		dashboardPage.clickListCustomerButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
		//BrowserFactory.tearDown();
	}

}
