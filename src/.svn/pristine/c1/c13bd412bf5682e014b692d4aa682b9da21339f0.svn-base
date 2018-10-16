package tests.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.dbManagement.GUIQueries;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

import java.util.ArrayList;

/**
 * Created by karthik.m on 9/14/2018.
 */
public class ToVerifyTheWalletsOptionsLinkedWithTheirCurrencyCode extends TestInit {
    @Test
    public void ToVerifyTheWalletsOptions() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1581-WA-Card-04", "To Verify The Wallets Options Linked With Their Currency Code");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

//        driver.get("http://172.19.7.229:1035/CNP/payModeAction_payment?customCss=http://172.19.7.229:1035/CART/css/customCss.css&transactionAmount=100&currency=USD&orderId=12345&userid=cnp&billingAddressLine1=USA1&billingAddressLine2=USA2&billingCountry=USA&billingState=New%20York&&billingCity=New%20York&mobile=4545454545&email=g@g.com&targetUrl=_parent&hid=automation&mid=74000274&tid=88000047&checkSum=e1029617db6a63faeea6c8aed9ad4421baa337f873e53c961f4e4f1a21578cd8&callbackurl=http://172.19.7.229:1035/CART/jsps/home.jsp&transactionType=sale&customerCode=1234&taxIncluded=Y&electronicGoodsIndicator=D&billingZipCode=4331&shippingDate=12-May-2015&checkSumPayment=fd63ab7f20d1176e6c996046a5322aed66405321a9b0263084d7f40dcdb5f55b&taxAmount=1&hierarchyCriteria=B2");

        WalletPaymentInfo_pg.init(t1)
                .clickOnWallet();

        String url = driver.getCurrentUrl();
        String[] split = url.split("=");
        String[] s = split[2].split("&");
        String amt = s[0];
        String[] s1 = split[3].split("&");
        String cur = s1[0];

        GUIQueries db = new GUIQueries();
        ArrayList<String> wallets = db.getWallets(cur);

        if(wallets !=null){
            t1.pass("Currency= "+cur+"these wallet options="+wallets);
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else if (wallets == null){
            t1.pass("Currency= "+cur+"does not have any wallet option ");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Problem in loading the wallet");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

    }

}
