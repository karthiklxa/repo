package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Card.CardInfo_pg;
import framework.util.common.Assertion;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/29/2018.
 */
public class ToVerifyWhenEnteredValidOPTCardPageShouldBeDisplayed  extends TestInit
{@Test
public void Payment() throws Exception {
    ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-22", "To Verify When Entered Valid OPT Card Page Should Be Displayed");

    Login.init(t1)
            .validLogin();

    CartManagement.init(t1)
            .addDefaultItemToCart1();

    LightBoxManagement.init(t1)
            .loginToLightBox();

//    String cardMsg = CardInfo_pg.init(t1)
//            .cardPage();

//    Assertion.verifyContains(cardMsg, MessageReader.getMessage("card.page.validation",null),"Card Payment Page Is Displayed",t1);

    boolean card = CardInfo_pg.init(t1)
            .CardNumEnabled();

    if(card == true){
        t1.pass("Card Payment Page Is Displayed");
        t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
    }
    else {
        t1.fail("Card Payment Page Is Not Displayed");
        t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
    }


}

}