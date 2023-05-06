package aiss.gitminer.controller;

import aiss.gitminer.model.Commit;
import aiss.gitminer.repository.CommitRepository;
import aiss.gitminer.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commits")
public class CommitController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    CommitRepository commitRepository;

    // GET http://localhost:8080/api/commits
    @GetMapping
    public List<Commit> findAll() {
        return commitRepository.findAll();
    }

    // GET http://localhost:8080/api/commits/{id}
    @GetMapping("/{id}")
    public Commit findOne(@PathVariable long id) {
        Optional<Commit> commit = commitRepository.findById(id);
        return commit.get();
    }

}
