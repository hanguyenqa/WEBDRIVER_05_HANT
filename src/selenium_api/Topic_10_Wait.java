package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_10_Wait {

	WebDriver driver;	
	WebDriverWait wait;

	public void TC_01_implicitWait() {

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

		driver.findElement(By.xpath("//button[text()='Start']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
	}

	@Test
	public void TC_02_explicitWait() {

		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='calendarContainer']")));
		
		WebElement selectedDate = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"));
		
		Assert.assertEquals(selectedDate.getText(), "No Selected Dates to display.");
		
		driver.findElement(By.xpath("//tr[@class='rcRow']//a[text()='11']")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='rcSelected']//a[text()='11']")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText(), "Tuesday, September 11, 2018");
		
	}

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, 30);
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
