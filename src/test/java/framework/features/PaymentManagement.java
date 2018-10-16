package framework.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import framework.entity.PaymentCard;
import framework.entity.User;
import framework.entity.Wallet;
import framework.entity.WrongCardNumValidation;
import framework.pageObjects.Card.PaymentInfo.PaymentInfo_pg1;
import framework.pageObjects.Wallet.PaymentInfo.WalletPaymentInfo_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.DataFactory;
import framework.util.dbManagement.GUIQueries;
import framework.util.globalConstants.Wallets;
import framework.util.propertyManagement.MessageReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.IOException;


/**
 * Created by karthik.m on 6/8/2018.
 */
public class PaymentManagement {
    private static ExtentTest pNode;

    public static PaymentManagement init(ExtentTest t1) {
        pNode = t1;
        return new PaymentManagement();
    }

    public void enterCardDetails(PaymentCard card, boolean saveCard) throws IOException {
        Markup m = MarkupHelper.createLabel("validCardDetails:", ExtentColor.TEAL);
        pNode.info(m);
        try {
            PaymentInfo_pg1.init(pNode)
                    .CardNum(card.cardNumber)
                    .CardHolderName(card.userName)
                    .expMonth(card.expiryMonth)
                    .expYear(card.expiryYear)
                    .cvv(card.cvv)
                    .saveCard(saveCard)
                    .PayNowBtn();
        } catch (Exception e) {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }

    public void enterInvalidCardNumber(WrongCardNumValidation card, boolean saveCard) throws IOException {
        Markup m = MarkupHelper.createLabel("InvalidCardNumber:", ExtentColor.TEAL);
        pNode.info(m);
        try {
            PaymentInfo_pg1.init(pNode)
                    .CardNum(card.cardNumber)
                    .CardHolderName(card.userName)
                    .expMonth(card.expiryMonth)
                    .expYear(card.expiryYear)
                    .cvv(card.cvv)
                    .saveCard(saveCard)
                    .PayNowBtn();
        } catch (Exception e) {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public String checkSavedCard() throws IOException {

        Markup m = MarkupHelper.createLabel("checkSavedCard:", ExtentColor.TEAL);
        pNode.info(m);
        try {
            WebElement list = PaymentInfo_pg1.init(pNode)
                    .savedCardList();
            return list.getText();
//            List<String> ls = new ArrayList<String>();

//            for(WebElement all : list){
//                String opt = all.getText();
//                ls.add(opt);
//
//            }
//            return ls;
        } catch (Exception e) {
            Assertion.raiseExceptionAndStop(e, pNode);
        }

        return null;
    }

    public void initiateWalletPayment(User user, Wallet wallet,String action ) throws Exception {
        Markup m = MarkupHelper.createLabel("initiateWalletPayment:", ExtentColor.TEAL);
        pNode.info(m);
        WalletPaymentInfo_pg page = WalletPaymentInfo_pg.init(pNode);
        try {
            page.clickOnWallet()
                    .selectWallet(wallet.autWalletCode)
                    .clickOnPayNowBtn();
            if (!wallet.isThirdParty) {

                page
                        .enterMobNumMP(user.msisdn)
                        .clickOnGenerateID();
            } else {
                page
                        .enterMobNumEC(user.msisdn)
                        .clickOnSubmitBtn();
            }

            String refNum = null;
            if (!wallet.isThirdParty) {
                refNum = page.getReferenceNum();
                if (refNum == null) {
                    pNode.fail("Failed to get the rrn");
                    Assert.fail("Failed to get the rrn");
                }
            } else if (wallet.autWalletCode.equalsIgnoreCase(Wallets.ECO_CASH)) {
                // TODO - this is not the exact expected behaviour, only for tetsing purpose
//                refNum = "EC" + DataFactory.getRandomNumberAsString(9);
                GUIQueries db = new GUIQueries();
                refNum = db.mcRRN();
            }
            user.setReferenceNum(refNum);

            if (ConfigInput.isAssert) {
                Assertion.assertEqual("0000", ApiManagement.init(pNode).verifyWalletPayment(action,user.msisdn, refNum), "Payment is Initiated", pNode);
                page.clickOnConfirmPaymentBtn1();
                Assertion.verifyActionMessageContain("payment.success.msg1", "Verify wallet payment is successful for user:" + user.loginId, pNode);

            }
        } catch (Exception e) {
            Assertion.raiseExceptionAndContinue(e, pNode);
        }
    }

    public void initiateWalletPayment1(User user, Wallet wallet) throws Exception {
        Markup m = MarkupHelper.createLabel("initiateWalletPayment:", ExtentColor.TEAL);
        pNode.info(m);
        WalletPaymentInfo_pg page = WalletPaymentInfo_pg.init(pNode);
        try {
            page.clickOnWallet()
                    .selectWallet(wallet.autWalletCode)
                    .clickOnPayNowBtn();
            if (!wallet.isThirdParty) {

                page
                        .enterMobNumMP(user.msisdn)
                        .clickOnGenerateID();
            } else {
                page
                        .enterMobNumEC(user.msisdn)
                        .clickOnSubmitBtn();
            }

            String refNum = null;
            if (!wallet.isThirdParty) {
                refNum = page.getReferenceNum();
                if (refNum == null) {
                    pNode.fail("Failed to get the rrn");
                    Assert.fail("Failed to get the rrn");
                }
            } else if (wallet.autWalletCode.equalsIgnoreCase(Wallets.ECO_CASH)) {
                // TODO - this is not the exact expected behaviour, only for tetsing purpose
//                refNum = "EC" + DataFactory.getRandomNumberAsString(9);
                GUIQueries db = new GUIQueries();
                refNum = db.mcRRN();
            }
            user.setReferenceNum(refNum);
        } catch (Exception e) {
            Assertion.raiseExceptionAndContinue(e, pNode);
        }
    }
}