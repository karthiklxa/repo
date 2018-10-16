package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.util.Encryption.CurrencySymbol;
import framework.util.Encryption.EcnryptData;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 9/13/2018.
 */
public class ToVerifyTheHeaderContainsAmtAndCur extends TestInit {
    @Test
    public void toVerifyAmountAndCurrencyInHeader() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1581-CA-Card-04", "To Verify The Header Contains Amount And Curency");

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

        String en = "{\"transactionCurrencyCode\":\"" + cur + "\"}";
        String data = EcnryptData.aesEncryption(en);
        String res = ApiManagement.init(t1).currencyCode(data);
        String code = EcnryptData.aesDecryption(res);
        System.out.println(code);
        String currencySymbol = CurrencySymbol.getCurrencySymbol(code);
        System.out.println("Currency Symbol  " + currencySymbol);

        String currencyDetails = AddToCart_pg1.init(t1)
                .currencyDetails();

        if (currencyDetails.contains(amt) && currencyDetails.contains(currencySymbol)){
            t1.pass("Currency symbol and amount present in the heading of the page ");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Currency symbol and amount does not present in the heading of the page");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }


    }

    }
