package com.benz.oauth2.entity;

import com.benz.oauth2.util.ERole;
import com.benz.oauth2.util.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="ROLE",schema = Schema.OAUTH2,uniqueConstraints =
  @UniqueConstraint(columnNames = "NAME")
)
@Getter
@Setter
public class Role {

    @Id
    @Column(name = "ID")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name="NAME")
    private ERole name;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="PERMISSION_ROLE",
     joinColumns = {@JoinColumn(name = "ROLE_ID",referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name = "PERMISSION_ID",referencedColumnName = "ID")})
    private Set<Permission> permissions;
}
