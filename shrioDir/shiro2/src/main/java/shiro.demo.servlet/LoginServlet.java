package shiro.demo.servlet;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shiro.demo.utils.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by first on 2017/05/18.
 */
public class LoginServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("login doget----------------------");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            logger.info("认证成功");
            request.getSession().setAttribute("username",username);
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            logger.info("认证失败");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } finally {

        }
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
       doGet(request, response);
    }
}
