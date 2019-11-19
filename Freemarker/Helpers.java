package Freemarker;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class Helpers {
    public static void render(HttpServletRequest request,
                              HttpServletResponse response,
                              String path,
                              Map<String, Object> root) {


        Configuration cfg = FreeMarkerConfig.getConfig(request);
        try {
            Template tmpl = cfg.getTemplate(path);
            try {
                tmpl.process(root, response.getWriter());
            } catch (TemplateException e) {
                throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String dispatcherPhoto(HttpServletRequest request) {
        Part p = null;
        try {
            p = request.getPart("photo");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (ServletException e) {
            throw new IllegalArgumentException(e);
        }
        String localdir = "uploads";
        String pathDir = request.getServletContext().getRealPath("") + File.separator + localdir;
        File dir = new File(pathDir);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String[] filename_data = p.getSubmittedFileName().split("\\.");
        String filename = Math.random()*1000000 + "." + filename_data[filename_data.length - 1];
        String fullpath = pathDir + File.separator + filename;
        try {
            p.write(fullpath);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        String s = "/" + localdir + "/" + filename;
        return s;
    }

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/semestrovochka?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "Max158320");
            return connection;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}

