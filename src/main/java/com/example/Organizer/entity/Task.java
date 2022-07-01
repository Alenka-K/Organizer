package com.example.Organizer.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private Integer priorityId;


    private String description;


    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateTask;


    public Task() {

    }

    public Task(Integer id, Integer priorityId, String description, Date dateTask) {
        this.id = id;
        this.priorityId = priorityId;
        this.description = description;
        this.dateTask = dateTask;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateTask() {
        return dateTask;
    }

    public void setDate(Date dateTask) {
        this.dateTask = dateTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (priorityId != task.priorityId) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        return dateTask != null ? dateTask.equals(task.dateTask) : task.dateTask == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + priorityId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateTask != null ? dateTask.hashCode() : 0);
        return result;
    }
}
