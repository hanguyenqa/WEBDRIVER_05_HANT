package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

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
		Step 01 - Truy cập vào trang: http://live.guru99.com
		Step 02 - Kiểm tra title của page là: "Home page"
		Step 03 - Click vào link "My Account" để tới trang đăng nhập
		Step 04 - Click CREATE AN ACCOUNT button để tới trang đăng kí tài khoản
		Step 05 - Back lại trang đăng nhập
		Step 06 - Kiểm tra url của page đăng nhập là: http://live.guru99.com/index.php/customer/account/login/
		Step 07 - Forward tới trang tạo tài khoản
		Step 08 - Kiểm tra url của page tạo tài khoản là: http://live.guru99.com/index.php/customer/account/create/
		 */
		
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		String pageTitle = driver.getTitle();
		
		Assert.assertEquals(pageTitle, "Home page");
		
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		
		driver.findElement(By.xpath("//div[@class='footer-container']//a[@href='http://live.guru99.com/index.php/customer/account/']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.findElement(By.xpath("//a[@class='back-link']")).click();
		
		
		String loginUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(loginUrl, "http://live.guru99.com/index.php/customer/account/login/");
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		String signupUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(signupUrl, "http://live.guru99.com/index.php/customer/account/create/");
		
	  
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
