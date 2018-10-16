package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.util.common.Assertion;
import framework.util.common.DataFactory;
import framework.util.dbManagement.GUIQueries;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik.m on 9/28/2018.
 */
public class ToVerifyTheCardType extends TestInit
{
    @Test
    public void cardType() throws Exception {
        ExtentTest t1 = pNode.createNode("ToVerifyTheCardType", "ToVerifyTheCardType");

        PaymentCard card = DataFactory.getCreditCardFromAppData();
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

        PaymentInfo_pg1.init(t1)
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

        PaymentInfo_pg1.init(t1)
                .CardHolderName(card.userName)
                .expMonth(card.expiryMonth)
                .expYear(card.expiryYear)
                .cvv(card.cvv)
                .saveCard(true)
                .PayNowBtn();

        Thread.sleep(3000);
        List<String> win = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(win.get(0));
        Thread.sleep(3000);
        String actualMessage = driver.switchTo().alert().getText();

        Assertion.verifyContains(actualMessage, MessageReader.getMessage("payment.success", null), "card payment successfully done through card in hosted page",t1, true);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }

}
