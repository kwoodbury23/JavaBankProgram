// This class allows the user to choose which account
import java.util.Scanner;

public class BankMenu {

	public void initiate() {
	
	}
	
	// Have the user enter a choice of savings or checking account
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int userChoice;
        	  
        	  // Go to checking account
              System.out.println("1. Checking Account");

              // Go to Saving Account
              System.out.println("2. Savings Account");
              
              // Exit the program
              System.out.println("3. Exit");

              // Have the user enter an option
              System.out.print("Enter option: ");

              userChoice = in.nextInt();

              switch (userChoice) {
              
              case 1:
              getCheckingAccount();
              break;
              case 2:
              getSavingsAccount();
              break;
              case 3:
              getExit();
              }
        }
					// Go to Checking account program
    				public static void getCheckingAccount(){

                      CheckingAccount c = new CheckingAccount();
                      c.initiate();
    				}
                        
    				// Go to Savings account program
    				public static void getSavingsAccount(){

                      SavingsAccount s = new SavingsAccount();
                      s.initiate();
    				}
                	  
    				// Option to exit program
                    public static void getExit(){
                    	boolean quit = false;
                        quit = true;

                        while (!quit);

                        // While program quits, display that user is logged out
                        System.out.println("\nLogged out.");
                    }
	
}