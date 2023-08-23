package com.fgn.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fgn.todolist.model.entities.Task;
import com.fgn.todolist.repositories.TaskRepository;
import com.fgn.todolist.service.exception.ResourceAlreadyExistsException;
import com.fgn.todolist.service.exception.ResourceNotFoundException;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  public Task findById(Long id) {
    return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found!"));
  }

  public List<Task> findAll() {
    Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());

    return taskRepository.findAll(sort);
  }

  public Task insert(Task task) {
    if (task.getId() != null && taskRepository.existsById(task.getId())) {
      throw new ResourceAlreadyExistsException("Object already exists!");
    }
    return taskRepository.save(task);

  }

  public void update(Task task) {
    Task taskToUpdate = findById(task.getId());
    updateData(taskToUpdate, task);
    taskRepository.save(taskToUpdate);

  }

  private void updateData(Task taskToUpdate, Task task) {
    taskToUpdate.setName(task.getName());
    taskToUpdate.setDescription(task.getDescription());
    taskToUpdate.setStatus(task.getStatus());
    taskToUpdate.setPriority(task.getPriority());
  }

  public void delete(Long id) {
    findById(id);
    taskRepository.deleteById(id);
  }

}
