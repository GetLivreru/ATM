package basic.atm;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int balance = 1000; // starting balance
        
        // login
        System.out.println("Enter your PIN:");
        int pin = input.nextInt();
        
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

