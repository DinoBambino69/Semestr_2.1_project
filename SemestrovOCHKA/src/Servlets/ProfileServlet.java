package Servlets;

import Freemarker.Helpers;
import Database.User;
import Database.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig
public class ProfileServlet extends HttpServlet {
    Map<String, Object> root = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user  = (User) session.getAttribute("current_user");
        if(user != null) {
            root.put("user",user);
            response.setContentType("text/html");
            Helpers.render(request, response, "profile.ftl", root);
        } else {
            root.put("message", "you need to login");
            response.sendRedirect("/login");
        }
    }


}
