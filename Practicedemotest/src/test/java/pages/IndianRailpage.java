package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IndianRailpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Train Number']")
	WebElement train;
	
	@FindBy(xpath="//img[@title='Select date']")
	WebElement calender;
	
	@FindBy(xpath="//input[@id='sourceStation']")
	WebElement dept;
	
	@FindBy(xpath="//input[@id='destinationStation']")
	WebElement arriv;
	
	@FindBy(xpath="//select[@id='class']")
	WebElement entrclass;
	
	@FindBy(xpath="//select[@id='quota']")
	WebElement quote;
	
	@FindBy(xpath="//input[@id='modal1']")
	WebElement submit;
	
	@FindBy(id="inputCaptcha")
	WebElement captha;
	
	//constructor
	
	public IndianRailpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void Trainno() throws InterruptedException {
		train.sendKeys("123");
		Thread.sleep(2000);
		train.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		train.sendKeys(Keys.ENTER);
		
	}
	public void datecalender() {
		calender.click();
	}
	public void departure() throws InterruptedException {
		dept.sendKeys("Howrah");
		Thread.sleep(2000);
		dept.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		dept.sendKeys(Keys.ENTER);
		
	}
	public void arrival() throws InterruptedException {
		arriv.sendKeys("Delhi");
		Thread.sleep(2000);
		arriv.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		arriv.sendKeys(Keys.ENTER);
	}
	public void mdouleclass() {
		Select st=new Select(entrclass);
		st.selectByVisibleText(" FIRST CLASS");
	}
	
	public void quotatype() {
		Select sb=new Select(quote);
		sb.selectByValue("PT");
	}
	
	public void Submitbtn() {
		submit.click();
	}
	
	
}
