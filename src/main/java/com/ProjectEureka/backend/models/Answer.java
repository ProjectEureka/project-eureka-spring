package com.ProjectEureka.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "Answers")
public class Answer {
    @Id
    private String id;
    private List<String> media_urls;
    private String answer_date;
    private String description;
    private Long question_id;
    private Long user_id;

}