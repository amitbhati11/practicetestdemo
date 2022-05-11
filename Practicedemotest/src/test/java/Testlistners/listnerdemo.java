package Testlistners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listnerdemo implements ITestListener {
	



public void onFinish(ITestContext context) {					
    System.out.println("****test1"+context.getName());	        		
	    }		

			
	    public void onStart(ITestContext context) {					

	    	System.out.println("#####test6"+context.getName());
	    }		

	 	
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
            System.out.println("####test7"+result.getName());	        		
	    }		

	 		
	    public void onTestFailure(ITestResult result) {					
             System.out.println("******test2"+result.getName());	        		
	    }		

			
	    public void onTestSkipped(ITestResult result) {					
         System.out.println("******test3"+result.getName());	        		
	    }		

	  		
	    public void onTestStart(ITestResult result) {					
              
	    	System.out.println("****test4"+result.getName());
	    }		

	  			
	    public void onTestSuccess(ITestResult result) {					
          System.out.println("*****test5"+result.getName());	        		
	    }		

}
