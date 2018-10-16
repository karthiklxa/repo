package tests.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import framework.entity.User;
import framework.entity.Wallet;
import framework.features.*;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.globalConstants.Wallets;
import framework.util.propertyManagement.MessageReader;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/12/2018.
 */
public class PaymentSuccessfullyDoneThroughEcoCash extends TestInit {

    @Test(priority = 1)
    public void paymentSuccessfull() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-push-10", "PaymentSuccessfullyDoneThroughEcoCash");

        User newUser = new User();
        Wallet wEcoCash = DataFactory.getWalletFromAppData(Wallets.ECO_CASH);

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentManagement.init(t1)
                .initiateWalletPayment(newUser, wEcoCash,ConfigInput.ActiontypeAccept);
    }

}