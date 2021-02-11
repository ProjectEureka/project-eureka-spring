package com.ProjectEureka.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Answers")
public class Answer {
    @Id
    private String id;

    @Field("media_urls")
    private List<String> mediaUrls;

    @Field("answer_date")
    private String answerDate;

    private String description;

    @Field("question_id")
    private String questionId;

    @Field("user_id")
    private String userId;

}