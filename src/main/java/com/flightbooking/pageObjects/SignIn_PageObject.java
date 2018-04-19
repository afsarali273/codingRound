package com.flightbooking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn_PageObject {

	WebDriver driver;
	WebElement element=null;;

	public  SignIn_PageObject(WebDriver driver){

		this.driver=driver;
	}

	public WebElement linkText_YourTrip(){

		try {
			element=driver.findElement(By.linkText("Your trips"));
			System.out.println("your trips Link is Displayed ");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement button_SignIn(){

		try {
			element=driver.findElement(By.id("SignIn"));
			System.out.println("Sign In button is Displayed ");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement button_SignInSubmission(){
		try {
			element=driver.findElement(By.id("signInButton"));
			System.out.println("Sign In button is Displayed ");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement text_errorMsg(){
		try {
			element=driver.findElement(By.id("errors1"));
			System.out.println("Sign In button is Displayed ");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

}
