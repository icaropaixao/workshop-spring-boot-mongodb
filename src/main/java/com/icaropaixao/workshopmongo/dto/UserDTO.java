package com.icaropaixao.workshopmongo.dto;

import com.icaropaixao.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;
    private String email;

    // construtor
    public UserDTO() {
    }


    public UserDTO(User obj) {
        // coletando dados especificos da classe User
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }


    // gets and sets
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
