package com.queirozisrael.springmongodb.resources;

import com.queirozisrael.springmongodb.domain.Post;
import com.queirozisrael.springmongodb.resources.util.URL;
import com.queirozisrael.springmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value ="/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value ="/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value ="text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
