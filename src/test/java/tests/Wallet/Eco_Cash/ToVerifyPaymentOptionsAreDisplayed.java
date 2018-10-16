package tests.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/13/2018.
 */
public class ToVerifyPaymentOptionsAreDisplayed extends TestInit {
    @Test
    public void toVerifyPaymentOptions() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-push-01", "To Verify Payment Options Are Displayed");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        boolean display1 = PaymentInfo_pg1.init(t1)
                .creditOrDebit();

        boolean display2 = WalletPaymentInfo_pg.init(t1)
                .wallet();
        if(display1 == true && display2 ==true){
            t1.pass("Credit/Debit Card Payment and Wallet Payment Option Is Displayed");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Credit/Debit Card Payment and Wallet Payment Option Is Not Displayed");
            t1.fail("",MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

    }
}

