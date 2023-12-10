package firstAutomationProject;

import java.awt.Button;
import java.time.LocalDate;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfRegionAndSubregions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyTestCase {

	WebDriver driver = new ChromeDriver();
	String theWebsite = "https://www.almosafer.com/en";
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void setup() {
		driver.get(theWebsite);
		driver.manage().window().maximize();
		WebElement welcomeButton = driver
				.findElement(By.xpath("//button[normalize-space()='Kingdom of Saudi Arabia, SAR']"));
		welcomeButton.click();
	}

	@Test()
	public void langugeTest() {

		String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectLang = "en";
		softAssert.assertEquals(ActualLang, ExpectLang);

	}

	@Test()
	public void currencyTest() {
		String Expectcurr = "SAR";
		WebElement currElement = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO"));
		String Actualcurr = currElement.getText();
		softAssert.assertEquals(Actualcurr, Expectcurr);

	}

	@Test()
	public void NumberTest() {

		String ExpectNum = "+966554400000";
		WebElement NumberElement = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));
		String ActualNum = NumberElement.getText();
		softAssert.assertEquals(ActualNum, ExpectNum);

	}

	@Test()
	public void timeTest() {

		LocalDate today = LocalDate.now();
		int AcullyTimeDep = Integer.parseInt(driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
				.getText());
		int AcllyTimeRett = Integer.parseInt(driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"))
				.getText());

		int ExpectTimeDep = today.plusDays(1).getDayOfMonth();
		int ExpectTimeRett = today.plusDays(2).getDayOfMonth();

		softAssert.assertEquals(AcullyTimeDep, ExpectTimeDep);
		softAssert.assertEquals(AcllyTimeRett, ExpectTimeRett);
		// ---------------------------------------------------------------------------------

		String AcullyMonthDep = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-hvvHee cuAEQj']"))
				.getText().toUpperCase();
		String AcullyMonthRett = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-hvvHee cuAEQj']"))
				.getText().toUpperCase();

		String ExpectMonthDep = today.plusDays(1).getMonth().toString();
		String ExpectMonthRett = today.plusDays(2).getMonth().toString();

		softAssert.assertEquals(AcullyMonthDep, ExpectMonthDep);
		softAssert.assertEquals(AcullyMonthRett, ExpectMonthRett);
		// -----------------------------------------------------------------------------------
		String AcullyDayDep = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-eSePXt ljMnJa']"))
				.getText().toUpperCase();
		String AcullyDayRett = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-eSePXt ljMnJa']"))
				.getText().toUpperCase();

		String ExpectDayDep = today.plusDays(1).getDayOfWeek().toString();
		String ExpectDayRett = today.plusDays(2).getDayOfWeek().toString();

		softAssert.assertEquals(AcullyDayDep, ExpectDayDep);
		softAssert.assertEquals(AcullyDayRett, ExpectDayRett);

	}

	@AfterTest
	public void postTesting() {
		softAssert.assertAll();

	}

}
