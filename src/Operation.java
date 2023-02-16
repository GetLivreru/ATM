package basic.atm;
public class Operation {
    public void deposit(Account account, int amount) {
        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(Account account, int amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public int checkBalance(Account account) {
        return account.getBalance();
    }
} 
