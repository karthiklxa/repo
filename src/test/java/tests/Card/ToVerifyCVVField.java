package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.CvvValidation;
import framework.entity.PaymentCard;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.propertyManagement.MessageReader;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik.m on 6/11/2018.
 */
public class ToVerifyCVVField extends TestInit
{

    @Test(priority = 1)
    public void verifyingCVVWithOneDigit() throws Exception {
        ExtentTest t1 = pNode.createNode("ToVerifyCVVField", "ToVerifyCVVFieldAsOneDigit");
        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        CvvValidation cvv = DataFactory.getCvvFromAppData();

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentInfo_pg1.init(t1)
                .CardNum(crCard.cardNumber)
                .CardHolderName(crCard.userName)
                .expMonth(crCard.expiryMonth)
                .expYear(crCard.expiryYear)
                .cvv(cvv.cvv1)
                .saveCard(crCard.saveThisCard)
                .PayNowBtn();

        Thread.sleep(3000);
        List<String> win = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.switchTo().window(win.get(0));
//        String actualMessage = PaymentInfo_pg1.init(t1)
//                .errorMsg().getText();
        String actualMessage = driver.switchTo().alert().getText();

        if(actualMessage.contains(MessageReader.getMessage("payment.success",null))){
            t1.pass("CVV Num Should Be 3 Or 4 Digits Not 1");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else{
            t1.pass("CVV Num Is Valid");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
//        driver.close();
        driver.switchTo().alert().accept();
    }





    @Test(priority = 2)
    public void verifyingCVVWithTwoDigit() throws Exception {
        ExtentTest t1 = pNode.createNode("ToVerifyCVVField", "ToVerifyCVVFieldAsTwoDigit");
        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        CvvValidation cvv = DataFactory.getCvvFromAppData();

//        Login.init(t1)
//                .validLogin();
        List<String> win = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(win.get(0));

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentInfo_pg1.init(t1)
                .CardNum(crCard.cardNumber)
                .CardHolderName(crCard.userName)
                .expMonth(crCard.expiryMonth)
                .expYear(crCard.expiryYear)
                .cvv(cvv.cvv2)
                .saveCard(crCard.saveThisCard)
                .PayNowBtn();

        Thread.sleep(3000);
        List<String> win1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(win1.get(0));
        String actualMessage = driver.switchTo().alert().getText();
//        String actualMessage = PaymentInfo_pg1.init(t1)
//                .errorMsg().getText();

        if(actualMessage.contains(MessageReader.getMessage("payment.success",null))){
            t1.pass("CVV Num Should Be 3 Or 4 Digits Not 2");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else{
            t1.pass("CVV Num Is Valid");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        driver.switchTo().alert().accept();
//        driver.close();
    }


    @Test(priority = 3)
    public void verifyingCVVWithThreeDigit() throws Exception {
        ExtentTest t1 = pNode.createNode("ToVerifyCVVField", "ToVerifyCVVFieldAsThreeDigit");
        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        CvvValidation cvv = DataFactory.getCvvFromAppData();

//        Login.init(t1)
//                .validLogin();
        List<String> win = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(win.get(0));

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentInfo_pg1.init(t1)
                .CardNum(crCard.cardNumber)
                .CardHolderName(crCard.userName)
                .expMonth(crCard.expiryMonth)
                .expYear(crCard.expiryYear)
                .cvv(cvv.cvv3)
                .saveCard(crCard.saveThisCard)
                .PayNowBtn();

        Thread.sleep(3000);
        List<String> win1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(win1.get(0));
        String actualMessage = driver.switchTo().alert().getText();

        Thread.sleep(3000);

        if(actualMessage.contains(MessageReader.getMessage("payment.success",null))){
            t1.pass("Cvv Num Is Valid As 3 Digit");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else{
            t1.fail("CVV Num Is Invalid");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        driver.switchTo().alert().accept();
    }


    @Test(priority = 4)
    public void verifyingCVVWithFourDigit() throws Exception {
        ExtentTest t1 = pNode.createNode("ToVerifyCVVField", "ToVerifyCVVFieldAsFourDigit");
        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        CvvValidation cvv = DataFactory.getCvvFromAppData();

//        Login.init(t1)
//                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentInfo_pg1.init(t1)
                .CardNum(crCard.cardNumber)
                .CardHolderName(crCard.userName)
                .expMonth(crCard.expiryMonth)
                .expYear(crCard.expiryYear)
                .cvv(cvv.cvv4)
                .saveCard(crCard.saveThisCard)
                .PayNowBtn();

        Thread.sleep(3000);
        List<String> win = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.switchTo().window(win.get(0));
        String actualMessage = driver.switchTo().alert().getText();

        if(actualMessage.contains(MessageReader.getMessage("payment.success",null))){
            t1.pass("Cvv Num Is Valid As 4 Digit");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else{
            t1.fail("CVV Num Is Invalid");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        Thread.sleep(3000);

//        driver.close();
        driver.switchTo().alert().accept();
    }

}
