package tests.LightBox.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Wallet.WalletInfo_pg;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/13/2018.
 */
public class ShouldGetErrorMsgWhenNotEnteringAnyMSISDNNUmberEC extends TestInit
{
    @Test
    public void enteringNullMSISDNNUmber() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-wallet-EcoCash-05", "Should Get Error Message When Not Entering Any MSISDN");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

//        LightBoxManagement.init(t1)
//                .loginToLightBox();

        WalletInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnEcoCashRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumEC("")
                .clickOnSubmitBtn();
        Thread.sleep(3000);
        String msg = WalletPaymentInfo_pg.init(t1)
                .getErrorMsg();

        startNegativeTest(t1);

        if (ConfigInput.isAssert){
            Assertion.verifyContains(msg,MessageReader.getMessage("error.msg.for.emepty.fields",null),"should throw error message when MSISDN field emepy and clicking on submit button",t1,true);

        }
        else{
            t1.fail("Not Throwing Error Msg");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
