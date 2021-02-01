package com.ProjectEureka.backend.models;

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
    private String category;
    @Field("picture_url")
    private String pictureUrl;
    private boolean role;
    private int rating;

    public User(String firstName, String lastName, String firebaseUuid, String email, String city, String category,
            String pictureUrl, Boolean role, Integer rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.firebaseUuid = firebaseUuid;
        this.email = email;
        this.city = city;
        this.category = category;
        this.pictureUrl = pictureUrl;
        this.role = role;
        this.rating = rating;
    }
}
