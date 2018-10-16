package framework.util.dbManagement;

import com.google.common.base.CharMatcher;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by karthik.m on 6/26/2018.
 */
public class GUIQueries
{
    private static OracleDB dbConn;
    GUIQueries gu;

    public GUIQueries() {
        dbConn = new OracleDB();
    }

    public static String getOTP(String mobNum) throws IOException {
        String outPutOtp = null;
//        final String query = "select TEXT from (SELECT * FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='ECOM_OTP_TEMPLATE' and TO_MOBILE_NUMBER ='"+mobNum+"' order by created_on_local desc) where rownum ='1'";
        final String query = "select TEXT FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='ECOM_OTP_TEMPLATE' and TO_MOBILE_NUMBER ='"+mobNum+"' order by created_on_local desc LIMIT 1";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                String otp = result.getString("TEXT");
                System.out.println(otp);
                outPutOtp = CharMatcher.is('-').or(CharMatcher.DIGIT).retainFrom(otp);            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return outPutOtp;
    }

    public static String mcRRN() throws IOException {
        String rrn = null;
        final String query = "select ref_transaction_id from mpos_transaction where mod_id='WALEC' order by created_on_local desc limit 1";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                String rrn1 = result.getString(1);
                System.out.println(rrn1);
                rrn=rrn1;
                           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return rrn;
    }

