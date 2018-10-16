package framework.entity;

/**
 * Created by karthik.m on 6/14/2018.
 */
public class Wallet {
    public String autWalletCode;
    public String actionType;
    public boolean isThirdParty;

    public Wallet(String walletName, String isThirdParty,String actionType){
        this.autWalletCode = walletName;
        this.isThirdParty = (isThirdParty.equalsIgnoreCase("TRUE"))? true : false;
        this.actionType =  actionType;

    }
}
