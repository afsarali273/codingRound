package com.hotelSearching.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hotelSearch.pageFactory.ClearTripHotelSearchPage_PageFactory;
import com.utility.BaseClass;

public class SearchHotel extends BaseClass{

	ClearTripHotelSearchPage_PageFactory hotel;

	@Parameters({"browsername","URL"})
	@BeforeTest
	public void HotelSearchSetUp(@Optional("Chrome")String browsername,@Optional("https://www.cleartrip.com/")String URL){

		OpenBrowser(browsername, URL);
		hotel=PageFactory.initElements(driver, ClearTripHotelSearchPage_PageFactory.class);
	}

	@Test
	public void HotelSearch(){
		hotel.HotelSearch("Indiranagar, Bangalore", "2 rooms, 4 adults");
	}

}
