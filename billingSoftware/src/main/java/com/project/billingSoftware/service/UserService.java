package com.project.billingSoftware.service;

import java.util.List;

import com.project.billingSoftware.io.UserRequest;
import com.project.billingSoftware.io.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
    String getUserRole(String email);
    List<UserResponse> readUsers();
    void deleteUser(String id);
}
