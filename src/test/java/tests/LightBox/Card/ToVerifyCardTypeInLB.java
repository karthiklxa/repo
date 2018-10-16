package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.pageObjects.LightBox.Card.CardInfo_pg;
import framework.util.Encryption.CurrencySymbol;
import framework.util.Encryption.EcnryptData;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.dbManagement.GUIQueries;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 9/26/2018.
 */
public class ToVerifyCardTypeInLB extends TestInit {
    @Test
    public void cardType() throws Exception {
        ExtentTest t1 = pNode.createNode("ToVerifyCardTypeInLB", "To Verify Card Type In LB");

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

        AddToCart_pg1.init(t1)
                .frame();

        LightBoxManagement.init(t1)
                .loginToLightBox();

        PaymentCard card = DataFactory.getCreditCardFromAppData();
        CardInfo_pg.init(t1)
                .CardNum(card.cardNumber);
        GUIQueries db = new GUIQueries();
        String cardType = db.cardType("Mastercard");

        if (cardType.equals("Mastercard")){
            t1.pass("Card type exists and card type is :"+ cardType);
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Card type doesn't exsits");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

        String currencyCode = db.currencyCodeForCard("Mastercard");
        if(currencyCode.equals(cur)){
            t1.pass("card type :"+cardType+"and currency type :"+cur+ " is provisioned");
        }else {
            t1.fail("card type :"+cardType+"and currency type :"+cur+ " is not provisioned");
        }

        CardInfo_pg.init(t1)
                .CardHolderName(card.userName)
                .expDate("2424")
                .cvv(card.cvv)
                .saveCard(true)
                .PayNowBtn();

        Thread.sleep(2000);
        String msg = CardInfo_pg.init(t1)
                .successMsg();
        Thread.sleep(2000);
        System.out.println(msg);

        if (ConfigInput.isAssert){
            Assertion.verifyContains(msg, MessageReader.getMessage("payment.success.msg.card", null), "card payment successfully done through card in lightbox", t1, true);
            Thread.sleep(3000);
            CardInfo_pg.init(t1)
                    .okBtn();
        }









    }


}
