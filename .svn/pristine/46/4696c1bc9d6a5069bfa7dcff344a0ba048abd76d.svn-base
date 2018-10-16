package framework.features;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import framework.pageObjects.Common.login.LoginPage_pg1;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.DriverFactory;

import java.io.IOException;

/**
 * Created by karthik.m on 6/5/2018.
 */
public class Login {
    private static ExtentTest pNode;

    public static Login init(ExtentTest t1) {
        pNode = t1;
        return new Login();
    }

    public void validLogin() throws IOException {

        Markup m = MarkupHelper.createLabel("validLogin:"+ ConfigInput.UserName, ExtentColor.TEAL);
        pNode.info(m);
        try {
            DriverFactory.getDriver().get(ConfigInput.URL);

            LoginPage_pg1.init(pNode)
                    .setUserName(ConfigInput.UserName)
                    .setPassword(ConfigInput.Password)
                    .clickLogin();

        } catch (Exception e) {
            Assertion.raiseExceptionAndStop(e, pNode);
        }


    }

}
