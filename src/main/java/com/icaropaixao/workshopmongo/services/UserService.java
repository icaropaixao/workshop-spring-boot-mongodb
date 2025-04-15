package com.icaropaixao.workshopmongo.services;


import com.icaropaixao.workshopmongo.domain.User;
import com.icaropaixao.workshopmongo.dto.UserDTO;
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

    // findBy Id
    public User findById(String id) {

        Optional<User> obj = usRepo.findById(id); //

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));


    }

    // inserir um usuario
    public User insert(User obj) {
        return usRepo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        usRepo.deleteById(id);
    }


    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());

    }


}
