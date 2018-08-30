package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_08_JS_Executor {

	WebDriver driver;

	public void TC_01() {

		openAnyURLByJS("http://live.guru99.com/");

		String domain = (String) executeJSForWebBrowser("return document.domain");
		Assert.assertEquals(domain, "live.guru99.com");

		String url = (String) executeJSForWebBrowser("return document.URL");
		Assert.assertEquals(url, "http://live.guru99.com/");

		WebElement mobileMemu = driver.findElement(By.xpath("//a[text()='Mobile']"));

		clickToElementByJS(mobileMemu);

		WebElement samSungProduct = driver.findElement(By.xpath(
				"//a[text()='Samsung Galaxy']/ancestor::h2/following-sibling::div//button[@title='Add to Cart']"));

		clickToElementByJS(samSungProduct);

		String innerText = executeJSForWebBrowser("return document.documentElement.innerText;").toString();

		Assert.assertTrue(innerText.contains("Samsung Galaxy was added to your shopping cart."));

		WebElement privacyLink = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));

		clickToElementByJS(privacyLink);

		String privacyTitle = executeJSForWebBrowser("return document.title;").toString();

		Assert.assertEquals(privacyTitle, "Privacy Policy");

		scrollToBottomPage();

		WebElement lastItem = driver.findElement(By.xpath(
				"//th[text()='WISHLIST_CNT']/following-sibling::td[text()='The number of items in your Wishlist.']"));

		Assert.assertEquals(lastItem.isDisplayed(), true);

		openAnyURLByJS("http://demo.guru99.com/v4/");

		String newDomain = (String) executeJSForWebBrowser("return document.domain");

		Assert.assertEquals(newDomain, "demo.guru99.com");
	}

	@Test
	public void TC_02() {
		
		openAnyURLByJS("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		
		WebElement lastNameBox = driver.findElement(By.xpath("//input[@name='lname']"));
		removeAttributeInDOM(lastNameBox, "disabled");
	}
	
	public Object executeJSForWebBrowser(String JS) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(JS);

	}

	public Object openAnyURLByJS(String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.location= '" + url + "'");
	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public Object clickToElementByJS(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object removeAttributeInDOM(WebElement element, String attribute) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}

}
