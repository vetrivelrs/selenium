package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PojoSupport extends BaseClass{
	
	public static void main(String[] args) {
		
		brwlaunch("https://adactinhotelapp.com/");
		Pojo p = new Pojo();
		WebElement user = p.getUser();
		user.sendKeys("SuguAravind");
		WebElement pass = p.getPass();
		pass.sendKeys("sugu@3005");
		driver.navigate().refresh();
		String attribute = pass.getAttribute("id");
		System.out.println(attribute);
		WebElement user1 = p.getUser();
		user1.sendKeys("vetri");
		WebElement pass1 = p.getPass();
		pass1.sendKeys("12345");
		WebElement btn = p.getBtn();
		btn.click();
				
		
		
		
				}

}
