package tests.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
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
import framework.util.dbManagement.GUIQueries;
import framework.util.globalConstants.Wallets;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/20/2018.
 */
public class PaymentFailedInEcoCash extends TestInit
{
    @Test
    public void paymentFailure() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-push-11", "Payment Failed In EcoCash When Customer Rejects The Payment");

        User newUser = new User();

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        WalletPaymentInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnEcoCashRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumEC(newUser.msisdn)
                .clickOnSubmitBtn();
        GUIQueries db = new GUIQueries();
        String refNum = db.mcRRN();
//        String refNum = "EC" + DataFactory.getRandomNumberAsString(9);
        if (ConfigInput.isAssert) {
            Assertion.assertEqual("0000", ApiManagement.init(t1).verifyWalletPayment(NegativedData.ActionTypeReject,newUser.msisdn, refNum), "Payment is Initiated", t1);
            WalletPaymentInfo_pg.init(t1).clickOnConfirmPaymentBtn1();
            startNegativeTest(t1);

            Assertion.verifyActionMessageContain("payment.failure.msg1", "Verify wallet payment is failed when user rejects the payment for user:" + newUser.loginId, t1);

        }

    }
}
