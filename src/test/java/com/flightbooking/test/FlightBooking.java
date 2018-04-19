package com.flightbooking.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flightbooking.actionModule.SearchFlights_ActionModule;
import com.utility.BaseClass;

public class FlightBooking extends BaseClass{

	SearchFlights_ActionModule search;
	@Parameters({"browsername","URL"})
	@BeforeTest
	public void FlightSearchSetUp(@Optional("Chrome")String browsername,@Optional("https://www.cleartrip.com/")String URL){

		OpenBrowser(browsername, URL);
		search=new SearchFlights_ActionModule(driver);
	}

	@Test
	public void FlightSearchTest(){

		System.out.println("*****Executing Search Flight Test ******* ");

		search.FilghtSearch("Bangalore", "Delhi", "25/04/2018");
	}

}
