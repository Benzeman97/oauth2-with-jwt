package com.benz.oauth2.dao;

import com.benz.oauth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {

    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);
}
