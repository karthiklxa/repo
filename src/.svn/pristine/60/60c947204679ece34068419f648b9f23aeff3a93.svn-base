package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.Login;
import framework.features.PaymentManagement;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.util.common.DataFactory;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/10/2018.
 */
public class CustomerShouldBeAbleToEnterAllValuesInPaymentPage extends TestInit
{
    @Test
    public void checkingAllFeildsInPaymentPage() throws Exception
    {
        ExtentTest t1 = pNode.createNode("checkingAllFeildsInPaymentPage", "All The Fields In Payemnt Page");

        PaymentCard card = DataFactory.getCreditCardFromAppData();
        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentInfo_pg1.init(t1)
                .CardNum(card.cardNumber)
                .CardHolderName(card.userName)
                .expMonth(card.expiryMonth)
                .expYear(card.expiryYear)
                .cvv(card.cvv)
                .saveCard(true);

        boolean cardNum = PaymentInfo_pg1.init(t1).verifyCardNum();
        boolean cardName = PaymentInfo_pg1.init(t1).verifyCardName();
        boolean mm = PaymentInfo_pg1.init(t1).verifyExpMonth();
        boolean yy = PaymentInfo_pg1.init(t1).verifyExpYear();
        boolean cvv = PaymentInfo_pg1.init(t1).verifyCVV();
        boolean sCard = PaymentInfo_pg1.init(t1).verifySavedCard();

        if(cardNum == true && cardName == true && mm == true && yy == true && cvv ==true && sCard == true){
            t1.pass("All The Mandatory Fields Required For Card Payment Is Enabled");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Mandatory Fields Are Missing");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }



    }
}
