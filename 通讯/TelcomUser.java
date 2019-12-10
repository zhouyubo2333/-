import java.text.*;
import java.util.*;

public class TelcomUser {
     private String phoneNumber;
     private String callTo;
     private Vector communicationRecords;
     private HashMap singleRecord;
     //private LinkedHashMap singleRecord;
    private TreeMap treeMapCallToAndFee;
     public TelcomUser(String phoneNumber) {
    	 this.phoneNumber=phoneNumber;
    	 this.communicationRecords=new Vector();
    	 this.singleRecord=new HashMap();
    	 //this.singleRecord=new LinkedHashMap();
    	 this.treeMapCallToAndFee=new TreeMap();
    	 
     }
     void generateCommunicationRecord() {
    	 int recordNum=new Random().nextInt(10);
    	 for(int i = 0; i <= recordNum; i++) {
 			Calendar cal = Calendar.getInstance();
 			cal.add(Calendar.HOUR, - new Random().nextInt(10));
 			long timeStart = cal.getTimeInMillis();
 			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
 			this.callTo = getCallToPhoneNumber();
 			this.singleRecord.put("主叫", this.phoneNumber);
 			this.singleRecord.put("开始时间",simpleDateFormat.format(timeStart));
 			this.singleRecord.put("结束时间",simpleDateFormat.format(timeEnd));
 			this.singleRecord.put("被叫号码", this.callTo);
 			this.singleRecord.put("计费", this.accountFee(timeStart,timeEnd));
 			this.communicationRecords.add(this.singleRecord);
 			this.treeMapCallToAndFee.put(this.callTo, this.accountFee(timeStart, timeEnd));
 		}
     }
     private String getCallToPhoneNumber() {
 		return "1380372010" + String.valueOf(new Random().nextInt(10));
 	}
     private String accountFee(long timeStart, long timeEnd) {
 		double feePerMinute = 0.2;
 		int minutes = Math.round((timeEnd - timeStart)/60000);
 		double feeTotal = feePerMinute * minutes;
 		return String.format("%.4f", feeTotal);
 	}
     /*
     void printDetails() {
    	 Enumeration itRecord = this.communicationRecords.elements();
 		 while(itRecord.hasMoreElements()) {
 			System.out.println("---------"+"通话记录分割线"+"---------");
 			this.singleRecord = ((LinkedHashMap)itRecord.nextElement());
 			Set keySet = this.singleRecord.keySet();
 			Iterator itKey = keySet.iterator();
 			while(itKey.hasNext()) {
 				Object key = itKey.next();
 				Object value = this.singleRecord.get(key);
 				System.out.println(key+":"+value);
 			}
 		}
     }
     */
     void printDetails() {
    	 Iterator itRencords = this.communicationRecords.iterator();
    	 while(itRencords.hasNext()) {
    		 System.out.println("--------"+"通话记录"+"--------");
    		 this.singleRecord = ((HashMap)itRencords.next());
    		 Set entrySet = this.singleRecord.entrySet();
    		 Iterator itEntry = entrySet.iterator();
    		 while(itEntry.hasNext()){
    			 Map.Entry entry = (Map.Entry)itEntry.next();
    			 Object key = entry.getKey();
    			 Object value = entry.getValue();
    			 System.out.println(key+" : "+value);
    		 }
    	 }
     }
     void printCallToAndFee() {
    	 System.out.println("---"+"被叫号码"+" : "+"话费"+"---");
    	 Iterator it = this.treeMapCallToAndFee.entrySet().iterator();
    	 while(it.hasNext()) {
    		 Map.Entry entry=(Map.Entry)it.next();
    		 System.out.println(entry.getKey()+" : "+entry.getValue());
    	 }
     }
     
}
