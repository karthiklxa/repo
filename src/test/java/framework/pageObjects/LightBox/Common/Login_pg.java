package framework.pageObjects.LightBox.Common;

import com.aventstack.extentreports.ExtentTest;
import framework.pageObjects.PageInit;
import framework.util.common.GenericMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by karthik.m on 6/26/2018.
 */
public class Login_pg extends PageInit {
    private static GenericMethods gM;


    @FindBy(id = "emailAddress")
    private WebElement Email;

    @FindBy(id = "mobileNumber")
    private WebElement MobNum;

    @FindBy(xpath = "//button[contains(text(),'LOGIN')]")
    private WebElement LoginBtn;

    @FindBy(id = "otp")
    private WebElement OTP;

    @FindBy(xpath = "//p[contains(text(),'LOGIN')]")
    private WebElement LoginBtn1;

    @FindBy(xpath = "//div[@class='merchant-name']")
    private WebElement MerchantName;

    @FindBy(xpath = "//a[contains(@href,'#cardType1')]")
    private WebElement DebitOrCredit;

    @FindBy(xpath = "//div[@class='amount']")
    private WebElement Amount;

    @FindBy(id = "errorMobile")
    private WebElement MobNumMSG;

    @FindBy(id = "errorEmail")
    private WebElement EmailMSG;

    @FindBy(xpath = "//div[@class='order-desc']")
    private WebElement ProductName;

    @FindBy(xpath = "//label[contains(.,'Please enter the OTP received to proceed')]")
    private WebElement OTPMSG;




    public Login_pg(ExtentTest t1) {
        super(t1);
    }

    public static Login_pg init(ExtentTest t1){return new Login_pg(t1);}

    public Login_pg email(String email) {
//        driver.switchTo().frame(0);
        setText(Email, email, "Login Email-ID");
        return this;
    }

    public boolean verifyEmail(){
        return Email.isDisplayed();
    }

    public Login_pg mobNum(String mobNum){
        setText(MobNum,mobNum,"Login Mobile Number");
        return this;
    }

    public boolean verifyMobNum(){
        return MobNum.isDisplayed();
    }

//    public Login_pg loginBtn(){
//        clickOnElement(LoginBtn,"Login Button");
//        return this;
//    }
    public Login_pg creditOrDebitLink(){
        clickOnElement(DebitOrCredit,"credit Or Debit Link");
        return this;
    }

    public Login_pg otp(String otp){
        setText(OTP,otp,"getting opt from DB");
        return this;
    }

    public boolean verifyOTP(){
        return OTP.isDisplayed();
    }

    public Login_pg loginBtn1(){
        clickOnElement(LoginBtn1,"Login Button");
        return this;
    }

    public boolean merchantName(){
        return MerchantName.isDisplayed();
    }

    public boolean creditOrDebit()
    {
        return DebitOrCredit.isDisplayed();
    }

    public boolean amount(){
        return Amount.isDisplayed();
    }

    public String mobNumMSG(){
        return MobNumMSG.getText();
    }

    public String emailMSG(){
        return EmailMSG.getText();
    }

    public boolean productName(){
        return ProductName.isDisplayed();
    }

    public String otpMsg(){
        return OTPMSG.getText();
    }


}
