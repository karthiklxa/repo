package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import framework.util.common.*;
import framework.util.propertyManagement.PayPlusProperties;
import framework.util.reportManagement.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class TestInit {
    private static ExtentReports extent; // test Node
    protected ExtentTest pNode; // parent Node
    private static ThreadLocal parentTest = new ThreadLocal();
    private static String fileName = null;
    protected static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(TestInit.class);

    /**
     * Before Suite - Load Environment Variables and Base Set
     * @param ctx
     * @throws Exception
     */
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext ctx) throws Exception {
        /**
         * if the suite is executed from XML then create extent file with Suite Name mentioned in the xml,
         * else
         * use the Class name.
         */
        String suiteName = (ctx.getSuite().getName().
                equalsIgnoreCase("Default Suite")) ? getClass().getSimpleName() : ctx.getSuite().getName();

        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm").format(new Date());
        fileName = "reports/" + suiteName + "_" + timeStamp + ".html";

        extent = ExtentManager.getInstance(fileName);
        pNode = extent.createTest("Init");

        // Init Config Input
        ConfigInput.init();
        DataFactory.loadCards();
        DataFactory.loadWallet();
        DataFactory.loadCardForInvalidCardNumber();
        DataFactory.getCvv();
        NegativedData.init();


        extent.setSystemInfo("URL", ConfigInput.URL);
//        extent.setSystemInfo("URL", ConfigInput.merchantURL);
        extent.setSystemInfo("Browser", PayPlusProperties.getInstance().getProperty("browser.name"));

        extent.flush();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClassRun() throws Exception {


        pNode = extent.createTest(getClass().getSimpleName());
        parentTest.set(pNode);

        Markup m = MarkupHelper.createLabel("Setup For Test: " + getClass().getSimpleName(), ExtentColor.BLUE);
        pNode.info(m); // Method Start Marker

        logger.info("Started Test Suite: " + getClass().getSimpleName());
        // get the driver
        driver = DriverFactory.getDriver();

//        ConfigInput.init();
//        driver.get(ConfigInput.URL);
//        driver.get(ConfigInput.merchantURL);


    }

    @BeforeMethod(alwaysRun = true)
    public void beforMethodRun(Method method) {
        logger.info("---\\");
        logger.info("STARTED TEST >---> " + method.getName());
        Assertion.resetSoftAsserts();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("TEST         >---> " + result.getName() + " - Executed Successfully");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logger.info("TEST         >---> " + result.getName() + " - Execution Failed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.info("TEST         >---> " + result.getName() + " - Execution Skipped");
            pNode.skip(result.getName() + ":Test Case Executed Skipped!");
        }
        logger.info("END TEST     >---> " + result.getName());
        logger.info("---/");
        extent.flush();
        ConfigInput.isAssert = true;
    }

    @AfterClass(alwaysRun = true)
    public void afterClassRun() throws InterruptedException {
        extent.flush();
        DriverFactory.quitDriver();
        Assertion.resetSoftAsserts();
    }

    @AfterSuite(alwaysRun = true)
    public static void afterSuiteRun() throws Exception {

        DriverFactory.quitDriver();
    }
    protected void markSetupAsFailure(Exception e) {
        e.printStackTrace();
        pNode.fail("Setup Failure due to Exception for: " + getClass().getSimpleName() +", refer console For additional details");
        pNode.error(e);
        Assert.fail("Setup Failure Due to Exception: " + e.toString());
    }

    protected void markTestAsFailure(Exception e, ExtentTest t1) {
        e.printStackTrace();
        t1.fail("Test Failure due to Exception");
        t1.error(e);
        Assert.fail("Test Failure Due to Exception: " + e.toString());
    }

    protected void startNegativeTest(ExtentTest t1){
        Markup m = MarkupHelper.createLabel("startNegativeTest:", ExtentColor.AMBER);
        t1.info(m);

//        ConfigInput.isAssert = false;
    }

}
