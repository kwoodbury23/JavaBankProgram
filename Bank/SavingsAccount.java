import java.util.Scanner;
// This class has a user complete an action in the savings account
public class SavingsAccount {
	
	public void initiate() {
		
	}
	
	// Have the user pick an option they want to do
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
			int userChoice;

				  // Deposit into savings account
			      System.out.println("1. Deposit");

			      // Withdrawal from savings account
			      System.out.println("2. Withdraw");

			      // Check balance of savings account
			      System.out.println("3. Check balance");
			      
			      // Exit the program
			      System.out.println("4. Exit");

			      // Have the user enter an option
			      System.out.print("\nEnter option: ");

			      userChoice = in.nextInt();

			      switch (userChoice) {
			      
			      case 1:
			      getDepositAmount();
			      break;
			      case 2:
			      getWithdrawalAmount();
			      break;
			      case 3:
			      getSavingsBalance();
			      case 4:
			      getExit();
			      break;
			      }
		}
        }
    			  // balance starts at zero
    			  static double balance = 0;
             
    			  // Deposits money into account
                  public static void getDepositAmount(){

                	    // Have the user enter a deposit amount
                        System.out.print("Deposit amount: ");
                        Scanner input = new Scanner(System.in);
                        double amount = input.nextDouble();

                        // Cannot deposit negative number
                        if (amount <= 0)

                             System.out.println("Can't deposit negative amount.");

                        // Displays how much was deposited
                        else {

                             balance += amount;

                             System.out.println("$" + amount + " has been deposited.");                          
                        }
                        main(null);
                  }
                  

                  // Withdraws money from account
                   public static void getWithdrawalAmount(){

                	    // Have the user enter a withdrawal amount
                        System.out.print("Withdrawal amount: ");
                        Scanner input = new Scanner(System.in);
                        double amount = input.nextDouble();

                        // Withdrawal cannot be negative or be more than balance
                        if (amount <= 0 || amount > balance)

                             System.out.println("Withdrawal can't be completed.");

                        // Displays how much was withdrawn
                        else {

                             balance -= amount;

                             System.out.println("$" + amount + " has been withdrawn.");
                        }
                        
                        main(null);
                        
                        }


                       // Displays the balance of the savings account
                       public static void getSavingsBalance(){

                        System.out.println("Your balance: $" + balance);
                        
                        main(null);
                       }
                       
                        // Exits the program and displays logged out
                        public static void getExit(){
                        boolean quit = false;
                        quit = true;
                        
                        // While program quits, display that user is logged out
                        while (!quit);

                        System.out.println("Logged out.");

                  }

      }