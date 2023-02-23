package basic.atm;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean isLogin = false;
        Account account = null;
        
        //Displaying the main menu
        int option = 0;
        while (option == 0) {
            System.out.println("==== SELECT AN OPTION ====");
            System.out.println("1. Create an account");
            System.out.println("2. Sign in\n");
            
            while (option < 1 || option > 2) {
                System.out.println("Type your choice: ");
                
                option = scanner.nextInt();
            }
        }
        
        switch(option) {
            case 1: //Creating a new account
                System.out.println("\n\n=== CREATE NEW ACCOUNT ===\n");
                
                System.out.println("Enter first name:");
                
                String firstName = scanner.next();
                
                System.out.println("Enter last name:");
                
                String lastName = scanner.next();
                
                
                Account account = new Account(firstName, lastName);
                
                account.register();
                
                break;
                
            case 2: //Login to an existing account
                System.out.println("\n\n==== SIGN IN ====\n");
                
                System.out.println("Enter your card number: ");
                
                String cardNumber = scanner.next();
                
                System.out.println("Enter your pincode: ");
                
                String pincode = scanner.next();
                
                Operation operation = new Operation(cardNumber, pincode);
                
                //Checking that the user exists
                
                try {
                   Connection c = Database.connection();
                    
                   Statement stmt4 = c.createStatement();
                    
                   String sql4 = "SELECT * FROM card WHERE card_number = '" + cardNumber + "' AND pincode = '" + pincode + "'";
                    
                   ResultSet rs4 = stmt4.executeQuery(sql4);
                    
                   //Display the menu of the user who is logged in
                   if (rs4.next()) {
                       isLogin = true;
                        
                       System.out.println("\n\n==== LOGIN SUCCESS ====\n");
                        
                       System.out.println("--- Enter an option ---");
                        
                       System.out.println("1. Balance");
                       System.out.println("2. Deposit");
                       System.out.println("3. Send to other person");
                        
                       Integer option_user = 0;
                       
                       while (option_user < 1 || option_user > 3) {
                            System.out.println("\nType your choice: ");
                            
                            option_user = scanner.nextInt();
                        }
                        
                        Integer balance = 0;
        
        // Check if the login information is correct
                if (operation.validateLogin()) {
                    isLogin = true;
                    account = operation.getAccount();
                } else {
                    System.out.println("Invalid login information. Please try again.");
                }

                break;
        }

        if (isLogin) {
            int balance = (int) account.getBalance();
        

        // menu
        while (true) {
            System.out.println("Welcome to the ATM. What would you like to do?");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Exit");
            int amount = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + balance);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    int amount = scanner.nextInt();
                    if (amount > balance) {
                            System.out.println("Insufficient funds.");
                        } else {
                            account.withdraw(amount);
                            System.out.println("Withdrawn " + amount + ". Your new balance is " + account.getBalance());
                        }
                        break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    int deposit = scanner.nextInt();
                    account.deposit(deposit);
                        System.out.println("Deposited " + deposit + ". Your new balance is " + account.getBalance());
                        break;
                case 4:
                    account.save(); // Save the account information to the file
                        System.out.println("Thank you for using the ATM.");
                        System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

