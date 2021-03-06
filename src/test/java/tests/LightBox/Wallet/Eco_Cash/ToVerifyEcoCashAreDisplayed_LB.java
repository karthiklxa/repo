package tests.LightBox.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Wallet.WalletInfo_pg;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/13/2018.
 */
public class ToVerifyEcoCashAreDisplayed_LB extends TestInit {
        @Test
        public void toVerifyPaymentOptionsInWallet() throws Exception {
            ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-wallet-EcoCash-01", "To Verify Payment Options Eco-Cash In Wallet Are Displayed And Clickable");

            Login.init(t1)
                    .validLogin();

            CartManagement.init(t1)
                    .addDefaultItemToCart1();

//            LightBoxManagement.init(t1)
//                    .loginToLightBox();

            WalletInfo_pg.init(t1)
                    .clickOnWallet();
            boolean display1 = WalletInfo_pg.init(t1)
                    .ecoCashRadioBtn();
            boolean ecSelected = WalletInfo_pg.init(t1)
                    .clickOnEcoCashRadiobtnVerify();

            if(display1 == true && ecSelected == true ){
                t1.pass("Eco-Cash Option Is Displayed And Clickable");
                t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            }
            else {
                t1.fail("Eco-Cash Option Is Not Displayed  And Not Clickable", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
                t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
            }
        }
    }
