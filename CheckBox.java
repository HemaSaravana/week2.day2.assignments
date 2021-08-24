package week2.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[text()='Java']/input")).click();
		driver.findElement(By.xpath("//div[text()='VB']/input")).click();
		driver.findElement(By.xpath("//div[text()='SQL']/input")).click();

		// Confirm Selenium is checked
		WebElement selChkd = driver.findElement(By.xpath("//div[text()='Selenium']/input"));
		if (selChkd.isSelected())
			System.out.println("Selenium is selected");

		// Deselect only checked
		WebElement deSlctChkd = driver.findElement(By.xpath("//div[text()='I am Selected']/input"));
		if (deSlctChkd.isSelected()) {
			deSlctChkd.click();
		}

		// Select all checkboxes
		List<WebElement> mulChkBox = driver
				.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));
		for (int i = 0; i < mulChkBox.size(); i++) {
			mulChkBox.get(i).click();
	}

}
}
