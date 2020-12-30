package com.app.dotask.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateTodoDto {
    private String task;
    private String todoStatus;
}
