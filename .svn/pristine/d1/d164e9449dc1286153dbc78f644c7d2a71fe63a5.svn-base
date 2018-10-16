package tests.Wallet.M_Pesa;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/18/2018.
 */
public class ShouldGetErrorMsgWhenNotEnteringAnyMSISDNNUmberMP extends TestInit
{
    @Test
    public void enteringNullMSISDNNUmber() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-Consumer-14", "Should Get Error Msg When Not Entering Any MSISDN NUmber");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        WalletPaymentInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnMpesaRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumMP("")
                .clickOnGenerateID();

        Thread.sleep(3000);
        String msg = WalletPaymentInfo_pg.init(t1)
                .getErrorMsg();

        Thread.sleep(3000);

        if (ConfigInput.isAssert){
            Assertion.verifyContains(msg, MessageReader.getMessage("error.msg.for.emepty.fields",null),"successful",t1,true);

        }
        else{
            t1.fail("Not Throwing Error Msg");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

        }
    }
}
