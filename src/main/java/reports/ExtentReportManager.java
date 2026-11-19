package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports getReportInstance() {

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        sparkReporter.config().setReportName("Selenium Automation Report");

        sparkReporter.config().setDocumentTitle("Automation Test Results");

        ExtentReports extent = new ExtentReports();

        extent.attachReporter(sparkReporter);

        return extent;
    }
}
