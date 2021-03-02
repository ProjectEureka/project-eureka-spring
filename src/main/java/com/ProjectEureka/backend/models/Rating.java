package com.ProjectEureka.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Users")
@Data
public class Rating {
    @Id
    private String id;

    private int rating;

}
