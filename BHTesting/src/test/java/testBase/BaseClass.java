package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
public WebDriver driver;
	
	@BeforeClass
	public void setup() throws Throwable
	{
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//1"Navigate to BH home page: https://www.brighthorizons.com/"
		driver.get("https://www.brighthorizons.com/");
		System.out.println("Launched Chrome and open the link Checkpoint 1");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
	 driver.quit();
	}
	
	
}
