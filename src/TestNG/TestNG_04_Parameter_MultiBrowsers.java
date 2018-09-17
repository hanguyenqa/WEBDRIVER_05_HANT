package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TestNG_04_Parameter_MultiBrowsers {

	WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void beforeClass(String browser) {

		if (browser.equals("firefox")) {

			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {

			driver = new ChromeDriver();
		}

		
	}

	@Test(invocationCount = 5)
	public void TC_LoginToSystem() {
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automationvalid_02@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("111111");
		driver.findElement(By.xpath("//button[@id='send2']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed());

	}

	@AfterMethod
	public void afterClass() {

		driver.quit();
	}

}
