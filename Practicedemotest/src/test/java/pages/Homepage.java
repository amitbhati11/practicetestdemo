package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage {

	WebDriver driver;
	
	@FindBy(xpath="(//h1[text()='TestProject Example page'])[2]")
	WebElement testprj;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(xpath="//input[@placeholder='Enter your address']")
	WebElement add;
	
	@FindBy(xpath="//input[@placeholder='Enter your email']")
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Enter your phone number']")
	WebElement phone;
	
	@FindBy(xpath="//button[@id='save']")
	WebElement save;
	
	@FindBy(xpath="//span[text()='Saved']")
	WebElement saved;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void text() {
		testprj.isDisplayed();
	}
	
	public void desh() {
		country.click();
		Select st=new Select(country);
		st.selectByVisibleText("India");
		
	}
	public void address() {
		add.sendKeys("delhi");
	}
	public void mailadd() {
		email.sendKeys("abc@gmail.com");
	}
	public void telephone() {
		phone.sendKeys("98xxxxxxxx");
	}
	
	public void savebtn() {
		save.click();
	}
	
	public void completed() {
		saved.isDisplayed();
	}
	
	
}
