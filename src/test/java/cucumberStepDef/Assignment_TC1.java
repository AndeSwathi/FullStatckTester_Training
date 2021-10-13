package cucumberStepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assignment_TC1 {

	WebDriver driver;
	String strExpMsg;

	@Given("^User is on the E - learning site$")
	public void user_is_on_the_E_learning_site() throws Throwable {

		System.out.println("--------------App Launch--------------");

		System.setProperty("webdriver.chrome.driver",
				"D:\\AndeSwathi\\EclipseWorkplace\\CucumberTraining\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// Launch URL
		driver.get("http://elearningm1.upskills.in/");
		// Maximize window
		driver.manage().window().maximize();
		// wait for page load
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// validate home page
		driver.findElement(By.xpath("//a[@title=\"Homepage\"]")).isDisplayed();

	}

	@When("^User selects what he want to do\\?$")
	public void user_selects_what_he_want_to_do() throws Throwable {

		System.out.println("--------------Entering Registration Details--------------");

		// Click on sign up link
		driver.findElement(By.xpath("//a[text()=\" Sign up! \"]")).click();
		// Select radio option for what user wants to do
		driver.findElement(By.xpath("//p[text()=\"Follow courses\"]")).click();

	}

	@When("^User enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enter(String fName, String lName, String eMail, String userName, String pass) throws Throwable {

		strExpMsg = fName + " " + lName;

		// Verify sign up page
		driver.findElement(By.xpath("//h2[text()=\"Registration\"]")).isDisplayed();
		// Enter First name
		driver.findElement(By.id("registration_firstname")).sendKeys(fName);
		// Validate entered text is displayed
		Assert.assertEquals(driver.findElement(By.id("registration_firstname")).getAttribute("value"), fName);
		// Enter last name
		driver.findElement(By.id("registration_lastname")).sendKeys(lName);
		// Enter Email
		driver.findElement(By.id("registration_email")).sendKeys(eMail);
		// Enter user name
		driver.findElement(By.id("username")).sendKeys(userName);
		// Enter password
		driver.findElement(By.id("pass1")).sendKeys(pass);
		// Enter confirm password
		driver.findElement(By.id("pass2")).sendKeys(pass);

	}

	@When("^User enter \"([^\"]*)\" select \"([^\"]*)\" and click on register button$")
	public void user_enter_select_and_click_on_register_button(String phnNum, String lang) throws Throwable {

		// Enter phone number
		driver.findElement(By.id("registration_phone")).sendKeys(phnNum);
		// select language
		WebElement selLang = driver.findElement(By.id("registration_language"));
		Select se = new Select(selLang);
		se.selectByVisibleText("English");
		// Click on Register
		driver.findElement(By.id("registration_submit")).click();

	}

	@Then("^verify success message$")
	public void verify_success_message() throws Throwable {

		System.out.println("--------------Registration successfull--------------");

		String strSuccessMsg = driver.findElement(By.xpath("//div[@class=\"col-xs-12 col-md-12\"]")).getText();

		Assert.assertTrue(strSuccessMsg.contains(strExpMsg));

		driver.quit();

		System.out.println("--------------Close App--------------");

	}

	@When("^User enters \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enters(String userName, String pass) throws Throwable {

		System.out.println("--------------User Login--------------");

		// Enter Username
		driver.findElement(By.id("login")).sendKeys(userName);

		// Enter Password
		driver.findElement(By.id("password")).sendKeys(pass);

	}

	@When("^User click on login button$")
	public void user_click_on_login_button() throws Throwable {

		// Click on login button
		driver.findElement(By.id("form-login_submitAuth")).click();

	}

	@Then("^verify user home page with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_user_home_page_with_and(String fName, String lName) throws Throwable {
		
		strExpMsg = fName + " " + lName;

		// Verify welcome msg with user name
		String strWelcomemsg = driver.findElement(By.id("homepage-course")).getText();
		Assert.assertTrue(strWelcomemsg.contains(strExpMsg));
		// Close browser
		driver.quit();

		System.out.println("--------------Close App--------------");

	}

	@When("^User edit profile with \"([^\"]*)\" and new \"([^\"]*)\"$")
	public void user_edit_profile_with_and_new(String oldPass, String newPass) throws Throwable {

		// Click on edit profile link
		driver.findElement(By.xpath("//a[text()=\"Edit profile\"]")).click();
		// Enter password
		driver.findElement(By.id("profile_password0")).sendKeys(oldPass);
		// Enter new password
		driver.findElement(By.id("password1")).sendKeys(newPass);
		// Confirm password
		driver.findElement(By.id("profile_password2")).sendKeys(newPass);
		// Click on save
		driver.findElement(By.id("profile_apply_change")).click();

	}

	@Then("^Verify save message$")
	public void verify_save_message() throws Throwable {

		// Verify success message
		driver.findElement(By.xpath("//div[text()=\"Your new profile has been saved\"]")).isDisplayed();

		// close browser
		driver.quit();

	}

}
