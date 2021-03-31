package com.xeneta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookMeetingTest {
	
	@Parameters({"page"})
	@Test
	public void scheduleNow(String page) {
		
		/*
		 * Problem Statement -> To check 'Schedule Now' button action 
		 * 
		 * Flow: Open google chrome browser -> open link -> accept cookies message -> 
		 * click 'Schedule Now' button -> extract values from Popup window -> assert/verify -> close browser
		 * 
		 * Values to extract: 1. Form Popup 1 display mode
		 * 
		 * Assertions for this Test Case: 
		 * 1. If display mode change from 'none' to 'inline-block'
		 */

		
		System.out.println("Starting Demo Page - Schedule Now Button Test");
		
		// Create Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximise browser window
		driver.manage().window().maximize();

		// Sleep for 1 second
		sleep(1000);

		// Open test page
		String url = "https://www.xeneta.com/"+page;

		driver.get(url);
		System.out.println("The page is opened");

		// Sleep for 1 second1
		sleep(1000);
		
		// Handle cookie message by clicking accept button
	    driver.findElement(By.id("hs-eu-confirmation-button")).click();
		
	    // Sleep for 1 second
	 	sleep(1000);
	    
	 // Click on 'Schedule Now' Button
 	 	WebElement scheduleNow = driver.findElement(By.xpath("//a[@class='popup-btn'][contains(text(),'Schedule Now')]"));
 	 	scheduleNow.click();
	 	
	 	sleep(1000);
	 	
		// Extracting Field form popup status
	 	WebElement formElement = driver.findElement(By.xpath("//div[@id='form-popup-2']"));
	 	String actualStatus = formElement.getAttribute("style").strip();
	 	System.out.println(actualStatus);
	 	
	 	//Assertions of Test Case
	 	String expectedStatus = "display: inline-block;";
	 	Assert.assertEquals(actualStatus, expectedStatus, "Form Status denotes that the form is not opened");
	 	
	 	//Close browser
	 	driver.quit();

	}
	
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
