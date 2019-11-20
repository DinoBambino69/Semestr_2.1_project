package Servlets;

import Database.User;
import Database.UserDAO;
import Freemarker.Helpers;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.crypto.spec.PSource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

@MultipartConfig
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    Map<String, Object> root = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current_user");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User users = null;
        boolean rememberMe = request.getParameter("remember") != null;
        if (user != null) {
            response.sendRedirect("/profile");
        } else {
            boolean flag = false;
            for (User x : UserDAO.getUser()) {
                if (x.getEmail().equals(username) && x.getPassword().equals(Helpers.hasherPassword(
                        request.getParameter("password")))) {
                    flag = true;
                    users = x;
                } else {
                }
            }
            if (flag == true) {
                Cookie cookie = new Cookie("username", username);
                session.setAttribute("current_user", users);
                response.addCookie(cookie);
                response.sendRedirect("/profile");
            } else {
                response.sendRedirect("/login");
                root.put("ERROR", "profile not found");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current_user");
        if (user != null)
            response.sendRedirect("/profile");
        else {
        }
        response.setContentType("text/html");
        Helpers.render(request, response, "login.ftl", root);
    }


}