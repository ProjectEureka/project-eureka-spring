package com.ProjectEureka.backend.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Profile {
    // user info
    User user;
    // questions
    List<Question> questions;

    // answers
    List<Answer> answers;
}
