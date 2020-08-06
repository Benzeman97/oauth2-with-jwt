package com.benz.oauth2.entity;

import com.benz.oauth2.util.EPermission;
import com.benz.oauth2.util.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PERMISSION",schema = Schema.OAUTH2,uniqueConstraints = @UniqueConstraint(
        columnNames = "NAME"
))
@Getter
@Setter
public class Permission {

    @Id
    @Column(name="ID")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME")
    private EPermission name;
}
