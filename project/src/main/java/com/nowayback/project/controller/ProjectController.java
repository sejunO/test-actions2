package com.nowayback.project.controller;

import com.nowayback.project.entity.Project;
import com.nowayback.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(
            @RequestParam String name,
            @RequestParam String description
    ) {
        Project createdProject = projectService.createProject(name, description);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(
            @PathVariable("id") Long id
    ) {
        Project project = projectService.getProject(id);
        return ResponseEntity.ok(project);
    }
}
