package com.ProjectEureka.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MoreDetail {
    User user;

    Question question;

    List<List<Object>> userAnswer;
}
