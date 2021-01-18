package com.ProjectEureka.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ProjectEureka.backend.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByFirstName(String firstName);

    public User findByLastName(String lastName);

    public User findByFirebaseUuid(String firebaseUuid);

    public User findByEmail(String email);

    public User findByCity(String city);

    public User findByCategory(String category);

    public User findByPictureUrl(String pictureUrl);

    public User findByRole(Boolean role);

    public User findByRating(Integer rating);
}
