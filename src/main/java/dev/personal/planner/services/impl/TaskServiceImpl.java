//package dev.personal.planner.services.impl;
//
//import dev.personal.planner.dto.TaskDto;
//import dev.personal.planner.dto.TaskResponse;
//import dev.personal.planner.exceptions.TaskNotFoundException;
//import dev.personal.planner.models.Task;
//import dev.personal.planner.repository.TaskRepository;
//import dev.personal.planner.services.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class TaskServiceImpl implements TaskService {
//    private final TaskRepository taskRepository;
//
//    @Autowired
//    public TaskServiceImpl(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }
//
//    @Override
//    public TaskDto createTask(TaskDto taskDto) {
//        Task task = new Task();
//        task.setTitle(taskDto.getTitle());
//        task.setDescription(taskDto.getDescription());
//        Task newTask = taskRepository.save(task);
//
//        TaskDto taskResponse = new TaskDto();
//        taskResponse.setId(newTask.getId());
//        taskResponse.setTitle(newTask.getTitle());
//        taskResponse.setDescription(newTask.getDescription());
//        return taskResponse;
//    }
//
//    @Override
//    public TaskResponse getAllTasks(int pageNo, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNo, pageSize);
//        Page<Task> tasks = taskRepository.findAll(pageable);
//        List<Task> listOfTasks = tasks.getContent();
//        List<TaskDto> content = listOfTasks.stream().map(t -> mapToDtp(t)).collect(Collectors.toList());
//
//        TaskResponse taskResponse = new TaskResponse();
//        taskResponse.setContent(content);
//        taskResponse.setPageNo(tasks.getNumber());
//        taskResponse.setPageSize(tasks.getSize());
//        taskResponse.setTotalElements(tasks.getTotalElements());
//        taskResponse.setTotalPages(tasks.getTotalPages());
//        taskResponse.setLast(tasks.isLast());
//
//        return taskResponse;
//    }
//
//    @Override
//    public TaskDto getTaskById(int id) {
//        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found!"));
//        return mapToDtp(task);
//    }
//
//    @Override
//    public TaskDto updateTask(TaskDto taskDto, int id) {
//        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not updated!"));
//        task.setTitle(taskDto.getTitle());
//        task.setDescription(taskDto.getDescription());
//
//        Task updatedTask = taskRepository.save(task);
//        return mapToDtp(updatedTask);
//    }
//
//    @Override
//    public void deleteTaskById(int id) {
//        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not deleted!"));
//        taskRepository.delete(task);
//    }
//
//    private TaskDto mapToDtp(Task task) {
//        TaskDto taskDto = new TaskDto();
//        taskDto.setId(task.getId());
//        taskDto.setTitle(task.getTitle());
//        taskDto.setDescription(task.getDescription());
//        return taskDto;
//    }
//
//    private Task mapToEntity(TaskDto taskDto) {
//        Task task = new Task();
//        task.setId(taskDto.getId());
//        task.setTitle(taskDto.getTitle());
//        task.setDescription(taskDto.getDescription());
//        return task;
//    }
//}
