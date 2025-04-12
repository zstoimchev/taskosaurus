package dev.personal.planner.mappers;

import dev.personal.planner.dto.ProjectDto;
import dev.personal.planner.models.Project;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProjectMapper {
    Project toEntity(ProjectDto dto);
    ProjectDto toDto(Project entity);
}
