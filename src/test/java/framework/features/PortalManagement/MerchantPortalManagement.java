package framework.features.PortalManagement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import framework.pageObjects.Portal.MerchantPortalInfo.MerchantLogin_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;

import java.io.IOException;

/**
 * Created by karthik.m on 7/16/2018.
 */
public class MerchantPortalManagement
{
    private static ExtentTest pNode;

    public static MerchantPortalManagement init(ExtentTest t1) {
        pNode = t1;
        return new MerchantPortalManagement();
    }

    public void validLogin() throws IOException {
        Markup m = MarkupHelper.createLabel("validLogin:"+ ConfigInput.merchantUN, ExtentColor.TEAL);
        pNode.info(m);
        try {
            MerchantLogin_pg.init(pNode)
                    .setUserName(ConfigInput.merchantUN)
                    .setPassword(ConfigInput.merchantPWD)
                    .loginBtn();



        } catch (Exception e) {
            Assertion.raiseExceptionAndStop(e, pNode);
        }

    }
}
