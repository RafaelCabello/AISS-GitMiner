package aiss.gitminer.controller;

import aiss.gitminer.model.Issue;
import aiss.gitminer.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    IssueRepository issueRepository;

    // GET http://localhost:8080/api/issues
    @GetMapping
    public List<Issue> findAll() {
        return issueRepository.findAll();
    }

    // GET http://localhost:8080/api/issues/{id}
    @GetMapping("/{id}")
    public Issue findOne(@PathVariable long id) {
        Optional<Issue> issue = issueRepository.findById(id);
        return issue.get();
    }


}
