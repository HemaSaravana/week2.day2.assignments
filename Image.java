package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on this image to go home page
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img"))
				.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("landed in home page" + currentUrl);
		driver.navigate().back();

		// Am I Broken Image?
		WebElement brokenImage = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"));
		String broken = brokenImage.getAttribute("src");
		driver.navigate().to(broken);

		if (driver.getTitle().contains("404")) {
			System.out.println("image is brocken");
		}
		driver.navigate().back();

		// Click me using Keyboard or Mouse
		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img"))
				.click();
	}

}
