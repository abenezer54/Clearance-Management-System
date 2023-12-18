package MysqlDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataUpdater {
    public static void updateData(String query) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBConnection.getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                statement.executeUpdate(query);
                System.out.println("Data Updated Successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
