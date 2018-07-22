package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Topic_04_TextBox_TextArea_DropdownList {
	
	WebDriver driver;
	String email, password, ID, customerName, gender, dob, address, city, state, pin, mobileNumber, customerID;
  
	public void TC_01_HandleDropdown() {
		
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Select jobDropdown;
		WebElement jobDropdownentElement = driver.findElement(By.id("job1"));  
		
		jobDropdown = new Select(jobDropdownentElement);
		
		Assert.assertFalse(jobDropdown.isMultiple());
		
		jobDropdown.selectByVisibleText("Automation Tester");
		
		String jobSelected = jobDropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(jobSelected, "Automation Tester");
		
		jobDropdown.selectByValue("manual");
		
		jobSelected = jobDropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(jobSelected, "Manual Tester");
		
		jobDropdown.selectByIndex(3);
		
		jobSelected = jobDropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(jobSelected, "Mobile Tester");
		
		Assert.assertEquals(jobDropdown.getOptions().size(), 5);
		
		}
	@Test
  public void TC_02_Textbox_TextArea() throws Exception {
	  
	  	driver.get("http://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		WebElement UserID = driver.findElement(By.name("uid"));
		UserID.sendKeys(ID);
		
		WebElement loginPasswordField = driver.findElement(By.name("password"));
		loginPasswordField.sendKeys(password);
		
		WebElement loginBtn = driver.findElement(By.name("btnLogin"));
		loginBtn.click();
		
		WebElement newCustomer = driver.findElement(By.xpath("//a[text()='New Customer']"));
		newCustomer.click();
		
		WebElement customerNameField = driver.findElement(By.name("name"));
		customerNameField.sendKeys(customerName);
		
		WebElement female = driver.findElement(By.xpath("//input[@value='f']"));
		female.click();
		
		WebElement dobField = driver.findElement(By.name("dob"));
		removeAttributeInDOM(dobField, "type");
		Thread.sleep(5000);
		dobField.sendKeys(dob);
		
		WebElement addressField = driver.findElement(By.name("addr"));
		addressField.sendKeys(address);
		
		WebElement cityField = driver.findElement(By.name("city"));
		cityField.sendKeys(city);
		
		WebElement stateField = driver.findElement(By.name("state"));
		stateField.sendKeys(state);
		
		WebElement pinField = driver.findElement(By.name("pinno"));
		pinField.sendKeys(pin);
		
		WebElement mobileNumberField = driver.findElement(By.name("telephoneno"));
		mobileNumberField.sendKeys(mobileNumber);
		
		WebElement emailField = driver.findElement(By.name("emailid"));
		emailField.sendKeys(email);
		
		WebElement signupPasswordField = driver.findElement(By.name("password"));
		signupPasswordField.sendKeys(password);
		
		WebElement submitBtn = driver.findElement(By.name("sub"));
		submitBtn.click();
		
		Thread.sleep(5000);
		
		
		customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
		
		WebElement editCustomer = driver.findElement(By.xpath("//a[text()='Edit Customer']"));
		editCustomer.click();
		
		WebElement cusIDEditField = driver.findElement(By.name("cusid"));
		cusIDEditField.sendKeys(customerID);
		WebElement submitEditBtn = driver.findElement(By.name("AccSubmit"));
		submitEditBtn.click();
		
		
		
		
			
  }
	
  @BeforeClass
  public void beforeClass() {

		driver = new ChromeDriver();
		email = "test" + createRandomNumber() + "@gmail.com";
		ID = "mngr144320";
		password = "zYvYhyz";
		customerName = "Ha Nguyen";
		dob = "01/01/1991";
		address = "123 somewhere";
		city = "HCM";
		state = "Unknown";
		pin = "123123";
		mobileNumber = "0123456789";
			
		
  }

  public long createRandomNumber() {
		 
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime();
		
	}
  public void removeAttributeInDOM(WebElement element,String attribute ) {
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver; 
	  js.executeScript("arguments[0].removeAttribute('" + attribute + "')", element);
	  
  }

@AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
