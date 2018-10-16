package framework.entity;

/**
 * Created by karthik.m on 6/10/2018.
 */
public class WrongCardNumValidation {
    public String cardNumber, expiryMonth, expiryYear, cvv, userName;
    public boolean saveThisCard = false, isCredit = true, isDebit = true;

    public WrongCardNumValidation(String userName, String cardnum, String expMonth, String expYear, String cvv, String isCredit, String isDebit){
//        if(expMonth.length() == 1){
//            expMonth = "0"+ expMonth;
//        }
        this.cardNumber = cardnum;
        this.cvv = cvv;
        this.userName = userName;
        this.expiryMonth = expMonth;
        this.expiryYear = expYear;
        this.saveThisCard = true;
        this.isCredit = (isCredit.equalsIgnoreCase("Y")) ? true : false;
        this.isDebit = (isDebit.equalsIgnoreCase("Y")) ? true : false;
    }
}
