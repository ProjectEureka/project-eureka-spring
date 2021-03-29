package com.ProjectEureka.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Rating {
    @Id
    private String id;

    private double rating;

}
