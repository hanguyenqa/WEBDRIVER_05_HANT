package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestNG_03_DataProvider {
	
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
	}

	@Test(dataProvider = "accounts")
	public void TC_LoginToSystem(String username, String password) {

	}

	@DataProvider
	public Object[][] accounts() {
		return new Object[][] { new Object[] { "automationvalid_01@gmail.com", "111111" }, new Object[] { "automationvalid_02@gmail.com", "111111" }, new Object[] { "automationvalid_03@gmail.com", "111111" } };
	}

	@AfterClass
	public void afterClass() {
	}

}
