package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_02_XpathCss {
	
	WebDriver driver;
  
	@Test 
	public void TC_01_VerifyURLandTitle() {

		
		/* 
		 Test Script 01: Verify URL and title
		Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com
		Step 02 - Ki峄僲 tra title c峄 page l脿: "Home page"
		Step 03 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸
		Step 04 - Click CREATE AN ACCOUNT button 膽峄� t峄沬 trang 膽膬ng k铆 t脿i kho岷
		Step 05 - Back l岷 trang 膽膬ng nh岷璸
		Step 06 - Ki峄僲 tra url c峄 page 膽膬ng nh岷璸 l脿: http://live.guru99.com/index.php/customer/account/login/
		Step 07 - Forward t峄沬 trang t岷 t脿i kho岷
		Step 08 - Ki峄僲 tra url c峄 page t岷 t脿i kho岷 l脿: http://live.guru99.com/index.php/customer/account/create/
		 */
		
//		Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
//		Step 02 - Ki峄僲 tra title c峄 page l脿: "Home page"
		
		String pageTitle = driver.getTitle();
		
		Assert.assertEquals(pageTitle, "Home page");
		
//		Step 03 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸	
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account")).click();
		
//		Step 04 - Click CREATE AN ACCOUNT button 膽峄� t峄沬 trang 膽膬ng k铆 t脿i kho岷
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
//		Step 05 - Back l岷 trang 膽膬ng nh岷璸
		//driver.findElement(By.xpath("//a[@class='back-link']")).click();
		driver.navigate().back();
		
		
//		Step 06 - Ki峄僲 tra url c峄 page 膽膬ng nh岷璸 l脿: http://live.guru99.com/index.php/customer/account/login/
		String loginUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(loginUrl, "http://live.guru99.com/index.php/customer/account/login/");
		
//		Step 07 - Forward t峄沬 trang t岷 t脿i kho岷		
		//driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.navigate().forward();
		
//		Step 08 - Ki峄僲 tra url c峄 page t岷 t脿i kho岷 l脿: http://live.guru99.com/index.php/customer/account/create/		
		String signupUrl = driver.getCurrentUrl();
		Assert.assertEquals(signupUrl, "http://live.guru99.com/index.php/customer/account/create/");
		
	  
  }
	@Test
	public void TC_02_LoginEmpty() {
		
		/*
		Test Script 02: Login empty
		Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com/
		Step 02 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸
		Step 03 - 膼峄� tr峄憂g Username/ Password
		Step 04 - Click Login button
		Step 05 - Verify error message xu岷 hi峄噉 t岷 2 field:  This is a required field.
		 */
		
//		Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");
		
//		Step 02 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account")).click();
		
//		Step 03 - 膼峄� tr峄憂g Username/ Password
		
//		Step 04 - Click Login button
		driver.findElement(By.id("send2")).click();
		
//		Step 05 - Verify error message xu岷 hi峄噉 t岷 2 field:  This is a required field.
		
		String emailErrorMsg = driver.findElement(By.id("advice-required-entry-email")).getText();
		
		Assert.assertEquals(emailErrorMsg, "This is a required field.");
		
		String passwordErrorMsg = driver.findElement(By.id("advice-required-entry-pass")).getText();
		
		Assert.assertEquals(passwordErrorMsg, "This is a required field.");
		
	}
	
	@Test
	public void TC_03_LoginWithInvalidEmail() {
	
		/*
		 Test Script 03: Login with Email invalid
			Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com/
			Step 02 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸
			Step 03 - Nh岷璸 email invalid: 123434234@12312.123123
			Step 04 - Click Login button
			Step 05 - Verify error message xu岷 hi峄噉:  Please enter a valid email address. For example johndoe@domain.com.
		 */
		
//			Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com/
			driver.get("http://live.guru99.com");
						
//			Step 02 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸
			driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account")).click();
			
//			Step 03 - Nh岷璸 email invalid: 123434234@12312.123123
			driver.findElement(By.id("email")).sendKeys("123434234@12312.123123");
			
//			Step 04 - Click Login button
			driver.findElement(By.id("send2")).click();
						
//			Step 05 - Verify error message xu岷 hi峄噉:  Please enter a valid email address. For example johndoe@domain.com.
			String invalidEmailMsg = driver.findElement(By.id("advice-validate-email-email")).getText();
			Assert.assertEquals(invalidEmailMsg, "Please enter a valid email address. For example johndoe@domain.com.");
			
		
	}
	
	@Test
	public void TC_04_LoginWithIncorrectPassword() {

		/*
		Test Script 04: Login with Password incorrect
		Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com/
		Step 02 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸
		Step 03 - Nh岷璸 email correct and password incorrect: automation@gmail.com/ 123
		Step 04 - Click Login button
		Step 05 - Verify error message xu岷 hi峄噉: Please enter 6 or more characters without leading or trailing spaces.
		 */


//		Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");
					
//		Step 02 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account")).click();
		
//		Step 03 - Nh岷璸 email correct and password incorrect: automation@gmail.com/ 123		
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		
//		Step 04 - Click Login button
		driver.findElement(By.id("send2")).click();
		
//		Step 05 - Verify error message xu岷 hi峄噉: Please enter 6 or more characters without leading or trailing spaces.
		String incorrectPasswordMsg = driver.findElement(By.id("advice-validate-password-pass")).getText();
		Assert.assertEquals(incorrectPasswordMsg, "Please enter 6 or more characters without leading or trailing spaces.");

	
	}

	@Test
	public void TC_05_CreateAnAccount() throws InterruptedException {
	/*
	 Test Script 05: Create an account
	Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com/
	Step 02 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸
	Step 03 - Click CREATE AN ACCOUNT button 膽峄� t峄沬 trang 膽膬ng k铆 t脿i kho岷
	Step 04 - Nh岷璸 th么ng tin h峄 l峄� v脿o t岷 c岷� c谩c field: First Name/ Last Name/ Email Address/ Password/ Confirm Password
	(L瓢u 媒: T岷 random cho d峄� li峄噓 t岷 field Email Address)
	Step 05 - Click REGISTER button
	Step 05 - Verify message xu岷 hi峄噉 khi 膽膬ng k铆 th脿nh c么ng: Thank you for registering with Main Website Store.
	Step 06 - Logout kh峄廼 h峄� th峄憂g
	Step 07 - Ki峄僲 tra h峄� th峄憂g navigate v峄� Home page sau khi logout th脿nh c么ng
	*/
		
		
//		Step 01 - Truy c岷璸 v脿o trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");
					
//		Step 02 - Click v脿o link "My Account" 膽峄� t峄沬 trang 膽膬ng nh岷璸
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account")).click();

//		Step 03 - Click CREATE AN ACCOUNT button 膽峄� t峄沬 trang 膽膬ng k铆 t脿i kho岷
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		
//		Step 04 - Nh岷璸 th么ng tin h峄 l峄� v脿o t岷 c岷� c谩c field: First Name/ Last Name/ Email Address/ Password/ Confirm Password	
//		(L瓢u 媒: T岷 random cho d峄� li峄噓 t岷 field Email Address)
		
		String email = "test" + createRandomNumber() + "@test.com";
		
		driver.findElement(By.id("firstname")).sendKeys("Ha");
		driver.findElement(By.id("middlename")).sendKeys("Nguyen");
		driver.findElement(By.id("lastname")).sendKeys("Thanh");
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys("123123");
		driver.findElement(By.id("confirmation")).sendKeys("123123");
		
//		Step 05 - Click REGISTER button
		driver.findElement(By.xpath("//button[@title='Register']")).click();
//		Step 05 - Verify message xu岷 hi峄噉 khi 膽膬ng k铆 th脿nh c么ng: Thank you for registering with Main Website Store.
		
		String successMsg = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
		
		Assert.assertEquals(successMsg, "Thank you for registering with Main Website Store.");
		
//		Step 06 - Logout kh峄廼 h峄� th峄憂g
		driver.findElement(By.xpath("//div[@class='skip-links']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/customer/account/logout/']")).click();
		
		Thread.sleep(7000);	
		
//		Step 07 - Ki峄僲 tra h峄� th峄憂g navigate v峄� Home page sau khi logout th脿nh c么ng
		String pageTitle = driver.getTitle();
		
		Assert.assertEquals(pageTitle, "Home page");
		
	}
	
	public long createRandomNumber() {
		 
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime();
		
	}
	@BeforeClass
	public void beforeClass() {
	  
	driver = new FirefoxDriver();
	
	}
	
	@AfterClass
	public void afterClass() {
	
		driver.quit();
		
	}

}
