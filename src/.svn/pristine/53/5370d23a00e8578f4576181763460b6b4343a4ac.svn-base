package framework.pageObjects.Portal.AdminPortalInfo;

import com.aventstack.extentreports.ExtentTest;
import framework.pageObjects.PageInit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by karthik.m on 8/28/2018.
 */
public class BOE_CCECreation_pg extends PageInit
{
    @FindBy(xpath = "//b[contains(text(),'USER MANAGEMENT')]" )
    private WebElement UserManagement;

    @FindBy(id = "partyTypeId")
    private WebElement UserType;

    @FindBy(id = "hid")
    private WebElement HID;

    @FindBy(id = "partyNamePrefixId")
    private WebElement NameSalvation;

    @FindBy(id = "firstName")
    private WebElement FirstName;

    @FindBy(id = "lastName")
    private WebElement LastName;

    @FindBy(id = "msisdnUser")
    private WebElement MSISDN;

    @FindBy(id = "email")
    private WebElement EmailID;

    @FindBy(id = "msisdnWeb")
    private WebElement LoginID;

    @FindBy(id = "prefLanguage")
    private WebElement PrefLang;

    @FindBy(id = "BoeRole55555")
    private WebElement RoleRodioBtn;

    @FindBy(id = "CceRole55555")
    private WebElement RoleRodioBtnCCE;

    @FindBy(id = "nextDiv")
    private WebElement NextBtn;

    @FindBy(id = "allowedFormTimeHour")
    private WebElement FromHour;

    @FindBy(id = "allowedFormTimeMin")
    private WebElement FromMin;

    @FindBy(id = "allowedToTimeHour")
    private WebElement ToHour;

    @FindBy(id = "allowedToTimeMin")
    private WebElement ToMin;

    @FindBy(xpath = "//div[@class='common_container style_submit_form_button_container form_button_container style_primary form_primary form_button_medium']")
    private WebElement NextBtn1;

    @FindBy(xpath = "//b[contains(text(),'CONTROL PANEL')]")
    private WebElement ControlPanel;

    @FindBy(xpath = "//a[.='Group Role Management']")
    private WebElement GroupRole;

    @FindBy(id = "catCode")
    private WebElement Category;

    @FindBy(id = "groupRoleCode")
    private WebElement GroupRoleCode;

    @FindBy(id = "groupRoleName")
    private WebElement GroupRoleName;

    @FindBy(id = "allCheck")
    private WebElement SelectRoles;

    @FindBy(id = "id_button_label_add")
    private WebElement AddBtn;

    @FindBy(xpath = "//span[contains(.,'group role has been added.')]")
    private WebElement GroupRoleSuccessMSG;

    @FindBy(xpath = "//span[contains(.,'User details for Mr. BOE 1 has been initialised and sent for approval.')]")
    private WebElement BoeAddedMSG;

    @FindBy(xpath = "//span[contains(.,'User details for Mr. CCE 1 has been initialised and sent for approval.')]")
    private WebElement CceAddedMSG;

    @FindBy(xpath = "//span[contains(.,'User details for Mr. Merchant Admin has been initialised and sent for approval.')]")
    private WebElement MAAddedMSG;

    @FindBy(xpath = "//a[contains(.,'Relogin')]")
    private WebElement ReloginLink;

    @FindBy(id = "id_tertiary_navigation_link_view_operator_user")
    private WebElement ApproveUser;

    @FindBy(name = "_partyTypeId")
    private WebElement CategoryType;

    @FindBy(name = "_msisdnWeb")
    private WebElement LoginIDApproval;

    @FindBy(id = "hidToApprove")
    private WebElement HIDApproval;

    @FindBy(xpath = "//td[.='Mr. BOE 1']/..//input")
    private WebElement SelBOERadio;

    @FindBy(xpath = "//td[.='Mr. CCE 1']/..//input")
    private WebElement SelCCERadio;

    @FindBy(xpath = "//td[.='Mr. Merchant Admin']/..//input")
    private WebElement SelHIDRadio;

