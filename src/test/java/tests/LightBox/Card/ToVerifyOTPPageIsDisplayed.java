package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Common.Login_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/29/2018.
 */
public class ToVerifyOTPPageIsDisplayed extends TestInit
{@Test
public void Payment() throws Exception {
    ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-21 & PAYPLUS-1582-CA-Card-05", "To Verify Card Payment Page");

    Login.init(t1)
            .validLogin();

    CartManagement.init(t1)
            .addDefaultItemToCart1();

    Login_pg.init(t1)
            .email(ConfigInput.email)
            .mobNum(ConfigInput.mobileNum)
            .creditOrDebitLink();

//    boolean otp = Login_pg.init(t1)
//            .verifyOTP();

    String otpMsg = Login_pg.init(t1).otpMsg();

//    if(otp == true){
//        t1.pass("OTP Filed Is Displayed");
//        t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
//    }
//    else {
//        t1.fail("OTP Filed Is Not Displayed");
//        t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
//    }
    if (ConfigInput.isAssert) {
        Assertion.verifyContains(otpMsg, MessageReader.getMessage("otp.page.msg", null), "otp page message", t1, true);
    }







    }
}