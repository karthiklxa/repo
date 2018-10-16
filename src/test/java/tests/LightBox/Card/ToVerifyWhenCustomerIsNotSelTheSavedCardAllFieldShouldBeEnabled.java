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
public class ToVerifyWhenCustomerIsNotSelTheSavedCardAllFieldShouldBeEnabled extends TestInit {
    @Test
    public void Payment() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-20", "To Verify When Customer Is Not Selecting The Saved Card All Field Should Be Enabled");

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
        boolean card = CardInfo_pg.init(t1)
                .CardNumEnabled();
        boolean name = CardInfo_pg.init(t1)
                .CardNameEnable();
        String cardMsg = CardInfo_pg.init(t1)
                .errorMsgInvalidCard();
        Thread.sleep(2000);
//        CardInfo_pg.init(t1)
//                .okBtn();
//        Thread.sleep(2000);
        boolean month = CardInfo_pg.init(t1)
                .ExpDate();
//        boolean year = CardInfo_pg.init(t1)
//                .YearEnabled();
        boolean cvv = CardInfo_pg.init(t1)
                .CVVEnabled();


        if(name == true && card == true && month == true && cvv == true){
            t1.pass("When Customer Is Not Selecting The Saved Card All Field Are Enabled");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("When Customer Is Not Selecting The Saved Card All Field Are Disabled");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }


    }
}