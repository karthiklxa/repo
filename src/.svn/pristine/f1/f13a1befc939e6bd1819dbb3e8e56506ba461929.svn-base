package tests.Wallet.M_Pesa;

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
import framework.util.globalConstants.Wallets;
import framework.util.propertyManagement.MessageReader;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/12/2018.
 */
public class PaymentSuccessfullyDoneThroughMPesa extends TestInit
{
    @Test
    public void paymentSuccessfully() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-Consumer-12", "PaymentSuccessfullyDoneThroughMPesa");


        User newUser = new User();
        Wallet wMPesa = DataFactory.getWalletFromAppData(Wallets.M_PESA);

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentManagement.init(t1)
                .initiateWalletPayment(newUser, wMPesa,ConfigInput.ActiontypeAccept);
    }
}
