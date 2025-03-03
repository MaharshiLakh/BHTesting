package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.VerifyComments;
import testBase.BaseClass;

public class TC02_Test2 extends BaseClass{

	
	@Test
	public void VerifyCenter()
	{
	
		VerifyComments repage = new VerifyComments(driver);

		repage.Allaccept();
		System.out.println("Checkpoint 2");
		//Click on Find a Center option (top header)
		repage.ClickFindCenter();
		//Verify that newly open page contains: 
		///child-care-locator
		 //as a part of its URL 
		
		System.out.println("Checkpoint 3");
		repage.VerifyWebURL();
		
		repage.VerifyTitle();
		
		System.out.println("Checkpoint 4");
		//Type New York
		//into search box and press Enter the search
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		repage.EnterCenter();
		
		//Validating the number of Centers
		System.out.println("Checkpoint 5");
		//validate total number of centers
		repage.ValidateCenter();
	
		//click the First Search Value
		System.out.println("Checkpoint 6");
		repage.ClickFirstSearchCenter();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Matching the Headings
		System.out.println("Checkpoint 7");
		repage.MatchHeaderText();
		
		//Matching the Address
		repage.MatchAddress();
		System.out.println("Test 2 complete");

}
}
