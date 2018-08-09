package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_07_User_Interactions {

	WebDriver driver;
	WebDriverWait wait;

	public void TC_01_1_Hover_Mouse() throws Exception {

		driver.get("http://daominhdam.890m.com/");

		WebElement hoverText = driver.findElement(By.xpath("//a[text()='Hover over me']"));

		Actions action = new Actions(driver);
		action.moveToElement(hoverText).perform();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@role='tooltip']/div[@class='tooltip-inner']")).getText(), "Hooray!");

	}

	public void TC_01_2_Hover_Mouse() throws Exception {

		driver.get("https://www.myntra.com/");
		WebElement menu = driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"));
		WebElement loginButton = driver.findElement(By.xpath("//a[@data-track='login']"));

		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();

		loginButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']")).isDisplayed(), true);

	}

	public void TC_02_1_Click_And_Hold() throws Exception {

		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");

		List<WebElement> selectTable = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));

		Actions action = new Actions(driver);
		action.clickAndHold(selectTable.get(0)).moveToElement(selectTable.get(3)).release().perform();

		Assert.assertEquals(driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']")).size(), 4);

	}

	public void TC_02_2_Click_And_Hold() throws Exception {

		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");

		List<WebElement> selectTable = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));

		Actions action = new Actions(driver);
		// action.clickAndHold(selectTable.get(0)).moveToElement(selectTable.get(3)).release().perform();
		action.keyDown(Keys.CONTROL).build().perform();
		selectTable.get(0).click();
		selectTable.get(2).click();
		selectTable.get(4).click();
		selectTable.get(6).click();

		action.keyUp(Keys.CONTROL).build().perform();

		Assert.assertEquals(driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']")).size(), 4);

	}

	@Test
	public void TC_03_Double_Click() throws Exception {
		
		driver.get("http://www.seleniumlearn.com/double-click");
		
		WebElement button = driver.findElement(By.xpath("//button[text()='Double-Click Me!']"));

		Actions action = new Actions(driver);
		
		action.doubleClick(button).perform();

		
		
		

	}

	@BeforeClass
	public void beforeClass() {

		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 30);
	}

	@AfterClass
	public void afterClass() {

		driver.close();
	}

}
