package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.features.PaymentManagement;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 9/13/2018.
 */
public class ToVerifyTheCardPage extends TestInit {
    @Test
    public void toVerifyTheCardPage() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1581-LB-Card-05", "To Verify The Card Page Will Displayed By Default");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        boolean verify = PaymentInfo_pg1.init(t1).verifyCardNum();
        if(verify == true){
            t1.pass("Card Page is Displayed By Default");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Card Page is Not Displayed");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
