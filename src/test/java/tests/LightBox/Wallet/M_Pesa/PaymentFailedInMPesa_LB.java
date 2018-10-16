package tests.LightBox.Wallet.M_Pesa;

import com.aventstack.extentreports.ExtentTest;
import framework.entity.User;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Wallet.WalletInfo_pg;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.NegativedData;
import org.junit.Assert;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/20/2018.
 */
public class PaymentFailedInMPesa_LB extends TestInit
{
    @Test
    public void paymentFailed() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-wallet-MPesa-08", "Payment Failed In M-Pesa When Customer Rejects The Payment");

        User newUser = new User();

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        Thread.sleep(2000);
        WalletInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnMpesaRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumMP(newUser.msisdn)
                .clickOnGenerateID();
        String refNum = WalletInfo_pg.init(t1)
                .getReferenceNum();
        if (refNum == null) {
            pNode.fail("Failed to get the rrn");
            Assert.fail("Failed to get the rrn");
        }

        if (ConfigInput.isAssert) {
            Assertion.assertEqual("0000", ApiManagement.init(t1).verifyWalletPayment(NegativedData.ActionTypeReject,newUser.msisdn, refNum), "Payment is Initiated", t1);
            WalletInfo_pg.init(t1).clickOnConfirmPaymentBtn();
            startNegativeTest(t1);
             Assertion.verifyActionMessageContain("payment.failure.msg", "Verify wallet payment is failed when user rejects the payment for user:" + newUser.loginId, t1);

        }

    }
}
