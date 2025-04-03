package com.icaropaixao.workshopmongo.services;


import com.icaropaixao.workshopmongo.domain.User;
import com.icaropaixao.workshopmongo.repository.UserRepository;
import com.icaropaixao.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // metodo para buscar os usuarios
    @Autowired
    private UserRepository usRepo;

    public List<User> findAll() {
        return usRepo.findAll();
    }

    public User findById(String id) {

        Optional<User> obj = usRepo.findById(id); //

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));


    }


}
