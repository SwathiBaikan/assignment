package com.xeneta;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenRolesTests {
	
	/*
	 * Problem Statement -> To check Open Roles Section
	 * 
	 * Flow: Open google chrome browser -> open link -> accept cookies message -> 
	 * Click/extract values -> assert/verify -> close browser
	 * 
	 * Values to extract: 
	 * 1. Open Roles Count
	 * 2. Open Roles Name
	 * 3. Open Block status - open = 'display: block' / close = 'display: none' 
	 * 4. Role name on new page after clicking 'Apply'
	 *  
	 * Assertions for this Test Case: 
	 * 1. No. of open roles -> 5
	 * 2. Clicking on 1 role, does it expand the page block
	 * 3. Whether Roles are repeating or not
	 * 4. Does it contain 1 particular name, this is test case -> check 'TEST AUTOMATION ENGINEER'
	 * 5. After clicking 'Apply' does it go to proper page -> Role Name check 
	 */
	
	@Parameters({"page","number","role"})
	@Test (priority = 1)
	public void openRolesCountTest (String page, int expectedNumRoles, String roleCheck) {
		
		System.out.println("Starting Careers Page - Checking Open Roles Count");
		
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
		
		
		// Extract Roles Count
		List<WebElement> roles = driver.findElements(By.xpath("//div[@class='accordion']//div[@class='acdn-heading']//h4"));
		int actualNumRoles = roles.size();
		System.out.println(actualNumRoles);
				
		// Assertion
		Assert.assertEquals(actualNumRoles, expectedNumRoles, "Actual number of available roles are not the same as expected");
				
		//Close browser
		driver.quit();
		
	}
	
	@Parameters({"page","number","role"})
	@Test (priority = 2)
	public void clickExpandRoleTest (String page, int expectedNumRoles, String roleCheck) {
		
		System.out.println("Starting Careers Page - Checking whether block expands or not");
		
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
		
		
		// Perform
		List<WebElement> roles = driver.findElements(By.xpath("//div[@class='accordion']//div[@class='acdn-heading']//h4"));
		
		// Clicking the first role only, if we have to click all roles then a for loop can be added to run the index from 0 to 5.  
		System.out.println(roles.get(0).getText());
		roles.get(0).click();
		
		// Extracting the content block status for 1st role
		List<WebElement> blockStatus = driver.findElements(By.xpath("//div[@class='accordion_content']"));
		String actualBlockStatus = blockStatus.get(0).getAttribute("style").split(";")[0];
		System.out.println(actualBlockStatus);
		
		// Assertion
		String expectedBlockStatus = "display: block";
		Assert.assertEquals(actualBlockStatus, expectedBlockStatus, "Block for the first role did not open after clicking");
				
		//Close browser
		driver.quit();
		
	}
	
	@Parameters({"page","number","role"})
	@Test (priority = 3)
	public void repeatingRolesTest (String page, int expectedNumRoles, String roleCheck) {
		
		System.out.println("Starting Careers Page - Ensuring no roles are repeating");
		
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
		
		
		// Perform
		List<WebElement> roles = driver.findElements(By.xpath("//div[@class='accordion']//div[@class='acdn-heading']//h4"));
		int actualNumRoles = roles.size();
		
	  
		// Extract all the names and storing in an Array of String
		String[] nameRoles = new String[actualNumRoles];
		
		// To fail this test case, we can add an extra space to the string array and add the same value as of the last role
		//String[] nameRoles = new String[6];
		//nameRoles[5] = roles.get(4).getText();
		
		for (int i=0; i<actualNumRoles;i++){
			nameRoles[i] = roles.get(i).getText();
		}

		
		// Comparing each element in String Array to determine if the elements are duplicate or not
		Boolean duplicateValue = false; // Assuming there is no duplicate value
		for (int i = 0; i < nameRoles.length; i++) { 
			for (int j = i + 1 ; j < nameRoles.length; j++) { 
				if (nameRoles[i].equals(nameRoles[j])) { 
					duplicateValue = true; // this changes as soon as a duplicate value is found
					} 
				} 
			}
				  
		// Assertion
		Assert.assertFalse(duplicateValue, "Duplicate roles found in the listing");
	  
		//Close browser 
		driver.quit();
		
	}
	
	@Parameters({"page","number","role"})
	@Test (priority = 4)
	public void checkRoleTest (String page, int expectedNumRoles, String roleCheck) {
		
		System.out.println("Starting Careers Page - Checking 'TEST AUTOMATION ENGINEER' Role is present");
		
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
				
		// Perform
		List<WebElement> roles = driver.findElements(By.xpath("//div[@class='accordion']//div[@class='acdn-heading']//h4"));
				
		Boolean rolePresent = false;  // assuming the role is not present
		for (int i=0; i<roles.size();i++){
			if (roles.get(i).getText().equals(roleCheck)) {
				rolePresent = true; // this changes as soon as a found is match
				}
			}
				  
		// Assertion
		Assert.assertTrue(rolePresent, "'TEST AUTOMATION ENGINEER' is not present in the listed roles");
	  
		//Close browser 
		driver.quit();
		
	}
	
	@Parameters({"page","number","role"})
	@Test (priority = 5)
	public void checkApplyLinkTest (String page, int expectedNumRoles, String roleCheck) {
		
		System.out.println("Starting Careers Page - Checking 'Apply' Link");

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
		
		
		// Clicking on first role name
		List<WebElement> roles = driver.findElements(By.xpath("//div[@class='accordion']//div[@class='acdn-heading']//h4"));
		roles.get(0).click();
		
		// Sleep for 1 second
		sleep(1000);
	
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		// Clicking on first role 'Apply Link'
		List<WebElement> applyLinks = driver.findElements(By.xpath("//div[@class='accordion_content']//a"));
		applyLinks.get(0).click();
		sleep(1000);

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		// Extracting URL and Job Title from new window
		String actualUrl = driver.getCurrentUrl(); // there are 2 different pages for these profiles, which has different places for job titles
				
		String actualRole; // Defining blank string variable to have Job Title using below if-else statements
		
		//Extracting Job Title from the new window
		if(actualUrl.contains("bamboohr")) {
			WebElement actualJobTitle = driver.findElement(By.xpath("//h2")); //for BambooHR, job title is present in H2
			actualRole = actualJobTitle.getText();
			
		} else {
			WebElement actualJobTitle = driver.findElement(By.xpath("//h1")); //for FirstEngineer, job title is present in H1
			actualRole = actualJobTitle.getText();
		}
		
		// Sleep for 1 second
		sleep(1000);
		
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		// Assertion
		String expectedRole = roles.get(0).getText();
		Assert.assertEquals(actualRole, expectedRole, "Actual Heading is not the same as expected");
		
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
