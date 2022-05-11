package Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import pages.IndianRailpage;

public class Railtest {
	
	WebDriver driver;
	IndianRailpage irp;
	
	@BeforeTest
	
	public void setup() {
		
		String cpath="C:\\Users\\Admin_SRV\\git\\practicetestdemo\\Practicedemotest\\src\\test\\resources\\drivers\\chromedriver.exe";
	      System.setProperty("webdriver.chrome.driver",cpath);
	      driver=new ChromeDriver();
	      
	}
	
	@Test
	
	public void testexecution() throws InterruptedException, IOException, TesseractException {
		driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
		 irp=new IndianRailpage(driver);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,250)");
		 
		 irp.Trainno();
		 irp.datecalender();
		 
		 String Expdate="3-July-2022";
		 String Eday=Expdate.split("-")[0];
		 String Emonth=Expdate.split("-")[1];
		 String Eyear=Expdate.split("-")[2];
		 
		 System.out.println(Eday+"##"+Emonth+"@@"+Eyear);
		 
		 
		 String Cmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().trim();
		 String Cyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().trim();
		 
		 System.out.println(Cmonth+"$$"+Cyear);
		 
		 while((!Cmonth.equals(Emonth)||(!Cyear.equals(Eyear)))) {
			 WebElement eu=driver.findElement(By.xpath("//span[text()='Next']"));
			 eu.click();
			 Cmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().trim();
			  Cyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().trim();
			
			  List <WebElement> list=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
			  list.size();
			 
			//	wait.until(ExpectedConditions.invisibilityOfAllElements(list));
			  for(int i=0;i<list.size();i++) {
				String Cday=list.get(i).getText();
				//System.out.println(Cday+"##");
				if(Cday.equals(Eday)) {
					
					 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
						wait.until(ExpectedConditions.visibilityOfAllElements(list));
					list.get(i).click();
					break;
				}
				
			  }
		 
		}
		 irp.departure();
		 irp.arrival();
		 irp.mdouleclass();
		 irp.quotatype();
		 irp.Submitbtn();
		 
		 Thread.sleep(3000);
		
		 String path="C:\\Users\\Admin_SRV\\git\\practicetestdemo\\Practicedemotest\\Screenshots\\Img1.png";
	
		 
		
	File src= driver.findElement(By.xpath("//img[@id='CaptchaImgID']")).getScreenshotAs(OutputType.FILE);
	try {
	FileHandler.copy(src, new File(path));
	}catch(Exception e){
		System.out.println(e.getMessage());
		
	}
	ITesseract imges=new Tesseract();
		String imgtxt= imges.doOCR(new File(path));
	
		System.out.println(imgtxt);
	
	String R=imgtxt.split("[0-9]+//+-[0-9]*")[0];
	System.out.println(R+"regex");
			
	String S1=imgtxt.substring(0,3);
	String S2=imgtxt.substring(5,8);
	System.out.println(S1);
	System.out.println(S2);
	
	Integer I1=Integer.valueOf(S1);
	Integer I2=Integer.valueOf(S2);
	
	if(R.contains("+")) {
		Integer I=I1+I2;
		//System.out.println(I);
		String S=String.valueOf(I);
		
	driver.findElement(By.id("inputCaptcha")).sendKeys(S);
	
		//System.out.println(S);
	}else if(R.contains("-")) {
		Integer I=I1-I2;
		String S=String.valueOf(I);
		
		driver.findElement(By.id("inputCaptcha")).sendKeys(S);
		
		
	}
	Thread.sleep(3000);
	driver.findElement(By.id("test")).click();
	}
}
