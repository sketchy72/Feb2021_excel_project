package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashBoardPage extends BasePage {
	
	WebDriver driver;
	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement DASHBOARD_TITLE_ELEMENT;
	@FindBy(how=How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement CUSTOMERS_ELEMENT;
	@FindBy(how=How.XPATH, using = "//a[contains(text(), 'Add Customer')]") WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how=How.XPATH, using = "//a[contains(text(), 'List Customer')]") WebElement LIST_CUSTOMER_ELEMENT;
	
	
	public void varifyDashboardPage() {
		Assert.assertEquals(DASHBOARD_TITLE_ELEMENT.getText(), "Dashboard", "Wrong Page!!");
	}

	public void clickCustomerButton() {
		CUSTOMERS_ELEMENT.click();
	}
	
	public void clickAddCustomerButton() {
		waitForElement(driver, 5, ADD_CUSTOMER_ELEMENT);
		ADD_CUSTOMER_ELEMENT.click();
	}

	public void clickListCustomerButton() {
		LIST_CUSTOMER_ELEMENT.click();
	}
	
}
