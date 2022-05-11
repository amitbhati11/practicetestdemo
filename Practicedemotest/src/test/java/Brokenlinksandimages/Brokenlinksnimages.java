package Brokenlinksandimages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Brokenlinksnimages {
	WebDriver driver;
	@BeforeTest
	
	public void setup() {
		String cpath="C:\\Users\\Admin_SRV\\git\\practicetestdemo\\Practicedemotest\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", cpath);
		driver=new ChromeDriver();
		
	}
	@Test
	public void testexecution() throws MalformedURLException, IOException {
		driver.get("https://webswastech.wordpress.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	List <WebElement> list=	driver.findElements(By.tagName("a"));
	
	  list.addAll(driver.findElements(By.tagName("img")));
	  System.out.println("size of all link--->"+list.size());
	List<WebElement> activelink=new ArrayList<WebElement>();
	  for(int i=0;i<list.size();i++) {
		  System.out.println(list.get(i).getAttribute("href"));
		if(list.get(i).getAttribute("href")!=null && (!list.get(i).getAttribute("href").contains("javascript")&& (!list.get(i).getAttribute("href").contains("no protocol")))) {
			activelink.add(list.get(i));
		}
		 
	} System.out.println("size of active link and imges--->"+activelink.size());
	for(int j=0;j<activelink.size();j++) {
		
	
HttpURLConnection connection=(HttpURLConnection)new URL(activelink.get(j).getAttribute("href")).openConnection();
connection.connect();
 String response= connection.getResponseMessage();
  connection.disconnect();
      System.out.println(activelink.get(j).getAttribute("href")+"--->"+response);

	}
	}
}
