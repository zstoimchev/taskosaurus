package dev.personal.planner.dto;

import dev.personal.planner.models.enums.Priority;
import dev.personal.planner.models.Project;
import dev.personal.planner.models.enums.Status;
import lombok.Data;

import java.time.Instant;

@Data
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private Status status;
    private Priority priority;
    private Instant createdAt;
    private Instant deadline;
    private Instant completedAt;
    private String file;
    private Project project;
}
