package com.xeneta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoHeadingTest {

	@Parameters({"page","expectedHeading"})
	@Test
	public void headingTest(String page, String expectedHeading) {

		/*
		 * Problem Statement -> To check the heading on the Demo page
		 * 
		 * Flow: Open google chrome browser -> open link -> extract values ->
		 * assert/verify -> close browser
		 * 
		 * Values to extract: 1. Heading   2. Tag line
		 * 
		 * Assertions for this Test Case: 
		 * 1. Heading should be "Procure freight like a pro." 
		 * 2. Tag line should be "Monitor. Analyze. Budget. Plan. All with one platform."
		 */

		System.out.println("Starting Demo Page Heading Test");
		
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

		// Sleep for 2 seconds
		sleep(2000);

		System.out.println("Extracting heading and tagline");
		
		// Extracting heading
		WebElement heading = driver.findElement(By.xpath("//div[@class='banner-title white-color']//h1"));
		String actualHeading = heading.getText().strip();
		System.out.println(actualHeading);
		
		// Extracting tag line
		WebElement tagLine = driver.findElement(By.xpath("//div[@class='banner-title white-color']//h2"));
		String actualTagLine = tagLine.getText().strip();
		System.out.println(actualTagLine);
		
		//Assertions of Test Case
		
		// Assertion 1 -> Assert the Heading
		Assert.assertEquals(actualHeading, expectedHeading, "Actual Heading is not the same as expected");

		/*
		 * // Assertion 2 -> Assert the Tag Line String expectedTagLine =
		 * "Monitor. Analyze. Budget. Plan. All with one platform.";
		 * Assert.assertEquals(actualTagLine, expectedTagLine,
		 * "Actual Tag Line is not the same as expected");
		 */
		
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
