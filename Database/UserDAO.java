package Database;

import Freemarker.Helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {

    public static ArrayList<User> getUser() {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = Helpers.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("country"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("photo"),
                        resultSet.getTimestamp("date_birth")));
            }
            Helpers.closeConnection(connection);
            return users;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
