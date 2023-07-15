package com.fgn.todolist.model.entities;

import com.fgn.todolist.model.entities.enums.PriorityEnum;
import com.fgn.todolist.model.entities.enums.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;

  private Integer status;
  private Integer priority;

  public Task() {
  }

  public Task(String name, String description, StatusEnum status, PriorityEnum priority) {
    this.name = name;
    this.description = description;
    setStatus(status);
    setPriority(priority);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public StatusEnum getStatus() {
    return StatusEnum.valueOf(status);
  }

  public void setStatus(StatusEnum status) {
    if (status != null) {
      this.status = status.getCode();
    }
  }

  public PriorityEnum getPriority() {
    return PriorityEnum.valueOf(priority);
  }

  public void setPriority(PriorityEnum priority) {
    if (priority != null) {
      this.priority = priority.getCode();
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Task other = (Task) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}