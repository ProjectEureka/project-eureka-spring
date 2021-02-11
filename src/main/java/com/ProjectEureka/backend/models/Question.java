package com.ProjectEureka.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Questions")
public class Question {
    @Id
    private String id;

    private String title;

    @Field("question_date")
    private String questionDate;

    private String description;

    private String category;

    @Field("media_urls")
    private List<String> mediaUrls;

    @Field("status")
    private String status;

    private Boolean visible;

    @Field("user_id")
    private String userId;

    public Question(String title, String questionDate, String description, String category, String status,
            Boolean visible, String userId) {
        this.title = title;
        this.questionDate = questionDate;
        this.description = description;
        this.category = category;
        this.status = status;
        this.visible = visible;
        this.userId = userId;
    }
}