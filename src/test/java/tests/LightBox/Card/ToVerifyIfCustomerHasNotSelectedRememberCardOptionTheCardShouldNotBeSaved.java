package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Card.CardInfo_pg;
import framework.pageObjects.PageInit;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.common.NegativedData;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

import java.util.ArrayList;

/**
 * Created by karthik.m on 7/2/2018.
 */
public class ToVerifyIfCustomerHasNotSelectedRememberCardOptionTheCardShouldNotBeSaved extends TestInit {
    @Test
    public void Payment() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-23", "To Verify If Customer Has Not Selected Remember Card Option The Card Should Not Be Saved");

        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        LightBoxManagement.init(t1)
                .loginToLightBox();

        PaymentCard card = DataFactory.getCreditCardFromAppData();
        try {
            CardInfo_pg.init(t1)
                    .CardHolderName(card.userName)      //5459648900740060
                    .CardNum(NegativedData.UnsavedCard)
                    .expDate("2424")
//                    .expYear(card.expiryYear)
                    .cvv(card.cvv)
                    .PayNowBtn();
            Thread.sleep(2000);
            String msg = CardInfo_pg.init(t1)
                    .successMsg();
            System.out.println(msg);

            Thread.sleep(2000);

            if (ConfigInput.isAssert){
                Assertion.verifyContains(msg, MessageReader.getMessage("payment.success.msg.card", null), "card payment successfully done through card in lightbox", t1, true);
                Thread.sleep(3000);
                CardInfo_pg.init(t1)
                        .okBtn();
            }

        } catch (Exception e) {
            Assertion.raiseExceptionAndStop(e, t1);
        }

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        LightBoxManagement.init(t1)
                .loginToLightBox();
        Thread.sleep(2000);

        String opt = CardInfo_pg.init(t1)
                .getOptionByPartialText("5459");
        Thread.sleep(2000);

        ArrayList<String> list = CardInfo_pg.init(t1)
                .listOfDropDown();

//        Assertion.verifyListContains(list,opt,"Unsaved Card Is Not There In The Saved List",t1);
        if(!list.contains(opt)){
            t1.pass("Unsaved Card Is Not There IN The List"+";is:  "+list+"card: "+NegativedData.UnsavedCard);
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else{
            t1.fail("Unsaved Card Is  There IN The List"+list+"card: "+NegativedData.UnsavedCard);
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }



    }
}