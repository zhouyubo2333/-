package bank;

import java.io.Serializable;

public class User implements Serializable {
    //此类就是用于表达一个用户
    private String call;//电话号码
    private int account;//余额
    private String userName;//用户名
    private String cardPwd;//密码
    private String cardId;//卡号
    public String getCall(){
        return call;
    }
    public void setCall(String telephonenum){
        System.out.println(telephonenum);
        this.call= telephonenum;
    }
    public int getAccount(){
        return account;
    }
    public void setAccount(int tmpAccount){
        this.account = tmpAccount;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String tmpUserName){
        this.userName = tmpUserName;
    }
    public String getCardPwd(){
        return cardPwd;
    }
    public void setCardPwd(String tmpCardPwd){
        this.cardPwd = tmpCardPwd;
    }
    public String getCardId(){
        return cardId;
    }
    public void setCardId(String tmpCardId){
        this.cardId = tmpCardId;
    }
}