package selenium_api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Topic_03_WebElement_WebBrowser {

	WebDriver driver;

	// @Test
	public void TC_01_CheckDisplayedElements() throws InterruptedException {

		/*
		 * Test Script 01: Kiå³„åƒ² tra phå²·îœ´ tå³„ï¿½ hiå³„åƒ´ thå³„ï¿½ tré”šn trang
		 * Step 01 - Truy cå²·ç’¸ vè„¿o trang: http://daominhdam.890m.com/ Step 02 -
		 * Kiå³„åƒ² tra cè°©c phå²·îœ´ tå³„ï¿½ sau hiå³„åƒ´ thå³„ï¿½ tré”šn trang:
		 * Email/ Age (Under 18)/ Education Step 03 - Nå²·ç¸° cè´¸ nhå²·ç’¸ giè°©
		 * trå³„ï¿½: Automation Testing vè„¿o 2 field Email/ Education vè„¿ chå³„å³® Age
		 * = Under 18
		 */

		// Step 01 - Truy cå²·ç’¸ vè„¿o trang: http://daominhdam.890m.com/
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Step 02 - Kiå³„åƒ² tra cè°©c phå²·îœ´ tå³„ï¿½ sau hiå³„åƒ´ thå³„ï¿½ tré”šn
		// trang: Email/ Age (Under 18)/ Education

		Thread.sleep(3000);

		boolean isEmailDisplayed = driver.findElement(By.xpath("//label[@for='mail']")).isDisplayed();

		Assert.assertTrue(isEmailDisplayed);

		boolean isAgeDisplayed = driver.findElement(By.xpath("//label[@for='under_18']")).isDisplayed();

		Assert.assertTrue(isAgeDisplayed);

		boolean isEduDisplayed = driver.findElement(By.xpath("//label[@for='edu']")).isDisplayed();

		Assert.assertTrue(isEduDisplayed);

		// Step 03 - Nå²·ç¸° cè´¸ nhå²·ç’¸ giè°© trå³„ï¿½: Automation Testing vè„¿o 2
		// field Email/ Education vè„¿ chå³„å³® Age = Under 18

		driver.findElement(By.id("mail")).sendKeys("Education");
		driver.findElement(By.id("edu")).sendKeys("Education");
		driver.findElement(By.id("under_18")).click();

	}

	// @Test
	public void TC_02_CheckEnableDisableElements() throws InterruptedException {
		/*
		 * Test Script 02: Kiå³„åƒ² tra phå²·îœ´ tå³„ï¿½ enable/ disable tré”šn trang
		 * Step 01 - Truy cå²·ç’¸ vè„¿o trang: http://daominhdam.890m.com/ Step 02 -
		 * Kiå³„åƒ² tra cè°©c phå²·îœ´ tå³„ï¿½ sau enable tré”šn trang: Email/ Age
		 * (Under 18)/ Education/ Job Role 01/ Interests (Development)/ Slider 01/
		 * Button is enabled Step 03 - Kiå³„åƒ² tra cè°©c phå²·îœ´ tå³„ï¿½ sau disable
		 * tré”šn trang: Password / Age (Radiobutton is disabled)/ Biography/ Job Role
		 * 02/ Interests (Checkbox is disabled)/ Slider 02/ Button is disabled Step 04 -
		 * Nå²·ç¸° cè´¸ in ra Element is enabled/ ngç“¢å³„î–© lå²·î“¯ Element is
		 * disabled
		 */

		// Step 01 - Truy cå²·ç’¸ vè„¿o trang: http://daominhdam.890m.com/
		driver.get("http://daominhdam.890m.com/");

		// Step 02 - Kiå³„åƒ² tra cè°©c phå²·îœ´ tå³„ï¿½ sau enable tré”šn trang: Email/
		// Age (Under 18)/ Education/ Job Role 01/ Interests (Development)/ Slider 01/
		// Button is enabled

		boolean isEmailEnabled = driver.findElement(By.id("mail")).isEnabled();
		Assert.assertTrue(isEmailEnabled);
		System.out.println("Element Email is Enabled");

		boolean isAgeUnder18Enabled = driver.findElement(By.id("under_18")).isEnabled();
		Assert.assertTrue(isAgeUnder18Enabled);
		System.out.println("Element AgeUnder18 is Enabled");

		boolean isEducationEnabled = driver.findElement(By.id("edu")).isEnabled();
		Assert.assertTrue(isEducationEnabled);
		System.out.println("Element Education is Enabled");

		boolean isJobRole01Enabled = driver.findElement(By.id("job1")).isEnabled();
		Assert.assertTrue(isJobRole01Enabled);
		System.out.println("Element JobRole01 is Enabled");

		boolean isInterestsEnabled = driver.findElement(By.id("development")).isEnabled();
		Assert.assertTrue(isInterestsEnabled);
		System.out.println("Element Interests is Enabled");

		boolean isSlider01Enabled = driver.findElement(By.id("slider-1")).isEnabled();
		Assert.assertTrue(isSlider01Enabled);
		System.out.println("Element Slider01 is Enabled");

		boolean isButtonIsEnableEnabled = driver.findElement(By.id("button-enabled")).isEnabled();
		Assert.assertTrue(isButtonIsEnableEnabled);
		System.out.println("Element ButtonIsEnable is Enabled");

		// Step 03 - Kiå³„åƒ² tra cè°©c phå²·îœ´ tå³„ï¿½ sau disable tré”šn trang:
		// Password / Age (Radiobutton is disabled)/ Biography/ Job Role 02/ Interests
		// (Checkbox is disabled)/ Slider 02/ Button is disabled

		boolean isPaswordEnabled = driver.findElement(By.id("password")).isEnabled();
		Assert.assertFalse(isPaswordEnabled);
		System.out.println("Pasword field is diabled");

		boolean isRadioBtnIsDisabledEnabled = driver.findElement(By.id("radio-disabled")).isEnabled();
		Assert.assertFalse(isRadioBtnIsDisabledEnabled);
		System.out.println("Radiobutton is disabled value is disabled ");

		boolean isBiographyEnabled = driver.findElement(By.id("bio")).isEnabled();
		Assert.assertFalse(isBiographyEnabled);
		System.out.println("Biography textarea  is disabled");

		boolean isJobRole02Enabled = driver.findElement(By.id("job2")).isEnabled();
		Assert.assertFalse(isJobRole02Enabled);
		System.out.println("Element JobRole02 is disbaled");

		boolean isCheckboxEnabled = driver.findElement(By.id("check-disbaled")).isEnabled();
		Assert.assertFalse(isCheckboxEnabled);
		System.out.println("Checkbox is disabled");

		boolean isSlider02Enabled = driver.findElement(By.id("slider-2")).isEnabled();
		Assert.assertFalse(isSlider02Enabled);
		System.out.println("Element Slider02 is disabled");

		boolean isButtonIsDisabledEnabled = driver.findElement(By.id("button-disabled")).isEnabled();
		Assert.assertFalse(isButtonIsDisabledEnabled);
		System.out.println("Button is disabled");

		// Step 04 - Nå²·ç¸° cè´¸ in ra Element is enabled/ ngç“¢å³„î–© lå²·î“¯ Element
		// is disabled

	}

	@Test
	public void TC_03_CheckSelectedElements() throws InterruptedException {

		/*
		 * Test Script 03: Kiá»ƒm tra pháº§n tá»­ Ä‘Æ°á»£c chá»�n trÃªn trang Step 01 -
		 * Truy cáº­p vÃ o trang: http://daominhdam.890m.com/ Step 02 - Click chá»�n Age
		 * (Under 18)/ Interests (Development) Step 03 - Kiá»ƒm tra cÃ¡c pháº§n tá»­
		 * táº¡i Step 02 Ä‘Ã£ Ä‘Æ°á»£c chá»�n Step 04 - Náº¿u chÆ°a Ä‘Æ°á»£c chá»�n thÃ¬
		 * cho phÃ©p chá»�n láº¡i 1 láº§n ná»¯a
		 */

		// Step 01 - Truy cáº­p vÃ o trang: http://daominhdam.890m.com/
		driver.get("http://daominhdam.890m.com/");

		// Step 02 - Click chá»�n Age (Under 18)/ Interests (Development)
		driver.findElement(By.id("under_18")).click();
		driver.findElement(By.id("development")).click();

		// Step 03 - Kiá»ƒm tra cÃ¡c pháº§n tá»­ táº¡i Step 02 Ä‘Ã£ Ä‘Æ°á»£c chá»�n
		// Step 04 - Náº¿u chÆ°a Ä‘Æ°á»£c chá»�n thÃ¬ cho phÃ©p chá»�n láº¡i 1 láº§n
		// ná»¯a
		boolean isUnder18Selected = driver.findElement(By.id("under_18")).isSelected();
		try {

			Assert.assertTrue(isUnder18Selected);

		} catch (Exception e) {

			driver.findElement(By.id("under_18")).click();
		}

		boolean isDevelopmentSelected = driver.findElement(By.id("development")).isSelected();

		try {

			Assert.assertTrue(isDevelopmentSelected);

		} catch (Exception e) {

			driver.findElement(By.id("under_18")).click();
		}

	}

	@BeforeClass
	public void beforeClass() {

		// driver = new FirefoxDriver();

		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Automation\\WEBDRIVER_05_HANT\\driver\\chromedriver.exe");

		// driver = new InternetExplorerDriver();

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
