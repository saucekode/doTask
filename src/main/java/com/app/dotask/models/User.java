package com.app.dotask.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
