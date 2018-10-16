package tests.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.User;
import framework.entity.Wallet;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.Login;
import framework.features.PaymentManagement;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.common.NegativedData;
import framework.util.globalConstants.Wallets;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/16/2018.
 */
public class ToVerifyResponseCodeWhenMSISDNNumberNotMatching extends TestInit
{
    @Test(priority = 1)
    public void verifyResponseCodeWhenMSISDNNumberNotMatching() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-push-08", "To Verify Response Code When MSISDN Number Not Matching");

        User newUser = new User();
        Wallet wEcoCash = DataFactory.getWalletFromAppData(Wallets.ECO_CASH);

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        startNegativeTest(t1);
        PaymentManagement.init(t1)
                .initiateWalletPayment1(newUser, wEcoCash);

        String code = ApiManagement.init(t1).verifyWalletPayment("ACCEPT",NegativedData.InvalidMSISDN, newUser.rrn);

        if (!code.equals("0000")) {
            t1.pass("Since Mobile Number Is Not Matching Cannot Click On Confirm Payment Button");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        } else {
            t1.fail("Should Not Click On Confirm Payment Button Since Mobile Number Is Given Wrong");
            t1.fail("",MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }


    }

}
