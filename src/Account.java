package basic.atm;

public class Account implements BankOperations {
    private String firstName;
    private String lastName;
    private Integer balance;

    Account(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String generateCardNumber() {
        Integer length = 8;
        String passwordSet = "1234567890";
        char[] cardNumber = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            cardNumber[i] = passwordSet.charAt(rand);
        }

        return new String(cardNumber);
    }

    public String generatePincode() {
        Integer length = 4;
        String passwordSet = "1234567890";
        char[] pinCode = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            pinCode[i] = passwordSet.charAt(rand);
        }

        return new String(pinCode);
    }

    public void deposit(Integer amount) {
        this.balance += amount;
    }

    public void withdraw(Integer amount) {
        if (this.balance < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        this.balance -= amount;
    }

    public Integer getBalance() {
        return this.balance;
    }
}
