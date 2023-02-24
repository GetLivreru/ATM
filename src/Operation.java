package basic.atm;

import java.sql.*;


public class Operation {
    private final String card_number;

    private final String pincode;

    private int balance;

    Operation(String card_number, String pincode) {
        this.card_number = card_number;
        this.pincode = pincode;
    }
    /*
    Displaying the balance of the bank card
    */
    public Integer showBalance(String card_number) {
        try {
            Connection c = Database.connection();

            Statement stmt5 = c.createStatement();

            String sql5 = "SELECT * FROM atm.balance WHERE card_number = " + card_number;

            ResultSet rs5 = stmt5.executeQuery(sql5);

            while (rs5.next()) {
                this.balance = rs5.getInt(2);
            }

        } catch (Exception e) {
            System.out.println();
        }

        return this.balance;
    }


    /*
    Put money on a bank card
    */
    public void deposit(Integer amount, String card_number) {
        try {
            Connection c = Database.connection();

            Statement stmt6 = c.createStatement();

            String sql6 = "UPDATE atm.balance SET balance = balance + '" + amount + "' WHERE card_number = " + card_number;

            stmt6.executeUpdate(sql6);
        } catch (Exception e) {
            System.out.println();
        }
    }

    /*
    Transfer money to another user
    */
    public void sendMoneyToOther(Integer amountOther, String numberOther, String card_number) {
        try (Connection c = Database.connection();
             PreparedStatement pstmt1 = c.prepareStatement("UPDATE atm.balance SET balance = balance + ? WHERE card_number = ?");
             PreparedStatement pstmt2 = c.prepareStatement("UPDATE atm.balance SET balance = balance - ? WHERE card_number = ?")) {
            pstmt1.setInt(1, amountOther);
            pstmt1.setString(2, numberOther);
            pstmt1.executeUpdate();

            pstmt2.setInt(1, amountOther);
            pstmt2.setString(2, card_number);
            pstmt2.executeUpdate();
        } catch (SQLException e) {
            // handle exception
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println();
        }
    }


}
