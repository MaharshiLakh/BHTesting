package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Serachbutton;
import testBase.BaseClass;

public class TC01_Test1 extends BaseClass{

	@Test
	public void verify_text()
	{
		Serachbutton searchbutton = new Serachbutton(driver);
		
		//2Click on search/loop icon (top, right corner)
		searchbutton.clickCookie();
		searchbutton.clickSerachbutton();
		System.out.println("Checkpoint 2");
		
		//3Verify if search field is visible on the full page
		searchbutton.verifySearchVisibility();
		
		
		//"Type:
		//Employee Education in 2018: Strategies to Watch
		//into the search field and click on Search button"
		searchbutton.setSerachText("Employee Education in 2018: Strategies to Watch");
		searchbutton.clickSerachButton();
		
		//Verify if the first search result is exact match to what you typed into search 
		searchbutton.verifyTextFirstSerach();
		System.out.println("Test 1 Complete");
		
		
	}	
		
	}
	
