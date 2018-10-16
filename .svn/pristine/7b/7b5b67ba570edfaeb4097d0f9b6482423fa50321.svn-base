package framework.entity;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class PaymentCard {
    public String cardNumber, expiryMonth, expiryYear, cvv, userName;
    public boolean saveThisCard = false, isCredit = true, isDebit = true;

//    public PaymentCard(){
//        this.cardNumber = DataFactory.getRandomNumberAsString(9);
//        this.cvv = DataFactory.getRandomNumberAsString(3);
//        this.userName = "CU"+ DataFactory.getRandomNumberAsString(6);
//        this.expiryMonth = "8"; // todo should be current + 1
//        this.expiryYear = "2020"; // todo should be current + 1
//        this.saveThisCard = false;
//    }

    public PaymentCard(String userName, String cardnum, String expMonth, String expYear, String cvv, String isCredit, String isDebit){
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





    public void setCardNumber(String cardNum){
        this.cardNumber = cardNum;
    }

    public void setIsCreditCard(){
        this.isCredit = true;
    }

    public void setData(String param, String value){
         switch(param){
             case "cardNumber":
                 this.cardNumber = value;
                 break;
             case "cvv":
                 this.cvv = value;
                 break;
         }
    }
}
