package framework.pageObjects.Wallet.PaymentInfo;

import com.aventstack.extentreports.ExtentTest;
import framework.entity.User;
import framework.pageObjects.PageInit;
import framework.util.globalConstants.Wallets;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by karthik.m on 6/12/2018.
 */
public class WalletPaymentInfo_pg extends PageInit
{

    User user;

    @FindBy(xpath = "//a[contains(text(),'Wallet')]")
    private WebElement ClickOnWallet;

    @FindBy(id = "Ecocash")
    private WebElement ClickOnEcoCashRadiobtn;

    @FindBy(xpath = "//a[contains(text(),' Pay')]")
    private WebElement ClickOnPayNowBtn;

    @FindBy(id = "mobileNumberEC")
    private WebElement MobNumFieldEC;

    @FindBy(id = "mobileNumberMP")
    private WebElement MobNumFieldMP;

    @FindBy(id = "generateID")
    private WebElement ClickOnGenerateID;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    private WebElement ClickOnSubmitBtn;

    @FindBy(xpath = "//p[contains(text(),'Confirm Payment')]")
    private WebElement ClickOnConfirmPaymentBtn;

    @FindBy(xpath = "//a[contains(text(),'Confirm Payment')]")
    private WebElement ClickOnConfirmPaymentBtn1;

    @FindBy(xpath = "//h3[contains(text(),'Payment Successful')]")
    private WebElement PaymentSuccessMsg;

    @FindBy(xpath = "//h3[contains(text(),'Payment Failed')]")
    private WebElement PaymentFailureMsg;

    @FindBy(id = "Mpesa")
    private WebElement ClickOnMPesaRadiobtn;

    @FindBy(xpath = "//div[contains(text(),'missing or are incorrect')]")
    private WebElement ErrorMsg;

    @FindBy(xpath = "//h2[contains(text(),'MP')]")
    private WebElement RefID;

    @FindBy(xpath = "//p[contains(text(),' Please follow these steps to make the payment.')]")
    private WebElement TransactionMSG;



    public WalletPaymentInfo_pg(ExtentTest t1) {
        super(t1);
    }

    public static WalletPaymentInfo_pg init(ExtentTest t1){return new WalletPaymentInfo_pg(t1);}



    public WalletPaymentInfo_pg clickOnWallet(){
        clickOnElement(ClickOnWallet,"Click On Wallet Button");
        return this;
    }

    public WalletPaymentInfo_pg clickOnEcoCashRadiobtn(){
        clickOnElement(ClickOnEcoCashRadiobtn,"Click On Eco-Cash Radio Button");
        return this;
    }

    public WalletPaymentInfo_pg clickOnMpesaRadiobtn(){
        clickOnElement(ClickOnMPesaRadiobtn,"Click On M-Pesa Radio Button");
        return this;
    }
    public boolean clickOnEcoCashRadiobtnVerify(){
        clickOnElement(ClickOnEcoCashRadiobtn,"Click On Eco-Cash Radio Button");
        return ClickOnEcoCashRadiobtn.isSelected();
    }

    public boolean clickOnMpesaRadiobtnVerify(){
        clickOnElement(ClickOnMPesaRadiobtn,"Click On M-Pesa Radio Button");
        return ClickOnMPesaRadiobtn.isSelected();
    }


    public WalletPaymentInfo_pg selectWallet(String autWalletCode){
        if(autWalletCode.equalsIgnoreCase(Wallets.ECO_CASH)){
            clickOnElement(ClickOnEcoCashRadiobtn,"Click On Eco-Cash Radio Button");
        }else if(autWalletCode.equalsIgnoreCase(Wallets.M_PESA)){
            clickOnElement(ClickOnMPesaRadiobtn,"Click On M-Pesa Radio Button");
        }
        return this;
    }

    public WalletPaymentInfo_pg clickOnPayNowBtn() throws InterruptedException {
        clickOnElement(ClickOnPayNowBtn,"Click On Pay Now Botton");
        return this;
    }

    public WalletPaymentInfo_pg enterMobNumEC(String mobNum){
        setText(MobNumFieldEC,mobNum,"Enter Mobile Number");
        return this;
    }

    public WalletPaymentInfo_pg enterMobNumMP(String mobNum){
        setText(MobNumFieldMP,mobNum,"Enter Mobile Number");
        return this;
    }

    public WalletPaymentInfo_pg clickOnGenerateID(){
        clickOnElement(ClickOnGenerateID,"Click On Generate ID");
        return this;
    }

    public WalletPaymentInfo_pg clickOnSubmitBtn(){
        clickOnElement(ClickOnSubmitBtn,"Click On Submit Button");
        return this;
    }

    public String getReferenceNum(){
        return wait.until(ExpectedConditions.elementToBeClickable(RefID)).getText().trim();
    }

    public boolean verifyRefNum(){
        return RefID.isDisplayed();
    }

    public WalletPaymentInfo_pg clickOnConfirmPaymentBtn(){
        clickOnElement(ClickOnConfirmPaymentBtn,"Click On Confirm Payment Button");
        return this;
    }

    public WalletPaymentInfo_pg clickOnConfirmPaymentBtn1(){
        clickOnElement(ClickOnConfirmPaymentBtn1,"Click On Confirm Payment Button");
        return this;
    }

    public String paymentSuccessMsg()
    {
        return PaymentSuccessMsg.getText();
    }



    public Boolean wallet(){
        return ClickOnWallet.isDisplayed();
    }

    public Boolean ecoCashRadioBtn(){
        return ClickOnEcoCashRadiobtn.isDisplayed();
    }

    public Boolean mPesaRadioBtn(){
        return ClickOnMPesaRadiobtn.isDisplayed();
    }

    public String getErrorMsg(){
        return wait.until(ExpectedConditions.visibilityOf(ErrorMsg)).getText();
    }

    public String transactionMSG(){
        return TransactionMSG.getText();
    }

    public boolean mobNumFieldMPVerify(){
        return MobNumFieldMP.isEnabled();
    }

    public boolean generateIDVerify(){
        return ClickOnGenerateID.isEnabled();
    }


}
