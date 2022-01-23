package org.test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Receiver extends BaseClass {
	@Test(dataProvider="pro")
	private void launch(String username,String password,String firstname,String lastname,String address ,
			String ccnum,String cvv) throws IOException {
	brwlaunch();
   locatorsxpath("//input[@id='username']").sendKeys(username);
	locatorsxpath("//input[@id='password']").sendKeys(password);
	locatorsxpath("//input[@name='login']").click();
	WebElement s1 = locatorsxpath("//select[@id='location']");
	Selects(s1, "value", "Sydney");
	WebElement s2 = locatorsxpath("//select[@id='hotels']");
	Selects(s2, "value", "Hotel Creek");
	WebElement s3 = locatorsxpath("//select[@id='room_type']");
	Selects(s3, "value","Double");
	WebElement s4 = locatorsxpath("//select[@id='room_nos']");
	Selects(s4, "value", "1");
	WebElement s5 = locatorsxpath("//select[@id='adult_room']");
	Selects(s5, "value", "1");
	WebElement s6 = locatorsxpath("//select[@id='child_room']");
	Selects(s6, "value","0");
	locatorsxpath("//input[@name='Submit']").click();
	locatorsxpath("//input[@name='radiobutton_0']").click();
	locatorsxpath("//input[@name='continue']").click();
	locatorsxpath("//input[@name='first_name']").sendKeys(firstname);
	locatorsxpath("//input[@name='last_name']").sendKeys(lastname);
	locatorsxpath("//textarea[@name='address']").sendKeys(address);
	locatorsxpath("//input[@name='cc_num']").sendKeys(ccnum);
	WebElement s7 = locatorsxpath("//select[@id='cc_type']");
	Selects(s7, "value", "VISA");
	WebElement s8 = locatorsxpath("//select[@id='cc_exp_month']");
	Selects(s8, "value", "10");
	WebElement s9 = locatorsxpath("//select[@id='cc_exp_year']");
	Selects(s9, "value", "2022");
	locatorsxpath("//input[@id='cc_cvv']").sendKeys(cvv);
	locatorsxpath("//input[@id='book_now']").click();
	waits();
	WebElement order = locatorsxpath("//input[@id='order_no']");
	String attribute = order.getAttribute("value");
	System.out.println("orderID : " +attribute);
	excelWrite(attribute);
	
	

	}
	
	@DataProvider(name="pro")
	private Object[][] dataprovider() throws IOException {
		return new Object[][] {
			{excelread(0, 0),excelread(0, 1),excelread(0, 2),excelread(0, 3),excelread(0, 4)
				,excelread(0, 5),excelread(0, 6)},
//			{excelread(2, 0),excelread(2, 1),excelread(2, 2),excelread(2, 3),excelread(2, 4)
//					,excelread(2, 5),excelread(2, 6)},
//			{excelread(4, 0),excelread(4, 1),excelread(4, 2),excelread(4, 3),excelread(4, 4)
//						,excelread(4, 5),excelread(4, 6)}
			
		};

	}
}
