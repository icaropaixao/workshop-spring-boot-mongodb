package com.icaropaixao.workshopmongo.resources;

import com.icaropaixao.workshopmongo.domain.User;
import com.icaropaixao.workshopmongo.repository.UserRepository;
import com.icaropaixao.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value= "/users")
public class UserResource {

    @Autowired
    private UserService usService;

    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<User>>  findAll(){

        List<User> usersList = usService.findAll(); // busca os usuarios com o metodo finAll
        return ResponseEntity.ok().body(usersList); // retorna os usuarios
    }

}
