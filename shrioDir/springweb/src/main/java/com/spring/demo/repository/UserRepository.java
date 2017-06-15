package com.spring.demo.repository;

import com.spring.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hunter on 2017-06-15.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
