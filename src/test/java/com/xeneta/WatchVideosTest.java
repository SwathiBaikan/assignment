package com.xeneta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WatchVideosTest {
	
	@Parameters({"page","pageHeading","pageTitle","pageUrl"})
	@Test
	public void watchVideo(String page, String expectedHeading, String expectedPageTitle, String expectedUrl) {
		
		/*
		 * Problem Statement -> To check the 'Watch Videos' button action 
		 * 
		 * Flow: Open google chrome browser -> open link -> accept cookies message -> 
		 * click 'Watch Videos' button -> extract values -> assert/verify -> close browser
		 * 
		 * Values to extract: 1. Heading    2. Page Title   3. url after clicking
		 * 
		 * Assertions for this Test Case: 
		 * 1. Heading should be "Learn More About Xeneta" 
		 * 2. Title of the page "Watch Xeneta Videos"
		 * 3. New link is 'https://www.xeneta.com/watchdemos'
		 */

		
		System.out.println("Starting Demo Page - Watch Videos Button Test");
		
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
	    
		// Click on 'Watch Videos'
		WebElement watchVideos = driver.findElement(By.xpath("//span/a[@title='WATCH VIDEOS']"));
		watchVideos.click();
		
		/*
		 * Other ways to identify the same 'Watch Videos' button 1.
		 * xpath("//a[@id='cta_button_1816946_9de3cc6a-09e2-43f8-a2ff-7688cf0588ee']")
		 * 2. id("cta_button_1816946_9de3cc6a-09e2-43f8-a2ff-7688cf0588ee")
		 */
		
		// Extracting heading
		WebElement heading = driver.findElement(By.xpath("//div[@class='banner-title white-color']//h1"));
		String actualHeading = heading.getText().strip();
		System.out.println(actualHeading);
		
		// Extracting Page Title
		String actualPageTitle = driver.getTitle();
		System.out.println(actualPageTitle);
		
		// Extracting Page URL
		String actualUrl = driver.getCurrentUrl().split("\\?")[0];
		System.out.println(actualUrl);
		
		//Assertions of Test Case
		
		// Assertion 1 -> Assert the Heading
		Assert.assertEquals(actualHeading, expectedHeading, "Actual Heading is not the same as expected");
				
		// Assertion 2 -> Assert the Page Title
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "Actual Page Title is not the same as expected");
		
		// Assertion 3 -> Assert the Page URL after clicking
		Assert.assertEquals(actualUrl, expectedUrl, "Actual url after clicking is not the same as expected");
				
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
