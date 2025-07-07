package com.icaropaixao.workshopmongo.config;

import com.icaropaixao.workshopmongo.domain.Post;
import com.icaropaixao.workshopmongo.domain.User;
import com.icaropaixao.workshopmongo.dto.AuthorDTO;
import com.icaropaixao.workshopmongo.repository.PostRepository;
import com.icaropaixao.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration // Torna essa classe um Bean gerenciado pelo Spring
public class Instantietion implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository; // Injeção de dependência do repositório


    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


        userRepository.deleteAll(); // deleta todos os usuarios e adiciona os solicitados
        postRepository.deleteAll();
        // Criando usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User manu = new User(null, "Emanuele Bibiane", "manu@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob, manu));


        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia!", "Acordei Feliz hoje!", new AuthorDTO(maria));
        
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

        System.out.println("Usuários e posts salvos no banco de dados!");
    }


}

