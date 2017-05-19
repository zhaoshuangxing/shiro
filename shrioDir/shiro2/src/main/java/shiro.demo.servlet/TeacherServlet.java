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
public class TeacherServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doGet(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" thacher do");
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.hasRole("teacher")) {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/unanthorized.jsp").forward(request, response);
        }
    }
}
