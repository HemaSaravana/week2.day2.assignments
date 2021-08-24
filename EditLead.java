package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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

		// Enter first name
		driver.findElement(By.xpath("(//div[@class='x-form-item x-tab-item'])[2]//input")).sendKeys("hema");

		// Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);

		// Click on first resulting lead
		driver.findElement(By.xpath("//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ')]//a")).click();

		// Verify title of the page
		System.out.println(driver.getTitle());
		
		// To get Original company name string
		String originalCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();

		// Click on Edit
		Thread.sleep(2000);
		driver.findElement(By.linkText("Edit")).click();

		// Change the company name
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys("CTS Company");

		// Click on update
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		// Confirm the changed name appears

		String changeCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		// print Original company and edited company name
		System.out.println("Comapny Name before update : " + originalCompanyName + "Company Name after update " + changeCompanyName);
		driver.close();
	}

}
