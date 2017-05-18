package demo.shrio.core;

import demo.shrio.day1.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**jdbc realm从数据库中获取验证数据对传入的参数进行身份验证，验证通过则打印出通过的语句，否则不予通过
 * Created by hunter on 2017/5/18.
 */
public class JdbcRealm {
    public static void main(String[] args) {
        SecurityUtils.login("classpath:shiro.ini","hunter","123");
    }
}
