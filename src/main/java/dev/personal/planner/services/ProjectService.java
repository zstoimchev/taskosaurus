package dev.personal.planner.services;

import dev.personal.planner.dto.ProjectDto;

public interface Project {
    Project getProject();
    ProjectDto createProject(ProjectDto projectDto, Long projectId);
    ProjectDto updateProject(Long projectId, ProjectDto projectDto);
    ProjectDto getProjectById(Long projectId);
    void deleteProject(Long projectId);
}
