package tests.LightBox.Wallet.Eco_Cash;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.pageObjects.LightBox.Wallet.WalletInfo_pg;
import framework.util.dbManagement.GUIQueries;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

import java.util.ArrayList;

/**
 * Created by karthik.m on 9/15/2018.
 */
public class ToVerifyTheWalletsOptionsLinkedWithTheirCurrencyCodeLB extends TestInit {
    @Test
    public void ToVerifyTheWalletsOptions() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1582-WA-Card-05", "To Verify The Wallets Options Linked With Their Currency Code");

        Login.init(t1)
                .validLogin();
        CartManagement.init(t1)
                .addDefaultItemToCart2();

        String URL = AddToCart_pg1.init(t1).frameURL();
        System.out.println(URL);

        String[] split = URL.split("=");
        String[] s = split[2].split("&");
        String amt = s[0];
        String[] s1 = split[3].split("&");
        String cur = s1[0];

        AddToCart_pg1.init(pNode)
                .frame();

        WalletInfo_pg.init(t1)
                .clickOnWallet();

        GUIQueries db = new GUIQueries();
        ArrayList<String> wallets = db.getWallets(cur);

        if(wallets !=null){
            t1.pass("Currency= "+cur+"have these wallet options="+wallets);
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else if (wallets == null){
            t1.pass("Currency= "+cur+"does not have any wallet option ");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("Problem in loading the wallet");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }

    }
}
