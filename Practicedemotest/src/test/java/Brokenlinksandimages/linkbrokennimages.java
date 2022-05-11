package Brokenlinksandimages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class linkbrokennimages {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		String path="C:\\Users\\Admin_SRV\\git\\practicetestdemo\\Practicedemotest\\src\\test\\resources\\drivers\\chromedriver.exe";
	   System.setProperty("webdriver.chrome.driver",path);
	      driver=new ChromeDriver();
	}
	@Test
	public void testExecution() throws MalformedURLException, IOException {
		driver.get("https://makemysushi.com/404");
		
		List <WebElement> alllist=driver.findElements(By.tagName("a"));
		alllist.addAll(driver.findElements(By.tagName("img")));
		alllist.size();
		
		System.out.println("total links are ----->"+alllist.size());
		List <WebElement> activelink= new ArrayList<WebElement>();
		
		for(int i=0; i<alllist.size();i++) {
			alllist.get(i).getAttribute("href");
			System.out.println(alllist.get(i).getAttribute("href"));
	      if(alllist.get(i).getAttribute("href")!=null &&(!alllist.get(i).getAttribute("href").contains("javascript"))) {
	    	  activelink.add(alllist.get(i)); 
	      } 
		}System.out.println("activelink are --->"+activelink.size());
		
		for(int j=0;j<activelink.size();j++) {
			
			
		HttpURLConnection connect=(HttpURLConnection)new URL(activelink.get(j).getAttribute("href")).openConnection();
		connect.connect();
		String response=connect.getResponseMessage();
		connect.disconnect();
		System.out.println(activelink.get(j).getAttribute("href")+"response are -->"+response);
		}
		            
	}

}
