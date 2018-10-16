package framework.pageObjects.Portal.MerchantPortalInfo;

import com.aventstack.extentreports.ExtentTest;
import framework.pageObjects.PageInit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by karthik.m on 7/16/2018.
 */
public class MerchantLogin_pg extends PageInit
{

    @FindBy(id = "userName")
    private WebElement UN;

    @FindBy(id = "password")
    private WebElement PWD;

    @FindBy(xpath = "//input[@class='button']")
    private WebElement LoginBtn;


    public MerchantLogin_pg(ExtentTest t1) {
        super(t1);
    }
    public static MerchantLogin_pg init(ExtentTest t1){return new MerchantLogin_pg(t1);}


    public MerchantLogin_pg setUserName(String un){
        setText(UN,un,"username");
        return this;
    }

    public MerchantLogin_pg setPassword(String pwd){
        setText(PWD,pwd,"password");
        return this;
    }

    public MerchantLogin_pg loginBtn(){
        clickOnElement(LoginBtn,"login button");
        return this;
    }


}
