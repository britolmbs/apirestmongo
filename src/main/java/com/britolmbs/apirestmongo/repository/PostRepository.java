package com.britolmbs.apirestmongo.repository;

import com.britolmbs.apirestmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends MongoRepository<Post, String> {
}
