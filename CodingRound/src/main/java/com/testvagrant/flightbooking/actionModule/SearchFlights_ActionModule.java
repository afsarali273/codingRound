package com.flightbooking.actionModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.flightbooking.pageObjects.SeacrhFlightsClearTrip_PageObjects;

import junit.framework.Assert;

public class SearchFlights_ActionModule {

	WebDriver driver;
	SeacrhFlightsClearTrip_PageObjects Objsearchpage;
	public SearchFlights_ActionModule(WebDriver driver){
		this.driver=driver;
		Objsearchpage=new SeacrhFlightsClearTrip_PageObjects(driver);
	}

	public void FilghtSearch(String EnterFrom,String EnterToCity,String EnterDate){
		Objsearchpage.input_From().sendKeys(EnterFrom);
		System.out.println("From City is Entered as : "+EnterFrom);
		Objsearchpage.dropdownList_From(EnterFrom).click();
		System.out.println("Clicked on the Flight Selected ");
		Objsearchpage.input_To().sendKeys(EnterToCity);
		System.out.println("To City is Enterd as : "+EnterToCity);
		Objsearchpage.dropdownList_To(EnterToCity).click();
		System.out.println("To City is Entered as : "+EnterToCity);
		//for Entering value into Date picker using JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('DepartDate').value = '"+EnterDate+"';");//DDmmYYYY format
		System.out.println("Date is entered as : "+EnterDate);
		Objsearchpage.button_Search().click();
		System.out.println("Search button is clicked ");
		waitFor(10000);//Waiting for the Result page to be dispalyed

		Boolean result=isElementPresent(By.className("searchSummary"));
		//System.out.println(Objsearchpage.text_SearchResult().getText());
		Assert.assertTrue("Search Summary Result is dispalyed", result);


	}



	 private void waitFor(int durationInMilliSeconds) {
	        try {
	            Thread.sleep(durationInMilliSeconds);
	        } catch (InterruptedException e) {
	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        }
	    }


	    private boolean isElementPresent(By by) {
	        try {
	            driver.findElement(by);
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }



}
