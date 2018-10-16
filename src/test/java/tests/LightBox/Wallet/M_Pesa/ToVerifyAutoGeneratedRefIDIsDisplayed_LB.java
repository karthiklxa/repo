package tests.LightBox.Wallet.M_Pesa;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.entity.User;
import framework.features.CartManagement;
import framework.features.LightBoxManagement;
import framework.features.Login;
import framework.pageObjects.LightBox.Wallet.WalletInfo_pg;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 6/18/2018.
 */
public class ToVerifyAutoGeneratedRefIDIsDisplayed_LB extends TestInit
{
    @Test
    public void toVerifyAutoGeneratedRefID() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-672-LB-wallet-MPesa-05", "To Verify Auto-Generated Reference-ID Is Displayed");
        User newUser = new User();

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart1();

//        LightBoxManagement.init(t1)
//                .loginToLightBox();

        WalletInfo_pg.init(t1)
                .clickOnWallet()
                .clickOnMpesaRadiobtn()
                .clickOnPayNowBtn()
                .enterMobNumMP(newUser.msisdn)
                .clickOnGenerateID();

        String refNum = WalletInfo_pg.init(t1)
                .getReferenceNum();

        boolean refNumDisplay = WalletInfo_pg.init(t1)
                .verifyRefNum();
        if(refNumDisplay == true)
        {
            t1.pass("Reference ID Is Displayed & ID is "+ refNum);
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

        }
        else {
            t1.fail("Reference ID Is Not Displayed");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

        }
    }

    }
