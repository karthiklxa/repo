package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.PaymentManagement;
import framework.features.Login;
import framework.util.common.Assertion;
import framework.util.common.DataFactory;
import framework.util.propertyManagement.MessageReader;
import org.testng.annotations.Test;
import tests.TestInit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik.m on 6/8/2018.
 */
public class PaymentSuccessfullyDone extends TestInit
{
    @Test
    public void Payment() throws Exception
    {
        ExtentTest t1 = pNode.createNode("PaymentSuccessfullyDone", "PaymentSuccessfullyDone");

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

        Assertion.verifyContains(actualMessage, MessageReader.getMessage("payment.success", null), "card payment successfully done through card in hosted page",t1, true);
        Thread.sleep(3000);

//        if(actualMessage.contains(MessageReader.getMessage("payment.success",null)))
//            t1.pass("Payment successful");
//        else
//            t1.fail("payment unsuccessful");
        driver.switchTo().alert().accept();
    }
}
