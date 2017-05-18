package demo.shrio.day1;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hunter on 2017/5/18.
 */
public class RoleDemo {
    @Test
    public void testHasRole() {
        String config = "classpath:shiro.ini";
        String username = "hunter";
        String password = "123";

        Subject currentUser = SecurityUtils.login(config, username, password);
        List<String> arrays = Arrays.asList("ADMIN","USER","ADD");
        boolean[] results = currentUser.hasRoles(arrays);
        for (int i = 0; i < results.length; i++
             ) {
            System.out.println(results[i] ? "有"+arrays.get(i)+"这个角色" : "没有"+arrays.get(i)+"这个角色");
        }
        boolean hasAdd = currentUser.hasRole("ADD");
        System.out.println(hasAdd ? "有ADD角色" : "没有ADD角色");
        currentUser.logout();
    }

    @Test
    public void testCheckRole() {
        String config = "classpath:shiro.ini";
        String username = "breeder";
        String password = "spring.c";

        Subject currentUser = SecurityUtils.login(config, username, password);
        try {
            currentUser.checkRole("ADMIN");
            System.out.println("拥有角色---逻辑处理");
        } catch (UnauthorizedException e) {
            System.out.println("不拥有此权限---逻辑处理");
            e.printStackTrace();
        }finally {
            currentUser.logout();
        }
    }
}
