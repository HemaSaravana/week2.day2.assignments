package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();

		// Enter the email
		driver.findElement(By.name("emailAddress")).sendKeys("hemasarava@gmail.com");

		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);

		WebElement firstLead = driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a"));
		// Capture name of First Resulting lead
		String firstLeadTxt = firstLead.getText();
		System.out.println("First Resulting Lead Name : " + firstLeadTxt);

		// Click First Resulting lead
		firstLead.click();
		
		//Click on Duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//Verify the title as 'Duplicate Lead'
		System.out.println(driver.getTitle());
		
		//Click Create Lead
		driver.findElement(By.name("submitButton")).click();
		
		//Confirm the duplicated lead name is same as captured name
		String duplicateLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		if(duplicateLeadName.equals(firstLeadTxt)) {
			System.out.println(duplicateLeadName + " && " + firstLeadTxt + " are equals to eachother");
		}
		driver.close();
	}

}
