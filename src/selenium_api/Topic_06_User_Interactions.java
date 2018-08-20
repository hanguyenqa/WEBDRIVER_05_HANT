package selenium_api;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_User_Interactions {

	WebDriver driver;
	WebDriverWait wait;

	public void TC_01_1_HoverMouse() throws Exception {

		driver.get("http://daominhdam.890m.com/");

		WebElement hoverText = driver.findElement(By.xpath("//a[text()='Hover over me']"));

		Actions action = new Actions(driver);
		action.moveToElement(hoverText).perform();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@role='tooltip']/div[@class='tooltip-inner']")).getText(), "Hooray!");

	}

	public void TC_01_2_HoverMouse() throws Exception {

		driver.get("https://www.myntra.com/");
		WebElement menu = driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"));
		WebElement loginButton = driver.findElement(By.xpath("//a[@data-track='login']"));

		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();

		loginButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']")).isDisplayed(), true);

	}

	public void TC_02_1_ClickAndHold() throws Exception {

		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");

		List<WebElement> selectTable = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));

		Actions action = new Actions(driver);
		action.clickAndHold(selectTable.get(0)).moveToElement(selectTable.get(3)).release().perform();

		Assert.assertEquals(driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']")).size(), 4);

	}

	public void TC_02_2_ClickAndHold() throws Exception {

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

	public void TC_03_DoubleClick() throws Exception {

		driver.get("http://www.seleniumlearn.com/double-click");

		WebElement button = driver.findElement(By.xpath("//button[text()='Double-Click Me!']"));

		Actions action = new Actions(driver);

		action.doubleClick(button).perform();

		Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
		Assert.assertEquals(textOnAlert, "The Button was double-clicked.");

		alert.accept();

	}

	public void TC_04_RightClick() throws Exception {

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement button = driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions action = new Actions(driver);

		action.contextClick(button).perform();

		WebElement quitButton = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]"));

		action.moveToElement(quitButton).perform();

		Thread.sleep(5000);

		Assert.assertEquals(driver.findElement(By.xpath("//li[contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]/span[text()='Quit']")).isDisplayed(), true);

		quitButton.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void TC_05_1_DropAndDrop() throws Exception {

		driver.get("http://demos.telerik.com/kendo-ui/dragdrop/angular");

		WebElement source = driver.findElement(By.xpath("//div[@id='droptarget']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='draggable']"));

		Assert.assertEquals(source.getText(), "Drag the small circle here.");

		Actions action = new Actions(driver);
		action.clickAndHold(target).moveToElement(source).release().perform();

		Assert.assertEquals(source.getText(), "You did great!");

		Thread.sleep(5000);

	}

	@Test
	public void TC_05_2_DropAndDrop() throws Exception {

		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		Thread.sleep(5000);

		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions action = new Actions(driver);
		action.clickAndHold(target).moveToElement(source).release().perform();

		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Dropped!']")).isDisplayed(), true);

		Thread.sleep(5000);

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
