package com.firstRest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.firstRest.controller.PostModel;
import com.firstRest.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository orm;

    public List<PostModel> ListPost() {
        return orm.findAll();
    }

    public Optional<PostModel> GetPost(Long id) {
        return orm.findById(id);
    }

    public PostModel CreatePost(PostModel post) {
        // if (post.id <= 0) {
        // throw new IllegalArgumentException("Error id must be greater then 0 ");
        // }

        return orm.save(post);
    }

    public PostModel UpdatePost(Long id, PostModel post) {
        post.id = id;
        return orm.save(post);
    }

    public String DeletePost(Long id) {
        orm.deleteById(id);
        return "Delete success (id : " + id + ")";
    }
}
