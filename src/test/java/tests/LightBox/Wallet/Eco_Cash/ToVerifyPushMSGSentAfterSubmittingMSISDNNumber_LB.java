package tests.LightBox.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.User;
import framework.entity.Wallet;
import framework.features.*;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.globalConstants.Wallets;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/16/2018.
 */
public class ToVerifyPushMSGSentAfterSubmittingMSISDNNumber_LB extends TestInit
{


    @Test(priority = 1)
    public void verifyPushMSGSent() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-wallet-EcoCash-03", "To Verify Push MSG Received After Submitting MSISDN Number");

        User newUser = new User();
        Wallet wEcoCash = DataFactory.getWalletFromAppData(Wallets.ECO_CASH);

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

//        LightBoxManagement.init(t1)
//                .loginToLightBox();

//        Thread.sleep(2000);
        LightBoxManagement.init(t1)
                .initiateWalletPayment1(newUser, wEcoCash);

//        String code = ApiManagement.init(t1).verifyWalletPayment("ACCEPT", newUser.msisdn, newUser.rrn);

//        if(code.equals("0000")){
//            t1.pass("Reference ID Matches So Push Msg Successfully Sent");
//        }
        if (ConfigInput.isAssert) {
            Assertion.assertEqual("0000", ApiManagement.init(t1).verifyWalletPayment(ConfigInput.ActiontypeAccept, newUser.msisdn, newUser.rrn), "Reference ID Matches So Push Msg Successfully Sent", t1);
        }
        else{
            t1.fail("Reference ID Is Not Matching So Push Msg Not Sent");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
