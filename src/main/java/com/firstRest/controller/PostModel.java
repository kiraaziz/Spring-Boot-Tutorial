package com.firstRest.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;
    public String name;
    public String content;

    // public PostModel(int id, String name, String content) {
    // this.id = id;
    // this.name = name;
    // this.content = content;
    // }

}
