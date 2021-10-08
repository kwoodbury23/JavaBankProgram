package application;

// This program allows a user to create an account and login
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// This program allows the user to create an account and login
public class Login extends Application {
private TextField tfUser  = new TextField();
private TextField tfPass = new TextField();
private TextField tfFullName = new TextField();
private Button btSetUser = new Button("Create Account");
private TextField tfUserName = new TextField();
private TextField tfPassWord = new TextField();
private Button btLogin = new Button("Login");
private Button btExit = new Button("Exit");

@Override // Override the start method in the Application class
 public void start(Stage primaryStage) {
//Create UI
GridPane gridPane = new GridPane();
gridPane.setHgap(5);
gridPane.setVgap(5);

// Place labels, buttons and text fields
gridPane.add(new Label("Create a new account"), 0, 0);
gridPane.add(new Label("Your full name:"), 0, 1);
gridPane.add(tfFullName, 1, 1);
gridPane.add(new Label("New username:"), 0, 2);
gridPane.add(tfUser, 1, 2);
gridPane.add(new Label("New password:"), 0, 3);
gridPane.add(tfPass, 1, 3);
gridPane.add(btSetUser, 0, 4);
gridPane.add(new Label("Enter username:"), 0, 5);
gridPane.add(tfUserName, 1, 5);
gridPane.add(new Label("Enter password:"), 0, 6);
gridPane.add(tfPassWord, 1, 6);
gridPane.add(btLogin, 0, 7);
gridPane.add(btExit, 1, 7);

//Set properties for UI
gridPane.setAlignment(Pos.CENTER);
tfUser.setAlignment(Pos.BOTTOM_RIGHT);
tfFullName.setAlignment(Pos.BOTTOM_RIGHT);
tfPass.setAlignment(Pos.BOTTOM_RIGHT);

// Set button actions
btSetUser.setOnAction(e -> createAccount());
btLogin.setOnAction(e -> verifyLogin());
btExit.setOnAction(e -> getExit());

//Create a scene and place it in the stage 
Scene scene = new Scene(gridPane, 400, 250);
// Set title
primaryStage.setTitle("ATM");
// Place the scene in the stage
primaryStage.setScene(scene); 
// Display the stage
primaryStage.show();

 }

	// Create an account
	private void createAccount() {
		// Verify that the fields are not empty
		
		 // If full name is missing display alert
		 if(tfFullName.getText().trim().isEmpty()){
		        Alert fail= new Alert(AlertType.INFORMATION);
		        fail.setHeaderText("Missing Information");
		        fail.setContentText("Please enter full name.");
		        fail.showAndWait();
		         
		 }
		 // If new username is missing display alert
		 else if(tfUser.getText().trim().isEmpty()){
			    Alert fail= new Alert(AlertType.INFORMATION);
				fail.setHeaderText("Missing Information");
				fail.setContentText("Please enter a username.");
				fail.showAndWait();
				
		 }
		 // If new password is missing display alert
		 else if(tfPass.getText().trim().isEmpty()){
			    Alert fail= new Alert(AlertType.INFORMATION);
				fail.setHeaderText("Missing Information");
				fail.setContentText("Please enter a password.");
				fail.showAndWait();

		 } 
		 // Display that account was created
		 else {
		
		// Display welcome alert
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Welcome!");
		alert.setHeaderText("You have successfully created your new account.");
		alert.setContentText("Please login to your new account.");
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
	}
}

	// Verify that the fields are not empty
	private void verifyLogin() {
		// If username is missing display alert
		 if(tfUserName.getText().trim().isEmpty()){
		        Alert fail= new Alert(AlertType.INFORMATION);
		        fail.setHeaderText("Missing Information");
		        fail.setContentText("Please enter username.");
		        fail.showAndWait();
		         
		 }
		 // If password is missing display alert
		 else if(tfPassWord.getText().trim().isEmpty()){
			    Alert fail= new Alert(AlertType.INFORMATION);
				fail.setHeaderText("Missing Information");
				fail.setContentText("Please enter password.");
				fail.showAndWait();
				
		 }
		 // Go to login
		 else {
			 logIn();
		 }
	}
	
	// Login to account
	private void logIn() {
		String username = (tfUserName.getText());
		String name = (tfUser.getText());
		String password = (tfPassWord.getText());
		String pass = (tfPass.getText());
		
		// Welcome if information is correct
	    if (username.equals(name) && password.equals(pass)) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Welcome!");
	    	alert.setHeaderText(null);
	    	alert.setContentText("You have logged in.");
	    	alert.showAndWait();
	    }

	    // If information does not match, display the reason
	    
	    // If usernames match, then password is incorrect
	    else if (username.equals(name)) {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Error");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Incorrect password!");
	    	alert.showAndWait();
	        
	    // If passwords match, then username is incorrect
	    } else if (password.equals(pass)) {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Error");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Incorrect username!");
	    	alert.showAndWait();
	        
	    // If both do not match, both are wrong
	    } else {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Error");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Incorrect username and password!");
	    	alert.showAndWait();
	        
	    }

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