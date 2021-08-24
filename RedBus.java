package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// 1.Go to https://www.redbus.in/ in chrome
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@data-id='123']")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bengaluru ");
		driver.findElement(By.xpath("//ul[@class='autoFill']/li")).click();
		driver.findElement(By.xpath("//td[text()='24']")).click();
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']/parent::div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='close-primo']/i")).click();
		String busSeatResult = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total no. of bus seat found :" + busSeatResult);

		driver.findElement(By.xpath("//label[text()='SLEEPER']/preceding-sibling::label")).click();
		Thread.sleep(1000);
		String sleeperBusResult = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total no. of Sleeper bus seat found :" + sleeperBusResult);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[text()='SLEEPER']/preceding-sibling::label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='AC']/preceding-sibling::label")).click();
		String deselectSleeperRslt = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total no. AC bus seat found :" + deselectSleeperRslt);
		
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//label[text()='NONAC']/preceding-sibling::label")).click();
	    String nonAcAndAcSeatFound = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
	    System.out.println("Number of AC & Non AC seats found are : "+nonAcAndAcSeatFound);

	}

}
