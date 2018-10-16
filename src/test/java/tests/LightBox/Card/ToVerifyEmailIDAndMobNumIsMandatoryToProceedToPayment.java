package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Common.Login_pg;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/28/2018.
 */
public class ToVerifyEmailIDAndMobNumIsMandatoryToProceedToPayment extends TestInit
{
    @Test
    public void VerifyEmailIDAndMobNumIsMandatory() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-10", "To Verify Email-ID And Mobile Number Is Mandatory To Proceed To Payment");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        boolean validateEmail = Login_pg.init(t1)
                .verifyEmail();
        boolean validateMob = Login_pg.init(t1)
                .verifyMobNum();



        Login_pg.init(t1)
                .email(ConfigInput.email)
                .mobNum(ConfigInput.mobileNum);

        if(validateEmail == true && validateMob == true){
            t1.pass("Email And Mobile Number Fiels is displayed In Lightbox Screen ");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Email And Mobile Number Fiels is Not displayed In Lightbox Screen ");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

        boolean otp = Login_pg.init(t1)
                .creditOrDebitLink()
                .verifyOTP();

        if(otp == true){
            t1.pass("OTP Field Is Displayed Therefore Email-ID and Mobile Number Fields Are Working Fine");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("OTP Field Is Not Displayed");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }


    }

}
