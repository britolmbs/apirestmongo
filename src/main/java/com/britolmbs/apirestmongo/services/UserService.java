package com.britolmbs.apirestmongo.services;

import com.britolmbs.apirestmongo.domain.User;
import com.britolmbs.apirestmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void  delete(String id) {
        findById(id);
        repo.delete(id);
    }

    public  User update(User obj) {
       User newObj  = repo.findOne(obj.getId());
       updateDate(newObj, obj);
       return  repo.save(newObj);
    }

    private void updateDate(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());

    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
