package com.spring.demo.repository;

import com.spring.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hunter on 2017-06-15.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
    //此写法会自动解析方法名
    User findByNameAndPassword(String name, String password);

    @Modifying
    @Query("delete User u where u.id =:id")
    @Transactional
    void delByUserId(@Param("id") Long id);
}
