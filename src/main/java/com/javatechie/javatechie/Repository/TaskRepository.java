package com.javatechie.javatechie.Repository;

import com.javatechie.javatechie.Model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBysecurity();

    //@Query({assignee: ?0 })
    //public List<Task> getTaskByassignee   { }
}
