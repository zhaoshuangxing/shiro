package shiro.demo.utils;

import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by first on 2017/05/18.
 */
public class SecurityUtils {
    private static final String configShiro = "F:/shiro/shrioDir/shiro2/src/main/webapp/WEB-INF/shiro.ini";
    public static Subject getSubject() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configShiro);
        SecurityManager securityManager = factory.getInstance();
        org.apache.shiro.SecurityUtils.setSecurityManager(securityManager);
        return org.apache.shiro.SecurityUtils.getSubject();
    }
}
