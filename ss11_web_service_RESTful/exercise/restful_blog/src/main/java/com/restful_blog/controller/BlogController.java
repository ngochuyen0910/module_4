package com.restful_blog.controller;

import com.restful_blog.model.Blog;
import com.restful_blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/api/v1")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        Blog blog1 = new Blog();
        BeanUtils.copyProperties(blog, blog1);
        blogService.save(blog1);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id,
                                           @RequestBody Blog blog) {
        Blog currentBlog = blogService.findById(id);
        if (currentBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentBlog.setNameBlog(blog.getNameBlog());
        currentBlog.setContent(blog.getContent());
        currentBlog.setCategory(blog.getCategory());

        blogService.save(currentBlog);
        return new ResponseEntity<>(currentBlog, HttpStatus.OK);
    }
}
