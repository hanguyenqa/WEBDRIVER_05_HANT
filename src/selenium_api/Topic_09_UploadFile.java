package selenium_api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_09_UploadFile {

	WebDriver driver;

	String projectDirectory = System.getProperty("user.dir");
	String imageFolder = "images";
	String uploadFolder = "upload";
	String fileName = "ha.jpg";
	String uploadFilePath = projectDirectory + "\\" + imageFolder + "\\" + fileName;
	String chromeUpload = projectDirectory + "\\" + uploadFolder + "\\chrome.exe";
	String firefoxUpload = projectDirectory + "\\" + uploadFolder + "\\firefox.exe";
	String ieUpload = projectDirectory + "\\" + uploadFolder + "\\ie.exe";
	String folderName = "Test" + random(1000,9999);
	String email = "test@test.com";
	String name = "Ha";
	

	public void TC_01_upload_By_Senkeys() throws Exception {

		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
		uploadElement.sendKeys(uploadFilePath);
		Assert.assertTrue(
				driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());

		WebElement uploadButton = driver
				.findElement(By.xpath("//button[@class=\"btn btn-primary start\"]//span[text()='Start']"));
		uploadButton.click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//p[@class='name']/a[@title='" + fileName + "']")).isDisplayed());
	}

	public void TC_02_upload_By_AutoIT() throws Exception {

		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		WebElement uploadElement = driver.findElement(By.cssSelector(".fileinput-button"));
		uploadElement.click();

		Runtime.getRuntime().exec(new String[] { chromeUpload, uploadFilePath });
		// Runtime.getRuntime().exec(new String[] { firefoxUpload, uploadFilePath });
		// Runtime.getRuntime().exec(new String[] { ieUpload, uploadFilePath });

		Assert.assertTrue(
				driver.findElement(By.xpath("//p[@class='name' and text()='" + fileName + "']")).isDisplayed());

		WebElement uploadButton = driver
				.findElement(By.xpath("//button[@class=\"btn btn-primary start\"]//span[text()='Start']"));
		uploadButton.click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//p[@class='name']/a[@title='" + fileName + "']")).isDisplayed());
	}

	public void TC_03_upload_By_Robot() throws Exception {

		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// Specify the file location with extension
		StringSelection select = new StringSelection(uploadFilePath);

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		// Click
		driver.findElement(By.className("fileinput-button")).click();

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	@Test
	public void TC_04() throws Exception {

		driver.get("https://encodable.com/uploaddemo/");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(uploadFilePath);

		WebElement uploadToElement = driver.findElement(By.xpath("//select[@name='subdir1']"));

		Select select = new Select(uploadToElement);

		select.selectByVisibleText("/uploaddemo/files/");
		
		driver.findElement(By.xpath("//input[@id='newsubdir1']")).sendKeys(folderName);
		driver.findElement(By.xpath("//input[@id='formfield-email_address']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='formfield-first_name']")).sendKeys(name);

		driver.findElement(By.xpath("//input[@id='uploadbutton']")).click();
	
		Assert.assertTrue(driver.findElement(By.xpath("//dl[@id='fcuploadsummary']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//dl[@id='fcuploadsummary']//dd[text()='Email Address: " + email + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//dl[@id='fcuploadsummary']//dd[text()='First Name: " + name + "']")).isDisplayed());
		
		
		driver.findElement(By.xpath("//a[text()='View Uploaded Files']")).click();
		driver.findElement(By.xpath("//a[text()='"+ folderName +"']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + fileName + "']")).isDisplayed());
		
			
		
	}

	
	public int random(int maximum, int minimum)
	{
		Random rn = new Random();
		int n = maximum - minimum + 1;
		int i = rn.nextInt() % n;
		return  minimum + i;
	}
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();

//		 driver = new ChromeDriver();
//		 driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
