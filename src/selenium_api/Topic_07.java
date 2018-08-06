package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Topic_07 {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void TC_01_Hover_Mouse() {

	
	
	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 30);
	}

	@AfterClass
	public void afterClass() {
	}

}
