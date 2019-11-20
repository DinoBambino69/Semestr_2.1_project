package Database;

import Freemarker.Helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostDAO {

    public static ArrayList<Post> getPost() {
        ArrayList<Post> posts = new ArrayList<>();
        Connection connection = Helpers.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM post");
            while (resultSet.next()) {
                posts.add(new Post(resultSet.getInt("id"),
                        resultSet.getString("photo"),
                        resultSet.getString("text_inform")));
            }
            Helpers.closeConnection(connection);
            return posts;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
