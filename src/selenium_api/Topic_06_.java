package selenium_api;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_06_ {

	WebDriver driver;
	WebDriverWait wait;

	public void TC_01_Button() throws Exception {

		driver.get("http://live.guru99.com/");

		// Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed());

		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='account-login']")).isDisplayed());

		String loginUrl = driver.getCurrentUrl();

		Assert.assertEquals(loginUrl, "http://live.guru99.com/index.php/customer/account/login/");

		// Thread.sleep(5000);

		clickElementByJavascript("//a[@title='Create an Account']");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='account-create']")).isDisplayed());

		String signupUrl = driver.getCurrentUrl();
		Assert.assertEquals(signupUrl, "http://live.guru99.com/index.php/customer/account/create/");

	}

	// @Test
	public void TC_02_CustomeCheckbox() {
		driver.get("https://demos.telerik.com/kendo-ui/styling/checkboxes");

		String dualZoneCheckbox = "//label[text()='Dual-zone air conditioning']/preceding-sibling::input";

		clickElementByJavascript(dualZoneCheckbox);

		Assert.assertTrue(isElementSelected(dualZoneCheckbox));

		unCheckSelectbox(dualZoneCheckbox);

		Assert.assertTrue(!isElementSelected(dualZoneCheckbox));

	}

	// @Test
	public void TC_03() {

		driver.get("https://demos.telerik.com/kendo-ui/styling/radios");

		String thirdPetrolRadioButtonString = "//label[@for='engine3']/preceding-sibling::input";

		checkRadioButton(thirdPetrolRadioButtonString);

		Assert.assertTrue(isElementSelected(thirdPetrolRadioButtonString));

	}

	// @Test
	public void TC_04() {

		driver.get("http://daominhdam.890m.com/");

		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

		Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
		Assert.assertEquals(textOnAlert, "I am a JS Alert");

		alert.accept();

		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked an alert successfully");

	}

	//@Test
	public void TC_05() {
		
		driver.get("http://daominhdam.890m.com/");
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		
		Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
		Assert.assertEquals(textOnAlert, "I am a JS Confirm");
		
		alert.dismiss();
		
		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Cancel");
		
	}
	
	@Test
	public void TC_06() throws Exception {

		driver.get("http://daominhdam.890m.com/");

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

		Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
		Assert.assertEquals(textOnAlert, "I am a JS prompt");

		Thread.sleep(5000);
		
		alert.sendKeys("daominhdao");
		
		Thread.sleep(5000);
		alert.dismiss();
		
		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: daominhdam");

	}

	public void checkRadioButton(String locator) {

		if (!isElementSelected(locator)) {
			clickElementByJavascript(locator);
		}
	}

	public void clickElementByJavascript(String locator) {

		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	public boolean isElementSelected(String locator) {

		return driver.findElement(By.xpath(locator)).isSelected();
	}

	public void unCheckSelectbox(String locator) {

		if (isElementSelected(locator)) {
			clickElementByJavascript(locator);
		}
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

		driver.close();
	}

}
