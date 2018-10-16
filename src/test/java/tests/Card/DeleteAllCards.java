package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.util.common.DataFactory;
import framework.util.propertyManagement.MessageReader;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/12/2018.
 */
public class DeleteAllCards extends TestInit {
    @Test(enabled = false)
    public void deleteCard() throws Exception {
        ExtentTest t1 = pNode.createNode("DeleteSavedCard", "verifying:DeleteSavedCard");

        PaymentCard crCard = DataFactory.getCreditCardFromAppData();
        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        int size = AddToCart_pg1.init(t1)
                .getSizeOfList();
        while (size!=0){
            CartManagement.init(t1)
                    .deleteCard();

            Thread.sleep(3000);
            String actualMessage1 = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

            String actualMessage2 = driver.switchTo().alert().getText();
            if(actualMessage2.contains(MessageReader.getMessage("card.deleted.success",null)))
                t1.pass("card deleted successful");
            else
                t1.fail("card deleted unsuccessful");
            Thread.sleep(3000);
            driver.switchTo().alert().accept();


        }
    }
}