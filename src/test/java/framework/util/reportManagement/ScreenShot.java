package framework.util.reportManagement;

import framework.util.common.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class ScreenShot {
    private static WebDriver driver;
    public static String TakeScreenshot(WebDriver... newDriver) {

        if(newDriver.length>0){
            driver =  newDriver[0]; // its quite possible that screen shot of other driver instance is required
        }else{
            driver = DriverFactory.getDriver();
        }

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String format = "png";
        String dirPath = "reports/capture/";
        String snapPath = "./" + dirPath;

        String fileName = null;
        try {
            fileName = timeStamp + "." + format;
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(snapPath + fileName));
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return "./capture/" + fileName;
    }
}
