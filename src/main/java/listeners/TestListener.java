package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentReportManager;

public class TestListener implements ITestListener {
	ExtentReports extent =
	        ExtentReportManager.getReportInstance();

	ExtentTest test;
	
    public void onTestStart(ITestResult result) {
    	test = extent.createTest(result.getName());
        System.out.println(result.getName() + " STARTED");
    }

    public void onTestSuccess(ITestResult result) {
    	test.pass("Test Passed");
        System.out.println(result.getName() + " PASSED");
    }

    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        System.out.println(result.getName() + " FAILED");
    }

    public void onTestSkipped(ITestResult result) {
    	test.skip("Test Skipped");
        System.out.println(result.getName() + " SKIPPED");
    }
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("Extent Report Generated");
    }
}
