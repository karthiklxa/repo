package framework.util.common;

import framework.util.propertyManagement.PayPlusProperties;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class ConfigInput {
    public static String URL,URL1,UserName,Password,CardNum,Name,CVV,CVV1,CVV2,CVV3,CVV4,ValidMobileNumber,
            InValidMobileNumber, msisdnPrefix,BaseURI,BaseURIOracle,PostURL,ActiontypeAccept,email,mobileNum,
            title,merchantURL,merchantUN,merchantPWD,adminPortalURL,superAdminUN,superAdminPWD,groupRoleCode,
            newPassword,groupRoleCodeBoe,groupRoleCodeCce,PostURL1,BaseURI1;

    public static boolean isAssert = true;

    public static void init() {
        PayPlusProperties Me = PayPlusProperties.getInstance();
        URL = Me.getProperty("web.url");
        URL1 = Me.getProperty("web.url1");
        UserName = Me.getProperty("demoUser");
        Password = Me.getProperty("demoUserPwd");
        msisdnPrefix = Me.getProperty("msisdn.prefix");
        BaseURI=Me.getProperty("base.uri");
        BaseURI1=Me.getProperty("base.uri1");
        BaseURIOracle=Me.getProperty("base.uri.oracle");
        PostURL=Me.getProperty("post.url");
        PostURL1=Me.getProperty("post.url1");
        ActiontypeAccept = Me.getProperty("wallet.actiontype");
        email = Me.getProperty("demo.email");
        mobileNum = Me.getProperty("demo.mobile.num");
        title = Me.getProperty("title.name");


//        merchant portal details
        merchantURL = Me.getProperty("web.url.merchant");
        merchantUN = Me.getProperty("m.username");
        merchantPWD = Me.getProperty("m.password");

//        admin portal details
        adminPortalURL  =   Me.getProperty("web.url.admin");
        superAdminUN    =   Me.getProperty("web.superadmin.username");
        superAdminPWD   =   Me.getProperty("web.superadmin.password");
        groupRoleCode   =   Me.getProperty("group.role.code");
        groupRoleCodeBoe =   Me.getProperty("group.role.code.BOE");
        groupRoleCodeCce =   Me.getProperty("group.role.code.CCE");
        newPassword     =   Me.getProperty("new.password");





        // below is not required here
//        CardNum = Me.getProperty("cardNumber");
//        Name = Me.getProperty("name");
//        CVV = Me.getProperty("cvv");
//        CVV1=Me.getProperty("cvv.As1Digit");
//        CVV2=Me.getProperty("cvv.As2Digit");
//        CVV3=Me.getProperty("cvv.As3Digit");
//        CVV4=Me.getProperty("cvv.As4Digit");
//        ValidMobileNumber=Me.getProperty("valid.mobileNumber");
//        InValidMobileNumber=Me.getProperty("Invalid.mobileNumber");

    }

}
