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
public class ToVerifyThePaymentOptionsInLB extends TestInit {
    @Test
    public void verifyPaymentOptions() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-3", "To Verify The Payment Options In Lightbox");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        boolean card = Login_pg.init(t1)
                .creditOrDebit();
        Boolean wallet = WalletInfo_pg.init(t1)
                .wallet();

        if(card == true && wallet == true){
            t1.pass("Payment Options Like Credit/Debit Card and Wallet is displayed in login page Of Lightbox");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Payment Options Are Not Displayed");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
