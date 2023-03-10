package com.britolmbs.apirestmongo.config;

import com.britolmbs.apirestmongo.domain.Post;
import com.britolmbs.apirestmongo.domain.User;
import com.britolmbs.apirestmongo.dto.AuthorDTO;
import com.britolmbs.apirestmongo.dto.CommentDTO;
import com.britolmbs.apirestmongo.repository.PostRepository;
import com.britolmbs.apirestmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User lucas = new User(null, "Lucas Brito", "lucas@gmail.com");
        User dilma = new User(null, "Dilma Brito", "dilma@gmail.com");
        User thor = new User(null, "Thor", "thor@gmail.com");

        userRepository.save(Arrays.asList(lucas, dilma, thor));

        Post post1 = new Post(null, sdf.parse("20/01/2023"), "Partiu viagem", "Vou viajar para São Paulo.", new AuthorDTO(lucas) );
        Post post2 = new Post(null, sdf.parse("21/01/2023"), "Bom dia!", "Acordei, feliz hoje", new AuthorDTO(lucas));

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("24/01/2023"), new AuthorDTO(dilma));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("25/01/2023"), new AuthorDTO(thor));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("26/01/2023"), new AuthorDTO(dilma));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.save(Arrays.asList(post1, post2));

        lucas.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(lucas);
    }
}
