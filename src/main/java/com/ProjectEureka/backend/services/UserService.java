package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.models.User;
import java.util.List;

public interface UserService {
    User createUser(User user);

    User updateUser(String id, User user);

    List<User> getAllUsers();

    User getUserById(String id);

    User deleteUser(String id);
}
