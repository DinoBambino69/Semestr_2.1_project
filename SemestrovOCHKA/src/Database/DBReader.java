package Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DBReader {
    String path;
    File file;

    public DBReader(String path) {
        this.path = path;
        file = new File(path);
    }

    public DBProperties reader() throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        Map<String, String> map = new HashMap<>();
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            map.put(line.split(": ")[0], line.split(": ")[1]);
        }
        DBProperties dbProperties = new DBProperties();
        dbProperties.user = map.get("user_name");
        dbProperties.password = map.get("password");
        dbProperties.url = map.get("url");
        return dbProperties;
    }
}
