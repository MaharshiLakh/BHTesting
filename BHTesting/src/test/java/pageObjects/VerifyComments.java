package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class VerifyComments extends BasePage {
	
	public VerifyComments(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	WebElement Fristob;        
	        
	@FindBy(xpath="(//a[@href='https://www.brighthorizons.com/child-care-locator'])[2]")
	WebElement findACenter;
			
	@FindBy(xpath="//input[@name=\"addressInput\"]")
	WebElement enterCenter;	
			
	@FindBy(xpath="//span[@class='resultsNumber']")
	WebElement totalCenter;			
			
	@FindBy(xpath="(//h3[@class='centerResult__name'])[1]")
	WebElement firstSearchCenter;		
	
	
	@FindBy(xpath="(//h3[@class='centerResult__name']/following-sibling::span[@class='centerResult__address'])[1]")
	WebElement centerAddress;
	
	@FindBy(xpath="//span[@class='mapTooltip__headline']")
	WebElement sideSearchCenter;
	
	@FindBy(xpath="//div[@class='mapTooltip__address']")
	WebElement sideSearchAddress;
	
	@FindBy(xpath="//h3[@class='centerResult__name']")
	List<WebElement> allCenters;
	
	//Second Test
	
	public void Allaccept()
	{
		Fristob.click();
	}
	
	public void ClickFindCenter()
	{
		findACenter.click();
		
	}
	
	
	public void VerifyWebURL()
	{
		  String currentURL= driver.getCurrentUrl();
		  System.out.println("Current URL: " + currentURL);
		  
		  String expectedSubstring = "child-care-locator";
		  Assert.assertTrue(currentURL.contains(expectedSubstring), "URL does not contain expected text!");
          System.out.println("Test Passed: URL contains expected text.");
           			
	}
	
	
	public void VerifyTitle()
	{
		String currentTitle= driver.getTitle();
		System.out.println("Current Title: " + currentTitle);    
          			
	}
	//Type New York
	//into search box and press Enter
	public void EnterCenter()
	{
		enterCenter.sendKeys("New York");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		enterCenter.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		enterCenter.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).pause(2000).build().perform(); 
		actions.sendKeys(Keys.ENTER).perform();
		//actions.moveToElement(enterCenter).sendKeys("New York").click().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		}
	
	public void ValidateCenter()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));      
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(totalCenter));
        element.click();

       
		String DisplayCenters = totalCenter.getText();
		System.out.println(DisplayCenters);
		System.out.println(1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		int Actualcenters = allCenters.size();
		System.out.println(Actualcenters);
		System.out.println(2);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String converted = String.valueOf(Actualcenters);
		
		if(DisplayCenters.equals(converted))
		{
			System.out.println("Centers are Matching");
		} else
		{
			System.out.println("Centers are not matching");
		}
		
	}
	

	public void ClickFirstSearchCenter()
	{
		firstSearchCenter.click();
	}
	
	public void MatchHeaderText()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    String OriginalText = firstSearchCenter.getText();
		System.out.println(OriginalText);
	
		sideSearchCenter.click();
		String SideCenterText = sideSearchCenter.getText();
		System.out.println(SideCenterText);
		
		Assert.assertEquals(OriginalText, SideCenterText, "They are SAME!! " );		
	}
	
	public void MatchAddress()
	{ 	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String OriginalAddress = centerAddress.getText();
		System.out.println(OriginalAddress);
		
		String SideAddress= sideSearchAddress.getText();
		System.out.println(SideAddress);
		
		OriginalAddress = OriginalAddress.replaceAll("\\s+", " ").trim();
		SideAddress = SideAddress.replaceAll("\\s+", " ").trim();
		
		Assert.assertEquals(OriginalAddress, SideAddress, "Address match!");
	}
}
