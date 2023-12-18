package MysqlDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetriever {
    public static void retrieveData(String query ) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String id = resultSet.getString("student_id");
                    String fname = resultSet.getString("first_name");
                    String mname = resultSet.getString("middle_name");
                    String lname = resultSet.getString("last_name");

                    // Process retrieved data as needed
                    System.out.println("ID: " + id + ", Name: " + fname + mname + lname);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

