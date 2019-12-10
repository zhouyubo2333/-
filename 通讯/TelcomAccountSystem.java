
public class TelcomAccountSystem {
     public static void main(String[] args) {
    	 TelcomUser telcomUser = new TelcomUser("15937233517");
    	 
    	 telcomUser.generateCommunicationRecord();
    	 
    	 telcomUser.printDetails();
    	 telcomUser.printCallToAndFee();
     }
}
