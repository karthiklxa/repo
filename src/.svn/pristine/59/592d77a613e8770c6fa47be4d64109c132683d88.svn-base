package tests.LightBox.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Wallet.WalletInfo_pg;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/29/2018.
 */
public class ToVerifyMSISDNFieldIsDisplayed extends TestInit {
    @Test
    public void MSISDNFieldIsDisplayed() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-wallet-EcoCash-02", "To Verify MSISDN Field Is Displayed");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

//        LightBoxManagement.init(t1)
//                .loginToLightBox();
//        Thread.sleep(3000);

        WalletInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnEcoCashRadiobtn()
                .clickOnPayNowBtn();

        boolean mob = WalletInfo_pg.init(t1)
                .verifyMobNumEC();

        if(mob == true){
            t1.pass("MSISN Field For Eco Cash Is Displayed");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

        }
        else {
            t1.fail("MSISN Field For Eco Cash Is Not Displayed");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

        }
    }

