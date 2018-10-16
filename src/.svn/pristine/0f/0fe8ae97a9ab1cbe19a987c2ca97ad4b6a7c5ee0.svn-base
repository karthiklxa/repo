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
public class ToVerifyProductIsDisplayed extends TestInit
{
    @Test
    public void verifyProductName() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-8", "To Verify Product Name Is Displayed In Lightbox");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        boolean name = Login_pg.init(t1)
                .productName();

        if(name == true){
            t1.pass("Product Name is displayed in login page Of Lightbox");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Product Name Is Not Displayed");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
