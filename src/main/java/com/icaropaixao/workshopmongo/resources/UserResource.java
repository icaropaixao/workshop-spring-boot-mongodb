package com.icaropaixao.workshopmongo.resources;

import com.icaropaixao.workshopmongo.domain.User;
import com.icaropaixao.workshopmongo.dto.UserDTO;
import com.icaropaixao.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService usService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> usersList = usService.findAll(); // busca os usuarios com o metodo finAl

        // pegando a lista original, transformando em um DTOList (Stream) e transformando em list novamente
        List<UserDTO> usersDTO = usersList.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(usersDTO); // retorna os usuarios
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        User obj = usService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj)); // convertendo o OBJ para um UserDto


    }

}
