package com.benz.oauth2.entity;

import com.benz.oauth2.util.Schema;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_client_details",schema = Schema.OAUTH2)
@Getter
@Setter
public class OAuthClient {

    @Id
    @Column(name = "client_id")
    private String clientId;
    @Column(name="client_secret")
    private String clientSecret;
    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectUri;
    @Column(name = "scope")
    private String scope;
    @Column(name = "accsess_token_validity")
    private String accessTokenValidity;
    @Column(name = "refresh_token_validity")
    private String refreshTokenValidity;
    @Column(name = "resource_id")
    private String resourceId;
    @Column(name="authorized_grant_types")
    private String authorizedGrantType;
    @Column(name = "authorities")
    private String authorities;
    @Column(name = "additional_information")
    private String additionalInformation;
    @Column(name = "autoapprove")
    private String autoApprove;

}
