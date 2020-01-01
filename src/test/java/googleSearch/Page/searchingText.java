package googleSearch.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import googleSearch.PageControllers.GoogleMain;

public class searchingText {
	
	private GoogleMain google;
	private WebDriver driver;
	
	@Parameters({"driverPath"})
	@BeforeTest
	private void setUp(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
		this.driver = new ChromeDriver();
		this.google = new GoogleMain(this.driver);
	}
	
	@Test
	public void findMarca() {
		try{	
			int millisecondsWait = 8000;
			google.find("marca", millisecondsWait);
			Thread.sleep(millisecondsWait);
		}catch(InterruptedException e) {
			System.err.println("Error: Happens while waiting in find Action.");
		}
	}

	@AfterTest
	private void endTest() {
		driver.close();
		driver.quit();
	}
}
