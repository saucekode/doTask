package com.app.dotask.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String email;
}
