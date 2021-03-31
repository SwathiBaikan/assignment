package com.xeneta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ClickingCircleTests {

	
	/*
	 * Problem Statement -> To check clicking on circles route to correct pages
	 * 
	 * This files contains 3 tests, 1 for each circle on Demo page
	 * 
	 * Flow: Open google chrome browser -> open link -> click circle ->
	 * assert/verify -> close browser
	 * 
	 * Assertions for this Test Cases:
	 * 1st Test case -> Does it route to Watch Videos page?
	 * 2nd Test case -> Does it route to Schedule Demo page?
	 * 3rd Test case -> Does it route to Signup page?
	 * 
	 */
	@Test (priority = 1)
	public void watchVideoCircle() {
		
		System.out.println("Starting Demo Page - Clicking Watch Demo Circle");
		
		// Create Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximise browser window
		driver.manage().window().maximize();

		// Sleep for 1 second
		sleep(1000);

		// Open test page
		String url = "https://www.xeneta.com/demo";

		driver.get(url);
		System.out.println("The page is opened");

		// Sleep for 2 seconds
		sleep(2000);
		
		// Handle cookie message by clicking accept button
	    driver.findElement(By.id("hs-eu-confirmation-button")).click();
		
		// Click on 'Watch Videos' circle
		WebElement watchVideosCircle = driver.findElement(By.xpath("//div[@class='body-container-wrapper']//div[@style='background:#F9f9f9 url(https://www.xeneta.com/hubfs/Accessible.png) no-repeat']"));
		watchVideosCircle.click();
		
		// Extracting url after clicking
		String actualUrl = driver.getCurrentUrl().split("\\?")[0];
		System.out.println(actualUrl);
		
		//Assertions of Test Case -> Assert the Page URL after clicking the icon
		String expectedUrl = "https://www.xeneta.com/demo";
		Assert.assertEquals(actualUrl, expectedUrl, "Actual url after clicking on Watch Videos circle is not the same as expected");
		
		// Close browser
		driver.quit();
		
	}
	@Test (priority = 2)
	public void bookMeetingCircle() {
		
		System.out.println("Starting Demo Page - Clicking Book Meeting Circle");
		
		// Create Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximise browser window
		driver.manage().window().maximize();

		// Sleep for 1 second
		sleep(1000);

		// Open test page
		String url = "https://www.xeneta.com/demo";

		driver.get(url);
		System.out.println("The page is opened");

		// Sleep for 2 seconds
		sleep(2000);
		
		// Handle cookie message by clicking accept button
	    driver.findElement(By.id("hs-eu-confirmation-button")).click();
		
		// Click on 'Watch Videos' circle
		WebElement bookMeetingCircle = driver.findElement(By.xpath("//div[@class='body-container-wrapper']//div[@style='background:#F9f9f9 url(https://www.xeneta.com/hubfs/Unique%20services.png) no-repeat']"));
		bookMeetingCircle.click();
		
		// Extracting url after clicking
		String actualUrl = driver.getCurrentUrl().split("\\?")[0];
		System.out.println(actualUrl);
		
		//Assertions of Test Case -> Assert the Page URL after clicking the icon
		String expectedUrl = "https://www.xeneta.com/demo";
		Assert.assertEquals(actualUrl, expectedUrl, "Actual url after clicking on Book Meeting circle is not the same as expected");
		
		// Close browser
		driver.quit();
		
	}
	@Test (priority = 3)
	public void signUpCircle() {
		
		System.out.println("Starting Demo Page - Clicking SignUp Circle");
		
		// Create Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximise browser window
		driver.manage().window().maximize();

		// Sleep for 1 second
		sleep(1000);

		// Open test page
		String url = "https://www.xeneta.com/demo";

		driver.get(url);
		System.out.println("The page is opened");

		// Sleep for 2 seconds
		sleep(2000);
		
		// Handle cookie message by clicking accept button
	    driver.findElement(By.id("hs-eu-confirmation-button")).click();
		
		// Click on 'Watch Videos' circle
		WebElement signUpCircle = driver.findElement(By.xpath("//div[@class='body-container-wrapper']//div[@style='background:#F9f9f9 url(https://www.xeneta.com/hubfs/Compare%20to%20peers.png) no-repeat']"));
		signUpCircle.click();
		
		// Extracting url after clicking
		String actualUrl = driver.getCurrentUrl().split("\\?")[0];
		System.out.println(actualUrl);
		
		//Assertions of Test Case -> Assert the Page URL after clicking
		String expectedUrl = "https://www.xeneta.com/live-group-demo-sign-up";
		Assert.assertEquals(actualUrl, expectedUrl, "Actual url after clicking on SignUp circle is not the same as expected");
		
		// Close browser
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
