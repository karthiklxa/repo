package tests.LightBox.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import framework.entity.User;
import framework.entity.Wallet;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.features.PaymentManagement;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.globalConstants.Wallets;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/12/2018.
 */
public class PaymentSuccessfullyDoneThroughEcoCash_LB extends TestInit {

    @Test(priority = 1)
    public void paymentSuccessfull() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-wallet-EcoCash-08", "Payment Successfully Done Through EcoCash ");

        User newUser = new User();
        Wallet wEcoCash = DataFactory.getWalletFromAppData(Wallets.ECO_CASH);
//        Thread.sleep(4000);
        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

//        LightBoxManagement.init(t1)
//                .loginToLightBox();
//        Thread.sleep(4000);

        LightBoxManagement.init(t1)
                .initiateWalletPayment(newUser, wEcoCash,ConfigInput.ActiontypeAccept);

    }

}