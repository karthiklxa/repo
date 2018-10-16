package framework.features.PortalManagement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import framework.entity.User;
import framework.pageObjects.Portal.AdminPortalInfo.BOE_CCECreation_pg;
import framework.pageObjects.Portal.AdminPortalInfo.SuperAdminLogin_pg;
import framework.pageObjects.Portal.AdminPortalInfo.SystemAdminCreation_pg;
import framework.util.common.Assertion;
import framework.util.common.ConfigInput;
import framework.util.common.DateAndTime;
import framework.util.common.DriverFactory;
import framework.util.dbManagement.GUIQueries;
import framework.util.propertyManagement.MessageReader;

import java.io.IOException;

/**
 * Created by karthik.m on 8/23/2018.
 */
public class AdminPortalManagement
{
    private static ExtentTest pNode;
    public static String SysAdminLoginID;
    public static String BOELoginID;
    public static String CCELoginID;
    public static String HID;


    User u = new User();




    public static AdminPortalManagement init(ExtentTest t1)
    {
        pNode = t1;
        return new AdminPortalManagement();
    }

    public void validLoginSuperAdmin() throws IOException
    {
        Markup m = MarkupHelper.createLabel("valid Login For SuperAdmin:"+ ConfigInput.superAdminUN, ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            DriverFactory.getDriver().get(ConfigInput.adminPortalURL);
            SuperAdminLogin_pg.init(pNode)
                    .frame()
                    .superUn(ConfigInput.superAdminUN)
                    .superPwd(ConfigInput.superAdminPWD)
                    .superLoginBtn();
                    Thread.sleep(4000);
                    GUIQueries db = new GUIQueries();
                    String otp = db.getOTPForSupAdmin("9910208721");
                    SuperAdminLogin_pg.init(pNode)
                            .otp(otp)
                            .submitBtn();
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public void creatingGroupRolesForSysAdmin() throws IOException {
        Markup m = MarkupHelper.createLabel("Creating Group Roles", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            SystemAdminCreation_pg.init(pNode)
//                    .frame()
                    .controlPanel()
                    .groupRole()
                    .category("System Admin")
                    .nextBtn1()
                    .groupRoleCode(ConfigInput.groupRoleCode)
                    .groupRoleName(ConfigInput.groupRoleCode)
                    .selRoles()
                    .addBtn();
            String msg = SystemAdminCreation_pg.init(pNode).groupRoleSuccessMSG();

            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("group.role.added.successfully", null), "Group role added successfully", pNode, true);
            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }

    public void systemAdminCreation() throws IOException {
        Markup m = MarkupHelper.createLabel("System Admin Creation", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            SystemAdminCreation_pg.init(pNode)
//                    .frame()
                    .userManagement()
                    .userType("System Admin")
                    .bankName("ICICI")
                    .nameSalvation("Mr.")
                    .firstName("Sys")
                    .lastName("Admin1")
                    .MSISDN("91"+u.msisdn)
                    .emailID(ConfigInput.email)
                    .loginID("SysAdm"+ DateAndTime.getTimeStamp());
                    SysAdminLoginID = SystemAdminCreation_pg.init(pNode)
                            .sysID();
                    SystemAdminCreation_pg.init(pNode)
                    .preLang("English")
                    .roleRadio()
                    .fromHour("00")
                    .fromMin("00")
                    .toHour("11")
                    .toMin("59")
                    .nextBtn()
                    .confirmBtn()
                    .moveTo();
            System.out.println("login id"+SysAdminLoginID);


            String msg = SystemAdminCreation_pg.init(pNode).sysAdminAddedMSG();

            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("systemAdmin.added.successfully", null), " System Admin initialised and need approval.", pNode, true);
            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }

    }


    public void approveUser() throws IOException {
        Markup m = MarkupHelper.createLabel("Approve User", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            SystemAdminCreation_pg.init(pNode)
//                    .frame()
                    .approveUser()
//                    .categoryType("System Admin")
                    .loginIDApproval(SysAdminLoginID)
                    .submitBtn()
                    .selSysAdmin()
                    .submitBtn()
                    .approve();

            String msg = SystemAdminCreation_pg.init(pNode).approveMSG();


            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("approve.user.success.msg", null), " System Admin approved successfully", pNode, true);
            }
            SystemAdminCreation_pg.init(pNode)
                    .logoutLink();
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public void SystemAdminPwdChange() throws IOException {
        Markup m = MarkupHelper.createLabel("System Admin Login_Login-ID: "+SysAdminLoginID, ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            DriverFactory.getDriver().get(ConfigInput.adminPortalURL);

            SuperAdminLogin_pg.init(pNode)
                    .frame()
                    .superUn(SysAdminLoginID);

                     GUIQueries db = new GUIQueries();
                    String pwd = db.getPwdForSysAdmin(SysAdminLoginID);

            SuperAdminLogin_pg.init(pNode)
                    .superPwd(pwd)
                    .superLoginBtn();
            System.out.println(pwd);
            SystemAdminCreation_pg.init(pNode)
                    .oldPwd(pwd)
                    .newPwd(ConfigInput.newPassword)
                    .confirmPwd(ConfigInput.newPassword)
                    .submitBtn1();

            String msg = SystemAdminCreation_pg.init(pNode).pwdConfirmMsg();
            SystemAdminCreation_pg.init(pNode).reloginLink();

            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("change.password.success.msg", null), "Password Successfully Changed", pNode, true);
            }



        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }

    }




