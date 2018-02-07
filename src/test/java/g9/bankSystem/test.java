package g9.bankSystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test {

	WebDriver driver = new FirefoxDriver();

	@Test
	public void Login() {
		// log into system
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.cssSelector("input[name=uid]")).clear();
		driver.findElement(By.cssSelector("input[name=password]")).clear();
		driver.findElement(By.cssSelector("input[name=uid]")).sendKeys("test");
		driver.findElement(By.cssSelector("input[name=password]")).sendKeys("test");
		driver.findElement(By.name("btnLogin")).click();
		String htext = driver.findElement(By.cssSelector("tr.heading3")).getText();
		System.out.println(htext);
		Assert.assertEquals("Manger Id : mngr30325", htext);
	}
}
