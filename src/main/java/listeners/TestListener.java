package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " STARTED");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " PASSED");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " FAILED");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " SKIPPED");
    }
}
