package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Hema");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		WebElement leadID = driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a"));
		String leadIDtxt = leadID.getText();
		leadID.click();

		String findLeadURL = driver.getCurrentUrl();
		System.out.println("landed in view lead page" + findLeadURL);

		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Hema");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();


		String leadIDAfterDeleText = driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a")).getText();
				

		if (!leadIDtxt.equals(leadIDAfterDeleText)) {
			System.out.println("lead Id not exist");
		}
		driver.close();
	}

}
