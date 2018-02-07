package g9.bankSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Admin {
	WebDriver driver = null;

	File configFile = new File(".//configfiles//global.properties");
	public static Properties prop = new Properties();

	@BeforeTest
	public void beforeTest() throws IOException {
		System.out.print("BT\n");
		FileInputStream fileInput = null;
		fileInput = new FileInputStream(configFile);
		prop.load(fileInput);
		FirefoxBinary binary = new FirefoxBinary(new File(prop.getProperty("pathffbinary")));
		FirefoxProfile profile = new FirefoxProfile();
		driver = new FirefoxDriver(binary, profile);

	}

	@BeforeMethod
	// Executes before every @test
	public void beforeMethod() throws IOException {
		System.out.print("BM\n");

	}

	@Test
	public void openBrowser() {
		// Open browser
		driver.get(prop.getProperty("url"));
	}

	@Test(dependsOnMethods = "openBrowser")
	public void Login() {
		// log into system
		driver.findElement(By.cssSelector("input[name=uid]")).clear();
		driver.findElement(By.cssSelector("input[name=password]")).clear();
		driver.findElement(By.cssSelector("input[name=uid]")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.cssSelector("input[name=password]")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("btnLogin")).click();
		String htext = driver.findElement(By.cssSelector("tr.heading3")).getText();
		System.out.println(htext);
		Assert.assertEquals("Manger Id : mngr30325", htext);
	}

	@Test(dependsOnMethods = "Login")
	public void logout() throws InterruptedException {

		driver.findElement(By.linkText("Log out")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Popup text: " + alert.getText());
		alert.accept();

	}

	@AfterMethod
	// Executes after every @test
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:\\testScreenShot.jpg"));
		}
	}

	@BeforeClass
	public void beforeClass() {
		System.out.print("BC\n");

	}

	@AfterClass
	public void afterClass() {
		System.out.print("AC\n");
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.print("AT\n");

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.print("BS\n");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.print("AS\n");
	}

}
