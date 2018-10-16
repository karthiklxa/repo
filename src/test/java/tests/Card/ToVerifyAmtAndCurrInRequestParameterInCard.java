package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 9/12/2018.
 */
public class ToVerifyAmtAndCurrInRequestParameterInCard extends TestInit
{
    @Test
    public void toVerifyAmountAndCurrencyInURL() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1581-CA-Card-01", "To Verify Amount And Currency In Request Parameter");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        String url = driver.getCurrentUrl();
        String[] split = url.split("=");
        String[] s = split[2].split("&");
        String amt = s[0];
        String[] s1 = split[3].split("&");
        String cur = s1[0];
        System.out.println(url);

        if (url.contains("transactionAmount="+amt) && url.contains("currency="+cur)){
            t1.pass("when the hosted payment page is called, currency and amount of transaction is present in the request parameter(URL)");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("when the hosted payment page is called, currency and amount of transaction is not present in the request parameter(URL)");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }



    }
}
