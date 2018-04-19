package com.hotelSearch.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.BaseClass;

public class ClearTripHotelSearchPage_PageFactory {

	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;



    public void HotelSearch(String EnterLocalitySeacrhText,String EnterTravellersVisibleText){

    	hotelLink.click();
    	System.out.println("Hotel Link is Clicked");
    	localityTextBox.sendKeys(EnterLocalitySeacrhText);
    	System.out.println("Locality Search box is Enterd as : "+EnterLocalitySeacrhText);//2 rooms, 4 adults
    	BaseClass.Select_By_VisibleText(travellerSelection,EnterTravellersVisibleText);
    	System.out.println("Travellers are selected as  "+EnterTravellersVisibleText);
    	searchButton.click();
    	System.out.println("Search button is clicked ");
    }


}