    public static String getOTPForSupAdmin(String mobNum) throws IOException {
        String outPutOtp = null;
//        final String query = "select TEXT from (SELECT * FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='ECOM_OTP_TEMPLATE' and TO_MOBILE_NUMBER ='"+mobNum+"' order by created_on_local desc) where rownum ='1'";
        final String query = "select TEXT FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='OTP_TEMPLATE' and TO_MOBILE_NUMBER ='"+mobNum+"' order by created_on_local desc LIMIT 1";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                String otp = result.getString("TEXT");
                System.out.println(otp);
                outPutOtp = CharMatcher.is('-').or(CharMatcher.DIGIT).retainFrom(otp);
                System.out.println(outPutOtp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return outPutOtp;
    }




    public static String getOTPForSysAdmin(String SysAdmin) throws IOException {
        String outPutOtp = null;
//        final String query = "select TEXT from (SELECT * FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='ECOM_OTP_TEMPLATE' and TO_MOBILE_NUMBER ='"+mobNum+"' order by created_on_local desc) where rownum ='1'";
//        final String query = "select TEXT FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='OTP_TEMPLATE' and TO_MOBILE_NUMBER ='"+mobNum+"' order by created_on_local desc LIMIT 1";
        final String query = "select TEXT FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='OTP_TEMPLATE' and text like ('%"+SysAdmin+"%') order by created_on_local desc LIMIT 1";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                String otp = result.getString("TEXT");
                System.out.println(otp);
                String[] split = otp.split(" ");
                String aa = split[9];
                outPutOtp = CharMatcher.is('-').or(CharMatcher.DIGIT).retainFrom(aa);
                System.out.println(outPutOtp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return outPutOtp;
    }

    
    
    
    

    public static String getPwdForSysAdmin(String SysAdmin) throws IOException {
        String outPutPwd = null;
//        final String query = "select TEXT from (SELECT * FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='ECOM_OTP_TEMPLATE' and TO_MOBILE_NUMBER ='"+mobNum+"' order by created_on_local desc) where rownum ='1'";
        final String query = "select EMAIL_BODY from EMAIL_QUEUE where EMAIL_BODY like ('%"+SysAdmin+" and Password: %') order by CREATED_ON_LOCAL desc";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                String otp = result.getString("EMAIL_BODY");
                System.out.println(otp);
                String[] outPut = otp.split(" ");
                outPutPwd = outPut[12];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return outPutPwd;
    }


    public static String getPwdForBOE(String SysAdmin) throws IOException {
        String outPutPwd = null;
//        final String query = "select TEXT from (SELECT * FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='ECOM_OTP_TEMPLATE' and TO_MOBILE_NUMBER ='"+mobNum+"' order by created_on_local desc) where rownum ='1'";
        final String query = "select EMAIL_BODY from EMAIL_QUEUE where EMAIL_BODY like ('%"+SysAdmin+" and Password: %') order by CREATED_ON_LOCAL desc";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                String otp = result.getString("EMAIL_BODY");
                System.out.println(otp);
                String[] outPut = otp.split(" ");
                outPutPwd = outPut[13];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return outPutPwd;
    }


    public static String getPwdForCCE(String SysAdmin) throws IOException {
        String outPutPwd = null;
//        final String query = "select TEXT from (SELECT * FROM BUSINESSTXN.SMS_QUEUE where sms_template_id='ECOM_OTP_TEMPLATE' and TO_MOBILE_NUMBER ='"+mobNum+"' order by created_on_local desc) where rownum ='1'";
        final String query = "select EMAIL_BODY from EMAIL_QUEUE where EMAIL_BODY like ('%"+SysAdmin+" and Password: %') order by CREATED_ON_LOCAL desc";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                String otp = result.getString("EMAIL_BODY");
                System.out.println(otp);
                String[] outPut = otp.split(" ");
                outPutPwd = outPut[11];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return outPutPwd;
    }

    public static void insertHID(String HID) {

        final String query = "INSERT INTO BUSINESSMASTER.ORG_HIERARCHY (HIERARCHY_ID, NAME, ADDRESS, CITY, MOBILE_NUMBER, EMAIL_ADDRESS, HIER_END_DATE, HIER_STATUS, CREATED_BY, CREATED_ON_LOCAL, CREATED_ON_LOCAL_TZ, CREATED_ON_GLOBAL, LAST_MODIFIED_ON_TZ, HIERARCHY_CRITERIA) VALUES ('"+HID+"', 'Automation', 'RMZ', 'Beng', 'Qeq2KofOIWK0dK+WPcZUgiY/NJ1VcYGic5vUzuaFcAg=" +
                "IA==', 'ngRmwzEnCuAuUBp1d5qFXxbNjlnFaWjBhwAvIO6+knjgozk/iOMCs8llYg+wAUB9IA==', TO_DATE('31-12-99', 'DD-MM-RR'), 'ACTIVE', 'COMVIVA', TO_DATE('11-07-18', 'DD-MM-RR'), 'India Standard Time', TO_DATE('11-07-18', 'DD-MM-RR'), 'UTC+5:30', 'B1')";
//        String commitQuery = "commit";
        try {

            ResultSet result = dbConn.RunUpdateQuery(query);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static String getActCodeForHID(String HID) throws IOException {
        String outPutACode = null;
        final String query = "select TEXT FROM BUSINESSTXN.SMS_QUEUE where TEXT like('%"+HID+"%') order by CREATED_ON_LOCAL desc";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                String otp = result.getString("TEXT");
                System.out.println(otp);
                String[] outPut = otp.split(":");
                String outPut1 = outPut[7];
                String[] output2 = outPut1.split(" ");
                String output3 = output2[1];
                outPutACode = CharMatcher.is('-').or(CharMatcher.DIGIT).retainFrom(output3);
                System.out.println("HID: "+outPutACode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return outPutACode;
    }



    public static String authorizationCode() throws IOException {
        String AccessToken = null;
        final String query = "select ACCESS_TOKEN from wso2_api_manager_apimgt.IDN_OAUTH2_ACCESS_TOKEN where grant_type = 'client_credentials' and CONSUMER_KEY_ID =(select ID from wso2_api_manager_apimgt.IDN_OAUTH_CONSUMER_APPS where username = 'admin' and APP_NAME like '%_MpgSdkApplication_SANDBOX')";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                AccessToken = result.getString("ACCESS_TOKEN");
                System.out.println(AccessToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return AccessToken;
    }


    public static ArrayList<String> getWallets(String currency) throws IOException {
        ArrayList<String> aa = new ArrayList<String>();;
        int count=0;
        final String query = "SELECT service_name FROM org_payment_services where currency_code='"+currency+"' and service_name in (SELECT service_name FROM payment_types WHERE payment_type='Wallet')";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                String Wallets = result.getString("service_name");
                aa.add(Wallets);
                System.out.println("Wallets= "+Wallets);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        System.out.println("no. of wallets "+count);
        return aa;
    }


    public static String cardType(String cardType) throws IOException {
        String CardType = null;
        final String query = "select service_name from BUSINESSMASTER.org_payment_services where service_name='"+cardType+"'";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                CardType = result.getString("service_name");
                System.out.println(CardType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return CardType;
    }



    public static String currencyCodeForCard(String cardType) throws IOException {
        String CardType = null;
        final String query = "select currency_code from BUSINESSMASTER.org_payment_services where service_name='"+cardType+"'";
        try {
            ResultSet result = dbConn.RunQuery(query);
            while (result.next()) {
                CardType = result.getString("currency_code");
                System.out.println(CardType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConn.CloseConnection();
        }
        return CardType;
    }




}
