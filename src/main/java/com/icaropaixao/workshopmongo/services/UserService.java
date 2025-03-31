package com.icaropaixao.workshopmongo.services;


import com.icaropaixao.workshopmongo.domain.User;
import com.icaropaixao.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  {

    // metodo para buscar os usuarios
    @Autowired
    private UserRepository usRepo;

    public List<User> findAll() {
        return usRepo.findAll();
    }



}
