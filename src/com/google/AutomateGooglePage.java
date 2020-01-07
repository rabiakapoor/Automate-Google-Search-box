package com.google;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateGooglePage {

	public static void main(String[] args) {
        
		//Launch the Browser   
		System.setProperty("driver.chrome.driver",
				"\\Users\\lalit\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         
		//open url  
		driver.get("https://www.google.com/");
        
		//find the search box element by name locator and type testing 
		driver.findElement(By.name("q")).sendKeys("testing");
        
		//complete list of elements are stored in list 
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));
		System.out.println(list.size());
        
		//by using for loop select testing mom and click it
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("testing mom")) {
				list.get(i).click();

				break;

			}

		}
        //close the browser 
		driver.close();

	}

}
