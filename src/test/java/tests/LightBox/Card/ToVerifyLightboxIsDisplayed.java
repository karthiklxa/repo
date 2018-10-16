package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Common.Login_pg;
import framework.util.common.DataFactory;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/28/2018.
 */
public class ToVerifyLightboxIsDisplayed extends TestInit
{
    @Test
    public void verifyLightbox() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-01", "To Verify Lightbox Is Displayed");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

//        driver.switchTo().frame(0);
        boolean validate = Login_pg.init(t1)
                .merchantName();

        if(validate == true){
            t1.pass("lightbox pop screen is  displayed ");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("lightbox pop screen is not displayed ");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
