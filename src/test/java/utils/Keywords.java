package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Keywords {
	public static WebDriver driver;

	public static boolean isTextPresent(String txtValue) {
		boolean b = false;
		try {
			b = driver.getPageSource().contains(txtValue);
			// System.out.println(txtValue);
			return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return b;
		}
	}

	public static boolean isElementPresent(By by) {
		boolean b = false;
		try {
			driver.findElement(by);
			return b;
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return b;
		}
	}

	public static void getAllLinks() {

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (int i = 0; i < allLinks.size(); i++) {
			if (allLinks.get(i).getAttribute("href").contains("reset")
					|| allLinks.get(i).getAttribute("href")
							.contains("register")) {
				String link = allLinks.get(i).getText();
				System.out.println(link);
			}
		}
	}

	public static void logout() {
		WebElement btnLogout = driver.findElement(By.linkText("Logout"));
		Assert.assertNotNull(btnLogout);
		btnLogout.click();
	}

}
