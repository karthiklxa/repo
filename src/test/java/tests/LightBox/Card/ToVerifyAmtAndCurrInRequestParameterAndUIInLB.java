package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.util.Encryption.CurrencySymbol;
import framework.util.Encryption.EcnryptData;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 9/15/2018.
 */
public class ToVerifyAmtAndCurrInRequestParameterAndUIInLB extends TestInit
{
    @Test
    public void toVerifyAmountAndCurrencyInURLAndRP() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1582-CA-Card-02", "To Verify Amount And Currency In Request Parameter And In UI");

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

        String en = "{\"transactionCurrencyCode\":\""+cur+"\"}";
        String data = EcnryptData.aesEncryption(en);
        String res = ApiManagement.init(t1).currencyCode(data);
        String code = EcnryptData.aesDecryption(res);
        System.out.println(code);
        String currencySymbol = CurrencySymbol.getCurrencySymbol(code);
        System.out.println("Currency Symbol  "+currencySymbol);

        String currencyDeatils = AddToCart_pg1.init(t1)
                .currencyDetails();

        if (currencyDeatils.contains(currencySymbol) && currencyDeatils.contains(amt) && URL.contains("transactionAmount="+amt+"") && URL.contains("currency="+cur+"")) {
            t1.pass("when the light box is called, currency and amount of transaction is present in the request parameter(URL) and the same is present in UI");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("when the light box is called, currency and amount of transaction is not present in the request parameter(URL) the same is present in UI");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }


    }
}
