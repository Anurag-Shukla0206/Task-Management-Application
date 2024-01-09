package com.anurag.TaskManagementApplication.Service;

import com.anurag.TaskManagementApplication.Model.Task;
import com.anurag.TaskManagementApplication.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    @Autowired
    TaskRepository taskRepository;

    public ResponseEntity<String> createTask(Task task){
        taskRepository.save(task);
        return new ResponseEntity<>("Successfully created task", HttpStatus.CREATED);
    }

    public List<Task> allTasks(){
        return taskRepository.findAll();
    }

    public ResponseEntity<String> deleteTask(int id){
        if(!taskRepository.findById(id).isPresent()){
            return new ResponseEntity<>("Task not found",HttpStatus.NOT_FOUND);
        }

        taskRepository.deleteById(id);
        return new ResponseEntity<>("Deleted succesfully",HttpStatus.ACCEPTED);
    }



    public ResponseEntity<String> updateTask(int id,Task task){
        if(!taskRepository.findById(id).isPresent()){
            return new ResponseEntity<>("task record does not exist",HttpStatus.NOT_FOUND);
        }

        Task taskDetails = taskRepository.findById(id).get();
        if(task.getEmail()!=null){
            taskDetails.setEmail(task.getEmail());
        }
        if(task.getFirstName()!=null){
            taskDetails.setFirstName(task.getFirstName());
        }
        if(task.getLastName()!=null){
            taskDetails.setLastName(task.getLastName());
        }
        if(task.getPhoneNumber()!=null){
            taskDetails.setPhoneNumber(task.getPhoneNumber());
        }
        if(task.getTaskDesc()!=null){
            taskDetails.setTaskDesc(task.getTaskDesc());
        }
        if(task.getTaskTitle()!=null){
            taskDetails.setTaskTitle(task.getTaskTitle());
        }


        taskRepository.save(taskDetails);

        return new ResponseEntity<>("successfully updated the task details",HttpStatus.CREATED);
    }


    public Optional<Task> getTaskById(int id) {

        Optional<Task> task = taskRepository.findById(id);
        if(task!=null){

            return task;
        }
        return null;
    }
}
