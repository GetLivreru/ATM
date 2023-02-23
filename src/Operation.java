package basic.atm;

import java.sql.*;


public class Operation {
    private String cardNumber;

    private String pincode;

    private Integer balance;

    Operation(String cardNumber, String pincode) {
        this.cardNumber = cardNumber;
        this.pincode = pincode;
    }
    /*
    Displaying the balance of the bank card
    */
    public Integer showBalance(String cardNumber) {
        try {
            Connection c = Database.connection();

            Statement stmt5 = c.createStatement();

            String sql5 = "SELECT * FROM balance WHERE card_number = " + cardNumber;

            ResultSet rs5 = stmt5.executeQuery(sql5);

            while (rs5.next()) {
                this.balance = rs5.getInt(2);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
