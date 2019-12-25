package bank;

import java.io.*;
import java.util.HashMap;
public class DBUtils {
        //模拟数据库的一个工具
    private static DBUtils instance = null;
    private HashMap<String , User> users = new HashMap<String , User>();
    private DBUtils()throws Exception{
        FileInputStream fis = new FileInputStream("userData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        users= (HashMap<String, User>) ois.readObject();
        ois.close();
        fis.close();

//        User u1 = new User();
//        u1.setCall("15937298021");
//        u1.setCardId("0817184805071c1");
//        u1.setCardPwd("123456");
//        u1.setUserName("林凌志");
//        u1.setAccount(10000001);
//        users.put(u1.getCardId(),u1);
//
//        User u2 = new User();
//        u2.setCall("15038539718");
//        u2.setCardId("0817184805071c2");
//        u2.setCardPwd("123456");
//        u2.setUserName("林森");
//        u2.setAccount(10000082);
//        users.put(u2.getCardId(),u2);
//        User u3 = new User();
//        u3.setCall("13461091861		");
//        u3.setCardId("0817184805071c3");
//        u3.setCardPwd("123456");
//        u3.setUserName("林先生");
//        u3.setAccount(10000093);
//        users.put(u3.getCardId(),u3);
//        FileOutputStream fis = new FileOutputStream("userData.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fis);
//        oos.writeObject(users);
//        oos.close();
//        fis.close();
    }

    public static DBUtils getInstance(){
        if(instance == null){
            synchronized (DBUtils.class) {
                if (instance == null) {
                    try {
                        instance = new DBUtils();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
    public User getUser(String cardId){
        User user = (User) users.get(cardId);
        return user;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
    public void setUsers(User u)throws Exception{
        users.put(u.getCardId(),u);
        FileOutputStream fis = new FileOutputStream("userData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fis);
        oos.writeObject(users);
        oos.close();
        fis.close();
    }
}