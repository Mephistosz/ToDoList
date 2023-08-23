package com.fgn.todolist.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fgn.todolist.model.entities.Task;
import com.fgn.todolist.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping
  public ResponseEntity<List<Task>> findAll() {
    return ResponseEntity.ok().body(taskService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Task> findAll(@PathVariable Long id) {
    return ResponseEntity.ok().body(taskService.findById(id));
  }

  @PostMapping
  public ResponseEntity<Task> insert(@RequestBody @Valid Task task) {

    taskService.insert(task);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@RequestBody Task task, @PathVariable Long id) {
    task.setId(id);
    taskService.update(task);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    taskService.delete(id);

    return ResponseEntity.noContent().build();
  }

}
