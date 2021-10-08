package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// This class deposits and withdraws money from a savings account
public class SavingsAccount extends Application {
private TextField tfAmount = new TextField();
private TextField tfCurrentBalance = new TextField();
private Button btDeposit = new Button("Deposit");
private TextField tfSavingsBalance = new TextField();
private Button btExit = new Button("Exit");
private Button btWithdraw = new Button("Withdraw");
private Button btBalance = new Button("Balance");

 @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
// Create UI
GridPane gridPane = new GridPane();
gridPane.setHgap(5);
gridPane.setVgap(5);

// Place labels, buttons and text fields
gridPane.add(new Label("Savings Account"), 0, 0);
gridPane.add(new Label("Amount:"), 0, 2);
gridPane.add(tfAmount, 1, 2);
gridPane.add(new Label("Savings Account Balance:"), 0, 4);
gridPane.add(tfSavingsBalance, 1, 4);
gridPane.add(btDeposit, 0, 6);
gridPane.add(btWithdraw, 1, 6);
gridPane.add(btBalance, 2, 6);
gridPane.add(btExit, 2, 12);

// Set properties for UI
gridPane.setAlignment(Pos.CENTER);

// Set alignment and action
tfCurrentBalance.setAlignment(Pos.BOTTOM_RIGHT);
tfAmount.setAlignment(Pos.BOTTOM_RIGHT);
btDeposit.setOnAction(e -> getDepositValid());
btWithdraw.setOnAction(e -> getWithdrawalValid());
btBalance.setOnAction(e -> getBalance());
btExit.setOnAction(e -> getExit());

// Create a scene and place it in the stage 
Scene scene = new Scene(gridPane, 400, 250);
//Set title
primaryStage.setTitle("ATM");
//Place the scene in the stage
primaryStage.setScene(scene);
//Display the stage
primaryStage.show(); 
  }

 // Set balance
 static double balance = 0;
 
 // See if deposit amount is valid
  void getDepositValid(){
	// If the amount is missing display alert
   	if(tfAmount.getText().trim().isEmpty()){
 		Alert fail= new Alert(AlertType.INFORMATION);
 		fail.setHeaderText("Missing Information");
 		fail.setContentText("Please enter deposit amount.");
 		fail.showAndWait();
 }
   	else {
   		// Go to deposit
   		getDeposit();
   	}
 }
  
  // See if withdrawal amount is valid
  void getWithdrawalValid(){
	    // If amount is missing display alert
	   	if(tfAmount.getText().trim().isEmpty()){
	 		Alert fail= new Alert(AlertType.INFORMATION);
	 		fail.setHeaderText("Missing Information");
	 		fail.setContentText("Please enter withdrawal amount.");
	 		fail.showAndWait();
	 }
	   	else {
	   		// Go to withdrawal
	   		getWithdrawal();
	   	}
	 }
  
    // Make a deposit and get the balance
	private void getDeposit() {		
		double amount = Double.parseDouble(tfAmount.getText());
		// Check to see if number is not negative
		if (amount < 0) {
        	Alert fail= new Alert(AlertType.INFORMATION);
			fail.setHeaderText("Error");
			fail.setContentText("Can't deposit negative amount.");
			fail.showAndWait();
        }      
		// Get Balance
        else {
        	tfSavingsBalance.setText(String.format("$%.2f", 
        			((balance + amount))));
        	balance += amount;
        }
	}

	// Make a withdraw and get the balance
	private void getWithdrawal() {		
		double amount = Double.parseDouble(tfAmount.getText());   
		// Check to see if number is not negative
	     if (amount < 0) {
        	Alert fail= new Alert(AlertType.INFORMATION);
			fail.setHeaderText("Error");
			fail.setContentText("Can't deposit negative amount.");
			fail.showAndWait();
        }      
        // Make sure withdrawal does not exceed balance
        else if (amount > balance) {
        	Alert fail= new Alert(AlertType.INFORMATION);
			fail.setHeaderText("Error");
			fail.setContentText("Can't withdraw amount.");
			fail.showAndWait();
        }
        // Get balance
        else {
        	tfSavingsBalance.setText(String.format("$%.2f", 
        			((balance - amount))));
        	balance -= amount;
        }
	}
	
	// Display the balance
	private void getBalance() {

    	tfSavingsBalance.setText(String.format("$%.2f", 
    			((balance))));

	}
	
	// Exit the program
	private void getExit() {
		Platform.exit();
	}
	
// Launch the program
public static void main(String[] args) {
 launch(args);
 }
 }