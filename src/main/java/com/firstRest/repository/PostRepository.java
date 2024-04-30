package com.firstRest.repository;
import com.firstRest.controller.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel, Long> {

}
