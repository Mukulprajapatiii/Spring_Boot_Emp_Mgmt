package com.javatechie.javatechie.Controller;

import com.javatechie.javatechie.Model.Task;
import com.javatechie.javatechie.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    //Create call here
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    //Read call here
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    //Read call from here...getting single task by Id
    @GetMapping("/id/{taskId}")
    public Task getTasks(@PathVariable String taskId) {
        return taskService.getTaskById(taskId);
    }

    //Read call from here...getting single task by security
    @GetMapping("/security/{security}")
    public List<Task> findTaskBySecurity(@PathVariable int security) {
        return taskService.getTaskBySecurity(security);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/id/{taskId}")
    public String deleteTask(@PathVariable String taskId) {
        return taskService.deleteTask(taskId);
    }


}
