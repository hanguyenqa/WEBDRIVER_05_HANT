package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_07_Iframe {

	WebDriver driver;

	public void TC_01() {

		driver.get("https://www.hdfcbank.com/");

		// Close popup nếu có hiển thị
		List<WebElement> notificationIframe = driver.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
		if (notificationIframe.size() > 0) {

			driver.switchTo().frame(notificationIframe.get(0));
			driver.findElement(By.xpath("//div[@id='div-close']")).click();
			driver.switchTo().defaultContent();
			System.out.println("Popup displayed");
		}

		// Verify đoạn text được hiển thị: What are you looking for?
		WebElement lookingForIframe = driver.findElement(By.xpath("//div[@class='flipBannerWrap']//iframe"));

		driver.switchTo().frame(lookingForIframe);

		WebElement lookingForMessage = driver.findElement(By.xpath("//span[@id='messageText']"));

		Assert.assertEquals(lookingForMessage.getText(), "What are you looking for?");

		driver.switchTo().defaultContent();

		// Verify banner image được hiển thị, Verify banner có đúng 6 images
		WebElement imageIframe = driver.findElement(By.xpath("//div[@class='slidingbanners']//iframe"));

		driver.switchTo().frame(imageIframe);

		WebElement imageContainer = driver.findElement(By.xpath("//div[@id='productcontainer']"));
		Assert.assertTrue(imageContainer.isDisplayed());

		List<WebElement> images = driver.findElements(By.xpath("//div[@id='productcontainer']//img"));

		Assert.assertEquals(images.size(), 6);

		driver.switchTo().defaultContent();

		// Verify flipper banner được hiển thị và có 8 items

		WebElement flipperBanner = driver.findElement(By.xpath("//div[@class='flipBanner']"));
		Assert.assertTrue(flipperBanner.isDisplayed());

		List<WebElement> flipperImages = driver.findElements(By.xpath("//div[@class='flipBanner']//img[@class='front icon']"));
		Assert.assertEquals(flipperImages.size(), 8);

		for (int i = 0; i < flipperImages.size(); i++) {

			Assert.assertTrue(flipperImages.get(i).isDisplayed());

			System.out.println("Image " + (i + 1) + " displayed");
		}

	}

	public void TC_02() {

		driver.get("http://daominhdam.890m.com/");

		String parentWindow = driver.getWindowHandle();
		WebElement openGoogle = driver.findElement(By.xpath("//a[text()='Click Here']"));

		openGoogle.click();

		switchToWindowByTitle("Google");

		Assert.assertEquals(driver.getTitle(), "Google");

		closeAllWithoutParentWindows(parentWindow);

	}

	@Test
	public void TC_03() {

		driver.get("http://www.hdfcbank.com/");

		String parentWindow = driver.getWindowHandle();
		// Close popup nếu có hiển thị
		List<WebElement> notificationIframe = driver.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
		if (notificationIframe.size() > 0) {

			driver.switchTo().frame(notificationIframe.get(0));
			driver.findElement(By.xpath("//div[@id='div-close']")).click();
			driver.switchTo().defaultContent();
			System.out.println("Popup displayed");
		}

		WebElement agriLink = driver.findElement(By.xpath("//a[text()='Agri']"));
		agriLink.click();

		switchToWindowByTitle("HDFC Bank Kisan Dhan Vikas e-Kendra");

		WebElement accountDetailLink = driver.findElement(By.xpath("//p[text()='Account Details']"));
		accountDetailLink.click();

		switchToWindowByTitle("Welcome to HDFC Bank NetBanking");
		WebElement footerIframe = driver.findElement(By.xpath("//frame[@name='footer']"));

		driver.switchTo().frame(footerIframe);

		WebElement policyLink = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));

		policyLink.click();
		
		switchToWindowByTitle("HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
		
		WebElement csrLink = driver.findElement(By.xpath("//a[text()='CSR']"));
		csrLink.click();
		
		closeAllWithoutParentWindows(parentWindow);
		
		System.out.println(driver.getTitle());

	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindows(String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
