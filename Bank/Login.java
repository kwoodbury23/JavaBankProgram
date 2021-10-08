import java.util.Scanner;
// This class has the user create an account and login
public class Login  {

public static void main(String[] args) {
	// Have the user enter their full name
	Scanner input1 = new Scanner(System.in);
	System.out.print("Enter your full name: ");
	String fullName = input1.next();
	
	// Have the user enter a new username
	Scanner input2 = new Scanner(System.in);
	System.out.print("Enter a new username: ");
	String name = input2.next();

	// Have the user enter a new password
	Scanner input3 = new Scanner(System.in);
	System.out.print("Enter a new password: ");
	String pass = input3.next();
	
	// Display that the account was created
    System.out.println("\nWelcome! You have successfully created your new account.");
    
    // Display that user needs to login
    System.out.println("\nPlease login to your new account.");

    // Have the user enter the username
    Scanner input4 = new Scanner(System.in);
    System.out.println("\nEnter Username: ");
    String username = input4.next();
    
    // Have the user enter the password
    Scanner input5 = new Scanner(System.in);
    System.out.println("Enter Password: ");
    String password = input5.next();

    // Verify that information matches
    if (username.equals(name) && password.equals(pass)) {
    	getWelcome();
    }

    // If information does not match, display the reason
    else if (username.equals(name)) {
    	// If usernames match then password is wrong
        System.out.println("Incorrect password");
        getIncorrect();
    } else if (password.equals(pass)) {
    	// If passwords match then username is wrong
        System.out.println("Incorrect username");
        getIncorrect();
    } else {
    	// If both do not match then display both are incorrect
        System.out.println("Incorrect username and password");
        getIncorrect();
    }

}

	// Welcomes the user and gives option of menu or exit
	public static void getWelcome(){
		System.out.println("\nWelcome !");
        Scanner in = new Scanner(System.in);

        int userChoice;

        	  // Go to the menu
              System.out.println("\n1. Go to menu");

              // Exit the program
              System.out.println("2. Exit");

              // Have the user enter an option
              System.out.print("Enter option: ");

              userChoice = in.nextInt();

              switch (userChoice) {
              
              case 1:
              getBankMenu();
              break;
              case 2:
              getExit();
              }
}
	
	// Goes to bank menu
	public static void getBankMenu(){

        BankMenu b = new BankMenu();
        b.initiate();
		}
	
	// Displays that information is incorrect and they need to try again
	public static void getIncorrect(){
		// Try again is displayed if information is wrong
		System.out.println("Try Again");
		boolean quit = false;
		quit = true;
        
		// While program quits, display that user is logged out
        while (!quit);

        System.out.println("\nLogged out.");

}
	
	// Exits the program
    public static void getExit(){
    	boolean quit = false;
        quit = true;

        // While program quits, display that user is logged out
        while (!quit);

        System.out.println("\nLogged out.");
    }
}