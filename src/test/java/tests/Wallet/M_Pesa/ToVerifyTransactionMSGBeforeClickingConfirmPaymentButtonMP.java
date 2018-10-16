package tests.Wallet.M_Pesa;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.User;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/18/2018.
 */
public class ToVerifyTransactionMSGBeforeClickingConfirmPaymentButtonMP extends TestInit
{
    @Test
    public void confirmingTransactionmsg() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-Consumer-05", "To Verify Transaction Message Before Clicking ConfirmPayment Button");
        User newUser = new User();

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        WalletPaymentInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnMpesaRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumMP(newUser.msisdn)
                .clickOnGenerateID();

        Thread.sleep(2000);
        String msg = WalletPaymentInfo_pg.init(t1)
                .transactionMSG();

        Thread.sleep(3000);

        if (ConfigInput.isAssert) {
            Assertion.verifyContains(msg, MessageReader.getMessage("transaction.msg.mp", null), "Transaction message is displayed on the UI", t1, true);
        } else {
            t1.fail("No Transaction Message");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
