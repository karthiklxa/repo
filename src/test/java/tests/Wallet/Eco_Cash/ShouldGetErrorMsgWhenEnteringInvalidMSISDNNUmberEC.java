package tests.Wallet.Eco_Cash;

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
public class ShouldGetErrorMsgWhenEnteringInvalidMSISDNNUmberEC extends TestInit
{
    @Test
    public void enteringInvalidMSISDNNUmberEC() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-673-push-04", "ShouldGetErrorMsgWhenEnteringInvalidMSISDNNUmber");
        User newUser = new User();

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        WalletPaymentInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnEcoCashRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumEC(NegativedData.InvalidMSISDN)
                .clickOnSubmitBtn();


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
            Assertion.verifyContains(msg,MessageReader.getMessage("error.msg.for.emepty.fields",null),"should throw error message when MSISDN field wrong and clicking on submit button",t1,true);
        }
        else{
            t1.fail("Not Throwing Error Msg");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }



    }

}
