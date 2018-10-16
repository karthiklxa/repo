package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Common.Login_pg;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/28/2018.
 */
public class ToVerifyEmailAndMobNum extends TestInit {
    @Test
    public void verifyEmailAndMobum() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-02", "To Verify Email And Mobile Number In LightBox");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        boolean validateEmail = Login_pg.init(t1)
                .verifyEmail();
        boolean validateMob = Login_pg.init(t1)
                .verifyMobNum();

        if(validateEmail == true && validateMob == true){
            t1.pass("Email And Mobile Number Fiels is displayed In Lightbox Screen ");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Email And Mobile Number Fiels is Not displayed In Lightbox Screen ");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}