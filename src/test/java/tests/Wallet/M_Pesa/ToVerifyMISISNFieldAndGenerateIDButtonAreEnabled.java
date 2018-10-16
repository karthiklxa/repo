package tests.Wallet.M_Pesa;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.User;
import framework.entity.Wallet;
import framework.features.CartManagement;
import framework.features.Login;
import framework.features.PaymentManagement;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.DataFactory;
import framework.util.globalConstants.Wallets;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/18/2018.
 */
public class ToVerifyMISISNFieldAndGenerateIDButtonAreEnabled extends TestInit {

    @Test
    public void toVerifyMISISNFieldAndGenerateIDButton() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-Consumer-02", "To Verify MISISN Filed And Generate-ID Button Are Enabled");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        WalletPaymentInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnMpesaRadiobtn()
                .clickOnPayNowBtn();
        boolean MISISN = WalletPaymentInfo_pg.init(t1)
                .mobNumFieldMPVerify();
        boolean generateID = WalletPaymentInfo_pg.init(t1)
                .generateIDVerify();

        if(MISISN == true && generateID == true){
            t1.pass("MISISN Field And Generate-ID button Are Enabled");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("MISISN Field And Generate-ID button Are Disabled");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}