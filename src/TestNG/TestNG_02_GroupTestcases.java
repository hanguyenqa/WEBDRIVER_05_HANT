package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_02_GroupTestcases {

	@Test(groups = "customer")
	public void TC_01() {

		System.out.println("TC 01");
	}

	@Test(groups = "payment")
	public void TC_02() {
		System.out.println("TC 02");
	}

	@Test(groups = "customer", priority = 3)
	public void TC_03() {
		System.out.println("TC 03");
	}

	@Test(groups = "payment", priority = 2)
	public void TC_04() {
		System.out.println("TC 04");
	}

	@Test(groups = "customer", priority = 1, enabled = false)
	public void TC_05() {
		System.out.println("TC 05");
	}

	public void TC_06() {
		System.out.println("TC 06");
	}

}
