package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Topic_04_TextBox_TextArea_DropdownList {

	WebDriver driver;
	
	String email, password, ID, customerName, gender, dob, address, city, state, pin, mobileNumber, customerID,
			newAddress, newCity;

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
	public void TC_02_Dropdown() throws Exception {
		
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@id='number-button']")).click();
		
				
		Thread.sleep(5000);
		
		Select selectNumberDropBox = new Select(driver.findElement(By.xpath("//ul[@id='number-menu']/li")));
				
		List <WebElement> options = selectNumberDropBox.getOptions(); 
		
		for (int i = 0; i < options.size(); i++) {
			
			if ( options.get(i).getText().equals("19"))
				
			{
						
				options.get(i).click();
				
				break;
				
			}
			
		}
		
		
		
		Thread.sleep(5000);
		
		
		
		
	}
	

	public void TC_03_Textbox_TextArea() throws Exception {

		driver.get("http://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Create new account

		WebElement UserID = driver.findElement(By.name("uid"));
		UserID.sendKeys(ID);

		WebElement loginPasswordField = driver.findElement(By.name("password"));
		loginPasswordField.sendKeys(password);

		WebElement loginBtn = driver.findElement(By.name("btnLogin"));
		loginBtn.click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());

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

		// Go to Edit customer
		customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();

		WebElement editCustomer = driver.findElement(By.xpath("//a[text()='Edit Customer']"));
		editCustomer.click();

		WebElement cusIDEditField = driver.findElement(By.name("cusid"));
		cusIDEditField.sendKeys(customerID);
		WebElement submitEditBtn = driver.findElement(By.name("AccSubmit"));
		submitEditBtn.click();

		Thread.sleep(5000);

		// Verify

		String actualCustomerName = driver.findElement(By.name("name")).getAttribute("value").toString();

		Assert.assertEquals(actualCustomerName, customerName);

		WebElement addressTextarea = driver.findElement(By.name("addr"));

		String actualAddress = addressTextarea.getText();

		Assert.assertEquals(actualAddress, address);

		addressTextarea.clear();
		addressTextarea.sendKeys(newAddress);

		WebElement cityTextbox = driver.findElement(By.name("city"));

		cityTextbox.clear();
		cityTextbox.sendKeys(newCity);

		WebElement submitEditButton = driver.findElement(By.name("sub"));
		submitEditButton.click();

		Thread.sleep(3000);

		WebElement updatedAddressTextarea = driver
				.findElement(By.xpath("//td[text()='Address']/following-sibling::td"));

		String actualNewAddress = updatedAddressTextarea.getText();
		Assert.assertEquals(actualNewAddress, newAddress);

		WebElement updatedCityTextbox = driver.findElement(By.xpath("//td[text()='City']/following-sibling::td"));

		String actualNewCity = updatedCityTextbox.getText();
		Assert.assertEquals(actualNewCity, newCity);

	}
	
	

	@BeforeClass
	public void beforeClass() {

		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
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
		newAddress = "234 somewhere";
		newCity = "HN";

	}

	public long createRandomNumber() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime();

	}

	public void removeAttributeInDOM(WebElement element, String attribute) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "')", element);

	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
