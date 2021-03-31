package com.xeneta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareersHeadingTest {
	
	@Test
	public void headingTest2() {
		
		/*
		 * Problem Statement -> To check the heading on the Careers page
		 * 
		 * Flow: Open google chrome browser -> open link -> extract values ->
		 * assert/verify -> close browser
		 * 
		 * Values to extract: 1. Heading  
		 * 
		 * Assertions for this Test Case: 
		 * 1. Heading should be "Join Us" 
		 */
		
		System.out.println("Starting Careers Page - Heading Test");
		
		// Create Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximise browser window
		driver.manage().window().maximize();

		// Sleep for 1 second
		sleep(1000);

		// Open test page
		String url = "https://www.xeneta.com/careers";

		driver.get(url);
		System.out.println("The page is opened");

		// Sleep for 1 second1
		sleep(1000);
		
		// Extracting heading
		WebElement heading = driver.findElement(By.xpath("//div[@class='banner-title white-color']//h1"));
		String actualHeading = heading.getText().strip();
		System.out.println(actualHeading);

		//Assertions of Test Case -> Assert the Heading
		String expectedHeading = "Join Us";
		Assert.assertEquals(actualHeading, expectedHeading, "Actual Heading is not the same as expected");
				
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