    @FindBy(xpath = "//span[contains(.,'Operator User for Mr. BOE 1 has been approved Successfully')]")
    private WebElement ApproveUserSuccessMsgBOE;

    @FindBy(xpath = "//span[contains(.,'Operator User for Mr. CCE 1 has been approved Successfully')]")
    private WebElement ApproveUserSuccessMsgCCE;

    @FindBy(xpath = "//span[contains(.,'Operator User has been approved Successfully')]")
    private WebElement ApproveUserSuccessMsgHID;

    @FindBy(name = "oldPassword")
    private WebElement OldPwd;

    @FindBy(name = "newPassword")
    private WebElement NewPwd;

    @FindBy(name = "confirmNewPassword")
    private WebElement ConfirmPwd;

    @FindBy(xpath = "//span[contains(.,'Password changed successfully .')]")
    private WebElement PwdSuccessMsg;




    public BOE_CCECreation_pg(ExtentTest t1) {
        super(t1);
    }

    public static BOE_CCECreation_pg init(ExtentTest t1) {
        return new BOE_CCECreation_pg(t1);
    }




    public BOE_CCECreation_pg frame() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        return this;
    }

    public BOE_CCECreation_pg userType(String sysAdmin) throws InterruptedException {
        Thread.sleep(2000);
        selectVisibleText(UserType, sysAdmin, "User Type");
        return this;
    }

    public BOE_CCECreation_pg hid(String hid){
        selectVisibleText(HID,hid,"Select HID");
        return this;
    }

    public String hid1(){
            return HID.getAttribute("value");
    }

    public BOE_CCECreation_pg userManagement(){
        clickOnElement(UserManagement,"User Management");
        return this;
    }

    public BOE_CCECreation_pg nameSalvation(String salvation) {
        selectVisibleText(NameSalvation, salvation, "Name Salvation");
        return this;
    }

    public BOE_CCECreation_pg firstName(String fName) {
        setText(FirstName, fName, "First Name");
        return this;
    }

    public BOE_CCECreation_pg lastName(String lName) {
        setText(LastName, lName, "Last Name");
        return this;
    }

    public BOE_CCECreation_pg MSISDN(String num) {
        setText(MSISDN, num, "MSISDN");
        return this;
    }

    public BOE_CCECreation_pg emailID(String email) {
        setText(EmailID, email, "Email ID");
        return this;
    }

    public BOE_CCECreation_pg loginID(String ID) {
        setText(LoginID, ID, "User Login-ID For System Admin");
        return this;
    }

    public String sysID(){
        return LoginID.getAttribute("value");
    }

    public BOE_CCECreation_pg preLang(String PLang) throws InterruptedException {
        selectVisibleText(PrefLang, PLang, "Preferred Language");
        return this;
    }

    public BOE_CCECreation_pg roleRadioBOE(){
        clickOnElement(RoleRodioBtn,"Role Radio Button");
        return this;
    }

    public boolean boeRadioBtnIsDisplyed(){
        try{
            return RoleRodioBtn.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public BOE_CCECreation_pg roleRadioCCE(){
        clickOnElement(RoleRodioBtnCCE,"Role Radio Button");
        return this;
    }

    public boolean cceRoleIsDisplayed(){
        try{
            return RoleRodioBtnCCE.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public BOE_CCECreation_pg nextBtn() {
        clickOnElement(NextBtn, "Next Button");
        return this;
    }

    public BOE_CCECreation_pg fromHour(String FHour){
        setText(FromHour,FHour,"Allowed Form Time Hour");
        return this;
    }

    public BOE_CCECreation_pg fromMin(String FMin){
        setText(FromMin,FMin,"Allowed Form Time Min");
        return this;
    }

    public BOE_CCECreation_pg toHour(String THour){
        setText(ToHour,THour,"Allowed To Time Hour");
        return this;
    }

    public BOE_CCECreation_pg toMin(String TMin){
        setText(ToMin,TMin,"Allowed To Time Min");
        return this;
    }

    public BOE_CCECreation_pg confirmBtn() {
        clickOnElement(NextBtn1, "Add & Confirm Button");
        return this;
    }

    public BOE_CCECreation_pg controlPanel()
    {
        clickOnElement(ControlPanel,"Control Panel");
        return this;
    }

    public BOE_CCECreation_pg groupRole() throws InterruptedException {
        Thread.sleep(5000);
        clickOnElement(GroupRole,"Group Role Management");
        return this;
    }

    public BOE_CCECreation_pg category(String category){
        selectVisibleText(Category,category,"Category");
        return this;
    }

    public BOE_CCECreation_pg nextBtn1(){
        clickOnElement(NextBtn1,"Next Button");
        return this;
    }

    public BOE_CCECreation_pg groupRoleCode(String code){
        setText(GroupRoleCode,code,"Group Role Code");
        return this;
    }

    public BOE_CCECreation_pg groupRoleName(String name){
        setText(GroupRoleName,name,"Group Role Name");
        return this;
    }

    public BOE_CCECreation_pg selRoles(){
        clickOnElement(SelectRoles,"Select All Roles");
        return this;
    }

    public BOE_CCECreation_pg addBtn(){
        clickOnElement(NextBtn1,"Add Button");
        return this;
    }

    public String groupRoleSuccessMSG(){
        return GroupRoleSuccessMSG.getText();
    }

    public String boeAddedMSG(){
        return BoeAddedMSG.getText();
    }

    public String cceAddedMSG(){
        return CceAddedMSG.getText();
    }

    public String maAddedMSG(){
        return MAAddedMSG.getText();
    }

    public BOE_CCECreation_pg reloginLink(){
        clickOnElement(ReloginLink,"Re-login Link");
        return this;
    }

    public BOE_CCECreation_pg moveTo(){
        Actions act = new Actions(driver);
        act.moveToElement(UserManagement).perform();
        return this;
    }

    public BOE_CCECreation_pg approveUser(){
        clickOnElement(ApproveUser,"Approve User");
        return this;
    }

    public BOE_CCECreation_pg categoryType(String type){
        selectVisibleText(CategoryType,type,"Category Type");
        return this;
    }

    public BOE_CCECreation_pg loginIDApproval(String ID){
        setText(LoginIDApproval,ID,"Login-ID For Approval;");
        return this;
    }

    public BOE_CCECreation_pg hidApproval(String hid){
        setText(HIDApproval,hid,"HID For Approval");
        return this;
    }


    public BOE_CCECreation_pg submitBtn(){
        clickOnElement(NextBtn1,"Submit Button");
        return this;
    }

    public BOE_CCECreation_pg selBOE(){
        clickOnElement(SelBOERadio,"Select System Admin Radio Button");
        return this;
    }

    public BOE_CCECreation_pg selCCE(){
        clickOnElement(SelCCERadio,"Select System Admin Radio Button");
        return this;
    }

    public BOE_CCECreation_pg selHID(){
        clickOnElement(SelHIDRadio,"Select HID Radio Button");
        return this;
    }


    public BOE_CCECreation_pg approve(){
        clickOnElement(NextBtn1,"Approve Button");
        return this;
    }

    public String approveMSGBOE(){
        return ApproveUserSuccessMsgBOE.getText();
    }

    public String approveMSGCCE(){
        return ApproveUserSuccessMsgCCE.getText();
    }

    public String approveMSGHID(){
        return ApproveUserSuccessMsgHID.getText();
    }

    public BOE_CCECreation_pg oldPwd(String oldPwd){
        setText(OldPwd,oldPwd,"Old Password");
        return this;
    }

    public BOE_CCECreation_pg newPwd(String newPwd){
        setText(NewPwd,newPwd,"New Password");
        return this;
    }

    public BOE_CCECreation_pg confirmPwd(String confirmPwd){
        setText(ConfirmPwd,confirmPwd,"Confirm New Password");
        return this;
    }

    public BOE_CCECreation_pg submitBtn1(){
        clickOnElement(NextBtn1,"Submit Button For Password Change");
        return this;
    }

    public String pwdConfirmMsg(){
        return PwdSuccessMsg.getText();
    }




}