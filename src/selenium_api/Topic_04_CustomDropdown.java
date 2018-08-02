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

public class Topic_04_CustomDropdown {

	WebDriver driver;
	
	WebDriverWait wait;
	

	@Test
	public void TC_01() throws Exception {
		
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 
		 wait = new WebDriverWait(driver, 30);
		 
//		 driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
//		 
//		 selectCustomDropdownList("//*[@id='number-button']/span[@class='ui-selectmenu-text']", "//ul[@id='number-menu']/li[@class='ui-menu-item']", "19");
//		 
//		 Assert.assertEquals(driver.findElement(By.xpath("//*[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),"19");
		 
		 driver.get("https://material.angular.io/components/select/examples");
		 selectCustomDropdownList("//div[@class='mat-select-value']/span[text()='Favorite food']", "//mat-option[@role='option']/span", "Tacos");
		 Assert.assertEquals(driver.findElement(By.xpath("//*[@class='mat-select-value']/span")).getText(),"Tacos");
		 
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
	}

	@AfterClass
	public void afterClass() {
	}

}
