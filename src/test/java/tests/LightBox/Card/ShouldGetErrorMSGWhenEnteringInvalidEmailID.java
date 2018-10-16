package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Common.Login_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.NegativedData;
import framework.util.propertyManagement.MessageReader;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/28/2018.
 */
public class ShouldGetErrorMSGWhenEnteringInvalidEmailID extends TestInit {
    @Test
    public void verifyInvalidEmailID() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-6", "To Verify Error Message Is Displayed When Entering Invalid Email-ID");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        startNegativeTest(t1);
        Login_pg.init(t1)
                .mobNum(ConfigInput.mobileNum)
                .email(NegativedData.InvalidEmail)
                .creditOrDebitLink();
        String msg = Login_pg.init(t1)
                .emailMSG();

        Assertion.verifyContains( msg,MessageReader.getMessage("error.msg.for.invalid.email", null), "Error Message Is Displayed When Entering Invalid Email-ID", t1);

    }
}
