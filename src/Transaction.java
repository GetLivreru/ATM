package basic.atm;

import java.time.LocalDateTime;

public class Transaction {
  private int amount;
  private String transactionType;
  private LocalDateTime transactionDateTime;
  
   public Transaction(int amount, String transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDateTime = LocalDateTime.now();
    }
   public int getAmount() {
        return amount;
    }
    public String getTransactionType() {
        return transactionType;
    }
   public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }
}
