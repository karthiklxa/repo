package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 9/15/2018.
 */
public class ToVerifyAmtAndCurrInRequestParameterInLBCard extends TestInit
{
    @Test
    public void toVerifyAmountAndCurrencyInURL() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1582-CA-Card-01", "To Verify Amount And Currency In Request Parameter");

        Login.init(t1)
                .validLogin();
        CartManagement.init(t1)
                .addDefaultItemToCart2();

        String URL = AddToCart_pg1.init(t1).frameURL();
        System.out.println(URL);

        String[] split = URL.split("=");
        String[] s = split[2].split("&");
        String amt = s[0];
        String[] s1 = split[3].split("&");
        String cur = s1[0];

        AddToCart_pg1.init(pNode)
                .frame();

        LightBoxManagement.init(t1)
                .loginToLightBox();

        if (URL.contains("transactionAmount="+amt) && URL.contains("currency="+cur)){
            t1.pass("when the light box called, currency and amount of transaction is present in the request parameter(URL)");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("when the light box called, currency and amount of transaction is not present in the request parameter(URL)");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
