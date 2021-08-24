package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	    driver.get("http://leafground.com/pages/Edit.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("HemaSaravana123@gmail.com");
		// Append a text and press keyboard tab
		WebElement app = driver.findElement(By.xpath("//input[@value='Append ']"));
		String apptext = app.getAttribute("Value");
		app.clear();
		app.sendKeys(apptext + "abc");
		app.sendKeys(Keys.TAB);
		
		// Get default text entered
				WebElement defaulttext = driver.findElement(By.xpath("//input[@name='username']"));
				String daftxtval = defaulttext.getAttribute("Value");
				System.out.println(daftxtval);
				
				// Clear the text
				driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();

				// Confirm that edit field is disabled
				WebElement disabled = driver.findElement(By.xpath("//input[@disabled='true']"));
				if (disabled.isEnabled()) {
					System.out.println("Last edit field is enabled");
				} 
				else {
					System.out.println("Last edit field is disabled");
				}

}
}
