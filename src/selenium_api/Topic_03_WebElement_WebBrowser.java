package selenium_api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_WebElement_WebBrowser {
	
	
	
  WebDriver driver;
  
  
  @Test
  public void TC_01_CheckDisplayedElements() throws InterruptedException {

	  /*Test Script 01: Kiểm tra phần tử hiển thị trên trang
	Step 01 - Truy cập vào trang: http://daominhdam.890m.com/
	Step 02 - Kiểm tra các phần tử sau hiển thị trên trang: Email/ Age (Under 18)/ Education
	Step 03 - Nếu có nhập giá trị: Automation Testing vào 2 field Email/ Education và chọn Age = Under 18
	*/
	  
	 //Step 01 - Truy cập vào trang: http://daominhdam.890m.com/
	driver.get("http://daominhdam.890m.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//Step 02 - Kiểm tra các phần tử sau hiển thị trên trang: Email/ Age (Under 18)/ Education
	
	Thread.sleep(3000);
	
	boolean isEmailDisplayed = driver.findElement(By.xpath("//label[@for='mail']")).isDisplayed();
	
	Assert.assertTrue(isEmailDisplayed);
	
	boolean isAgeDisplayed = driver.findElement(By.xpath("//label[@for='under_18']")).isDisplayed();
	
	Assert.assertTrue(isAgeDisplayed);
	
	boolean isEduDisplayed = driver.findElement(By.xpath("//label[@for='edu']")).isDisplayed();
	
	Assert.assertTrue(isEduDisplayed);
	
	//Step 03 - Nếu có nhập giá trị: Automation Testing vào 2 field Email/ Education và chọn Age = Under 18
	
	driver.findElement(By.id("mail")).sendKeys("Education");
	driver.findElement(By.id("edu")).sendKeys("Education");
	driver.findElement(By.id("under_18")).click();
		
		
  }
  
  @Test
  public void TC_02_CheckEnableDisableElements() throws InterruptedException {
	/* 
	Test Script 02: Kiểm tra phần tử enable/ disable trên trang
	Step 01 - Truy cập vào trang: http://daominhdam.890m.com/
	Step 02 - Kiểm tra các phần tử sau enable trên trang: Email/ Age (Under 18)/ Education/ Job Role 01/ Interests (Development)/ Slider 01/ Button is enabled
	Step 03 - Kiểm tra các phần tử sau disable trên trang: Password / Age (Radiobutton is disabled)/ Biography/ Job Role 02/ Interests (Checkbox is disabled)/ Slider 02/ Button is disabled
	Step 04 - Nếu có in ra Element is enabled/ ngược lại Element is disabled
	 */
	  
	
	  
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  
		driver = new FirefoxDriver();
	  
  }

  @AfterClass
  public void afterClass() {
	  
	 // driver.quit();
  }

}
