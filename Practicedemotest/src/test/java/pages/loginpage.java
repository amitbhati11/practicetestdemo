package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	@FindBy(xpath="(//a[text()='FREE SIGN UP'])[1]")
	WebElement fresignup;
	
	@FindBy(xpath="//input[@placeholder='Enter your full name']")
	WebElement fulname;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	WebElement pasword;
	
	@FindBy(xpath="//button[@id='login']")
	WebElement lognbtn;
	
	@FindBy(xpath="//div[text()='Password is invalid']")
	WebElement incrrctpws;
	public loginpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void frsignup() {
		fresignup.isDisplayed();
	}
	
	public void us_name(String username) {
		fulname.sendKeys(username);
	}
	public void us_pass(String password) {
		pasword.sendKeys(password);
	}
	public void loginbtn() {
		lognbtn.click();
	}
	
	public void invalidpwd() throws IOException {
		String path="C:\\Users\\Admin_SRV\\eclipse-workspace\\Practicedemotest\\Screenshots\\image.png";
		File src=incrrctpws.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(path));
	}
	
	
	

}
