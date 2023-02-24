package basic.atm;

import java.sql.*;

public class Account {

    private final String firstName;

    private final String lastName;

    private int balance;

    Account(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*
    Registration of new user
    */
    public void register() {
        try {
            Connection c = Database.connection();

            Statement stmt = c.createStatement();

            String sql = "INSERT INTO atm.account (first_name, last_name) VALUES ('" + this.firstName + "', '" + this.lastName + "')";

            stmt.executeUpdate(sql);

            String sql2 = "SELECT LAST_INSERT_ID()";
            ResultSet rs2 = stmt.executeQuery(sql2);

            int last_account_id = 0;

            while (rs2.next()) {
                last_account_id = rs2.getInt(1);
            }

            String cardNumber = this.generateCardNumber();

            String code = this.generatePincode();

            Statement stmt3 = c.createStatement();

            String sql3 = "INSERT INTO atm.card (account_id, card_number, pincode) VALUES (" + last_account_id + ", '" + cardNumber + "', '" + code + "')";

            stmt3.executeUpdate(sql3);

            Statement stmt4 = c.createStatement();

            String sql4 = "INSERT INTO atm.balance (card_number, balance) VALUES ('" + cardNumber + "', 0)";

            stmt4.executeUpdate(sql4);

            c.close();

            System.out.println("Account created successfully");
            System.out.println("Card number: " + cardNumber);
            System.out.println("Pincode: " + code);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /*
    Card number generation
    */
    String passwordSet = "1234567890";
    public String generateCardNumber() {
        int length = 8;

        char[] cardNumber = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());

            cardNumber[i] = passwordSet.charAt(rand);
        }

        return new String(cardNumber);
    }

    /*
    Pin code generation
    */
    public String generatePincode() {
        int length = 4;

        char[] cardNumber = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());

            cardNumber[i] = passwordSet.charAt(rand);
        }

        return new String(cardNumber);
    }


}
