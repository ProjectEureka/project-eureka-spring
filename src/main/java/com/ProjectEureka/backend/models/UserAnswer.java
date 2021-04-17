package com.ProjectEureka.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAnswer {
    User user;
    Answer answer;
}
