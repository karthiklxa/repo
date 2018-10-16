package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.Login;
import framework.features.PaymentManagement;
import framework.util.common.DataFactory;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik.m on 6/10/2018.
 */
public class ForFutureTransactionSaveCardDetails extends TestInit {
    @Test
    public void savedCardVerification() throws Exception {
        ExtentTest t1 = pNode.createNode("savedCardVerification", "CheckingSavedCardInSavedCardList");

        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentManagement.init(t1)
                .enterCardDetails(crCard, true);

        Thread.sleep(3000);
        List<String> win = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(win.get(0));
        Thread.sleep(3000);

        String actualMessage = driver.switchTo().alert().getText();

        if (actualMessage.contains(MessageReader.getMessage("payment.success", null))) {
            t1.pass("Payment successful");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

        else {
            t1.fail("payment unsuccessful");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

        driver.switchTo().alert().accept();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        String verify = PaymentManagement.init(t1)
                .checkSavedCard();
//        Assertion.verifyListContains(verify,"5454545454545454","SavedCardIsThereInList",t1);
        System.out.println(verify);
        if(verify.contains(MessageReader.getMessage("last.four.digit.of.saved.card",null))){
            t1.pass("SavedCardIsThereInList");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

        }
        else
        {
            t1.fail("SavedCardIsNotThereInList");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

        }
//        List<String> list = PaymentInfo_pg1.init(t1)
//                .savedCardList();
//        Assertion.verifyListContains(list,"5454","5454 is the card ending number",t1);


    }
}
