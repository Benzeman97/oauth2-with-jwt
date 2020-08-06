package com.benz.oauth2.controller;

import com.benz.oauth2.dao.OAuthClientDAO;
import com.benz.oauth2.dao.UserDAO;
import com.benz.oauth2.entity.OAuthClient;
import com.benz.oauth2.entity.User;
import com.benz.oauth2.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OAuthClientDAO oAuthClientDAO;

    @GetMapping("/user/{userName}")
    public User getUser(@PathVariable("userName") String userName)
    {

            return userDAO.findByUserName(userName)
              .orElseThrow(
                      ()->new DataNotFoundException("data not available with username"));
    }

    @GetMapping("/clients")
    public void getClient()
    {

        OAuthClient client=oAuthClientDAO.findByClientId("web")
                .orElseThrow(()->new DataNotFoundException("data not available"));

        System.out.println(client.getClientSecret());
          }
}
