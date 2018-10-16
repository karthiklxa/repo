package tests.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/13/2018.
 */
public class ToVerifyEcoCashAreDisplayed extends TestInit {
        @Test
        public void toVerifyPaymentOptionsInWallet() throws Exception {
            ExtentTest t1 = pNode.createNode("PAYPLUS-673-push-02", "To Verify Payment Options Eco-Cash In Wallet Are Displayed And Clickable");

            Login.init(t1)
                    .validLogin();

            CartManagement.init(t1)
                    .addDefaultItemToCart();

            WalletPaymentInfo_pg.init(t1)
                    .clickOnWallet();
            boolean display1 = WalletPaymentInfo_pg.init(t1)
                    .ecoCashRadioBtn();
            boolean ecSelected = WalletPaymentInfo_pg.init(t1)
                    .clickOnEcoCashRadiobtnVerify();

            if(display1 == true && ecSelected == true ){
                t1.pass("Eco-Cash Option Is Displayed And Clickable");
                t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            }
            else {
                t1.fail("Eco-Cash Option Is Not Displayed  And Not Clickable", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            }
        }
    }
