package com.anurag.TaskManagementApplication.Controller;

import com.anurag.TaskManagementApplication.Model.Task;
import com.anurag.TaskManagementApplication.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
@Validated
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getTaskById")
    public Optional<Task> getTaskById(@RequestParam int id){
        return taskService.getTaskById(id);
    }

    @PostMapping("/createTask")
    public ResponseEntity<String> createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping("/allTasks")
    public List<Task> allTasks(){
        return taskService.allTasks();
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<String> updatetask(@PathVariable int id,@RequestBody Task task){
        return taskService.updateTask(id,task);
    }


    @DeleteMapping("/task/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id){
        return taskService.deleteTask(id);
    }

}