//    B O E    C R E A T I O N

    public void validLoginSysAdmin() throws IOException
    {
        Markup m = MarkupHelper.createLabel("valid Login For SuperAdmin:"+ ConfigInput.superAdminUN, ExtentColor.TEAL);
        pNode.info(m);
        try
        {
//            DriverFactory.getDriver().get(ConfigInput.adminPortalURL);
            SuperAdminLogin_pg.init(pNode)
//                    .frame()
                    .superUn(SysAdminLoginID)
                    .superPwd(ConfigInput.newPassword)
                    .superLoginBtn();
            Thread.sleep(4000);
            boolean otpVisi = SuperAdminLogin_pg.init(pNode).otpVisible();
            if(otpVisi == true){
                GUIQueries db = new GUIQueries();
                String otp = db.getOTPForSysAdmin(SysAdminLoginID);
                SuperAdminLogin_pg.init(pNode)
                        .otp(otp)
                        .submitBtn();
            }else {
                System.out.println("OTP is disabled");
            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public void creatingGroupRolesForBOE() throws IOException {
        Markup m = MarkupHelper.createLabel("Creating Group Roles", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            BOE_CCECreation_pg.init(pNode)
//                    .frame()
                    .controlPanel()
                    .groupRole()
                    .category("Back Office Executive")
                    .nextBtn1()
                    .groupRoleCode(ConfigInput.groupRoleCodeBoe)
                    .groupRoleName(ConfigInput.groupRoleCodeBoe)
                    .selRoles()
                    .addBtn();
            String msg = SystemAdminCreation_pg.init(pNode).groupRoleSuccessMSG();

            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("group.role.added.successfully.BOE", null), "Group role added successfully", pNode, true);
            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public void boeCreation() throws IOException {
        Markup m = MarkupHelper.createLabel("System Admin Creation", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            BOE_CCECreation_pg.init(pNode)
//                    .frame()
                    .userManagement()
                    .userType("Back Office Executive")
                    .nameSalvation("Mr.")
                    .firstName("BOE")
                    .lastName("1")
                    .MSISDN("91"+u.msisdn)
                    .emailID(ConfigInput.email)
                    .loginID("BOE"+ DateAndTime.getTimeStamp());
            BOELoginID = SystemAdminCreation_pg.init(pNode)
                    .sysID();
            BOE_CCECreation_pg.init(pNode)
                    .preLang("English")
                    .roleRadioBOE()
                    .fromHour("00")
                    .fromMin("00")
                    .toHour("11")
                    .toMin("59")
                    .nextBtn()
                    .confirmBtn()
                    .moveTo();
            System.out.println("login id"+BOELoginID);


            String msg = BOE_CCECreation_pg.init(pNode).boeAddedMSG();

            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("systemAdmin.added.successfully.BOE", null), " BOE initialised and need approval.", pNode, true);
            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }

    }


    public void approveBOEUser() throws IOException {
        Markup m = MarkupHelper.createLabel("Approve User", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            BOE_CCECreation_pg.init(pNode)
//                    .frame()
                    .approveUser()
//                    .categoryType("Back Office Executive")
                    .loginIDApproval(BOELoginID)
                    .submitBtn()
                    .selBOE()
                    .submitBtn()
                    .approve();

            String msg = BOE_CCECreation_pg.init(pNode).approveMSGBOE();


            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("approve.user.success.msg.BOE", null), " BOE approved successfully", pNode, true);
            }
            SystemAdminCreation_pg.init(pNode)
                    .logoutLink();
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public void BOEPwdChange() throws IOException {
        Markup m = MarkupHelper.createLabel("System Admin Login_Login-ID: "+SysAdminLoginID, ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            DriverFactory.getDriver().get(ConfigInput.adminPortalURL);

            SuperAdminLogin_pg.init(pNode)
                    .frame()
                    .superUn(BOELoginID);

            GUIQueries db = new GUIQueries();
            String pwd = db.getPwdForBOE(BOELoginID);

            SuperAdminLogin_pg.init(pNode)
                    .superPwd(pwd)
                    .superLoginBtn();
            System.out.println(pwd);
            BOE_CCECreation_pg.init(pNode)
                    .oldPwd(pwd)
                    .newPwd(ConfigInput.newPassword)
                    .confirmPwd(ConfigInput.newPassword)
                    .submitBtn1();

            String msg = SystemAdminCreation_pg.init(pNode).pwdConfirmMsg();
            SystemAdminCreation_pg.init(pNode).reloginLink();

            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("change.password.success.msg", null), "Password Successfully Changed", pNode, true);
            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }





//    C C E     C R E A T I O N


    public void creatingGroupRolesForCCE() throws IOException {
        Markup m = MarkupHelper.createLabel("Creating Group Roles", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            BOE_CCECreation_pg.init(pNode)
//                    .frame()
                    .controlPanel()
                    .groupRole()
                    .category("Customer Care Executive")
                    .nextBtn1()
                    .groupRoleCode(ConfigInput.groupRoleCodeCce)
                    .groupRoleName(ConfigInput.groupRoleCodeCce)
                    .selRoles()
                    .addBtn();
            String msg = SystemAdminCreation_pg.init(pNode).groupRoleSuccessMSG();

            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("group.role.added.successfully.CCE", null), "Group role added successfully", pNode, true);
            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public void cceCreation() throws IOException {
        Markup m = MarkupHelper.createLabel("System Admin Creation", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            BOE_CCECreation_pg.init(pNode)
//                    .frame()
                    .userManagement()
                    .userType("CCE")
//                    .bankName("IDFC")
                    .nameSalvation("Mr.")
                    .firstName("CCE")
                    .lastName("1")
                    .MSISDN("91"+u.msisdn)
                    .emailID(ConfigInput.email)
                    .loginID("CCE"+ DateAndTime.getTimeStamp());
            CCELoginID = SystemAdminCreation_pg.init(pNode)
                    .sysID();
            BOE_CCECreation_pg.init(pNode)
                    .preLang("English")
                    .roleRadioCCE()
                    .fromHour("00")
                    .fromMin("00")
                    .toHour("11")
                    .toMin("59")
                    .nextBtn()
                    .confirmBtn()
                    .moveTo();
            System.out.println("login id"+CCELoginID);


            String msg = BOE_CCECreation_pg.init(pNode).cceAddedMSG();

            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("systemAdmin.added.successfully.CCE", null), " CCE initialised and need approval.", pNode, true);
            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public void approveCCEUser() throws IOException {
        Markup m = MarkupHelper.createLabel("Approve User", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            BOE_CCECreation_pg.init(pNode)
//                    .frame()
                    .approveUser()
//                    .categoryType("Back Office Executive")
                    .loginIDApproval(CCELoginID)
                    .submitBtn()
                    .selCCE()
                    .submitBtn()
                    .approve();

            String msg = BOE_CCECreation_pg.init(pNode).approveMSGCCE();


            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("approve.user.success.msg.CCE", null), " CCE approved successfully", pNode, true);
            }
            SystemAdminCreation_pg.init(pNode)
                    .logoutLink();
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public void CCEPwdChange() throws IOException {
        Markup m = MarkupHelper.createLabel("System Admin Login_Login-ID: "+SysAdminLoginID, ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            DriverFactory.getDriver().get(ConfigInput.adminPortalURL);

            SuperAdminLogin_pg.init(pNode)
                    .frame()
                    .superUn(CCELoginID);

            GUIQueries db = new GUIQueries();
            String pwd = db.getPwdForCCE(CCELoginID);

            SuperAdminLogin_pg.init(pNode)
                    .superPwd(pwd)
                    .superLoginBtn();
            System.out.println(pwd);
            BOE_CCECreation_pg.init(pNode)
                    .oldPwd(pwd)
                    .newPwd(ConfigInput.newPassword)
                    .confirmPwd(ConfigInput.newPassword)
                    .submitBtn1();

            String msg = SystemAdminCreation_pg.init(pNode).pwdConfirmMsg();
            SystemAdminCreation_pg.init(pNode).reloginLink();

            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("change.password.success.msg", null), "Password Successfully Changed", pNode, true);
            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }





//    M E R C H A N T    A D M I N     C R E A T I O N
public void merchantAdminCreation() throws IOException {
    Markup m = MarkupHelper.createLabel("Merchant Admin Creation", ExtentColor.TEAL);
    pNode.info(m);
    try
    {
        HID = "HID"+u.HIDValue;

        GUIQueries db = new GUIQueries();
        db.insertHID(HID);
        BOE_CCECreation_pg.init(pNode)
                .frame()
                .userManagement()
                .userType("Merchant Admin")
                .hid(HID+" - Automation")
                .nameSalvation("Mr.")
                .firstName("Merchant")
                .lastName("Admin")
                .MSISDN("91"+u.msisdn)
                .emailID(ConfigInput.email)
                .preLang("English")
                .nextBtn()
                .confirmBtn()
                .moveTo();
        System.out.println("HID :"+HID);


        String msg = BOE_CCECreation_pg.init(pNode).maAddedMSG();

        if (ConfigInput.isAssert) {
            Assertion.verifyContains(msg, MessageReader.getMessage("systemAdmin.added.successfully.MA", null), " Merchant Admin initialised and need approval.", pNode, true);
        }
    }
    catch (Exception e)
    {
        Assertion.raiseExceptionAndStop(e, pNode);
    }
}


    public void approveMA() throws IOException {
        Markup m = MarkupHelper.createLabel("Approve User", ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            BOE_CCECreation_pg.init(pNode)
//                    .frame()
                    .approveUser()
                    .hidApproval(HID)
                    .submitBtn()
                    .selHID()
                    .submitBtn()
                    .approve();

            String msg = BOE_CCECreation_pg.init(pNode).approveMSGHID();


            if (ConfigInput.isAssert) {
                Assertion.verifyContains(msg, MessageReader.getMessage("approve.user.success.msg.HID", null), " CCE approved successfully", pNode, true);
            }
            SystemAdminCreation_pg.init(pNode)
                    .logoutLink();
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }


    public void hidCreation() throws IOException {
        Markup m = MarkupHelper.createLabel("System Admin Login_Login-ID: "+SysAdminLoginID, ExtentColor.TEAL);
        pNode.info(m);
        try
        {
            DriverFactory.getDriver().get(ConfigInput.merchantURL);

//            SuperAdminLogin_pg.init(pNode)
//                    .frame()
//                    .superUn(CCELoginID);
//
//            GUIQueries db = new GUIQueries();
//            String pwd = db.getPwdForCCE(CCELoginID);
//
//            SuperAdminLogin_pg.init(pNode)
//                    .superPwd(pwd)
//                    .superLoginBtn();
//            System.out.println(pwd);
//            BOE_CCECreation_pg.init(pNode)
//                    .oldPwd(pwd)
//                    .newPwd(ConfigInput.newPassword)
//                    .confirmPwd(ConfigInput.newPassword)
//                    .submitBtn1();
//
//            String msg = SystemAdminCreation_pg.init(pNode).pwdConfirmMsg();
//            SystemAdminCreation_pg.init(pNode).reloginLink();

//            if (ConfigInput.isAssert) {
//                Assertion.verifyContains(msg, MessageReader.getMessage("change.password.success.msg", null), "Password Successfully Changed", pNode, true);
//            }
        }
        catch (Exception e)
        {
            Assertion.raiseExceptionAndStop(e, pNode);
        }
    }
















}

