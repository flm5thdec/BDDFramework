package steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import exceptions.InvalidBrowserException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	
	WebDriver driver;
	
	
	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {
		
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			try {
				throw new InvalidBrowserException();
			} catch (InvalidBrowserException e) {
				System.out.println(e.getMessage());
			}

			break;
		}
	   
	}

	@Given("user launch app using url {string}")
	public void user_launch_app_using_url(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
	}

	@When("user enters text {string} in texbox using xpath {string}")
	public void user_enters_text_in_texbox_using_xpath(String text, String xpath) {
		
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	    
	}

	@When("user clicks button using xpath {string}")
	public void user_clicks_button_using_xpath(String xpath) {
	   
		driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user validates the profile picture using {string}")
	public void user_validates_the_profile_picture_using(String xpath) {
	    
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		
	}




@Then("user validates title to be {string}")
public void user_validates_title_to_be(String title) {
	
	Assert.assertTrue("Titles Matched" , driver.getTitle().equals(title));
}


}
