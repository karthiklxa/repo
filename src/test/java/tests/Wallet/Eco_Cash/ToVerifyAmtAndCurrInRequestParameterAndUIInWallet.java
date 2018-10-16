package tests.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.Encryption.CurrencySymbol;
import framework.util.Encryption.EcnryptData;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 9/14/2018.
 */
public class ToVerifyAmtAndCurrInRequestParameterAndUIInWallet extends TestInit
{
    @Test
    public void toVerifyAmountAndCurrencyInURLAndRP() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1581-WA-Card-02", "To Verify Amount And Currency In Request Parameter And In UI");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        WalletPaymentInfo_pg.init(t1)
                .clickOnWallet();

        String url = driver.getCurrentUrl();
        String[] split = url.split("=");
        String[] s = split[2].split("&");
        String amt = s[0];
        String[] s1 = split[3].split("&");
        String cur = s1[0];

        String en = "{\"transactionCurrencyCode\":\""+cur+"\"}";
        String data = EcnryptData.aesEncryption(en);
        String res = ApiManagement.init(t1).currencyCode(data);
        String code = EcnryptData.aesDecryption(res);
        System.out.println(code);
        String currencySymbol = CurrencySymbol.getCurrencySymbol(code);
        System.out.println("Currency Symbol  "+currencySymbol);

        String currencyDetails = AddToCart_pg1.init(t1)
                .currencyDetails();

        if (currencyDetails.contains(currencySymbol) && currencyDetails.contains(amt) && url.contains("transactionAmount="+amt+"") && url.contains("currency="+cur+"")) {
            t1.pass("when the hosted payment page is called, currency= "+currencySymbol+" and amount of transaction= "+amt+" is present in the request parameter(URL) and the same is present in UI");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("when the hosted payment page is called, currency= "+currencySymbol+" and amount of transaction= "+amt+" is not present in the request parameter(URL) the same is present in UI");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

    }
}
