package shiro.demo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import shiro.demo.dao.UserDao;
import shiro.demo.model.User;
import shiro.demo.utils.JDBCConnection;

import java.sql.Connection;

/**
 * Created by hunter on 2017/5/19.
 */
public class MyRealm extends AuthorizingRealm {
    private UserDao userDao = new UserDao();
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Connection con = null;
        try {
            con = JDBCConnection.getConnection();
            authorizationInfo.setRoles(userDao.getRoles(con,username));//设置角色
            authorizationInfo.setStringPermissions(userDao.getPerms(con,username));//set 权限
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.close(con);
        }
        return authorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal(); // 获取用户名
        Connection conn = null;
        try {
            conn = JDBCConnection.getConnection();
            User user = userDao.getByUsername(conn, username); // 仅仅是根据用户名查出的用户信息，不涉及到密码
            if (user != null) {
                AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                        user.getName(), user.getPassword(), "myrealm");
                return authcInfo;
            } else {
                return null;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                JDBCConnection.close(conn);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
