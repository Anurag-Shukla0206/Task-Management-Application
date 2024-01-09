package com.anurag.TaskManagementApplication.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int taskId;

    public String firstName;

    public String lastName;

    public String taskTitle;

    public String taskDesc;

    @Length(min = 10,max = 10,message = "Please enter correct")
    public String phoneNumber;

    @Email(message = "please enter correct email")
    public String email;


}
