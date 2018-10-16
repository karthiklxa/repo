package tests.LightBox.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.pageObjects.LightBox.Wallet.WalletInfo_pg;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 9/14/2018.
 */
public class ToVerifyAmtAndCurrInRequestParameterInLBWallet extends TestInit
{
    @Test
    public void ToVerifyAmtAndCurr() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1582-WA-Card-01", "To Verify Amount And Currency In Request Parameter In Wallet");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart2();

//        AddToCart_pg1.init(pNode).changeFrameURL("http://172.19.7.229:1035/CNP/payModeAction_payment?customCss=http://172.19.7.229:1035/CART/css/customCss.css&transactionAmount=100&currency=USD&merchantName=payPlus&productName=Color%20tShirt&orderId=12345&userid=cnp&billingAddressLine1=USA1&billingAddressLine2=USA2&billingCountry=USA&billingState=New%20York&&billingCity=New%20York&mobile=4545454545&email=g@g.com&targetUrl=_parent&hid=automation&mid=74000274&tid=88000047&checkSum=e1029617db6a63faeea6c8aed9ad4421baa337f873e53c961f4e4f1a21578cd8&callbackurl=http://172.19.7.229:1035/CART/jsps/home.jsp&transactionType=sale&customerCode=1234&taxIncluded=Y&electronicGoodsIndicator=D&billingZipCode=4331&shippingDate=12-May-2015&checkSumPayment=fd63ab7f20d1176e6c996046a5322aed66405321a9b0263084d7f40dcdb5f55b&taxAmount=1&hierarchyCriteria=B2");
        String URL = AddToCart_pg1.init(t1).frameURL();
        System.out.println(URL);

        String[] split = URL.split("=");
        String[] s = split[2].split("&");
        String amt = s[0];
        String[] s1 = split[3].split("&");
        String cur = s1[0];

        AddToCart_pg1.init(pNode)
                .frame();
//        WalletInfo_pg.init(t1)
//                .clickOnWallet();

        if (URL.contains("transactionAmount="+amt) && URL.contains("currency="+cur)){
            t1.pass("when the hosted payment page is called, currency= "+cur+" and amount of transaction= "+amt+" is present in the request parameter(URL)");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("when the hosted payment page is called, currency= "+cur+" and amount of transaction= "+amt+" is not present in the request parameter(URL)");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
    }
}
