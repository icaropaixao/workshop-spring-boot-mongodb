package com.icaropaixao.workshopmongo.resources;

import com.icaropaixao.workshopmongo.domain.User;
import com.icaropaixao.workshopmongo.dto.UserDTO;
import com.icaropaixao.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService usService;

    // buscar todos
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> usersList = usService.findAll(); // busca os usuarios com o metodo finAl

        // pegando a lista original, transformando em um DTOList (Stream) e transformando em list novamente
        List<UserDTO> usersDTO = usersList.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(usersDTO); // retorna os usuarios
    }

    // buscar usuario pelo id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        User obj = usService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj)); // convertendo o OBJ para um UserDto

    }

    // Inserir usuario
    @PostMapping
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO objDTO) {
        User obj = usService.fromDTO(objDTO); // convertendo o DTO para tipo user
        obj = usService.insert(obj);

        // Cria uma URI com o caminho do recurso recém-criado (incluindo o ID)
        // e retorna uma resposta HTTP 201 Created com o cabeçalho "Location" apontando para essa URI.
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }


}
