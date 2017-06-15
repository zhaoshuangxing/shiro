package com.spring.demo.service;

/**
 * Created by first on 2017/06/15.
 */
public interface UserService {
    boolean login(String name, String password);

    void delByUserId(Long id);
}
