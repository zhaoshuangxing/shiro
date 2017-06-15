package service;

import com.spring.demo.model.User;
import com.spring.demo.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hunter on 2017-06-15.
 */
public class UserServiceTest {
    @Test
    public void addUser(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        if(userService!=null)System.out.println("success");
        userService.addUser(new User("ZHANGSAN","ZHANGSAN123"));
    }
}
