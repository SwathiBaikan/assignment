package com.xeneta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareersVisitLinkTests {
	
	/*
	 * Problem Statement -> To check clicking on circles route to correct pages
	 * 
	 * This files contains 3 tests, 1 for each circle on Demo page
	 * 
	 * Flow: Open google chrome browser -> open link -> accept cookies message -> 
	 * click visit link -> assert/verify -> close browser
	 * 
	 * Assertions for this Test Cases:
	 * 1st Test case -> Does it route to Oslo page?
	 * 2nd Test case -> Does it route to New York page?
	 * 3rd Test case -> Does it route to Hamburg page?
	 * 
	 * 
	 * 
	 */
	@Test (priority = 1)
	public void osloVisitLink () {
		
		System.out.println("Starting Careers Page - Oslo Visit Link Test");
		
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
		
		// Handle cookie message by clicking accept button
	    driver.findElement(By.id("hs-eu-confirmation-button")).click();

		// Sleep for 1 second
		sleep(1000);
		
		WebElement visitLink = driver.findElement(By.xpath("//div[@id='slick-slide00']//a[@class='cta_button']"));
		visitLink.click();
		
		//Extracting url after clicking
		String actualUrl = driver.getCurrentUrl().split("\\?")[0];
		System.out.println(actualUrl);
		
		// Sleep for 1 second
		sleep(1000);
		
		// Assertion of Test Case -> New page url is same as expected
		String expectedUrl = "https://www.xeneta.com/locations/oslo";
		Assert.assertEquals(actualUrl, expectedUrl, "Actual url is not the same as expected");
		
		//Close browser
		driver.quit();
		
	}
	
	@Test (priority = 2)
	public void newYorkVisitLink () {
		
		System.out.println("Starting Careers Page - New York Visit Link Test");
		
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
		
		// Handle cookie message by clicking accept button
	    driver.findElement(By.id("hs-eu-confirmation-button")).click();

		// Sleep for 1 second
		sleep(1000);
		
		WebElement visitLink = driver.findElement(By.xpath("//div[@id='slick-slide01']//a[@class='cta_button']"));
		visitLink.click();
		
		//Extracting url after clicking
		String actualUrl = driver.getCurrentUrl().split("\\?")[0];
		System.out.println(actualUrl);
		
		// Sleep for 1 second
		sleep(1000);
		
		// Assertion of Test Case -> New page url is same as expected
		String expectedUrl = "https://www.xeneta.com/locations/new-york";
		Assert.assertEquals(actualUrl, expectedUrl, "Actual url is not the same as expected");
		
		//Close browser
		driver.quit();
		
	}
	
	@Test (priority = 3)
	public void hamburgVisitLink () {
		
		System.out.println("Starting Careers Page - Hamburg Visit Link Test");
		
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
		
		// Handle cookie message by clicking accept button
	    driver.findElement(By.id("hs-eu-confirmation-button")).click();

		// Sleep for 1 second
		sleep(1000);
		
		WebElement visitLink = driver.findElement(By.xpath("//div[@id='slick-slide02']//a[@class='cta_button']"));
		visitLink.click();
		
		//Extracting url after clicking
		String actualUrl = driver.getCurrentUrl().split("\\?")[0];
		System.out.println(actualUrl);
		
		// Sleep for 1 second
		sleep(1000);
				
		// Assertion of Test Case -> New page url is same as expected
		String expectedUrl = "https://www.xeneta.com/locations/hamburg";
		Assert.assertEquals(actualUrl, expectedUrl, "Actual url is not the same as expected");
		
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
