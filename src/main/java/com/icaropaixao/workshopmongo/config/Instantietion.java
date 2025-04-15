package com.icaropaixao.workshopmongo.config;

import com.icaropaixao.workshopmongo.domain.User;
import com.icaropaixao.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration // Torna essa classe um Bean gerenciado pelo Spring
public class Instantietion implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository; // Injeção de dependência do repositório

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll(); // deleta todos os usuarios e adiciona os solicitados
        // Criando usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User manu = new User(null, "Emanuele Bibiane", "manu@gmail.com");

        // Salvando no banco de dados
        userRepository.saveAll(Arrays.asList(maria, alex, bob, manu));

        System.out.println("Usuários salvos no banco!");
    }


}

