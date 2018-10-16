package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.util.common.DataFactory;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/12/2018.
 */
public class VerifyCardSchemeLogoSpecificToTheCard extends TestInit{
    @Test
    public void verifyCardSchemeLogoSpecificToTheCard() throws Exception {
        ExtentTest t1 = pNode.createNode("VerifyCardSchemeLogo", "VerifyCardSchemeLogo");

        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentInfo_pg1.init(t1)
                .CardNum(crCard.cardNumber)
                .CardHolderName(crCard.userName)
                .expYear(crCard.expiryYear)
                .expMonth(crCard.expiryMonth)
                .cvv(crCard.cvv);
        Thread.sleep(2000);
        boolean image = PaymentInfo_pg1.init(t1)
                .cardCvvImage();
        PaymentInfo_pg1.init(t1).cvvImage();
        if(image==true){
            t1.pass("CVV Card Image Is Displayed");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else{
            t1.fail("CVV Card Image Is Not Displayed");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

    }
}
