package framework.util.common;

import framework.entity.CvvValidation;
import framework.entity.PaymentCard;
import framework.entity.Wallet;
import framework.entity.WrongCardNumValidation;

import java.util.List;

/**
 * Created by karthik.m on 6/8/2018.
 */
public class GlobalData {
    public static List<PaymentCard> paymentCards;
    public static List<Wallet> wallets;
    public static List<WrongCardNumValidation> loadCardForInvalidCardNumber;
    public static List<CvvValidation> cvvDigits;


}
