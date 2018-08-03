package selenium_api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Topic_05_CustomDropdown {

	WebDriver driver;

	WebDriverWait wait;

	@Test
	public void TC_01() throws Exception {

		//// Jquery
		// driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		//
		// selectCustomDropdownList("//*[@id='number-button']/span[@class='ui-selectmenu-text']", "//ul[@id='number-menu']/li[@class='ui-menu-item']", "19");
		//
		// Assert.assertEquals(driver.findElement(By.xpath("//*[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),"19");

		// // Angular
		// driver.get("https://material.angular.io/components/select/examples");
		// selectCustomDropdownList("//div[@class='mat-select-value']/span[text()='Favorite food']", "//mat-option[@role='option']/span", "Tacos");
		// Assert.assertEquals(driver.findElement(By.xpath("//div[@class='mat-select-value']/span")).getText(), "Tacos");

		// //Kendo UI
		// driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		// selectCustomDropdownList("//div[@id='cap-view']//span[text()='Black']", "//ul[@id='color_listbox']/li", "Grey");
		// Assert.assertEquals(driver.findElement(By.xpath("//div[@id='cap-view']//span[text()='Grey']")).getText(),"Grey");

		// // vue-dropdowns
		// driver.get("https://mikerodham.github.io/vue-dropdowns/");
		// selectCustomDropdownList("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']/li", "Third Option");
		// Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Third Option");

		//Editable
		driver.get("http://indrimuska.github.io/jquery-editable-select/");

		WebElement dropDown = driver.findElement(By.xpath("//div[@id='basic-place']/input"));

		dropDown.clear();

		dropDown.sendKeys("fi");

		driver.findElement(By.xpath("//ul[@class='es-list']/li[text()='Fiat']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@style='display: block;']")).getText(), "Fiat");
		

	}

	public void selectCustomDropdownList(String dropdown, String listitem, String valueitem) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(dropdown));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath(dropdown)).click();
		List<WebElement> allitem = driver.findElements(By.xpath(listitem));

		wait.until(ExpectedConditions.visibilityOfAllElements(allitem));

		for (WebElement item : allitem) {
			if (item.getText().equals(valueitem)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
				item.click();
				Thread.sleep(3000);
				break;
			}
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

		driver.quit();
	}

}
