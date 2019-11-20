package Servlets;

import Database.User;
import Database.UserDAO;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterServlet implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpSession session = request1.getSession();
        Cookie[] cookies = request1.getCookies();
        for (Cookie x: cookies
        ) {
            if(x.getName().equals("username"))
            {
                session.setAttribute("username", x.getValue());
            }
            if (x.getName().equals("password"))
            {
                session.setAttribute("password", x.getValue());
            }
            if(x.getName().equals("remember"))
            {
                session.setAttribute("remember", x.getValue());
            }


        }
        if(session.getAttribute("username")!= null && session.getAttribute("password")!=null) {
            if (session.getAttribute("remember").equals("on")) {
                for (User x : UserDAO.getUser()
                ) {
                    if (x.getEmail().equals(session.getAttribute("username"))
                            && x.getPassword().equals(session.getAttribute("password"))) {
                        session.setAttribute("current_user", x);
                    }

                }
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
