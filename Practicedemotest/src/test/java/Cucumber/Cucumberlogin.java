package Cucumber;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.Homepage;
import pages.loginpage;

public class Cucumberlogin {
 
	WebDriver driver;
	loginpage lp;
	Homepage hp;
	
	@Before
	public void setup() {
		
		
	String crpath="C:\\Users\\Admin_SRV\\git\\practicetestdemo\\Practicedemotest\\src\\test\\resources\\drivers\\chromedriver.exe";
	   System.setProperty("webdriver.chrome.driver",crpath);
	   driver=new ChromeDriver();
	
	}
	@After
	public void teardown() {
		driver.close();
		System.out.println("Successed");
	}
	
	@Given("Enter the URl")
	public void enter_the_u_rl() {
		driver.get("https://example.testproject.io/web/");
	}

	@And("^login with valid (.*) and (.*)$")
	public void login_with_valid_username_and_password(String username,String password) throws InterruptedException {
	       lp=new loginpage(driver);
	       lp.us_name(username);
	       lp.us_pass(password);
	       
	}
	
	@And("^login with invalid (.*) and (.*)$")
	public void login_with_invalid_username_and_password(String username,String password) throws InterruptedException {
		lp=new loginpage(driver);
	       lp.us_name(username);
	       lp.us_pass(password);
	}

	@When("click on login btn")
	public void click_on_login_btn() throws InterruptedException, IOException {
		lp=new loginpage(driver);
		lp.loginbtn();
		
	}

	@Then("navigate to home page")
	public void navigate_to_home_page() throws InterruptedException {
	          hp=new Homepage(driver);
	          hp.desh();
	          hp.address();
	          hp.mailadd();
	          hp.telephone();
	          hp.savebtn();
	}
}
