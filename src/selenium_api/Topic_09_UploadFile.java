package selenium_api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_09_UploadFile {
	
	WebDriver driver;

	String projectDirectory = System.getProperty("user.dir");
	String imageFolder = "images";	
	String fileName = "ha.jpg";	
	String uploadFilePath = projectDirectory + "\\" + imageFolder + "\\" + fileName;
	@Test
	public void TC_01() throws Exception {

		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
		uploadElement.sendKeys(uploadFilePath);
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());
		
		WebElement uploadButton = driver.findElement(By.xpath("//button[@class=\"btn btn-primary start\"]//span[text()='Start']"));
		uploadButton.click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + fileName + "']")).isDisplayed());
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
