package com.ProjectEureka.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

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
