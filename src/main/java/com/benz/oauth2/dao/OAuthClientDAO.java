package com.benz.oauth2.dao;

import com.benz.oauth2.entity.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OAuthClientDAO extends JpaRepository<OAuthClient,String> {

    Optional<OAuthClient> findByClientId(String clientId);
}
