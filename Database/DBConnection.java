package Database;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.util.Properties;

public class DBConnection {

    public static DBConnection instance;

    Connection connection;

    public static DBConnection getInstance(DBProperties dbProperties) throws SQLException, ClassNotFoundException {
        if (instance == null) {
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            properties.setProperty("user", dbProperties.user);
            properties.setProperty("password", dbProperties.password);
            instance = new DBConnection();
            instance.connection = DriverManager.getConnection(dbProperties.url, properties);
        }
        return instance;
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return getInstance(null);
    }

    private DBConnection() {

    }
}
