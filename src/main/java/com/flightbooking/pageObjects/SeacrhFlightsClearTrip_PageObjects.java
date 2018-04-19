package com.flightbooking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeacrhFlightsClearTrip_PageObjects {

	WebDriver driver;
	WebElement element=null;;

	public  SeacrhFlightsClearTrip_PageObjects(WebDriver driver){

		this.driver=driver;
	}

	public WebElement radioButton_FlightMode_OneWay(){

		try {
			element=driver.findElement(By.id("OneWay"));
			System.out.println("One Way radio button is diaplayed ");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement dropdownList_From(String EnterCityFrom){

		try {
			element=driver.findElement(By.id(".//*[@id='ui-id-1']/li/a[contains(text(),'"+EnterCityFrom+"')]"));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement dropdownList_To(String EnterCityTo){

		try {
			element=driver.findElement(By.xpath(".//*[@id='ui-id-2']/li/a[contains(text(),'"+EnterCityTo+"')]"));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement input_From(){

		try {
			element=driver.findElement(By.id("FromTag"));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement input_To(){

		try {
			element=driver.findElement(By.id("ToTag"));
			System.out.println("To tag input box is displayed on the Flight search page");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement input_DatePicker(){

		try {
			element=driver.findElement(By.id("DepartDate"));
			System.out.println("Depart  is Present on the datePicker input box");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement button_Search(){

		try {
			element=driver.findElement(By.id("SearchBtn"));
			System.out.println("Search button is present on the Flight search page");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}

	public WebElement text_SearchResult(){

		try {
			element=driver.findElement(By.className("searchSummary"));
			System.out.println("Search Summary Result is Dispalyed on the Search result page");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not located due to the exceptions : "+e.getMessage());
		}
		return element;
	}




}
