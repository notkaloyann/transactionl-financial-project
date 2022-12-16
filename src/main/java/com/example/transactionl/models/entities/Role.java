package com.example.transactionl.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table(name = "roles")
@Entity
public class Role extends BaseEntity {

    private RoleEnums roleEnum;

    public Role() {
    }

    @Enumerated(value = EnumType.STRING)
    public RoleEnums getRoleEnum() {
        return roleEnum;
    }

    public Role setRoleEnum(RoleEnums roleEnum) {
        this.roleEnum = roleEnum;
        return this;
    }
}
