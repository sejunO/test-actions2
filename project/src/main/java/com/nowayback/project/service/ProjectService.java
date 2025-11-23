package com.nowayback.project.service;

import com.nowayback.project.entity.Project;
import com.nowayback.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Project createProject(String name, String description) {
        Project project = Project.create(name, description);
        return projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public Project getProject(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project with id " + id + " not found"));
    }
}
