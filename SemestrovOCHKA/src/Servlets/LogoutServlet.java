package Servlets;

import Freemarker.Helpers;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class LogoutServlet extends HttpServlet {
    Map<String, Object> root = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("current_user");
        Cookie cookie = new Cookie("username","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.setContentType("text/html");
        response.sendRedirect("/login");
    }
}