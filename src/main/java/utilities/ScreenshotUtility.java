package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static String captureScreenshot(
	        WebDriver driver,
	        String screenshotName) {

	    TakesScreenshot ts =
	            (TakesScreenshot) driver;

	    File source =
	            ts.getScreenshotAs(OutputType.FILE);

	    String path =
	            "Screenshots/"
	            + screenshotName
	            + ".png";

	    File destination =
	            new File(path);

	    try {

	        FileUtils.copyFile(
	                source,
	                destination);

	    } catch (IOException e) {

	        e.printStackTrace();
	    }

	    return path;
	}
}