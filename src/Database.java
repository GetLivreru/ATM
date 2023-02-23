package basic.atm;

import java.sql.*;


public class Database {
    private static final String dbClassName = "com.mysql.cj.jdbc.Driver";

    private static final String CONNECTION = "jdbc:mysql://localhost:3306";

    private static final String USER = "Sepa";

    private static final String PASSWORD = "1234";

    public static java.sql.Connection connection() throws Exception {
        Class.forName(dbClassName);

        return DriverManager.getConnection(CONNECTION, USER, PASSWORD);
    }
}

