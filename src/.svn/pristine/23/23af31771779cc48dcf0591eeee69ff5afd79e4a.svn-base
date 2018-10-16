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
public class ToVerifyMerchantNameIsDisplayed extends TestInit
{
    @Test
    public void verifyMerchantName() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-7", "To Verify Merchant Name Is Displayed In Lightbox");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        boolean name = Login_pg.init(t1)
                .merchantName();

        if(name == true){
            t1.pass("Merchant Name is displayed in login page Of Lightbox");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Merchant Name Is Not Displayed");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
