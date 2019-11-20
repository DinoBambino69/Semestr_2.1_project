package Servlets;

import Freemarker.Helpers;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig
public class RegisterServlet extends HttpServlet {
    Map<String ,Object> root = new HashMap<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "INSERT INTO user(name, surname, country, email, password, photo) VALUES (?,?,?,?,?,?)";
        try(Connection connection = Helpers.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,request.getParameter("name"));
            preparedStatement.setString(2,request.getParameter("surname"));
            preparedStatement.setString(3,request.getParameter("country"));
            preparedStatement.setString(4,request.getParameter("email"));
            preparedStatement.setString(5,Helpers.hasherPassword(request.getParameter("password")));
            preparedStatement.setString(6,Helpers.dispatcherPhoto(request));
            preparedStatement.executeUpdate();
            response.sendRedirect("/profile");
        }
        catch (SQLException e){
            throw new IllegalArgumentException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Helpers.render(request,response,"registration.ftl",root);
    }
}