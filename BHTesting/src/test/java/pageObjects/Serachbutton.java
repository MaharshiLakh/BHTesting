package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Serachbutton extends BasePage{
	
	public Serachbutton(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	WebElement Cookies;
	
	@FindBy(xpath="//a[@href='#subnav-search-desktop-top']")
	WebElement Search;
	
	@FindBy(xpath="(//input[@placeholder='Type to Search'])[2]")
	WebElement typetextbox;
	
	@FindBy(xpath="(//button[text()='Search'])[2]")
	WebElement clickSerach;
	
	
	@FindBy(xpath="(//h3[@class='title'])[1]")
	WebElement firstSerachText;
			
	
	public void clickCookie()
	{
		Cookies.click();
	}
				
	//Click on search/loop icon (top, right corner)

	public void clickSerachbutton()
	{
		Search.click();
	}
	
	//4Verify if search field is visible on the page

	public void verifySearchVisibility()
	{
		if(typetextbox.isDisplayed())
		{
			System.out.println("Serach field is visible on page :Checkpoint 2");
			
		}else {
			System.out.println("Serach field is not !!visible on page::Checkpoint 2");
		}
	}		


	//"Type:
	//Employee Education in 2018: Strategies to Watch
	//into the search field and click on Search button"

	public void setSerachText(String text) 
	{
		typetextbox.sendKeys(text);		
	}
	
	public void clickSerachButton()
	{
		clickSerach.click();
	}
	
	
	//Verify if the first search result is exact match to what you typed into search 
	
	public void verifyTextFirstSerach()
	{
		
		String Giventext = "Employee Education in 2018: Strategies to Watch";
		//typetextbox.sendKeys(Giventext);
		
		String firstResultText = firstSerachText.getText();
		System.out.println("Comparing last.....");
		if(firstResultText.equals(Giventext))
		{
			System.out.println("Passed: First text on page matches the given text");
		}else {
			System.out.println("Failed: First text on page does not matches the given text");
		}
	}
	
			
			
		
			
			
}
