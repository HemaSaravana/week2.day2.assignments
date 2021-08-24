package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Select training program using Index
		WebElement drop1 = driver.findElement(By.id("dropdown1"));
		Select drpdwn1 = new Select(drop1);
		drpdwn1.selectByIndex(2);

		// Select training program using Text
		WebElement drop2  = driver.findElement(By.name("dropdown2"));
		Select drpdwn2 = new Select(drop2);
		drpdwn2.selectByVisibleText("Selenium");

		// Select training program using Value
		WebElement drop3 = driver.findElement(By.id("dropdown3"));
		Select drpdwn3 = new Select(drop3);
		drpdwn3.selectByValue("1");
		
		// Select training program using options
		driver.findElement(By.className("dropdown")).click();
		int nofdrop = driver.findElements(By.tagName("select")).size();
		System.out.println("There are " + nofdrop + " drop downs in web page");
		
	}

}
