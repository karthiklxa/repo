package tests.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.User;
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
public class ToVerifyAmtAndCurrInRequestParameterInWallet extends TestInit
{
    @Test
    public void ToVerifyAmtAndCurr() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1581-WA-Card-01", "To Verify Amount And Currency In Request Parameter In Wallet");

        User newUser = new User();

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

        if (url.contains("transactionAmount="+amt) && url.contains("currency="+cur)){
            t1.pass("when the hosted payment page is called, currency= "+cur+" and amount of transaction= "+amt+" is present in the request parameter(URL)");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("when the hosted payment page is called, currency= "+cur+" and amount of transaction= "+amt+" is not present in the request parameter(URL)");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

    }
}
