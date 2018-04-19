package com.utility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import com.sun.javafx.PlatformUtil;

public class BaseClass {


	protected WebDriver driver;

	/**
	 * @author md.afsar.ali
	 * @Date 04/18/2018
	 * @param EnterBrowser
	 * @param EnterURL
	 * @desciption This Method will instantiate WebDriver
	 */
	public void OpenBrowser(String EnterBrowser,String EnterURL){
		String strBrowserName=EnterBrowser;
		String strURL=EnterURL;

		if(strBrowserName.equalsIgnoreCase("Chrome")){
			setDriverPath();//Setting Driver path
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
		}else if(strBrowserName.equalsIgnoreCase("IE")){

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(strURL);

		System.out.println("Browser is Launched sucessfully");
	}


    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

    @AfterMethod
    public void AfterMethod_(Method method){

    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
    	try {
			FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"/TakeSceenShots/"+method.getName().trim()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@AfterClass
	public void teardown(){

		//driver.quit();
		System.out.println("Driver instance is closed/killed");
	}

	//============ Utility Methods===================

	public static void Select_By_VisibleText(WebElement ele,String EnterTheVisibleText){

       Select se= new Select(ele);
        se.selectByVisibleText(EnterTheVisibleText);
	}

	public static void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    public static boolean isElementPresent(WebDriver driver,By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
