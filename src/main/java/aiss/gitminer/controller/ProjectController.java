package aiss.gitminer.controller;

import aiss.gitminer.model.Project;
import aiss.gitminer.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    // GET http://localhost:8080/api/projects
    @GetMapping
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    // GET http://localhost:8080/api/projects/{id}
    @GetMapping("/{id}")
    public Project findOne(@PathVariable long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.get();
    }

    // POST http://localhost:8080/api/projects
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Project create(@RequestBody @Valid Project project) {
        Project _project = projectRepository.save(new Project(project.getId(), project.getName(), project.getWebUrl()));
        /*
        _project.setId(project.getId());
        _project.setName(project.getName());
        _project.setWebUrl(project.getWebUrl());
        _project.setCommits(project.getCommits());
        _project.setIssues(project.getIssues());

         */
        //projectRepository.save(_project);
        return _project;
    }

    // PUT http://localhost:8080/api/projects/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Project updatedProject, @PathVariable long id) {
        Optional<Project> projectData = projectRepository.findById(id);

        Project _project = projectData.get();
        _project.setName(updatedProject.getName());
        _project.setWebUrl(updatedProject.getWebUrl());
        projectRepository.save(_project);
    }

    // DELETE https://localhost:8080/api/projects/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        }
    }
}
