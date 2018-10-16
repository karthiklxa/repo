package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import framework.entity.WrongCardNumValidation;
import framework.features.CartManagement;
import framework.features.Login;
import framework.features.PaymentManagement;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.util.common.Assertion;
import framework.util.common.DataFactory;
import framework.util.propertyManagement.MessageReader;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/10/2018.
 */
public class CustomerShouldGetErrorMessageWhenUserEntersWrongCredentials extends TestInit {
    @Test
    public void InvalidCardNumValidation() throws Exception
    {
        ExtentTest t1 = pNode.createNode("InvalidCardNumber", "InvalidCardNumber");

        WrongCardNumValidation crCard = DataFactory.getCreditCardFromAppData1();
        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        PaymentManagement.init(t1)
                .enterInvalidCardNumber(crCard, true);
        Thread.sleep(3000);
        String msg = PaymentInfo_pg1.init(t1)
                .errorMsg().getText();

        Thread.sleep(3000);
        Assertion.verifyContains(msg, MessageReader.getMessage("error.msg.for.emepty.fields", null), "Should Throw Error Msg When The Fields Are Empty",t1, true);
    }
}
