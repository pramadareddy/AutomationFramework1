package practice;

import org.testng.Assert;

import org.testng.annotations.Test;

public class RetryAnalyserPractice {
@Test(retryAnalyzer= genericUtility.RetryAnalyserImplementation.class)
public void test() {
	System.out.println("Step 1");
	Assert.fail();
	System.out.println("Step 2");
	
	
}
}
