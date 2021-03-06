package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.features.PortalManagement.AdminPortalManagement;
import framework.util.common.DataFactory;
import framework.util.dbManagement.GUIQueries;
import org.testng.annotations.Test;
import tests.TestInit;



/**
 * Created by karthik.m on 6/26/2018.
 */
public class CardPaymentSuccessfullyDone_LB extends TestInit
{
    @Test
    public void Payment() throws Exception
    {
        ExtentTest t1 = pNode.createNode("PaymentSuccessfullyDone", "PaymentSuccessfullyDone");

        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        LightBoxManagement.init(t1)
                .loginToLightBox();

        LightBoxManagement.init(t1)
                .enterCardDetails(crCard,true);


    }
}



