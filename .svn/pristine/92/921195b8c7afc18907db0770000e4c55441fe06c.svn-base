package tests.Wallet.M_Pesa;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.User;
import framework.features.CartManagement;
import framework.features.Login;
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
public class ShouldGetErrorMsgWhenEnteringInvalidMSISDNNUmberMP extends TestInit
{
    @Test
    public void enteringInvalidMSISDNNUmberEC() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-Consumer-03", "ShouldGetErrorMsgWhenEnteringInvalidMSISDNNUmber");
        User newUser = new User();

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        WalletPaymentInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnMpesaRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumMP(NegativedData.InvalidMSISDN)
                .clickOnGenerateID();


        startNegativeTest(t1);
        String msg = WalletPaymentInfo_pg.init(t1)
                .getErrorMsg();

//        if(msg.contains(MessageReader.getMessage("error.msg.for.emepty.fields",null))){
//            t1.pass("Should Throw Error Msg");
//        }
//        else{
//            t1.fail("Not Throwing Error Msg");
//        }

        if (ConfigInput.isAssert){
            Assertion.verifyContains(msg,MessageReader.getMessage("error.msg.for.emepty.fields",null),"successful",t1,true);
        }
        else{
            t1.fail("Not Throwing Error Msg");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
