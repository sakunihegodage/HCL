package com.qa.AutomationAssesment.com.qa.AutomationAssesment;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginToEbay {
	
	// Initializing the WebDriver
		WebDriver driver;
		
		
		@BeforeTest
		public void PreCondition() throws IOException {

			System.setProperty(
				    "webdriver.gecko.driver",
				    "C:\\Users\\HP\\eclipse-workspace\\com.qa.AutomationAssesment\\drivers\\geckodriver.exe"); 
			
			driver = new FirefoxDriver();

			driver.get("https://www.google.com/");
			driver.manage().window().maximize();

		}
		
		@AfterTest
		public void PostCondition() {

			//driver.quit();
		}
		
		@Test
		public void GoogleSearchEbay() throws InterruptedException {
			
			//Search for ebay keyword in google search engine
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys("ebay");
			
			//Provide keyboard enter key for the search
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.RETURN);
			
			Thread.sleep(3000);
			
			//Click on the link to navigate to the ebay login page
			driver.findElement(By.xpath("//h3[text()='eBay: Electronics, Cars, Fashion, Collectibles, Coupons and More']")).click();
			
			Thread.sleep(5000);
			
			//click on the signin button
			driver.findElement(By.xpath("//*[@id=\"gh-ug\"]/a")).click();
			
			//Enter email id in email field
			driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("SakuAutomation@gmail.com");
			
			//Enter password in the password field
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Welcome@123");
			
			//Click on the Login button
			driver.findElement(By.xpath("//button[@id='sgnBt']")).click();
			
			Thread.sleep(3000);
			
			//Verify whether the user has successfully logged in
			String ExectedebayName="Sakuni";
			String ActualebayName=driver.findElement(By.xpath("//*[@id=\"gh-ug\"]/b[1]")).getText();
			
			Thread.sleep(5000);
			
			//Verify the username
			Assert.assertEquals(ActualebayName, ExectedebayName, "Successfull Login");
		}
			

}
