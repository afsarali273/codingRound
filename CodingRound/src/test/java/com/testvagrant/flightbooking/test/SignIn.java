package com.flightbooking.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flightbooking.actionModule.SignIn_Actions;
import com.utility.BaseClass;

public class SignIn extends BaseClass{

	SignIn_Actions signin;
	@Parameters({"browsername","URL"})
	@BeforeTest
	public void FlightSearchSetUp(@Optional("Chrome")String browsername,@Optional("https://www.cleartrip.com/")String URL){

		OpenBrowser(browsername, URL);
		signin=new SignIn_Actions(driver);
	}

	@Test
	public void SignInTest(){

		System.out.println("*****Executing  ******* ");

		signin.verifySignIn();
	}

}
