package dianxin1;

import java.util.*;
import java.text.*;


public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private ArrayList communicationRecords;


	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new  ArrayList();
	}

// ģ��ͨ����¼������
	void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for (int i = 0; i <= recordNum; i++) {
			// this.phoneNumber=getCallToPhoneNumber();// ������ɵ�i��ͨ����¼
			// ��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			// ����ʱ�俪ʼ���ʮ�����������һ-��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			this.callTo = getCallToPhoneNumber();// ���к���
			// ����ͨ����¼
			this.communicationRecords
					.add(this.phoneNumber + "," + timeStart + "," + timeEnd + "," + this.callTo + ";");
		}

	}

	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10))
				+ String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10));
	}

	// ģ��ƷѰ취�����ַ�������ʽ���ر���3λС���ļƷѽ��
	private String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.2;
		int minutes = Math.round((timeEnd - timeStart) / 60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.3f", feeTotal);

	}

//��ӡͨ����¼
	void printDetails() {
		int arrayListSize=this.communicationRecords.size();
		DateFormat date = DateFormat.getDateInstance(DateFormat.FULL);
		SimpleDateFormat da = new SimpleDateFormat("E yyyy - MM - dd  hh:mm:ss ");
		for (int i = 0; i < arrayListSize-1; i++) {
			String[] recordField = ((String)this.communicationRecords.get(i)).split(",");
			// System.out.println(recordField.length);
			System.out.println("----------ͨ����¼�ָ���----------");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			System.out.println("ͨ����ʼʱ�䣺" + da.format(Long.parseLong(recordField[1])));
		
			// System.out.println(recordField[1]);
			System.out.println("ͨ������ʱ�䣺" + date.format(Long.parseLong(recordField[2])));
			System.out.println("�Ʒѣ�" + accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2])) + "Ԫ");
		}

	}

}
