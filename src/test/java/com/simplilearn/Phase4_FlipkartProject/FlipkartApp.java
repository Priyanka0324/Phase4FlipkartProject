package com.simplilearn.Phase4_FlipkartProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FlipkartApp {
	
	//initializing the driver as Android driver
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApp() throws MalformedURLException {
		
		// 1) Launch the Flipkart application
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "RZ8N82V8VNY");		// Real device name
		cap.setCapability("platformName", "ANDROID");		
		cap.setCapability("appPackage", "com.flipkart.android");	
		cap.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		cap.setCapability("noReset", true);
		driver=new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);		//Appium server host & port no.
	}

	@Test
	public void FlipkartOderSummary() throws InterruptedException {
		
		Thread.sleep(3000);
		//search ‘mobile’ in the search-box
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Search for products']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Search for Products, Brands and More']")).sendKeys("Mobile");
		driver.findElement(By.xpath("//android.widget.TextView[@text='mobiles']")).click();
		
		//Click on the first search result
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Filter']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Brand']")).click();
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//android.widget.TextView[@text='SAMSUNG']")).click();
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Apply']")).click();
		
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='SAMSUNG Galaxy F23 5G (Aqua Blue, 128 GB)']")).click();
		
		//Click on ‘Add to cart’ button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']")).click();
		
		//Click on ‘Go to cart’ button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='GO TO CART']")).click();
		
		//Verify you see ‘Order Summary’ as heading of the activity
		Thread.sleep(5000);
		Boolean myCartItemIsPresent = driver.findElement(By.xpath("//android.widget.TextView[@text='My Cart']")).isDisplayed();
		Assert.assertTrue(myCartItemIsPresent);
		
	}
	
	@AfterTest
	public void CloseApp() {
		driver.quit();
		
	}


}
