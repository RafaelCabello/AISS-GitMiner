package aiss.gitminer.controller;

import aiss.gitminer.model.Comment;
import aiss.gitminer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    // GET http://localhost:8080/api/comments
    @GetMapping
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    // GET http://localhost:8080/api/comments/{id}
    @GetMapping("/{id}")
    public Comment findOne(@PathVariable long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.get();
    }
}
