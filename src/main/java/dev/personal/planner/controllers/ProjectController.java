package dev.personal.planner.controllers;

import dev.personal.planner.dto.ProjectDto;
import dev.personal.planner.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String getAllProjects() {
        return "Get all projects";
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {
        return new ResponseEntity<>(projectService.createProject(projectDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{projectId}")
    public String updateProject(@PathVariable Long projectId) {
        return "Update project with ID: " + projectId;
    }

    @GetMapping("/{projectId}")
    public String getProjectById(@PathVariable Long projectId) {
        return "Get project with ID: " + projectId;
    }

    @DeleteMapping("/delete/{projectId}")
    public String deleteProject(@PathVariable Long projectId) {
        return "Delete project with ID: " + projectId;
    }

}
