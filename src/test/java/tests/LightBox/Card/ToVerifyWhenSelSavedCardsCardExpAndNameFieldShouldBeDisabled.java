package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Card.CardInfo_pg;
import framework.util.common.DataFactory;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/29/2018.
 */
public class ToVerifyWhenSelSavedCardsCardExpAndNameFieldShouldBeDisabled extends TestInit {
    @Test
    public void Payment() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-19", "To Verify When Selected Saved Cards Card Exp And Name Field Should Be Disabled");

        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        LightBoxManagement.init(t1)
                .loginToLightBox();
        LightBoxManagement.init(t1)
                .enterCardDetails(crCard, true);


        CartManagement.init(t1)
                .addDefaultItemToCart1();

        LightBoxManagement.init(t1)
                .loginToLightBox();

//        CardInfo_pg.init(t1)
//                .SelCard();
        Thread.sleep(2000);
        CardInfo_pg.init(t1)
                .selByPartialText("5454");

        boolean name = CardInfo_pg.init(t1)
                .CardNameEnable1();
        boolean card = CardInfo_pg.init(t1)
                .CardNumEnabled1();
        boolean date = CardInfo_pg.init(t1)
                .ExpDate1();
//        boolean month = CardInfo_pg.init(t1)
//                .MonthEnabled();
        boolean cvv = CardInfo_pg.init(t1)
                .CVVEnabled();


        if(name == false && card == false && date == false && cvv == true){
            t1.pass("When Selecting Saved Card From The List NameOfCard, CardNumber And ExpirationDate Get Disabled,CVV Field Should Be Enabled And Values Comes Automatically");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Saved Card Details Not Visible");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }


    }
}