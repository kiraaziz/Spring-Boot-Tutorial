package com.firstRest.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstRest.controller.PostModel;
import com.firstRest.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService services;

    @Autowired
    public PostController(PostService services) {
        this.services = services;
    }

    @GetMapping
    public List<PostModel> ListPost() {
        return services.ListPost();
    }

    @GetMapping("/{id}")
    public Optional<PostModel> getPost(@PathVariable Long id) {
        return services.GetPost(id);
    }

    @PostMapping
    public PostModel createPost(@RequestBody PostModel data) {
        return services.CreatePost(data);
    }

    @PatchMapping("/{id}")
    public PostModel updatePost(@PathVariable Long id, @RequestBody PostModel data) {
        return services.UpdatePost(id, data);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        return services.DeletePost(id);
    }
}
