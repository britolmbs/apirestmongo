package com.britolmbs.apirestmongo.config;

import com.britolmbs.apirestmongo.domain.User;
import com.britolmbs.apirestmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

   @Autowired
   private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User lucas = new User(null, "Lucas Brito", "lucas@gmail.com");
        User dilma = new User(null, "Dilma Brito", "dilma@gmail.com");
        User thor = new User(null, "Thor", "thor@gmail.com");

        userRepository.save(Arrays.asList(lucas, dilma, thor));
    }
}
