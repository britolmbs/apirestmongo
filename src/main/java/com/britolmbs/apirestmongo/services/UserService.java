package com.britolmbs.apirestmongo.services;

import com.britolmbs.apirestmongo.domain.User;
import com.britolmbs.apirestmongo.repository.UserRepository;
import com.britolmbs.apirestmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        User user = repo.findOne(id);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

}
