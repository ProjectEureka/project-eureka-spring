package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.models.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    User updateUser(String id, User user);

    List<User> getAllUsers();

    User getUserById(String id);

    void deleteById(String id);
}
