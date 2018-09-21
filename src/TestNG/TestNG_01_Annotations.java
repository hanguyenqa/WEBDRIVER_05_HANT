package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_01_Annotations {
	
	//test aakkk

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@Test
	public void TC_01() {
		System.out.println("TC 01");
	}

	@Test
	public void TC_02() {
		System.out.println("TC 02");
	}

	@Test
	public void TC_03() {
		System.out.println("TC 03");
	}

	@Test
	public void TC_04() {
		System.out.println("TC 04");
	}

	@Test
	public void TC_05() {
		System.out.println("TC 05");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}


	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}


	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}


	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

}
