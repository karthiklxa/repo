package tests.LightBox.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.PaymentCard;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 7/2/2018.
 */
public class ToVerifyForTheBrowserBackButtonWhenTheLighboxIsOpened extends TestInit
{
    @Test
    public void Payment() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-card-24", "To Verify For The Browser Back Button When The Lighbox Is Opened");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

        Thread.sleep(2000);

        driver.navigate().back();
        String title = driver.getTitle();

        if(title.equals(ConfigInput.title)){
            t1.pass("When Clicking On Back Button Login Page Is Displayed");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("When Clicking On Back Button Login Page Is Not Displayed");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }


    }

}
