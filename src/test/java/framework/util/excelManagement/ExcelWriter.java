package framework.util.excelManagement;

import framework.features.PortalManagement.AdminPortalManagement;
import framework.util.common.ConfigInput;
import framework.util.globalConstants.FilePath;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;

import java.io.*;

/**
 * Created by karthik.m on 9/10/2018.
 */
public class ExcelWriter
{
    public static FileOutputStream fout;
    public static void loginData() throws Exception {

        File src = new File(FilePath.Login_Data);
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);
        sheet1.createRow(0).createCell(0).setCellValue("Users");
        sheet1.createRow(1).createCell(0).setCellValue("System Admin");
        sheet1.createRow(2).createCell(0).setCellValue("BOE");
        sheet1.createRow(3).createCell(0).setCellValue("CCe");
        sheet1.getRow(0).createCell(1).setCellValue("User Id");
        sheet1.getRow(0).createCell(2).setCellValue("Password");
        sheet1.getRow(1).createCell(1).setCellValue(AdminPortalManagement.SysAdminLoginID);
        sheet1.getRow(2).createCell(1).setCellValue(AdminPortalManagement.BOELoginID);
        sheet1.getRow(3).createCell(1).setCellValue(AdminPortalManagement.CCELoginID);
        sheet1.getRow(1).createCell(2).setCellValue(ConfigInput.newPassword);
        sheet1.getRow(2).createCell(2).setCellValue(ConfigInput.newPassword);
        sheet1.getRow(3).createCell(2).setCellValue(ConfigInput.newPassword);
        fout = new FileOutputStream(src);
        wb.write(fout);
        fout.close();


    }




}
