package dk.sdu.dm;
import java.sql.*;


public class Main {
    static Connection connection = null;
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/dm-07", "postgres", "Nils3141");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users(name, cpr) VALUES (?, ?)");
            insertStatement.setString(1, "Mikkel Grove");
            insertStatement.setString(2, "1234567891");
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM users WHERE cpr = ?");
            selectStatement.setString(1, "1234567891");
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
