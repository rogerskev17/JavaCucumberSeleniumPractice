package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationPracticeStepDefinitions {
	
	WebDriver driver;
	
	String expectedTitle;
	String actualTitle;
	
	@Given("^I navigate to http://the-internet.herokuapp.com/$")
	public void navigateToTheInternet() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\Programming\\Tools\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com");
		
		System.out.println("Successful Navigation Test Result:");	
		expectedTitle = "The Internet";
		actualTitle = driver.getTitle();
		
		if (actualTitle == expectedTitle) {
			System.out.println("Pass");
		}
		
		else {
			System.out.println("Fail");
		}
		
	}
	
	@When("I click on {string}")
	public void navigateToABTesting(String link) throws InterruptedException {
		
		WebElement element = driver.findElement(By.linkText(link));
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		element.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		element.sendKeys(Keys.ENTER);
		
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
	}
	
	@And("^I navigate to \"([^\"]*)\"")
	public void navigateToDropdown(String link) throws InterruptedException {
		
		driver.findElement(By.linkText(link)).click();
		Thread.sleep(2000);
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByIndex(1);	
		Thread.sleep(2000);
		dropdown.selectByIndex(2);	
		Thread.sleep(2000);
		dropdown.selectByVisibleText("Option 1");
		Thread.sleep(2000);
		dropdown.selectByVisibleText("Option 2");
		Thread.sleep(2000);
		dropdown.selectByValue("1");
		Thread.sleep(2000);
		dropdown.selectByValue("2");
		Thread.sleep(2000);
		
		driver.navigate().back();		
	}
	
	@And("I go to the Context Menu Page")
	public void navigateToContextMenu() throws InterruptedException {
		
		driver.findElement(By.linkText("Context Menu")).click();
		
		WebElement element = driver.findElement(By.id("hot-spot"));
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

		element.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		element.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		element.sendKeys(Keys.ENTER);
				
	}

}
