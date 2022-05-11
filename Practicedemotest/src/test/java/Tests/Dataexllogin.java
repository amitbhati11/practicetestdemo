package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Exceldemop.Excelutildemo;
import pages.Homepage;
import pages.loginpage;

public class Dataexllogin {
	
	WebDriver driver;
	loginpage lp;
	Homepage hp;
	@Parameters("browser")
	@BeforeTest
	
	public void setup(String browser) {
		System.out.println("the browser is:"+browser);
		if(browser.contains("chrome")) {
		String dpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\Practicedemotest\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", dpath);
		driver=new ChromeDriver();
	}else if(browser.contains("firefox")) {
		String gpath="C:\\Users\\Admin_SRV\\git\\practicetestdemo\\Practicedemotest\\src\\test\\resources\\drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", gpath);
		driver=new FirefoxDriver();
		
	}
	}
	
	@DataProvider(name="testdata")
	
	public Object [][] providdate() throws Exception {
		String xlpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\Practicedemotest\\src\\test\\resources\\data\\loginDataprovider.xlsx";
		String Sheetname="Sheet1";
		Object data [][]=getcelldata(xlpath, Sheetname);
		return data;
	}
	
	@Test(dataProvider="testdata")
	
	public void finaldata(String username,String password, String id) throws InterruptedException, IOException {
		System.out.println(username+" | "+password+" | "+id);
		driver.get("https://example.testproject.io/web/");
		lp=new loginpage(driver);
		lp.frsignup();
		lp.us_name(username);
		lp.us_pass(password);
        lp.loginbtn();
        Thread.sleep(5000);
      String et= driver.findElement(By.xpath("//div[text()='Password is invalid']")).getText();
      System.out.println(et);
        
   
       if(et.equals("Password is invalid"))
       {
        lp.invalidpwd();
        Thread.sleep(4000);
    	   
	}else {
		hp=new Homepage(driver);
	       hp.text();
	       
		 hp.desh();
	        hp.address();
	        hp.mailadd();
	        hp.telephone();
	        hp.savebtn();
	        Thread.sleep(2000);
	        hp.completed();
		
		
	}
	}
	@AfterTest
	
	public void teardown() {
		
		System.out.println("sucess");
		driver.close();
	}
	
	
	public Object [][] getcelldata(String xlpath,String Sheetname) throws Exception {
		Excelutildemo  eud=new Excelutildemo(xlpath, Sheetname);
		
	int Rownum=	eud.countrownum();
	int Colnum=	eud.countcolnum();
	
	         Object data [][]=new Object [Rownum-1][Colnum];
	         
	         for(int i=1;i<Rownum;i++) {
	        	 for(int j=0;j<Colnum;j++) {
	        		 
	        		 data[i-1][j]=eud.datacell(i, j);
	        	 }
	         }return data;
		
		
		
	}

}
