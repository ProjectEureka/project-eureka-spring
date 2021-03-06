package com.ProjectEureka.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
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
    private Date questionDate;

    private String description;

    private String category;

    @Field("media_urls")
    private List<String> mediaUrls;

    private Boolean closed;

    private Boolean visible;

    @Field("user_id")
    private String userId;

}
