package com.fgn.todolist.model.entities;

import com.fgn.todolist.model.entities.enums.PriorityEnum;
import com.fgn.todolist.model.entities.enums.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @NotBlank(message = "The value can't be blank")
  private String name;
  @NotBlank(message = "The value can't be blank")
  private String description;

  private Integer status;
  private Integer priority;

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

}