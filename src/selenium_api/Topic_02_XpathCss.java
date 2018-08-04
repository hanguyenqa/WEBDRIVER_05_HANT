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
		 * Test Script 01: Verify URL and title Step 01 - Truy c宀风捀 v鑴縪 trang:
		 * http://live.guru99.com Step 02 - Ki宄勫儾 tra title c宄勵湩 page l鑴�:
		 * "Home page" Step 03 - Click v鑴縪 link "My Account" 鑶藉硠锟� t宄勬铂 trang
		 * 鑶借啲ng nh宀风捀 Step 04 - Click CREATE AN ACCOUNT button 鑶藉硠锟� t宄勬铂
		 * trang 鑶借啲ng k閾� t鑴縤 kho宀奉柎 Step 05 - Back l宀奉摨 trang 鑶借啲ng
		 * nh宀风捀 Step 06 - Ki宄勫儾 tra url c宄勵湩 page 鑶借啲ng nh宀风捀 l鑴�:
		 * http://live.guru99.com/index.php/customer/account/login/ Step 07 - Forward
		 * t宄勬铂 trang t宀奉摰 t鑴縤 kho宀奉柎 Step 08 - Ki宄勫儾 tra url c宄勵湩 page
		 * t宀奉摰 t鑴縤 kho宀奉柎 l鑴�:
		 * http://live.guru99.com/index.php/customer/account/create/
		 */

		// Step 01 - Truy c宀风捀 v鑴縪 trang: http://live.guru99.com
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Step 02 - Ki宄勫儾 tra title c宄勵湩 page l鑴�: "Home page"

		String pageTitle = driver.getTitle();

		Assert.assertEquals(pageTitle, "Home page");

		// Step 03 - Click v鑴縪 link "My Account" 鑶藉硠锟� t宄勬铂 trang 鑶借啲ng
		// nh宀风捀
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

		// Step 04 - Click CREATE AN ACCOUNT button 鑶藉硠锟� t宄勬铂 trang 鑶借啲ng
		// k閾� t鑴縤 kho宀奉柎
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		// Step 05 - Back l宀奉摨 trang 鑶借啲ng nh宀风捀
		// driver.findElement(By.xpath("//a[@class='back-link']")).click();
		driver.navigate().back();

		// Step 06 - Ki宄勫儾 tra url c宄勵湩 page 鑶借啲ng nh宀风捀 l鑴�:
		// http://live.guru99.com/index.php/customer/account/login/
		String loginUrl = driver.getCurrentUrl();

		Assert.assertEquals(loginUrl, "http://live.guru99.com/index.php/customer/account/login/");

		// Step 07 - Forward t宄勬铂 trang t宀奉摰 t鑴縤 kho宀奉柎
		// driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.navigate().forward();

		// Step 08 - Ki宄勫儾 tra url c宄勵湩 page t宀奉摰 t鑴縤 kho宀奉柎 l鑴�:
		// http://live.guru99.com/index.php/customer/account/create/
		String signupUrl = driver.getCurrentUrl();
		Assert.assertEquals(signupUrl, "http://live.guru99.com/index.php/customer/account/create/");

	}

	@Test
	public void TC_02_LoginEmpty() {

		/*
		 * Test Script 02: Login empty Step 01 - Truy c宀风捀 v鑴縪 trang:
		 * http://live.guru99.com/ Step 02 - Click v鑴縪 link "My Account" 鑶藉硠锟�
		 * t宄勬铂 trang 鑶借啲ng nh宀风捀 Step 03 - 鑶煎硠锟� tr宄勬唫g Username/
		 * Password Step 04 - Click Login button Step 05 - Verify error message xu宀奉櫤
		 * hi宄勫檳 t宀奉摨 2 field: This is a required field.
		 */

		// Step 01 - Truy c宀风捀 v鑴縪 trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");

		// Step 02 - Click v鑴縪 link "My Account" 鑶藉硠锟� t宄勬铂 trang 鑶借啲ng
		// nh宀风捀
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

		// Step 03 - 鑶煎硠锟� tr宄勬唫g Username/ Password

		// Step 04 - Click Login button
		driver.findElement(By.id("send2")).click();

		// Step 05 - Verify error message xu宀奉櫤 hi宄勫檳 t宀奉摨 2 field: This is a
		// required field.

		String emailErrorMsg = driver.findElement(By.id("advice-required-entry-email")).getText();

		Assert.assertEquals(emailErrorMsg, "This is a required field.");

		String passwordErrorMsg = driver.findElement(By.id("advice-required-entry-pass")).getText();

		Assert.assertEquals(passwordErrorMsg, "This is a required field.");

	}

	@Test
	public void TC_03_LoginWithInvalidEmail() {

		/*
		 * Test Script 03: Login with Email invalid Step 01 - Truy c宀风捀 v鑴縪 trang:
		 * http://live.guru99.com/ Step 02 - Click v鑴縪 link "My Account" 鑶藉硠锟�
		 * t宄勬铂 trang 鑶借啲ng nh宀风捀 Step 03 - Nh宀风捀 email invalid:
		 * 123434234@12312.123123 Step 04 - Click Login button Step 05 - Verify error
		 * message xu宀奉櫤 hi宄勫檳: Please enter a valid email address. For example
		 * johndoe@domain.com.
		 */

		// Step 01 - Truy c宀风捀 v鑴縪 trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");

		// Step 02 - Click v鑴縪 link "My Account" 鑶藉硠锟� t宄勬铂 trang 鑶借啲ng
		// nh宀风捀
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

		// Step 03 - Nh宀风捀 email invalid: 123434234@12312.123123
		driver.findElement(By.id("email")).sendKeys("123434234@12312.123123");

		// Step 04 - Click Login button
		driver.findElement(By.id("send2")).click();

		// Step 05 - Verify error message xu宀奉櫤 hi宄勫檳: Please enter a valid email
		// address. For example johndoe@domain.com.
		String invalidEmailMsg = driver.findElement(By.id("advice-validate-email-email")).getText();
		Assert.assertEquals(invalidEmailMsg, "Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void TC_04_LoginWithIncorrectPassword() {

		/*
		 * Test Script 04: Login with Password incorrect Step 01 - Truy c宀风捀 v鑴縪
		 * trang: http://live.guru99.com/ Step 02 - Click v鑴縪 link "My Account"
		 * 鑶藉硠锟� t宄勬铂 trang 鑶借啲ng nh宀风捀 Step 03 - Nh宀风捀 email correct
		 * and password incorrect: automation@gmail.com/ 123 Step 04 - Click Login
		 * button Step 05 - Verify error message xu宀奉櫤 hi宄勫檳: Please enter 6 or
		 * more characters without leading or trailing spaces.
		 */

		// Step 01 - Truy c宀风捀 v鑴縪 trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");

		// Step 02 - Click v鑴縪 link "My Account" 鑶藉硠锟� t宄勬铂 trang 鑶借啲ng
		// nh宀风捀
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

		// Step 03 - Nh宀风捀 email correct and password incorrect:
		// automation@gmail.com/ 123
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");

		// Step 04 - Click Login button
		driver.findElement(By.id("send2")).click();

		// Step 05 - Verify error message xu宀奉櫤 hi宄勫檳: Please enter 6 or more
		// characters without leading or trailing spaces.
		String incorrectPasswordMsg = driver.findElement(By.id("advice-validate-password-pass")).getText();
		Assert.assertEquals(incorrectPasswordMsg,
				"Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	public void TC_05_CreateAnAccount() throws InterruptedException {
		/*
		 * Test Script 05: Create an account Step 01 - Truy c宀风捀 v鑴縪 trang:
		 * http://live.guru99.com/ Step 02 - Click v鑴縪 link "My Account" 鑶藉硠锟�
		 * t宄勬铂 trang 鑶借啲ng nh宀风捀 Step 03 - Click CREATE AN ACCOUNT button
		 * 鑶藉硠锟� t宄勬铂 trang 鑶借啲ng k閾� t鑴縤 kho宀奉柎 Step 04 - Nh宀风捀
		 * th涔坣g tin h宄勵柖 l宄勶拷 v鑴縪 t宀奉櫤 c宀凤拷 c璋ヽ field: First Name/
		 * Last Name/ Email Address/ Password/ Confirm Password (L鐡 濯�: T宀奉摰
		 * random cho d宄勶拷 li宄勫檽 t宀奉摨 field Email Address) Step 05 - Click
		 * REGISTER button Step 05 - Verify message xu宀奉櫤 hi宄勫檳 khi 鑶借啲ng k閾�
		 * th鑴縩h c涔坣g: Thank you for registering with Main Website Store. Step 06 -
		 * Logout kh宄勫患 h宄勶拷 th宄勬唫g Step 07 - Ki宄勫儾 tra h宄勶拷 th宄勬唫g
		 * navigate v宄勶拷 Home page sau khi logout th鑴縩h c涔坣g
		 */

		// Step 01 - Truy c宀风捀 v鑴縪 trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");

		// Step 02 - Click v鑴縪 link "My Account" 鑶藉硠锟� t宄勬铂 trang 鑶借啲ng
		// nh宀风捀
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();

		// Step 03 - Click CREATE AN ACCOUNT button 鑶藉硠锟� t宄勬铂 trang 鑶借啲ng
		// k閾� t鑴縤 kho宀奉柎
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();

		// Step 04 - Nh宀风捀 th涔坣g tin h宄勵柖 l宄勶拷 v鑴縪 t宀奉櫤 c宀凤拷 c璋ヽ
		// field: First Name/ Last Name/ Email Address/ Password/ Confirm Password
		// (L鐡 濯�: T宀奉摰 random cho d宄勶拷 li宄勫檽 t宀奉摨 field Email Address)

		String email = "test" + createRandomNumber() + "@test.com";

		driver.findElement(By.id("firstname")).sendKeys("Ha");
		driver.findElement(By.id("middlename")).sendKeys("Nguyen");
		driver.findElement(By.id("lastname")).sendKeys("Thanh");
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys("123123");
		driver.findElement(By.id("confirmation")).sendKeys("123123");

		// Step 05 - Click REGISTER button
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		// Step 05 - Verify message xu宀奉櫤 hi宄勫檳 khi 鑶借啲ng k閾� th鑴縩h c涔坣g:
		// Thank you for registering with Main Website Store.

		String successMsg = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();

		Assert.assertEquals(successMsg, "Thank you for registering with Main Website Store.");

		// Step 06 - Logout kh宄勫患 h宄勶拷 th宄勬唫g
		driver.findElement(By.xpath("//div[@class='skip-links']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/customer/account/logout/']")).click();

		Thread.sleep(10000);

		// Step 07 - Ki宄勫儾 tra h宄勶拷 th宄勬唫g navigate v宄勶拷 Home page sau khi
		// logout th鑴縩h c涔坣g
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
