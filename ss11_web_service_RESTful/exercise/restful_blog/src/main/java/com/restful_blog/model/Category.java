package com.restful_blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCategory;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private Set<Blog> blog;

    public Category() {
    }

    public Category(int id, String nameCategory, Set<Blog> blog) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public Set<Blog> getBlog() {
        return blog;
    }

    public void setBlog(Set<Blog> blog) {
        this.blog = blog;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}