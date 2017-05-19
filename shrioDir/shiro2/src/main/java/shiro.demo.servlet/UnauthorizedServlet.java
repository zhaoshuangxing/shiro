package shiro.demo.servlet;

import org.apache.shiro.subject.Subject;
import shiro.demo.utils.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hunter on 2017/5/19.
 */
public class UnauthorizedServlet extends HttpServlet  {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doGet(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UnauthorizedServlet do");
        request.getRequestDispatcher("/unauthorizedServlet.jsp").forward(request, response);
    }
}
