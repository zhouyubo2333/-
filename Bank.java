package bank;

import java.util.Scanner;
public class Bank {
    int account;
    private static User user = new User();
    public int show(){
        System.out.println("欢迎来到网上银行！");
        System.out.println("请输入您要进行的操作：1.登录 2.注册");
        Scanner input = new Scanner(System.in);
        int x=input.nextInt();
        String st = input.nextLine();
        return x;
    }
    public void register(){
        DBUtils dbUtil = DBUtils.getInstance();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入此卡所要预留手机号:");
        String call = input.nextLine();
        user.setCall(call);
        System.out.println("请输入您要注册的用户名:");
        String userName = input.nextLine();
        user.setUserName(userName);
        System.out.println("请输入您要注册的卡号:");
        String ID = input.nextLine();
        user.setCardId(ID);
        System.out.println("请输入您的密码:");
        String Pwd = input.nextLine();
        user.setCardPwd(Pwd);
        user.setAccount(0);
        try {
            dbUtil.setUsers(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void login(){
        System.out.println("欢迎来到网上银行！");
        DBUtils dbUtil = DBUtils.getInstance();
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("请输入您的卡号:");
            String ID = input.nextLine();
            System.out.println("请输入您的密码:");
            String Pwd = input.nextLine();
            user = dbUtil.getUser(ID);
            if(dbUtil.getUsers().containsKey(ID)&&user.getCardPwd().equals(Pwd)){
                System.out.println("登录成功!欢迎"+user.getUserName()+"先生");
                break;
            }  else {
                System.out.println("卡号或密码输入错误,请重新输入!");
            }

        }
    }
    public void operate(){
        //1.存款
        //2.取款
        //3.余额
        //4.退出
        Bank b = new Bank();
        while(true){
            System.out.println("请输入您要进行的操作(输入序号)，按回车结束");
            System.out.println("1.存款");
            System.out.println("2.取款");
            System.out.println("3.查询余额");
            System.out.println("4.退出");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            if("1".equals(s)||"2".equals(s)){
                int num = 0;
                try {
                    System.out.print("请输入存取的金额:");
                    num = Integer.parseInt(input.nextLine());
                }catch (Exception e){
                    System.out.println("输入的金额有误！");
                    continue;
                }
                switch (s){
                    case "1":
                        b.incomeMoney(num);
                        break;
                    case "2":
                        b.takeoutMoney(num);
                        break;
                }
            } else if("3".equals(s)){
                b.showMoney();
            }else if ("4".equals(s)){
                System.out.println("退出系统!");
                return;
            }else{
                System.out.println("请输入有效操作序号！");
            }
        }
    }
    public void incomeMoney(int num){
        //存钱
        account = user.getAccount()+num;
        user.setAccount(account);
        System.out.println("成功存入"+num+"元至此卡："+user.getCardId());
        this.showMoney();
    }
    public void takeoutMoney(int num){
        //取款
        if(user.getAccount() >= num){
            account = user.getAccount() - num;
            user.setAccount(account);
            System.out.println("成功取出"+num+"元从此卡："+user.getCardId());
            this.showMoney();
        }
    }
    public void showMoney(){
        //see 余额
        System.out.println("您的卡号为:"+user.getCardId()+"的银行卡余额为:"+user.getAccount());
    }
    public static void main(String[] args)throws Exception {
        Bank b = new Bank();
        //b.login();
        switch (b.show()){
            case 1:
                b.login();
                break;
            case 2:
                b.register();
                System.out.println("注册成功！");
                break;
            default:
                System.out.println("cuowu");
        }
        b.operate();
    }
}