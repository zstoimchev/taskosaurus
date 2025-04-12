package dev.personal.planner.services;

import dev.personal.planner.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAllProjects();
    ProjectDto createProject(ProjectDto projectDto);
    ProjectDto updateProject(Long projectId, ProjectDto projectDto);
    ProjectDto getProjectById(Long projectId);
    void deleteProject(Long projectId);
}
