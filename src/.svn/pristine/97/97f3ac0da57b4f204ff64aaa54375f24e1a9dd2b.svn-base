package tests.Wallet.M_Pesa;

import com.aventstack.extentreports.ExtentTest;
import framework.entity.User;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.NegativedData;
import org.junit.Assert;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/22/2018.
 */
public class ToVerifyTheRefundMSGWhenInvalidRefIDGiven extends TestInit
{
    @Test
    public void toVerifyTheRefundMSG() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-Consumer-17", "To Verify The Refund MSG When User Gives Invalid Ref-ID");

        User newUser = new User();

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        Thread.sleep(2000);
        WalletPaymentInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnMpesaRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumMP(newUser.msisdn)
                .clickOnGenerateID();
        String refNum = WalletPaymentInfo_pg.init(t1)
                .getReferenceNum();

        if (ConfigInput.isAssert) {
            Assertion.assertEqual("0006", ApiManagement.init(t1).verifyWalletPayment(ConfigInput.ActiontypeAccept,NegativedData.InvalidMobNum,refNum), "Payment is Initiated", t1);
            WalletPaymentInfo_pg.init(t1).clickOnConfirmPaymentBtn1();
            startNegativeTest(t1);
            Assertion.verifyActionMessageContain("payment.refund.msg", "Verify wallet payment is refunded when user gives wrong reference-ID for user:" + newUser.loginId, t1);

        }

    }
}
