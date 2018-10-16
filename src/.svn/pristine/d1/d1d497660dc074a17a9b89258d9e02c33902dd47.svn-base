package tests.Wallet.M_Pesa;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/13/2018.
 */
public class ToVerifyMPesaAreDisplayed extends TestInit {
        @Test
        public void toVerifyPaymentOptionsInWallet() throws Exception {
            ExtentTest t1 = pNode.createNode("PAYPLUS-673-Consumer-01", "To Verify Payment Options M-Pesa In Wallet Are Displayed And Clickable");

            Login.init(t1)
                    .validLogin();

            CartManagement.init(t1)
                    .addDefaultItemToCart();

            WalletPaymentInfo_pg.init(t1)
                    .clickOnWallet();
            boolean display2 = WalletPaymentInfo_pg.init(t1)
                    .mPesaRadioBtn();
            boolean mpSelected = WalletPaymentInfo_pg.init(t1)
                    .clickOnMpesaRadiobtnVerify();

            if(display2 == true && mpSelected == true){
                t1.pass("M-Pesa Option Is Displayed And Clickable");
                t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            }
            else {
                t1.fail("M-Pesa Option Is Not Displayed And Not Clickable");
                t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

            }
        }
    }
