package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.util.Encryption.CurrencySymbol;
import framework.util.Encryption.EcnryptData;
import framework.util.common.ConfigInput;
import framework.util.common.DriverFactory;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 9/13/2018.
 */
public class ToVerifyTheAmtAndCurByChangingTheURLValue extends TestInit {
    @Test
    public void toVerifyTheAmtAndCurByChangingTheURLValue() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1581-LB-Card-10", "To Verify The Amount And Currency symbol By Changing The URL Value");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

//        String url = driver.getCurrentUrl();
        String baseUrl = ConfigInput.URL1;

        driver.get("http://"+baseUrl+"/CNP/payModeAction_payment?customCss=http://"+baseUrl+"/CART/css/customCss.css&transactionAmount=100&currency=USD&orderId=12345&userid=cnp&billingAddressLine1=USA1&billingAddressLine2=USA2&billingCountry=USA&billingState=New%20York&&billingCity=New%20York&mobile=4545454545&email=g@g.com&targetUrl=_parent&hid=automation&mid=74000274&tid=88000047&checkSum=e1029617db6a63faeea6c8aed9ad4421baa337f873e53c961f4e4f1a21578cd8&callbackurl=http://172.19.7.229:1035/CART/jsps/home.jsp&transactionType=sale&customerCode=1234&taxIncluded=Y&electronicGoodsIndicator=D&billingZipCode=4331&shippingDate=12-May-2015&checkSumPayment=fd63ab7f20d1176e6c996046a5322aed66405321a9b0263084d7f40dcdb5f55b&taxAmount=1&hierarchyCriteria=B2");

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

        String currencyDeatils = AddToCart_pg1.init(t1)
                .currencyDetails();

        if (currencyDeatils.contains(currencySymbol) && currencyDeatils.contains(amt) && url.contains("transactionAmount="+amt+"") && url.contains("currency="+cur+"")) {
            t1.pass("Transaction amount and currency symbol is displayed in dollars as requested");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Transaction amount and currency symbol is not displayed in dollars ");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }

}
