package basic.atm;

public interface BankOperations {
  
  // Method to deposit an amount of money into an account
  public void deposit(double amount);

  // Method to withdraw an amount of money from an account
  public void withdraw(double amount);

  // Method to get the balance of an account
  public double getBalance();

  // Method to transfer an amount of money from one account to another
  public void transfer(double amount, BankOperations destinationAccount);
      void save();
}
