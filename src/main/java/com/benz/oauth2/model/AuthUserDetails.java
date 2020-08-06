package com.benz.oauth2.model;

import com.benz.oauth2.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthUserDetails implements UserDetails{

    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;
    private boolean accNonExpired;
    private boolean accNonLocked;
    private boolean credentialNonExpired;
    private boolean active;

    public AuthUserDetails()
    {

    }

    public AuthUserDetails(boolean active, List<GrantedAuthority> authorities, String userName, String password,
			boolean accNonExpired, boolean credentialNonExpired, boolean accNonLocked) {

		this.active = active;
		this.authorities = authorities;
		this.userName = userName;
		this.password = password;
		this.accNonExpired = accNonExpired;
		this.credentialNonExpired = credentialNonExpired;
		this.accNonLocked = accNonLocked;
    }




	public static UserDetails builder(User user)
    {

    	List<GrantedAuthority> grantedAuthorities=new ArrayList<>();

         user.getRoles().forEach(role-> {

        			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().name()));

        			role.getPermissions().forEach(perm->{
        					grantedAuthorities.add(new SimpleGrantedAuthority(perm.getName().name()));
        			});

        		});

         return new AuthUserDetails((user.getActive()==1),grantedAuthorities,user.getUserName(),user.getPassword(),
        		 (user.getAccNonExpired()==1), (user.getCredentialNonExpired()==1),(user.getAccNonLocked()==1));

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
