//package dev.personal.planner.controllers;
//
//import dev.personal.planner.dto.TaskDto;
//import dev.personal.planner.dto.TaskResponse;
//import dev.personal.planner.models.Task;
//import dev.personal.planner.services.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/")
//public class TaskController {
//
//    private final TaskService taskService;
//
//    @Autowired
//    public TaskController(TaskService taskService) {
//        this.taskService = taskService;
//    }
//
//    @GetMapping("tasks")
//    public ResponseEntity<TaskResponse> getTasks(
//            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
//            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
//        return new ResponseEntity<>(taskService.getAllTasks(pageNo, pageSize), HttpStatus.OK);
//    }
//
//    @GetMapping("tasks/{id}")
//    public ResponseEntity<TaskDto> taskDetails(@PathVariable int id) {
//        return ResponseEntity.ok(taskService.getTaskById(id));
//    }
//
//    @PostMapping("tasks/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
//        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
//    }
//
//    @PutMapping("tasks/{id}/update")
//    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto, @PathVariable("id") int id) {
//        TaskDto response = taskService.updateTask(taskDto, id);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @DeleteMapping("tasks/{id}/delete")
//    public ResponseEntity<String> deleteTask(@PathVariable("id") int id) {
//        taskService.deleteTaskById(id);
//        return new ResponseEntity<>("Task deleted!", HttpStatus.OK);
//    }
//}
