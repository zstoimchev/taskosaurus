package dev.personal.planner.dto;

import lombok.Data;

import java.util.List;

@Data
public class TaskResponse {
    private List<TaskDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
