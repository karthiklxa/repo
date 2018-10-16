package framework.util.common;

import framework.entity.CvvValidation;
import framework.entity.PaymentCard;
import framework.entity.Wallet;
import framework.entity.WrongCardNumValidation;
import framework.util.globalConstants.FilePath;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class DataFactory {


    public static void loadCards() throws IOException, InvalidFormatException {
        int currencySheet = 0;
        DataFormatter formatter = new DataFormatter();

        // * Read the Excel *
        List<PaymentCard> cardList = new ArrayList<>();
        InputStream inp = new FileInputStream(FilePath.FILE_CONFIG_INPUT);
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(currencySheet);

        /* get last used row */
        int lastRow = sheet.getLastRowNum();

        for (int i = 1; i < lastRow; i++) {
            String username = formatter.formatCellValue(sheet.getRow(i).getCell(0));
            if (username == "") {
                continue;
            }
            String cardNum = formatter.formatCellValue(sheet.getRow(i).getCell(1));
            String expiryMonth = formatter.formatCellValue(sheet.getRow(i).getCell(2));
            String expirtYear = formatter.formatCellValue(sheet.getRow(i).getCell(3));
            String cvv = formatter.formatCellValue(sheet.getRow(i).getCell(4));
            String isCredit = formatter.formatCellValue(sheet.getRow(i).getCell(5));
            String isDebit = formatter.formatCellValue(sheet.getRow(i).getCell(6));

            PaymentCard obj = new PaymentCard(username, cardNum, expiryMonth, expirtYear, cvv, isCredit, isDebit);

            cardList.add(obj);
        }
        GlobalData.paymentCards = cardList;
    }

    public static PaymentCard getCreditCardFromAppData() {
        for (PaymentCard card : GlobalData.paymentCards) {
            if (card.isCredit) {
                return card;
            }
        }
        return null;
    }

    public static PaymentCard getDebitCardFromAppData() {
        for (PaymentCard card : GlobalData.paymentCards) {
            if (card.isDebit) {
                return card;
            }
        }
        return null;
    }


    public static void loadCardForInvalidCardNumber() throws IOException, InvalidFormatException {
        int currencySheet = 2;
        DataFormatter formatter = new DataFormatter();

        // * Read the Excel *
        List<WrongCardNumValidation> cardList = new ArrayList<>();
        InputStream inp = new FileInputStream(FilePath.FILE_CONFIG_INPUT);
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(currencySheet);

        /* get last used row */
        int lastRow = sheet.getLastRowNum();

        for (int i = 1; i < lastRow; i++) {
            String username = formatter.formatCellValue(sheet.getRow(i).getCell(0));
            if (username == "") {
                continue;
            }
            String cardNum = formatter.formatCellValue(sheet.getRow(i).getCell(1));
            String expiryMonth = formatter.formatCellValue(sheet.getRow(i).getCell(2));
            String expirtYear = formatter.formatCellValue(sheet.getRow(i).getCell(3));
            String cvv = formatter.formatCellValue(sheet.getRow(i).getCell(4));
            String isCredit = formatter.formatCellValue(sheet.getRow(i).getCell(5));
            String isDebit = formatter.formatCellValue(sheet.getRow(i).getCell(6));

            WrongCardNumValidation obj = new WrongCardNumValidation(username, cardNum, expiryMonth, expirtYear, cvv, isCredit, isDebit);

            cardList.add(obj);
        }
        GlobalData.loadCardForInvalidCardNumber = cardList;
    }

    public static WrongCardNumValidation getCreditCardFromAppData1() {
        for (WrongCardNumValidation card : GlobalData.loadCardForInvalidCardNumber) {
            if (card.isCredit) {
                return card;
            }
        }
        return null;
    }

    public static void loadWallet() throws IOException, InvalidFormatException {
        int currencySheet = 1;
        DataFormatter formatter = new DataFormatter();

        // * Read the Excel *
        List<Wallet> walletList = new ArrayList<>();
        InputStream inp = new FileInputStream(FilePath.FILE_CONFIG_INPUT);
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(currencySheet);

        /* get last used row */
        int lastRow = sheet.getLastRowNum();

        for (int i = 1; i < lastRow; i++) {
            String autWalletCode = formatter.formatCellValue(sheet.getRow(i).getCell(0));
            if (autWalletCode == "") {
                continue;
            }
            String isThirdParty = formatter.formatCellValue(sheet.getRow(i).getCell(1));
            String actionType= formatter.formatCellValue(sheet.getRow(i).getCell(2));


            Wallet obj = new Wallet(autWalletCode, isThirdParty,actionType);

            walletList.add(obj);
        }
        GlobalData.wallets = walletList;
    }

    /**
     *
     * @param autWalletCode - eg MPESA
     * @return
     */
    public static Wallet getWalletFromAppData(String autWalletCode){
        for (Wallet wlt : GlobalData.wallets){
            if(wlt.autWalletCode.equalsIgnoreCase(autWalletCode)){
                return wlt;
            }
        }
        return null;
    }


    public static void getCvv() throws IOException, InvalidFormatException {
        int currencySheet = 3;
        DataFormatter formatter = new DataFormatter();

        // * Read the Excel *
        List<CvvValidation> cvvDigits = new ArrayList<>();
        InputStream inp = new FileInputStream(FilePath.FILE_CONFIG_INPUT);
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(currencySheet);

        /* get last used row */
        int lastRow = sheet.getLastRowNum();

        for (int i = 1; i < lastRow; i++) {
            String cvvAs1Digit = formatter.formatCellValue(sheet.getRow(i).getCell(0));
            if (cvvAs1Digit == "") {
                continue;
            }
            String cvvAs2Digit = formatter.formatCellValue(sheet.getRow(i).getCell(1));
            String cvvAs3Digit = formatter.formatCellValue(sheet.getRow(i).getCell(2));
            String cvvAs4Digit = formatter.formatCellValue(sheet.getRow(i).getCell(3));

            CvvValidation obj = new CvvValidation(cvvAs1Digit,cvvAs2Digit,cvvAs3Digit,cvvAs4Digit);

            cvvDigits.add(obj);
        }
        GlobalData.cvvDigits= cvvDigits;

    }

    public static CvvValidation getCvvFromAppData(){
        for (CvvValidation cvv : GlobalData.cvvDigits){
           return cvv;
        }
        return null;
    }



//        return null;
//    }


    /**
     * @return
     */


    public static String getRandomNumberAsString(int length) {
        return "" + getRandomNumber(length);
    }

    /**
     * Generate Random Number
     * TODO - move to generic File
     * TODO - move to generic File
     *
     * @param length
     * @return
     */
    public static int getRandomNumber(int length) {
        Random r = new Random(System.currentTimeMillis());
        switch (length) {
            case 2: {
                return r.nextInt(20 - 10 + 1) + 10;
            }
            case 3: {
                return r.nextInt(999 - 100 + 1) + 100;
            }
            case 4: {
                return r.nextInt(9999 - 1000 + 1) + 1000;
            }
            case 5: {
                return r.nextInt(99999 - 10000 + 1) + 10000;
            }
            case 6: {
                return r.nextInt(999999 - 100000 + 1) + 100000;
            }
            case 7: {
                return r.nextInt(9999999 - 1000000 + 1) + 1000000;
            }
            case 8: {
                return r.nextInt(99999999 - 10000000 + 1) + 10000000;
            }
            case 9: {
                return r.nextInt(999999999 - 100000000 + 1) + 100000000;
            }
        }
        return length;
    }

}
