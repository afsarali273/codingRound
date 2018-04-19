package com.flightbooking.actionModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.flightbooking.pageObjects.SignIn_PageObject;
import com.utility.BaseClass;

import junit.framework.Assert;

public class SignIn_Actions {

	WebDriver driver;
	SignIn_PageObject signin;
	public SignIn_Actions(WebDriver driver){
		this.driver=driver;
		signin=new SignIn_PageObject(driver);
	}


	public void verifySignIn(){

		signin.linkText_YourTrip().click();
		System.out.println("your trip link text is clicked");
		signin.button_SignIn().click();
		System.out.println("Sign In button is Clciked ");
		signin.button_SignInSubmission().click();
		System.out.println("Final Sign In Sub,ission button is Clicked ");

		if(BaseClass.isElementPresent(driver, By.id("errors1"))){
			Assert.assertTrue(signin.text_errorMsg().getText().contains("There were errors in your submission"));
		}else{
			try {
				Assert.assertFalse(true);
				throw new Exception("Error Message is not found ");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
