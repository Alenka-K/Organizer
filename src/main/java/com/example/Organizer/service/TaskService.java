package com.example.Organizer.service;

import com.example.Organizer.entity.Task;

import java.util.List;

public interface TaskService {

    void saveTask(Task task);
    void deleteTask(int id);
    List<Task> getAllTasks();
}
