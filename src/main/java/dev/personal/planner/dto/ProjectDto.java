package dev.personal.planner.dto;

import dev.personal.planner.models.enums.Priority;
import dev.personal.planner.models.enums.Status;
import dev.personal.planner.models.Task;
import dev.personal.planner.models.User;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectDto {
    private Long id;
    private String name;
    private String category;
    private String description;
    private Instant createdAt = Instant.now();
    private Instant updatedAt;
    private Instant deadline;
    private Instant endedAt;
    private Status status;
    private Priority priority;
    private double progress = 0.0;
    private User owner;
    private List<Task> tasks = new ArrayList<>();
}
