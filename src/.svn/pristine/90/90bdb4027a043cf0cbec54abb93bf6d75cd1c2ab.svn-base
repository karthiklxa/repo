package tests.Portal.MerchantPortal;

import com.aventstack.extentreports.ExtentTest;
import framework.features.PortalManagement.MerchantPortalManagement;
import framework.util.common.ConfigInput;
import org.testng.annotations.Test;
import tests.TestInit;

/**
 * Created by karthik.m on 7/16/2018.
 */
public class Login extends TestInit
{
    @Test
    public void login() throws Exception {
        ExtentTest t1 = pNode.createNode("Login", "Login to merchant portal with user: " + ConfigInput.merchantUN);
        MerchantPortalManagement.init(t1)
                .validLogin();


    }
}
