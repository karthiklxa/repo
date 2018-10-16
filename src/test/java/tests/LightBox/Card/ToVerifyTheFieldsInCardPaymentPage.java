package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Card.CardInfo_pg;
import framework.util.reportManagement.ScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.TestInit;

import java.time.Year;

/**
 * Created by karthik.m on 6/28/2018.
 */
public class ToVerifyTheFieldsInCardPaymentPage extends TestInit
{
    @Test
public void verifyFields() throws Exception {
    ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-12", "To Verify The Fields In Card Payment Page");

    Login.init(t1)
            .validLogin();

    CartManagement.init(t1)
            .addDefaultItemToCart1();
        Thread.sleep(2000);
    LightBoxManagement.init(t1)
            .loginToLightBox();
        Thread.sleep(2000);
        boolean num = CardInfo_pg.init(t1)
            .verifyCardNum();
        boolean name = CardInfo_pg.init(t1)
            .verifyCardName();
        String cardMsg = CardInfo_pg.init(t1)
                .errorMsgInvalidCard();
        Thread.sleep(2000);
//        CardInfo_pg.init(t1)
//                .okBtn();
//        Thread.sleep(2000);
        boolean date = CardInfo_pg.init(t1)
            .verifyDate();
        Thread.sleep(2000);
//    boolean year = CardInfo_pg.init(t1)
//            .verifyYear();
    boolean cvv = CardInfo_pg.init(t1)
            .verifyCVV();
    boolean sCards = CardInfo_pg.init(t1)
            .verifySavedCards();

//    CardInfo_pg.init(pNode)
//            .CardHolderName(card.userName)
//            .CardNum(card.cardNumber)
//            .expMonth(02)
//            .expYear(card.expiryYear)
//            .cvv(card.cvv)
//            .saveCard(saveCard);



    if(name == true && num == true && date == true && cvv ==true && sCards == true){
        t1.pass("All The Mandatory Fields Required For Card Payment Is Displayed");
        t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
    }
    else {
        t1.fail("Mandatory Fields Are Missing");
        t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
    }

    }
}
