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
public class ToVerifyAmtAndCurInPayBtnInLB extends TestInit {
    @Test
    public void toVerifySymbolAndAmount() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1582-CA-Card-04", "To Verify Amount And Currency InPay Button");

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

        String payBtnWithCurrency = AddToCart_pg1.init(t1)
                .payBtn();

        if (payBtnWithCurrency.contains(amt) && payBtnWithCurrency.contains(currencySymbol)){
            t1.pass("Currency symbol and amount present in pay button");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Currency symbol and amount not present in pay button");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
