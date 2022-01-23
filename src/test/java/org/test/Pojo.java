package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo extends BaseClass{
	
	public Pojo() {
		PageFactory.initElements(driver, this);
}
    @FindBy(id="username")
	private WebElement user;
	@FindBy(id="password")
	private WebElement pass;
	@FindBy(id="login")
	private WebElement btn;
	
	public WebElement getUser() {
		return user;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getBtn() {
		return btn;
	}
	
	
	
	
}
