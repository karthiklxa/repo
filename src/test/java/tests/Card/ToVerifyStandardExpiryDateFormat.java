package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/11/2018.
 */
public class ToVerifyStandardExpiryDateFormat extends TestInit {

    @Test
    public void verifyingDateFormat() throws Exception {
        ExtentTest t1 = pNode.createNode("VerifyingDateFormat", "VerifyingDateFormat");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        String month = PaymentInfo_pg1.init(t1)
                .verifyMonth().getText();
        String year = PaymentInfo_pg1.init(t1)
                .verifyYear().getText();

        if(month.equalsIgnoreCase("mm") && year.equalsIgnoreCase("yyyy")){
            t1.pass("Date & Year Format Are As Far Standard");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else{
            t1.fail("Date & Year Format Are Not As Far Standard");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }



    }
}
