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
  private TaskRepository taskrepository;

  public Task findById(Long id) {
    return taskrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado!"));
  }

  public List<Task> findAll() {
    Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());

    return taskrepository.findAll(sort);
  }

  public Task insert(Task task) {
    if (task.getId() != null && taskrepository.existsById(task.getId())) {
      throw new ResourceAlreadyExistsException("Objeto já existe!");
    }
    return taskrepository.save(task);

  }

  public void update(Task task) {
    Task taskToUpdate = findById(task.getId());
    updateData(taskToUpdate, task);
    taskrepository.save(taskToUpdate);

  }

  private void updateData(Task taskToUpdate, Task task) {
    taskToUpdate.setName(task.getName());
    taskToUpdate.setDescription(task.getDescription());
    taskToUpdate.setStatus(task.getStatus());
    taskToUpdate.setPriority(task.getPriority());
  }

  public void delete(Long id) {
    findById(id);
    taskrepository.deleteById(id);
  }

}
