package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.pageObjects.LightBox.Card.CardInfo_pg;
import framework.pageObjects.LightBox.Common.Login_pg;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/11/2018.
 */
public class ToVerifyStandardExpiryDateFormat_LB extends TestInit {

    @Test
    public void verifyingDateFormat() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-16", "Verifying Date Format");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        LightBoxManagement.init(t1)
                .loginToLightBox();

        String date = CardInfo_pg.init(t1)
                .verifyDateFormat();
//        String year = CardInfo_pg.init(t1)
//                .verifyYearFormat().getText();

//        if(month.equalsIgnoreCase("MM") && year.equalsIgnoreCase("YYYY"))
        if(date.equals("MM / YY"))
        {
            t1.pass("Date & Year Format Are As Far Standard");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else{
            t1.fail("Date & Year Format Are Not As Far Standard");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }



    }
}
