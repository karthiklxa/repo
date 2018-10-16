package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.util.common.NegativedData;
import framework.util.reportManagement.ScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/28/2018.
 */
public class ToVerifyCardNumShouldNotAllowAlphaNumeric extends TestInit {
    @Test
    public void verifyFields() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-15", "To Verify Card Number Should Not Allow Alpha Numeric");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        LightBoxManagement.init(t1)
                .loginToLightBox();
        startNegativeTest(t1);
        WebElement ele = driver.findElement(By.id("cardNumberCredit"));
        ele.sendKeys(NegativedData.CardNumAsAlphaNumeric);
        String actual = ele.getAttribute("value");

        t1.info("card numbers tried to pass: " + NegativedData.CardNumAsAlphaNumeric);
        t1.info("card numbers accepted: " + actual);
        if (!NegativedData.CardNumAsAlphaNumeric.equals(actual)) {
            t1.pass("Card Number Field Should Not Accept Alpha Numeric");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        } else {
            t1.fail("Card Number Field Should Not Accept Alpha Numeric");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
