package com.fgn.todolist.model.entities.enums;

public enum StatusEnum {

  BACKLOG(1),
  TO_DO(2),
  IN_PROGRESS(3),
  FINISHED(4);

  private int code;

  private StatusEnum(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static StatusEnum valueOf(Integer id) {
    for (StatusEnum enums : StatusEnum.values()) {
      if (id == enums.getCode()) {
        return enums;
      }
    }
    throw new IllegalArgumentException("Invalid OrderStatus code");

  }

}
