package com.javatechie.javatechie.Service;

import com.javatechie.javatechie.Model.Task;
import com.javatechie.javatechie.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;


@Component
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    //Create Read Update Delete

    //Create
    public Task saveTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    //Read
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    //ReadById
    public Task getTaskById(String taskId) {

        return taskRepository.findById(taskId).get();
    }

    //ReadBySecurity
    public List<Task> getTaskBySecurity(int security) {
        return taskRepository.findBysecurity();
    }

    //public List<Task> getTaskByassignee(String assignee){ }

    //Update
    public Task updateTask(Task taskToBeUpdated) {
        //first get the existing document, that needs to be updated
        //populate new value from request to existing object/entity

        Task existingTask = taskRepository.findById(taskToBeUpdated.getTaskId()).get();
        existingTask.setDescription(taskToBeUpdated.getDescription());
        existingTask.setAssignee(taskToBeUpdated.getAssignee());
        existingTask.setSecurity(taskToBeUpdated.getSecurity());
        existingTask.setStoryPoint(taskToBeUpdated.getStoryPoint());
        return taskRepository.save(existingTask);

    }

    //Delete
    public String deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
        return taskId + "deleted";
    }
}
