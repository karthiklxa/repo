package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Common.Login_pg;
import framework.pageObjects.LightBox.Wallet.WalletInfo_pg;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/28/2018.
 */
public class ToVerifyAmountIsDisplayed extends TestInit
{
    @Test
    public void verifyAmount() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-4", "To Verify Amount Is Displayed In Lightbox");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        boolean amount = Login_pg.init(t1)
                .amount();

        if(amount == true){
            t1.pass("Amount To Be Payed is displayed in login page Of Lightbox");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Amount Is Not Displayed");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
