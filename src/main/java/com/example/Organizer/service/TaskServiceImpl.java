package com.example.Organizer.service;

import com.example.Organizer.entity.Task;
import com.example.Organizer.repository.TaskRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll(Sort.by(
                Sort.Order.desc("priorityId")));
    }
}
