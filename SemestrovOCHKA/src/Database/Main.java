package Database;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        DBReader reader = new DBReader("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\SemestrovOCHKA\\fail.txt");
        DBProperties prop = reader.reader();
        DBConnection dbConnection = DBConnection.getInstance(prop);
    }
}
//C:Program FilesApache Software FoundationTomcat 9.0SemestrovOCHKAail.txt