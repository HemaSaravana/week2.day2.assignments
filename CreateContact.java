package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        // 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		        WebDriverManager.chromedriver().setup();
		        WebDriver driver = new ChromeDriver();
		        driver.get("http://leaftaps.com/opentaps/control/login");
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		       //2. Enter UserName and Password Using Id Locator
		       driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		       driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		        // 3. Click on Login Button using Class Locator
		        driver.findElement(By.className("decorativeSubmit")).click(); 
		
		        //Click on CRM/SFA Link
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				//Click on contacts Button
				driver.findElement(By.linkText("Contacts")).click();
				
				//Click on Create Contact
				driver.findElement(By.linkText("Create Contact")).click();
				
				//Enter First Name and Last name using ID locator
				driver.findElement(By.id("firstNameField")).sendKeys("HEMA");
				driver.findElement(By.id("lastNameField")).sendKeys("PRIYA");
				
				//Enter FirstName(Local) and LastName(Local) Field Using id Locator
				driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("HEMAPRIYA");
				driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("SARAVANA");
				
				//Enter Department Field Using any Locator of Your Choice
				driver.findElement(By.id("createContactForm_departmentName")).sendKeys("CS");
				
				//Enter Description Field Using any Locator of Your Choice
				driver.findElement(By.id("createContactForm_description")).sendKeys("DESCRIPTION");
				
				//Enter your email in the E-mail address Field using the locator of your choice
				driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("hemapriya@gmail.com");
				
				//Select State/Province as NewYork Using Visible Text
				WebElement drop = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
				Select drpdwn = new Select(drop);
				drpdwn.selectByVisibleText("Louisiana");
				
				//Click on Create Contact
				driver.findElement(By.className("smallSubmit")).click();
				
				//Click on edit button 
				driver.findElement(By.linkText("Edit")).click();
				
				//Clear the Description Field using .clear
				driver.findElement(By.id("updateContactForm_description")).clear();
				
				//Fill ImportantNote Field with Any text
				driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Selenium class");
				
				//Click on update button using Xpath locator
				driver.findElement(By.xpath("//input[@value='Update']")).click();
				
				//Get the Title of Resulting Page.
				System.out.println("Title of the resulting page " + driver.getTitle());
				
	}

}
