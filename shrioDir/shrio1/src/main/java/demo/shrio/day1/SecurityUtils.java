package demo.shrio.day1;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by hunter on 2017/5/18.
 */
public class SecurityUtils {
    public static Subject login(String config, String username, String password) {
        //读取配置文件，初始化工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(config);
        //获取SecurtiyManager实例
        SecurityManager securityManager = factory.getInstance();
        //吧SecurtiyManage绑定到SecuriyUtils
        org.apache.shiro.SecurityUtils.setSecurityManager(securityManager);
        //创建token令牌，用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //得到当前用户
        Subject currentUser = org.apache.shiro.SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            System.out.println("身份认证成功！");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份认证失败！");
        }
        return currentUser;
    }
}
