package com.example.Organizer.controller;

import com.example.Organizer.entity.Task;
import com.example.Organizer.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<Task> taskList = taskService.getAllTasks();
        model.addAttribute("taskList", taskList);
        model.addAttribute("taskSize", taskList.size());
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }
}
