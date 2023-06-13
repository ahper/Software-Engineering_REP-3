package com.example.task8_dao_v2.DAO;

import com.example.task8_dao_v2.model.Task;

import java.util.List;

public interface TaskDAO {
    List<Task> getAllTasks();
    Task getTaskById(int id);
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(int id);
}
