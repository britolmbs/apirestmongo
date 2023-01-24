package com.britolmbs.apirestmongo.services;

import com.britolmbs.apirestmongo.domain.Post;
import com.britolmbs.apirestmongo.repository.PostRepository;
import com.britolmbs.apirestmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post post = repo.findOne(id);
        if (post == null) {
            throw new ObjectNotFoundException("Objeto não Encontrado");

        } return post;
    }
    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);    }
}
