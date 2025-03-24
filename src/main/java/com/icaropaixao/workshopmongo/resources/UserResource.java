package com.icaropaixao.workshopmongo.resources;

import com.icaropaixao.workshopmongo.domain.User;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>>  findAll(){

        User maria = new User("1","maria Brown","maria@gmail.com");
        User alex = new User("2","alex Grenn","alex@gmail.com");
        List<User> usersList = new ArrayList<>();
        usersList.addAll(Arrays.asList(maria,alex));

        return ResponseEntity.ok().body(usersList);
    }

}
