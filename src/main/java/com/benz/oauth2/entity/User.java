package com.benz.oauth2.entity;

import com.benz.oauth2.util.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user56",schema = Schema.OAUTH2,uniqueConstraints = @UniqueConstraint(
        columnNames = "username"
))
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(name="user_id_gen",sequenceName = Schema.OAUTH2+".user_id_seq",initialValue = 1003,allocationSize = 1)
    @GeneratedValue(generator = "user_id_gen",strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private int active;
    @Column(name = "acc_non_expired")
    private int accNonExpired;
    @Column(name = "credential_non_expired")
    private int credentialNonExpired;
    @Column(name = "acc_non_locked")
    private int accNonLocked;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "role_user",
    joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private Set<Role> roles;

}
