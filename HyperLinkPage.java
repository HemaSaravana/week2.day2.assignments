package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinkPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Go to Home Page
		WebElement homepage = driver.findElement(By.linkText("Go to Home Page"));
		String link1 = homepage.getAttribute("href");
		homepage.click();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Find where am supposed to go without clicking me?
		String withoutClick = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href");
		System.out.println("Find where am supposed to go without clicking me " + withoutClick);

		// Verify am I broken
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title = driver.getTitle();
		if (title.contains("404 – Not Found")) 
		{
			System.out.println("broken link");
		}
		else
		{
			System.out.println(title);
		}
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Go to Home Page (Interact with same link name)
		String fourthLink = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
		if (link1.equals(fourthLink)) {
			homepage.click(); // doubt
		}
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// How many links are available in this page?
		driver.findElement(By.id("How many links are available in this page?")).click();
		int nlinks = driver.findElements(By.tagName("a")).size();
		System.out.println("There are " + nlinks + " in web page");
		driver.close();

	}

}
