package com.fgn.todolist.model.entities.enums;

public enum PriorityEnum {

  LOW(1),
  MEDIUM(2),
  HIGH(3);

  private int code;

  private PriorityEnum(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static PriorityEnum valueOf(Integer id) {
    for (PriorityEnum priorityEnum : PriorityEnum.values()) {
      if (id == priorityEnum.getCode()) {
        return priorityEnum;
      }
    }
    throw new IllegalArgumentException("Invalid OrderStatus code");
  }

}
