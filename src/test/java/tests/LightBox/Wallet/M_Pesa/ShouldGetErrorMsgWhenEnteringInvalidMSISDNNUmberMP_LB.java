package tests.LightBox.Wallet.M_Pesa;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.User;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Wallet.WalletInfo_pg;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.NegativedData;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/13/2018.
 */
public class ShouldGetErrorMsgWhenEnteringInvalidMSISDNNUmberMP_LB extends TestInit
{
    @Test
    public void enteringInvalidMSISDNNUmberEC_LB() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-wallet-MPesa-04", "Should Get Error Message When Entering Invalid MSISDN");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

//        LightBoxManagement.init(t1)
//                .loginToLightBox();

        WalletInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnMpesaRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumMP(NegativedData.InvalidMSISDN)
                .clickOnGenerateID();

        startNegativeTest(t1);
        String msg = WalletInfo_pg.init(t1)
                .getErrorMsg();
        Thread.sleep(2000);

        if (ConfigInput.isAssert){
            Assertion.verifyContains(msg,MessageReader.getMessage("error.msg.for.emepty.fields",null),"Error Message Displayed",t1,true);
        }
        else{
            t1.fail("Not Throwing Error Msg");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
