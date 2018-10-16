package tests.Card;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import framework.features.ApiManagement;
import framework.features.CartManagement;
import framework.features.Login;
import framework.pageObjects.Common.AddToCart.AddToCart_pg1;
import framework.util.Encryption.CurrencySymbol;
import framework.util.Encryption.EcnryptData;
import framework.util.Encryption.EncryptionUtils;
import framework.util.reportManagement.ScreenShot;
import org.testng.annotations.Test;
import tests.TestInit;

import java.util.Map;

/**
 * Created by karthik.m on 9/12/2018.
 */
public class ToVerifyAmtAndCurrInRequestParameterAndUI extends TestInit
{
    @Test
    public void toVerifyAmountAndCurrencyInURLAndRP() throws Exception {
        ExtentTest t1 = pNode.createNode("PAYPLUS-1581-CA-Card-02", "To Verify Amount And Currency In Request Parameter And In UI");

        Login.init(t1)
                .validLogin();

        CartManagement.init(t1)
                .addDefaultItemToCart();

        String url = driver.getCurrentUrl();
        String[] split = url.split("=");
        String[] s = split[2].split("&");
        String amt = s[0];
        String[] s1 = split[3].split("&");
        String cur = s1[0];

////        String en = "\"transactionCurrencyCode\":\"\'"+cur+"'";
//        String en = "{\"transactionCurrencyCode\":\""+cur+"\"}";
//        Map<String, Object> ww = EncryptionUtils.packetEncryption(en);
//        System.out.println("payloads= "+ww);
////        Object key = ww.get("decryptedKey");
//        byte[] randomRequestKey;
//        randomRequestKey = (byte[])ww.get("decryptedKey");
//        Object text = ww.get("payloadText");
//        String enText = text.toString();
//        Object var = ww.get("payloadVariable");
//        String iv = var.toString();
//
//        System.out.println("pp"+EncryptionUtils.packetDecryption(enText,randomRequestKey,iv));
//        String data = EcnryptData.aesEncryption(en);
//        System.out.println("en  "+EcnryptData.aesDecryption(data));
//        System.out.println(data);
//        String[] aa = data.split(":");
//        String[] var = aa[1].split(",");
//        String vari = var[0];
//        String variable = vari.substring(1, vari.length() - 1);
//        System.out.println("variable  "+variable);
//        String[] te = aa[2].split(",");
//        String tex = te[0];
//        String text = tex.substring(1, tex.length() - 1);
////        System.out.println("tex  "+tex);
//        System.out.println("text  "+text);
//        String[] to = aa[3].split(",");
//        String tok = to[0];
//        String token = tok.substring(1, tok.length() - 2);
////        System.out.println("tok  "+tok);
//        System.out.println("token  "+token);


        String en = "{\"transactionCurrencyCode\":\""+cur+"\"}";
        String data = EcnryptData.aesEncryption(en);
        String res = ApiManagement.init(t1).currencyCode(data);
        String code = EcnryptData.aesDecryption(res);
        System.out.println(code);
        String currencySymbol = CurrencySymbol.getCurrencySymbol(code);
        System.out.println("Currency Symbol  "+currencySymbol);

        String currencyDeatils = AddToCart_pg1.init(t1)
                .currencyDetails();

        if (currencyDeatils.contains(currencySymbol) && currencyDeatils.contains(amt) && url.contains("transactionAmount="+amt+"") && url.contains("currency="+cur+"")) {
            t1.pass("when the hosted payment page is called, currency and amount of transaction is present in the request parameter(URL) and the same is present in UI");
            t1.pass("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());
        }
        else {
            t1.fail("when the hosted payment page is called, currency and amount of transaction is not present in the request parameter(URL) the same is present in UI");
            t1.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.TakeScreenshot()).build());

        }
    }
}
