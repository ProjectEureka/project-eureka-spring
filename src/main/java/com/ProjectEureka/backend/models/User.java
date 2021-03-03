package com.ProjectEureka.backend.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "Users")
@Data
public class User {
    @Id
    private String id;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("firebase_uuid")
    private String firebaseUuid;

    private String email;

    private String city;

    private List<String> category;

    @Field("picture_url")
    private String pictureUrl;

    private int role;

    private int rating;
}
