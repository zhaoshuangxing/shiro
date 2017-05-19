package shiro.demo.utils;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by hunter on 2017/5/19.
 */
public class Log4jInit extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void destroy() {
        super.destroy();
    }
    public Log4jInit() {
        super();
    }
    public void init() throws ServletException {
        String file = this.getInitParameter("log4j");
        if(file != null) {
            PropertyConfigurator.configure(file);
        }
    }
}
