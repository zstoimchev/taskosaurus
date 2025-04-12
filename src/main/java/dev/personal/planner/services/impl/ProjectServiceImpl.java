package dev.personal.planner.services.impl;

import dev.personal.planner.dto.ProjectDto;
import dev.personal.planner.mappers.ProjectMapper;
import dev.personal.planner.models.Project;
import dev.personal.planner.repository.ProjectRepository;
import dev.personal.planner.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return List.of();
    }


    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        Project newProject = projectRepository.save(project);
        return projectMapper.toDto(newProject);
    }

    @Override
    public ProjectDto updateProject(Long projectId, ProjectDto projectDto) {
        return null;
    }

    @Override
    public ProjectDto getProjectById(Long projectId) {
        return null;
    }

    @Override
    public void deleteProject(Long projectId) {

    }


}
