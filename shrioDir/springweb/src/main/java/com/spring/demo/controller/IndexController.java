package com.spring.demo.controller;

import com.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by first on 2017/06/14.
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam() String name, @RequestParam String password, Model model) {
        boolean ends = userService.login(name,password);
        if(ends) {
            return "success";
        } else {
            return "index";
        }
    }
    @RequestMapping("delByUserId")
    @ResponseBody
    public void delUser(@RequestParam() Long id) {
        try{
            userService.delByUserId(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
