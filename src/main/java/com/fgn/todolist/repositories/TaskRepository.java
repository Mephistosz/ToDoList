package com.fgn.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fgn.todolist.model.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}