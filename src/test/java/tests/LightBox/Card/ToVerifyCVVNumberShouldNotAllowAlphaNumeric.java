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
public class ToVerifyCVVNumberShouldNotAllowAlphaNumeric extends TestInit {
    @Test
    public void verifyFields() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-18", "To Verify CVV Number Should Not Allow Alpha Numeric");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        LightBoxManagement.init(t1)
                .loginToLightBox();

        startNegativeTest(t1);
        WebElement ele = driver.findElement(By.id("cvvCredit"));
        ele.sendKeys(NegativedData.CVVNumberAsAlphaNumeric);
        String actual = ele.getAttribute("value");

        t1.info("CVV numbers tried to pass: "+NegativedData.CVVNumberAsAlphaNumeric);
        t1.info("CVV numbers accepted: "+actual);
        if(!NegativedData.CVVNumberAsAlphaNumeric.equals(actual)){
            t1.pass("CVV Number Should Not Be Alpha Numeric");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("CVV Number Accepts Alpha Numeric");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

        }

}
}
