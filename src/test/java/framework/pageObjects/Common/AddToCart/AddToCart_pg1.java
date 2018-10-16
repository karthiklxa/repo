package framework.pageObjects.Common.AddToCart;

import com.aventstack.extentreports.ExtentTest;
import framework.pageObjects.PageInit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik.m on 6/6/2018.
 */
public class AddToCart_pg1 extends PageInit {

    @FindBy(xpath = "//img[contains(@src, 'shirt2.png')]")
    private WebElement defaultItem;

    @FindBy(xpath = "(//div[@align='center']//button[contains(text(),'ADD TO CART')])[2]")
    private WebElement AddToCartBtn;

    @FindBy(xpath = "//button[@class='loginsigninbutton' and @ng-click='cartSubmit()']")
    private WebElement CartBtn;

    @FindBy(xpath = "//button[contains(text(),'Proceed to checkout')]")
    private WebElement ProceedPayment;

    @FindBy(xpath = "//button[contains(text(),'Proceed to payment')]")
    private WebElement Payment;

    @FindBy(id = "cardTokens")
    private WebElement SelCard;

    @FindBy(xpath = "//a[@id='cardDeleteButton']")
    private WebElement ClickDeleteLink;

    @FindBy(id = "currAmountHeader")
    private WebElement CurrencyDetails;

    @FindBy(id = "currAmountPayButton")
    private WebElement PayBtn;

    @FindBy(id = "iFrameBox")
    private WebElement Frame;



    public AddToCart_pg1(ExtentTest t1) {
        super(t1);
    }

    public static AddToCart_pg1 init(ExtentTest t1) {
        return new AddToCart_pg1(t1);
    }


    public AddToCart_pg1 selDefaultItem(){
        clickOnElement(defaultItem,"Default Item, Shirt");
        return this;
    }
    public  AddToCart_pg1 addToCart() throws InterruptedException {
        Thread.sleep(3000);
        clickOnElement(AddToCartBtn,"AddToCartBtnCartBtn");
//        AddToCartBtn.click();
        return this;
    }
    public AddToCart_pg1 cartBtn(){
        clickOnElement(CartBtn,"Click_Cart_button");
        return this;
    }
    public AddToCart_pg1 proceedPayment(){
        clickOnElement(ProceedPayment,"Prooceed_to_payment");
        return this;
    }
    public AddToCart_pg1 payment(){
        clickOnElement(Payment,"payment_page");
        return this;
    }
    public AddToCart_pg1 navigateToPaymentPage(int index){
        List<String> win = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(win.get(index));
        return this;
    }
    public AddToCart_pg1 SelCard(){
        selectIndex(SelCard,1,"Select_Saved_Card");
        return this;
    }
    public AddToCart_pg1 clickDeleteLink(){
        clickOnElement(ClickDeleteLink,"Delete_Link");
        return this;
    }

    public int getSizeOfList(){
        Select sel = new Select(SelCard);
        List<WebElement> size = sel.getOptions();
        return size.size();
    }

    public AddToCart_pg1 frame(){
        driver.switchTo().frame(0);
        return this;
    }

    public String currencyDetails(){
        return CurrencyDetails.getText();
    }

    public String payBtn(){
        return PayBtn.getText();
    }

    public String frameURL(){
        return Frame.getAttribute("src");
    }

    public AddToCart_pg1 changeFrameURL(String url){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", Frame, "src", url);
        return this;
    }

}