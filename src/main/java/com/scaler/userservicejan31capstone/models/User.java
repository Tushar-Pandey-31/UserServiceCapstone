package com.scaler.userservicejan31capstone.models;


import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends Base
{
    private String name;
    private String email;
    private String password;

    @ManyToMany
    private List<Role> roles;
}

/*
* User---> Role(many to many)
* */

