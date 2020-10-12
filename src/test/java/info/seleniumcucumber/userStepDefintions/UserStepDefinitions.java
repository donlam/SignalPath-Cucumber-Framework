package info.seleniumcucumber.userStepDefintions;

import cucumber.api.java.en.Given;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserStepDefinitions implements BaseTest {

	protected WebDriver driver = DriverUtil.getDefaultDriver();

	@Given("^I press the enter button$")
	public void press_enter() throws Throwable {
		By selection = By.className("new-todo");
		(new WebDriverWait(driver, 30)).until(
				ExpectedConditions.visibilityOfElementLocated(selection));
		WebElement textbox = driver.findElement(By.className("new-todo"));
		textbox.sendKeys(Keys.ENTER);
	}


	@Given("^I should have completed my list")
	public void verify_complete_list(){
		By selection = By.className("clear-completed");
		(new WebDriverWait(driver, 30)).until(
				ExpectedConditions.visibilityOfElementLocated(selection));
		String to_do_count = driver.findElement(By.className("todo-count")).getText();
		Assert.assertEquals("0 items left",to_do_count);
	}

	//Step to navigate to specified URL
	@Given("^I should have \"([^\"]*)\" items left$")
	public void verify_complete(String count)
	{
		By selection = By.className("clear-completed");
		(new WebDriverWait(driver, 30)).until(
				ExpectedConditions.visibilityOfElementLocated(selection));
		String to_do_count = driver.findElement(By.className("todo-count")).getText();
		to_do_count = to_do_count.substring(0,to_do_count.indexOf("items")).trim();
		Assert.assertEquals(count,to_do_count);
	}

	@Given("^I can delete my last to do item")
	public void delete_to_do_and_entire_list(){
		By selection = By.className("destroy");
		(new WebDriverWait(driver, 30)).until(
				ExpectedConditions.visibilityOfElementLocated(selection));
		WebElement delete_box = driver.findElement(By.className("destroy"));
		delete_box.click();
	}

}
