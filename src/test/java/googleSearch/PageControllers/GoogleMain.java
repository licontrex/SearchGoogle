package googleSearch.PageControllers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMain {
	
	private WebDriver driver;
	private String googleNameSearchBar = "q";
	private WebElement srch;
	private String url ="https://www.google.com/";
	
	public GoogleMain(WebDriver dr) {
		this.driver = dr;
		this.driver.manage().window().maximize();
		this.driver.get(this.url);
		this.srch = getSearchBar();
	}
	
	public void find(String text) {
		this.srch.sendKeys(text);
		this.srch.sendKeys(Keys.ENTER);
	}
	
	public void find(String text, int millisecondsWait) {
		this.srch.sendKeys(text);
		try{
			Thread.sleep(millisecondsWait);
		}catch(InterruptedException e) {
			System.err.println("Error: Happens while waiting in find Action.");
		}
		this.srch.sendKeys(Keys.ENTER);
	}
	
	private WebElement getSearchBar() {
		return this.driver.findElement(By.name(googleNameSearchBar));
	}
}
