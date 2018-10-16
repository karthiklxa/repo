package tests.Portal.AdminPortal;

import com.aventstack.extentreports.ExtentTest;
import framework.features.PortalManagement.AdminPortalManagement;
import framework.pageObjects.Portal.AdminPortalInfo.BOE_CCECreation_pg;
import framework.pageObjects.Portal.AdminPortalInfo.SystemAdminCreation_pg;
import framework.util.common.ConfigInput;
import framework.util.dbManagement.GUIQueries;
import framework.util.excelManagement.ExcelWriter;
import org.testng.annotations.Test;
import tests.TestInit;

import java.io.IOException;

/**
 * Created by karthik.m on 8/29/2018.
 */
public class BOE_CCE_MACreation extends TestInit
{
    @Test
    public void superLogin() throws Exception {
        ExtentTest t1 = pNode.createNode("Login as Super Admin", "Logging in as super admin to create system admin ");
        AdminPortalManagement.init(t1)
                .validLoginSuperAdmin();
        Thread.sleep(3000);
        SystemAdminCreation_pg.init(t1)
                .frame()
                .userType("System Admin");
//                .userManagement();
        boolean sysRadio = SystemAdminCreation_pg.init(t1).roleIsDisplayed();
        if (sysRadio==true){
            AdminPortalManagement.init(t1)
                    .systemAdminCreation();
        }
        else {
            AdminPortalManagement.init(t1)
                    .creatingGroupRolesForSysAdmin();
            AdminPortalManagement.init(t1)
                     .systemAdminCreation();
        }
        AdminPortalManagement.init(t1)
                .approveUser();
        AdminPortalManagement.init(t1)
                .SystemAdminPwdChange();




//        ExtentTest t2 = pNode.createNode("Login as System Admin", "Logging in as System admin to create CCE ");
//        AdminPortalManagement.init(t2)
//                .validLoginSysAdmin();
//        Thread.sleep(3000);
////        BOE_CCECreation_pg.init(t2)
////                .frame();
//        BOE_CCECreation_pg.init(t2)
//                .frame()
//                .userManagement()
//                .userType("CCE");
//        boolean cceRadio = BOE_CCECreation_pg.init(t2).cceRoleIsDisplayed();
//        if(cceRadio == true){
//            AdminPortalManagement.init(t2)
//                    .cceCreation();
//        }else {
//            AdminPortalManagement.init(t2)
//                    .creatingGroupRolesForCCE();
//            AdminPortalManagement.init(t2)
//                    .cceCreation();
//        }
//        AdminPortalManagement.init(t2)
//                .approveCCEUser();
//        AdminPortalManagement.init(t2)
//                .CCEPwdChange();
//
//
//
        ExtentTest t3 = pNode.createNode("Login as System Admin", "Logging in as System admin to create BOE ");
        AdminPortalManagement.init(t3)
                .validLoginSysAdmin();
        Thread.sleep(3000);
        BOE_CCECreation_pg.init(t3)
                .frame()
                .userManagement()
                .userType("Back Office Executive");
        boolean boeRadio = BOE_CCECreation_pg.init(t3).boeRadioBtnIsDisplyed();
        if(boeRadio == true){
            AdminPortalManagement.init(t3)
                    .boeCreation();
        }else {
            AdminPortalManagement.init(t3)
                    .creatingGroupRolesForBOE();
            AdminPortalManagement.init(t3)
                    .boeCreation();
        }
        AdminPortalManagement.init(t3)
                .approveBOEUser();
        AdminPortalManagement.init(t3)
                .BOEPwdChange();


        ExcelWriter.loginData();


        ExtentTest t4 = pNode.createNode("Login as System Admin", "Logging in as System admin to create Merchant Admin ");
        AdminPortalManagement.init(t4)
                .validLoginSysAdmin();
        Thread.sleep(3000);
        AdminPortalManagement.init(t4)
                .merchantAdminCreation();
        AdminPortalManagement.init(t4)
                .approveMA();
        AdminPortalManagement.init(t4)
                .hidCreation();

        GUIQueries db = new GUIQueries();
        db.getActCodeForHID(AdminPortalManagement.HID);


    }
}

