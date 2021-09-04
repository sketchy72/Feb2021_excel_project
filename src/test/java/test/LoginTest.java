package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import util.BrowserFactory;
import util.ReadExcel;
import page.DashBoardPage;
import page.LoginPage;

public class LoginTest {
	
	WebDriver driver;
	
	ReadExcel exlread = new ReadExcel("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void loginTest() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserName(userName);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		
		DashBoardPage dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardPage.varifyDashboardPage();
		
		BrowserFactory.tearDown();
	}
}
