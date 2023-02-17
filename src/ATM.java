package basic.atm;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        
        public static boolean isLogin = false;
        
        //Displaying the main menu
        while (option == 0) {
            System.out.println("==== SELECT AN OPTION ====");
            System.out.println("1. Create an account");
            System.out.println("2. Sign in");
            
            while (option < 1 || option > 2) {
                System.out.println("Type your choice: ");
                
                option = scanner.nextInt();
            }
        }
        
        switch(option) {
            case 1: //Creating a new account
                System.out.println("\n\n=== CREATE NEW ACCOUNT ===\n");
                
                System.out.println("Enter first name:");
                
                String firstName = scanner.next().trim();
                
                System.out.println("Enter last name:");
                
                String lastName = scanner.next().trim();
                
                
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
        }
        
        Scanner input = new Scanner(System.in);
        int balance = 1000; // starting balance
        

        // menu
        while (true) {
            System.out.println("Welcome to the ATM. What would you like to do?");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Exit");
            int choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + balance);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    int amount = input.nextInt();
                    if (amount > balance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        balance -= amount;
                        System.out.println("Withdrawn " + amount + ". Your new balance is " + balance);
                    }
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    int deposit = input.nextInt();
                    balance += deposit;
                    System.out.println("Deposited " + deposit + ". Your new balance is " + balance);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

