package framework.util.common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jayway.restassured.response.ValidatableResponse;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class Assertion {

    public static SoftAssert sAssert;

    public static void markAsFailure(String message) {
        getSoftAssert().fail(message);
    }

    public static SoftAssert getSoftAssert() {
        if (sAssert == null) {
            sAssert = new SoftAssert();
        }
        return sAssert;
    }

    public static void finalizeSoftAsserts() {
        getSoftAssert().assertAll();
    }

    public static void resetSoftAsserts() {
        if (sAssert == null) {
            return;
        } else {
            sAssert = null;
        }
    }

    /**
     * Get Action Message
     *
     * @return
     */
    public static String getActionMessage() throws NoSuchElementException {
        return DriverFactory.getDriver().findElement(By.className("actionMessage")).getText();
    }

    public static void verifyResponseSucceeded(ValidatableResponse response, ExtentTest t1) throws IOException {
        t1.info("Message: " + response.extract().jsonPath().getString("message"));
        t1.info("TransactionId: " + response.extract().jsonPath().getString("transactionId"));
        verifyEqual(response.extract().jsonPath().getString("status"), "SUCCEEDED", "Verify response Succeeded", t1);
    }

    public static void verifyResponseFailed(ValidatableResponse response, ExtentTest t1) throws IOException {
        t1.info("Message: " + response.extract().jsonPath().getString("message"));
        t1.info("TransactionId: " + response.extract().jsonPath().getString("transactionId"));
        verifyEqual(response.extract().jsonPath().getString("status"), "FAILED", "Verify response Failed", t1);
    }


    public static List<String> getAllActionMessages() {
        List<String> actionList = new ArrayList<>();
        try {
            List<WebElement> actions = DriverFactory.getDriver().findElements(By.id("transactionStatus"));
            for (int i = 0; i < actions.size(); i++) {
                actionList.add(actions.get(i).getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
            markAsFailure("Failed to get error Message");
        }

        return actionList;
    }

    public static void alertAssertionDynamic(String msgCode, String para, ExtentTest pNode) {
        try {
            pNode.info("Check Alert");
            String msg = DriverFactory.getDriver().switchTo().alert().getText();
            DriverFactory.getDriver().switchTo().alert().accept();
            pNode.info("Accept Alert : " + msg);
            String expectedMsg = MessageReader.getDynamicMessage(msgCode, para);
            String code = null;
            Markup m = null;
            if (msg.contains(expectedMsg)) {
                code = "Verified Successfully - " + ":\nExpected: " + expectedMsg + "\nActual  : " + msg;
                m = MarkupHelper.createCodeBlock(code);
                pNode.pass(m);
                pNode.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            } else {
                code = "Verified Not Successfully - " + ":\nExpected: " + expectedMsg + "\nActual  : " + msg;
                m = MarkupHelper.createCodeBlock(code);
                pNode.fail(m);
                pNode.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            }
        } catch (Exception e) {
            pNode.fail("Alert Not Found");
        }

    }

    public static void alertAssertion(String msgCode, ExtentTest pNode) {
        try {

            pNode.info("Check Alert");
            String msg = DriverFactory.getDriver().switchTo().alert().getText();
            DriverFactory.getDriver().switchTo().alert().accept();
            pNode.info("Accept Alert : " + msg);
            String expectedMsg = MessageReader.getMessage(msgCode, null);
            String code = null;
            Markup m = null;
            if (msg.contains(expectedMsg)) {
                code = "Verified Successfully - " + ":\nExpected: " + expectedMsg + "\nActual  : " + msg;
                m = MarkupHelper.createCodeBlock(code);
                pNode.pass(m);
                pNode.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            } else {
                code = "Verified Not Successfully - " + ":\nExpected: " + expectedMsg + "\nActual  : " + msg;
                m = MarkupHelper.createCodeBlock(code);
                pNode.fail(m);
                pNode.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            }
        } catch (Exception e) {
            pNode.fail("Alert Not Found");
        }

    }

    public static List<String> getAllErrorMessages() throws NoSuchElementException {
        List<String> errorList = new ArrayList<>();

        try {
            List<WebElement> actions = DriverFactory.getDriver().findElements(By.className("errorMessage"));
            for (int i = 0; i < actions.size(); i++) {
                errorList.add(actions.get(i).getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
            markAsFailure("Exception: while fetching all Error message");
        }

        return errorList;
    }

    public static String getErrorMessage() throws Exception {
        try {
            return DriverFactory.getDriver().findElement(By.className("errorMessage")).getText();
        } catch (Exception e) {
            e.printStackTrace();
            markAsFailure("Exception: while fetching Error message");
        }
        return null;
    }

    public static String expectErrorInPage() throws Exception {
        try {
            return DriverFactory.getDriver().findElement(By.className("errorMessage")).getText();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Verify Message Contains
     *
     * @param actual
     * @param expected
     * @param node
     * @throws IOException
     */
    public static void verifyMessageContain(String actual, String expected, String message, ExtentTest node) throws IOException {
        String expectedMsg = MessageReader.getMessage(expected, null);
        String code[][] = {{"Verify", message}, {"Actual", actual}, {"Expected", expectedMsg}};
        Markup m = MarkupHelper.createTable(code);
        if (actual.contains(expectedMsg)) {
            node.pass(m);
            node.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        } else {
            node.fail(m);
            node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            markAsFailure("Failure: Verify Message Contains! refer reports");
        }
    }

    /**
     * Assert Message Contains - exit execution on failure
     *
     * @param actual
     * @param expected
     * @param node
     * @throws IOException
     */
    public static void assertMessageContain(String actual, String expected, String message, ExtentTest node) throws IOException {
        String expectedMsg = MessageReader.getMessage(expected, null);
        String code[][] = {{"Verify", message}, {"Actual", actual}, {"Expected", expectedMsg}};
        Markup m = MarkupHelper.createTable(code);
        if (actual.contains(expectedMsg)) {
            node.pass(m);
            node.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        } else {
            node.fail(m);
            node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            Assert.fail();
        }
    }

    /**
     * Verify That a Specific Comparison is Not true
     *
     * @param actual
     * @param expected
     * @param message
     * @param node
     * @throws IOException
     */
    public static void verifyNotEqual(Object actual, Object expected, String message, ExtentTest node) throws IOException {
        String code[][] = {{"Verify", message}, {"Actual", actual.toString()}, {"Expected", expected.toString()}};
        Markup m = MarkupHelper.createTable(code);

        boolean isEqual = false;
        if (actual instanceof Integer && expected instanceof Integer) {
            isEqual = actual == expected;
        } else if (actual instanceof String && expected instanceof String) {
            isEqual = actual.equals(expected);
        }
        getSoftAssert().assertEquals(actual, expected);

        if (!isEqual) {
            node.pass(m);
        } else {
            node.fail(m);
        }
    }

    /**
     * Verify For Equal
     *
     * @param actual
     * @param expected
     * @param message
     * @param node
     * @throws IOException
     */
    public static boolean verifyEqual(Object actual, Object expected, String message, ExtentTest node, boolean... takeScreenShot) throws IOException {
        String code[][] = {{"Verify", message}, {"Actual", actual.toString()}, {"Expected", expected.toString()}};
        Markup m = MarkupHelper.createTable(code);

        boolean isEqual = false;
        boolean takeSnap = takeScreenShot.length > 0 ? takeScreenShot[0] : true;
        if (actual instanceof BigDecimal && expected instanceof BigDecimal) {
            isEqual = actual.equals(expected);
        } else if (actual instanceof Integer && expected instanceof Integer) {
            isEqual = actual == expected;
        } else if (actual instanceof String && expected instanceof String) {
            isEqual = actual.equals(expected);
        } else if (actual instanceof Boolean && expected instanceof Boolean) {
            isEqual = actual == expected;
        }
        getSoftAssert().assertEquals(actual, expected);

        if (isEqual) {
            node.pass(m);
            if (takeSnap)
                node.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            return true;
        } else {
            node.fail(m);
            if (takeSnap)
                node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            markAsFailure("Failed to verify fo equality!");
        }
        return false;
    }

    public static boolean assertEqual(Object actual, Object expected, String message, ExtentTest node, boolean... takeScreenShot) throws IOException {
        String code[][] = {{"Verify", message}, {"Actual", actual.toString()}, {"Expected", expected.toString()}};
        Markup m = MarkupHelper.createTable(code);
        boolean isEqual = false;

        boolean takeSnap = takeScreenShot.length > 0 ? takeScreenShot[0] : true;
        if (actual instanceof BigDecimal && expected instanceof BigDecimal) {
            isEqual = actual.equals(expected);
        } else if (actual instanceof Integer && expected instanceof Integer) {
            isEqual = actual == expected;
        } else if (actual instanceof String && expected instanceof String) {
            isEqual = actual.equals(expected);
        } else if (actual instanceof Boolean && expected instanceof Boolean) {
            isEqual = actual == expected;
        }

        getSoftAssert().assertEquals(actual, expected);

        if (isEqual) {
            node.pass(m);

            if (takeSnap)
                node.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            return true;
        } else {
            node.fail(m);

            if (takeSnap)
                node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            Assert.fail("Not Equal");// fail the test
        }
        return false;
    }

    public static boolean verifyContains(String actual, String expected, String message, ExtentTest node, boolean... takeScreenShot) throws IOException {
        String code[][] = {{"Verify", message}, {"Actual", actual.toString()}, {"Expected", expected.toString()}};
        Markup m = MarkupHelper.createTable(code);
        boolean isContain = false;

        boolean captureScreen = (takeScreenShot.length > 0) ? takeScreenShot[0] : true;
        if (actual.contains(expected)) {
            isContain = true;
        }

        if (isContain) {
            node.pass(m);
            if (captureScreen)
                node.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            return true;
        } else {
            node.fail(m);
            if (captureScreen)
                node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            markAsFailure("Failure: Refer reports for more details");
        }
        return false;
    }

    public static boolean verifyNotContains(String actual, String expected, String message, ExtentTest node, boolean... takeScreenShot) throws IOException {
        String code[][] = {{"Verify", message}, {"Actual", actual.toString()}, {"Expected", expected.toString()}};
        Markup m = MarkupHelper.createTable(code);
        boolean isContain = false;

        boolean captureScreen = (takeScreenShot.length > 0) ? takeScreenShot[0] : true;
        if (actual.contains(expected)) {
            isContain = true;
        }

        if (!isContain) {
            node.pass(m);
            if (captureScreen)
                node.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            return true;
        } else {
            node.fail(m);
            if (captureScreen)
                node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            markAsFailure("Failure: Refer reports for more details");
        }
        return false;
    }

    public static boolean verifyListContains(List actual, String expected, String message, ExtentTest node) throws IOException {
        String code[][] = {{"Verify List Contains: ", message}, {"Actual", actual.toString()}, {"Expected", expected.toString()}};
        Markup m = MarkupHelper.createTable(code);
        boolean isContain = false;

        if (actual.contains(expected)) {
            isContain = true;
        }

        if (isContain) {
            node.pass(m);
            return true;
        } else {
            node.fail(m);
            node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            markAsFailure("Failure: Refer reports for more details");
        }
        return false;
    }

    public static boolean verifyListNotContains(List actual, String expected, String message, ExtentTest node) throws IOException {
        String code[][] = {{"Verify List Not Contains: ", message}, {"Actual", actual.toString()}, {"Expected", expected.toString()}};
        Markup m = MarkupHelper.createTable(code);
        boolean isContain = false;

        if (actual.contains(expected)) {
            isContain = true;
        }

        if (isContain) {
            node.fail(m);
            node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            return false;
        } else {
            node.pass(m);
            return true;
        }
    }

    public static void verifyIsGreater(int first, int second, String message, ExtentTest node) throws IOException {
        String code[][] = {{"Verify", message}, {"First", String.valueOf(first)}, {"Second", String.valueOf(second)}};
        Markup m = MarkupHelper.createTable(code);

        if (first > second) {
            node.pass(m);
        } else {
            node.fail(m);
            node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            markAsFailure("Failure: Refer reports for more details");
        }
    }

    /**
     * Assert Not Equal
     *
     * @param actual
     * @param expected
     * @param message
     * @param node
     * @throws IOException
     */
    public static void assertNotEqual(Object actual, Object expected, String message, ExtentTest node) throws IOException {
        String code[][] = {{"Verify", message}, {"Actual", actual.toString()}, {"Expected", expected.toString()}};
        Markup m = MarkupHelper.createTable(code);
        boolean isEqual = false;
        if (actual instanceof Integer && expected instanceof Integer) {
            isEqual = actual == expected;
        } else if (actual instanceof String && expected instanceof String) {
            isEqual = actual.equals(expected);
        }
        if (!isEqual) {
            node.pass(m);
        } else {
            Assert.fail();
        }
    }

    /**
     * Verify Action Message
     *
     * @param expected
     * @param message
     * @param node
     * @param variation - for dynamic message
     * @return
     * @throws Exception
     * TODO - refine further when we come across various assertions
     */
    public static Boolean verifyActionMessageContain(String expected, String message, ExtentTest node, String... variation) throws Exception {
        try {

            String actual = "";
            boolean isFound = false;
            String expectedMsg = null;

            if (variation.length > 0) {
                expectedMsg = MessageReader.getDynamicMessage(expected, variation);
            } else {
                expectedMsg = MessageReader.getMessage(expected, null);
            }

            List<String> actionMessages = getAllActionMessages();
            for (int i = 0; i < actionMessages.size(); i++) {
                actual = actual + "," + actionMessages.get(i);
                if (actionMessages.get(i).contains(expectedMsg)) {
                    isFound = true;
                    actual = actionMessages.get(i);
                    break;
                }
            }

            String code[][] = {{"Verify", message}, {"Actual", actual.toString()}, {"Expected", expectedMsg.toString()}};
            Markup m = MarkupHelper.createTable(code);

            if (isFound) {
                node.pass(m);
                node.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
                return true;
            } else {
                node.fail(m);
                node.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
                markAsFailure("Failure: Refer reports for more details");
                return false;
            }
        } catch (Exception e) {
            Assertion.raiseExceptionAndContinue(e, node);
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Verify Error Message
     *
     * @param expected
     * @param message
     * @param node
     * @throws IOException
     */
    public static Boolean verifyErrorMessageContain(String expected, String message, ExtentTest node, String... variation) throws Exception {

        String actual = "";
        boolean isFound = false;
        String expectedMsg = null;

        if (variation.length > 0) {
            expectedMsg = MessageReader.getDynamicMessage(expected, variation);
        } else {
            expectedMsg = MessageReader.getMessage(expected, null);
        }

        List<String> errorMessages = getAllErrorMessages();
        for (int i = 0; i < errorMessages.size(); i++) {
            actual = actual + " " + errorMessages.get(i);
            if (errorMessages.get(i).contains(expectedMsg)) {
                isFound = true;
                actual = errorMessages.get(i);
                break;
            }
        }

        String code[][] = {{"Verify", message}, {"Actual", actual.toString()}, {"Expected", expectedMsg.toString()}};
        Markup m = MarkupHelper.createTable(code);

        if (isFound) {
            node.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            node.pass(m);
            return true;
        } else {
            node.fail(m);
            node.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            markAsFailure("Failure: Refer reports for more details");
            return false;
        }
    }

    /**
     * Verify Message Equals
     *
     * @param expected
     * @param actual
     * @param node
     * @throws IOException
     */
    public static void verifyMessageEquals(String actual, String expected, String message, ExtentTest node) throws Exception {
        String code[][] = {{"Verify", message}, {"Actual", actual.toString()}, {"Expected", expected.toString()}};
        Markup m = MarkupHelper.createTable(code);
        String expectedMsg = MessageReader.getMessage(expected, null);
        if (actual.equals(expectedMsg)) {
            node.pass(m);
        } else {
            node.fail(m);
            node.info("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }

    public static void raiseExceptionAndStop(Exception e, ExtentTest node) throws IOException {
        node.fail(e);
        node.error("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        e.printStackTrace();
        Assert.fail("Error. Stopping the test execution. Message:- " + e.getMessage());
    }

    public static void raiseExceptionAndContinue(Exception e, ExtentTest node) throws IOException {
        node.fail(e);
        node.error("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        markAsFailure("Error: Refer reports for more details. Message:- " + e.getMessage());
    }

    /**
     * Check if there is any error in the page
     *
     * @return
     */
    public static boolean isErrorInPage(ExtentTest node) throws IOException {
        WebDriver driver = DriverFactory.getDriver();
        if (driver.findElements(By.className("errorMessage")).size() > 0 ||
                driver.findElements(By.className("error_Message")).size() > 0) {
            node.info("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            return true;
        } else {
            node.pass("No Error Continue Execution!");
            return false;
        }
    }


    public static Boolean checkActionMessageContain(String expected, String message, ExtentTest node) throws Exception {
        String code = null;
        Markup m = null;
        String actual = "";
        boolean isFound = false;

        String expectedMsg = MessageReader.getMessage(expected, null);
        List<String> actionMessages = getAllActionMessages();
        for (int i = 0; i < actionMessages.size(); i++) {
            actual = actual + ", " + actionMessages.get(i);
            if (actionMessages.get(i).contains(expectedMsg)) {
                isFound = true;
                actual = actionMessages.get(i);
                break;
            }
        }

        if (isFound) {
            code = "Verified Successfully - " + message + ":\nExpected: " + expectedMsg + "\nActual  : " + actual;
            m = MarkupHelper.createCodeBlock(code);
            node.pass(m);
            return true;
        } else {
            return false;
        }
    }


    public static Boolean checkErrorMessageContain(String expected, String message, ExtentTest node) throws IOException {
        String code = null;
        Markup m = null;
        String actual = "";
        boolean isFound = false;

        String expectedMsg = MessageReader.getMessage(expected, null);
        List<String> actionMessages = getAllErrorMessages();
        for (int i = 0; i < actionMessages.size(); i++) {
            actual = actual + ", " + actionMessages.get(i);
            if (actionMessages.get(i).contains(expectedMsg)) {
                isFound = true;
                actual = actionMessages.get(i);
                break;
            }
        }

        if (isFound) {
            code = "Verified Successfully - " + message + ":\nExpected: " + expectedMsg + "\nActual  : " + actual;
            m = MarkupHelper.createCodeBlock(code);
            node.pass(m);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Log Info
     *
     * @param info
     */
    public static void logAsPass(String info, ExtentTest node) {
        Markup m = MarkupHelper.createCodeBlock(info);
        node.pass(m);
    }

    public static void logAsInfo(String info, ExtentTest node) {
        Markup m = MarkupHelper.createCodeBlock(info);
        node.info(m);
    }



}
