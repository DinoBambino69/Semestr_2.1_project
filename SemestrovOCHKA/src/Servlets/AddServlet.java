package Servlets;

import Database.User;
import Freemarker.Helpers;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@MultipartConfig
public class AddServlet extends HttpServlet {
    Map<String ,Object> root = new HashMap<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User profile = (User) session.getAttribute("current_user");
        if (profile != null) {
            String sql = "INSERT INTO post(id,photo,text_inform) VALUES(?,?,?)";
            try (Connection conn = Helpers.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, profile.getId());
                pstmt.setString(2,Helpers.dispatcherPhoto(request));
                pstmt.setString(3, (String) request.getParameter("text_inform"));
                pstmt.executeUpdate();
                response.sendRedirect("/profile");
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current_user");
        if (user == null) {
            response.sendRedirect("/login");
        } else {
            response.setContentType("text/html");
            root.put("user", user);
            Helpers.render(request, response, "add.ftl", root);
        }
    }
}
