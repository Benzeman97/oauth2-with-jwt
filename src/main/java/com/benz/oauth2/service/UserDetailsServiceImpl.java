package com.benz.oauth2.service;

import com.benz.oauth2.dao.UserDAO;
import com.benz.oauth2.entity.User;
import com.benz.oauth2.model.AuthUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user= userDAO.findByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException("data not found with "+username));

        return AuthUserDetails.builder(user);
    }

}
