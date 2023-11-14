package Test;


import org.testng.annotations.Test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;



public class ListenerTest implements ITestListener {

	@Override
		public void onFinish(ITestContext Result) {
		System.out.println();
		System.out.print("on Finish : " + Result.getName() + "\t");

	//	report.endTest(test);

	}

	@Override
	@Parameters("browser")
	public void onStart(ITestContext Result ) {
		System.out.println();
		System.out.print("on Start : " + Result.getName() + "\t");
	

		System.out.println();

	} 

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		try
		{
		System.out.println();
		System.out.print("The Name of The Test Case Within Percentage of Success is : " + Result.getName() + "\t");
		System.out.println();
		}
		catch (Exception e) {
			 System.out.println(e.getMessage());	}
	}

	@Override
	public void onTestFailure(ITestResult Result) {
		try 
		{
		System.out.println();  		
		System.out.print("The Name of The Test Case Failed is : " + Result.getName() + "\t");
		Thread.currentThread();
		
		System.out.println();
		}
		catch (Exception e) { 
			 System.out.println(e.getMessage());		}
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println();
		System.out.print("The Name of The Test Case Skipped is : " + Result.getName() + "\t");
		System.out.println();

	}

	@Override
	public void onTestStart(ITestResult Result) {
		System.out.println();
		System.out.print(Result.getName() + " Test Case Started" + "\t");
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		System.out.println();
		System.out.print("The Name of The Test Case Passed is : " + Result.getName() + "\t");
		System.out.println();
	}
}
 

