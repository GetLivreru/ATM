package basic.atm;
import java.sql.*;

public class Database {
    private Connection connection;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://host:port/database", "username", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
    public void saveAccount(Account account) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts (first_name, last_name, card_number, pin_code, balance) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setString(3, account.getCardNumber());
            statement.setString(4, account.getPincode());
            statement.setInt(5, account.getBalance());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

