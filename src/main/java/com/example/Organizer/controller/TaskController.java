package com.example.Organizer.controller;

import com.example.Organizer.entity.Task;
import com.example.Organizer.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getAllTasks(Model model) {
        List<Task> list = taskService.getAllTasks();
        System.out.println(list);
        model.addAttribute("taskList", list);
        model.addAttribute("taskSize", list.size());
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam("priorityId") int priorityId,
                          @RequestParam("description") String description,
                          @RequestParam("dateTask") String dateTask) {
        Task task = new Task();
        task.setPriorityId(priorityId);
        task.setDescription(description);
        LocalDate date = LocalDate.parse(dateTask, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        task.setDateTask(date);
        taskService.saveTask(task);
        return "redirect:/";
    }

}
