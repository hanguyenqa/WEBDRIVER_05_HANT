package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TestNG_03_DataProvider {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
	}

	@Test(dataProvider = "accounts")
	public void TC_LoginToSystem(String username, String password) {

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed(), true);
		
	}

	@DataProvider
	public Object[][] accounts() {
		return new Object[][] { new Object[] { "automationvalid_01@gmail.com", "111111" }, new Object[] { "automationvalid_02@gmail.com", "111111" }, new Object[] { "automationvalid_03@gmail.com", "111111" } };
	}

	@AfterMethod
	public void afterMethod() {
		
		driver.quit();
	}

}
